package fr.givrix.buyapple;

import org.bukkit.plugin.java.JavaPlugin;

import fr.givrix.buyapple.commands.CommandBuyApple;

public class BuyApple extends JavaPlugin {
	
	@Override
	public void onEnable() {
		
		getCommand("buyApple").setExecutor(new CommandBuyApple());
		
	}
}