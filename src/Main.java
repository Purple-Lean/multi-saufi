import java.util.concurrent.TimeUnit;

public class Main {
	
	private static MainMenu mm = null;
	
	public static void main(String[] args) {
		
		ClientId.loadId();
		
		Splash sp = new Splash();
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		sp.setVisible(false);
		sp.dispose();
		
		startMainMenu();
		
	}
	
	public static void startMainMenu() {
		if (mm == null) {
			mm = new MainMenu();
		}
	}
	
	public static void closeMainMenu() {
		mm = null;
	}

}
