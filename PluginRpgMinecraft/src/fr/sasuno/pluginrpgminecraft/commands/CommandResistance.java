package fr.sasuno.pluginrpgminecraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CommandResistance implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		//==========================================================================
		//	Si c'est un joueur qui lance la commande je rentre dans la boucle      /
		//==========================================================================
		if(sender instanceof Player)
		{
			//Je récupère les infos du joueur
			Player player = (Player)sender;
			
			if(player.getLevel() > 29)
			{
				 player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 300000000, 1));
				 player.setLevel(player.getLevel() - 30);
			}
		}
		
		return false;
	}

}
