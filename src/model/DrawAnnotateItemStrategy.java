package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.ImageObserver;
import java.util.Vector;

import model.AnnotateItem;

/**
 *
 * @author Marielle Fransen & Jasper Vek
 * 
 * 
 */
public class DrawAnnotateItemStrategy implements IDrawItemStrategy {
	private Vector<Point> toDraw;

	@Override
	public void drawItem(Object ob, int x, int y, float scale, Graphics g, Style myStyle, ImageObserver o) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(getTickness((AnnotateItem) ob)));
		g2d.setColor(getColor((AnnotateItem) ob));
		
		this.toDraw = getVector((AnnotateItem) ob);

		for (int i = 1; i < toDraw.size(); i++) {
			Point previous = toDraw.get(i - 1);
			Point current = toDraw.get(i);
			g2d.drawLine(previous.x, previous.y, current.x, current.y);
		}
	}

	@Override
	public int getY(Graphics g, float scale, Style myStyle) {
		// niet nodig
		return 0;
	}

	private Vector<Point> getVector(AnnotateItem ob) {
		return ob.getVector();
	}
	
	private int getTickness(AnnotateItem ob) {
		return ob.getTickness();
	}
	
	private Color getColor(AnnotateItem ob) {
		return ob.getColor();
	}

}
