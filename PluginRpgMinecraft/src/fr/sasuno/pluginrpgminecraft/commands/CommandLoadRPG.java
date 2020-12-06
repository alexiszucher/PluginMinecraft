package fr.sasuno.pluginrpgminecraft.commands;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.sasuno.pluginrpgminecraft.classe.Berserker;
import fr.sasuno.pluginrpgminecraft.classe.Classe;

public class CommandLoadRPG implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {

		if(sender instanceof Player) {
			Player player = (Player) sender;
			String pwd = System.getProperty("user.dir");
			Path fichierSave = Paths.get(pwd+"/plugins/saveRPG.txt");
			
			try {
				List<String> lignes = Files.readAllLines(fichierSave);
				
				for(String ligne : lignes) {
					String[] colonnes = ligne.split(";");
					Player playerInLoad = Bukkit.getServer().getPlayer(colonnes[0]);
		        	AttributeInstance attributeHeart = playerInLoad.getAttribute(Attribute.GENERIC_MAX_HEALTH);
		        	AttributeInstance attributeDamage = playerInLoad.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
		        	attributeHeart.setBaseValue(Double.parseDouble(colonnes[2]));
		        	attributeDamage.setBaseValue(Double.parseDouble(colonnes[3]));
					if(colonnes[1].equals("Berserker")) {
						Classe.classe.put(colonnes[0], new Berserker());
					}
						Classe.classe.get(colonnes[0]).setWeaponLvl(Integer.parseInt(colonnes[4]));
						Classe.classe.get(colonnes[0]).setArmorLvl(Integer.parseInt(colonnes[5]));
				}
				player.sendMessage(ChatColor.GREEN + "Chargement des classes de tous les joueurs effectués !");
				
			} catch(Exception e) {
				player.sendMessage("Erreur : "+e);
			}

		}
		return true;
	}

}
