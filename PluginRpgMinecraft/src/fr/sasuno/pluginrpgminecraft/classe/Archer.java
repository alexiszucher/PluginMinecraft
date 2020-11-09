package fr.sasuno.pluginrpgminecraft.classe;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
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
		ItemStack [][] ListArmors = {
							{new ItemStack(Material.LEATHER_HELMET), new ItemStack(Material.LEATHER_LEGGINGS)},
							{new ItemStack(Material.IRON_HELMET), new ItemStack(Material.IRON_LEGGINGS)}
							};
		this.ListArmorsUp = ListArmors;
		this.NomClasse = "Archer";
	}
	
	//=======================================================================================================
	//	Création de la classe																				/
	//========================================================================================================
	public void createClass(Player player)
	{
		player.sendMessage("Félicitation ! Vous êtes à présent Archer !"
				+ "Vous pouvez améliorer votre arme au fur et à mesure de votre aventure avec "
				+ ChatColor.AQUA+"/weaponup \n"
				+ ChatColor.WHITE +" et ouvrir le menu de votre classe avec "
				+ ChatColor.AQUA+"/menuclass \n");
		ItemStack [] items = {new ItemStack(Material.BOW),
							new ItemStack(Material.ARROW,30)};
		Classe.giveItemsJustForClass(player, items);
		giveArmors(player, ListArmorsUp[0]);
	}

	//=======================================================================================================
	//			Menu de la classe																			/
	//========================================================================================================
	@Override
	public void menuClass(Player player) {
		
		player.sendMessage("Bienvenue dans le menu de votre classe, vous pouvez y retrouver toutes les infos utiles : \n"
				+ ChatColor.AQUA +"VOS SPECIALITES : \n"
				+ ChatColor.YELLOW + "/addspeed "+ ChatColor.WHITE +" 5 XP courrez ! \n"
				+ ChatColor.YELLOW +"/addnofall "+ ChatColor.WHITE +" 5 XP n'ayez plus peur de tomber ! \n \n"
				+ ChatColor.AQUA +"AMELIORATION : \n"
				+ ChatColor.YELLOW + "/bowinfinity "+ ChatColor.WHITE +" 10 XP : donne un arc infinity \n"
				+ ChatColor.YELLOW +"/arrow "+ ChatColor.WHITE +" 25 XP : donne des flêches \n"
				+ ChatColor.YELLOW +"/weaponup "+ ChatColor.WHITE +" augmente votre arme");
		
	}

	@Override
	public void giveArmors(Player player, ItemStack[] items) {

		player.getInventory().setHelmet(items[0]);
		player.getInventory().setLeggings(items[1]);
		
	}
	
}
