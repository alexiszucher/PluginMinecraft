package fr.givrix.bingo.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class ListenerStart implements Listener {
	
	@EventHandler
	public void onInteract(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		player.sendMessage("Bienvenue dans ce bingo, au top départ, vous devrez trouver le plus d'item possible avant l'autre joueur. Bonne chance !");
		PlayerInventory inventory = player.getInventory();
		
		ItemStack grilleBingo = new ItemStack(Material.CHEST);
		ItemMeta grilleBingoMeta = grilleBingo.getItemMeta();
		grilleBingoMeta.setDisplayName("Grille Bingo");
		grilleBingoMeta.setLocalizedName("grilleBingo");
		grilleBingo.setItemMeta(grilleBingoMeta);
		
		if (!inventory.contains(grilleBingo) && !inventory.getItemInOffHand().equals(grilleBingo)) inventory.addItem(grilleBingo);
	}

}