package fr.sasuno.pluginrpgminecraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.sasuno.pluginrpgminecraft.classes.Classe;

public class CommandUp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;
			
			if (args.length == 1) {
				
				if (args[0].equalsIgnoreCase("weapon")) {
					Classe.changeWeaponLvl(player, 1);
				}
				
				if (args[0].equalsIgnoreCase("armor")) {
					Classe.changeArmorLvl(player, 1);
				}
				
			} else {
				
				// Erreur de syntaxe
				player.sendMessage("Syntaxe : /up weapon ou /up armor");
			}
			
			return true;
		}
		
		return false;
	}
	
}