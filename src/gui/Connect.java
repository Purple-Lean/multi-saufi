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
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Connect extends JFrame {

	private static final long serialVersionUID = 5622599683122069424L;
	
	static Connect connect = null;
	private static Timer timer;
	
	static void start(String address) {
		if (connect == null) {
			connect = new Connect(address);
		}
	}

	public Connect(String address) {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		setSize(screenSize.width / 8, screenSize.height / 16);
		setLocation(screenSize.width * 7 / 16, screenSize.height * 15 / 32);
		// setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setTitle("Multi-Saufi");
		setAutoRequestFocus(true);
		setAlwaysOnTop(true);

		JPanel bg = new JPanel();
		bg.setLayout(new BoxLayout(bg, BoxLayout.Y_AXIS));
		bg.setAlignmentX(JComponent.CENTER_ALIGNMENT);

		JLabel label = new JLabel("Trying to reach " + address);
		JLabel label2 = new JLabel("Connecting     ");
		
		JButton button_ex = new JButton("Cancel");
		JPanel panel = new JPanel();
		label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		label.setAlignmentY(JComponent.CENTER_ALIGNMENT);
		label2.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		label2.setAlignmentY(JComponent.CENTER_ALIGNMENT);
		button_ex.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		button_ex.setAlignmentY(JComponent.CENTER_ALIGNMENT);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		panel.setAlignmentY(JComponent.CENTER_ALIGNMENT);

		bg.add(label);
		bg.add(label2);
		bg.add(button_ex);

		button_ex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component component = (Component) e.getSource();
				JFrame frame = (JFrame) SwingUtilities.getRoot(component);
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});

		bg.setBorder(BorderFactory.createLineBorder(Color.black));
		//bg.add(panel);
		getContentPane().add(bg);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				Connect.connect = null;
				timer.cancel();
			}
		});

		setVisible(true);

		changeCursor();
		setIcon();
		
		timer = new Timer();
		timer.scheduleAtFixedRate(new ScheduleTask(label2), 0l, 200l); 
		
	}
		
	private class ScheduleTask extends TimerTask {
		
		JLabel b = null;
		
		int counter = 0;
		
		public ScheduleTask(JLabel b) {
			this.b = b;
		}
		
        @Override
        public void run() {
            b.setText("Connecting"+new String(new char[counter]).replace("\0", ".")+new String(new char[5-counter]).replace("\0", " "));
            counter++;
            counter = counter%6;
        }
        
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
