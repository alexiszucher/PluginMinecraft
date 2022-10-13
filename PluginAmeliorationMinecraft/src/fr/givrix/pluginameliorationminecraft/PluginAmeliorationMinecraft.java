package fr.givrix.pluginameliorationminecraft;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.RenderType;
import org.bukkit.scoreboard.Scoreboard;

import fr.givrix.pluginameliorationminecraft.commands.CommandFollow;
import fr.givrix.pluginameliorationminecraft.commands.CommandHome;
import fr.givrix.pluginameliorationminecraft.commands.CommandInventory;
import fr.givrix.pluginameliorationminecraft.commands.CommandPosition;
import fr.givrix.pluginameliorationminecraft.commands.CommandUhc;
import fr.givrix.pluginameliorationminecraft.events.ListenerFollow;
import fr.givrix.pluginameliorationminecraft.events.ListenerStart;
import fr.givrix.pluginameliorationminecraft.events.ListenerUhc;

public class PluginAmeliorationMinecraft extends JavaPlugin {
	
	private static PluginAmeliorationMinecraft plugin;
	
	private static Scoreboard mainScoreboard;

	private static Inventory sharedInventory = Bukkit.createInventory(null, InventoryType.CHEST, "Inventaire commun");
	
	File file = new File(this.getDataFolder(), "sharedInventory.yml");
	YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
	
	@Override
	public void onEnable() {
		
		System.out.println("Ouverture du serveur de Givrix");
		
		plugin = this;
		
		for(int i = 0; i < sharedInventory.getContents().length; i++){
			if (configuration.getItemStack(Integer.toString(i)) != null) sharedInventory.addItem(configuration.getItemStack(Integer.toString(i)));
		}
		
		Scoreboard mainScoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
		
		// On affiche la vie des joueurs dans le tab
		if (mainScoreboard.getObjective("vieDesJoueurs") == null) {
			mainScoreboard.registerNewObjective("vieDesJoueurs", "health", "Vie", RenderType.HEARTS);
			mainScoreboard.getObjective("vieDesJoueurs").setDisplaySlot(DisplaySlot.PLAYER_LIST);
		}
		
		// On fait en sorte que la nuit passe si la majorité des joueurs dorment
		Bukkit.getWorlds().get(0).setGameRule(GameRule.PLAYERS_SLEEPING_PERCENTAGE, 49);
		
		// On implémente nos commandes
		getCommand("position").setExecutor(new CommandPosition());
		getCommand("follow").setExecutor(new CommandFollow());
		getCommand("uhc").setExecutor(new CommandUhc());
		getCommand("inventory").setExecutor(new CommandInventory());
		getCommand("home").setExecutor(new CommandHome());
		
		// On implémente nos events
		Bukkit.getPluginManager().registerEvents(new ListenerFollow(), this);
		Bukkit.getPluginManager().registerEvents(new ListenerStart(), this);
		Bukkit.getPluginManager().registerEvents(new ListenerUhc(), this);
	}
	
	@Override
	public void onDisable() {
		
		for(int i = 0; i < sharedInventory.getContents().length; i++) {
			if (sharedInventory.getContents()[i] != null) {
				configuration.set(Integer.toString(i), sharedInventory.getContents()[i]);
			} else {
				configuration.set(Integer.toString(i), null);
			}
		}
		
		try {
			configuration.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Fermeture du serveur de Givrix");
	}
	
	public static PluginAmeliorationMinecraft getPlugin() {
		return plugin;
	}
	
	public static Scoreboard getMainPluginScoreboard() {
		return mainScoreboard;
	}
	
	public static Inventory getSharedInventory() {
		return sharedInventory;
	}

}