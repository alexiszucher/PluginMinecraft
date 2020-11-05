package fr.zucher.rpg;

import org.bukkit.plugin.java.JavaPlugin;

import fr.zucher.cmd.CommandAddHearts;
import fr.zucher.cmd.CommandChoiceClass;
import fr.zucher.cmd.CommandClassMenu;
import fr.zucher.cmd.CommandGetStuffDiamond;
import fr.zucher.cmd.CommandGetStuffIron;
import fr.zucher.cmd.CommandResistance;
import fr.zucher.listener.EnterInTheWorld;

public class Main extends JavaPlugin {
	
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
