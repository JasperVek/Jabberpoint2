package main;

import model.IPresentationModel;
import model.ISlide;
/** 
*
* @author  Marielle Fransen & Jasper Vek
* 
*/

public abstract class GUIBuilder {

	 abstract IPresentationModel createPresentation();
	 abstract ISlide createSlide();

	 // ook stylefactory?
}
