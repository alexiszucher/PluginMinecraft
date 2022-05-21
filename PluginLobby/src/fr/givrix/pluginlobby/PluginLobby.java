package fr.givrix.pluginlobby;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import fr.givrix.pluginlobby.events.ListenerPlayerMove;
import fr.givrix.pluginlobby.events.ListenerPortals;
import fr.givrix.pluginlobby.events.ListenerStart;
import fr.givrix.pluginlobby.helpers.PluginMessageHelper;

public class PluginLobby extends JavaPlugin {
	
	private static PluginLobby plugin;

	@Override
	public void onEnable() {
		
		plugin = this;
		
		PluginMessageHelper.registerChannels(plugin);
		
		Bukkit.getPluginManager().registerEvents(new ListenerStart(), this);
		Bukkit.getPluginManager().registerEvents(new ListenerPortals(), this);
		Bukkit.getPluginManager().registerEvents(new ListenerPlayerMove(), this);
	}

	@Override
	public void onDisable() {
		
	}
	
	public static PluginLobby getPlugin() {
		return plugin;
	}
	
}
