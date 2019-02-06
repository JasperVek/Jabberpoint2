package commands;

import factories.SlideBuilder;
import model.Presentation;
import model.Slide;

/**
 *
 * @author Marielle Fransen & Jasper Vek
 * 
 */
public class New implements ICommand {

	private Presentation p;

	public New(Presentation p) {
		this.p = p;
	}

	@Override
	public void Execute() {
		p.clear();
		p.setTitle("Nieuwe presentatie");
		SlideBuilder slideBuilder = new SlideBuilder();
		Slide slide = (Slide) slideBuilder.createSlide();
		slide.setTitle("nieuw....");
		p.append(slide);
		p.ChangeState(0);
	}

}