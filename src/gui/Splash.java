package gui;

import java.awt.AlphaComposite;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class Splash extends JFrame {

	private static final long serialVersionUID = -8425079915601941797L;

	static Font standFont = new Font("TimesRoman", Font.BOLD, 30);
	static Font standFont2 = new Font("TimesRoman", Font.BOLD, 60);
	static Font standFont3 = new Font("TimesRoman", Font.BOLD, 120);

	public Splash() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setUndecorated(true);
		setTitle("Multi-Saufi");
		setSize(screenSize.width / 2, screenSize.height / 2);
		setLocation(screenSize.width / 4, screenSize.height / 4);

		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setLayout(new OverlayLayout(backgroundPanel));

		JPanel panel = new JPanel();

		panel.setLayout(new OverlayLayout(panel));

		backgroundPanel.add(new JLabel(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(getClass().getResource("../ressources/images/splash/splash2.png"))
						.getScaledInstance(screenSize.width / 2, screenSize.height / 2, Image.SCALE_SMOOTH))));

		backgroundPanel.setLayout(new OverlayLayout(backgroundPanel));
		panel.add(backgroundPanel);

		setContentPane(panel);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setIcon();
		setResizable(false);
		setAutoRequestFocus(true);
		setAlwaysOnTop(true);
		setVisible(true);

		hideCursor();

	}

	private void hideCursor() {
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
		setCursor(blankCursor);
	}

	private void setIcon() {
		ImageIcon img = new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(getClass().getResource("../ressources/images/gui/logo_1024.png")));
		setIconImage(img.getImage());
	}

	BufferedImage createResizedCopy(Image originalImage, int scaledWidth, int scaledHeight, boolean preserveAlpha) {
		int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
		BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
		Graphics2D g = scaledBI.createGraphics();
		if (preserveAlpha) {
			g.setComposite(AlphaComposite.Src);
		}
		g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
		g.dispose();
		return scaledBI;
	}

}
