package fr.givrix.pluginameliorationminecraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;

public class CommandPosition implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;
			
			switch (args.length) {
			case 0:
				// On affiche la position du joueur ayant exécuté la commande
				Location playerLocation = player.getLocation();
				player.chat(ChatColor.GOLD + "x: " + playerLocation.getBlockX() + ChatColor.DARK_AQUA + "   y: " + playerLocation.getBlockY() + ChatColor.GREEN + "   z: " + playerLocation.getBlockZ());
				break;
				
			case 1:
				Player target = Bukkit.getPlayerExact(args[0]);
				
				// On vérifie que la cible existe
				if (target == null) {
					player.sendMessage("Le joueur " + args[0] + " n'existe pas ou n'est pas connecté");
					return true;
				}
				
				// On affiche la position de la cible
				Location targetLocation = target.getLocation();				
				player.sendMessage(ChatColor.GOLD + "x: " + targetLocation.getBlockX() + ChatColor.DARK_AQUA + "   y: " + targetLocation.getBlockY() + ChatColor.GREEN + "   z: " + targetLocation.getBlockZ());
				break;

			default:
				return false;
			}
			
			return true;
		}
		
		return false;
	}

}