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

public class Paladin extends Classe {
	
	public Paladin() {
		_classeName = "Paladin";
		_maxHealth = 28;
		_weaponLvl = 1;
		_armorLvl = 1;
		_effectLvl = 1;
		_actifLvl = 1;
		_onCast = false;
		_onCooldown = false;
	}
	
	public Paladin(int maxHealth, int weaponLvl, int armorLvl, int effectLvl, int actifLvl, boolean onCast, boolean onCooldown) {
		_classeName = "Paladin";
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
		ItemStack shield= new ItemStack(Material.SHIELD);
		ItemMeta shieldMeta = shield.getItemMeta();
		shieldMeta.setDisplayName("§6Bouclier impénétrable");
		shieldMeta.setLore(Arrays.asList("Un bouclier en bois mais très résistant", "§3Les enfants aiment jouer avec"));
		shieldMeta.setLocalizedName("shieldPaladin");
		shieldMeta.setUnbreakable(true);
		shield.setItemMeta(shieldMeta);
		
		ItemStack weapon1= new ItemStack(Material.WOODEN_SWORD);
		ItemMeta weaponMeta1 = weapon1.getItemMeta();
		weaponMeta1.setDisplayName("§6Épée de l'optimiste");
		weaponMeta1.setLore(Arrays.asList("L'arme basique par excellence", "§3Les enfants aiment jouer avec"));
		weaponMeta1.setLocalizedName("weaponPaladin");
		weaponMeta1.setUnbreakable(true);
		weapon1.setItemMeta(weaponMeta1);
		
		ItemStack weapon2= new ItemStack(Material.STONE_SWORD);
		ItemMeta weaponMeta2 = weapon2.getItemMeta();
		weaponMeta2.setDisplayName("§6Épée de clarté");
		weaponMeta2.setLore(Arrays.asList("Une arme un peu émoussée, mais qui fait le taff", "§3Vos adversaires n'ont qu'à bien se tenir"));
		weaponMeta2.setLocalizedName("weaponPaladin");
		weaponMeta2.setUnbreakable(true);
		weapon2.setItemMeta(weaponMeta2);
		
		ItemStack weapon3= new ItemStack(Material.IRON_SWORD);
		ItemMeta weaponMeta3 = weapon3.getItemMeta();
		weaponMeta3.setDisplayName("§6Épée de lumière");
		weaponMeta3.setLore(Arrays.asList("Enfin une arme correcte !", "§3Cette longue lame resplendissante a l'air tranchante"));
		weaponMeta3.setLocalizedName("weaponPaladin");
		weaponMeta3.setUnbreakable(true);
		weapon3.setItemMeta(weaponMeta3);
		
		// Suppression de l'ancienne arme et ajout de la nouvelle
		switch (getWeaponLvl()) {
		case 1:
			if (!inventory.contains(weapon1) && !inventory.getItemInOffHand().equals(weapon1)) inventory.addItem(weapon1);
			if (!inventory.contains(shield) && !inventory.getItemInOffHand().equals(shield)) inventory.setItemInOffHand(shield);
			break;
			
		case 2:
			if (inventory.contains(weapon1)) inventory.setItem(inventory.first(weapon1), weapon2);
			if (inventory.getItemInOffHand().equals(weapon1)) inventory.setItemInOffHand(weapon2);
			break;
			
		case 3:
			if (inventory.contains(weapon2)) inventory.setItem(inventory.first(weapon2), weapon3);
			if (inventory.getItemInOffHand().equals(weapon2)) inventory.setItemInOffHand(weapon3);
			break;
			
		default:
		}
		
		// On met à jour l'armure
		
		// On prépare la liste de toutes les armures
		ItemStack chestplate1 = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemMeta chestplateMeta1 = chestplate1.getItemMeta();
		chestplateMeta1.setDisplayName("§6Plastron de l'optimiste");
		chestplateMeta1.setLore(Arrays.asList("L'armure basique par excellence", "§3Tient plutôt chaud"));
		chestplateMeta1.setLocalizedName("chestplatePaladin");
		chestplateMeta1.setUnbreakable(true);
		chestplate1.setItemMeta(chestplateMeta1);
		chestplate1.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack chestplate2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemMeta chestplateMeta2 = chestplate2.getItemMeta();
		chestplateMeta2.setDisplayName("§6Plastron de clarté");
		chestplateMeta2.setLore(Arrays.asList("Une armure un peu émoussée, mais qui fait le taff", "§3Vous ressemblez à un chevalier avec ça"));
		chestplateMeta2.setLocalizedName("chestplatePaladin");
		chestplateMeta2.setUnbreakable(true);
		chestplate2.setItemMeta(chestplateMeta2);
		chestplate2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		chestplate2.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1);
		chestplate2.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack chestplate3 = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta chestplateMeta3 = chestplate3.getItemMeta();
		chestplateMeta3.setDisplayName("§6Plastron de lumière");
		chestplateMeta3.setLore(Arrays.asList("Enfin une armure correcte !", "§3Foncez au coeur de la bataille sans", "§3vous préoccuper des dégats reçus"));
		chestplateMeta3.setLocalizedName("chestplatePaladin");
		chestplateMeta3.setUnbreakable(true);
		chestplate3.setItemMeta(chestplateMeta3);
		chestplate3.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		chestplate3.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
		chestplate3.addEnchantment(Enchantment.THORNS, 1);
		chestplate3.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack chestplate4 = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta chestplateMeta4 = chestplate4.getItemMeta();
		chestplateMeta4.setDisplayName("§6Plastron du protecteur éternel");
		chestplateMeta4.setLore(Arrays.asList("Une armure à toute épreuve", "§3Vous n'avez plus peur de rien avec ça"));
		chestplateMeta4.setLocalizedName("chestplatePaladin");
		chestplateMeta4.setUnbreakable(true);
		chestplate4.setItemMeta(chestplateMeta4);
		chestplate4.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		chestplate4.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 3);
		chestplate4.addEnchantment(Enchantment.THORNS, 2);
		chestplate4.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack chestplate5 = new ItemStack(Material.NETHERITE_CHESTPLATE);
		ItemMeta chestplateMeta5 = chestplate5.getItemMeta();
		chestplateMeta5.setDisplayName("§6Plastron de la bénédiction divine");
		chestplateMeta5.setLore(Arrays.asList("Une armure divine forgée par les dieux", "§3Soyez celui qui défend tout le monde"));
		chestplateMeta5.setLocalizedName("chestplatePaladin");
		chestplateMeta5.setUnbreakable(true);
		chestplate5.setItemMeta(chestplateMeta5);
		chestplate5.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		chestplate5.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
		chestplate5.addEnchantment(Enchantment.THORNS, 3);
		chestplate5.addEnchantment(Enchantment.BINDING_CURSE, 1);

		ItemStack leggings1 = new ItemStack(Material.LEATHER_LEGGINGS);
		ItemMeta leggingsMeta1 = leggings1.getItemMeta();
		leggingsMeta1.setDisplayName("§6Pantalon de l'optimiste");
		leggingsMeta1.setLore(Arrays.asList("L'armure basique par excellence", "§3Tient plutôt chaud"));
		leggingsMeta1.setLocalizedName("leggingsPaladin");
		leggingsMeta1.setUnbreakable(true);
		leggings1.setItemMeta(leggingsMeta1);
		leggings1.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack leggings2 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		ItemMeta leggingsMeta2 = leggings2.getItemMeta();
		leggingsMeta2.setDisplayName("§6Pantalon de clarté");
		leggingsMeta2.setLore(Arrays.asList("Une armure un peu émoussée, mais qui fait le taff", "§3Vous ressemblez à un chevalier avec ça"));
		leggingsMeta2.setLocalizedName("leggingsPaladin");
		leggingsMeta2.setUnbreakable(true);
		leggings2.setItemMeta(leggingsMeta2);
		leggings2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		leggings2.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
		leggings2.addEnchantment(Enchantment.PROTECTION_FIRE, 1);
		leggings2.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack leggings3 = new ItemStack(Material.IRON_LEGGINGS);
		ItemMeta leggingsMeta3 = leggings3.getItemMeta();
		leggingsMeta3.setDisplayName("§6Pantalon de lumière");
		leggingsMeta3.setLore(Arrays.asList("Enfin une armure correcte !", "§3Foncez au coeur de la bataille sans", "§3vous préoccuper des dégats reçus"));
		leggingsMeta3.setLocalizedName("leggingsPaladin");
		leggingsMeta3.setUnbreakable(true);
		leggings3.setItemMeta(leggingsMeta3);
		leggings3.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		leggings3.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
		leggings3.addEnchantment(Enchantment.PROTECTION_FIRE, 2);
		leggings3.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack leggings4 = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta leggingsMeta4 = leggings4.getItemMeta();
		leggingsMeta4.setDisplayName("§6Pantalon du protecteur éternel");
		leggingsMeta4.setLore(Arrays.asList("Une armure à toute épreuve", "§3Vous n'avez plus peur de rien avec ça"));
		leggingsMeta4.setLocalizedName("leggingsPaladin");
		leggingsMeta4.setUnbreakable(true);
		leggings4.setItemMeta(leggingsMeta4);
		leggings4.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		leggings4.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 3);
		leggings4.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
		leggings4.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack leggings5 = new ItemStack(Material.NETHERITE_LEGGINGS);
		ItemMeta leggingsMeta5 = leggings5.getItemMeta();
		leggingsMeta5.setDisplayName("§6Pantalon de la bénédiction divine");
		leggingsMeta5.setLore(Arrays.asList("Une armure divine forgée par les dieux", "§3Soyez celui qui défend tout le monde"));
		leggingsMeta5.setLocalizedName("leggingsPaladin");
		leggingsMeta5.setUnbreakable(true);
		leggings5.setItemMeta(leggingsMeta5);
		leggings5.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		leggings5.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
		leggings5.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
		leggings5.addEnchantment(Enchantment.BINDING_CURSE, 1);

		ItemStack boots1 = new ItemStack(Material.LEATHER_BOOTS);
		ItemMeta bootsMeta1 = boots1.getItemMeta();
		bootsMeta1.setDisplayName("§6Bottes de l'optimiste");
		bootsMeta1.setLore(Arrays.asList("L'armure basique par excellence", "§3Tient plutôt chaud"));
		bootsMeta1.setLocalizedName("bootsPaladin");
		bootsMeta1.setUnbreakable(true);
		boots1.setItemMeta(bootsMeta1);
		boots1.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack boots2 = new ItemStack(Material.CHAINMAIL_BOOTS);
		ItemMeta bootsMeta2 = boots2.getItemMeta();
		bootsMeta2.setDisplayName("§6Bottes de clarté");
		bootsMeta2.setLore(Arrays.asList("Une armure un peu émoussée, mais qui fait le taff", "§3Vous ressemblez à un chevalier avec ça"));
		bootsMeta2.setLocalizedName("bootsPaladin");
		bootsMeta2.setUnbreakable(true);
		boots2.setItemMeta(bootsMeta2);
		boots2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		boots2.addEnchantment(Enchantment.PROTECTION_FALL, 1);
		boots2.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack boots3 = new ItemStack(Material.IRON_BOOTS);
		ItemMeta bootsMeta3 = boots3.getItemMeta();
		bootsMeta3.setDisplayName("§6Bottes de lumière");
		bootsMeta3.setLore(Arrays.asList("Enfin une armure correcte !", "§3Foncez au coeur de la bataille sans", "§3vous préoccuper des dégats reçus"));
		bootsMeta3.setLocalizedName("bootsPaladin");
		bootsMeta3.setUnbreakable(true);
		boots3.setItemMeta(bootsMeta3);
		boots3.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		boots3.addEnchantment(Enchantment.PROTECTION_FALL, 2);
		boots3.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack boots4 = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta bootsMeta4 = boots4.getItemMeta();
		bootsMeta4.setDisplayName("§6Bottes du protecteur éternel");
		bootsMeta4.setLore(Arrays.asList("Une armure à toute épreuve", "§3Vous n'avez plus peur de rien avec ça"));
		bootsMeta4.setLocalizedName("bootsPaladin");
		bootsMeta4.setUnbreakable(true);
		boots4.setItemMeta(bootsMeta4);
		boots4.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		boots4.addEnchantment(Enchantment.PROTECTION_FALL, 3);
		boots4.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack boots5 = new ItemStack(Material.NETHERITE_BOOTS);
		ItemMeta bootsMeta5 = boots5.getItemMeta();
		bootsMeta5.setDisplayName("§6Bottes de la bénédiction divine");
		bootsMeta5.setLore(Arrays.asList("Une armure divine forgée par les dieux", "§3Soyez celui qui défend tout le monde"));
		bootsMeta5.setLocalizedName("bootsPaladin");
		bootsMeta5.setUnbreakable(true);
		boots5.setItemMeta(bootsMeta5);
		boots5.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		boots5.addEnchantment(Enchantment.PROTECTION_FALL, 4);
		boots5.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		// Suppression de l'ancienne armure et ajout de la nouvelle
		switch (getArmorLvl()) {
		case 1:
			if (!inventory.contains(chestplate1) && !inventory.getItemInOffHand().equals(chestplate1)) inventory.setChestplate(chestplate1);
			if (!inventory.contains(leggings1) && !inventory.getItemInOffHand().equals(leggings1)) inventory.setLeggings(leggings1);
			if (!inventory.contains(boots1) && !inventory.getItemInOffHand().equals(boots1)) inventory.setBoots(boots1);
			break;
			
		case 2:
			if (inventory.getChestplate().equals(chestplate1)) inventory.setChestplate(chestplate2);
			if (inventory.getLeggings().equals(leggings1)) inventory.setLeggings(leggings2);
			if (inventory.getBoots().equals(boots1)) inventory.setBoots(boots2);
			break;
			
		case 3:
			if (inventory.getChestplate().equals(chestplate2)) inventory.setChestplate(chestplate3);
			if (inventory.getLeggings().equals(leggings2)) inventory.setLeggings(leggings3);
			if (inventory.getBoots().equals(boots2)) inventory.setBoots(boots3);
			break;
			
		case 4:
			if (inventory.getChestplate().equals(chestplate3)) inventory.setChestplate(chestplate4);
			if (inventory.getLeggings().equals(leggings3)) inventory.setLeggings(leggings4);
			if (inventory.getBoots().equals(boots3)) inventory.setBoots(boots4);			
			break;
			
		case 5:
			if (inventory.getChestplate().equals(chestplate4)) inventory.setChestplate(chestplate5);
			if (inventory.getLeggings().equals(leggings4)) inventory.setLeggings(leggings5);
			if (inventory.getBoots().equals(boots4)) inventory.setBoots(boots5);
			break;
			
		default:
		}
		
		// On met à jour les effets
		
		PotionEffect effect1 = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100000, 0, false, false);
		PotionEffect effect2 = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100000, 1, false, false);
		
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
		
		switch (getWeaponLvl()) {
		case 1:
			inventory.setItem(18, weaponUp1);
			break;

		case 2:
			inventory.setItem(18, weaponUp2);
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
		
		ItemStack armorUp4 = new ItemStack(Material.NETHERITE_CHESTPLATE);
		ItemMeta armorUpMeta4 = armorUp4.getItemMeta();
		armorUpMeta4.setDisplayName("§6Amélioration de l'armure");
		armorUpMeta4.setLore(Arrays.asList("", "§aCoût : §730", "§fPayez avec vos niveaux pour", "§faméliorer votre armure"));
		armorUpMeta4.setLocalizedName("armorUp");
		armorUp4.setItemMeta(armorUpMeta4);
		
		switch (getArmorLvl()) {
		case 1:
			inventory.setItem(0, armorUp1);
			break;

		case 2:
			inventory.setItem(0, armorUp2);
			break;

		case 3:
			inventory.setItem(0, armorUp3);
			break;

		case 4:
			inventory.setItem(0, armorUp4);
			break;
			
		default:
		}
		
		ItemStack effectUp1 = new ItemStack(Material.POTION);
		ItemMeta effectUpMeta1 = effectUp1.getItemMeta();
		effectUpMeta1.setDisplayName("§dAmélioration des effets");
		effectUpMeta1.setLore(Arrays.asList("", "§aCoût : §715", "§fPayez avec vos niveaux pour", "§faméliorer vos effets", "§5Prochain effet : §cRésistance 1"));
		effectUpMeta1.setLocalizedName("effectUp");
		effectUp1.setItemMeta(effectUpMeta1);
		
		ItemStack effectUp2 = new ItemStack(Material.POTION);
		PotionMeta effectUpMeta2 = (PotionMeta) effectUp2.getItemMeta();
		PotionData potionData = new PotionData(PotionType.TURTLE_MASTER);
		effectUpMeta2.setBasePotionData(potionData);
		effectUpMeta2.setDisplayName("§dAmélioration des effets");
		effectUpMeta2.setLore(Arrays.asList("", "§aCoût : §720", "§fPayez avec vos niveaux pour", "§faméliorer vos effets", "§5Prochain effet : §cRésistance 2"));
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