package fr.givrix.pluginameliorationminecraft.events;

import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class ListenerUhc implements Listener {

	@EventHandler
	public void onInteract(PlayerChangedWorldEvent event) {
		
		Player player = event.getPlayer();
		World currentWorld = player.getWorld();
		World oldWorld = event.getFrom();
		
		currentWorld.setDifficulty(oldWorld.getDifficulty());
		currentWorld.setGameRule(GameRule.NATURAL_REGENERATION, oldWorld.getGameRuleValue(GameRule.NATURAL_REGENERATION));
		currentWorld.setHardcore(oldWorld.isHardcore());
	}
	
}