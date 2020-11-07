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
			//Je récupère les infos du joueur
			Player player = (Player)sender;
			
			//Si il a déjà choisi sa classe
			if(player.getCustomName() != null)
			{
				player.sendMessage("Hop hop hop, je te rappelle que tu as déjà une classe, fais /menu pour voir ce qu'il est possible de faire avec ta classe"+player.getCustomName());
			}
			//==========================================================================
			//	Si aucun paramètre n'est renseigné, je lui affiche la bonne commande   /
			//==========================================================================
			else if(args.length == 0)
			{
				player.sendMessage("La commande est : "+ ChatColor.GREEN +"/class <Paladin>, <Berserker> ou <Archer>");
			}
			// Si il y a un paramètre...
			else if(args.length == 1)
			{
				
				StringBuilder parametre = new StringBuilder();
				for(String part : args)
				{
					parametre.append(part);
				}
				// Si il choisi de bons arguments
				if(parametre.toString().equals("Paladin"))
				{
					player.setCustomName("PALADIN");
					Classe.classe.put(player.getName(), new Paladin());
					Classe.classe.get(player.getName()).createClass(player);
				}
				else if(parametre.toString().equals("Archer"))
				{
					player.setCustomName("ARCHER");
					Classe.classe.put(player.getName(), new Archer());
					Classe.classe.get(player.getName()).createClass(player);
				}
				else if(parametre.toString().equals("Berserker"))
				{
					player.setCustomName("BERSRKER");
					Classe.classe.put(player.getName(), new Berserker());
					Classe.classe.get(player.getName()).createClass(player);
				}
				else
				{
					player.sendMessage("Mmmhh, tu n'as pas entré de bons paramètres : "+ ChatColor.GREEN +"/class <Paladin>, <Berserker>, <Archer>");
				}
				
			}
		}

		// TODO Auto-generated method stub
		return false;
	}

}
