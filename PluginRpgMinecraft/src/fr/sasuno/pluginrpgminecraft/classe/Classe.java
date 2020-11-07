package fr.sasuno.pluginrpgminecraft.classe;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class Classe {
	
	public static Classe classe;
	
	//==============================================================================================
	//	Variables pour la liste des armes de la classe en question afin de faire des weaponup      /
	//==============================================================================================
	protected ItemStack [] ListWeaponsUp;
	protected ItemStack [][] ListArmorsUp;
	
	//==========================================================================================================================================
	//	Variables pour savoir � quel niveau de l'arme / armure de la classe du joueur on se trouve, on commence au lvl 1 avec une arme en bois /
	//==========================================================================================================================================
	protected static int WeaponLvl = 1;
	protected static int ArmorLvl = 1;
	
	//===================================================================================================================
	//	Fonction de cr�ation de classe, fonction abstraite car cr�ation de classe se fait en fonction de la classe choisie  /
	//===================================================================================================================
	public abstract void createClass(Player player);
	
	//==================================================================================================================
	//	Fonction de menu de classe, fonction abstraite car le menu de classe se fait en fonction de la classe choisie  /
	//==================================================================================================================
	public abstract void menuClass(Player player);
	
	//=================================================================================
	//	Fonction de passage d'une mati�re sup�rieur de l'arme principle de la classe  /
	//=================================================================================
	public static void weaponUp(Player player, Classe classe)
	{
		if(player.getLevel() > Classe.WeaponLvl *2)
		{
			ItemStack [] items = {classe.ListWeaponsUp[Classe.WeaponLvl]};
			Classe.giveItems(player, items);
			if(classe.ListWeaponsUp.length > Classe.WeaponLvl + 1)
			{
				Classe.WeaponLvl = Classe.WeaponLvl+1;
			}
		}
		else
		{
			player.sendMessage("Vous n'avez pas encore le lvl n�cessaire pour am�liorer votre arme, vous devez �tre lvl "+ ChatColor.AQUA +Classe.WeaponLvl*2);
		}
	}
	
	//====================================================================================
	//	Fonction de passage d'une mati�re sup�rieur de l'armure principle de la classe   /
	//====================================================================================
	public static void armorUp(Player player, Classe classe)
	{
		if(player.getLevel() > Classe.ArmorLvl *5)
		{
			ItemStack [] items = classe.ListArmorsUp[Classe.ArmorLvl];
			Classe.giveItems(player, items);
			if(classe.ListArmorsUp.length > Classe.ArmorLvl + 1)
			{
				Classe.ArmorLvl = Classe.ArmorLvl+1;
			}
		}
		else
		{
			player.sendMessage("Vous n'avez pas encore le lvl n�cessaire pour am�liorer votre armure, vous devez �tre lvl "+ ChatColor.AQUA +Classe.ArmorLvl*5);
		}
	}
	
	//=======================================================================================================
	//	Fonction giveItem pour allez plus vite dans le d�veloppement, mettez vos items � give sous forme	/
	//	de tableau ItemStack pour give tout au joueur concern�												/
	//========================================================================================================
	public static void giveItems(Player player, ItemStack [] items)
	{
		for(ItemStack item : items)
		{
			player.getInventory().addItem(item);
		}
	}
}
