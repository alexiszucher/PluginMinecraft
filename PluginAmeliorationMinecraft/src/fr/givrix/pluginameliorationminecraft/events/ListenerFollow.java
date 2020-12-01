package fr.givrix.pluginameliorationminecraft.events;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ListenerFollow implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack item = event.getItem();
		
		// On v�rifie que l'item existe et que ce ne soit pas un item basique
		if (item == null || !item.hasItemMeta()) return;
		
		// On v�rifie si l'item est le PlayerTracker
		if (item.getType() == Material.COMPASS && (action == Action.RIGHT_CLICK_AIR || action ==  Action.RIGHT_CLICK_BLOCK) && item.getItemMeta().getLore().equals(Arrays.asList("Permet de suivre un joueur pr�cis", "�c" + item.getItemMeta().getLocalizedName() + " �5est la cible actuelle"))) {
			// On r�cup�re la position de la cible
			Player target = Bukkit.getPlayerExact(item.getItemMeta().getLocalizedName());
			Location targetLocation = target.getLocation();
			World targetWorld = target.getWorld();
			
			switch (targetWorld.getEnvironment()) {
			case NORMAL:
				// On met � jour la position de la cible
				player.setCompassTarget(targetLocation);
				player.sendMessage("La position de votre cible a �t� mise � jour");
				break;
				
			case NETHER:
				player.sendMessage("Le Player Tracker ne marche pas dans le Nether");
				break;

			case THE_END:
				player.sendMessage("Le Player Tracker ne marche pas dans l'Ender");
				break;
			}
			
		}
		
	}

}
