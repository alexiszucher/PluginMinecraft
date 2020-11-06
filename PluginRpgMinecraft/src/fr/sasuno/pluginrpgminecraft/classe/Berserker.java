package fr.sasuno.pluginrpgminecraft.classe;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


public class Berserker extends Classe {

	@Override
	public void createClass(Player player)
	{
		player.sendMessage("Félicitation ! Vous êtes à présent  !");
		ItemStack [] items = {new ItemStack(Material.WOODEN_AXE), 
							new ItemStack(Material.LEATHER_CHESTPLATE), 
							new ItemStack(Material.LEATHER_BOOTS), 
							new ItemStack(Material.LEATHER_LEGGINGS), 
							new ItemStack(Material.LEATHER_HELMET)};
		Classe.giveItems(player, items);
	}

	@Override
	public void menuClass(Player player) {
		// TODO Auto-generated method stub
		
	}


}
