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
				// On affiche la position du joueur ayant exécuté la commande
				Location playerLocation = player.getLocation();
				player.chat("§6x: " + playerLocation.getBlockX() + "   §3y: " + playerLocation.getBlockY() + "   §az: " + playerLocation.getBlockZ());
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
				player.sendMessage("§6x: " + targetLocation.getBlockX() + "   §3y: " + targetLocation.getBlockY() + "   §az: " + targetLocation.getBlockZ());
				break;

			default:
				// Erreur de syntaxe
				player.sendMessage("Syntaxe : /pos ou /pos <joueur>");
				break;
			}
			
			return true;
		}
		
		return false;
	}

}