package fr.sasuno.pluginrpgminecraft.classes;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class Arbaletrier extends Classe {
	
	public Arbaletrier() {
		
		_classeName = "Arbalétrier";
		_maxHealth = 20;
		_weaponLvl = 1;
		_armorLvl = 1;
		_effectLvl = 1;		
	}
	
	public Arbaletrier(int maxHealth, int weaponLvl, int armorLvl, int effectLvl) {
		
		_classeName = "Arbalétrier";
		_maxHealth = maxHealth;
		_weaponLvl = weaponLvl;
		_armorLvl = armorLvl;
		_effectLvl = effectLvl;			
	}

	@Override
	public void updateStuff(Player player) {
		
		PlayerInventory inventory = player.getInventory();
		
		// On met à jour l'arme
		
		// On prépare la liste de toutes les armes
		ItemStack weapon1= new ItemStack(Material.WOODEN_AXE);
		ItemMeta weaponMeta1 = weapon1.getItemMeta();
		weaponMeta1.setDisplayName("§6Hache du bougon");
		weaponMeta1.setLore(Arrays.asList("L'arme basique par excellence", "§3Pratique pour couper du bois"));
		weaponMeta1.setLocalizedName("weaponBerserker");
		weaponMeta1.setUnbreakable(true);
		weapon1.setItemMeta(weaponMeta1);
		weapon1.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		weapon1.addEnchantment(Enchantment.DAMAGE_ARTHROPODS, 1);
		weapon1.addEnchantment(Enchantment.DAMAGE_UNDEAD, 1);
		
		ItemStack weapon2= new ItemStack(Material.STONE_AXE);
		ItemMeta weaponMeta2 = weapon2.getItemMeta();
		weaponMeta2.setDisplayName("§6Hache du nonchalant");
		weaponMeta2.setLore(Arrays.asList("Une arme un peu émoussée, mais qui fait le taff", "§3Vos adversaires n'ont qu'à bien se tenir"));
		weaponMeta2.setLocalizedName("weaponBerserker");
		weaponMeta2.setUnbreakable(true);
		weapon2.setItemMeta(weaponMeta2);
		weapon2.addEnchantment(Enchantment.DAMAGE_ALL, 2);
		weapon2.addEnchantment(Enchantment.DAMAGE_ARTHROPODS, 2);
		weapon2.addEnchantment(Enchantment.DAMAGE_UNDEAD, 2);
		
		ItemStack weapon3= new ItemStack(Material.IRON_AXE);
		ItemMeta weaponMeta3 = weapon3.getItemMeta();
		weaponMeta3.setDisplayName("§6Hache du mécontentement");
		weaponMeta3.setLore(Arrays.asList("Enfin une arme correcte !", "§3Faites savoir que vous n'êtes pas de bonne humeur"));
		weaponMeta3.setLocalizedName("weaponBerserker");
		weaponMeta3.setUnbreakable(true);
		weapon3.setItemMeta(weaponMeta3);
		weapon3.addEnchantment(Enchantment.DAMAGE_ALL, 3);
		weapon3.addEnchantment(Enchantment.DAMAGE_ARTHROPODS, 3);
		weapon3.addEnchantment(Enchantment.DAMAGE_UNDEAD, 3);
		
		ItemStack weapon4= new ItemStack(Material.DIAMOND_AXE);
		ItemMeta weaponMeta4 = weapon4.getItemMeta();
		weaponMeta4.setDisplayName("§6Hache de la colère ultime");
		weaponMeta4.setLore(Arrays.asList("On ressent une haine profonde dans cette arme", "§3Si quelqu'un pense être plus fort que moi, qu'il vienne !"));
		weaponMeta4.setLocalizedName("weaponBerserker");
		weaponMeta4.setUnbreakable(true);
		weapon4.setItemMeta(weaponMeta4);
		weapon4.addEnchantment(Enchantment.DAMAGE_ALL, 4);
		weapon4.addEnchantment(Enchantment.DAMAGE_ARTHROPODS, 4);
		weapon4.addEnchantment(Enchantment.DAMAGE_UNDEAD, 4);
		
		ItemStack weapon5= new ItemStack(Material.NETHERITE_AXE);
		ItemMeta weaponMeta5 = weapon5.getItemMeta();
		weaponMeta5.setDisplayName("§6Hache de la fureur suprème");
		weaponMeta5.setLore(Arrays.asList("Une arme de destruction forgée dans le Nether", "§3Laissez vos pulsions s'exprimer"));
		weaponMeta5.setLocalizedName("weaponBerserker");
		weaponMeta5.setUnbreakable(true);
		weapon5.setItemMeta(weaponMeta5);
		weapon5.addEnchantment(Enchantment.DAMAGE_ALL, 5);
		weapon5.addEnchantment(Enchantment.DAMAGE_ARTHROPODS, 5);
		weapon5.addEnchantment(Enchantment.DAMAGE_UNDEAD, 5);
		
		// Suppression de l'ancienne arme et ajout de la nouvelle
		switch (getWeaponLvl()) {
		case 1:
			if (!inventory.contains(weapon1) && !inventory.getItemInOffHand().equals(weapon1)) inventory.addItem(weapon1);
			break;
			
		case 2:
			if (inventory.contains(weapon1)) inventory.setItem(inventory.first(weapon1), weapon2);
			if (inventory.getItemInOffHand().equals(weapon1)) inventory.setItemInOffHand(weapon2);
			break;
			
		case 3:
			if (inventory.contains(weapon2)) inventory.setItem(inventory.first(weapon2), weapon3);
			if (inventory.getItemInOffHand().equals(weapon2)) inventory.setItemInOffHand(weapon3);
			break;
			
		case 4:
			if (inventory.contains(weapon3)) inventory.setItem(inventory.first(weapon3), weapon4);
			if (inventory.getItemInOffHand().equals(weapon3)) inventory.setItemInOffHand(weapon4);
			break;
			
		case 5:
			if (inventory.contains(weapon4)) inventory.setItem(inventory.first(weapon4), weapon5);
			if (inventory.getItemInOffHand().equals(weapon4)) inventory.setItemInOffHand(weapon5);
			break;
			
		default:
		}
		
		// On met à jour l'armure
		
		// On prépare la liste de toutes les armures
		ItemStack chestplate1 = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemMeta chestplateMeta1 = chestplate1.getItemMeta();
		chestplateMeta1.setDisplayName("§6Plastron du bougon");
		chestplateMeta1.setLore(Arrays.asList("L'armure basique par excellence", "§3Tient plutôt chaud"));
		chestplateMeta1.setLocalizedName("chestplateBerserker");
		chestplateMeta1.setUnbreakable(true);
		chestplate1.setItemMeta(chestplateMeta1);
		chestplate1.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack chestplate2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemMeta chestplateMeta2 = chestplate2.getItemMeta();
		chestplateMeta2.setDisplayName("§6Plastron du nonchalant");
		chestplateMeta2.setLore(Arrays.asList("Une armure un peu émoussée, mais qui fait le taff", "§3Vous ressemblez à un chevalier avec ça"));
		chestplateMeta2.setLocalizedName("chestplateBerserker");
		chestplateMeta2.setUnbreakable(true);
		chestplate2.setItemMeta(chestplateMeta2);
		chestplate2.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack chestplate3 = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta chestplateMeta3 = chestplate3.getItemMeta();
		chestplateMeta3.setDisplayName("§6Plastron du mécontentement");
		chestplateMeta3.setLore(Arrays.asList("Enfin une armure correcte !", "§3Foncez au coeur de la bataille sans", "§3vous préoccuper des dégats reçus"));
		chestplateMeta3.setLocalizedName("chestplateBerserker");
		chestplateMeta3.setUnbreakable(true);
		chestplate3.setItemMeta(chestplateMeta3);
		chestplate3.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack helmet1 = new ItemStack(Material.LEATHER_HELMET);
		ItemMeta helmetMeta1 = helmet1.getItemMeta();
		helmetMeta1.setDisplayName("§6Casque du bougon");
		helmetMeta1.setLore(Arrays.asList("L'armure basique par excellence", "§3Tient plutôt chaud"));
		helmetMeta1.setLocalizedName("helmetBerserker");
		helmetMeta1.setUnbreakable(true);
		helmet1.setItemMeta(helmetMeta1);
		helmet1.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack helmet2 = new ItemStack(Material.CHAINMAIL_HELMET);
		ItemMeta helmetMeta2 = helmet2.getItemMeta();
		helmetMeta2.setDisplayName("§6Casque du nonchalant");
		helmetMeta2.setLore(Arrays.asList("Une armure un peu émoussée, mais qui fait le taff", "§3Vous ressemblez à un chevalier avec ça"));
		helmetMeta2.setLocalizedName("helmetBerserker");
		helmetMeta2.setUnbreakable(true);
		helmet2.setItemMeta(helmetMeta2);
		helmet2.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack helmet3 = new ItemStack(Material.IRON_HELMET);
		ItemMeta helmetMeta3 = helmet3.getItemMeta();
		helmetMeta3.setDisplayName("§6Casque du mécontentement");
		helmetMeta3.setLore(Arrays.asList("Enfin une armure correcte !", "§3Foncez au coeur de la bataille sans", "§3vous préoccuper des dégats reçus"));
		helmetMeta3.setLocalizedName("helmetBerserker");
		helmetMeta3.setUnbreakable(true);
		helmet3.setItemMeta(helmetMeta3);
		helmet3.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		// Suppression de l'ancienne armure et ajout de la nouvelle
		switch (getArmorLvl()) {
		case 1:
			if (!inventory.contains(chestplate1) && !inventory.getItemInOffHand().equals(chestplate1)) inventory.setChestplate(chestplate1);
			if (!inventory.contains(helmet1) && !inventory.getItemInOffHand().equals(helmet1)) inventory.setHelmet(helmet1);
			break;
			
		case 2:
			if (inventory.getChestplate().equals(chestplate1)) inventory.setChestplate(chestplate2);
			if (inventory.getHelmet().equals(helmet1)) inventory.setHelmet(helmet2);
			break;
			
		case 3:
			if (inventory.getChestplate().equals(chestplate2)) inventory.setChestplate(chestplate3);
			if (inventory.getHelmet().equals(helmet2)) inventory.setHelmet(helmet3);
			break;
			
		default:
		}
		
		// On met à jour les effets
		
		PotionEffect effect1 = new PotionEffect(PotionEffectType.NIGHT_VISION, 100000, 0, false, false);
		PotionEffect effect2 = new PotionEffect(PotionEffectType.JUMP, 100000, 1, false, false);
		
		switch (getEffectLvl()) {
		case 2:
			effect1.apply(player);
			break;

		case 3:
			effect2.apply(player);
			break;

		default:
		}
		
	}

	@Override
	public void openMenu(Player player) {
		
		Inventory inventory = Bukkit.createInventory(player, InventoryType.CHEST, "Menu d'amélioration de classe pour " + getClasseName());
		
		ItemStack weaponUp1 = new ItemStack(Material.STONE_AXE);
		ItemMeta weaponUpMeta1 = weaponUp1.getItemMeta();
		weaponUpMeta1.setDisplayName("§6Amélioration de l'arme");
		weaponUpMeta1.setLore(Arrays.asList("", "§aCoût : §710", "§fPayez avec vos niveaux pour", "§faméliorer votre arme"));
		weaponUpMeta1.setLocalizedName("weaponUp");
		weaponUp1.setItemMeta(weaponUpMeta1);
		
		ItemStack weaponUp2 = new ItemStack(Material.IRON_AXE);
		ItemMeta weaponUpMeta2 = weaponUp2.getItemMeta();
		weaponUpMeta2.setDisplayName("§6Amélioration de l'arme");
		weaponUpMeta2.setLore(Arrays.asList("", "§aCoût : §715", "§fPayez avec vos niveaux pour", "§faméliorer votre arme"));
		weaponUpMeta2.setLocalizedName("weaponUp");
		weaponUp2.setItemMeta(weaponUpMeta2);
		
		ItemStack weaponUp3 = new ItemStack(Material.DIAMOND_AXE);
		ItemMeta weaponUpMeta3 = weaponUp3.getItemMeta();
		weaponUpMeta3.setDisplayName("§6Amélioration de l'arme");
		weaponUpMeta3.setLore(Arrays.asList("", "§aCoût : §720", "§fPayez avec vos niveaux pour", "§faméliorer votre arme"));
		weaponUpMeta3.setLocalizedName("weaponUp");
		weaponUp3.setItemMeta(weaponUpMeta3);
		
		ItemStack weaponUp4 = new ItemStack(Material.NETHERITE_AXE);
		ItemMeta weaponUpMeta4 = weaponUp4.getItemMeta();
		weaponUpMeta4.setDisplayName("§6Amélioration de l'arme");
		weaponUpMeta4.setLore(Arrays.asList("", "§aCoût : §730", "§fPayez avec vos niveaux pour", "§faméliorer votre arme"));
		weaponUpMeta4.setLocalizedName("weaponUp");
		weaponUp4.setItemMeta(weaponUpMeta4);
		
		switch (getWeaponLvl()) {
		case 1:
			inventory.setItem(10, weaponUp1);
			break;

		case 2:
			inventory.setItem(10, weaponUp2);
			break;

		case 3:
			inventory.setItem(10, weaponUp3);
			break;

		case 4:
			inventory.setItem(10, weaponUp4);
			break;
			
		default:
		}
		
		ItemStack armorUp1 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemMeta armorUpMeta1 = armorUp1.getItemMeta();
		armorUpMeta1.setDisplayName("§6Amélioration de l'armure");
		armorUpMeta1.setLore(Arrays.asList("", "§aCoût : §710", "§fPayez avec vos niveaux pour", "§faméliorer votre armure"));
		armorUpMeta1.setLocalizedName("armorUp");
		armorUp1.setItemMeta(armorUpMeta1);
		
		ItemStack armorUp2 = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta armorUpMeta2 = armorUp2.getItemMeta();
		armorUpMeta2.setDisplayName("§6Amélioration de l'armure");
		armorUpMeta2.setLore(Arrays.asList("", "§aCoût : §715", "§fPayez avec vos niveaux pour", "§faméliorer votre armure"));
		armorUpMeta2.setLocalizedName("armorUp");
		armorUp2.setItemMeta(armorUpMeta2);
		
		ItemStack armorUp3 = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta armorUpMeta3 = armorUp3.getItemMeta();
		armorUpMeta3.setDisplayName("§6Amélioration de l'armure");
		armorUpMeta3.setLore(Arrays.asList("", "§aCoût : §720", "§fPayez avec vos niveaux pour", "§faméliorer votre armure"));
		armorUpMeta3.setLocalizedName("armorUp");
		armorUp3.setItemMeta(armorUpMeta3);
		
		switch (getArmorLvl()) {
		case 1:
			inventory.setItem(12, armorUp1);
			break;

		case 2:
			inventory.setItem(12, armorUp2);
			break;

		case 3:
			inventory.setItem(12, armorUp3);
			break;
			
		default:
		}
		
		ItemStack effectUp1 = new ItemStack(Material.POTION);
		PotionMeta effectUpMeta1 = (PotionMeta) effectUp1.getItemMeta();
		effectUpMeta1.setDisplayName("§dAmélioration des effets");
		effectUpMeta1.setLore(Arrays.asList("", "§aCoût : §720", "§fPayez avec vos niveaux pour", "§faméliorer vos effets", "§5Prochain effet : §cForce 1"));
		effectUpMeta1.setLocalizedName("effectUp");
		effectUp1.setItemMeta(effectUpMeta1);
		
		ItemStack effectUp2 = new ItemStack(Material.POTION);
		PotionMeta effectUpMeta2 = (PotionMeta) effectUp2.getItemMeta();
		PotionData potionData = new PotionData(PotionType.STRENGTH);
		effectUpMeta2.setBasePotionData(potionData);
		effectUpMeta2.setDisplayName("§dAmélioration des effets");
		effectUpMeta2.setLore(Arrays.asList("", "§aCoût : §730", "§fPayez avec vos niveaux pour", "§faméliorer vos effets", "§5Prochain effet : §cForce 2"));
		effectUpMeta2.setLocalizedName("effectUp");
		effectUp2.setItemMeta(effectUpMeta2);
		
		switch (getEffectLvl()) {
		case 1:
			inventory.setItem(14, effectUp1);
			break;

		case 2:
			inventory.setItem(14, effectUp2);
			break;
			
		default:
		}
		
		player.openInventory(inventory);
		
	}
	
}