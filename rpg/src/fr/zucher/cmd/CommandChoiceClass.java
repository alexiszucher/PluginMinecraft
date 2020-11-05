package fr.zucher.cmd;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.zucher.classe.Archer;
import fr.zucher.classe.Guerrier;

public class CommandChoiceClass implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		//==========================================================================
		//	Si c'est un joueur qui lance la commande je rentre dans la boucle      /
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
				player.sendMessage("La commande est : "+ ChatColor.GREEN +"/class Guerrier|Archer");
			}
			// Si il y a un paramètre...
			else if(args.length == 1)
			{
				
				StringBuilder parametre = new StringBuilder();
				for(String part : args)
				{
					parametre.append(part);
				}
				// Si il choisi la classe Guerrier ...
				if(parametre.toString().equals("Guerrier"))
				{
					Guerrier.createGuerrier(player);
				}
				// Si il choisi la classe Archer ...
				else if(parametre.toString().equals("Archer"))
				{
					Archer.createArcher(player);
				}
				else
				{
					player.sendMessage("Mmmhh, tu n'as pas entré de bons paramètres : "+ ChatColor.GREEN +"/class Guerrier|Archer");
				}
				
			}
		}

		// TODO Auto-generated method stub
		return false;
	}

}
