package factories;

import javax.swing.JFrame;

import model.IPresentationModel;
import view.SlideViewerComponent;
import view.SlideViewerFrame;

public class SlideViewerFactory {

	public SlideViewerFrame createSlideViewerFrame(String title, IPresentationModel presentation)
	{
		return new SlideViewerFrame(title, presentation);
	}
	
	public SlideViewerComponent createSlideViewerComponent(IPresentationModel presentation, JFrame frame)
	{
		return new SlideViewerComponent(presentation, frame);
	}
}