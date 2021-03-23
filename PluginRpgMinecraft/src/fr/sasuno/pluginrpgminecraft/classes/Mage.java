package fr.sasuno.pluginrpgminecraft.classes;

import org.bukkit.entity.Player;

public class Mage extends Classe {
	
	public Mage() {
		_classeName = "Mage";
		_maxHealth = 16;
		_weaponLvl = 1;
		_armorLvl = 1;
		_effectLvl = 1;
		_actifLvl = 1;
		_onCast = false;
		_onCooldown = false;
	}
	
	public Mage(int maxHealth, int weaponLvl, int armorLvl, int effectLvl, int actifLvl, boolean onCast, boolean onCooldown) {
		_classeName = "Mage";
		_maxHealth = maxHealth;
		_weaponLvl = weaponLvl;
		_armorLvl = armorLvl;
		_effectLvl = effectLvl;
		_actifLvl = actifLvl;
		_onCast = onCast;
		_onCooldown = onCooldown;
	}

	@Override
	public Classe updateStuff(Player player) {
		return null;
		// TODO Auto-generated method stub
		
	}
	
}