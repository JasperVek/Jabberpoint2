package main;

import model.IPresentationModel;
import model.ISlide;
import model.ISlideItem;


public abstract class GUIBuilder {

	 abstract IPresentationModel createPresentation();
	 abstract ISlide createSlide();
	 abstract ISlideItem createSlideItem();
}
