package fr.sasuno.pluginrpgminecraft.classes;

public class Mage extends Classe {
	
	public Mage() {
		_classeName = "Mage";
		_maxHealth = 16;
		_weaponLvl = 0;
		_armorLvl = 0;
		_effectLvl = 0;		
	}
	
	public Mage(int maxHealth, int weaponLvl, int armorLvl, int effectLvl) {
		_classeName = "Mage";
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