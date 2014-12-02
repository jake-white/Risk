package rendering;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import logic.Game;
import logic.ObjectMap;
import mapping.Tile;

public class Screen extends JPanel implements ComponentListener, MouseListener, MouseMotionListener{
	Tile[] tiles;
	Rectangle[] desks;
	BufferedImage png;
	ObjectMap oM;
	
	@Override
	public void componentResized(ComponentEvent e) {
		System.out.println("RESIZED YO");
		oM.m.updatePNG();
	}
	public Screen(ObjectMap oM) {
		this.oM = oM;
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	public void drawGame(Game game)
	{
		oM.g = game;
		tiles = oM.g.getTiles();
		System.out.println("Tiles updated....");		
		desks = game.getRectanglePositions();
		repaint();
	}
	public void setPNG(BufferedImage png)
	{
		this.png = png;
		repaint();
	}
	

	public void paintComponent(Graphics g) {
		System.out.println("Beginning to draw!");
		Graphics2D g2d = (Graphics2D) g;
		g.drawImage(png, 0, 0, oM.f.getSize().width, oM.f.getSize().height, null);
	}
	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("CLICK");
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		System.out.println("ENTERED THE PANEL");
		Point mousePosition = this.getMousePosition();
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}