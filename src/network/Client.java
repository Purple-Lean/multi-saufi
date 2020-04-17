package network;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import network.packages.HandshakePackage;
import network.packages.NetworkPackage;

public class Client {

	static Client client;

	// true if no problem
	public static boolean start(String ip, String password) {
		client = new Client(ip, password);
		return client.s != null;
	}

	Socket s = null;
	boolean inLobby = true;
	String ip = null;
	String password = null;

	Client(String ip, String password) {
		try {
			s = new Socket(ip, 7331);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		this.ip = ip;
		this.password = password;
	}

	public static void runHandshake() throws UnknownHostException, IOException {

		NetworkPackage.send(client.s, new HandshakePackage(client.password));
		NetworkPackage np = NetworkPackage.receive(client.s);
		if (np == null || !(np instanceof HandshakePackage)) {
			System.out.println("Connection failed...");
		}

		client.s.close();
	}

}
