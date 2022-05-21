package fr.givrix.bingo.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.givrix.bingo.ItemsToFind;

public class ListenerBingo implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack item = event.getItem();
		
		if (item == null || !item.hasItemMeta()) return;
		
		if (item.getType() == Material.CHEST && (action == Action.RIGHT_CLICK_AIR || action ==  Action.RIGHT_CLICK_BLOCK) && item.getItemMeta().getLocalizedName().equalsIgnoreCase("grilleBingo")) {
			
			event.setCancelled(true);
			
			Inventory inventory = Bukkit.createInventory(player, InventoryType.DISPENSER, "Grille du bingo");
			
			for (ItemStack itemStack : ItemsToFind.getINSTANCE().getListOfItemsToFind()) {
				inventory.setItem(ItemsToFind.getINSTANCE().getListOfItemsToFind().indexOf(itemStack), itemStack);
			}
			
			player.openInventory(inventory);
		}
		
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		
		ItemStack item = event.getCurrentItem();
		
		if (item == null) return;
		
		if (event.getView().getTitle().equalsIgnoreCase("Grille du bingo")) event.setCancelled(true);
		
	}
	
	@EventHandler
	public void onEntityPickupItem(EntityPickupItemEvent event) {
		
		if (event.getEntity() instanceof Player) {
			
			ItemStack item = event.getItem().getItemStack();
			
			if (ItemsToFind.getINSTANCE().getListOfItemsToFind().contains(item)) {
				
				Player player = (Player) event.getEntity();
				
				ItemsToFind.getINSTANCE().removeItemFromListOfItemsToFind(item);
				Bukkit.broadcastMessage(ChatColor.BLUE + player.getName() + " a trouvé l'item " + ChatColor.GREEN + item.getType().name());
				// TODO add player point in scoreboard and check if itemslisttofind is empty
				
			}
		}
		
	}
	
}