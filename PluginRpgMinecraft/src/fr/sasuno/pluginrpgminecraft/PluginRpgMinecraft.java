package fr.sasuno.pluginrpgminecraft;

import org.bukkit.plugin.java.JavaPlugin;

import fr.sasuno.pluginrpgminecraft.commands.*;
import fr.sasuno.pluginrpgminecraft.events.*;

public class PluginRpgMinecraft extends JavaPlugin {

	@Override
	public void onEnable() {
		System.out.println("Le Plugin Zucher s'est allumé");
		getServer().getPluginManager().registerEvents(new EnterInTheWorld(), this);
		getCommand("class").setExecutor(new CommandChoiceClass());
		getCommand("menuclass").setExecutor(new CommandClassMenu());
		getCommand("addHearts").setExecutor(new CommandAddHearts());
		getCommand("resistance").setExecutor(new CommandResistance());
		getCommand("getStuffIron").setExecutor(new CommandGetStuffIron());
		getCommand("getStuffDiamond").setExecutor(new CommandGetStuffDiamond());
	}
	
	@Override
	public void onDisable() {
		System.out.println("Le Plugin Zucher vient de s'éteindre");
	}
	
}
