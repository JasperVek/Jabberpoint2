package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.ImageObserver;
import java.util.Vector;

public class AnnotateItem extends SlideItem {
	private Color color = Color.red;
	private int thickness = 8;
	private Vector<Point> toDraw;
	private IDrawItemStrategy howToDraw;

	public AnnotateItem(IDrawItemStrategy howToDraw) {
		resetVector();
		this.howToDraw = howToDraw;
	}

	public void resetVector() {
		this.toDraw = new Vector<>();
	}

	public void setLineThickness(int thickness) {
		if (this.thickness-thickness >= 1)
			this.thickness = this.thickness-thickness;
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

	}

	@Override
	public int getY(float scale, Graphics g, Style myStyle) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String toString() {
		return "{Annotation item}";
	}
}
