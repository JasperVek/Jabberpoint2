package commands;

import model.IPresentationModel;

/**
 *
 * @author Marielle Fransen & Jasper Vek
 * 
 */
public class GotoSlide implements ICommand {

	private IPresentationModel p;
	private int newSlideNumber;

	public GotoSlide(IPresentationModel p, int slideNumber) {
		this.p = p;
		this.newSlideNumber = slideNumber;
	}

	@Override
	public void Execute() {
		p.ChangeState(newSlideNumber);
	}

}
