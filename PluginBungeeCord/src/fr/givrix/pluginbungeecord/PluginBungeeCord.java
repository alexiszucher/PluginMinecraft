package fr.givrix.pluginbungeecord;

import fr.givrix.pluginbungeecord.events.ListenerProxyPing;
import net.md_5.bungee.api.plugin.Plugin;

public class PluginBungeeCord extends Plugin {
	
	@Override
	public void onEnable() {
		
		getProxy().getPluginManager().registerListener(this, new ListenerProxyPing());
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
