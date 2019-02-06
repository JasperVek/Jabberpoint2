package model;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;

import java.io.IOException;


/** <p>De klasse voor een Bitmap item</p>
 * <p>Bitmap items hebben de verantwoordelijkheid om zichzelf te tekenen.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2019 M.Fransen & Jasper Vek
*/

public class BitmapItem extends SlideItem {
  private BufferedImage bufferedImage;
  private String imageName;
  private IDrawItemStrategy howToDraw;
  
  protected static final String FILE = "Bestand ";
  protected static final String NOTFOUND = " niet gevonden";

// level staat voor het item-level; name voor de naam van het bestand met de afbeelding
	public BitmapItem(int level, String name, IDrawItemStrategy howToDraw) {
		super(level);
		imageName = name;
		this.howToDraw = howToDraw;
		try {
			bufferedImage = ImageIO.read(new File(imageName));
		}
		catch (IOException e) {
			System.err.println(FILE + imageName + NOTFOUND) ;
		}
	}

// Een leeg bitmap-item
	public BitmapItem( IDrawItemStrategy howToDraw) {
		this(0, null, new DrawBitmapStrategy());
	}

// geef de bestandsnaam van de afbeelding
	public String getName() {
		return imageName;
	}


	public String toString() {
		return "BitmapItem[" + getLevel() + "," + imageName + "]";
	}
	
	public void draw(int x, int y, float scale, Graphics g, 
			Style myStyle, ImageObserver o) {
		howToDraw.drawItem(this, x, y, scale, g, myStyle, o);
	}
	
	@Override
	public int getY(float scale, Graphics g, Style myStyle) {
		return (int)howToDraw.getY(g, scale, myStyle);
	}
}
