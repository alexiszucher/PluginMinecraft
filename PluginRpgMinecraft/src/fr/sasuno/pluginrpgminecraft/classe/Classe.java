package fr.sasuno.pluginrpgminecraft.classe;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class Classe {
	
	protected ItemStack [] ListWeaponsUp;
	
	protected static int WeaponLvl = 1;
	
	public abstract void createClass(Player player);
	
	public abstract void menuClass(Player player);
	
	public static void weaponUp(Player player, Classe classe)
	{
		ItemStack [] items = {classe.ListWeaponsUp[Classe.WeaponLvl]};
		Classe.giveItems(player, items);
		Classe.WeaponLvl = Classe.WeaponLvl+1;
	}
	
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
			return paladin;
		}
		if(player.getCustomName().equals("BERSERKER"))
		{
			Berserker berserker = new Berserker();
			return berserker;
		}
		if(player.getCustomName().equals("ARCHER"))
		{
			Archer archer = new Archer();
			return archer;
		}
		
		Paladin rip = new Paladin();
		return rip;
	}
}
