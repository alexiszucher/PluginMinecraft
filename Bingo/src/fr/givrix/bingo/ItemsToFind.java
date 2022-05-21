package fr.givrix.bingo;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemsToFind {
	
	private ArrayList<ItemStack> listOfAllItems = new ArrayList<>();
	private ArrayList<ItemStack> listOfItemsToFind = new ArrayList<>();
	
	private ItemsToFind() {
		addToAllItems(new ItemStack(Material.BOW));
		addToAllItems(new ItemStack(Material.APPLE));
		addToAllItems(new ItemStack(Material.GOLDEN_APPLE));
		addToAllItems(new ItemStack(Material.GOLD_INGOT));
		addToAllItems(new ItemStack(Material.DIAMOND));
		addToAllItems(new ItemStack(Material.BROWN_MUSHROOM));
		addToAllItems(new ItemStack(Material.IRON_BLOCK));
		addToAllItems(new ItemStack(Material.TNT));
		addToAllItems(new ItemStack(Material.REDSTONE));
		addToAllItems(new ItemStack(Material.LAPIS_LAZULI));
		addToAllItems(new ItemStack(Material.EMERALD));
		addToAllItems(new ItemStack(Material.LAVA_BUCKET));
		addToAllItems(new ItemStack(Material.FISHING_ROD));
		addToAllItems(new ItemStack(Material.CARROT_ON_A_STICK));
		addToAllItems(new ItemStack(Material.BLAZE_ROD));
		addToAllItems(new ItemStack(Material.ENDER_PEARL));
		addToAllItems(new ItemStack(Material.GHAST_TEAR));
		addToAllItems(new ItemStack(Material.GLASS_BOTTLE));
		addToAllItems(new ItemStack(Material.COAL_BLOCK));
		addToAllItems(new ItemStack(Material.FLOWER_POT));
		addToAllItems(new ItemStack(Material.HAY_BLOCK));
		addToAllItems(new ItemStack(Material.MILK_BUCKET));
		addToAllItems(new ItemStack(Material.CAKE));
		addToAllItems(new ItemStack(Material.PUMPKIN));
		addToAllItems(new ItemStack(Material.MELON));
		addToAllItems(new ItemStack(Material.SADDLE));
		addToAllItems(new ItemStack(Material.DISPENSER));
		addToAllItems(new ItemStack(Material.NETHER_WART));
		
		randomiseItemsToFind();
	}
	
	private static ItemsToFind INSTANCE = new ItemsToFind();

	public static ItemsToFind getINSTANCE() {
		return INSTANCE;
	}

	private void addToAllItems(ItemStack item) {
		listOfAllItems.add(item);
	}
	
	private void randomiseItemsToFind() {
		
		for (int i = 0; i < 9; i++) {
			Random random = new Random();
			int x = random.nextInt(listOfAllItems.size());
			listOfItemsToFind.add(listOfAllItems.get(x));
			listOfAllItems.remove(x);
		}
	}
	
	public ArrayList<ItemStack> getListOfItemsToFind() {
		return listOfItemsToFind;		
	}
	
	public void removeItemFromListOfItemsToFind(ItemStack item) {
		listOfItemsToFind.remove(item);
	}
}