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

public class Sentinelle extends Classe {
	
	public Sentinelle() {
		
		_classeName = "Sentinelle";
		_maxHealth = 20;
		_weaponLvl = 1;
		_armorLvl = 1;
		_effectLvl = 1;		
	}
	
	public Sentinelle(int maxHealth, int weaponLvl, int armorLvl, int effectLvl) {
		
		_classeName = "Sentinelle";
		_maxHealth = maxHealth;
		_weaponLvl = weaponLvl;
		_armorLvl = armorLvl;
		_effectLvl = effectLvl;			
	}

	@Override
	public void updateStuff(Player player) {
		
		PlayerInventory inventory = player.getInventory();
		
		// On met � jour l'arme
		
		// On pr�pare la liste de toutes les armes
		ItemStack arrow = new ItemStack(Material.ARROW);
		arrow.setAmount(64);
		
		ItemStack weapon1= new ItemStack(Material.CROSSBOW);
		ItemMeta weaponMeta1 = weapon1.getItemMeta();
		weaponMeta1.setDisplayName("�6Arbal�te de chasse");
		weaponMeta1.setLore(Arrays.asList("L'arme basique par excellence", "�3Peut tirer sur de tr�s longues distances"));
		weaponMeta1.setLocalizedName("weaponSentinelle");
		weaponMeta1.setUnbreakable(true);
		weapon1.setItemMeta(weaponMeta1);
		
		ItemStack weapon2= new ItemStack(Material.CROSSBOW);
		ItemMeta weaponMeta2 = weapon2.getItemMeta();
		weaponMeta2.setDisplayName("�6Arbal�te du vif");
		weaponMeta2.setLore(Arrays.asList("Une arme un peu �mouss�e, mais qui fait le taff", "�3Cette arme transperce les ennemis"));
		weaponMeta2.setLocalizedName("weaponSentinelle");
		weaponMeta2.setUnbreakable(true);
		weapon2.setItemMeta(weaponMeta2);
		weapon2.addEnchantment(Enchantment.PIERCING, 1);
		
		ItemStack weapon3= new ItemStack(Material.CROSSBOW);
		ItemMeta weaponMeta3 = weapon3.getItemMeta();
		weaponMeta3.setDisplayName("�6Arbal�te de c�l�rit�");
		weaponMeta3.setLore(Arrays.asList("Enfin une arme correcte !", "�3Celle-ci tire plus vite"));
		weaponMeta3.setLocalizedName("weaponSentinelle");
		weaponMeta3.setUnbreakable(true);
		weapon3.setItemMeta(weaponMeta3);
		weapon3.addEnchantment(Enchantment.PIERCING, 2);
		weapon3.addEnchantment(Enchantment.QUICK_CHARGE, 1);
		
		ItemStack weapon4= new ItemStack(Material.CROSSBOW);
		ItemMeta weaponMeta4 = weapon4.getItemMeta();
		weaponMeta4.setDisplayName("�6Arbal�te de v�locit� extr�me");
		weaponMeta4.setLore(Arrays.asList("Une arme con�ue par les meilleurs ing�nieurs", "�3Vos adversaires ne sauront plus o� donner de la t�te"));
		weaponMeta4.setLocalizedName("weaponSentinelle");
		weaponMeta4.setUnbreakable(true);
		weapon4.setItemMeta(weaponMeta4);
		weapon4.addEnchantment(Enchantment.PIERCING, 3);
		weapon4.addEnchantment(Enchantment.QUICK_CHARGE, 2);
		
		ItemStack weapon5= new ItemStack(Material.CROSSBOW);
		ItemMeta weaponMeta5 = weapon5.getItemMeta();
		weaponMeta5.setDisplayName("�6Arbal�te de la vitesse lumi�re");
		weaponMeta5.setLore(Arrays.asList("Embrochez vos ennemis plus vite que votre ombre", "�3Faites pleuvoir des centaines de fl�ches"));
		weaponMeta5.setLocalizedName("weaponSentinelle");
		weaponMeta5.setUnbreakable(true);
		weapon5.setItemMeta(weaponMeta5);
		weapon5.addEnchantment(Enchantment.PIERCING, 4);
		weapon5.addEnchantment(Enchantment.QUICK_CHARGE, 3);
		weapon5.addEnchantment(Enchantment.MULTISHOT, 1);
		
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
		
		// On met � jour l'armure
		
		// On pr�pare la liste de toutes les armures
		ItemStack chestplate1 = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemMeta chestplateMeta1 = chestplate1.getItemMeta();
		chestplateMeta1.setDisplayName("�6Plastron de chasse");
		chestplateMeta1.setLore(Arrays.asList("L'armure basique par excellence", "�3Tient plut�t chaud"));
		chestplateMeta1.setLocalizedName("chestplateSentinelle");
		chestplateMeta1.setUnbreakable(true);
		chestplate1.setItemMeta(chestplateMeta1);
		chestplate1.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack chestplate2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemMeta chestplateMeta2 = chestplate2.getItemMeta();
		chestplateMeta2.setDisplayName("�6Plastron du vif");
		chestplateMeta2.setLore(Arrays.asList("Une armure un peu �mouss�e, mais qui fait le taff", "�3Vous ressemblez � un chevalier avec �a"));
		chestplateMeta2.setLocalizedName("chestplateSentinelle");
		chestplateMeta2.setUnbreakable(true);
		chestplate2.setItemMeta(chestplateMeta2);
		chestplate2.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack chestplate3 = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta chestplateMeta3 = chestplate3.getItemMeta();
		chestplateMeta3.setDisplayName("�6Plastron de c�l�rit�");
		chestplateMeta3.setLore(Arrays.asList("Enfin une armure correcte !", "�3Foncez au coeur de la bataille sans", "�3vous pr�occuper des d�gats re�us"));
		chestplateMeta3.setLocalizedName("chestplateSentinelle");
		chestplateMeta3.setUnbreakable(true);
		chestplate3.setItemMeta(chestplateMeta3);
		chestplate3.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack leggings1 = new ItemStack(Material.LEATHER_LEGGINGS);
		ItemMeta leggingsMeta1 = leggings1.getItemMeta();
		leggingsMeta1.setDisplayName("�6Pantalon de chasse");
		leggingsMeta1.setLore(Arrays.asList("L'armure basique par excellence", "�3Tient plut�t chaud"));
		leggingsMeta1.setLocalizedName("leggingsSentinelle");
		leggingsMeta1.setUnbreakable(true);
		leggings1.setItemMeta(leggingsMeta1);
		leggings1.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack leggings2 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		ItemMeta leggingsMeta2 = leggings2.getItemMeta();
		leggingsMeta2.setDisplayName("�6Pantalon du vif");
		leggingsMeta2.setLore(Arrays.asList("Une armure un peu �mouss�e, mais qui fait le taff", "�3Vous ressemblez � un chevalier avec �a"));
		leggingsMeta2.setLocalizedName("leggingsSentinelle");
		leggingsMeta2.setUnbreakable(true);
		leggings2.setItemMeta(leggingsMeta2);
		leggings2.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		ItemStack leggings3 = new ItemStack(Material.IRON_LEGGINGS);
		ItemMeta leggingsMeta3 = leggings3.getItemMeta();
		leggingsMeta3.setDisplayName("�6Pantalon de c�l�rit�");
		leggingsMeta3.setLore(Arrays.asList("Enfin une armure correcte !", "�3Foncez au coeur de la bataille sans", "�3vous pr�occuper des d�gats re�us"));
		leggingsMeta3.setLocalizedName("leggingsSentinelle");
		leggingsMeta3.setUnbreakable(true);
		leggings3.setItemMeta(leggingsMeta3);
		leggings3.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		// Suppression de l'ancienne armure et ajout de la nouvelle
		switch (getArmorLvl()) {
		case 1:
			if (!inventory.contains(chestplate1) && !inventory.getItemInOffHand().equals(chestplate1)) inventory.setChestplate(chestplate1);
			if (!inventory.contains(leggings1) && !inventory.getItemInOffHand().equals(leggings1)) inventory.setLeggings(leggings1);
			break;
			
		case 2:
			if (inventory.getChestplate().equals(chestplate1)) inventory.setChestplate(chestplate2);
			if (inventory.getLeggings().equals(leggings1)) inventory.setLeggings(leggings2);
			break;
			
		case 3:
			if (inventory.getChestplate().equals(chestplate2)) inventory.setChestplate(chestplate3);
			if (inventory.getLeggings().equals(leggings2)) inventory.setLeggings(leggings3);
			break;
			
		default:
		}
		
		// On met � jour les effets
		
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
		
		Inventory inventory = Bukkit.createInventory(player, InventoryType.CHEST, "Menu d'am�lioration de classe pour " + getClasseName());
		
		ItemStack arrowUp = new ItemStack(Material.ARROW);
		ItemMeta arrowUpMeta = arrowUp.getItemMeta();
		arrowUpMeta.setDisplayName("�6Ajout de fl�ches");
		arrowUpMeta.setLore(Arrays.asList("", "�aCo�t : �70", "�fPermet de faire le plein de fl�ches"));
		arrowUpMeta.setLocalizedName("arrowUp");
		arrowUp.setItemMeta(arrowUpMeta);
		
		ItemStack weaponUp1 = new ItemStack(Material.CROSSBOW);
		ItemMeta weaponUpMeta1 = weaponUp1.getItemMeta();
		weaponUpMeta1.setDisplayName("�6Am�lioration de l'arme");
		weaponUpMeta1.setLore(Arrays.asList("", "�aCo�t : �710", "�fPayez avec vos niveaux pour", "�fam�liorer votre arme"));
		weaponUpMeta1.setLocalizedName("weaponUp");
		weaponUp1.setItemMeta(weaponUpMeta1);
		
		ItemStack weaponUp2 = new ItemStack(Material.CROSSBOW);
		ItemMeta weaponUpMeta2 = weaponUp2.getItemMeta();
		weaponUpMeta2.setDisplayName("�6Am�lioration de l'arme");
		weaponUpMeta2.setLore(Arrays.asList("", "�aCo�t : �715", "�fPayez avec vos niveaux pour", "�fam�liorer votre arme"));
		weaponUpMeta2.setLocalizedName("weaponUp");
		weaponUp2.setItemMeta(weaponUpMeta2);
		
		ItemStack weaponUp3 = new ItemStack(Material.CROSSBOW);
		ItemMeta weaponUpMeta3 = weaponUp3.getItemMeta();
		weaponUpMeta3.setDisplayName("�6Am�lioration de l'arme");
		weaponUpMeta3.setLore(Arrays.asList("", "�aCo�t : �720", "�fPayez avec vos niveaux pour", "�fam�liorer votre arme"));
		weaponUpMeta3.setLocalizedName("weaponUp");
		weaponUp3.setItemMeta(weaponUpMeta3);
		
		ItemStack weaponUp4 = new ItemStack(Material.CROSSBOW);
		ItemMeta weaponUpMeta4 = weaponUp4.getItemMeta();
		weaponUpMeta4.setDisplayName("�6Am�lioration de l'arme");
		weaponUpMeta4.setLore(Arrays.asList("", "�aCo�t : �730", "�fPayez avec vos niveaux pour", "�fam�liorer votre arme"));
		weaponUpMeta4.setLocalizedName("weaponUp");
		weaponUp4.setItemMeta(weaponUpMeta4);
		
		inventory.setItem(13, arrowUp);
		
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
		armorUpMeta1.setDisplayName("�6Am�lioration de l'armure");
		armorUpMeta1.setLore(Arrays.asList("", "�aCo�t : �710", "�fPayez avec vos niveaux pour", "�fam�liorer votre armure"));
		armorUpMeta1.setLocalizedName("armorUp");
		armorUp1.setItemMeta(armorUpMeta1);
		
		ItemStack armorUp2 = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta armorUpMeta2 = armorUp2.getItemMeta();
		armorUpMeta2.setDisplayName("�6Am�lioration de l'armure");
		armorUpMeta2.setLore(Arrays.asList("", "�aCo�t : �715", "�fPayez avec vos niveaux pour", "�fam�liorer votre armure"));
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
		effectUpMeta1.setDisplayName("�dAm�lioration des effets");
		effectUpMeta1.setLore(Arrays.asList("", "�aCo�t : �715", "�fPayez avec vos niveaux pour", "�fam�liorer vos effets", "�5Prochain effet : �cVision nocturne"));
		effectUpMeta1.setLocalizedName("effectUp");
		effectUp1.setItemMeta(effectUpMeta1);
		
		ItemStack effectUp2 = new ItemStack(Material.POTION);
		PotionMeta effectUpMeta2 = (PotionMeta) effectUp2.getItemMeta();
		PotionData potionData = new PotionData(PotionType.NIGHT_VISION);
		effectUpMeta2.setBasePotionData(potionData);
		effectUpMeta2.setDisplayName("�dAm�lioration des effets");
		effectUpMeta2.setLore(Arrays.asList("", "�aCo�t : �720", "�fPayez avec vos niveaux pour", "�fam�liorer vos effets", "�5Prochain effet : �cJump boost 2"));
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
		actifUpMeta1.setDisplayName("�6Am�lioration du pouvoir");
		actifUpMeta1.setLore(Arrays.asList("", "�aCo�t : �715", "�fPayez avec vos niveaux pour", "�fam�liorer votre pouvoir"));
		actifUpMeta1.setLocalizedName("actifUp");
		actifUp1.setItemMeta(actifUpMeta1);
		
		ItemStack actifUp2 = new ItemStack(Material.FEATHER);
		ItemMeta actifUpMeta2 = actifUp2.getItemMeta();
		actifUpMeta2.setDisplayName("�6Am�lioration du pouvoir");
		actifUpMeta2.setLore(Arrays.asList("", "�aCo�t : �720", "�fPayez avec vos niveaux pour", "�fam�liorer votre pouvoir"));
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