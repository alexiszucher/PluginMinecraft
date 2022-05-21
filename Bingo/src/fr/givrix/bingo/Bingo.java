package fr.givrix.bingo;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import fr.givrix.bingo.commands.CommandStartBingo;
import fr.givrix.bingo.events.ListenerBingo;
import fr.givrix.bingo.events.ListenerStart;

public class Bingo extends JavaPlugin {
	
	private static Bingo plugin;
	
	@Override
	public void onEnable() {
		
		plugin = this;
		
		getCommand("startBingo").setExecutor(new CommandStartBingo());
		
		Bukkit.getPluginManager().registerEvents(new ListenerBingo(), this);
		Bukkit.getPluginManager().registerEvents(new ListenerStart(), this);
		
	}
	
	public static Bingo getPlugin() {
		return plugin;
	}
}