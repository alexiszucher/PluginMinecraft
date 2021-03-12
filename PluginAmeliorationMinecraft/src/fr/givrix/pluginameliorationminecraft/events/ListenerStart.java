package fr.givrix.pluginameliorationminecraft.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ListenerStart implements Listener {
	
	@EventHandler
	public void onInteract(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		
		// Affiche un message de bienvenue
		player.sendMessage("§eBienvenue " + player.getName() + " !");
		player.sendMessage("§7Le nombre de joueurs connectés est : §a" + Bukkit.getOnlinePlayers().size());		
	}

}