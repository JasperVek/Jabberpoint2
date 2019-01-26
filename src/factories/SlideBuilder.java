package factories;

import model.IPresentationModel;
import model.ISlide;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISlide createSlide() {
		// TODO Auto-generated method stub
		return new Slide();
	}
}