package model;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.font.TextLayout;
import java.awt.font.TextAttribute;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

/** <p>Een tekst item.</p>
 * <p>Een TextItem heeft tekenfunctionaliteit.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2019 M.Fransen & Jasper Vek
 */

public class TextItem extends SlideItem {
	private String text;
	
	private static final String EMPTYTEXT = "No Text Given";
    private IDrawItemStrategy howToDraw;


	
	public TextItem(int level, String string, IDrawItemStrategy howToDraw ) {
		super(level);
		text = string;
		this.howToDraw = howToDraw;
	}

// een leeg textitem
	public TextItem() {     
		this(0, EMPTYTEXT, new DrawTextStrategy());
	}

// Geef de tekst
	public String getText() {
		return text == null ? "" : text;
	}

// geef de AttributedString voor het item
	public AttributedString getAttributedString(Style style, float scale) {
		AttributedString attrStr = new AttributedString(getText());
		attrStr.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, text.length());
		return attrStr;
	}

	public int getY(float scale, Graphics g, 
			Style myStyle) {
		
		return (int)howToDraw.getY(g, scale, myStyle);
	}
	
	public void draw(int x, int y, float scale, Graphics g, 
			Style myStyle, ImageObserver o) {
		howToDraw.drawItem(this, x, y, scale, g, myStyle, o);
	}


	public String toString() {
		return "TextItem[" + getLevel()+","+getText()+"]";
	}

	

}
