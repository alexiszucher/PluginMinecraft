package fr.givrix.plugingowong;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import fr.givrix.plugingowong.events.ListenerDeath;
import fr.givrix.plugingowong.scoreboard.StatsScoreboard;

public class PluginGowong extends JavaPlugin {
	
	private static PluginGowong plugin;
	
	@Override
	public void onEnable() {
		
		plugin = this;
		
		// On implémente la règle du keep inventory
		for (World world : Bukkit.getWorlds()) {
			world.setGameRule(GameRule.KEEP_INVENTORY, false);
		}
		
		// On affiche le classement des joueurs par stat dans le scoreboard
		StatsScoreboard statsScoreboard = new StatsScoreboard();
		statsScoreboard.displayTopTimePassedOnServer();
		
		// On implémente nos commandes
		
		// On implémente nos events
		Bukkit.getPluginManager().registerEvents(new ListenerDeath(), this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static PluginGowong getPlugin() {
		return plugin;
	}

}
