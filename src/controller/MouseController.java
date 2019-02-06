package controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;
import factories.SlideItemFactory;
import model.AnnotateItem;
import model.Slide;
import view.SlideViewerComponent;
import view.SlideViewerFrame;

/**
 * 
 * @author Marielle Fransen & Jasper Vek
 * 
 */
public class MouseController extends MouseInputAdapter implements IInputController {

	private AnnotateItem annotateItem;
	private SlideViewerComponent comp;
	private Graphics2D g ;

	public MouseController(SlideViewerComponent comp) {
		this.comp = comp;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			annotateItem = ((Slide) comp.getSlide()).getAnnotateItem();	
			annotateItem.resetVector();
			this.addMouseMovement(e);
		    g = (Graphics2D) comp.getGraphics();
			g.setColor(annotateItem.getColor());
			g.setStroke(new BasicStroke(annotateItem.getTickness()));
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			this.addMouseMovement(e);
			draw();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			this.addMouseMovement(e);
			draw();
		}
	}

	private void addMouseMovement(MouseEvent e) {
		annotateItem.nieuwPunt(getPunt(e));
	}

	private Point getPunt(MouseEvent e) {
		return new Point(e.getX(), e.getY());
	}
	
	private void draw() {
		for (int i = 1; i < annotateItem.getVector().size(); i++) {
			Point previous = annotateItem.getVector().get(i - 1);
			Point current = annotateItem.getVector().get(i);
			g.drawLine(previous.x, previous.y, current.x, current.y);
			annotateItem.addLine(previous, current);
		}
	}

	public void clear() {
		annotateItem.clear();
	}
	
}
