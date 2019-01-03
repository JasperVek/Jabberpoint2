package commands;

import model.IPresentationModel;

/** 
*
* @author  Marielle Fransen & Jasper Vek
* 
*/
public class PreviousSlide implements ICommand {
	
	private IPresentationModel p;

	public PreviousSlide(IPresentationModel p){
		this.p = p;
	}
	
	@Override
	public void Execute() {
		int currentSlide = p.getState();
		p.ChangeState(--currentSlide);
	}

}
