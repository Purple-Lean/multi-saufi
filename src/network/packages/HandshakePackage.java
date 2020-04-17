package network.packages;

public class HandshakePackage extends NetworkPackage {

	String password = "";

	public HandshakePackage(String password) {
		this.password = password;
		if (this.password == null) {
			this.password = "";
		}
	}

	public HandshakePackage() {

	}

	@Override
	byte[] getRawData() {
		return password.getBytes();
	}

	@Override
	byte getPackageType() {
		return PackageType.HANDSHAKE.type;
	}

	@Override
	void decode(byte[] data) {
		password = new String(data);
	}

}
