package mapping;

import java.awt.Color;
import java.awt.Point;

import logic.Team;

public class Tile {
	private Team team;  //team that this tile belongs to
	private int number; //ID number of this specific tile
	private Tile[] neighbors;
	private Point[] p;
	public Tile(int number)
	{
		this.number = number;
	}
	public Color getColor()
	{
		return team.getColor();
	}
	public void setTeam(Team team)
	{
		this.team = team;
	}
	public void setPixels(Point[] p)
	{
		this.p = p;
	}
	public Team getTeam()
	{
		return team;
	}
	public int getID()
	{
		return number;
	}
}
