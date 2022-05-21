package fr.givrix.mrrobot.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class CommandTest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if (sender instanceof Player) {
			
			Player player = (Player) sender;
			Player robot = (Player) player.getWorld().spawnEntity(player.getLocation(), EntityType.HORSE);
			
			return true;
		}
		return false;
	}

}