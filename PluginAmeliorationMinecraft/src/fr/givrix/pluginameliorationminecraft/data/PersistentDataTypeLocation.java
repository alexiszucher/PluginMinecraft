package fr.givrix.pluginameliorationminecraft.data;

import java.nio.ByteBuffer;

import org.bukkit.Location;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;

public class PersistentDataTypeLocation implements PersistentDataType<byte[], Location> {

	@Override
	public Location fromPrimitive(byte[] primitive, PersistentDataAdapterContext context) {
		ByteBuffer byteBuffer = ByteBuffer.wrap(primitive);
		double x = byteBuffer.getDouble();
		double y = byteBuffer.getDouble();
		double z = byteBuffer.getDouble();
		float yaw = byteBuffer.getFloat();
		float pitch = byteBuffer.getFloat();
		return new Location(null, x, y, z, yaw, pitch);
	}

	@Override
	public Class<Location> getComplexType() {
		return Location.class;
	}

	@Override
	public Class<byte[]> getPrimitiveType() {
		return byte[].class;
	}

	@Override
	public byte[] toPrimitive(Location complex, PersistentDataAdapterContext context) {
		ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[32]);
		byteBuffer.putDouble(complex.getX());
		byteBuffer.putDouble(complex.getY());
		byteBuffer.putDouble(complex.getZ());
		byteBuffer.putFloat(complex.getYaw());
		byteBuffer.putFloat(complex.getPitch());
		return byteBuffer.array();
	}

}