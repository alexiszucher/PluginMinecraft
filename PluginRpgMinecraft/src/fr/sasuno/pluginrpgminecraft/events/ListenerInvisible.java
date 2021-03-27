package fr.sasuno.pluginrpgminecraft.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.potion.PotionEffectType;

public class ListenerInvisible implements Listener {
	
	@EventHandler
	public void onInteract(EntityTargetEvent event) {
		
		if (event.getTarget() instanceof Player) {
			
			Player player = (Player) event.getTarget();
			if (player.hasPotionEffect(PotionEffectType.INVISIBILITY)) event.setCancelled(true);
		}
		
	}
	
}