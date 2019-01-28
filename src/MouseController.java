import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.event.MouseInputListener;

public class MouseController implements MouseInputListener, MouseMotionListener {

	
	private int x;
	private int y;
	
	private Presentation presentation;
	public MouseController(Presentation p)
	{
		this.presentation = p;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		presentation.drawAnnotation(e, x, y);
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.x = e.getX();
		this.y = e.getY();
		presentation.drawAnnotation(e, x, y);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.x = e.getX();
		this.y = e.getY();
		presentation.drawAnnotation(e, x, y);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.x = e.getX();
		this.y = e.getY();
	}	
}