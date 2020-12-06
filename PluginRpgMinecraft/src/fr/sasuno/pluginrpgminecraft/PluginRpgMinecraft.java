package fr.sasuno.pluginrpgminecraft;

import org.bukkit.plugin.java.JavaPlugin;

import fr.sasuno.pluginrpgminecraft.classe.Classe;
import fr.sasuno.pluginrpgminecraft.commands.CommandLoadRPG;
import fr.sasuno.pluginrpgminecraft.events.ListenerClass;

public class PluginRpgMinecraft extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("Le Plugin Zucher s'est allum�");
		getServer().getPluginManager().registerEvents(new ListenerClass(), this);
		
		//=======================================================================================================
		//	Liste des commandes � faire fonctionner entre le jeu et les fonctions appel�es						/
		//========================================================================================================
		getCommand("loadRPG").setExecutor(new CommandLoadRPG());
	}
	
	@Override
	public void onDisable() {
		System.out.println("Le Plugin Zucher vient de s'�teindre");
	}
	
}
