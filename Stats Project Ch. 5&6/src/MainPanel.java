import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainPanel extends JPanel implements ActionListener{
	private JLabel p1amount, p2amount, die1, die2, trialCounter, probability1, probability2, sps;
	private JLabel winner;
	private JTextField player1, player2, trials;
	private GridLayout format;
	private JFrame frameOn;
	private JButton go;
	private int sides = 6, p1wins, p2wins, trialAmount = 1;
	private double prob1, prob2;
	public MainPanel(JFrame frame)
	{
		frameOn = frame;
		format = new GridLayout(6, 2);
		this.setLayout(format);
		winner = new JLabel("");
		die1 = new JLabel("Player 1's Highest:");
		die2 = new JLabel("Player 2's Highest:");
		p1amount = new JLabel("Patrick's # of dice");
		p2amount = new JLabel("Barney's # of dice");
		trialCounter = new JLabel("# of trials");
		probability1 = new JLabel("P(Player 1) = ");
		probability2 = new JLabel("P(Player 2) = ");
		sps = new JLabel(" trials per second");
		player1 = new JTextField("1");
		player2 = new JTextField("1");
		trials = new JTextField("1");
		player1.addActionListener(this);
		player2.addActionListener(this);
		trials.addActionListener(this);
		go = new JButton("Go!");
		go.addActionListener(this);
		
		this.add(p1amount);
		this.add(p2amount);
		this.add(player1);
		this.add(player2);
		this.add(trials);
		this.add(trialCounter);
		this.add(go);
		this.add(winner);
		this.add(probability1);
		this.add(probability2);
		this.add(sps);
		for(int i = 0; i < this.getComponentCount(); ++i)
		{
			this.getComponents()[i].setFont(this.getComponents()[i].getFont().deriveFont(20.0F));
		}
	}
	@Override
	public void actionPerformed(ActionEvent item) {
		if(item.getSource() == go)
		{
			Random rand = new Random();
			int p1 = 0, p2 = 0, p1wins = 0, p2wins = 0;

			trialAmount = Integer.parseInt(trials.getText());
			long start = System.currentTimeMillis();
			for(int c = 0; c< trialAmount; ++c)
			{
				p1 = 0; p2 = 0;
			for(int i = 0; i < Integer.parseInt(player1.getText()); ++i)
			{
			//	System.out.println("rolling p1");
				int randomDie = rand.nextInt(sides) + 1;
				if(randomDie > p1)
					p1 = randomDie;
			}
			for(int i = 0; i < Integer.parseInt(player2.getText()); ++i)
			{
				//System.out.println("rolling p2");
				int randomDie = rand.nextInt(sides) + 1;
				if(randomDie > p2)
					p2 = randomDie;
			}
			
			if(p1 > p2)
				++p1wins;
			else if(p2 > p1)
				++p2wins;
			else
				++p2wins;
			}
			long end = System.currentTimeMillis();
			prob1 = (double)p1wins/trialAmount;
			prob2 = (double)p2wins/trialAmount;
			System.out.println(p1wins + " " + p2wins + " " + trialAmount);
			probability1.setText("P(Player 1) = " + prob1);
			probability2.setText("P(Player 2) = " + prob2);
			if(prob1 > prob2)
			{
				winner.setText("Patrick usually wins.");
			}
			else if(prob2 > prob1)
			{
				winner.setText("Barney usually wins.");
			}
			else
				winner.setText("They have equal probability");
				
			long totalTime = end - start;
			double calcsPerMilli = (double)trialAmount/totalTime;
			System.out.println(totalTime);
			double calcsPerSec = Math.round(calcsPerMilli * 1000);
			sps.setText(calcsPerSec + " trials/sec.");
			
		}
		
	}
	
}
