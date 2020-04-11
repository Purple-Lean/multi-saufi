
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class horseListener extends JFrame implements ActionListener {

	JPanel left;
	JPanel right;
	JButton play;
	JLabel number;
	JLabel l1;
	JLabel l2;
	JLabel l3;
	JLabel l4;
	
	JLabel r1;
	JLabel r2;
	JLabel r3;
	JLabel r4;
	
	JLabel ll1;
	JLabel ll2;
	JLabel ll3;
	JLabel ll4;
	
	JLabel rr1;
	JLabel rr2;
	JLabel rr3;
	JLabel rr4;
	
	JLabel lr1;
	JLabel lr2;
	JLabel lr3;
	JLabel lr4;
	
	Font standFont = new Font ("TimesRoman", Font.BOLD, 60);
	Font standFont2 = new Font ("TimesRoman", Font.BOLD, 120);
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		JFrame horseGui = new JFrame();
		
		horseGui.setVisible(true);
		horseGui.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		horseGui.setSize(900, 700);
		horseGui.setMinimumSize(getSize());
		horseGui.setLocationRelativeTo(null);		
		horseGui.setTitle("Number Games, Horse Race");
		horseGui.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("IconTop.png")));
		horseGui.setLayout(new GridLayout(1, 2));
		
		initComponents();
		
		horseGui.add(left);
		left.setLayout(new GridLayout(5, 4));
		left.add(l1);
		l1.setFont(standFont);
		left.add(l2);
		l2.setFont(standFont);
		left.add(l3);
		l3.setFont(standFont);
		left.add(l4);
		l4.setFont(standFont);
		left.add(r1);
		r1.setFont(standFont);
		left.add(r2);
		r2.setFont(standFont);
		left.add(r3);
		r3.setFont(standFont);
		left.add(r4);
		r4.setFont(standFont);
		left.add(ll1);
		ll1.setFont(standFont);
		left.add(ll2);
		ll2.setFont(standFont);
		left.add(ll3);
		ll3.setFont(standFont);
		left.add(ll4);
		ll4.setFont(standFont);
		left.add(rr1);
		rr1.setFont(standFont);
		left.add(rr2);
		rr2.setFont(standFont);
		left.add(rr3);
		rr3.setFont(standFont);
		left.add(rr4);
		rr4.setFont(standFont);
		left.add(lr1);
		lr1.setFont(standFont);
		left.add(lr2);
		lr2.setFont(standFont);
		left.add(lr3);
		lr3.setFont(standFont);
		left.add(lr4);
		lr4.setFont(standFont);
		l1.setHorizontalAlignment(JLabel.CENTER);
		l2.setHorizontalAlignment(JLabel.CENTER);
		l3.setHorizontalAlignment(JLabel.CENTER);
		l4.setHorizontalAlignment(JLabel.CENTER);
		r1.setHorizontalAlignment(JLabel.CENTER);
		r2.setHorizontalAlignment(JLabel.CENTER);
		r3.setHorizontalAlignment(JLabel.CENTER);
		r4.setHorizontalAlignment(JLabel.CENTER);
		ll1.setHorizontalAlignment(JLabel.CENTER);
		ll2.setHorizontalAlignment(JLabel.CENTER);
		ll3.setHorizontalAlignment(JLabel.CENTER);
		ll4.setHorizontalAlignment(JLabel.CENTER);
		rr1.setHorizontalAlignment(JLabel.CENTER);
		rr2.setHorizontalAlignment(JLabel.CENTER);
		rr3.setHorizontalAlignment(JLabel.CENTER);
		rr4.setHorizontalAlignment(JLabel.CENTER);
		lr1.setHorizontalAlignment(JLabel.CENTER);
		lr2.setHorizontalAlignment(JLabel.CENTER);
		lr3.setHorizontalAlignment(JLabel.CENTER);
		lr4.setHorizontalAlignment(JLabel.CENTER);
		
		horseGui.add(right);
		right.setLayout(new GridLayout(2, 1));
		right.add(number);
		number.setFont(standFont2);
		number.setHorizontalAlignment(JLabel.CENTER);
		right.add(play);
		play.setFont(standFont2);
		play.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		int randomNumber = (int)(Math.random() * 4) + 1;
        		String randomNumberS = Integer.toString(randomNumber); 
        		
        		number.setText(randomNumberS);
        		
        		if(randomNumber == 1) {
        			String pos1S = lr1.getText();
        			int pos1 = Integer.parseInt(pos1S);
        			switch(pos1) {
        			case 1:
         	       		lr1.setText("2");
         	           	rr1.setText("2");        	         
         	           	break;
        			case 2:
        				lr1.setText("3");
         	       		rr1.setText("");
         	           	ll1.setText("3");
         	           	break;
         	       	case 3:
         	       		lr1.setText("4");
         	       		ll1.setText("");
         	       		r1.setText("4");
         	       		break;
         	       	case 4:
         	       		lr1.setText("5");
         	       		r1.setText("");
         	       		l1.setText("5");   
	        	        JOptionPane.showMessageDialog(null,
	        	           	"Player who bet on first number won.",
	                     	"End of Game",					      
	                      	JOptionPane.WARNING_MESSAGE);
	                    horseGui.dispose();
            		}
        		} else if(randomNumber == 2) {
        			String pos1S = lr2.getText();
        			int pos1 = Integer.parseInt(pos1S);
        			switch(pos1) {
        			case 1:
         	       		lr2.setText("2");
         	           	rr2.setText("2");        	         
         	           	break;
        			case 2:
        				lr2.setText("3");
         	       		rr2.setText("");
         	           	ll2.setText("3");
         	           	break;
         	       	case 3:
         	       		lr2.setText("4");
         	       		ll2.setText("");
         	       		r2.setText("4");
         	       		break;
         	       	case 4:
         	       		lr2.setText("5");
         	       		r2.setText("");
         	       		l2.setText("5");   
	        	        JOptionPane.showMessageDialog(null,
	        	           	"Player who bet on second number won.",
	                     	"End of Game",					      
	                      	JOptionPane.WARNING_MESSAGE);
	                    horseGui.dispose();
            		} 
        		} else if(randomNumber == 3) {
        			String pos1S = lr3.getText();
        			int pos1 = Integer.parseInt(pos1S);
        			switch(pos1) {
        			case 1:
         	       		lr3.setText("2");
         	           	rr3.setText("2");        	         
         	           	break;
        			case 2:
        				lr3.setText("3");
         	       		rr3.setText("");
         	           	ll3.setText("3");
         	           	break;
         	       	case 3:
         	       		lr3.setText("4");
         	       		ll3.setText("");
         	       		r3.setText("4");
         	       		break;
         	       	case 4:
         	       		lr3.setText("5");
         	       		r3.setText("");
         	       		l3.setText("5");   
	        	        JOptionPane.showMessageDialog(null,
	        	           	"Player who bet on third number won.",
	                     	"End of Game",					      
	                      	JOptionPane.WARNING_MESSAGE);
	                    horseGui.dispose();
            		}
        		} else if(randomNumber == 4) {
        			String pos1S = lr4.getText();
        			int pos1 = Integer.parseInt(pos1S);
        			switch(pos1) {
        			case 1:
         	       		lr4.setText("2");
         	           	rr4.setText("2");        	         
         	           	break;
        			case 2:
        				lr4.setText("3");
         	       		rr4.setText("");
         	           	ll4.setText("3");
         	           	break;
         	       	case 3:
         	       		lr4.setText("4");
         	       		ll4.setText("");
         	       		r4.setText("4");
         	       		break;
         	       	case 4:
         	       		lr4.setText("5");
         	       		r4.setText("");
         	       		l4.setText("5");   
	        	        JOptionPane.showMessageDialog(null,
	        	           	"Player who bet on fourth number won.",
	                     	"End of Game",					      
	                      	JOptionPane.WARNING_MESSAGE);
	                    horseGui.dispose();
            		}
        		}		
        	}
		});				
	}

	public void initComponents() {
		
		left = new JPanel();
		right = new JPanel();
		play = new JButton("Play");
		number = new JLabel("?");
		l1 = new JLabel();
		l2 = new JLabel();
		l3 = new JLabel();
		l4 = new JLabel();
		r1 = new JLabel();
		r2 = new JLabel();
		r3 = new JLabel();
		r4 = new JLabel();
		ll1 = new JLabel();
		ll2 = new JLabel();
		ll3 = new JLabel();
		ll4 = new JLabel();
		rr1 = new JLabel();
		rr2 = new JLabel();
		rr3 = new JLabel();
		rr4 = new JLabel();
		lr1 = new JLabel("1");
		lr2 = new JLabel("1");
		lr3 = new JLabel("1");
		lr4 = new JLabel("1");
		
	}
	
}
