package fr.sasuno.pluginrpgminecraft.classe;

import java.util.TreeMap;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class Classe {
	
	public static TreeMap < String, Classe > classe = new TreeMap<String, Classe>();
	
	protected String NomClasse;
	
	protected int NombreCoeurs = 20;
	
	//==============================================================================================
	//	Variables pour la liste des armes de la classe en question afin de faire des weaponup      /
	//==============================================================================================
	protected ItemStack [] ListWeaponsUp;
	protected ItemStack [][] ListArmorsUp;
	
	//==========================================================================================================================================
	//	Variables pour savoir � quel niveau de l'arme / armure de la classe du joueur on se trouve, on commence au lvl 1 avec une arme en bois /
	//==========================================================================================================================================
	protected int WeaponLvl = 1;
	protected int ArmorLvl = 1;
	
	//===================================================================================================================
	//	Fonction de cr�ation de classe, fonction abstraite car cr�ation de classe se fait en fonction de la classe choisie  /
	//===================================================================================================================
	public abstract void createClass(Player player);
	
	//==================================================================================================================
	//	Fonction de menu de classe, fonction abstraite car le menu de classe se fait en fonction de la classe choisie  /
	//==================================================================================================================
	public abstract void menuClass(Player player);
	
	//============================================================================================================================
	//	Fonction pour donner l'armure � un joueur, fonction abstraite car toutes les classe n'ont pas les m�mes pi�ces d'armure  /
	//============================================================================================================================
	public abstract void giveArmors(Player player, ItemStack [] items);
	
	//=================================================================================
	//	Fonction de passage d'une mati�re sup�rieur de l'arme principle de la classe  /
	//=================================================================================
	public static void weaponUp(Player player, Classe classe)
	{
		if(player.getLevel() > classe.WeaponLvl *2)
		{
			ItemStack [] items = {classe.ListWeaponsUp[classe.WeaponLvl]};
			Classe.giveItems(player, items);
			player.setLevel(player.getLevel() - classe.WeaponLvl *2);
			if(classe.ListWeaponsUp.length > classe.WeaponLvl + 1)
			{
				classe.WeaponLvl = classe.WeaponLvl+1;
			}
		}
		else
		{
			player.sendMessage("Vous n'avez pas encore le lvl n�cessaire pour am�liorer votre arme, vous devez �tre lvl "+ ChatColor.AQUA +classe.WeaponLvl*2);
		}
	}
	
	//====================================================================================
	//	Fonction de passage d'une mati�re sup�rieur de l'armure principle de la classe   /
	//====================================================================================
	public static void armorUp(Player player, Classe classe)
	{
		if(player.getLevel() > classe.ArmorLvl *5)
		{
			ItemStack [] items = classe.ListArmorsUp[classe.ArmorLvl];
			classe.giveArmors(player, items);
			int SoustraitLvl = classe.ArmorLvl *5;
			player.setLevel(player.getLevel() - SoustraitLvl);
			if(classe.ListArmorsUp.length > classe.ArmorLvl + 1)
			{
				classe.ArmorLvl = classe.ArmorLvl+1;
			}
		}
		else
		{
			player.sendMessage("Vous n'avez pas encore le lvl n�cessaire pour am�liorer votre armure, vous devez �tre lvl "+ ChatColor.AQUA +classe.ArmorLvl*5);
		}
	}
	
	//====================================================================================
	//	Fonction appel� par la commande /addhearts									     /
	//====================================================================================
	public static void addHearts(Player player, Classe classe)
	{
		//=======================
		//	PALADIN				/
		//=======================
		if(classe.NomClasse.equals("Paladin") && classe.NombreCoeurs != 40)
		{
			if(player.getLevel() > 4)
			{
				classe.NombreCoeurs = classe.NombreCoeurs + 4;
		        AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
		        attribute.setBaseValue(classe.NombreCoeurs);
		        player.setHealth(classe.NombreCoeurs);
		        player.setLevel(player.getLevel() - 5);
			}
		}
		
		//=======================
		//	BERSERKER			/
		//=======================
		if(classe.NomClasse.equals("Berserker") && classe.NombreCoeurs != 30)
		{
			if(player.getLevel() > 4)
			{
				classe.NombreCoeurs = classe.NombreCoeurs + 2;
		        AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
		        attribute.setBaseValue(classe.NombreCoeurs);
		        player.setHealth(classe.NombreCoeurs);
		        player.setLevel(player.getLevel() - 5);
			}
		}
		
	}
	
	//====================================================================================
	//	Fonction appel� par la commande /addhearts									     /
	//====================================================================================
	public static void addAttacks(Player player, Classe classe)
	{
		//=======================
		//	Berserker			/
		//=======================
//		if(classe.NomClasse.equals("Berserker"))
//		{
//			if(player.getLevel() > 4)
//			{
//				classe.NombreCoeurs = classe.NombreCoeurs + 4;
//		        AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
//		        attribute.setBaseValue(classe.NombreCoeurs);
//		        player.setHealth(classe.NombreCoeurs);
//		        player.setLevel(player.getLevel() - 5);
//			}
//		}	
		AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
		attribute.setBaseValue(300);
	}
	
	//=======================================================================================================
	//	Fonction giveItems pour allez plus vite dans le d�veloppement, mettez vos items � give sous forme	/
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
