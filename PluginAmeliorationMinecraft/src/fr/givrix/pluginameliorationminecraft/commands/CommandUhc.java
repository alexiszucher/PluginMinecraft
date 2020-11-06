package fr.givrix.pluginameliorationminecraft.commands;

import org.bukkit.Bukkit;
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
				
				if (world.getDifficulty() != Difficulty.HARD || world.getGameRuleValue(GameRule.NATURAL_REGENERATION) || !Bukkit.getServer().isHardcore()) {

					if (world.getDifficulty() != Difficulty.HARD) {
						world.setDifficulty(Difficulty.HARD);
					}
					
					if (world.getGameRuleValue(GameRule.NATURAL_REGENERATION)) {
						world.setGameRule(GameRule.NATURAL_REGENERATION, false);
					}
					
					if (!Bukkit.getServer().isHardcore()) {
						Bukkit.getServer().getWorld(player.getWorld().getName()).setHardcore(true);
						Bukkit.broadcastMessage("§4Le serveur doit redémarrer pour changer votre mode de jeu");
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							
						}
						Bukkit.getServer().spigot().restart();
					}
					
					Bukkit.broadcastMessage("§6Votre mode de jeu a été mis à jour");
					Bukkit.broadcastMessage("§eLe scénario UHC est maintenant activé. Ne perdez plus de vie !");
					
				} else {
					player.sendMessage("Vous êtes déjà en UHC");
				}
				
			} else {
				player.sendMessage("Syntaxe : /uhc");
			}
		
			return true;
		}
		
		return false;
	}

}