
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mainMenu extends JFrame {

	private JPanel upperPanel;
	private JPanel lowerPanel;
	
	private JLabel labelHigherLower;
	private JLabel labelHorse;
	private JLabel labelBus;
	
	private JButton buttonHigherLower;
	private JButton buttonHorse;
	private JButton buttonBus;
	
	Font standFont = new Font ("TimesRoman", Font.BOLD, 30);
	
	higherLowerListener listener1 = new higherLowerListener();
	horseListener listener2 = new horseListener();
	busListener listener3 = new busListener();
	
	public mainMenu() {
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setSize(900, 700);
		setMinimumSize(getSize());
		setLocationRelativeTo(null);		
		setTitle("Number Games");
		setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("IconTop.png")));
		setLayout(new BorderLayout());
		
		initComponents();
		
		add(upperPanel, BorderLayout.PAGE_START);
		upperPanel.setLayout(new GridLayout(1, 3));
		
		upperPanel.add(labelHigherLower);
		labelHigherLower.setVerticalAlignment(JLabel.CENTER);
		labelHigherLower.setHorizontalAlignment(JLabel.CENTER);
		labelHigherLower.setFont(standFont);
		
		upperPanel.add(labelHorse);
		labelHorse.setVerticalAlignment(JLabel.CENTER);
		labelHorse.setHorizontalAlignment(JLabel.CENTER);
		labelHorse.setFont(standFont);
		
		upperPanel.add(labelBus);
		labelBus.setHorizontalAlignment(JLabel.CENTER);
		labelBus.setVerticalAlignment(JLabel.CENTER);
		labelBus.setFont(standFont);
		
		add(lowerPanel, BorderLayout.CENTER);
		lowerPanel.setLayout(new GridLayout(1, 3));
		
		lowerPanel.add(buttonHigherLower);
		ImageIcon higherLowerIcon = new ImageIcon("HigherLower.png");
		Image higherLowerImg = higherLowerIcon.getImage();  
		Image newHigherLowerImg = higherLowerImg.getScaledInstance( 200, 300,  java.awt.Image.SCALE_SMOOTH ) ;  
		ImageIcon newHigherLowerIcon = new ImageIcon(newHigherLowerImg);
		buttonHigherLower.setIcon(newHigherLowerIcon);
		buttonHigherLower.addActionListener(listener1);
		
		lowerPanel.add(buttonHorse);
		ImageIcon horseIcon = new ImageIcon("Horse.png");
		Image horseImg = horseIcon.getImage();  
		Image newHorseImg = horseImg.getScaledInstance( 280, 250,  java.awt.Image.SCALE_SMOOTH ) ;  
		ImageIcon newHorseIcon = new ImageIcon(newHorseImg);
		buttonHorse.setIcon(newHorseIcon);
		buttonHorse.addActionListener(listener2);
		
		lowerPanel.add(buttonBus);
		ImageIcon BusIcon = new ImageIcon("Bus.png");
		Image BusImg = BusIcon.getImage();  
		Image newBusImg = BusImg.getScaledInstance( 450, 400,  java.awt.Image.SCALE_SMOOTH ) ;  
		ImageIcon newBusIcon = new ImageIcon(newBusImg);
		buttonBus.setIcon(newBusIcon);
		buttonBus.addActionListener(listener3);
		
	}
	
	private void initComponents() {
		
		upperPanel = new JPanel();
		lowerPanel = new JPanel();
		
		labelHigherLower = new JLabel("Higher Lower Game");
		labelHorse = new JLabel("Horse Race");
		labelBus = new JLabel("Bus Driver");
		
		buttonHigherLower = new JButton();
		buttonHorse = new JButton();
		buttonBus = new JButton();
		
	}
	
}
