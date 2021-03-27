package fr.sasuno.pluginrpgminecraft.events;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;

import fr.sasuno.pluginrpgminecraft.PluginRpgMinecraft;
import fr.sasuno.pluginrpgminecraft.classes.Classe;

public class ListenerArrow implements Listener {
	
	@EventHandler
	public void onInteract(EntityShootBowEvent event) {
		
		if (event.getBow().getType() == Material.CROSSBOW && event.getConsumable().getType() == Material.ARROW && event.getEntity() instanceof Player) {
			
			Player player = (Player) event.getEntity();
			
			if (!player.getInventory().contains(Material.ARROW)) player.getInventory().addItem(new ItemStack(Material.ARROW));			
		}
		
	}
	
	@EventHandler
	public void onInteract(ProjectileHitEvent event) {
		
		if (event.getEntity().getShooter() instanceof Player) {

			Player player = (Player) event.getEntity().getShooter();
			
			if (Classe.isThisClasse(player, "Archer") && Classe.getClasseObject(player).isOnCast()) {

				Location arrowLocation;
				
				if (event.getHitEntity() != null) {
					arrowLocation = event.getHitEntity().getLocation();
				} else {
					arrowLocation = event.getHitBlock().getLocation();
				}
				
				player.getWorld().createExplosion(arrowLocation, 2, false, false);
			}
			
		}
		
	}
	
	@EventHandler
	public void onInteract(ProjectileLaunchEvent event) {
		
		if (event.getEntity().getShooter() instanceof Player) {

			Player player = (Player) event.getEntity().getShooter();
			
			if (Classe.isThisClasse(player, "Sentinelle") && Classe.getClasseObject(player).isOnCast() && Classe.getClasseObject(player).getActifLvl() == 3) {
				
				Map<Integer, ? extends ItemStack> map = player.getInventory().all(Material.CROSSBOW);
				map.forEach((k, v) -> {
					
					if (v.getItemMeta().getLocalizedName().equalsIgnoreCase("weaponSentinelle")) {
						
						CrossbowMeta crossbowMeta = (CrossbowMeta) v.getItemMeta();
						if (!crossbowMeta.hasChargedProjectiles()) crossbowMeta.addChargedProjectile(new ItemStack(Material.ARROW, 1));
						Bukkit.getScheduler().runTaskLater(PluginRpgMinecraft.getPlugin(), () -> v.setItemMeta(crossbowMeta), 5);
					}
					
				});
				
			}
			
		}
		
	}

}
