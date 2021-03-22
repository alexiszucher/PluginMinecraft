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

public class Assassin extends Classe {
	
	public Assassin() {
		
		_classeName = "Assassin";
		_maxHealth = 20;
		_weaponLvl = 1;
		_armorLvl = 1;
		_effectLvl = 1;		
	}
	
	public Assassin(int maxHealth, int weaponLvl, int armorLvl, int effectLvl) {
		
		_classeName = "Assassin";
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
		ItemStack weapon1= new ItemStack(Material.WOODEN_SWORD);
		ItemMeta weaponMeta1 = weapon1.getItemMeta();
		weaponMeta1.setDisplayName("§6Lame du gothique");
		weaponMeta1.setLore(Arrays.asList("L'arme basique par excellence", "§3Une petite lame tranchante assez banale"));
		weaponMeta1.setLocalizedName("weaponAssassin");
		weaponMeta1.setUnbreakable(true);
		weapon1.setItemMeta(weaponMeta1);
		
		ItemStack weapon2= new ItemStack(Material.STONE_SWORD);
		ItemMeta weaponMeta2 = weapon2.getItemMeta();
		weaponMeta2.setDisplayName("§6Lame ");
		weaponMeta2.setLore(Arrays.asList("Une arme un peu émoussée, mais qui fait le taff", "§3Vos adversaires n'ont qu'à bien se tenir"));
		weaponMeta2.setLocalizedName("weaponAssassin");
		weaponMeta2.setUnbreakable(true);
		weapon2.setItemMeta(weaponMeta2);
		weapon2.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		
		ItemStack weapon3= new ItemStack(Material.IRON_SWORD);
		ItemMeta weaponMeta3 = weapon3.getItemMeta();
		weaponMeta3.setDisplayName("§6Lame lunaire");
		weaponMeta3.setLore(Arrays.asList("Enfin une arme correcte !", "§3Faufilez vous tel un ninja, et ne vous faites pas repérer"));
		weaponMeta3.setLocalizedName("weaponAssassin");
		weaponMeta3.setUnbreakable(true);
		weapon3.setItemMeta(weaponMeta3);
		weapon3.addEnchantment(Enchantment.DAMAGE_ALL, 2);
		weapon3.addEnchantment(Enchantment.SWEEPING_EDGE, 1);
		weapon3.addEnchantment(Enchantment.LOOT_BONUS_MOBS, 1);
		
		ItemStack weapon4= new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta weaponMeta4 = weapon4.getItemMeta();
		weaponMeta4.setDisplayName("§6Lame du soldat obscure");
		weaponMeta4.setLore(Arrays.asList("Ce katana peut découper presque tout", "§3Je mettrais ma main à couper qu'il", "a appartenu à un samouraï"));
		weaponMeta4.setLocalizedName("weaponAssassin");
		weaponMeta4.setUnbreakable(true);
		weapon4.setItemMeta(weaponMeta4);
		weapon4.addEnchantment(Enchantment.DAMAGE_ALL, 2);
		weapon4.addEnchantment(Enchantment.SWEEPING_EDGE, 2);
		weapon4.addEnchantment(Enchantment.LOOT_BONUS_MOBS, 2);
		
		ItemStack weapon5= new ItemStack(Material.NETHERITE_SWORD);
		ItemMeta weaponMeta5 = weapon5.getItemMeta();
		weaponMeta5.setDisplayName("§6Lame des ombres sanglantes");
		weaponMeta5.setLore(Arrays.asList("Une lame imprégnée des ténèbres", "§3Vos victimes n'auront pas le temps de souffir"));
		weaponMeta5.setLocalizedName("weaponAssassin");
		weaponMeta5.setUnbreakable(true);
		weapon5.setItemMeta(weaponMeta5);
		weapon5.addEnchantment(Enchantment.DAMAGE_ALL, 3);
		weapon5.addEnchantment(Enchantment.SWEEPING_EDGE, 3);
		weapon5.addEnchantment(Enchantment.LOOT_BONUS_MOBS, 3);
		weapon5.addEnchantment(Enchantment.KNOCKBACK, 1);
		
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
		chestplateMeta1.setDisplayName("§6Plastron de bûcheron");
		chestplateMeta1.setLore(Arrays.asList("L'armure basique par excellence", "§3Tient plutôt chaud"));
		chestplateMeta1.setLocalizedName("chestplateAssassin");
		chestplateMeta1.setUnbreakable(true);
		chestplate1.setItemMeta(chestplateMeta1);
		chestplate1.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack chestplate2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemMeta chestplateMeta2 = chestplate2.getItemMeta();
		chestplateMeta2.setDisplayName("§6Plastron du bougon");
		chestplateMeta2.setLore(Arrays.asList("Une armure un peu émoussée, mais qui fait le taff", "§3Vous ressemblez à un chevalier avec ça"));
		chestplateMeta2.setLocalizedName("chestplateAssassin");
		chestplateMeta2.setUnbreakable(true);
		chestplate2.setItemMeta(chestplateMeta2);
		chestplate2.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack chestplate3 = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta chestplateMeta3 = chestplate3.getItemMeta();
		chestplateMeta3.setDisplayName("§6Plastron du mécontentement");
		chestplateMeta3.setLore(Arrays.asList("Enfin une armure correcte !", "§3Foncez au coeur de la bataille sans", "§3vous préoccuper des dégats reçus"));
		chestplateMeta3.setLocalizedName("chestplateAssassin");
		chestplateMeta3.setUnbreakable(true);
		chestplate3.setItemMeta(chestplateMeta3);
		chestplate3.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack boots1 = new ItemStack(Material.LEATHER_BOOTS);
		ItemMeta bootsMeta1 = boots1.getItemMeta();
		bootsMeta1.setDisplayName("§6Casque de bûcheron");
		bootsMeta1.setLore(Arrays.asList("L'armure basique par excellence", "§3Tient plutôt chaud"));
		bootsMeta1.setLocalizedName("bootsAssassin");
		bootsMeta1.setUnbreakable(true);
		boots1.setItemMeta(bootsMeta1);
		boots1.addEnchantment(Enchantment.SOUL_SPEED, 1);
		boots1.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack boots2 = new ItemStack(Material.CHAINMAIL_BOOTS);
		ItemMeta bootsMeta2 = boots2.getItemMeta();
		bootsMeta2.setDisplayName("§6Casque du bougon");
		bootsMeta2.setLore(Arrays.asList("Une armure un peu émoussée, mais qui fait le taff", "§3Vous ressemblez à un chevalier avec ça"));
		bootsMeta2.setLocalizedName("bootsAssassin");
		bootsMeta2.setUnbreakable(true);
		boots2.setItemMeta(bootsMeta2);
		boots2.addEnchantment(Enchantment.SOUL_SPEED, 2);
		boots2.addEnchantment(Enchantment.FROST_WALKER, 1);
		boots2.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack boots3 = new ItemStack(Material.IRON_BOOTS);
		ItemMeta bootsMeta3 = boots3.getItemMeta();
		bootsMeta3.setDisplayName("§6Casque du mécontentement");
		bootsMeta3.setLore(Arrays.asList("Enfin une armure correcte !", "§3Foncez au coeur de la bataille sans", "§3vous préoccuper des dégats reçus"));
		bootsMeta3.setLocalizedName("bootsAssassin");
		bootsMeta3.setUnbreakable(true);
		boots3.setItemMeta(bootsMeta3);
		boots3.addEnchantment(Enchantment.SOUL_SPEED, 3);
		boots3.addEnchantment(Enchantment.FROST_WALKER, 2);
		boots3.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		// Suppression de l'ancienne armure et ajout de la nouvelle
		switch (getArmorLvl()) {
		case 1:
			if (!inventory.contains(chestplate1) && !inventory.getItemInOffHand().equals(chestplate1)) inventory.setChestplate(chestplate1);
			if (!inventory.contains(boots1) && !inventory.getItemInOffHand().equals(boots1)) inventory.setBoots(boots1);
			break;
			
		case 2:
			if (inventory.getChestplate().equals(chestplate1)) inventory.setChestplate(chestplate2);
			if (inventory.getBoots().equals(boots1)) inventory.setBoots(boots2);
			break;
			
		case 3:
			if (inventory.getChestplate().equals(chestplate2)) inventory.setChestplate(chestplate3);
			if (inventory.getBoots().equals(boots2)) inventory.setBoots(boots3);
			break;
			
		default:
		}
		
		// On met à jour les effets
		
		PotionEffect effect1 = new PotionEffect(PotionEffectType.SPEED, 100000, 0, false, false);
		PotionEffect effect2 = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100000, 0, false, false);
		
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
		
		ItemStack weaponUp1 = new ItemStack(Material.STONE_SWORD);
		ItemMeta weaponUpMeta1 = weaponUp1.getItemMeta();
		weaponUpMeta1.setDisplayName("§6Amélioration de l'arme");
		weaponUpMeta1.setLore(Arrays.asList("", "§aCoût : §710", "§fPayez avec vos niveaux pour", "§faméliorer votre arme"));
		weaponUpMeta1.setLocalizedName("weaponUp");
		weaponUp1.setItemMeta(weaponUpMeta1);
		
		ItemStack weaponUp2 = new ItemStack(Material.IRON_SWORD);
		ItemMeta weaponUpMeta2 = weaponUp2.getItemMeta();
		weaponUpMeta2.setDisplayName("§6Amélioration de l'arme");
		weaponUpMeta2.setLore(Arrays.asList("", "§aCoût : §715", "§fPayez avec vos niveaux pour", "§faméliorer votre arme"));
		weaponUpMeta2.setLocalizedName("weaponUp");
		weaponUp2.setItemMeta(weaponUpMeta2);
		
		ItemStack weaponUp3 = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta weaponUpMeta3 = weaponUp3.getItemMeta();
		weaponUpMeta3.setDisplayName("§6Amélioration de l'arme");
		weaponUpMeta3.setLore(Arrays.asList("", "§aCoût : §720", "§fPayez avec vos niveaux pour", "§faméliorer votre arme"));
		weaponUpMeta3.setLocalizedName("weaponUp");
		weaponUp3.setItemMeta(weaponUpMeta3);
		
		ItemStack weaponUp4 = new ItemStack(Material.NETHERITE_SWORD);
		ItemMeta weaponUpMeta4 = weaponUp4.getItemMeta();
		weaponUpMeta4.setDisplayName("§6Amélioration de l'arme");
		weaponUpMeta4.setLore(Arrays.asList("", "§aCoût : §730", "§fPayez avec vos niveaux pour", "§faméliorer votre arme"));
		weaponUpMeta4.setLocalizedName("weaponUp");
		weaponUp4.setItemMeta(weaponUpMeta4);
		
		switch (getWeaponLvl()) {
		case 1:
			inventory.setItem(0, weaponUp1);
			break;

		case 2:
			inventory.setItem(0, weaponUp2);
			break;

		case 3:
			inventory.setItem(0, weaponUp3);
			break;

		case 4:
			inventory.setItem(0, weaponUp4);
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
		
		switch (getArmorLvl()) {
		case 1:
			inventory.setItem(18, armorUp1);
			break;

		case 2:
			inventory.setItem(18, armorUp2);
			break;
			
		default:
		}
		
		ItemStack effectUp1 = new ItemStack(Material.POTION);
		PotionMeta effectUpMeta1 = (PotionMeta) effectUp1.getItemMeta();
		effectUpMeta1.setDisplayName("§dAmélioration des effets");
		effectUpMeta1.setLore(Arrays.asList("", "§aCoût : §715", "§fPayez avec vos niveaux pour", "§faméliorer vos effets", "§5Prochain effet : §cSpeed 1"));
		effectUpMeta1.setLocalizedName("effectUp");
		effectUp1.setItemMeta(effectUpMeta1);
		
		ItemStack effectUp2 = new ItemStack(Material.POTION);
		PotionMeta effectUpMeta2 = (PotionMeta) effectUp2.getItemMeta();
		PotionData potionData = new PotionData(PotionType.SPEED);
		effectUpMeta2.setBasePotionData(potionData);
		effectUpMeta2.setDisplayName("§dAmélioration des effets");
		effectUpMeta2.setLore(Arrays.asList("", "§aCoût : §720", "§fPayez avec vos niveaux pour", "§faméliorer vos effets", "§5Prochain effet : §cForce 1"));
		effectUpMeta2.setLocalizedName("effectUp");
		effectUp2.setItemMeta(effectUpMeta2);
		
		switch (getEffectLvl()) {
		case 1:
			inventory.setItem(8, effectUp1);
			break;

		case 2:
			inventory.setItem(8, effectUp2);
			break;
			
		default:
		}
		
		ItemStack actifUp1 = new ItemStack(Material.FEATHER);
		ItemMeta actifUpMeta1 = actifUp1.getItemMeta();
		actifUpMeta1.setDisplayName("§6Amélioration du pouvoir");
		actifUpMeta1.setLore(Arrays.asList("", "§aCoût : §715", "§fPayez avec vos niveaux pour", "§faméliorer votre pouvoir"));
		actifUpMeta1.setLocalizedName("actifUp");
		actifUp1.setItemMeta(actifUpMeta1);
		
		ItemStack actifUp2 = new ItemStack(Material.FEATHER);
		ItemMeta actifUpMeta2 = actifUp2.getItemMeta();
		actifUpMeta2.setDisplayName("§6Amélioration du pouvoir");
		actifUpMeta2.setLore(Arrays.asList("", "§aCoût : §720", "§fPayez avec vos niveaux pour", "§faméliorer votre pouvoir"));
		actifUpMeta2.setLocalizedName("actifUp");
		actifUp2.setItemMeta(actifUpMeta2);
		
		switch (getActifLvl()) {
		case 1:
			inventory.setItem(26, actifUp1);
			break;

		case 2:
			inventory.setItem(26, actifUp2);
			break;
			
		default:
		}
		
		player.openInventory(inventory);
		
	}
	
}