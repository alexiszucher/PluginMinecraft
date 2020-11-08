package fr.sasuno.pluginrpgminecraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.sasuno.pluginrpgminecraft.classe.Classe;

public class CommandMenuRpg implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		//==========================================================================
		//	Si c'est un joueur qui lance la commande je rentre dans la condition   /
		//==========================================================================
		if(sender instanceof Player)
		{
			//Je récupère les infos du joueur
			Player player = (Player)sender;
			
			Inventory inv = Bukkit.createInventory(null,36,"Choix de votre classe");
			
			ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
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
		
		return false;
	}

}
