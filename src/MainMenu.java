import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;


public class MainMenu extends JFrame {

	private static final long serialVersionUID = -3088890058631223710L;

	public MainMenu() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setTitle("Multi-Saufi");

        
		JButton button_jg = new JButton("Join Game");
		JButton button_hg = new JButton("Host Game");
		JButton button_op = new JButton("Options");
		JButton button_cr = new JButton("Credits");
		JButton button_ex = new JButton("Quit");

		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new GridBagLayout());
		this.add(mainpanel);
        mainpanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		
		JPanel menupanel = new JPanel();
		mainpanel.add(menupanel, new GridBagConstraints());
		menupanel.setLayout(new BoxLayout(menupanel, BoxLayout.Y_AXIS));
		menupanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		
		menupanel.setPreferredSize(new Dimension(screenSize.width/4, screenSize.height/4));
        menupanel.setMaximumSize(new Dimension(screenSize.width/4, screenSize.height/2));
        menupanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
        menupanel.add(button_jg);
        menupanel.add(Box.createVerticalGlue());
        menupanel.add(button_hg);
        menupanel.add(Box.createVerticalGlue());
        menupanel.add(button_op);
        menupanel.add(Box.createVerticalGlue());
        menupanel.add(button_cr);
        menupanel.add(Box.createVerticalGlue());
        menupanel.add(button_ex);
        
        button_jg.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button_hg.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button_op.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button_cr.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button_ex.setAlignmentX(JButton.CENTER_ALIGNMENT);
		
		button_jg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Client.start();
            }
        });
		
		button_hg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Host.start();
            }
        });
		
		button_ex.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Main.closeMainMenu();
                Component component = (Component) e.getSource();
                JFrame frame = (JFrame) SwingUtilities.getRoot(component);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		ImageIcon img = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("ressources/images/gui/logo_1024.png")));
		setIconImage(img.getImage());
	}

}
