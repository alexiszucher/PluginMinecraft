package fr.sasuno.pluginrpgminecraft.classe;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class Berserker extends Classe {

	//=======================================================================================================
	//	Constructeur de la classe																			/
	//========================================================================================================
	public Berserker()
	{
		ItemStack [] ListWeapons = {new ItemStack(Material.WOODEN_AXE), new ItemStack(Material.STONE_AXE), new ItemStack(Material.IRON_AXE), new ItemStack(Material.DIAMOND_AXE)};
		this.ListWeaponsUp = ListWeapons;
		
		ItemStack [][] ListArmors = {
				{new ItemStack(Material.LEATHER_HELMET), new ItemStack(Material.LEATHER_CHESTPLATE), new ItemStack(Material.LEATHER_BOOTS)},
				{new ItemStack(Material.IRON_HELMET), new ItemStack(Material.IRON_CHESTPLATE), new ItemStack(Material.IRON_BOOTS)},
				{new ItemStack(Material.DIAMOND_HELMET), new ItemStack(Material.DIAMOND_CHESTPLATE), new ItemStack(Material.DIAMOND_BOOTS)},
				};
		this.ListArmorsUp = ListArmors;
	}
	
	//=======================================================================================================
	//					Création de la classe																/
	//========================================================================================================
	@Override
	public void createClass(Player player)
	{
		player.sendMessage("Félicitation ! Vous êtes à présent  !");
		ItemStack [] items = {new ItemStack(Material.WOODEN_AXE)};
		Classe.giveItems(player, items);
		Classe.giveItems(player, ListArmorsUp[0]);
	}

	//=======================================================================================================
	//						Menu de la classe																/
	//========================================================================================================
	@Override
	public void menuClass(Player player) {

		player.sendMessage("Bienvenue dans le menu de votre classe, vous pouvez y retrouver toutes les infos utiles : \n"
				+ ChatColor.AQUA +"VOS SPECIALITES : \n"
				+ ChatColor.YELLOW + "/addhearts "+ ChatColor.WHITE +" 30 XP ajouter des coeurs à votre barre de vie ! \n"
				+ ChatColor.YELLOW +"/addattack "+ ChatColor.WHITE +" 30 XP attaquez à fond ! \n \n"
				+ ChatColor.AQUA +"MAGASIN D'EXPERIENCES : \n"
				+ ChatColor.YELLOW +"/arrow "+ ChatColor.WHITE +" 25 XP : donne des flêches \n"
				+ ChatColor.YELLOW + "/weaponup "+ ChatColor.WHITE +" augmente d'un niveau votre arme principale");
		
	}


}
