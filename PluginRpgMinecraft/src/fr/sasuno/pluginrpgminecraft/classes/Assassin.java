package fr.sasuno.pluginrpgminecraft.classes;

public class Assassin extends Classe {
	
	public Assassin() {
		_classeName = "Assassin";
		_maxHealth = 20;
		_weaponLvl = 0;
		_armorLvl = 0;
		_effectLvl = 0;		
	}
	
	public Assassin(int maxHealth, int weaponLvl, int armorLvl, int effectLvl) {
		_classeName = "Assassin";
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