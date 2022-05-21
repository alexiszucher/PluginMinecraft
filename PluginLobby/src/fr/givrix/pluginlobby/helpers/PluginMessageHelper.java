package fr.givrix.pluginlobby.helpers;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import fr.givrix.pluginlobby.PluginLobby;
import fr.givrix.pluginlobby.events.ListenerPluginMessageReceived;

public class PluginMessageHelper {

	private static final String BUNGEECORD_CHANNEL = "BungeeCord";
	
	private PluginMessageHelper() {}
	
	public static void registerChannels(Plugin plugin) {
		plugin.getServer().getMessenger().registerIncomingPluginChannel(plugin, BUNGEECORD_CHANNEL, new ListenerPluginMessageReceived());
		plugin.getServer().getMessenger().registerOutgoingPluginChannel(plugin, BUNGEECORD_CHANNEL);
	}
	
	public static void sendPluginMessage(Player player, String sub, String[] args) {
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		
		out.writeUTF(sub);
		
		for (String arg : args) {
			out.writeUTF(arg);
		}
		
		player.sendPluginMessage(PluginLobby.getPlugin(), BUNGEECORD_CHANNEL, out.toByteArray());
	}
	
	public static void receivePluginMessage(String channel, byte[] bytes) {
		if (!channel.equals(PluginMessageHelper.BUNGEECORD_CHANNEL)) return;
	}
}
