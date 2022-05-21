package fr.givrix.buyapple.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandBuyApple implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player) sender;
			
			if(player.getLevel() < 3) {
				player.sendMessage("Vous n'avez pas le level requis");
			} else {
				player.giveExpLevels(-3);
				player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
			}
			
			return true;
		}
		
		return false;
	}

}