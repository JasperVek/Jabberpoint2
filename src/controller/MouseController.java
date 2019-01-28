package controller;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;
import factories.SlideItemFactory;
import model.AnnotateItem;

/**
 * 
 * @author   Marielle Fransen & Jasper Vek
 * 
*/
public class MouseController  extends MouseInputAdapter implements IInputController  {
	
	private AnnotateItem annotateItem ;
	
	@Override
	public void mousePressed(MouseEvent e) {
			if ( SwingUtilities.isLeftMouseButton(e)) {
			SlideItemFactory slideItemFactory = new SlideItemFactory();
			annotateItem = slideItemFactory.createAnnotateItem();
			annotateItem.setColor(Color.RED);
			annotateItem.setLineThickness(30);  //>????? frn
			this.addMouseMovement(e);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
			if (SwingUtilities.isLeftMouseButton(e)) {
			this.addMouseMovement(e);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
			if (SwingUtilities.isLeftMouseButton(e)) {
			this.addMouseMovement(e);
		}
	}

	private void addMouseMovement(MouseEvent e) {
		annotateItem.nieuwPunt(getPunt(e));
	}
	
	private Point getPunt(MouseEvent e) {
		return new Point(e.getX(), e.getY());
	}
}
