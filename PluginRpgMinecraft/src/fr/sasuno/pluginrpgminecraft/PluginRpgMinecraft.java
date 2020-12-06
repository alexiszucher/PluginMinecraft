package fr.sasuno.pluginrpgminecraft;

import org.bukkit.plugin.java.JavaPlugin;

import fr.sasuno.pluginrpgminecraft.classe.Classe;
import fr.sasuno.pluginrpgminecraft.commands.CommandLoadRPG;
import fr.sasuno.pluginrpgminecraft.events.ListenerClass;

public class PluginRpgMinecraft extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("Le Plugin Zucher s'est allumé");
		getServer().getPluginManager().registerEvents(new ListenerClass(), this);
		
		//=======================================================================================================
		//	Liste des commandes à faire fonctionner entre le jeu et les fonctions appelées						/
		//========================================================================================================
		getCommand("loadRPG").setExecutor(new CommandLoadRPG());
	}
	
	@Override
	public void onDisable() {
		System.out.println("Le Plugin Zucher vient de s'éteindre");
	}
	
}
