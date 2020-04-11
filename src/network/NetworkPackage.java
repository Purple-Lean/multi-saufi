package network;

import java.nio.ByteBuffer;

public abstract class NetworkPackage {

	abstract byte[] getRawData();

	abstract byte getPackageType();

	public byte[] getFormattedData() {
		byte[] rawData = getRawData();
		ByteBuffer bb = ByteBuffer.allocate(rawData.length + 5);
		bb.putInt(rawData.length);
		bb.put(getPackageType());
		bb.put(rawData);
		return bb.array();
	}

	byte[] intToBytes(final int i) {
		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.putInt(i);
		return bb.array();
	}

}
