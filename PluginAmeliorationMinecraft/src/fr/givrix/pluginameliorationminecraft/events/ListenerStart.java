package fr.givrix.pluginameliorationminecraft.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ListenerStart implements Listener {
	
	@EventHandler
	public void onInteract(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		
		// Affiche un message de bienvenue
		player.sendMessage(ChatColor.YELLOW + "Bienvenue " + player.getName() + " !");
		player.sendMessage(ChatColor.GRAY + "Le nombre de joueurs connectés est : " + ChatColor.GREEN + Bukkit.getOnlinePlayers().size());
	}

}