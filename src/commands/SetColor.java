package commands;

import java.awt.Color;

import javax.swing.JColorChooser;

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
		JColorChooser cc = new JColorChooser();
		Color newColor = JColorChooser.showDialog( cc, "Color Chooser", Color.blue );
		((Slide) ((Presentation) p).getCurrentSlide()).getAnnotateItem().setColor(newColor);
	}

}