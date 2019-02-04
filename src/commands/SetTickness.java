package commands;

import java.awt.Color;

import model.IPresentationModel;
import model.Presentation;
import model.Slide;

public class SetTickness implements ICommand {
	
	private IPresentationModel p;
	private int i;

	public SetTickness(IPresentationModel p, int i){
		this.p = p;
		this.i = i;
	}
	
	@Override
	public void Execute() {
  // picker to be implemented
		((Slide) ((Presentation) p).getCurrentSlide()).getAnnotateItem().setLineThickness(i);
	}

}