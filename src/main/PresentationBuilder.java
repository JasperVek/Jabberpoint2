package main;

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
	IPresentationModel createPresentation() {
		// TODO Auto-generated method stub
		return new Presentation();
	}

	@Override
	ISlide createSlide() {
		// TODO Auto-generated method stub
		return null;
	}



}
