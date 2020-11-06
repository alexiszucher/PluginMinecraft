package fr.sasuno.pluginrpgminecraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.sasuno.pluginrpgminecraft.classe.Guerrier;
import fr.sasuno.pluginrpgminecraft.classe.Archer;

public class CommandClassMenu implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		//==========================================================================
		//	Si c'est un joueur qui lance la commande je rentre dans la boucle      /
		//==========================================================================
		if(sender instanceof Player)
		{
			//Je récupère les infos du joueur
			Player player = (Player)sender;
			
			if(player.getCustomName().equals("GUERRIER"))
			{
				Guerrier.menuGuerrier(player);
			}
			if(player.getCustomName().equals("ARCHER"))
			{
				Archer.menuArcher(player);
			}
		}
		
		return false;
	}

}
