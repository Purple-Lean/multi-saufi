import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class JoinGamePopup extends JFrame {

	private static final long serialVersionUID = 5153752319840062711L;

	static JoinGamePopup client = null;

	static void start() {
		if (client == null && HostGamePopup.host == null) {
			client = new JoinGamePopup();
		}
	}

	public JoinGamePopup() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setSize(screenSize.width / 4, screenSize.height / 8);
		setLocation(screenSize.width * 3 / 8, screenSize.height * 7 / 16);
		// setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setTitle("Multi-Saufi");
		setAutoRequestFocus(true);
		setAlwaysOnTop(true);

		JPanel bg = new JPanel();
		bg.setLayout(new BoxLayout(bg, BoxLayout.Y_AXIS));
		bg.setAlignmentX(JComponent.CENTER_ALIGNMENT);

		JLabel label = new JLabel("Address:");
		label.setHorizontalAlignment(JLabel.CENTER);

		JLabel label2 = new JLabel("Lobby-Password:");
		label2.setHorizontalAlignment(JLabel.CENTER);

		JTextField tf = new JTextField("ip/hostname:port", 100);

		JPasswordField jp = new JPasswordField();

		JPanel button_jo_p = new JPanel();
		JPanel button_ex_p = new JPanel();

		JButton button_jo = new JButton("Connect");
		JButton button_ex = new JButton("Abort");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2));
		// panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		panel.setAlignmentY(JComponent.CENTER_ALIGNMENT);
		// panel.setPreferredSize(new Dimension(100, 100));

		// button_ex_p.setBorder(new EmptyBorder(0, 0, screenSize.height/16, 0));
		// button_jo_p.setBorder(new EmptyBorder(0, 0, screenSize.height/16, 0));

		button_jo_p.add(button_jo);
		button_ex_p.add(button_ex);

		panel.add(label);
		panel.add(tf);
		panel.add(label2);
		panel.add(jp);
		panel.add(button_jo_p);
		panel.add(button_ex_p);

		button_jo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		button_ex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component component = (Component) e.getSource();
				JFrame frame = (JFrame) SwingUtilities.getRoot(component);
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});

		panel.setBorder(BorderFactory.createLineBorder(Color.black));

		bg.add(panel);
		getContentPane().add(bg);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				JoinGamePopup.client = null;
			}
		});

		setVisible(true);

		changeCursor();
		setIcon();

	}

	private void changeCursor() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("ressources/images/gui/cursor.png"));
		Cursor c = toolkit.createCustomCursor(image, new Point(0, 0), "beer");
		setCursor(c);
	}

	private void setIcon() {
		ImageIcon img = new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(getClass().getResource("ressources/images/gui/logo_1024.png")));
		setIconImage(img.getImage());
	}

}
