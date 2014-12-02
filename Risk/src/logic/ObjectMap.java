package logic;

import java.awt.Color;

import javax.swing.Timer;

import mapping.Map;
import rendering.Frame;
import rendering.Screen;

public class ObjectMap {
	public Map m;
	public Game g;
	public Timer t;
	public GameTimer gT;
	public Frame f;
	public Screen s;
	public int players; //amount of players
	public int rectangles;
	public boolean loading = true;
	public final Color[] colorList = {Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN};
}
