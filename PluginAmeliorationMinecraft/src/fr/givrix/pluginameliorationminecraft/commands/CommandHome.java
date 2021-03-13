package fr.givrix.pluginameliorationminecraft.commands;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;

import fr.givrix.pluginameliorationminecraft.PluginAmeliorationMinecraft;
import fr.givrix.pluginameliorationminecraft.data.PersistentDataTypeLocation;

public class CommandHome implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player) sender;
			
			PersistentDataTypeLocation dataType = new PersistentDataTypeLocation();
			PersistentDataContainer data = player.getPersistentDataContainer();
			NamespacedKey key = new NamespacedKey(PluginAmeliorationMinecraft.getPlugin(), "home");
			
			switch (args.length) {
			case 0:
				// Si un home existe, on téléport le joueur
				if (data.has(key, dataType)) {
					World world = player.getWorld();
					double x = data.get(key, dataType).getX();
					double y = data.get(key, dataType).getY();
					double z = data.get(key, dataType).getZ();
					float yaw = data.get(key, dataType).getYaw();
					float pitch = data.get(key, dataType).getPitch();
					Location location = new Location(world, x, y, z, yaw, pitch);
					player.teleport(location);
					
				} else {
					player.sendMessage("§cVous n'avez pas encore défini de home. Vous pouvez le définir avec la commande §r/home set");
				}
				
				break;
				
			case 1:
				// On défini le home du joueur
				if (args[0].equals("set")) {
					data.set(key, dataType, player.getLocation());
					player.sendMessage("§aVotre home a été défini avec succès !");
					break;
				}

			default:
				// Erreur de syntaxe
				player.sendMessage("Syntaxe : /home ou /home set");
			}
			
			return true;
		}
		
		return false;
	}
	
}