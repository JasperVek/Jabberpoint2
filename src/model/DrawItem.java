package model;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
/** 
*
* @author  Marielle Fransen & Jasper Vek
* 
* Strategy from strategy pattern
* of implementor van bridge pattern
* 
*/
public abstract class DrawItem {
// object nodig als parameter?
	public abstract void drawItem(Object ob, int x, int y, float scale, Graphics g, Style myStyle, ImageObserver o) ;
}
