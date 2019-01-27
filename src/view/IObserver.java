package view;
import model.ISlide;
/**
 * 
 * @author   Marielle Fransen & Jasper Vek
 * 
*/
import model.Presentation;
import model.Slide;

public interface IObserver {
	public void update(Presentation subject, ISlide iSlide);
}