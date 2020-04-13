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

import javax.swing.BoxLayout;
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

		JPanel bg = new JPanel();
		bg.setLayout(new BoxLayout(bg, BoxLayout.Y_AXIS));
		bg.setAlignmentX(JComponent.CENTER_ALIGNMENT);

		JPanel button_jg_p= new JPanel();
		JPanel button_hg_p= new JPanel();
		JPanel button_op_p= new JPanel();
		JPanel button_cr_p= new JPanel();
		JPanel button_ex_p= new JPanel();
		
		JButton button_jg = new JButton("Join Game");
		JButton button_hg = new JButton("Host Game");
		JButton button_op = new JButton("Options");
		JButton button_cr = new JButton("Credits");
		JButton button_ex = new JButton("Quit");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		//panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		panel.setAlignmentY(JComponent.CENTER_ALIGNMENT);
        panel.setPreferredSize(new Dimension(100, 100));
        panel.setMaximumSize(new Dimension(screenSize.width/4, screenSize.height/2));
        panel.setBorder(new EmptyBorder(screenSize.height/4, 0, 0, 0));
        
        button_jg_p.setBorder(new EmptyBorder(0, 0, screenSize.height/16, 0));
        button_hg_p.setBorder(new EmptyBorder(0, 0, screenSize.height/16, 0));
        button_op_p.setBorder(new EmptyBorder(0, 0, screenSize.height/16, 0));
        button_cr_p.setBorder(new EmptyBorder(0, 0, screenSize.height/16, 0));

        button_jg_p.add(button_jg);
        button_hg_p.add(button_hg);
        button_op_p.add(button_op);
        button_cr_p.add(button_cr);
        button_ex_p.add(button_ex);
		
		panel.add(button_jg_p);
		panel.add(button_hg_p);
		panel.add(button_op_p);
		panel.add(button_cr_p);
		panel.add(button_ex_p);
		
		button_jg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Client.start();
            }
        });
		
		button_hg.addActionListener(new ActionListener() {
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
		
		bg.add(panel);
		getContentPane().add(bg);
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
