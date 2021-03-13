package fr.sasuno.pluginrpgminecraft.classes;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Berserker extends Classe {
	
	public Berserker() {
		
		_classeName = "Berserker";
		_maxHealth = 24;
		_weaponLvl = 0;
		_armorLvl = 0;
		_effectLvl = 0;		
	}
	
	public Berserker(int maxHealth, int weaponLvl, int armorLvl, int effectLvl) {
		
		_classeName = "Berserker";
		_maxHealth = maxHealth;
		_weaponLvl = weaponLvl;
		_armorLvl = armorLvl;
		_effectLvl = effectLvl;			
	}

	@Override
	public Classe updateStuff() {
		
		ItemStack stuff;
		ItemMeta stuffMeta;
		
		// On met à jour l'arme
		switch (getWeaponLvl()) {
		case 0:
			stuff = new ItemStack(Material.WOODEN_AXE);
			stuffMeta = stuff.getItemMeta();
			stuffMeta.setDisplayName("§6Hache du bougon");
			stuffMeta.setLore(Arrays.asList("L'arme basique par excellence", "Pratique pour couper du bois"));
			stuffMeta.setLocalizedName("weapon");
			stuffMeta.setUnbreakable(true);
			stuff.setItemMeta(stuffMeta);
			changeWeaponLvl(1);
			break;
		case 1:
			stuff = new ItemStack(Material.STONE_AXE);
			stuffMeta = stuff.getItemMeta();
			stuffMeta.setDisplayName("§6Hache du nonchalant");
			stuffMeta.setLore(Arrays.asList("Une arme un peu émoussée, mais qui fait le taff", "Vos adversaires n'ont qu'à bien se tenir"));
			stuffMeta.setLocalizedName("weapon");
			stuffMeta.setUnbreakable(true);
			stuff.setItemMeta(stuffMeta);
			changeWeaponLvl(1);
			break;
		case 2:
			stuff = new ItemStack(Material.IRON_AXE);
			stuffMeta = stuff.getItemMeta();
			stuffMeta.setDisplayName("§6Hache du mécontentement");
			stuffMeta.setLore(Arrays.asList("Enfin une arme correcte !", "Faites savoir que vous n'êtes pas de bonne humeur"));
			stuffMeta.setLocalizedName("weapon");
			stuffMeta.setUnbreakable(true);
			stuff.setItemMeta(stuffMeta);
			changeWeaponLvl(1);
			break;
		case 3:
			stuff = new ItemStack(Material.DIAMOND_AXE);
			stuffMeta = stuff.getItemMeta();
			stuffMeta.setDisplayName("§6Hache de la colère ultime");
			stuffMeta.setLore(Arrays.asList("On ressent une haine profonde dans cette arme", "Si quelqu'un pense être plus fort que moi, qu'il vienne !"));
			stuffMeta.setLocalizedName("weapon");
			stuffMeta.setUnbreakable(true);
			stuff.setItemMeta(stuffMeta);
			changeWeaponLvl(1);
			break;
		default:
			stuff = new ItemStack(Material.NETHERITE_AXE);
			stuffMeta = stuff.getItemMeta();
			stuffMeta.setDisplayName("§6Hache de la fureur suprème");
			stuffMeta.setLore(Arrays.asList("Une arme de destruction forgée dans le Nether", "Laissez vos pulsions s'exprimer"));
			stuffMeta.setLocalizedName("weapon");
			stuffMeta.setUnbreakable(true);
			stuff.setItemMeta(stuffMeta);
			break;
		}
		
		// On met à jour l'armure
		switch (getArmorLvl()) {
		case 0:
			stuff = new ItemStack(Material.LEATHER_CHESTPLATE);
			stuffMeta = stuff.getItemMeta();
			stuffMeta.setDisplayName("§6Hache du bougon");
			stuffMeta.setLore(Arrays.asList("L'arme basique par excellence", "Pratique pour couper du bois"));
			stuffMeta.setLocalizedName("weapon");
			stuffMeta.setUnbreakable(true);
			stuff.setItemMeta(stuffMeta);
			changeWeaponLvl(1);
			break;
		case 1:
			stuff = new ItemStack(Material.STONE_AXE);
			stuffMeta = stuff.getItemMeta();
			stuffMeta.setDisplayName("§6Hache du nonchalant");
			stuffMeta.setLore(Arrays.asList("Une arme un peu émoussée, mais qui fait le taff", "Vos adversaires n'ont qu'à bien se tenir"));
			stuffMeta.setLocalizedName("weapon");
			stuffMeta.setUnbreakable(true);
			changeWeaponLvl(1);
			break;
		case 2:
			stuff = new ItemStack(Material.IRON_AXE);
			stuffMeta = stuff.getItemMeta();
			stuffMeta.setDisplayName("§6Hache du mécontentement");
			stuffMeta.setLore(Arrays.asList("Enfin une arme correcte !", "Faites savoir que vous n'êtes pas de bonne humeur"));
			stuffMeta.setLocalizedName("weapon");
			stuffMeta.setUnbreakable(true);
			changeWeaponLvl(1);
			break;
		default:
			stuff = new ItemStack(Material.NETHERITE_AXE);
			stuffMeta = stuff.getItemMeta();
			stuffMeta.setDisplayName("§6Hache de la fureur suprème");
			stuffMeta.setLore(Arrays.asList("Une arme de destruction forgée dans le Nether", "Laissez vos pulsions s'exprimer"));
			stuffMeta.setLocalizedName("weapon");
			stuffMeta.setUnbreakable(true);
			break;
		}
		
		return this;
		
	}
	
}