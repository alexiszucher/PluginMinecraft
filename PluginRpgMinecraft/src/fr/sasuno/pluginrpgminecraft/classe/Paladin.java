package fr.sasuno.pluginrpgminecraft.classe;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Paladin extends Classe {

	public Paladin()
	{
		ItemStack [] ListWeapons = {new ItemStack(Material.WOODEN_SWORD), new ItemStack(Material.STONE_SWORD), new ItemStack(Material.IRON_SWORD), new ItemStack(Material.DIAMOND_SWORD)};
		this.ListWeaponsUp = ListWeapons;
	}
	
	@Override
	public void createClass(Player player)
	{
		player.sendMessage("Félicitation ! Vous êtes à présent Paladin !");
		ItemStack [] items = {
							new ItemStack(Material.LEATHER_CHESTPLATE), 
							new ItemStack(Material.LEATHER_BOOTS), 
							new ItemStack(Material.LEATHER_LEGGINGS), 
							new ItemStack(Material.LEATHER_HELMET)};
		Classe.giveItems(player, items);
	}

	@Override
	public void menuClass(Player player) {

		player.sendMessage("Bienvenue dans le menu de votre classe, vous pouvez y retrouver toutes les infos utiles : \n"
				+ ChatColor.AQUA +"VOS SPECIALITES : \n"
				+ ChatColor.YELLOW + "/addhearts "+ ChatColor.WHITE +" 30 XP ajouter des coeurs à votre barre de vie ! \n"
				+ ChatColor.YELLOW +"/resistance "+ ChatColor.WHITE +" 30 XP résistez à tout ! \n \n"
				+ ChatColor.AQUA +"MAGASIN D'EXPERIENCES : \n"
				+ ChatColor.YELLOW +"/arrow "+ ChatColor.WHITE +" 25 XP : donne des flêches \n"
				+ ChatColor.YELLOW + "/weaponup "+ ChatColor.WHITE +" 5 XP : augmente d'un niveau votre arme principale");
		
	}
	
}
