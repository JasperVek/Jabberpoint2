package factories;

import model.IPresentationModel;
import model.ISlide;
/** 
*
* @author  Marielle Fransen & Jasper Vek
* 
*/

public abstract class GUIBuilder {

	 public abstract IPresentationModel createPresentation();
	 public abstract ISlide createSlide();

	 // ook stylefactory?
}
