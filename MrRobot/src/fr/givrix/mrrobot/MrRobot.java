package fr.givrix.mrrobot;

import org.bukkit.plugin.java.JavaPlugin;

import fr.givrix.mrrobot.commands.CommandTest;

public class MrRobot extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getCommand("test").setExecutor(new CommandTest());
	}
}