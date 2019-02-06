package factories;

import java.awt.Frame;

import controller.KeyController;
import controller.MenuController;
import controller.MouseController;
import model.Presentation;
import view.SlideViewerComponent;
import view.SlideViewerFrame;

public class ControllerFactory {
	
	public KeyController createKeyController(ICommandFactory cf)
	{
		return new KeyController(cf);
	}
	
	public MenuController createMenuController(Frame frame, ICommandFactory cf, SlideViewerComponent component)
	{
		return new MenuController(frame, cf, component );

	}
	
	public MouseController createMouseController(SlideViewerComponent comp)
	{
			return new MouseController( comp);
	}
}