package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
*
* @author Marielle Fransen & Jasper Vek
* 
* 
*/
public class DrawBitmapStrategy implements IDrawItemStrategy {
	private BufferedImage bufferedImage;

	protected static final String FILE = "Bestand ";
	protected static final String NOTFOUND = " niet gevonden";

	// teken de afbeelding
	public void drawItem(Object ob, int x, int y, float scale, Graphics g, Style myStyle, ImageObserver observer) {

		bufferedImage = getImage((BitmapItem) ob);
		int width = x + (int) (myStyle.indent * scale);
		int height = y + (int) (myStyle.leading * scale);
		g.drawImage(bufferedImage, width, height, (int) (bufferedImage.getWidth(observer) * scale),
				(int) (bufferedImage.getHeight(observer) * scale), observer);
	}

	private BufferedImage getImage(BitmapItem ob) {
		String imageName = ob.getName();
		try {
			bufferedImage = ImageIO.read(new File(imageName));
		} catch (IOException e) {
			System.err.println(FILE + imageName + NOTFOUND);
		}
		;
		return bufferedImage;
	}

	@Override
	public int getY(Graphics g, float scale, Style myStyle) {
		// niet nodig
		return 0;
	}
}