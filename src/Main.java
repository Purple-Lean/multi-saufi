import java.util.concurrent.TimeUnit;

public class Main {
	
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
		
		@SuppressWarnings("unused")
		MainMenu mm = new MainMenu();
		
	}

}
