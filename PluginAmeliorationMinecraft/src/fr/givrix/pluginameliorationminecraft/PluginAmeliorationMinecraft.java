package fr.givrix.pluginameliorationminecraft;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.RenderType;
import org.bukkit.scoreboard.Scoreboard;

import fr.givrix.pluginameliorationminecraft.commands.CommandFollow;
import fr.givrix.pluginameliorationminecraft.commands.CommandPos;
import fr.givrix.pluginameliorationminecraft.commands.CommandUhc;
import fr.givrix.pluginameliorationminecraft.events.ListenerFollow;

public class PluginAmeliorationMinecraft extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("on !");
		
		Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
		
		if (scoreboard.getObjective("vieDesJoueurs") == null) {
			scoreboard.registerNewObjective("vieDesJoueurs", "health", "Vie", RenderType.HEARTS);
			scoreboard.getObjective("vieDesJoueurs").setDisplaySlot(DisplaySlot.PLAYER_LIST);
		}
		
		getCommand("pos").setExecutor(new CommandPos());
		getCommand("follow").setExecutor(new CommandFollow());
		getCommand("uhc").setExecutor(new CommandUhc());
		
		Bukkit.getPluginManager().registerEvents(new ListenerFollow(), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("off !");
	}

}