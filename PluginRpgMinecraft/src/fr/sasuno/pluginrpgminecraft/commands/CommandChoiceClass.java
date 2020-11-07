package fr.sasuno.pluginrpgminecraft.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.sasuno.pluginrpgminecraft.classe.Archer;
import fr.sasuno.pluginrpgminecraft.classe.Berserker;
import fr.sasuno.pluginrpgminecraft.classe.Classe;
import fr.sasuno.pluginrpgminecraft.classe.Paladin;

public class CommandChoiceClass implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		//==========================================================================
		//	Si c'est un joueur qui lance la commande je rentre dans la condition   /
		//==========================================================================
		if(sender instanceof Player)
		{
			//Je r�cup�re les infos du joueur
			Player player = (Player)sender;
			
			//Si il a d�j� choisi sa classe
			if(player.getCustomName() != null)
			{
				player.sendMessage("Hop hop hop, je te rappelle que tu as d�j� une classe, fais /menu pour voir ce qu'il est possible de faire avec ta classe"+player.getCustomName());
			}
			//==========================================================================
			//	Si aucun param�tre n'est renseign�, je lui affiche la bonne commande   /
			//==========================================================================
			else if(args.length == 0)
			{
				player.sendMessage("La commande est : "+ ChatColor.GREEN +"/class <Paladin>, <Berserker> ou <Archer>");
			}
			// Si il y a un param�tre...
			else if(args.length == 1)
			{
				
				StringBuilder parametre = new StringBuilder();
				for(String part : args)
				{
					parametre.append(part);
				}
				// Si il choisi de bons arguments
				if(parametre.toString().equalsIgnoreCase("Paladin"))
				{
					player.setCustomName("PALADIN");
					Classe.classe.put(player.getName(), new Paladin());
					Classe.classe.get(player.getName()).createClass(player);
				}
				else if(parametre.toString().equalsIgnoreCase("Archer"))
				{
					player.setCustomName("ARCHER");
					Classe.classe.put(player.getName(), new Archer());
					Classe.classe.get(player.getName()).createClass(player);
				}
				else if(parametre.toString().equalsIgnoreCase("Berserker"))
				{
					player.setCustomName("BERSRKER");
					Classe.classe.put(player.getName(), new Berserker());
					Classe.classe.get(player.getName()).createClass(player);
				}
				else
				{
					player.sendMessage("Mmmhh, tu n'as pas entr� de bons param�tres : "+ ChatColor.GREEN +"/class <Paladin>, <Berserker>, <Archer>");
				}
				
			}
		}

		// TODO Auto-generated method stub
		return false;
	}

}
