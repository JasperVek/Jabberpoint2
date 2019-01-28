import java.awt.Point;

public class Line {

	private Point oldPoint;
	private Point newPoint;
	
	private int xOld;
	private int yOld;
	private int xNew;
	private int yNew;
	
	public Line(int xOld, int yOld, int xNew, int yNew)
	{
		setxOld(xOld);
		setyOld(yOld);
		setxNew(xNew);
		setyNew(yNew);
	}
	
	public Point getOldPoint()
	{
		return oldPoint;
	}
	
	public Point getNewPoint()
	{
		return newPoint;
	}

	public int getyNew() {
		return yNew;
	}

	public void setyNew(int yNew) {
		this.yNew = yNew;
	}

	public int getxNew() {
		return xNew;
	}

	public void setxNew(int xNew) {
		this.xNew = xNew;
	}

	public int getyOld() {
		return yOld;
	}

	public void setyOld(int yOld) {
		this.yOld = yOld;
	}

	public int getxOld() {
		return xOld;
	}

	public void setxOld(int xOld) {
		this.xOld = xOld;
	}
	
}
