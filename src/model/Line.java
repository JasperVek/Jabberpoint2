package model;

import java.awt.Color;
import java.awt.Point;

public class Line {

	private Point previousPoint;
	private Point currentPoint;
	private int thickness;
	private Color color;
	
	public Line(Point p1, Point p2, Color c, int t)
	{
		previousPoint = p1;
		currentPoint = p2;
		color = c;
		thickness = t;
	}
	
	public Point getPrevious()
	{
		return previousPoint;
	}
	
	public Point getCurrent()
	{
		return currentPoint;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public int getThickness()
	{
		return thickness;
	}
}
