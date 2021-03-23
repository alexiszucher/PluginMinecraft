package fr.givrix.pluginameliorationminecraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.givrix.pluginameliorationminecraft.functions.MyFunctions;

public class CommandUhc implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;
			
			if (args.length == 0) {
				World world = player.getWorld();
				
				if (world.getDifficulty() != Difficulty.HARD || world.getGameRuleValue(GameRule.NATURAL_REGENERATION) || !world.isHardcore()) {
					
					// Si la difficulté n'est pas en hard, on la met en hard
					if (world.getDifficulty() != Difficulty.HARD) {
						world.setDifficulty(Difficulty.HARD);
					}
					
					// Si la régénération naturelle est activée, on la désactive
					if (world.getGameRuleValue(GameRule.NATURAL_REGENERATION)) {
						world.setGameRule(GameRule.NATURAL_REGENERATION, false);
					}
					
					// Si le monde n'est pas en hardcore, on le met en hardcore
					if (!world.isHardcore()) {
						world.setHardcore(true);
						
						// On réécrit la ligne hardcore de server.properties
						MyFunctions.ReplaceText("server.properties", "hardcore", "hardcore=true");
						Bukkit.broadcastMessage("§4Le serveur doit redémarrer pour changer votre mode de jeu");
						
						// On attend 5 secondes et on redémarre le serveur
						try {
							Thread.sleep(5*1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						Bukkit.spigot().restart();
					}
					
					Bukkit.broadcastMessage("§6Votre mode de jeu a été mis à jour");
					Bukkit.broadcastMessage("§eLe scénario UHC est maintenant activé. Ne perdez plus de vie !");
					
				} else {
					player.sendMessage("Vous êtes déjà en UHC");
				}
				
			} else {
				// Erreur de syntaxe
				player.sendMessage("Syntaxe : /uhc");
			}
		
			return true;
		}
		
		return false;
	}

}