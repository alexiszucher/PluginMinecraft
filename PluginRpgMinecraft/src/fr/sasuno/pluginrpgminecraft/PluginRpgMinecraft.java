package fr.sasuno.pluginrpgminecraft;

import org.bukkit.plugin.java.JavaPlugin;

import fr.sasuno.pluginrpgminecraft.classe.Classe;
import fr.sasuno.pluginrpgminecraft.commands.CommandAddHearts;
import fr.sasuno.pluginrpgminecraft.commands.CommandArmorUp;
import fr.sasuno.pluginrpgminecraft.commands.CommandChoiceClass;
import fr.sasuno.pluginrpgminecraft.commands.CommandClassMenu;
import fr.sasuno.pluginrpgminecraft.commands.CommandGetStuffDiamond;
import fr.sasuno.pluginrpgminecraft.commands.CommandGetStuffIron;
import fr.sasuno.pluginrpgminecraft.commands.CommandResistance;
import fr.sasuno.pluginrpgminecraft.commands.CommandWeaponUp;
import fr.sasuno.pluginrpgminecraft.events.EnterInTheWorld;

public class PluginRpgMinecraft extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("Le Plugin Zucher s'est allumé");
		getServer().getPluginManager().registerEvents(new EnterInTheWorld(), this);
		
		//=======================================================================================================
		//	Liste des commandes à faire fonctionner entre le jeu et les fonctions appelées						/
		//========================================================================================================
		getCommand("class").setExecutor(new CommandChoiceClass());
		getCommand("menuclass").setExecutor(new CommandClassMenu());
		getCommand("addHearts").setExecutor(new CommandAddHearts());
		getCommand("resistance").setExecutor(new CommandResistance());
		getCommand("getStuffIron").setExecutor(new CommandGetStuffIron());
		getCommand("getStuffDiamond").setExecutor(new CommandGetStuffDiamond());
		getCommand("weaponup").setExecutor(new CommandWeaponUp());
		getCommand("armorup").setExecutor(new CommandArmorUp());
	}
	
	@Override
	public void onDisable() {
		System.out.println("Le Plugin Zucher vient de s'éteindre");
	}
	
}
