package fr.sasuno.pluginrpgminecraft.classe;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Archer extends Classe{
	
	//=======================================================================================================
	//					Constructeur																		/
	//========================================================================================================
	public Archer()
	{
		ItemStack [] ListWeapons = {new ItemStack(Material.BOW)};
		this.ListWeaponsUp = ListWeapons;
	}
	
	//=======================================================================================================
	//	Création de la classe																				/
	//========================================================================================================
	public void createClass(Player player)
	{
		player.sendMessage("Félicitation ! Vous êtes à présent Archer !");
		ItemStack [] items = {new ItemStack(Material.BOW),
							new ItemStack(Material.ARROW,30)};
		Classe.giveItems(player, items);
	}

	//=======================================================================================================
	//			Menu de la classe																			/
	//========================================================================================================
	@Override
	public void menuClass(Player player) {

		player.sendMessage("Bienvenue dans le menu de votre classe, vous pouvez y retrouver toutes les infos utiles : \n"
				+ ChatColor.AQUA +"VOS SPECIALITES : \n"
				+ ChatColor.YELLOW + "/speed "+ ChatColor.WHITE +" 30 XP courrez ! \n"
				+ ChatColor.YELLOW +"/nofall "+ ChatColor.WHITE +" 30 XP n'ayez plus peur de tomber ! \n \n"
				+ ChatColor.AQUA +"MAGASIN D'EXPERIENCES : \n"
				+ ChatColor.YELLOW + "/bowinfinity "+ ChatColor.WHITE +" 10 XP : donne un arc infinity \n"
				+ ChatColor.YELLOW +"/arrow "+ ChatColor.WHITE +" 25 XP : donne des flêches \n"
				+ ChatColor.YELLOW +"/weaponup "+ ChatColor.WHITE +" 5 XP : augmente votre arme");
		
	}
	
}
