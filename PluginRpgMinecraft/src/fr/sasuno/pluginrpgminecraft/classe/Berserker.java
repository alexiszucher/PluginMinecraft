package fr.sasuno.pluginrpgminecraft.classe;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
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
				{new ItemStack(Material.DIAMOND_HELMET), new ItemStack(Material.DIAMOND_CHESTPLATE), new ItemStack(Material.DIAMOND_BOOTS)}
				};
		this.ListArmorsUp = ListArmors;
		
		this.NomClasse = "Berserker";
	}
	
	//=======================================================================================================
	//					Création de la classe																/
	//========================================================================================================
	@Override
	public void createClass(Player player)
	{
		player.sendMessage("Félicitation ! Vous êtes à présent Berserker !"
				+ "Vous pouvez améliorer votre arme au fur et à mesure de votre aventure avec "
				+ ChatColor.AQUA+"/weaponup \n"
				+ ChatColor.WHITE +" et ouvrir le menu de votre classe avec "
				+ ChatColor.AQUA+"/menuclass \n");
		ItemStack [] items = {new ItemStack(Material.WOODEN_AXE)};
		Classe.giveItems(player, items);
		giveArmors(player, ListArmorsUp[0]);
		
        AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        attribute.setBaseValue(NombreCoeurs);
        player.setHealth(NombreCoeurs);
	}

	//=======================================================================================================
	//						Menu de la classe																/
	//========================================================================================================
	@Override
	public void menuClass(Player player) {

		player.sendMessage("Bienvenue dans le menu de votre classe, vous pouvez y retrouver toutes les infos utiles : \n"
				+ ChatColor.AQUA +"VOS SPECIALITES : \n"
				+ ChatColor.YELLOW + "/addhearts "+ ChatColor.WHITE +" 5 XP ajouter des coeurs à votre barre de vie ! \n"
				+ ChatColor.YELLOW +"/addattack "+ ChatColor.WHITE +" 30 XP attaquez à fond ! \n \n"
				+ ChatColor.AQUA +"AMELIORATION : \n"
				+ ChatColor.YELLOW +"/arrow "+ ChatColor.WHITE +" 25 XP : donne des flêches \n"
				+ ChatColor.YELLOW + "/weaponup "+ ChatColor.WHITE +" augmente d'un niveau votre arme principale");
		
	}

	@Override
	public void giveArmors(Player player, ItemStack[] items) {

		player.getInventory().setHelmet(items[0]);
		player.getInventory().setChestplate(items[1]);
		player.getInventory().setBoots(items[2]);
		
	}


}
