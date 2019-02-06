package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
*
* @author Marielle Fransen & Jasper Vek
* 
* 
*/
public  class DrawTextStrategy implements IDrawItemStrategy {
	private String text = "";
	
	public  void drawItem(Object ob, int x, int y, float scale, Graphics g, Style myStyle, ImageObserver o) {

		text = ((TextItem) ob).getText();
		if (text == null || text.length() == 0) {
			return;
		}
		List<TextLayout> layouts = getLayouts(g, myStyle, scale);
		Point pen = new Point(x + (int)(myStyle.indent * scale), 
				y + (int) (myStyle.leading * scale));
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(myStyle.color);
		Iterator<TextLayout> it = layouts.iterator();
		while (it.hasNext()) {
			TextLayout layout = it.next();
			pen.y += layout.getAscent();
			layout.draw(g2d, pen.x, pen.y);
			pen.y += layout.getDescent();
		}
	  }
	
	private List<TextLayout> getLayouts(Graphics g, Style s, float scale) {
		List<TextLayout> layouts = new ArrayList<TextLayout>();
		AttributedString attrStr = getAttributedString(s, scale);
    	Graphics2D g2d = (Graphics2D) g;
    	FontRenderContext frc = g2d.getFontRenderContext();
    	LineBreakMeasurer measurer = new LineBreakMeasurer(attrStr.getIterator(), frc);
    	float wrappingWidth = (Slide.WIDTH - s.indent) * scale;
    	while (measurer.getPosition() < text.length()) {
    		TextLayout layout = measurer.nextLayout(wrappingWidth);
    		layouts.add(layout);
    	}
    	return layouts;
	}
	
	// geef de AttributedString voor het item
	private AttributedString getAttributedString(Style style, float scale) {
			AttributedString attrStr = new AttributedString(text);
			attrStr.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, text.length());
			return attrStr;
		}
	
	  public int getY(Graphics g,float scale,Style myStyle) {
		  int y  = (int) (myStyle.leading * scale);
		  List<TextLayout> layouts = getLayouts(g, myStyle, scale);
		  Iterator<TextLayout> iterator = layouts.iterator();
			while (iterator.hasNext()) {
				TextLayout layout = iterator.next();
				Rectangle2D bounds = layout.getBounds();
				if (bounds.getHeight() > 0) {
					y += bounds.getHeight();
				}
				y += layout.getLeading() + layout.getDescent();
			}
		  
		  return y;
	  }
}
