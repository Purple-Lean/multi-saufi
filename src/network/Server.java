package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	static ArrayList<ClientHandler> clients = new ArrayList<>();

	static ServerSocket ss;

	public static void runServer() throws IOException {
		ss = new ServerSocket(7331);

		while (true) {
			Socket s = null;

			try {
				s = ss.accept();

				System.out.println("A new client is connected : " + s);
				System.out.println("Assigning new thread for this client");

				ClientHandler ch = new ClientHandler(s);

				synchronized (clients) {
					clients.add(ch);
				}

				ch.start();

			} catch (Exception e) {
				s.close();
				e.printStackTrace();
			}
		}
	}

	public static void close() {
		try {
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class ClientHandler extends Thread {

	final Socket s;

	public ClientHandler(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		while (true) {
			break;
		}

		synchronized (Server.clients) {
			Server.clients.remove(this);
		}
	}
}