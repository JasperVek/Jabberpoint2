package commands;

import model.IPresentatieModel;

/** 
*
* @author  Marielle Fransen & Jasper Vek
* 
*/
public class GotoSlide implements ICommand {
	
	private IPresentatieModel p;
	private int newSlideNumber;

	public GotoSlide(IPresentatieModel p,int slideNumber){
		this.p = p;
		this.newSlideNumber = slideNumber;
	}
	
	@Override
	public void Execute() {
		p.ChangeState(newSlideNumber);
	}

}
