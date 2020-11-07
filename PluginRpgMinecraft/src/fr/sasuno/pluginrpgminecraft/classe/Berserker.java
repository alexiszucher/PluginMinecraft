package fr.sasuno.pluginrpgminecraft.classe;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class Berserker extends Classe {

	//=======================================================================================================
	//	Constructeur de la classe																			/
	//========================================================================================================
	public Berserker()
	{
		ItemStack [] ListWeapons = {new ItemStack(Material.WOODEN_AXE), new ItemStack(Material.STONE_AXE), new ItemStack(Material.IRON_AXE), new ItemStack(Material.DIAMOND_AXE)};
		this.ListWeaponsUp = ListWeapons;
	}
	
	//=======================================================================================================
	//					Création de la classe																/
	//========================================================================================================
	@Override
	public void createClass(Player player)
	{
		player.sendMessage("Félicitation ! Vous êtes à présent  !");
		ItemStack [] items = {new ItemStack(Material.WOODEN_AXE)};
		Classe.giveItems(player, items);
	}

	//=======================================================================================================
	//						Menu de la classe																/
	//========================================================================================================
	@Override
	public void menuClass(Player player) {
		// TODO Auto-generated method stub
		
	}


}
