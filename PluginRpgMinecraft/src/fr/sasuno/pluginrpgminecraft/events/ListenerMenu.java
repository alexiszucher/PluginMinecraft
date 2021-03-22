package fr.sasuno.pluginrpgminecraft.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.sasuno.pluginrpgminecraft.classes.Classe;

public class ListenerMenu implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack item = event.getItem();
		
		// On vérifie que l'item existe et que ce ne soit pas un item basique
		if (item == null || !item.hasItemMeta()) return;
		
		// On vérifie si l'item est le MenuClasse
		if (item.getType() == Material.EMERALD && (action == Action.RIGHT_CLICK_AIR || action ==  Action.RIGHT_CLICK_BLOCK) && item.getItemMeta().getLocalizedName().equalsIgnoreCase("menuClasse")) {
			Classe.getClasseObject(player).openMenu(player);
		}
		
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		
		if (item == null) return;

		ItemMeta itemMeta = item.getItemMeta();
		
		if (event.getView().getTitle().equalsIgnoreCase("Menu d'amélioration de classe")) {
			
			event.setCancelled(true);
			
			switch (itemMeta.getLocalizedName()) {
			case "weaponUp":
				if (Classe.hasLvlToUpdateWeapon(player)) {
					Classe.changeWeaponLvl(player, 1);
				} else {
					player.sendMessage("Vous n'avez pas le niveau nécessaire pour cela");
				}
				
				break;
				
			case "armorUp":
				if (Classe.hasLvlToUpdateArmor(player)) {
					Classe.changeArmorLvl(player, 1);
				} else {
					player.sendMessage("Vous n'avez pas le niveau nécessaire pour cela");
				}
				
				break;
				
			case "effectUp":
				if (Classe.hasLvlToUpdateEffect(player)) {
					Classe.changeEffectLvl(player, 1);
				} else {
					player.sendMessage("Vous n'avez pas le niveau nécessaire pour cela");
				}
				
				break;
				
			case "actifUp":
				if (Classe.hasLvlToUpdateActif(player)) {
					Classe.changeActifLvl(player, 1);
				} else {
					player.sendMessage("Vous n'avez pas le niveau nécessaire pour cela");
				}
				
				break;
				
			case "arrowUp":
				ItemStack arrows = new ItemStack(Material.ARROW);
				arrows.setAmount(64);
				player.getInventory().addItem(arrows);

			default:
			}
			
			player.closeInventory();
		}
	}

}