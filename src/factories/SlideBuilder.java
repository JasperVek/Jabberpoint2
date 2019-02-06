package factories;

import model.IPresentationModel;
import model.ISlide;
import model.Presentation;
import model.Slide;
import model.Style;

/** 
*
* @author  Marielle Fransen & Jasper Vek
* 
*/
public class SlideBuilder extends GUIBuilder {

	@Override
	public
	IPresentationModel createPresentation() {
		
		return new Presentation();
	}

	@Override
	public ISlide createSlide() {
		
		return new Slide();
	}
}