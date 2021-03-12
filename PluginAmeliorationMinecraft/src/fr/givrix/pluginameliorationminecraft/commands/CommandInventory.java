package fr.givrix.pluginameliorationminecraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class CommandInventory implements CommandExecutor {

	Inventory inventory = Bukkit.createInventory(null, InventoryType.CHEST, "Inventaire commun");
			
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player) sender;
			
			if (args.length == 0) {
				player.openInventory(inventory);
				
			} else {
				// Erreur de syntaxe
				player.sendMessage("Syntaxe : /inventory");
			}
			
			return true;
		}
		
		return false;
	}
	
}