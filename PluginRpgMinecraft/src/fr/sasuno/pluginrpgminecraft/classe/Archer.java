package fr.sasuno.pluginrpgminecraft.classe;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Archer extends JavaPlugin {

	public static void createArcher(Player player)
	{
		player.sendMessage("Félicitation ! Vous êtes à présent Archer !");
		player.getInventory().addItem(new ItemStack(Material.BOW));
		player.getInventory().addItem(new ItemStack(Material.ARROW));
		player.getInventory().addItem(new ItemStack(Material.LEATHER_BOOTS));
		player.getInventory().addItem(new ItemStack(Material.LEATHER_LEGGINGS));
		player.getInventory().addItem(new ItemStack(Material.LEATHER_HELMET));
		player.setCustomName("ARCHER");
		player.setCustomNameVisible(true);
	}
	
	public static void menuArcher(Player player)
	{
		player.sendMessage("Bienvenue dans le menu de votre classe, vous pouvez y retrouver toutes les infos utiles : \n"
							+ ChatColor.AQUA +"VOS SPECIALITES : \n"
							+ ChatColor.YELLOW + "/speed "+ ChatColor.WHITE +" courrez aussi vite que possible ! \n"
							+ ChatColor.YELLOW +"/notFall "+ ChatColor.WHITE +" n'ayez plus peur de tomber ;) \n \n"
							+ ChatColor.AQUA +"MAGASIN D'EXPERIENCES : \n"
							+ ChatColor.YELLOW + "/getArrows "+ ChatColor.WHITE +" 10 XP : donne 20 flêches \n"
							+ ChatColor.YELLOW + "/getHealPotion "+ ChatColor.WHITE +" 15 XP : donne une potion de soin \n"
							+ ChatColor.YELLOW +"/getInfinity "+ ChatColor.WHITE +" 25 XP : donne un arc infinity 1");
	}
	
}
