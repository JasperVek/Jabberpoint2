package commands;

import model.IPresentatieModel;

/** 
*
* @author  Marielle Fransen & Jasper Vek
* 
*/
public class NextSlide implements ICommand {
	
	private IPresentatieModel p;

	public NextSlide(IPresentatieModel p){
		this.p = p;
	}
	
	@Override
	public void Execute() {
		int currentSlide = p.getState();
		p.ChangeState(++currentSlide);
	}

}
