package fr.sasuno.pluginrpgminecraft.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.sasuno.pluginrpgminecraft.classes.Classe;

public class ListenerStart implements Listener {
	
	@EventHandler
	public void onInteract(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();

		// Si le joueur n'a pas de classe, lui en attribue une
		if (!Classe.hasClasse(player)) {
			Classe.setRandomClasse(player);
		}
		
		player.sendMessage("Votre classe est §b" + Classe.getClasseName(player));
	}

}