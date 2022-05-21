package fr.givrix.pluginlobby.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ListenerStart implements Listener {
	
	@EventHandler
	public void onInteract(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		
		player.teleport(player.getWorld().getSpawnLocation());
	}

}
