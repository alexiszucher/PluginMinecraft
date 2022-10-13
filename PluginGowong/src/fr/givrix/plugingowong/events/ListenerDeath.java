package fr.givrix.plugingowong.events;

import java.util.Calendar;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import fr.givrix.plugingowong.PluginGowong;

public class ListenerDeath implements Listener {
	
	@EventHandler
	public void onInteract(PlayerDeathEvent event) {
		
		Player player = event.getEntity();
		
		int minutesAAttendre = 3;
		
		Calendar deathTime = Calendar.getInstance();
		deathTime.add(Calendar.MINUTE, minutesAAttendre);
		Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), "Vous êtes mort. Veuillez attendre " + minutesAAttendre +" minutes pour respawn", deathTime.getTime(), null);
		
		Bukkit.getScheduler().runTaskLater(PluginGowong.getPlugin(),
				() -> player.kickPlayer("Vous êtes mort. Veuillez attendre " + minutesAAttendre +" minutes pour respawn"), 5*20);
	}

}
