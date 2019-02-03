package controller;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;
import factories.SlideItemFactory;
import model.AnnotateItem;

/**
 * 
 * @author Marielle Fransen & Jasper Vek
 * 
 */
public class MouseController extends MouseInputAdapter implements IInputController {

	private AnnotateItem annotateItem;
	private Frame frame;

	public MouseController(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			SlideItemFactory slideItemFactory = new SlideItemFactory();
			annotateItem = slideItemFactory.createAnnotateItem();
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

			// tekenen
//			annotateItem.draw(0, 0, 0,0, g, myStyle, o);
			Graphics g = frame.getGraphics();
			g.setColor(annotateItem.getColor());
	
			for (int i = 1; i < annotateItem.getVector().size(); i++) {
				Point previous = annotateItem.getVector().get(i - 1);
				Point current = annotateItem.getVector().get(i);
		
			}
		}
	}

	private void addMouseMovement(MouseEvent e) {
		annotateItem.nieuwPunt(getPunt(e));
	}

	private Point getPunt(MouseEvent e) {
		return new Point(e.getX(), e.getY());
	}
}
