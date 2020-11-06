package fr.givrix.pluginameliorationminecraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class CommandPos implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;
			
			switch (args.length) {
			case 0:
				Location playerLocation = player.getLocation();
				player.chat("§6x: " + playerLocation.getBlockX() + "   §3y: " + playerLocation.getBlockY() + "   §az: " + playerLocation.getBlockZ());
				break;
				
			case 1:
				Player target = Bukkit.getPlayerExact(args[0]);
				
				if (target == null) {
					player.sendMessage("Le joueur " + args[0] + " n'existe pas ou n'est pas connecté");
					return true;
				}
				
				Location targetLocation = target.getLocation();				
				player.sendMessage("§6x: " + targetLocation.getBlockX() + "   §3y: " + targetLocation.getBlockY() + "   §az: " + targetLocation.getBlockZ());
				break;

			default:
				player.sendMessage("Syntaxe : /pos ou /pos <joueur>");
				break;
			}
			
			return true;
		}
		
		return false;
	}

}