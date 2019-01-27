package model;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

/**
 *
 * @author Marielle Fransen & Jasper Vek
 * 
 * 
 */
public interface IDrawItemStrategy {

	public abstract void drawItem(Object ob, int x, int y, float scale, Graphics g, Style myStyle, ImageObserver o);

	public int getY(Graphics g, float scale, Style myStyle);
}
