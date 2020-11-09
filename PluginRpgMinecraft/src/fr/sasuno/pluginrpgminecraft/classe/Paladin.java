package fr.sasuno.pluginrpgminecraft.classe;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Paladin extends Classe {

	//=======================================================================================================
	//				Constructeur de la classe																/
	//========================================================================================================
	public Paladin()
	{
		ItemStack [] ListWeapons = {new ItemStack(Material.WOODEN_SWORD), new ItemStack(Material.STONE_SWORD), new ItemStack(Material.IRON_SWORD), new ItemStack(Material.DIAMOND_SWORD)};
		this.ListWeaponsUp = ListWeapons;
		
		ItemStack [][] ListArmors = {
				{new ItemStack(Material.LEATHER_HELMET), new ItemStack(Material.LEATHER_CHESTPLATE), new ItemStack(Material.LEATHER_LEGGINGS), new ItemStack(Material.LEATHER_BOOTS)},
				{new ItemStack(Material.IRON_HELMET), new ItemStack(Material.IRON_CHESTPLATE), new ItemStack(Material.IRON_LEGGINGS), new ItemStack(Material.IRON_BOOTS)},
				{new ItemStack(Material.DIAMOND_HELMET), new ItemStack(Material.DIAMOND_CHESTPLATE), new ItemStack(Material.DIAMOND_LEGGINGS), new ItemStack(Material.DIAMOND_BOOTS)}
				};
		this.ListArmorsUp = ListArmors;
		
		this.NomClasse = "Paladin";
		
	}
	
	//=======================================================================================================
	//				Création de la classe																	/
	//========================================================================================================
	@Override
	public void createClass(Player player)
	{
		player.sendMessage("Félicitation ! Vous êtes à présent Paladin !"
							+ "Vous avez maintenant accès au menu de votre classe ! ");
		ItemStack [] items = {new ItemStack(Material.WOODEN_SWORD)};
		Classe.giveItemsJustForClass(player, items);
		giveArmors(player, ListArmorsUp[0]);
		
        AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        attribute.setBaseValue(NombreCoeurs);
        player.setHealth(NombreCoeurs);
	}

	//=======================================================================================================
	//					Menu de la classe																	/
	//========================================================================================================
	@Override
	public void menuClass(Player player) {
		
		Inventory inv = Bukkit.createInventory(null,36,"Menu de votre classe");
		
		ItemStack book = new ItemStack(Classe.createItemForMenu(new ItemStack(Material.DIAMOND_AXE), "Augmenter Votre Arme", "LVL REQUIS : "+WeaponLvl *2));
		inv.setItem(27, book);
		
		ItemStack book2 = new ItemStack(Classe.createItemForMenu(new ItemStack(Material.DIAMOND_CHESTPLATE), "Augmenter Votre Armure", "LVL REQUIS : "+ArmorLvl *5));
		inv.setItem(35, book2);
		
		ItemStack book3 = new ItemStack(Classe.createItemForMenu(new ItemStack(Material.SPLASH_POTION), "Augmenter Le Nombre De Coeurs", "LVL REQUIS : 5"));
		inv.setItem(0, book3);
		
		ItemStack book4 = new ItemStack(Classe.createItemForMenu(new ItemStack(Material.SHIELD), "Augmenter Votre Resistance", "LVL REQUIS : 5"));
		inv.setItem(8, book4);
		
		player.openInventory(inv);
		
	}

	@Override
	public void giveArmors(Player player, ItemStack[] items) {
		
		ItemMeta meta = items[0].getItemMeta();
		meta.setUnbreakable(true);
		items[0].setItemMeta(meta);
		
		meta = items[1].getItemMeta();
		meta.setUnbreakable(true);
		items[1].setItemMeta(meta);
		
		meta = items[2].getItemMeta();
		meta.setUnbreakable(true);
		items[2].setItemMeta(meta);
		
		meta = items[3].getItemMeta();
		meta.setUnbreakable(true);
		items[3].setItemMeta(meta);
		
		player.getInventory().setHelmet(items[0]);
		player.getInventory().setChestplate(items[1]);
		player.getInventory().setLeggings(items[2]);
		player.getInventory().setBoots(items[3]);
		
	}
	
}
