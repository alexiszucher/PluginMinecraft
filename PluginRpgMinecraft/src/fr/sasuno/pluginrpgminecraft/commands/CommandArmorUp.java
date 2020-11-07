package fr.sasuno.pluginrpgminecraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.sasuno.pluginrpgminecraft.classe.Classe;

public class CommandArmorUp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		//==========================================================================
		//	Si c'est un joueur qui lance la commande je rentre dans la condition   /
		//==========================================================================
		if(sender instanceof Player)
		{
			//Je récupère les infos du joueur
			Player player = (Player)sender;
			
			//============================================================================================
			//	J'exécute la fonction static armorUp commune à toutes les classes dans la classe Classe  /
			//============================================================================================
			Classe.armorUp(player, Classe.classe.get(player.getName()));
		}
		
		return false;
	}

}
