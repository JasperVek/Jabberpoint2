package factories;

import model.IPresentationModel;
import model.ISlide;
import model.Presentation;
/** 
*
* @author  Marielle Fransen & Jasper Vek
* 
*/

public class PresentationBuilder extends GUIBuilder {

	@Override
	public IPresentationModel createPresentation() {
		// TODO Auto-generated method stub
		return new Presentation();
	}

	@Override
	public ISlide createSlide() {
		// TODO Auto-generated method stub
		return null;
	}
}