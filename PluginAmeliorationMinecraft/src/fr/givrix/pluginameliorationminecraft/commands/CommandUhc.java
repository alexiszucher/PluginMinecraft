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
					
					// Si la difficult� n'est pas en hard, on la met en hard
					if (world.getDifficulty() != Difficulty.HARD) {
						world.setDifficulty(Difficulty.HARD);
					}
					
					// Si la r�g�n�ration naturelle est activ�e, on la d�sactive
					if (world.getGameRuleValue(GameRule.NATURAL_REGENERATION)) {
						world.setGameRule(GameRule.NATURAL_REGENERATION, false);
					}
					
					// Si le monde n'est pas en hardcore, on le met en hardcore
					if (!world.isHardcore()) {
						world.setHardcore(true);
						
						// On r��crit la ligne hardcore de server.properties
						MyFunctions.ReplaceText("server.properties", "hardcore", "hardcore=true");
						Bukkit.broadcastMessage("�4Le serveur doit red�marrer pour changer votre mode de jeu");
						
						// On attend 5 secondes et on red�marre le serveur
						try {
							Thread.sleep(5*1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						Bukkit.spigot().restart();
					}
					
					Bukkit.broadcastMessage("�6Votre mode de jeu a �t� mis � jour");
					Bukkit.broadcastMessage("�eLe sc�nario UHC est maintenant activ�. Ne perdez plus de vie !");
					
				} else {
					player.sendMessage("Vous �tes d�j� en UHC");
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