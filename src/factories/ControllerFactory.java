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
	
	public MenuController createMenuController(Frame frame, Presentation pres, ICommandFactory cf)
	{
			return new MenuController(frame, pres, cf);
	}
	
	public MouseController createMouseController()
	{
			return new MouseController();
	}
}