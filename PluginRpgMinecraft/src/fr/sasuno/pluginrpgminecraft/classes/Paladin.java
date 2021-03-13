package fr.sasuno.pluginrpgminecraft.classes;

public class Paladin extends Classe {
	
	public Paladin() {
		_classeName = "Paladin";
		_maxHealth = 28;
		_weaponLvl = 0;
		_armorLvl = 0;
		_effectLvl = 0;		
	}
	
	public Paladin(int maxHealth, int weaponLvl, int armorLvl, int effectLvl) {
		_classeName = "Paladin";
		_maxHealth = maxHealth;
		_weaponLvl = weaponLvl;
		_armorLvl = armorLvl;
		_effectLvl = effectLvl;			
	}

	@Override
	public void giveDefaultStuff() {
		// TODO Auto-generated method stub
		
	}
	
}