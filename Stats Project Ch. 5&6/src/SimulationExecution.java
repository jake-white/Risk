import java.io.PrintStream;

import javax.swing.JFrame;

public class SimulationExecution {
	
	public static JFrame frame;
	public static MainPanel panel;
	public static void main(String[] args) {
		panel = new MainPanel(frame);
		frame = new JFrame();
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(450, 500);
	}
}
