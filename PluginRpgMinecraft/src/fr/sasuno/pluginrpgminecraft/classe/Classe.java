package fr.sasuno.pluginrpgminecraft.classe;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class Classe {
	
	//=============================================================================================
	//	Variable pour la liste des armes de la classe en question afin de faire des weaponup      /
	//=============================================================================================
	protected ItemStack [] ListWeaponsUp;
	
	//================================================================================================================================
	//	Variable pour savoir à quel niveau de l'arme de la classe du joueur on se trouve, on commence au lvl 1 avec une arme en bois /
	//================================================================================================================================
	protected static int WeaponLvl = 1;
	
	//===================================================================================================================
	//	Fonction de création de classe, fonction abstraite car création de classe se fait en fonction de la classe choisie  /
	//===================================================================================================================
	public abstract void createClass(Player player);
	
	//==================================================================================================================
	//	Fonction de menu de classe, fonction abstraite car le menu de classe se fait en fonction de la classe choisie  /
	//==================================================================================================================
	public abstract void menuClass(Player player);
	
	//=================================================================================
	//	Fonction de passage d'une matière supérieur de l'arme principle de la classe  /
	//=================================================================================
	public static void weaponUp(Player player, Classe classe)
	{
		if(player.getLevel() > Classe.WeaponLvl *5)
		{
			ItemStack [] items = {classe.ListWeaponsUp[Classe.WeaponLvl]};
			Classe.giveItems(player, items);
			if(classe.ListWeaponsUp.length > Classe.WeaponLvl + 1)
			{
				player.sendMessage(" Longueur Tableau : "+classe.ListWeaponsUp.length+" Lvl rec : "+Classe.WeaponLvl);
				Classe.WeaponLvl = Classe.WeaponLvl+1;
			}
		}
		else
		{
			player.sendMessage("Vous n'avez pas encore le lvl nécessaire pour améliorer votre arme, vous devez être lvl "+ ChatColor.AQUA +Classe.WeaponLvl*5);
		}
	}
	
	//=======================================================================================================
	//	Fonction giveItem pour allez plus vite dans le développement, mettez vos items à give sous forme	/
	//	de tableau ItemStack pour give tout au joueur concerné												/
	//========================================================================================================
	public static void giveItems(Player player, ItemStack [] items)
	{
		for(ItemStack item : items)
		{
			player.getInventory().addItem(item);
		}
	}
	
	//=======================================================================================================
	//	Fonction pour récupérer la classe du joueur pour toutes les commandes que le joueur va faire		/
	//========================================================================================================
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
