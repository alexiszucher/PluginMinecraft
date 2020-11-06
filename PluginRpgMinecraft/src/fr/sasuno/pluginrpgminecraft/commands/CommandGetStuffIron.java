package fr.sasuno.pluginrpgminecraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.sasuno.pluginrpgminecraft.classe.Guerrier;
import fr.sasuno.pluginrpgminecraft.classe.Archer;

public class CommandGetStuffIron implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		//==========================================================================
		//	Si c'est un joueur qui lance la commande je rentre dans la boucle      /
		//==========================================================================
		if(sender instanceof Player)
		{
			//Je récupère les infos du joueur
			Player player = (Player)sender;
			
			if(player.getLevel() > 9)
			{
				 //Guerrier.getStuffIron(player);
				 player.setLevel(player.getLevel() - 10);
			}
		}
		
		return false;
	}

}
