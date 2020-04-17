package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ErrorPopup extends JFrame {
	
	private static final long serialVersionUID = 6648972193325239949L;
	
	public ErrorPopup(String message) {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		setSize(screenSize.width / 8, -15 + screenSize.height / 16);
		setLocation(screenSize.width * 7 / 16, screenSize.height * 15 / 32);
		setUndecorated(true);
		setTitle("Multi-Saufi");
		setAutoRequestFocus(true);
		setAlwaysOnTop(true);

		JPanel bg = new JPanel();
		bg.setLayout(new BoxLayout(bg, BoxLayout.Y_AXIS));
		bg.setAlignmentX(JComponent.CENTER_ALIGNMENT);

		JLabel label = new JLabel(message);
		
		JButton button_ex = new JButton("Okay");
		JPanel panel = new JPanel();
		label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		label.setAlignmentY(JComponent.CENTER_ALIGNMENT);
		button_ex.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		button_ex.setAlignmentY(JComponent.CENTER_ALIGNMENT);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		panel.setAlignmentY(JComponent.CENTER_ALIGNMENT);

		bg.add(label);
		bg.add(button_ex);

		button_ex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component component = (Component) e.getSource();
				JFrame frame = (JFrame) SwingUtilities.getRoot(component);
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});

		bg.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(bg);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setVisible(true);

		changeCursor();
		setIcon();
		
	}

	private void changeCursor() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("../ressources/images/gui/cursor.png"));
		Cursor c = toolkit.createCustomCursor(image, new Point(0, 0), "beer");
		setCursor(c);
	}

	private void setIcon() {
		ImageIcon img = new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(getClass().getResource("../ressources/images/gui/logo_1024.png")));
		setIconImage(img.getImage());
	}

}