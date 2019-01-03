package main;

import model.IPresentationModel;
import model.ISlide;
import model.ISlideItem;
/** 
*
* @author  Marielle Fransen & Jasper Vek
* 
*/

public abstract class GUIBuilder {

	 abstract IPresentationModel createPresentation();
	 abstract ISlide createSlide();
	 abstract ISlideItem createSlideItem();
	 // ook stylefactory?
}
