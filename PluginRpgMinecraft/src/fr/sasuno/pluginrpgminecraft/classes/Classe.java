package fr.sasuno.pluginrpgminecraft.classes;

import java.util.Random;

import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;

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
		setClasseObject(player, classe);
		updateMaxHealth(player);
		updateStuff(player);
	}
	
	public static void setRandomClasse(Player player) {
		
		Random random = new Random();
		int x = random.nextInt(5);
		
		Classe classe;
		
		switch (x) {
		case 0:
			classe = new Paladin();
			break;
		case 1:
			classe = new Berserker();
			break;
		case 2:
			classe = new Assassin();
			break;
		case 3:
			classe = new Archer();
			break;
		default:
			classe = new Mage();
		}
		
		setClasseObject(player, classe);
		updateMaxHealth(player);
		updateStuff(player);		
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
	
	public static void changeMaxHealth(Player player, int hearts) { setMaxHealth(player, getMaxHealth(player) + 2*hearts); }
	
	// Toutes fonctions relativent aux armes
	public int getWeaponLvl() { return _weaponLvl; }
	public static int getWeaponLvl(Player player) { return getClasseObject(player).getWeaponLvl(); }	
	public void setWeaponLvl(int weaponLvl) { _weaponLvl = weaponLvl; }	
	public static void setWeaponLvl(Player player, int weaponLvl) {
		
		Classe classeObject = getClasseObject(player);
		classeObject._weaponLvl = weaponLvl;
		setClasseObject(player, classeObject);
	}
	
	public void changeWeaponLvl(int lvl) { setWeaponLvl(getWeaponLvl() + lvl); }	
	public static void changeWeaponLvl(Player player, int lvl) { setWeaponLvl(player, getWeaponLvl(player) + lvl); }
	
	// Toutes fonctions relativent aux armures
	public int getArmorLvl() { return _armorLvl; }
	public static int getArmorLvl(Player player) { return getClasseObject(player).getArmorLvl(); }	
	public void setArmorLvl(int armorLvl) { _armorLvl = armorLvl; }	
	public static void setArmorLvl(Player player, int armorLvl) {
		
		Classe classeObject = getClasseObject(player);
		classeObject._armorLvl = armorLvl;
		setClasseObject(player, classeObject);
	}
	
	public void changeArmorLvl(int lvl) { setArmorLvl(getArmorLvl() + lvl); }
	public static void changeArmorLvl(Player player, int lvl) { setArmorLvl(player, getArmorLvl(player) + lvl); }
	
	// Toutes fonctions relativent aux effets
	public int getEffectLvl() { return _effectLvl; }
	public static int getEffectLvl(Player player) { return getClasseObject(player).getEffectLvl(); }	
	public void setEffectLvl(int effectLvl) { _effectLvl = effectLvl; }	
	public static void setEffectLvl(Player player, int effectLvl) {
		
		Classe classeObject = getClasseObject(player);
		classeObject._effectLvl = effectLvl;
		setClasseObject(player, classeObject);
	}
	
	public void changeEffectLvl(int lvl) { setEffectLvl(getEffectLvl() + lvl); }
	public static void changeEffectLvl(Player player, int lvl) { setEffectLvl(player, getEffectLvl(player) + lvl); }
	
	// Toutes fonctions relativent au stuff
	public abstract Classe updateStuff();
	public static void updateStuff(Player player) {
		
		Classe classeObject = getClasseObject(player).updateStuff();
		
	}
	
}