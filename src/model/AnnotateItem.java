package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.ImageObserver;
import java.util.Vector;

public class AnnotateItem extends SlideItem {
	private Color color;
	private int thickness;
	private Vector<Point> toDraw;
	private IDrawItemStrategy howToDraw;
	
	public AnnotateItem(IDrawItemStrategy howToDraw) {
		this.toDraw = new Vector<>();
		this.howToDraw = howToDraw;
	}
	
    public void setLineThickness(int thickness)
    {
        this.thickness = thickness;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }
    
    public void nieuwPunt(Point p){
    	toDraw.add(p);
    }

    public Vector<Point> getVector() {
    	return toDraw;
    }
    
    public int getTickness() {
    	return this.thickness;
    }
    
    public Color getColor() {
    	return this.color;
    }
    
	@Override
	public void draw(int x, int y, float scale, Graphics g, 
			Style myStyle, ImageObserver o) {
		howToDraw.drawItem(this, x, y, scale, g, myStyle, o);
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
