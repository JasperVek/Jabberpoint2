package commands;

import model.Presentation;

/** 
*
* @author  Marielle Fransen & Jasper Vek
* 
*/
public class New implements ICommand {
	
	private Presentation p;

	public New(Presentation p){
		this.p = p;
	}
	
	@Override
	public void Execute() {
		p.clear();
		
	}

}