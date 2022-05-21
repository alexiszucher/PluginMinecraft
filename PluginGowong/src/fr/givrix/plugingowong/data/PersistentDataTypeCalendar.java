package fr.givrix.plugingowong.data;

import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;

public class PersistentDataTypeCalendar implements PersistentDataType<byte[], Calendar> {

	@Override
	public Calendar fromPrimitive(byte[] primitive, PersistentDataAdapterContext context) {
		ByteBuffer byteBuffer = ByteBuffer.wrap(primitive);
		int year = byteBuffer.getInt();
		int month = byteBuffer.getInt();
		int day = byteBuffer.getInt();
		return new GregorianCalendar(year, month, day);
	}

	@Override
	public Class<Calendar> getComplexType() {
		return Calendar.class;
	}

	@Override
	public Class<byte[]> getPrimitiveType() {
		return byte[].class;
	}

	@Override
	public byte[] toPrimitive(Calendar complex, PersistentDataAdapterContext context) {
		ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[12]);
		byteBuffer.putInt(complex.get(Calendar.YEAR));
		byteBuffer.putInt(complex.get(Calendar.MONTH));
		byteBuffer.putInt(complex.get(Calendar.DAY_OF_MONTH));
		return byteBuffer.array();
	}

}
