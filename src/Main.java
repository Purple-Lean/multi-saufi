import java.util.concurrent.TimeUnit;

import gui.MainMenu;
import gui.Splash;

public class Main {

	public static void main(String[] args) {

		ClientId.loadId();

		Splash sp = new Splash();

		try {
			TimeUnit.SECONDS.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		sp.setVisible(false);
		sp.dispose();

		MainMenu.startMainMenu();

	}

}
