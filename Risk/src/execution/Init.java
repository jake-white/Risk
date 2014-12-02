package execution;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import logic.Game;
import logic.GameTimer;
import logic.ObjectMap;
import mapping.Map;
import rendering.Frame;
import rendering.Screen;

public class Init{
	private static ObjectMap oM;
	private static int players = 4;
	private static int r = 16;
	public static void main(String[] args) {
		ObjectMap oM = new ObjectMap();
		oM.players = players;
		oM.rectangles = r;
		oM.t = new Timer(10, oM.gT);
		oM.f = new Frame(oM);
		oM.s = new Screen(oM);
		oM.f.add(oM.s);
	//	oM.f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		oM.f.setSize(500, 400);
		oM.f.setVisible(true);
		oM.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		oM.m = new Map(oM);
		oM.s.addComponentListener(oM.s);
		oM.g = new Game(players, oM);
	}
	
}
