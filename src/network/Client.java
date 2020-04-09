package network;

import java.io.IOException;
import java.net.Socket;

public class Client {
	
	Socket s = null;
	
	Client(String ip) {
		try {
			s = new Socket(ip, 7331);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
