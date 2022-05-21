package fr.givrix.plugingowong.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.givrix.plugingowong.PluginGowong;

public class CommandAllResurrection implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if (args.length == 0) {
			if (!PluginGowong.getAllResurrection()) {
				PluginGowong.setAllResurrection(true);
				Bukkit.getScheduler().runTaskLater(PluginGowong.getPlugin(),
						() -> PluginGowong.setAllResurrection(false), 30*20);				
			}
			
			return true;
		}
		
		return false;
	}

}
