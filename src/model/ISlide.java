package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;
/**
*
* @author Marielle Fransen & Jasper Vek
* 
* 
*/
public interface ISlide {
		public void append(SlideItem iSlideItem);
		public String getTitle();
		public void setTitle(String newTitle);
		public void append(int level, String message);		
		public void appendBitmap(int level, String message);		
		public SlideItem getSlideItem(int number);
		public Vector<SlideItem> getSlideItems();
		public int getSize();
		public void draw(Graphics g, Rectangle area, ImageObserver view);
}