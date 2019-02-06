package commands;

import java.awt.Color;
import model.IPresentationModel;
import model.Presentation;
import model.Slide;

/** 
*
* @author  Marielle Fransen & Jasper Vek
* 
*/
public class SetColor implements ICommand {

	private IPresentationModel p;

	public SetColor(IPresentationModel p) {
		this.p = p;
	}

	@Override
	public void Execute() {
		// picker to be implemented
		((Slide) ((Presentation) p).getCurrentSlide()).getAnnotateItem().setColor(Color.BLUE);
	}

}