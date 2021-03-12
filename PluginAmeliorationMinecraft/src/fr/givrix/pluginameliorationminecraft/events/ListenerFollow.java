package fr.givrix.pluginameliorationminecraft.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import fr.givrix.pluginameliorationminecraft.PluginAmeliorationMinecraft;

public class ListenerFollow implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack item = event.getItem();
		
		// On v�rifie que l'item existe et que ce ne soit pas un item basique
		if (item == null || !item.hasItemMeta()) return;
		
		// On v�rifie si l'item est le PlayerTracker
		if (item.getType() == Material.COMPASS && (action == Action.RIGHT_CLICK_AIR || action ==  Action.RIGHT_CLICK_BLOCK) && item.getItemMeta().getLocalizedName().equals("playerTracker")) {
			
			CompassMeta playerTrackerMeta = (CompassMeta) item.getItemMeta();
			PersistentDataContainer data = playerTrackerMeta.getPersistentDataContainer();
			NamespacedKey key = new NamespacedKey(PluginAmeliorationMinecraft.getPlugin(), "target");
			Player target = Bukkit.getPlayerExact(data.get(key, PersistentDataType.STRING));
			
			// On v�rifie que la cible est connect�e
			if (target == null) {
				player.sendMessage("Le joueur " + data.get(key, PersistentDataType.STRING) + " n'est pas connect�");
				return;
			}
			
			// On r�cup�re la position de la cible
			Location targetLocation = target.getLocation();
			World.Environment targetEnvironment = target.getWorld().getEnvironment();
			
			// On pr�pare le message d'o� est la cible
			String environment = null;
			switch (targetEnvironment) {
			case NORMAL:
				environment = "l'Overworld";
				break;
				
			case NETHER:
				environment = "le Nether";
				break;

			case THE_END:
				environment = "l'Ender";
				break;
			}
			
			// On met � jour la position de la cible
			playerTrackerMeta.setLodestone(targetLocation);
			item.setItemMeta(playerTrackerMeta);
			if (player.getWorld().getEnvironment() == targetEnvironment) {
				player.sendMessage("La position de votre cible a �t� mise � jour");
				
			} else {
				player.sendMessage("�cVotre cible se trouve dans " + environment);
			}
			
		}
		
		return;
	}

}