package logic;

import java.awt.Rectangle;

import javax.swing.Timer;

import mapping.Tile;

public class Game {
	Tile[] tiles = new Tile[16];
	Rectangle[] r = new Rectangle[16];
	ObjectMap oM;
	public Game(int teamAmount, ObjectMap oM)
	{
		this.oM = oM;
		System.out.println(teamAmount + " teams created.");
		for(int t = 0; t < 16; ++t)
		{
			tiles[t] = new Tile(t);
		}
		Team[] teams = new Team[teamAmount + 1];
		for(int i = 0; i < teamAmount; ++i)
		{
			Tile[] subTiles = new Tile[4];
			System.arraycopy(tiles, i*4, subTiles, 0, 4);
			teams[i] = new Team(oM.colorList[i], subTiles);
			for(int c = 0; c < 4; c++)
			{
				subTiles[c].setTeam(teams[i]);
				System.out.println("set team " + i + " for tile" + ((i*4) + c));
			}
			teams[i] = new Team(oM.colorList[i], tiles);
			System.out.println(oM.colorList[i].toString());
		}
		oM.s.drawGame(this);
		for(int i = 0; i < tiles.length; ++i)
		{
		oM.m.changeTileColor(tiles[i], oM.colorList[(int) Math.floor((double) i/4)]);
		}
		oM.loading = false;
		oM.m.updatePNG();
		oM.t.start(); //starting the actual game!
		
	}
	public void setRectanglePositions(Rectangle[] r)
	{
		this. r = r;
	}
	public Rectangle[] getRectanglePositions()
	{
		for(int i = 0; i < r.length; ++i)
		{
			r[i] = new Rectangle(20*i, 20*i, 5,5);
		}
		return r;
	}
	public Tile[] getTiles()
	{
		return tiles;
	}
	
}
