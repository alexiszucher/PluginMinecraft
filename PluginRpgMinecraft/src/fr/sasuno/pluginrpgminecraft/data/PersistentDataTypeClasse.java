package fr.sasuno.pluginrpgminecraft.data;

import java.nio.ByteBuffer;

import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;

import fr.sasuno.pluginrpgminecraft.classes.Archer;
import fr.sasuno.pluginrpgminecraft.classes.Assassin;
import fr.sasuno.pluginrpgminecraft.classes.Berserker;
import fr.sasuno.pluginrpgminecraft.classes.Classe;
import fr.sasuno.pluginrpgminecraft.classes.Mage;
import fr.sasuno.pluginrpgminecraft.classes.Paladin;
import fr.sasuno.pluginrpgminecraft.classes.Sentinelle;
import fr.sasuno.pluginrpgminecraft.classes.Triton;

public class PersistentDataTypeClasse implements PersistentDataType<byte[], Classe> {

	@Override
	public Classe fromPrimitive(byte[] primitive, PersistentDataAdapterContext context) {
		ByteBuffer byteBuffer = ByteBuffer.wrap(primitive);
		int lengthClasse = (byteBuffer.limit() - 16) / 2;
		String classeName = "";
		for (int i = 0; i < lengthClasse; i++) {
			classeName += byteBuffer.getChar();
		}		
		int maxHealth = byteBuffer.getInt();
		int weaponLvl = byteBuffer.getInt();
		int armorLvl = byteBuffer.getInt();
		int effectLvl = byteBuffer.getInt();
		if (classeName.equalsIgnoreCase("Paladin")) return new Paladin(maxHealth, weaponLvl, armorLvl, effectLvl);
		else if (classeName.equalsIgnoreCase("Berserker")) return new Berserker(maxHealth, weaponLvl, armorLvl, effectLvl);
		else if (classeName.equalsIgnoreCase("Assassin")) return new Assassin(maxHealth, weaponLvl, armorLvl, effectLvl);
		else if (classeName.equalsIgnoreCase("Archer")) return new Archer(maxHealth, weaponLvl, armorLvl, effectLvl);
		else if (classeName.equalsIgnoreCase("Triton")) return new Triton(maxHealth, weaponLvl, armorLvl, effectLvl);
		else if (classeName.equalsIgnoreCase("Sentinelle")) return new Sentinelle(maxHealth, weaponLvl, armorLvl, effectLvl);
		else return new Mage(maxHealth, weaponLvl, armorLvl, effectLvl);
	}

	@Override
	public Class<Classe> getComplexType() {
		return Classe.class;
	}

	@Override
	public Class<byte[]> getPrimitiveType() {
		return byte[].class;
	}

	@Override
	public byte[] toPrimitive(Classe complex, PersistentDataAdapterContext context) {
		String classeName = complex.getClasseName();
		int lengthClasse = classeName.length();
		ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[2*lengthClasse + 16]);
		for (int i = 0; i < lengthClasse; i++) {
			byteBuffer.putChar(classeName.charAt(i));
		}
		byteBuffer.putInt(complex.getMaxHealth());
		byteBuffer.putInt(complex.getWeaponLvl());
		byteBuffer.putInt(complex.getArmorLvl());
		byteBuffer.putInt(complex.getEffectLvl());
		return byteBuffer.array();
	}

}