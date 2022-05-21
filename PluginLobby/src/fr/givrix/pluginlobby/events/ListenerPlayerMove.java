package fr.givrix.pluginlobby.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import fr.givrix.pluginlobby.helpers.PluginMessageHelper;

public class ListenerPlayerMove implements Listener {
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		
		Location from = event.getFrom();
		Location to = event.getTo();
		
		if (from.getWorld().getBlockAt(from).getLocation().equals(to.getWorld().getBlockAt(to).getLocation())) return;
		
		Block blockTo = to.getWorld().getBlockAt(to);
		
		if (blockTo.getType().equals(Material.END_PORTAL)) {
			PluginMessageHelper.sendPluginMessage(event.getPlayer(), "Connect", new String[] {"Hardcore_gOwOng"});
		} else if (blockTo.getType().equals(Material.NETHER_PORTAL)) {
			PluginMessageHelper.sendPluginMessage(event.getPlayer(), "Connect", new String[] {"Skyblock"});
		}
		
	}

}
