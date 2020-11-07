package fr.sasuno.pluginrpgminecraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.sasuno.pluginrpgminecraft.classe.Classe;

public class CommandClassMenu implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		//==========================================================================
		//	Si c'est un joueur qui lance la commande je rentre dans la condition   /
		//==========================================================================
		if(sender instanceof Player)
		{
			//Je récupère les infos du joueur et j'affiche le menu de la classe en question
			Player player = (Player)sender;
			Classe.getClasse(player).menuClass(player);
		}
		
		return false;
	}

}
