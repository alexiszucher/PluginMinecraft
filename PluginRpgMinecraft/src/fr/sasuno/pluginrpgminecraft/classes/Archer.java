package fr.sasuno.pluginrpgminecraft.classes;

public class Archer extends Classe {
	
	public Archer() {
		_classeName = "Archer";
		_maxHealth = 20;
		_weaponLvl = 0;
		_armorLvl = 0;
		_effectLvl = 0;		
	}
	
	public Archer(int maxHealth, int weaponLvl, int armorLvl, int effectLvl) {
		_classeName = "Archer";
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