package factories;

import java.awt.Color;
import model.Style;

public class StyleFactory {

	public Style createStyle(int indent, Color color, int points, int leading)
	{
		return new Style(indent, color, points, leading);
	}
}