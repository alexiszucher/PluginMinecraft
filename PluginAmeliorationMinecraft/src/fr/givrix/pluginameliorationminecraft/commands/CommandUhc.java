package fr.givrix.pluginameliorationminecraft.commands;

import org.bukkit.Difficulty;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandUhc implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;
			
			if (args.length == 0) {
				World world = player.getWorld();
				
				if (world.getDifficulty() != Difficulty.HARD) {
					world.setDifficulty(Difficulty.HARD);
				}
				
				/*if (!Bukkit.getServer().isHardcore()) {
					Bukkit.getServer().getWorld(player.getWorld().getName()).setHardcore(true); // ne marche pas
				}*/
				
				if (world.getGameRuleValue(GameRule.NATURAL_REGENERATION)) {
					world.setGameRule(GameRule.NATURAL_REGENERATION, false);
				}
				
				// dire à tout le monde que le mode de jeu a été mis à jour
				
			} else {
				player.sendMessage("Syntaxe : /uhc");
			}
		
			return true;
		}
		
		return false;
	}

}