package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class Lobby extends JFrame {

	private static final long serialVersionUID = 1641972348426503448L;

	static Lobby lobby = null;

	static void start(String address) {
		if (lobby == null && HostGamePopup.host == null && JoinGamePopup.client == null) {
			lobby = new Lobby(address);
		}
	}

	public Lobby(String address) {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setSize(screenSize.width / 2, screenSize.height * 3 / 4);
		setLocation(screenSize.width * 1 / 4, screenSize.height * 1 / 8);
		setUndecorated(true);
		setTitle("Multi-Saufi");
		setAutoRequestFocus(true);
		setAlwaysOnTop(true);

		JPanel bg = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		bg.setLayout(gbl);
		// bg.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.BOTH;

		JPanel playerPanel = new JPanel();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 3;
		gbl.setConstraints(playerPanel, c);
		playerPanel.setBackground(Color.RED);
		bg.add(playerPanel);

		JPanel settingsPanel = new JPanel();
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 4;
		gbl.setConstraints(settingsPanel, c);
		settingsPanel.setBackground(Color.BLUE);
		bg.add(settingsPanel);

		JPanel chatPanel = new JPanel();
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		c.gridheight = 2;
		gbl.setConstraints(chatPanel, c);
		chatPanel.setBackground(Color.GREEN);
		bg.add(chatPanel);

		JPanel buttonsPanel = new JPanel();
		c.gridx = 2;
		c.gridy = 4;
		c.gridwidth = 3;
		c.gridheight = 1;
		gbl.setConstraints(buttonsPanel, c);
		buttonsPanel.setBackground(Color.YELLOW);
		bg.add(buttonsPanel);

		//playerPanel.setLayout(new GridBagLayout());

		DefaultListModel<String> dm = new DefaultListModel<String>();

		dm.addElement("Player A");
		dm.addElement("Player B");

		JList<String> playerList = new JList<String>(dm);
		playerList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		playerList.setLayoutOrientation(JList.VERTICAL);
		playerList.setVisibleRowCount(-1);

		JScrollPane listScroller = new JScrollPane(playerList);
		listScroller.setPreferredSize(new Dimension(80, screenSize.height * 8 / 10 * 4 / 5 * 3 / 4));
		listScroller.setBorder(new EmptyBorder(0, 0, 0, 0));

		playerPanel
				.setPreferredSize(new Dimension(screenSize.width * 199 / 500 / 2, screenSize.height * 4 / 5 * 3 / 4));
		playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));

		JPanel playerText = new JPanel();
		JPanel playerButtons = new JPanel();

		JButton button_kick = new JButton("Kick");
		JButton button_ban = new JButton("Ban 5min");
		JButton button_info = new JButton("Info");

		JLabel playerTextLabel = new JLabel("Players:");
		playerTextLabel.setAlignmentX(0.0f);
		playerText.add(playerTextLabel);
		playerPanel.add(playerText);
		playerPanel.add(listScroller);
		playerButtons.add(button_kick);
		playerButtons.add(button_ban);
		playerButtons.add(button_info);
		playerPanel.add(playerButtons);
		
		
		chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));
		
	    JTextArea chatOutputField = new JTextArea(1, 30);
	    chatOutputField.setEditable(false);
	    chatOutputField.add(new JLabel("<Player> joined the game."));
	    
	    JScrollPane scroll = new JScrollPane(chatOutputField);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JPanel chatInputPanel = new JPanel();
		chatInputPanel.setLayout(new BoxLayout(chatInputPanel, BoxLayout.X_AXIS));
		
	    JTextArea textArea = new JTextArea("Enter text here...", 1, 30);
	    JScrollPane chatInput = new JScrollPane(textArea);
	    chatInput.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    chatInputPanel.add(chatInput);
	    
	    //chatPanel.add(new JLabel("Chat"));
	    chatPanel.add(scroll);
	    chatPanel.add(chatInputPanel);
		
	    

		settingsPanel.setPreferredSize(new Dimension(screenSize.width * 3 / 5 / 2, screenSize.height * 9 / 10 * 3 / 4));
		
		GridBagLayout gbl2 = new GridBagLayout();
		buttonsPanel.setLayout(gbl2);
		GridBagConstraints cc = new GridBagConstraints();


	    JButton send_chat_button = new JButton("Send Chat");
		JButton button_re = new JButton("Ready");
		JButton button_ex = new JButton("Leave");
		JButton button_jo = new JButton("Start");
		
		JPanel houseButtons = new JPanel();
		houseButtons.setLayout(new BoxLayout(houseButtons, BoxLayout.X_AXIS));
		houseButtons.setAlignmentY(0.5f);

		houseButtons.add(button_re);
		houseButtons.add(button_ex);
		houseButtons.add(button_jo);

		cc.fill = GridBagConstraints.BOTH;

		cc.gridx = 0;
		cc.gridy = 0;
		cc.gridwidth = 1;
		cc.gridheight = 3;
		gbl2.setConstraints(send_chat_button, cc);
		buttonsPanel.add(send_chat_button);
		

		cc.gridx = 1;
		cc.gridy = 1;
		cc.gridwidth = 5;
		cc.gridheight = 1;
		gbl2.setConstraints(houseButtons, cc);
		buttonsPanel.add(houseButtons);
		
		buttonsPanel
				.setPreferredSize(new Dimension(screenSize.width * 3 / 5 / 2, screenSize.height * 99 / 1000 * 3 / 4));

		// panel.setBorder(BorderFactory.createLineBorder(Color.black));

		bg.setBorder(BorderFactory.createLineBorder(Color.black));

		getContentPane().add(bg);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

		changeCursor();
		setIcon();

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

		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				Lobby.lobby = null;
			}
		});

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
