package factories;

import java.awt.Color;
import model.Style;
/*
 * 
*  Marielle Fransen & Jasper Vek
*  
*/
public class StyleFactory {


	
	public Style createStyle(int level) {
		switch(level) {
		case 1: return new Style(20, Color.blue,  40, 10);
		case 2: return new Style(50, Color.black, 36, 10);
		case 3: return new Style(70, Color.black, 30, 10);
		case 4: return new Style(90, Color.black, 24, 10);
		default : return new Style( 0, Color.red, 24, 10);
		}
	}
}

