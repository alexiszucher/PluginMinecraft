package fr.sasuno.pluginrpgminecraft.events;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.sasuno.pluginrpgminecraft.classe.Classe;

public class EnterInTheWorld implements Listener {
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		player.setCustomName(null);
		player.sendMessage("Salut "+player.getName()+" ! Commence ton aventure en choisissant ta classe ;) \n Je te laisse faire : \n "+ChatColor.GREEN + "/class Guerrier|Archer");
	}
}