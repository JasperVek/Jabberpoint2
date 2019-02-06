package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Point;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

public class AnnotateItem extends SlideItem {
	private Color color = Color.red;
	private int thickness = 8;
	private Vector<Point> toDraw;
	private ArrayList<Line> savedLines;
	private IDrawItemStrategy howToDraw;

	public AnnotateItem(IDrawItemStrategy howToDraw) {
		resetVector();
		this.howToDraw = howToDraw;
		this.savedLines = new ArrayList<Line>();
	}

	public void resetVector() {
		this.toDraw = new Vector<>();
	}

	public void setLineThickness(int thickness) {
		if (this.thickness + thickness >= 1)
			this.thickness = this.thickness + thickness;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void nieuwPunt(Point p) {
		toDraw.add(p);
	}

	public Vector<Point> getVector() {
		return toDraw;
	}

	public int getTickness() {
		return this.thickness;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver o) {

		// TODO savedLines tekenen
		for (int i = 0; i < savedLines.size(); i++) {
			Line line = savedLines.get(i);
			Point previous = line.getPrevious();
			Point current = line.getCurrent();
			g.setColor(line.getColor());
			((Graphics2D) g).setStroke(new BasicStroke(line.getThickness()));
			g.drawLine(previous.x, previous.y, current.x, current.y);
		}
	}

	@Override
	public int getY(float scale, Graphics g, Style myStyle) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String toString() {
		return "{Annotation item}";
	}

	public void addLine(Point previous, Point current) {
		Line line = new Line(previous, current, color, thickness);
		savedLines.add(line);
	}
	
	public ArrayList<Line> getSaved()
	{
		return savedLines;
	}

}
