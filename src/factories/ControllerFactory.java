package factories;

import java.awt.Frame;

import controller.KeyController;
import controller.MenuController;
import controller.MouseController;
import model.Presentation;

public class ControllerFactory {
	
	public KeyController createKeyController(ICommandFactory cf)
	{
		return new KeyController(cf);
	}
	
	public MenuController createMenuController(Frame frame, ICommandFactory cf)
	{
		return new MenuController(frame, cf);

	}
	
	public MouseController createMouseController(Frame frame)
	{
			return new MouseController( frame);
	}
}