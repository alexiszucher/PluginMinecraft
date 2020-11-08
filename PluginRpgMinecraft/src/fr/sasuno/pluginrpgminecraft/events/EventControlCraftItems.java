package fr.sasuno.pluginrpgminecraft.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class EventControlCraftItems implements Listener {
	
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
	
}
