package fr.sasuno.pluginrpgminecraft.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import fr.sasuno.pluginrpgminecraft.classes.Classe;

public class ListenerActif implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack item = event.getItem();
		
		// On vérifie que l'item existe et que ce ne soit pas un item basique
		if (item == null || !item.hasItemMeta()) return;
		
		// On vérifie si l'item est le MenuClasse
		if (item.getType() == Material.FEATHER && (action == Action.RIGHT_CLICK_AIR || action ==  Action.RIGHT_CLICK_BLOCK) && item.getItemMeta().getLocalizedName().equalsIgnoreCase("actifClasse")) {
			Classe.getClasseObject(player).updateStuff(player);
			Classe.getClasseObject(player).runActivable(player);
		}
		
	}

}