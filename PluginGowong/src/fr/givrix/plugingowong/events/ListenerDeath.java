package fr.givrix.plugingowong.events;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.persistence.PersistentDataContainer;

import fr.givrix.plugingowong.PluginGowong;
import fr.givrix.plugingowong.data.PersistentDataTypeCalendar;

public class ListenerDeath implements Listener {
	
	@EventHandler
	public void onInteract(PlayerDeathEvent event) {
		
		Player player = event.getEntity();
		
		PersistentDataTypeCalendar dataType = new PersistentDataTypeCalendar();
		PersistentDataContainer data = player.getPersistentDataContainer();
		NamespacedKey key = new NamespacedKey(PluginGowong.getPlugin(), "deathDate");

		Calendar deathDate = Calendar.getInstance();
		deathDate.add(Calendar.DAY_OF_MONTH, 3);
		data.set(key, dataType, deathDate);

		SimpleDateFormat formater = new SimpleDateFormat("dd MMMMM yyyy");
		Bukkit.getScheduler().runTaskLater(PluginGowong.getPlugin(),
				() -> player.kickPlayer("Vous avez été kick pour ne pas abuser du mode spectateur. Vous pourrez rejouer le " + formater.format(deathDate.getTime())), 5*60*20);
	}

}
