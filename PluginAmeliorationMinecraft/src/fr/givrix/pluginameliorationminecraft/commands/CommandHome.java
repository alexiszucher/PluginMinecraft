package fr.givrix.pluginameliorationminecraft.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import fr.givrix.pluginameliorationminecraft.PluginAmeliorationMinecraft;

public class CommandHome implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player) sender;
			
			File file = new File(PluginAmeliorationMinecraft.getPlugin().getDataFolder(), "home.yml");
			YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
			
			switch (args.length) {
			case 0:
				// Si un home existe, on téléport le joueur
				if (configuration.getLocation(player.getUniqueId().toString()) != null) {
					player.teleport(configuration.getLocation(player.getUniqueId().toString()));
				} else {
					player.sendMessage(ChatColor.RED + "Vous n'avez pas encore défini de home. Vous pouvez le définir avec la commande " + ChatColor.RESET + "/home set");
				}
				
				break;
				
			case 1:
				// On défini le home du joueur
				if (args[0].equals("set")) {
					configuration.set(player.getUniqueId().toString(), player.getLocation());
					player.sendMessage(ChatColor.GREEN + "Votre home a été défini avec succès !");
					
					try {
						configuration.save(file);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}

			default:
				return false;
			}
			
			return true;
		}
		
		return false;
	}
	
}