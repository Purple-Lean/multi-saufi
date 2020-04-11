
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class higherLowerListener extends JFrame implements ActionListener {

	JPanel up;
	JPanel down;
	JLabel scorePlatePlayer1;
	JLabel scorePlayer1;
	JLabel numberPlayer1;
	JLabel scorePlatePlayer2;
	JLabel scorePlayer2;
	JLabel numberPlayer2;
	JButton play;
	
	Font standFont = new Font ("TimesRoman", Font.BOLD, 60);
	Font standFont2 = new Font ("TimesRoman", Font.BOLD, 120);
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		JFrame higherLowerGui = new JFrame();
		
		higherLowerGui.setVisible(true);
		higherLowerGui.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		higherLowerGui.setSize(900, 700);
		higherLowerGui.setMinimumSize(getSize());
		higherLowerGui.setLocationRelativeTo(null);		
		higherLowerGui.setTitle("Number Games, HigherLowerGame");
		higherLowerGui.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("IconTop.png")));
		higherLowerGui.setLayout(new BorderLayout());
		
		initComponents();
		
		higherLowerGui.add(up, BorderLayout.PAGE_START);
		up.setLayout(new GridLayout(1, 2));
		higherLowerGui.add(down, BorderLayout.PAGE_END);
		down.setLayout(new GridLayout(1, 2));
		
		up.add(scorePlatePlayer1);
		scorePlatePlayer1.setFont(standFont);
		up.add(scorePlayer1);
		scorePlayer1.setFont(standFont);
		higherLowerGui.add(numberPlayer1, BorderLayout.LINE_START);
		numberPlayer1.setFont(standFont2);
		
		down.add(scorePlatePlayer2);
		scorePlatePlayer2.setFont(standFont);
		down.add(scorePlayer2);
		scorePlayer2.setFont(standFont);
		higherLowerGui.add(numberPlayer2, BorderLayout.LINE_END);
		numberPlayer2.setFont(standFont2);
		
		higherLowerGui.add(play, BorderLayout.CENTER);
		play.setFont(standFont2);
        play.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		int nP1;
        		int nP2;
        		nP1 = (int)(Math.random() * 32) + 1;
        		nP2 = (int)(Math.random() * 32) + 1;
        		String nP1S = Integer.toString(nP1);
        		String nP2S = Integer.toString(nP2);
        		
        		numberPlayer1.setText(nP1S);
        		numberPlayer2.setText(nP2S);
        		
        		int sP1;
        		int sP2;
        		
        		if(nP1 > nP2) {	
        			String sP1S = scorePlayer1.getText();
        			sP1 = Integer.parseInt(sP1S);
        			sP1 += 1;
        			sP1S = Integer.toString(sP1);
        			scorePlayer1.setText(sP1S);
        			if(sP1 >= 17) {
        				JOptionPane.showMessageDialog(null,
                                 "Player 1 won the Game.",
                                 "End of Game",					      
                                 JOptionPane.WARNING_MESSAGE);
        				higherLowerGui.dispose();
        			}
        		} else if(nP1 < nP2) {
        			String sP2S = scorePlayer2.getText();
        			sP2 = Integer.parseInt(sP2S);
        			sP2 += 1;
        			sP2S = Integer.toString(sP2);
        			scorePlayer2.setText(sP2S);
        			if(sP2 >= 17) {
        				JOptionPane.showMessageDialog(null,
                                 "Player 2 won the Game.",
                                 "End of Game",					      
                                 JOptionPane.WARNING_MESSAGE);
        				higherLowerGui.dispose();
        			}
        		} else if(nP1 == nP2) {
        			 JOptionPane.showMessageDialog(null,
                             "Tie, both Players got the same number.",
                             "Tie",					      
                             JOptionPane.WARNING_MESSAGE);
        		}
        		
            }
        });
		
	}

	public void initComponents() {
		
		up = new JPanel();
		down = new JPanel();
		scorePlatePlayer1 = new JLabel("Player 1 Score: ");
		int scoreInt1 = 0;
		String scoreInt1S = Integer.toString(scoreInt1);
		scorePlayer1 = new JLabel(scoreInt1S);
		numberPlayer1 = new JLabel("?");
		
		scorePlatePlayer2 = new JLabel("Player 2 Score: ");
		int scoreInt2 = 0;
		String scoreInt2S = Integer.toString(scoreInt2);
		scorePlayer2 = new JLabel(scoreInt2S);
		numberPlayer2 = new JLabel("?");
		
		play = new JButton("Play");
		
	}
	
}
