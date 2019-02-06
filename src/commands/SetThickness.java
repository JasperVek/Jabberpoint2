package commands;

import model.IPresentationModel;
import model.Presentation;
import model.Slide;

/** 
*
* @author  Marielle Fransen & Jasper Vek
* 
*/
public class SetThickness implements ICommand {

	private IPresentationModel p;
	private int i;

	public SetThickness(IPresentationModel p, int i) {
		this.p = p;
		this.i = i;
	}

	@Override
	public void Execute() {
		// updown to be implemented
		((Slide) ((Presentation) p).getCurrentSlide()).getAnnotateItem().setLineThickness(i);
	}

}