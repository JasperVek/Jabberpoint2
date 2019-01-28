import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.font.TextLayout;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AnnotateItem {


	private List<Line> lines = null;
	
	public AnnotateItem()
	{
		lines = new ArrayList<Line>();
	}

	public void draw(float scale, Graphics g, Style style, ImageObserver view, Point p, int x, int y) {
		
		Graphics2D g2d = (Graphics2D)g;
		Stroke stroke = new BasicStroke( 10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 10.0f);
		g2d.setStroke(stroke);
		
		  if(lines.isEmpty() == false)
		 {
		
			for(int i = 0; i < lines.size(); i++)
		 	{
			  Line line = lines.get(i);
			  int n = 0;
			  g2d.drawLine(line.getxOld() - 12, line.getyOld() - 55, line.getxNew()+n - 12, line.getyNew()+n - 55);
		 	}
		 }
		 
		int n = 0;
		g2d.drawLine(x - 12, y - 55, x +n - 12, y +n - 55);
		Line line = new Line(x, y, x+n, y+n);
		lines.add(line);
		 
	}
}