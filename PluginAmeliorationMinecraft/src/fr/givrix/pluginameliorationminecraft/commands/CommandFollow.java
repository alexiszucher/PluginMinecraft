package fr.givrix.pluginameliorationminecraft.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandFollow implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player) sender;
			
			if (args.length == 1) {
				Player target = Bukkit.getPlayerExact(args[0]);
				
				// On vérifie que la cible existe
				if (target == null) {
					player.sendMessage("Le joueur " + args[0] + " n'existe pas ou n'est pas connecté");
					return true;
				}
				
				Location targetLocation = target.getLocation();
				World targetWorld = target.getWorld();
				
				switch (targetWorld.getEnvironment()) {
				case NORMAL:
					player.setCompassTarget(targetLocation);
					
					// On crée un compas pour suivre une cible
					ItemStack playerTracker = new ItemStack(Material.COMPASS);
					ItemMeta playerTrackerMeta = playerTracker.getItemMeta();
					playerTrackerMeta.setDisplayName("Player Tracker");
					playerTrackerMeta.setLore(Arrays.asList("Permet de suivre un joueur précis", "§c" + (target.getName()) + " §5est la cible actuelle"));	
					playerTrackerMeta.setLocalizedName(args[0]);
					playerTracker.setItemMeta(playerTrackerMeta);
					
					// Si l'inventaire du joueur est plein, on lui drop l'item au sol
					if (player.getInventory().firstEmpty() == -1) {
						player.getWorld().dropItemNaturally(player.getLocation(), playerTracker);
						
					} else {
						player.getInventory().addItem(playerTracker);
						player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1, 2);
						player.updateInventory();
					}
					
					break;
					
				case NETHER:
					player.sendMessage("Le Player Tracker ne marche pas dans le Nether");
					break;

				case THE_END:
					player.sendMessage("Le Player Tracker ne marche pas dans l'Ender");
					break;
				}
				
			} else {
				// Erreur de syntaxe
				player.sendMessage("Syntaxe : /follow <joueur>");
			}
			
			return true;			
		}
		
		return false;
	}
	
}