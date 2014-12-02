package mapping;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import logic.ObjectMap;

public class Map {
	File map, loading;
	BufferedImage png, scaledpng, lpng, lscaledpng;
	Color[][] colors;
	ObjectMap oM;
	Dimension screenSize;
	private Rectangle[] r;
	private ArrayList<Point>[] lists;
	Color[] startColors;

	public Map(ObjectMap oM) // creating the map and reading in from map.png
	{
		this.oM = oM;
		r = new Rectangle[oM.rectangles];
		lists = new ArrayList[oM.rectangles];
		startColors = new Color[oM.rectangles];
		for (int i = 0; i < oM.rectangles; ++i) {
			startColors[i] = new Color(255, (i + 1) * 10, 0);
		}
		createPNG();
		parsePNG();
	}

	public void createPNG() {
		System.out.println("TRYING TO UPDATE, SHIT");
		screenSize = oM.f.getSize();
		System.out.println(oM.f.getSize().toString());
		map = new File("res/map.png");
		loading = new File("res/loading.png");
		try {
			lpng = ImageIO.read(loading);
			png = ImageIO.read(map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updatePNG();
		colors = new Color[png.getWidth()][png.getHeight()];
		for (int y = 0; y < png.getHeight(); ++y) {
			for (int x = 0; x < png.getWidth(); ++x) {
				colors[x][y] = new Color(png.getRGB(x, y));
			}
		}

	}

	public void updatePNG() {
		if (oM.loading)
			oM.s.setPNG(lpng);
		else
			oM.s.setPNG(png);
	}

	public void parsePNG() {

		// oM.g.setRectanglePositions(r);
		for (int i = 0; i < lists.length; ++i) {
			lists[i] = new ArrayList<Point>();
		}
		for (int y = 0; y < png.getHeight(); ++y) {
			for (int x = 0; x < png.getWidth(); ++x) {
				for (int c = 0; c < startColors.length; ++c) {
					if (colors[x][y].equals(startColors[c])) {
						Point point = new Point(x, y);
						lists[c].add(point);
					}
				}
			}
		}
		System.out.println("DONE PARSING MAP!");
		for (int a = 0; a < lists.length; ++a)
			System.out.println("List" + a + " is " + lists[a].size());
	}

	public void changeTileColor(Tile t, Color c) {
		for (int i = 0; i < lists[t.getID()].size(); ++i) {
			png.setRGB(lists[t.getID()].get(i).x, lists[t.getID()].get(i).y,
					c.getRGB());
		}
		updatePNG();
	}
}
