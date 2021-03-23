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

public class Triton extends Classe {
	
	public Triton() {
		
		_classeName = "Triton";
		_maxHealth = 20;
		_weaponLvl = 1;
		_armorLvl = 1;
		_effectLvl = 1;
		_actifLvl = 1;
		_onCast = false;
		_onCooldown = false;
	}
	
	public Triton(int maxHealth, int weaponLvl, int armorLvl, int effectLvl, int actifLvl, boolean onCast, boolean onCooldown) {
		
		_classeName = "Triton";
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
		ItemStack weapon1= new ItemStack(Material.TRIDENT);
		ItemMeta weaponMeta1 = weapon1.getItemMeta();
		weaponMeta1.setDisplayName("§6Trident du pêcheur");
		weaponMeta1.setLore(Arrays.asList("L'arme basique par excellence", "§3Pratique pour pêcher"));
		weaponMeta1.setLocalizedName("weaponTriton");
		weaponMeta1.setUnbreakable(true);
		weapon1.setItemMeta(weaponMeta1);
		weapon1.addEnchantment(Enchantment.LOYALTY, 1);
		weapon1.addEnchantment(Enchantment.IMPALING, 1);
		
		ItemStack weapon2= new ItemStack(Material.TRIDENT);
		ItemMeta weaponMeta2 = weapon2.getItemMeta();
		weaponMeta2.setDisplayName("§6Trident du marin");
		weaponMeta2.setLore(Arrays.asList("Une arme un peu émoussée, mais qui fait le taff", "§3À vos ordres capitaine !"));
		weaponMeta2.setLocalizedName("weaponTriton");
		weaponMeta2.setUnbreakable(true);
		weapon2.setItemMeta(weaponMeta2);
		weapon2.addEnchantment(Enchantment.LOYALTY, 1);
		weapon2.addEnchantment(Enchantment.IMPALING, 2);
		
		ItemStack weapon3= new ItemStack(Material.TRIDENT);
		ItemMeta weaponMeta3 = weapon3.getItemMeta();
		weaponMeta3.setDisplayName("§6Trident du pirate");
		weaponMeta3.setLore(Arrays.asList("Enfin une arme correcte !", "§3La chasse aux trésors peut commencer"));
		weaponMeta3.setLocalizedName("weaponTriton");
		weaponMeta3.setUnbreakable(true);
		weapon3.setItemMeta(weaponMeta3);
		weapon3.addEnchantment(Enchantment.LOYALTY, 2);
		weapon3.addEnchantment(Enchantment.IMPALING, 3);
		
		ItemStack weapon4= new ItemStack(Material.TRIDENT);
		ItemMeta weaponMeta4 = weapon4.getItemMeta();
		weaponMeta4.setDisplayName("§6Trident de la vague destructrice");
		weaponMeta4.setLore(Arrays.asList("Vous contrôlez la magie de la mer", "§3Surfez sur vos ennemis"));
		weaponMeta4.setLocalizedName("weaponTriton");
		weaponMeta4.setUnbreakable(true);
		weapon4.setItemMeta(weaponMeta4);
		weapon4.addEnchantment(Enchantment.LOYALTY, 2);
		weapon4.addEnchantment(Enchantment.IMPALING, 4);
		
		ItemStack weapon5= new ItemStack(Material.TRIDENT);
		ItemMeta weaponMeta5 = weapon5.getItemMeta();
		weaponMeta5.setDisplayName("§6Trident du tsunami ravageur");
		weaponMeta5.setLore(Arrays.asList("Une arme ultra puissante créée par Poséidon", "§3L'océan n'a plus de secret pour vous"));
		weaponMeta5.setLocalizedName("weaponTriton");
		weaponMeta5.setUnbreakable(true);
		weapon5.setItemMeta(weaponMeta5);
		weapon5.addEnchantment(Enchantment.LOYALTY, 3);
		weapon5.addEnchantment(Enchantment.IMPALING, 5);
		weapon5.addEnchantment(Enchantment.CHANNELING, 1);
		
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
		ItemStack boots1 = new ItemStack(Material.LEATHER_BOOTS);
		ItemMeta bootsMeta1 = boots1.getItemMeta();
		bootsMeta1.setDisplayName("§6Bottes du pêcheur");
		bootsMeta1.setLore(Arrays.asList("L'armure basique par excellence", "§3Tient plutôt chaud"));
		bootsMeta1.setLocalizedName("bootsTriton");
		bootsMeta1.setUnbreakable(true);
		boots1.setItemMeta(bootsMeta1);
		boots1.addEnchantment(Enchantment.DEPTH_STRIDER, 1);
		boots1.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack boots2 = new ItemStack(Material.CHAINMAIL_BOOTS);
		ItemMeta bootsMeta2 = boots2.getItemMeta();
		bootsMeta2.setDisplayName("§6Bottes du marin");
		bootsMeta2.setLore(Arrays.asList("Une armure un peu émoussée, mais qui fait le taff", "§3Vous ressemblez à un chevalier avec ça"));
		bootsMeta2.setLocalizedName("bootsTriton");
		bootsMeta2.setUnbreakable(true);
		boots2.setItemMeta(bootsMeta2);
		boots2.addEnchantment(Enchantment.DEPTH_STRIDER, 2);
		boots2.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack boots3 = new ItemStack(Material.IRON_BOOTS);
		ItemMeta bootsMeta3 = boots3.getItemMeta();
		bootsMeta3.setDisplayName("§6Bottes du pirate");
		bootsMeta3.setLore(Arrays.asList("Enfin une armure correcte !", "§3Foncez au coeur de la bataille sans", "§3vous préoccuper des dégats reçus"));
		bootsMeta3.setLocalizedName("bootsTriton");
		bootsMeta3.setUnbreakable(true);
		boots3.setItemMeta(bootsMeta3);
		boots3.addEnchantment(Enchantment.DEPTH_STRIDER, 3);
		boots3.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack helmet1 = new ItemStack(Material.LEATHER_HELMET);
		ItemMeta helmetMeta1 = helmet1.getItemMeta();
		helmetMeta1.setDisplayName("§6Casque du pêcheur");
		helmetMeta1.setLore(Arrays.asList("L'armure basique par excellence", "§3Tient plutôt chaud"));
		helmetMeta1.setLocalizedName("helmetTriton");
		helmetMeta1.setUnbreakable(true);
		helmet1.setItemMeta(helmetMeta1);
		helmet1.addEnchantment(Enchantment.OXYGEN, 1);
		helmet1.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack helmet2 = new ItemStack(Material.CHAINMAIL_HELMET);
		ItemMeta helmetMeta2 = helmet2.getItemMeta();
		helmetMeta2.setDisplayName("§6Casque du marin");
		helmetMeta2.setLore(Arrays.asList("Une armure un peu émoussée, mais qui fait le taff", "§3Vous ressemblez à un chevalier avec ça"));
		helmetMeta2.setLocalizedName("helmetTriton");
		helmetMeta2.setUnbreakable(true);
		helmet2.setItemMeta(helmetMeta2);
		helmet2.addEnchantment(Enchantment.OXYGEN, 2);
		helmet2.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack helmet3 = new ItemStack(Material.IRON_HELMET);
		ItemMeta helmetMeta3 = helmet3.getItemMeta();
		helmetMeta3.setDisplayName("§6Casque du pirate");
		helmetMeta3.setLore(Arrays.asList("Enfin une armure correcte !", "§3Foncez au coeur de la bataille sans", "§3vous préoccuper des dégats reçus"));
		helmetMeta3.setLocalizedName("helmetTriton");
		helmetMeta3.setUnbreakable(true);
		helmet3.setItemMeta(helmetMeta3);
		helmet3.addEnchantment(Enchantment.OXYGEN, 3);
		helmet3.addEnchantment(Enchantment.WATER_WORKER, 1);
		helmet3.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		// Suppression de l'ancienne armure et ajout de la nouvelle
		switch (getArmorLvl()) {
		case 1:
			if (!inventory.contains(boots1) && !inventory.getItemInOffHand().equals(boots1)) inventory.setBoots(boots1);
			if (!inventory.contains(helmet1) && !inventory.getItemInOffHand().equals(helmet1)) inventory.setHelmet(helmet1);
			break;
			
		case 2:
			if (inventory.getBoots().equals(boots1)) inventory.setBoots(boots2);
			if (inventory.getHelmet().equals(helmet1)) inventory.setHelmet(helmet2);
			break;
			
		case 3:
			if (inventory.getBoots().equals(boots2)) inventory.setBoots(boots3);
			if (inventory.getHelmet().equals(helmet2)) inventory.setHelmet(helmet3);
			break;
			
		default:
		}
		
		// On met à jour les effets
		
		PotionEffect effect1 = new PotionEffect(PotionEffectType.LUCK, 100000, 0, false, false);
		PotionEffect effect2 = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100000, 0, false, false);
		
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
		
		ItemStack weaponUp1 = new ItemStack(Material.TRIDENT);
		ItemMeta weaponUpMeta1 = weaponUp1.getItemMeta();
		weaponUpMeta1.setDisplayName("§6Amélioration de l'arme");
		weaponUpMeta1.setLore(Arrays.asList("", "§aCoût : §710", "§fPayez avec vos niveaux pour", "§faméliorer votre arme"));
		weaponUpMeta1.setLocalizedName("weaponUp");
		weaponUp1.setItemMeta(weaponUpMeta1);
		
		ItemStack weaponUp2 = new ItemStack(Material.TRIDENT);
		ItemMeta weaponUpMeta2 = weaponUp2.getItemMeta();
		weaponUpMeta2.setDisplayName("§6Amélioration de l'arme");
		weaponUpMeta2.setLore(Arrays.asList("", "§aCoût : §715", "§fPayez avec vos niveaux pour", "§faméliorer votre arme"));
		weaponUpMeta2.setLocalizedName("weaponUp");
		weaponUp2.setItemMeta(weaponUpMeta2);
		
		ItemStack weaponUp3 = new ItemStack(Material.TRIDENT);
		ItemMeta weaponUpMeta3 = weaponUp3.getItemMeta();
		weaponUpMeta3.setDisplayName("§6Amélioration de l'arme");
		weaponUpMeta3.setLore(Arrays.asList("", "§aCoût : §720", "§fPayez avec vos niveaux pour", "§faméliorer votre arme"));
		weaponUpMeta3.setLocalizedName("weaponUp");
		weaponUp3.setItemMeta(weaponUpMeta3);
		
		ItemStack weaponUp4 = new ItemStack(Material.TRIDENT);
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
		effectUpMeta1.setLore(Arrays.asList("", "§aCoût : §715", "§fPayez avec vos niveaux pour", "§faméliorer vos effets", "§5Prochain effet : §cLuck"));
		effectUpMeta1.setLocalizedName("effectUp");
		effectUp1.setItemMeta(effectUpMeta1);
		
		ItemStack effectUp2 = new ItemStack(Material.POTION);
		PotionMeta effectUpMeta2 = (PotionMeta) effectUp2.getItemMeta();
		PotionData potionData = new PotionData(PotionType.LUCK);
		effectUpMeta2.setBasePotionData(potionData);
		effectUpMeta2.setDisplayName("§dAmélioration des effets");
		effectUpMeta2.setLore(Arrays.asList("", "§aCoût : §720", "§fPayez avec vos niveaux pour", "§faméliorer vos effets", "§5Prochain effet : §cRésistance 1"));
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