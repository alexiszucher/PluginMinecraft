package fr.givrix.plugingowong.events;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.bukkit.GameMode;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;

import fr.givrix.pluginameliorationminecraft.PluginAmeliorationMinecraft;
import fr.givrix.plugingowong.PluginGowong;
import fr.givrix.plugingowong.data.PersistentDataTypeCalendar;

public class ListenerStart implements Listener {
	
	@EventHandler
	public void onInteract(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		
		PersistentDataTypeCalendar dataType = new PersistentDataTypeCalendar();
		PersistentDataContainer data = player.getPersistentDataContainer();
		NamespacedKey key = new NamespacedKey(PluginGowong.getPlugin(), "deathDate");
		
		PersistentDataContainer dataRemove1 = player.getPersistentDataContainer();
		NamespacedKey keyRemove1 = new NamespacedKey(PluginAmeliorationMinecraft.getPlugin(), "deathDate");
		NamespacedKey keyRemove2 = new NamespacedKey(PluginAmeliorationMinecraft.getPlugin(), "home");
		dataRemove1.remove(keyRemove1);
		dataRemove1.remove(keyRemove2);
		
		if (!data.has(key, dataType)) return;

		// On regarde si on est dans une phase de résurrection pour les joueurs morts
		if (PluginGowong.getAllResurrection()) {
			Calendar x = Calendar.getInstance();
			data.set(key, dataType, x);
		}
		
		// On récupère la date actuelle et la date de mort du joueur
		Calendar currentDate = Calendar.getInstance();
		int year = data.get(key, dataType).get(Calendar.YEAR);
		int month = data.get(key, dataType).get(Calendar.MONTH);
		int day = data.get(key, dataType).get(Calendar.DAY_OF_MONTH);
		Calendar deathDate = new GregorianCalendar(year, month, day);
		
		// Si la date actuelle est avant la date de mort on kick le joueur, sinon on le remet en mode survie
		if(currentDate.before(deathDate)) {
			SimpleDateFormat formater = new SimpleDateFormat("dd MMMMM yyyy");
			player.kickPlayer("Vous êtes encore mort. Votre date de respawn est le " + formater.format(deathDate.getTime()));
		} else {
			player.setGameMode(GameMode.SURVIVAL);
		}

	}

}
