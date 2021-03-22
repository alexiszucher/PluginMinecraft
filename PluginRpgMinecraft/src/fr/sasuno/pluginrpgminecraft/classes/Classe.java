package fr.sasuno.pluginrpgminecraft.classes;

import java.util.Arrays;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.sasuno.pluginrpgminecraft.PluginRpgMinecraft;
import fr.sasuno.pluginrpgminecraft.data.PersistentDataTypeClasse;

public abstract class Classe {
	
	protected String _classeName;
	protected int _maxHealth;
	protected int _weaponLvl;
	protected int _armorLvl;
	protected int _effectLvl;
	
	// Puisque c'est une classe abstraite (classe mère), les constructeurs sont dans les classes héritées (classes filles)
	public Classe() {}
	
	// Toutes fonctions relativent à l'objet de type Classe
	public static Classe getClasseObject(Player player) {
		
		PersistentDataTypeClasse dataType = new PersistentDataTypeClasse();
		PersistentDataContainer data = player.getPersistentDataContainer();
		NamespacedKey key = new NamespacedKey(PluginRpgMinecraft.getPlugin(), "classe");
		return data.get(key, dataType);
	}
	
	public static void setClasseObject(Player player, Classe classeObject) {
		
		PersistentDataTypeClasse dataType = new PersistentDataTypeClasse();
		PersistentDataContainer data = player.getPersistentDataContainer();
		NamespacedKey key = new NamespacedKey(PluginRpgMinecraft.getPlugin(), "classe");
		data.set(key, dataType, classeObject);
		classeObject.updateStuff(player);
	}
	
	public static boolean hasClasse(Player player) {
		
		PersistentDataTypeClasse dataType = new PersistentDataTypeClasse();
		PersistentDataContainer data = player.getPersistentDataContainer();
		NamespacedKey key = new NamespacedKey(PluginRpgMinecraft.getPlugin(), "classe");
		return data.has(key, dataType);
	}
	
	public boolean isThisClasse(String classeName) { return classeName.equalsIgnoreCase(getClasseName()); }
	public static boolean isThisClasse(Player player, String classeName) { return getClasseName(player).equalsIgnoreCase(classeName); }
	public static void setClasse(Player player, String classeName) {
		
		Classe classe;
		
		if (classeName.equalsIgnoreCase("Paladin")) classe = new Paladin();
		else if (classeName.equalsIgnoreCase("Berserker")) classe = new Berserker();
		else if (classeName.equalsIgnoreCase("Assassin")) classe = new Assassin();
		else if (classeName.equalsIgnoreCase("Archer")) classe = new Archer();
		else classe = new Mage();
		
		// On met à jour les infos du joueur
		setClasseObject(player, classe);
		fullHeal(player);
		
		// On donne au joueur l'item pour ouvrir le menu de classe
		if (!hasItemMenu(player)) giveItemMenu(player);
	}
	
	public static void setRandomClasse(Player player) {
		
		Random random = new Random();
		int x = random.nextInt(4);
		
		//x = 2;
		
		Classe classe;
		
		switch (x) {
		case 0:
			classe = new Berserker();
			break;
			
		case 1:
			classe = new Paladin();
			break;
			
		case 2:
			classe = new Archer();
			break;
			
		case 3:
			classe = new Triton();
			break;
			
		case 4:
			classe = new Arbaletrier();
			break;
			
		case 5:
			classe = new Assassin();
			break;
			
		default:
			classe = new Mage();
		}
		
		// On met à jour les infos du joueur
		setClasseObject(player, classe);
		updateMaxHealth(player);
		fullHeal(player);
		
		// On donne au joueur l'item pour ouvrir le menu de classe
		if (!hasItemMenu(player)) giveItemMenu(player);
	}
	
	// Toutes fonctions relativent au nom de la classe
	public String getClasseName() { return _classeName;	}
	public static String getClasseName(Player player) { return getClasseObject(player).getClasseName(); }
	
	// Toutes fonctions relativent à la vie
	public int getMaxHealth() { return _maxHealth; }
	public static int getMaxHealth(Player player) { return getClasseObject(player).getMaxHealth(); }
	public static void updateMaxHealth(Player player) {
		
		AttributeInstance maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
		maxHealth.setBaseValue(getMaxHealth(player));
	}
	
	public static void setMaxHealth(Player player, int maxHealth) {
		
		Classe classeObject = getClasseObject(player);
		classeObject._maxHealth = maxHealth;
		setClasseObject(player, classeObject);
		updateMaxHealth(player);
	}
	
	public static void changeMaxHealth(Player player, int hearts) {
		
		setMaxHealth(player, getMaxHealth(player) + 2*hearts);
		PotionEffect heal = new PotionEffect(PotionEffectType.REGENERATION, 5*hearts, 0);
		heal.apply(player);
	}
	
	public static void fullHeal(Player player) {

		PotionEffect heal = new PotionEffect(PotionEffectType.HEAL, 1, 1);
		heal.apply(player);
	}
	
	// Toutes fonctions relativent aux armes
	public int getWeaponLvl() { return _weaponLvl; }
	public static int getWeaponLvl(Player player) { return getClasseObject(player).getWeaponLvl(); }
	public static void setWeaponLvl(Player player, int weaponLvl) {
		
		if (weaponLvl < 1) weaponLvl = 1;
		if (weaponLvl > 5) weaponLvl = 5;
		Classe classeObject = getClasseObject(player);
		classeObject._weaponLvl = weaponLvl;
		setClasseObject(player, classeObject);
	}
	
	public static void changeWeaponLvl(Player player, int lvl) { setWeaponLvl(player, getWeaponLvl(player) + lvl); }
	
	// Toutes fonctions relativent aux armures
	public int getArmorLvl() { return _armorLvl; }
	public static int getArmorLvl(Player player) { return getClasseObject(player).getArmorLvl(); }
	public static void setArmorLvl(Player player, int armorLvl) {

		if (armorLvl < 1) armorLvl = 1;
		if (armorLvl > 5) armorLvl = 5;
		Classe classeObject = getClasseObject(player);
		classeObject._armorLvl = armorLvl;
		setClasseObject(player, classeObject);
	}
	
	public static void changeArmorLvl(Player player, int lvl) { setArmorLvl(player, getArmorLvl(player) + lvl); }
	
	// Toutes fonctions relativent aux effets
	public int getEffectLvl() { return _effectLvl; }
	public static int getEffectLvl(Player player) { return getClasseObject(player).getEffectLvl(); }
	public static void setEffectLvl(Player player, int effectLvl) {

		if (effectLvl < 1) effectLvl = 1;
		if (effectLvl > 3) effectLvl = 3;
		Classe classeObject = getClasseObject(player);
		classeObject._effectLvl = effectLvl;
		setClasseObject(player, classeObject);
	}
	
	public static void changeEffectLvl(Player player, int lvl) { setEffectLvl(player, getEffectLvl(player) + lvl); }
	
	// Toutes fonctions relativent au stuff
	public abstract void updateStuff(Player player);
	
	public static boolean hasItemMenu(Player player) {

		ItemStack menuClasse = new ItemStack(Material.EMERALD);
		ItemMeta menuClasseMeta = menuClasse.getItemMeta();
		menuClasseMeta.setDisplayName("§bPierre mystique d'amélioration");
		menuClasseMeta.setLore(Arrays.asList("Cette pierre magique permet", "d'améliorer vos compétences", "", "§9Tout aventurier en a une sur lui", "§cNe perdez pas cet item"));
		menuClasseMeta.setLocalizedName("menuClasse");
		menuClasse.setItemMeta(menuClasseMeta);
		if (player.getInventory().contains(menuClasse)) return true;
		if (player.getInventory().getItemInOffHand().equals(menuClasse)) return true;
		return false;
	}
	
	public static void giveItemMenu(Player player) {

		ItemStack menuClasse = new ItemStack(Material.EMERALD);
		ItemMeta menuClasseMeta = menuClasse.getItemMeta();
		menuClasseMeta.setDisplayName("§bPierre mystique d'amélioration");
		menuClasseMeta.setLore(Arrays.asList("Cette pierre magique permet", "d'améliorer vos compétences", "", "§9Tout aventurier en a une sur lui", "§cNe perdez pas cet item"));
		menuClasseMeta.setLocalizedName("menuClasse");
		menuClasse.setItemMeta(menuClasseMeta);
		player.getInventory().addItem(menuClasse);
	}
	
	public abstract void openMenu(Player player);

	public static boolean hasLvlToUpdateWeapon(Player player) {
		switch (getWeaponLvl(player)) {
		case 1:
			if (player.getLevel() >= 10) {
				player.giveExpLevels(-10);
				return true;
			}
			
		case 2:
			if (player.getLevel() >= 15) {
				player.giveExpLevels(-15);
				return true;
			}
			
		case 3:
			if (player.getLevel() >= 20) {
				player.giveExpLevels(-20);
				return true;
			}
			
		case 4:
			if (player.getLevel() >= 30) {
				player.giveExpLevels(-30);
				return true;
			}

		default:
		}
		
		return false;
	}

	public static boolean hasLvlToUpdateArmor(Player player) {
		switch (getArmorLvl(player)) {
		case 1:
			if (player.getLevel() >= 10) {
				player.giveExpLevels(-10);
				return true;
			}
			
		case 2:
			if (player.getLevel() >= 15) {
				player.giveExpLevels(-15);
				return true;
			}
			
		case 3:
			if (player.getLevel() >= 20) {
				player.giveExpLevels(-20);
				return true;
			}
			
		case 4:
			if (player.getLevel() >= 30) {
				player.giveExpLevels(-30);
				return true;
			}

		default:
		}
		
		return false;
	}

	public static boolean hasLvlToUpdateEffect(Player player) {
		switch (getEffectLvl(player)) {
		case 1:
			if (player.getLevel() >= 20) {
				player.giveExpLevels(-20);
				return true;
			}
			
		case 2:
			if (player.getLevel() >= 30) {
				player.giveExpLevels(-30);
				return true;
			}

		default:
		}
		
		return false;
	}
	
}