package logic;

import java.awt.Color;

import mapping.Tile;

public class Team {
	Tile[] tiles;
	Color color;
	public Team(Color color, Tile[] tiles)
	{
		this.color = color;
	}
	public Tile[] getTiles()
	{
		return tiles;
	}
	public Color getColor()
	{
		return color;
	}
}
