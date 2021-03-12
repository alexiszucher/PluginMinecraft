package fr.givrix.pluginameliorationminecraft.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import fr.givrix.pluginameliorationminecraft.PluginAmeliorationMinecraft;

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
				World.Environment targetEnvironment = target.getWorld().getEnvironment();
								
				// On crée un compas pour suivre une cible
				ItemStack playerTracker = new ItemStack(Material.COMPASS);
				CompassMeta playerTrackerMeta = (CompassMeta) playerTracker.getItemMeta();
				PersistentDataContainer data = playerTrackerMeta.getPersistentDataContainer();
				NamespacedKey key = new NamespacedKey(PluginAmeliorationMinecraft.getPlugin(), "target");
				
				// On customise les metadata de notre item
				playerTrackerMeta.setDisplayName("Player Tracker");
				playerTrackerMeta.setLore(Arrays.asList("Permet de suivre un joueur précis", "§c" + (target.getName()) + " §5est la cible actuelle"));
				playerTrackerMeta.setLocalizedName("playerTracker");
				data.set(key, PersistentDataType.STRING, target.getName());
				playerTrackerMeta.setLodestone(targetLocation);
				playerTrackerMeta.setLodestoneTracked(false);
				playerTracker.setItemMeta(playerTrackerMeta);
				
				// On prépare le message d'où est la cible
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
				
				if (player.getWorld().getEnvironment() != targetEnvironment) {
					player.sendMessage("§cVotre cible se trouve dans " + environment);
				}
					
				// Si l'inventaire du joueur est plein, on lui drop l'item au sol
				if (player.getInventory().firstEmpty() == -1) {
					player.getWorld().dropItemNaturally(player.getLocation(), playerTracker);
					
				} else {
					player.getInventory().addItem(playerTracker);
					player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1, 2);
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