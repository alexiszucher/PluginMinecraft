package fr.givrix.bingo.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.givrix.bingo.Bingo;

public class CommandStartBingo implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		for (Player player : Bukkit.getOnlinePlayers()) {
			
			Bukkit.getScheduler().runTaskLater(Bingo.getPlugin(), () -> player.sendTitle(ChatColor.RED + Integer.toString(3), null, 0, 10, 0), 20);
			Bukkit.getScheduler().runTaskLater(Bingo.getPlugin(), () -> player.sendTitle(ChatColor.RED + Integer.toString(2), null, 0, 10, 0), 20*2);
			Bukkit.getScheduler().runTaskLater(Bingo.getPlugin(), () -> player.sendTitle(ChatColor.RED + Integer.toString(1), null, 0, 10, 0), 20*3);
		}
		
		return false;
	}

}