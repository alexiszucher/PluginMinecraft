package fr.givrix.pluginlobby.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

public class ListenerPortals implements Listener {

	@EventHandler
	public void onPlayerPassPortal(PlayerPortalEvent event) {
		event.setCancelled(true);
	}
}
