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

public class Archer extends Classe {
	
	public Archer() {
		_classeName = "Archer";
		_maxHealth = 20;
		_weaponLvl = 1;
		_armorLvl = 1;
		_effectLvl = 1;
		_actifLvl = 1;
		_onCast = false;
		_onCooldown = false;
	}
	
	public Archer(int maxHealth, int weaponLvl, int armorLvl, int effectLvl, int actifLvl, boolean onCast, boolean onCooldown) {
		_classeName = "Archer";
		_maxHealth = maxHealth;
		_weaponLvl = weaponLvl;
		_armorLvl = armorLvl;
		_effectLvl = effectLvl;
		_actifLvl = actifLvl;
		_onCast = onCast;
		_onCooldown = onCooldown;
	}

	@Override
	public void updateStuff(Player player) {
		
		PlayerInventory inventory = player.getInventory();
		
		// On met à jour l'arme
		
		// On prépare la liste de toutes les armes
		ItemStack arrow = new ItemStack(Material.ARROW);
		
		ItemStack weapon1= new ItemStack(Material.BOW);
		ItemMeta weaponMeta1 = weapon1.getItemMeta();
		weaponMeta1.setDisplayName("§6Arc de chasse");
		weaponMeta1.setLore(Arrays.asList("L'arme basique par excellence", "§3Pratique pour chasser en forêt"));
		weaponMeta1.setLocalizedName("weaponArcher");
		weaponMeta1.setUnbreakable(true);
		weapon1.setItemMeta(weaponMeta1);
		weapon1.addEnchantment(Enchantment.ARROW_INFINITE, 1);
		weapon1.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
		
		ItemStack weapon2= new ItemStack(Material.BOW);
		ItemMeta weaponMeta2 = weapon2.getItemMeta();
		weaponMeta2.setDisplayName("§6Arc de tir");
		weaponMeta2.setLore(Arrays.asList("Une arme banale, mais qui fait le taff", "§3Vos adversaires n'ont qu'à bien se tenir"));
		weaponMeta2.setLocalizedName("weaponArcher");
		weaponMeta2.setUnbreakable(true);
		weapon2.setItemMeta(weaponMeta2);
		weapon2.addEnchantment(Enchantment.ARROW_INFINITE, 1);
		weapon2.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
		
		ItemStack weapon3= new ItemStack(Material.BOW);
		ItemMeta weaponMeta3 = weapon3.getItemMeta();
		weaponMeta3.setDisplayName("§6Arc de bonne augure");
		weaponMeta3.setLore(Arrays.asList("Enfin une arme correcte !", "§3Si vous êtes en danger, tirez !"));
		weaponMeta3.setLocalizedName("weaponArcher");
		weaponMeta3.setUnbreakable(true);
		weapon3.setItemMeta(weaponMeta3);
		weapon3.addEnchantment(Enchantment.ARROW_INFINITE, 1);
		weapon3.addEnchantment(Enchantment.ARROW_DAMAGE, 3);
		
		ItemStack weapon4= new ItemStack(Material.BOW);
		ItemMeta weaponMeta4 = weapon4.getItemMeta();
		weaponMeta4.setDisplayName("§6Arc du trésor perdu");
		weaponMeta4.setLore(Arrays.asList("Une relique perdue depuis plusieurs siècles", "§3Vos tirs sont plus précis que jamais"));
		weaponMeta4.setLocalizedName("weaponArcher");
		weaponMeta4.setUnbreakable(true);
		weapon4.setItemMeta(weaponMeta4);
		weapon4.addEnchantment(Enchantment.ARROW_INFINITE, 1);
		weapon4.addEnchantment(Enchantment.ARROW_DAMAGE, 4);
		weapon4.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
		
		ItemStack weapon5= new ItemStack(Material.BOW);
		ItemMeta weaponMeta5 = weapon5.getItemMeta();
		weaponMeta5.setDisplayName("§6Arc de la destiné");
		weaponMeta5.setLore(Arrays.asList("Une arme légendaire insufflée de magie", "§3Vos tirs atteignent toujours la cible"));
		weaponMeta5.setLocalizedName("weaponArcher");
		weaponMeta5.setUnbreakable(true);
		weapon5.setItemMeta(weaponMeta5);
		weapon5.addEnchantment(Enchantment.ARROW_INFINITE, 1);
		weapon5.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
		weapon5.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
		weapon5.addEnchantment(Enchantment.ARROW_FIRE, 1);
		
		// Suppression de l'ancienne arme et ajout de la nouvelle
		switch (getWeaponLvl()) {
		case 1:
			if (!inventory.contains(weapon1) && !inventory.getItemInOffHand().equals(weapon1)) inventory.addItem(weapon1);
			if(!inventory.contains(arrow) && !inventory.getItemInOffHand().equals(arrow)) inventory.addItem(arrow);
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
		ItemStack leggings1 = new ItemStack(Material.LEATHER_LEGGINGS);
		ItemMeta leggingsMeta1 = leggings1.getItemMeta();
		leggingsMeta1.setDisplayName("§6Pantalon de chasse");
		leggingsMeta1.setLore(Arrays.asList("L'armure basique par excellence", "§3Tient plutôt chaud"));
		leggingsMeta1.setLocalizedName("leggingsArcher");
		leggingsMeta1.setUnbreakable(true);
		leggings1.setItemMeta(leggingsMeta1);
		leggings1.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack leggings2 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		ItemMeta leggingsMeta2 = leggings2.getItemMeta();
		leggingsMeta2.setDisplayName("§6Pantalon de tir");
		leggingsMeta2.setLore(Arrays.asList("Une armure un peu émoussée, mais qui fait le taff", "§3Vous ressemblez à un chevalier avec ça"));
		leggingsMeta2.setLocalizedName("leggingsArcher");
		leggingsMeta2.setUnbreakable(true);
		leggings2.setItemMeta(leggingsMeta2);
		leggings2.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack leggings3 = new ItemStack(Material.IRON_LEGGINGS);
		ItemMeta leggingsMeta3 = leggings3.getItemMeta();
		leggingsMeta3.setDisplayName("§6Pantalon de bonne augure");
		leggingsMeta3.setLore(Arrays.asList("Enfin une armure correcte !", "§3Foncez au coeur de la bataille sans", "§3vous préoccuper des dégats reçus"));
		leggingsMeta3.setLocalizedName("leggingsArcher");
		leggingsMeta3.setUnbreakable(true);
		leggings3.setItemMeta(leggingsMeta3);
		leggings3.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack helmet1 = new ItemStack(Material.LEATHER_HELMET);
		ItemMeta helmetMeta1 = helmet1.getItemMeta();
		helmetMeta1.setDisplayName("§6Casque de chasse");
		helmetMeta1.setLore(Arrays.asList("L'armure basique par excellence", "§3Tient plutôt chaud"));
		helmetMeta1.setLocalizedName("helmetArcher");
		helmetMeta1.setUnbreakable(true);
		helmet1.setItemMeta(helmetMeta1);
		helmet1.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack helmet2 = new ItemStack(Material.CHAINMAIL_HELMET);
		ItemMeta helmetMeta2 = helmet2.getItemMeta();
		helmetMeta2.setDisplayName("§6Casque de tir");
		helmetMeta2.setLore(Arrays.asList("Une armure un peu émoussée, mais qui fait le taff", "§3Vous ressemblez à un chevalier avec ça"));
		helmetMeta2.setLocalizedName("helmetArcher");
		helmetMeta2.setUnbreakable(true);
		helmet2.setItemMeta(helmetMeta2);
		helmet2.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack helmet3 = new ItemStack(Material.IRON_HELMET);
		ItemMeta helmetMeta3 = helmet3.getItemMeta();
		helmetMeta3.setDisplayName("§6Casque de bonne augure");
		helmetMeta3.setLore(Arrays.asList("Enfin une armure correcte !", "§3Foncez au coeur de la bataille sans", "§3vous préoccuper des dégats reçus"));
		helmetMeta3.setLocalizedName("helmetArcher");
		helmetMeta3.setUnbreakable(true);
		helmet3.setItemMeta(helmetMeta3);
		helmet3.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		// Suppression de l'ancienne armure et ajout de la nouvelle
		switch (getArmorLvl()) {
		case 1:
			if (!inventory.contains(leggings1) && !inventory.getItemInOffHand().equals(leggings1)) inventory.setLeggings(leggings1);
			if (!inventory.contains(helmet1) && !inventory.getItemInOffHand().equals(helmet1)) inventory.setHelmet(helmet1);
			break;
			
		case 2:
			if (inventory.getLeggings().equals(leggings1)) inventory.setLeggings(leggings2);
			if (inventory.getHelmet().equals(helmet1)) inventory.setHelmet(helmet2);
			break;
			
		case 3:
			if (inventory.getLeggings().equals(leggings2)) inventory.setLeggings(leggings3);
			if (inventory.getHelmet().equals(helmet2)) inventory.setHelmet(helmet3);
			break;
			
		default:
		}
		
		// On met à jour les effets
		
		PotionEffect effect1 = new PotionEffect(PotionEffectType.SPEED, 100000, 0, false, false);
		PotionEffect effect2 = new PotionEffect(PotionEffectType.SPEED, 100000, 1, false, false);
		
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
		
		Inventory inventory = Bukkit.createInventory(player, InventoryType.CHEST, "Menu d'amélioration de classe");
		
		ItemStack weaponUp1 = new ItemStack(Material.BOW);
		ItemMeta weaponUpMeta1 = weaponUp1.getItemMeta();
		weaponUpMeta1.setDisplayName("§6Amélioration de l'arme");
		weaponUpMeta1.setLore(Arrays.asList("", "§aCoût : §710", "§fPayez avec vos niveaux pour", "§faméliorer votre arme"));
		weaponUpMeta1.setLocalizedName("weaponUp");
		weaponUp1.setItemMeta(weaponUpMeta1);
		
		ItemStack weaponUp2 = new ItemStack(Material.BOW);
		ItemMeta weaponUpMeta2 = weaponUp2.getItemMeta();
		weaponUpMeta2.setDisplayName("§6Amélioration de l'arme");
		weaponUpMeta2.setLore(Arrays.asList("", "§aCoût : §715", "§fPayez avec vos niveaux pour", "§faméliorer votre arme"));
		weaponUpMeta2.setLocalizedName("weaponUp");
		weaponUp2.setItemMeta(weaponUpMeta2);
		
		ItemStack weaponUp3 = new ItemStack(Material.BOW);
		ItemMeta weaponUpMeta3 = weaponUp3.getItemMeta();
		weaponUpMeta3.setDisplayName("§6Amélioration de l'arme");
		weaponUpMeta3.setLore(Arrays.asList("", "§aCoût : §720", "§fPayez avec vos niveaux pour", "§faméliorer votre arme"));
		weaponUpMeta3.setLocalizedName("weaponUp");
		weaponUp3.setItemMeta(weaponUpMeta3);
		
		ItemStack weaponUp4 = new ItemStack(Material.BOW);
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
		effectUpMeta2.setLore(Arrays.asList("", "§aCoût : §720", "§fPayez avec vos niveaux pour", "§faméliorer vos effets", "§5Prochain effet : §cSpeed 2"));
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
		actifUpMeta1.setDisplayName("§bAmélioration du pouvoir");
		actifUpMeta1.setLore(Arrays.asList("", "§aCoût : §715", "§fPayez avec vos niveaux pour", "§faméliorer votre pouvoir"));
		actifUpMeta1.setLocalizedName("actifUp");
		actifUp1.setItemMeta(actifUpMeta1);
		
		ItemStack actifUp2 = new ItemStack(Material.FEATHER);
		ItemMeta actifUpMeta2 = actifUp2.getItemMeta();
		actifUpMeta2.setDisplayName("§bAmélioration du pouvoir");
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

	@Override
	public void runActivable(Player player) {
		// TODO Auto-generated method stub
		
	}
	
}