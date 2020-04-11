
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class busListener extends JFrame implements ActionListener {

	JPanel up;
	JPanel down;
	JButton higher;
	JButton lower;
	JLabel number;
	JLabel position;
	JLabel positionNumber;
	JLabel card1;
	JLabel card2;
	JLabel card3;
	JLabel card4;
	JLabel card5;
	JLabel card6;
	JLabel card7;
	
	Font standFont = new Font ("TimesRoman", Font.BOLD, 30);
	Font standFont2 = new Font ("TimesRoman", Font.BOLD, 120);
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JFrame busGui = new JFrame();
		
		busGui.setVisible(true);
		busGui.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		busGui.setSize(900, 700);
		busGui.setMinimumSize(getSize());
		busGui.setLocationRelativeTo(null);		
		busGui.setTitle("Number Games, Bus Driver");
		busGui.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("IconTop.png")));
		busGui.setLayout(new GridLayout(2, 1));
		
		initComponents();
		
		busGui.add(up);
		up.setLayout(new GridLayout(1, 7));
		up.add(card1);
		up.add(card2);
		up.add(card3);
		up.add(card4);
		up.add(card5);
		up.add(card6);
		up.add(card7);
		card1.setFont(standFont2);
		card2.setFont(standFont2);
		card3.setFont(standFont2);
		card4.setFont(standFont2);
		card5.setFont(standFont2);
		card6.setFont(standFont2);
		card7.setFont(standFont2);
		busGui.add(down);
		down.setLayout(new GridLayout(1,5));
		down.add(number);
		number.setFont(standFont2);
		down.add(position);
		position.setFont(standFont);
		down.add(positionNumber);
		positionNumber.setFont(standFont2);
		down.add(higher);
		higher.setFont(standFont);;
		down.add(lower);
		lower.setFont(standFont);
		
		card1.setForeground(Color.RED);
		card2.setForeground(Color.GREEN);
		card3.setForeground(Color.GREEN);
		card4.setForeground(Color.GREEN);
		card5.setForeground(Color.GREEN);
		card6.setForeground(Color.GREEN);
		card7.setForeground(Color.GREEN);
		
		card1.setHorizontalAlignment(JLabel.CENTER);
		card2.setHorizontalAlignment(JLabel.CENTER);
		card3.setHorizontalAlignment(JLabel.CENTER);
		card4.setHorizontalAlignment(JLabel.CENTER);
		card5.setHorizontalAlignment(JLabel.CENTER);
		card6.setHorizontalAlignment(JLabel.CENTER);
		card7.setHorizontalAlignment(JLabel.CENTER);
		number.setHorizontalAlignment(JLabel.CENTER);
		position.setHorizontalAlignment(JLabel.CENTER);
		positionNumber.setHorizontalAlignment(JLabel.CENTER);
		
		int card1I = (int)(Math.random() * 8) + 1;
		String card1S = Integer.toString(card1I);
		card1.setText(card1S);
		
		int card2I = (int)(Math.random() * 8) + 1;
		String card2S = Integer.toString(card2I);
		card2.setText(card2S);
		
		int card3I = (int)(Math.random() * 8) + 1;
		String card3S = Integer.toString(card3I);
		card3.setText(card3S);
		
		int card4I = (int)(Math.random() * 8) + 1;
		String card4S = Integer.toString(card4I);
		card4.setText(card4S);
		
		int card5I = (int)(Math.random() * 8) + 1;
		String card5S = Integer.toString(card5I);
		card5.setText(card5S);
		
		int card6I = (int)(Math.random() * 8) + 1;
		String card6S = Integer.toString(card6I);
		card6.setText(card6S);
		
		int card7I = (int)(Math.random() * 8) + 1;
		String card7S = Integer.toString(card7I);
		card7.setText(card7S);
		
		higher.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		int randomNumber = (int)(Math.random() * 8) + 1;
        		String randomNumberS = Integer.toString(randomNumber);
        		
        		number.setText(randomNumberS);
        	
        		String pos = positionNumber.getText();
        		int posI = Integer.parseInt(pos);
        		
        		switch(posI) {
        		case 1: 
        			String cS1 = card1.getText();
            		int cI1 = Integer.parseInt(cS1);
            		if(cI1 <= randomNumber) {
            			positionNumber.setText("2");
            			card1.setForeground(Color.GREEN);
            			card2.setForeground(Color.RED);
            			card1.setText(randomNumberS);
            		} else if(cI1 > randomNumber) {
            			positionNumber.setText("1");
            			card1.setText(randomNumberS);
            		}
            		break;
        		case 2: 
        			String cS2 = card2.getText();
            		int cI2 = Integer.parseInt(cS2);
            		if(cI2 <= randomNumber) {
            			positionNumber.setText("3");
            			card2.setForeground(Color.GREEN);
            			card3.setForeground(Color.RED);
            			card2.setText(randomNumberS);
            		} else if(cI2 > randomNumber) {
            			positionNumber.setText("1");
            			card2.setForeground(Color.GREEN);
            			card1.setForeground(Color.RED);
            			card2.setText(randomNumberS);
            		}
            		break;
        		case 3: 
        			String cS3 = card3.getText();
            		int cI3 = Integer.parseInt(cS3);
            		if(cI3 <= randomNumber) {
            			positionNumber.setText("4");
            			card3.setForeground(Color.GREEN);
            			card4.setForeground(Color.RED);
            			card3.setText(randomNumberS);
            		} else if(cI3 > randomNumber) {
            			positionNumber.setText("1");
            			card3.setForeground(Color.GREEN);
            			card1.setForeground(Color.RED);
            			card3.setText(randomNumberS);
            		}
            		break;
        		case 4: 
        			String cS4 = card4.getText();
            		int cI4 = Integer.parseInt(cS4);
            		if(cI4 <= randomNumber) {
            			positionNumber.setText("5");
            			card4.setForeground(Color.GREEN);
            			card5.setForeground(Color.RED);
            			card4.setText(randomNumberS);
            		} else if(cI4 > randomNumber) {
            			positionNumber.setText("1");
            			card4.setForeground(Color.GREEN);
            			card1.setForeground(Color.RED);
            			card4.setText(randomNumberS);
            		}
            		break;
        		case 5: 
        			String cS5 = card5.getText();
            		int cI5 = Integer.parseInt(cS5);
            		if(cI5 <= randomNumber) {
            			positionNumber.setText("6");
            			card5.setForeground(Color.GREEN);
            			card6.setForeground(Color.RED);
            			card5.setText(randomNumberS);
            		} else if(cI5 > randomNumber) {
            			positionNumber.setText("1");
            			card5.setForeground(Color.GREEN);
            			card1.setForeground(Color.RED);
            			card5.setText(randomNumberS);
            		}	
            		break;
        		case 6: 
        			String cS6 = card6.getText();
            		int cI6 = Integer.parseInt(cS6);
            		if(cI6 <= randomNumber) {
            			positionNumber.setText("7");
            			card6.setForeground(Color.GREEN);
            			card7.setForeground(Color.RED);
            			card6.setText(randomNumberS);
            		} else if(cI6 > randomNumber) {
            			positionNumber.setText("1");
            			card6.setForeground(Color.GREEN);
            			card1.setForeground(Color.RED);
            			card6.setText(randomNumberS);
            		}
            		break;
        		case 7: 
        			String cS7 = card7.getText();
            		int cI7 = Integer.parseInt(cS7);
            		if(cI7 <= randomNumber) {
            			positionNumber.setText("8");
            			card1.setForeground(Color.RED);
            			card2.setForeground(Color.RED);
            			card3.setForeground(Color.RED);
            			card4.setForeground(Color.RED);
            			card5.setForeground(Color.RED);
            			card6.setForeground(Color.RED);
            			card7.setForeground(Color.RED);
            			card7.setText(randomNumberS);
            	        JOptionPane.showMessageDialog(null,
               	        	"You won the Game.",
          	               	"End of Game",					      
           	             	JOptionPane.WARNING_MESSAGE);
               	        busGui.dispose();
            		} else if(cI7 > randomNumber) {
            			positionNumber.setText("1");
            			card7.setForeground(Color.GREEN);
            			card1.setForeground(Color.RED);
            			card7.setText(randomNumberS);
            		}
            		break;
        		}
        	}
		});
		
		lower.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		int randomNumber = (int)(Math.random() * 8) + 1;
        		String randomNumberS = Integer.toString(randomNumber);
        		
        		number.setText(randomNumberS);
        	
        		String pos = positionNumber.getText();
        		int posI = Integer.parseInt(pos);
        		
        		switch(posI) {
        		case 1: 
        			String cS1 = card1.getText();
            		int cI1 = Integer.parseInt(cS1);
            		if(cI1 >= randomNumber) {
            			positionNumber.setText("2");
            			card1.setForeground(Color.GREEN);
            			card2.setForeground(Color.RED);
            			card1.setText(randomNumberS);
            		} else if(cI1 < randomNumber) {
            			positionNumber.setText("1");
            			card1.setText(randomNumberS);
            		}
            		break;
        		case 2: 
        			String cS2 = card2.getText();
            		int cI2 = Integer.parseInt(cS2);
            		if(cI2 >= randomNumber) {
            			positionNumber.setText("3");
            			card2.setForeground(Color.GREEN);
            			card3.setForeground(Color.RED);
            			card2.setText(randomNumberS);
            		} else if(cI2 < randomNumber) {
            			positionNumber.setText("1");
            			card2.setForeground(Color.GREEN);
            			card1.setForeground(Color.RED);
            			card2.setText(randomNumberS);
            		}
            		break;
        		case 3: 
        			String cS3 = card3.getText();
            		int cI3 = Integer.parseInt(cS3);
            		if(cI3 >= randomNumber) {
            			positionNumber.setText("4");
            			card3.setForeground(Color.GREEN);
            			card4.setForeground(Color.RED);
            			card3.setText(randomNumberS);
            		} else if(cI3 < randomNumber) {
            			positionNumber.setText("1");
            			card3.setForeground(Color.GREEN);
            			card1.setForeground(Color.RED);
            			card3.setText(randomNumberS);
            		}
            		break;
        		case 4: 
        			String cS4 = card4.getText();
            		int cI4 = Integer.parseInt(cS4);
            		if(cI4 >= randomNumber) {
            			positionNumber.setText("5");
            			card4.setForeground(Color.GREEN);
            			card5.setForeground(Color.RED);
            			card4.setText(randomNumberS);
            		} else if(cI4 < randomNumber) {
            			positionNumber.setText("1");
            			card4.setForeground(Color.GREEN);
            			card1.setForeground(Color.RED);
            			card4.setText(randomNumberS);
            		}
            		break;
        		case 5: 
        			String cS5 = card5.getText();
            		int cI5 = Integer.parseInt(cS5);
            		if(cI5 >= randomNumber) {
            			positionNumber.setText("6");
            			card5.setForeground(Color.GREEN);
            			card6.setForeground(Color.RED);
            			card5.setText(randomNumberS);
            		} else if(cI5 < randomNumber) {
            			positionNumber.setText("1");
            			card5.setForeground(Color.GREEN);
            			card1.setForeground(Color.RED);
            			card5.setText(randomNumberS);
            		}	
            		break;
        		case 6: 
        			String cS6 = card6.getText();
            		int cI6 = Integer.parseInt(cS6);
            		if(cI6 >= randomNumber) {
            			positionNumber.setText("7");
            			card6.setForeground(Color.GREEN);
            			card7.setForeground(Color.RED);
            			card6.setText(randomNumberS);
            		} else if(cI6 < randomNumber) {
            			positionNumber.setText("1");
            			card6.setForeground(Color.GREEN);
            			card1.setForeground(Color.RED);
            			card6.setText(randomNumberS);
            		}
            		break;
        		case 7: 
        			String cS7 = card7.getText();
            		int cI7 = Integer.parseInt(cS7);
            		if(cI7 >= randomNumber) {
            			positionNumber.setText("8");
            			card1.setForeground(Color.RED);
            			card2.setForeground(Color.RED);
            			card3.setForeground(Color.RED);
            			card4.setForeground(Color.RED);
            			card5.setForeground(Color.RED);
            			card6.setForeground(Color.RED);
            			card7.setForeground(Color.RED);
            			card7.setText(randomNumberS);
            	        JOptionPane.showMessageDialog(null,
               	        	"You won the Game.",
                        	"End of Game",					      
                        	JOptionPane.WARNING_MESSAGE);
            	        busGui.dispose();
            		} else if(cI7 < randomNumber) {
            			positionNumber.setText("1");
            			card7.setForeground(Color.GREEN);
            			card1.setForeground(Color.RED);
            			card7.setText(randomNumberS);
            		}
            		break;
        		}
        	}
		});
		
	}
	
	public void initComponents() {
		
		up = new JPanel();
		down = new JPanel();
		higher = new JButton("Higher");
		lower = new JButton("Lower");
		number = new JLabel("?");
		position = new JLabel("Position: ");
		positionNumber = new JLabel("1");
		card1 = new JLabel();
		card2 = new JLabel();
		card3 = new JLabel();
		card4 = new JLabel();
		card5 = new JLabel();
		card6 = new JLabel();
		card7 = new JLabel();
		
	}

}
