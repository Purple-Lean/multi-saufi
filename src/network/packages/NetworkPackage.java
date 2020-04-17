package network.packages;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;

public abstract class NetworkPackage {

	public static void send(Socket s, NetworkPackage p) {
		try {
			DataOutputStream dOut = new DataOutputStream(s.getOutputStream());
			dOut.write(p.getFormattedData());
			dOut.flush();
			dOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static NetworkPackage receive(Socket s) {
		try {
			DataInputStream dIn = new DataInputStream(s.getInputStream());
			int length = dIn.readInt();
			byte type = dIn.readByte();
			int read = 0;
			byte[] data = new byte[length];
			while (read < length) {
				read += dIn.read(data, read, length - read);
			}
			NetworkPackage np = null;
			for (PackageType pt : PackageType.values()) {
				if (pt.type == type) {
					try {
						np = pt.c.newInstance();
						break;
					} catch (InstantiationException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
			np.decode(data);
			return np;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	enum PackageType {

		//@formatter:off
		HANDSHAKE(1, HandshakePackage.class),
		PLAYERNAME(2, null),
		PLAYERICON(3, null),
		PLAYERID(4, null),
		PLAYERREADY(5, null),
		PLAYERUNREADY(6, null),
		PLAYERCHAT(7, null),
		LOBBYSETTINGS(8, null),
		PLAYERKICK(9, null),
		PLAYERADD(10, null),
		PLAYERREMOVE(11, null),
		GAMESTART(12, null),
		LOBBYCLOSED(13, null),
		STOPCONNECTION(14, null),
		MULTIPACKAGE(15, null);
		//@formatter:on

		byte type = 0;
		Class<? extends NetworkPackage> c;

		private PackageType(int type, Class<? extends NetworkPackage> c) {
			this.type = (byte) type;
			this.c = c;
		}

	}

	abstract byte[] getRawData();

	abstract byte getPackageType();

	abstract void decode(byte[] data);

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
