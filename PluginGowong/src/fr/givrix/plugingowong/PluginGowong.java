package fr.givrix.plugingowong;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import fr.givrix.plugingowong.commands.CommandAllResurrection;
import fr.givrix.plugingowong.events.ListenerDeath;
import fr.givrix.plugingowong.events.ListenerStart;
import fr.givrix.plugingowong.scoreboard.StatsScoreboard;

public class PluginGowong extends JavaPlugin {
	
	private static PluginGowong plugin;
	
	private static boolean allResurrection;
	
	@Override
	public void onEnable() {
		
		plugin = this;
		
		allResurrection = false;
		
		// On implémente la règle du keep inventory
		for (World world : Bukkit.getWorlds()) {
			world.setGameRule(GameRule.KEEP_INVENTORY, true);
		}
		
		// On affiche le classement des joueurs par stat dans le scoreboard
		StatsScoreboard statsScoreboard = new StatsScoreboard();
		statsScoreboard.displayTopTimePassedOnServer();
		
		// On implémente nos commandes
		getCommand("allResurrection").setExecutor(new CommandAllResurrection());
		
		// On implémente nos events
		Bukkit.getPluginManager().registerEvents(new ListenerStart(), this);
		Bukkit.getPluginManager().registerEvents(new ListenerDeath(), this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static PluginGowong getPlugin() {
		return plugin;
	}
	
	public static boolean getAllResurrection() {
		return allResurrection;
	}

	public static void setAllResurrection(boolean bool) {
		allResurrection = bool;
	}

}
