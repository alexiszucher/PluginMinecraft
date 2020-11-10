package fr.sasuno.pluginrpgminecraft.classe;

import java.util.Arrays;
import java.util.TreeMap;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public abstract class Classe {
	
	public static TreeMap < String, Classe > classe = new TreeMap<String, Classe>();
	
	protected String NomClasse;
	
	protected int NombreCoeurs = 20;
	
	protected int Dommage = 1;
	
	protected int Resistance = 0;
	//==============================================================================================
	//	Variables pour la liste des armes de la classe en question afin de faire des weaponup      /
	//==============================================================================================
	protected ItemStack [] ListWeaponsUp;
	protected ItemStack [][] ListArmorsUp;
	
	//==========================================================================================================================================
	//	Variables pour savoir à quel niveau de l'arme / armure de la classe du joueur on se trouve, on commence au lvl 1 avec une arme en bois /
	//==========================================================================================================================================
	protected int WeaponLvl = 1;
	protected int ArmorLvl = 1;
	
	//===================================================================================================================
	//	Fonction de création de classe, fonction abstraite car création de classe se fait en fonction de la classe choisie  /
	//===================================================================================================================
	public abstract void createClass(Player player);
	
	//==================================================================================================================
	//	Fonction de menu de classe, fonction abstraite car le menu de classe se fait en fonction de la classe choisie  /
	//==================================================================================================================
	public abstract void menuClass(Player player);
	
	//============================================================================================================================
	//	Fonction pour donner l'armure à un joueur, fonction abstraite car toutes les classe n'ont pas les mêmes pièces d'armure  /
	//============================================================================================================================
	public abstract void giveArmors(Player player, ItemStack [] items);
	
	//=================================================================================
	//	Fonction de passage d'une matière supérieur de l'arme principle de la classe  /
	//=================================================================================
	public static void weaponUp(Player player, Classe classe)
	{
		if(player.getLevel() >= classe.WeaponLvl *2)
		{
			player.getInventory().removeItem(classe.ListWeaponsUp[classe.WeaponLvl-1]);
			ItemStack [] items = {classe.ListWeaponsUp[classe.WeaponLvl]};
			Classe.giveItemsJustForClass(player, items);
			player.setLevel(player.getLevel() - classe.WeaponLvl *2);
			if(classe.ListWeaponsUp.length > classe.WeaponLvl + 1)
			{
				classe.WeaponLvl = classe.WeaponLvl+1;
			}
		}
		else
		{
			player.sendMessage("Vous n'avez pas encore le lvl nécessaire pour améliorer votre arme, vous devez être lvl "+ ChatColor.AQUA +classe.WeaponLvl*2);
		}
	}
	
	//====================================================================================
	//	Fonction de passage d'une matière supérieur de l'armure principle de la classe   /
	//====================================================================================
	public static void armorUp(Player player, Classe classe)
	{
		if(player.getLevel() >= classe.ArmorLvl *5)
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
			player.sendMessage("Vous n'avez pas encore le lvl nécessaire pour améliorer votre armure, vous devez être lvl "+ ChatColor.AQUA +classe.ArmorLvl*5);
		}
	}
	
	//====================================================================================
	//	Fonction appelé par la commande /addhearts									     /
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
		        player.sendMessage(ChatColor.YELLOW + "Vos coeurs ont été augmentés de 2 !");
			}
			else
			{
				player.sendMessage("Vous n'avez pas encore le lvl nécessaire, vous devez être "+ ChatColor.AQUA + "lvl 5");
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
		        player.sendMessage(ChatColor.YELLOW + "Vos coeurs ont été augmentés de 1 !");
			}
			else
			{
				player.sendMessage("Vous n'avez pas encore le lvl nécessaire, vous devez être "+ ChatColor.AQUA + "lvl 5");
			}
		}
		
	}
	
	//====================================================================================
	//	Fonction appelé par la commande /addhearts									     /
	//====================================================================================
	public static void addAttacks(Player player, Classe classe)
	{
		//=======================
		//	Berserker			/
		//=======================
		if(classe.NomClasse.equals("Berserker"))
		{
			if(player.getLevel() > 4)
			{
				classe.Dommage = classe.Dommage + 2;
		        AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
		        attribute.setBaseValue(classe.Dommage);
		        player.setLevel(player.getLevel() - 5);
		        player.sendMessage(ChatColor.YELLOW + "Votre attaque a été aumenté de 2 !");
			}
			else
			{
				player.sendMessage("Vous n'avez pas encore le lvl nécessaire, vous devez être "+ ChatColor.AQUA + "lvl 5");
			}
		}
	}
	
	//====================================================================================
	//	Fonction pour ajouter de la resistance								     		/
	//====================================================================================
	public static void addResistances(Player player, Classe classe)
	{
		//=======================
		//	Paladin				/
		//=======================
		if(classe.NomClasse.equals("Paladin"))
		{
			if(player.getLevel() > 4)
			{
				player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
				player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,100000000,classe.Resistance));
		        classe.Resistance = classe.Resistance + 1;
		        player.sendMessage(ChatColor.YELLOW + "Votre résistance a été aumenté !");
			}
			else
			{
				player.sendMessage("Vous n'avez pas encore le lvl nécessaire, vous devez être "+ ChatColor.AQUA + "lvl 5");
			}
		}
	}
	
	//=======================================================================================================
	//	Fonction giveItems pour allez plus vite dans le développement, mettez vos items à give sous forme	/
	//	de tableau ItemStack pour give tout au joueur concerné												/
	//========================================================================================================
	public static void giveItemsJustForClass(Player player, ItemStack [] items)
	{
		for(ItemStack item : items)
		{
			ItemMeta meta = item.getItemMeta();
			meta.setUnbreakable(true);
			meta.setLocalizedName(player.getName());
			item.setItemMeta(meta);
			player.getInventory().addItem(item);
		}
	}
	
	public static ItemStack createItemForMenu(ItemStack item, String name, String desc)
	{
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(name);
		itemM.setLore(Arrays.asList(ChatColor.YELLOW + desc));
		item.setItemMeta(itemM);
		return item;
	}
}
