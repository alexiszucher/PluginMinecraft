package fr.sasuno.pluginrpgminecraft.classe;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class Classe {
	
	protected String MainWeapon;
	
	public abstract void createClass(Player player);
	
	public abstract void menuClass(Player player);
	
	public static void giveItems(Player player, ItemStack [] items)
	{
		for(ItemStack item : items)
		{
			player.getInventory().addItem(item);
		}
	}
	
	public static Classe getClasse(Player player)
	{
		if(player.getCustomName().equals("PALADIN"))
		{
			Paladin paladin = new Paladin();
			paladin.MainWeapon = "SWORD";
			return paladin;
		}
		if(player.getCustomName().equals("BERSERKER"))
		{
			Berserker berserker = new Berserker();
			berserker.MainWeapon = "AXE";
			return berserker;
		}
		if(player.getCustomName().equals("ARCHER"))
		{
			Archer archer = new Archer();
			archer.MainWeapon = "BOW";
			return archer;
		}
		
		Paladin rip = new Paladin();
		return rip;
	}
}
