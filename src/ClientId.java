import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class ClientId {
	
	static UUID clientId = null;
	
	public static void loadId() {
		clientId = readId();
		if (clientId == null) {
			clientId = getNewId();
		}
	}
	
	private static UUID readId() {
		File f = new File("id.txt");
		if(f.exists() && !f.isDirectory()) { 
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(f));
				String st = br.readLine();
				UUID id = UUID.fromString(st);
				br.close();
				return id;
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
		}
		return null;
	}
	
	private static UUID getNewId() {
		UUID id = UUID.randomUUID();
		FileWriter myWriter;
		try {
			myWriter = new FileWriter("id.txt");
		    myWriter.write(id.toString());
		    myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return id;
	}

}
