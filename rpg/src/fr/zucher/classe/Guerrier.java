package fr.zucher.classe;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Guerrier extends JavaPlugin {
	
	public static void createGuerrier(Player player)
	{
		player.sendMessage("Félicitation ! Vous êtes à présent Guerrier !");
		player.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
		player.getInventory().addItem(new ItemStack(Material.LEATHER_CHESTPLATE));
		player.getInventory().addItem(new ItemStack(Material.LEATHER_BOOTS));
		player.getInventory().addItem(new ItemStack(Material.LEATHER_LEGGINGS));
		player.getInventory().addItem(new ItemStack(Material.LEATHER_HELMET));
		player.setCustomName("GUERRIER");
		player.setCustomNameVisible(true);
	}
	
	public static void menuGuerrier(Player player)
	{
		player.sendMessage("Bienvenue dans le menu de votre classe, vous pouvez y retrouver toutes les infos utiles : \n"
							+ ChatColor.AQUA +"VOS SPECIALITES : \n"
							+ ChatColor.YELLOW + "/addHearts "+ ChatColor.WHITE +" ajoute des coeurs à votre barre de vie \n"
							+ ChatColor.YELLOW +"/resistance "+ ChatColor.WHITE +"augmente votre défense \n \n"
							+ ChatColor.AQUA +"MAGASIN D'EXPERIENCES : \n"
							+ ChatColor.YELLOW + "/getStuffIron "+ ChatColor.WHITE +" 10 XP : donne un équipement en fer \n"
							+ ChatColor.YELLOW +"/getStuffDiamond "+ ChatColor.WHITE +" 25 XP : donne un équipement en diamant");
	}
	
}
