package fr.sasuno.pluginrpgminecraft.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.sasuno.pluginrpgminecraft.classe.Berserker;
import fr.sasuno.pluginrpgminecraft.classe.Classe_Alexis;
import fr.sasuno.pluginrpgminecraft.classe.Paladin;

public class ListenerClass implements Listener {
	
	//=================================================================================
	//	EVENT QUAND LE JOUEUR SE CONNECTE AU SERVEUR   								  /
	//=================================================================================
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		player.getInventory().addItem(new ItemStack(Material.COMPASS));
		player.sendMessage("Salut "+player.getName()+" ! Commence ton aventure en choisissant ta classe ;) \n Je te laisse faire : \n "+ChatColor.GREEN + "/class Guerrier|Archer");
	}
	
	@EventHandler
	public void onCraft(CraftItemEvent e)
	{
		Material itemType = e.getRecipe().getResult().getType();
		if(itemType==Material.WOODEN_AXE || itemType==Material.STONE_AXE || itemType==Material.IRON_AXE || itemType==Material.DIAMOND_AXE
		  || itemType==Material.WOODEN_SWORD || itemType==Material.STONE_SWORD || itemType==Material.IRON_SWORD || itemType==Material.DIAMOND_SWORD)
		{
			e.getInventory().setResult(new ItemStack(Material.AIR));
			for(HumanEntity he:e.getViewers())
			{
				if(he instanceof Player)
				{
					((Player)he).sendMessage(ChatColor.RED + "Vous ne pouvez pas crafter cet item !");
				}
			}
		}
	}
	
	//=================================================================================
	//	EVENT QUAND LE JOUEUR INTERAGIT AVEC QUELQUE CHOSE   						  /
	//=================================================================================
	@EventHandler
	public void onInteract(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack it = event.getItem();
		
		if(it == null) return;
		
		//=================================================================================
		//	INTERACTION AVEC LA BOUSSOLE												  /
		//=================================================================================
		if(it.getType() == Material.COMPASS)
		{
			if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK)
			{
				if(!Classe_Alexis.classe.containsKey(player.getName()))
				{
					Inventory inv = Bukkit.createInventory(null,36,"Choix de votre classe");
					
					ItemStack sword = new ItemStack(Material.SHIELD);
					ItemMeta swordM = sword.getItemMeta();
					swordM.setDisplayName("Paladin");
					sword.setItemMeta(swordM);
					inv.setItem(11, sword);
					
					ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
					ItemMeta axeM = axe.getItemMeta();
					axeM.setDisplayName("Berserker");
					axe.setItemMeta(axeM);
					inv.setItem(13, axe);
					
					player.openInventory(inv);
				}
				else
				{
					Classe_Alexis.classe.get(player.getName()).menuClass(player);
				}
				
			}
		}
	}
	
	//=================================================================================
	//	EVENT QUAND LE JOUEUR CLIQUE SUR UN ITEM (ou autre)   						  /
	//=================================================================================
	@EventHandler
	public void onClick(InventoryClickEvent event)
	{
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack current = event.getCurrentItem();
		
		if(current == null) return;
		
		//=================================================================================
		//	Si l'event click est appelé depuis l'inventaire choixClasse				      /
		//=================================================================================
		if(event.getView().getTitle().equalsIgnoreCase("Choix de votre classe"))
		{
			//Si il a déjà choisi sa classe
			if(Classe_Alexis.classe.containsKey(player.getName()))
			{
				player.sendMessage("Hop hop hop, je te rappelle que tu as déjà une classe");
				player.closeInventory();
			}
			//Sinon
			else if(current.getType() == Material.DIAMOND_AXE)
			{
				player.closeInventory();
				Classe_Alexis.classe.put(player.getName(), new Berserker());
				Classe_Alexis.classe.get(player.getName()).createClass(player);
			}
			else if(current.getType() == Material.SHIELD)
			{
				player.closeInventory();
				Classe_Alexis.classe.put(player.getName(), new Paladin());
				Classe_Alexis.classe.get(player.getName()).createClass(player);
			}
		}
		
		//=================================================================================
		//	Si l'event click est appelé depuis l'inventaire menuClasse   				  /
		//=================================================================================
		if(event.getView().getTitle().equalsIgnoreCase("Menu de votre classe"))
		{
			if(current.getType() == Material.DIAMOND_AXE){
				player.closeInventory();
				Classe_Alexis.weaponUp(player, Classe_Alexis.classe.get(player.getName()));
			}
			else if(current.getType() == Material.DIAMOND_CHESTPLATE){
				player.closeInventory();
				Classe_Alexis.armorUp(player, Classe_Alexis.classe.get(player.getName()));
			}
			else if(current.getType() == Material.SPLASH_POTION){
				player.closeInventory();
				Classe_Alexis.addHearts(player, Classe_Alexis.classe.get(player.getName()));
			}
			else if(current.getType() == Material.BLAZE_ROD){
				player.closeInventory();
				Classe_Alexis.addAttacks(player, Classe_Alexis.classe.get(player.getName()));
			}
			else if(current.getType() == Material.SHIELD){
				player.closeInventory();
				Classe_Alexis.addResistances(player, Classe_Alexis.classe.get(player.getName()));
			}
			else if(current.getType() == Material.SNOWBALL) {
				player.closeInventory();
				Classe_Alexis.savePlayer(player);
			}
		}
	}

}