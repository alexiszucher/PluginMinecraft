package fr.sasuno.pluginrpgminecraft;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import fr.sasuno.pluginrpgminecraft.events.ListenerActif;
import fr.sasuno.pluginrpgminecraft.events.ListenerArrow;
import fr.sasuno.pluginrpgminecraft.events.ListenerInvisible;
import fr.sasuno.pluginrpgminecraft.events.ListenerMenu;
import fr.sasuno.pluginrpgminecraft.events.ListenerStart;

public class PluginRpgMinecraft extends JavaPlugin {
	
	private static PluginRpgMinecraft plugin;
	
	@Override
	public void onEnable() {
		System.out.println("Le Plugin Zucher s'est allumé");
		
		plugin = this;
		
		// On passe le monde en uhc
		World world = Bukkit.getWorld("world");
		
		world.setDifficulty(Difficulty.HARD);
		world.setGameRule(GameRule.NATURAL_REGENERATION, true);
		world.setHardcore(true);
		
		// On implémente nos events
		Bukkit.getPluginManager().registerEvents(new ListenerStart(), this);
		Bukkit.getPluginManager().registerEvents(new ListenerMenu(), this);
		Bukkit.getPluginManager().registerEvents(new ListenerActif(), this);
		Bukkit.getPluginManager().registerEvents(new ListenerInvisible(), this);
		Bukkit.getPluginManager().registerEvents(new ListenerArrow(), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("Le Plugin Zucher vient de s'éteindre");
	}
	
	public static PluginRpgMinecraft getPlugin() {
		return plugin;
	}
	
}