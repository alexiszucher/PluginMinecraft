package fr.sasuno.pluginrpgminecraft;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import fr.sasuno.pluginrpgminecraft.events.ListenerStart;

public class PluginRpgMinecraft extends JavaPlugin {
	
	private static PluginRpgMinecraft plugin;
	
	@Override
	public void onEnable() {
		System.out.println("Le Plugin Zucher s'est allum�");
		
		plugin = this;
		
		// On impl�mente nos events
		Bukkit.getPluginManager().registerEvents(new ListenerStart(), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("Le Plugin Zucher vient de s'�teindre");
	}
	
	public static PluginRpgMinecraft getPlugin() {
		return plugin;
	}
	
}