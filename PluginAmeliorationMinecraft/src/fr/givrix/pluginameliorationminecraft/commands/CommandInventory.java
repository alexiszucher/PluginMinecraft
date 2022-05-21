package fr.givrix.pluginameliorationminecraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.givrix.pluginameliorationminecraft.PluginAmeliorationMinecraft;

public class CommandInventory implements CommandExecutor {
			
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player) sender;
			
			if (args.length == 0) {
				player.openInventory(PluginAmeliorationMinecraft.getSharedInventory());
				
			} else {
				// Erreur de syntaxe
				player.sendMessage("Syntaxe : /inventory");
			}
			
			return true;
		}
		
		return false;
	}
	
}