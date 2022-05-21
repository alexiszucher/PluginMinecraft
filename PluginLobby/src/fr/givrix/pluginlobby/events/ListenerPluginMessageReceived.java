package fr.givrix.pluginlobby.events;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import fr.givrix.pluginlobby.helpers.PluginMessageHelper;

public class ListenerPluginMessageReceived implements PluginMessageListener {

	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] bytes) {
		
		if (!channel.equalsIgnoreCase("BungeeCord")) return;
		PluginMessageHelper.receivePluginMessage(channel, bytes);
	}

}
