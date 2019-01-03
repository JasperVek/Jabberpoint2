package commands;

import model.IPresentationModel;

/** 
*
* @author  Marielle Fransen & Jasper Vek
* 
*/
public class NextSlide implements ICommand {
	
	private IPresentationModel p;

	public NextSlide(IPresentationModel p){
		this.p = p;
	}
	
	@Override
	public void Execute() {
		int currentSlide = p.getState();
		p.ChangeState(++currentSlide);
	}

}
