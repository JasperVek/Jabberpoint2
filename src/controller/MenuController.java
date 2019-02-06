package controller;

import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import factories.ControllerFactory;
import factories.ICommandFactory;
import io.IAccessor;
import io.IReader;
import io.IWriter;
import model.Presentation;
import view.SlideViewerComponent;

/**
 * <p>
 * De controller voor het menu
 * </p>
 * 
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2018/12/22 Marielle Fransen & Jasper Vek
 */
public class MenuController extends MenuBar implements IInputController {

	private Frame parent; // het frame, alleen gebruikt als ouder voor de Dialogs
	private Presentation presentation; // Er worden commando's gegeven aan de presentatie
	private MouseController mouseCon;
	private SlideViewerComponent component;
	
	private static final long serialVersionUID = 227L;

	protected static final String ABOUT = "About";
	protected static final String FILE = "File";
	protected static final String EXIT = "Exit";
	protected static final String GOTO = "Go to";
	protected static final String HELP = "Help";
	protected static final String NEW = "New";
	protected static final String NEXT = "Next";
	protected static final String OPEN = "Open";
	protected static final String PAGENR = "Page number?";
	protected static final String PREV = "Prev";
	protected static final String SAVE = "Save";
	protected static final String VIEW = "View";
	protected static final String ANNOTATE = "Annotate";
	protected static final String SETCOLOR = "Set color";
	protected static final String TICKMIN = "Tickness - 1";
	protected static final String TICKPLUS = "Tickness + 1";

	protected static final String TESTFILE = "test.xml";
	protected static final String SAVEFILE = "dump.xml";

	protected static final String IOEX = "IO Exception: ";
	protected static final String LOADERR = "Load Error";
	protected static final String SAVEERR = "Save Error";
	
	protected static final String START = "Start";
	protected static final String STOP = "Stop";
	protected static final String CLEAR = "Clear";

	public MenuController(Frame frame, ICommandFactory cf, SlideViewerComponent component) {


		parent = frame;

		MenuItem menuItem;
		IAccessor r = null;

		// filemenu
		Menu fileMenu = new Menu(FILE);
		fileMenu.add(menuItem = mkMenuItem(OPEN));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {				
				cf.CreateFileOpen(TESTFILE, (IReader) r).Execute();

			}
		});
		fileMenu.add(menuItem = mkMenuItem(NEW));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				cf.CreateNew().Execute();
				parent.repaint();
			}
		});
		fileMenu.add(menuItem = mkMenuItem(SAVE));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cf.CreateSaveFile().Execute();
			}
		});
		fileMenu.addSeparator();
		fileMenu.add(menuItem = mkMenuItem(EXIT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				cf.CreateExit().Execute();
			}
		});
		add(fileMenu);

		// viewmenu
		Menu viewMenu = new Menu(VIEW);
		viewMenu.add(menuItem = mkMenuItem(NEXT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				cf.CreateNextSlide().Execute();
			}
		});
		viewMenu.add(menuItem = mkMenuItem(PREV));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				cf.CreatePreviousSlide().Execute();
			}
		});
		viewMenu.add(menuItem = mkMenuItem(GOTO));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String pageNumberStr = JOptionPane.showInputDialog((Object) PAGENR);
				int pageNumber = Integer.parseInt(pageNumberStr);
				// dialog in command????
				cf.CreateGotoSlide(pageNumber - 1).Execute();
			}
		});
		add(viewMenu);

		//Annotatemenu
		Menu annotateMenu = new Menu(ANNOTATE);
		
		annotateMenu.add(menuItem = mkMenuItem(START));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// start
				ControllerFactory controllerF = new ControllerFactory();
				mouseCon = controllerF.createMouseController(component);
		     	component.addMouseListener(mouseCon);
		     	component.addMouseMotionListener(mouseCon);
			}
		});
		
		annotateMenu.add(menuItem = mkMenuItem(SETCOLOR));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				cf.CreateSetColor().Execute();
			}
		});
		add(annotateMenu);
		annotateMenu.add(menuItem = mkMenuItem(TICKMIN));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				cf.CreateSetTickness(-1).Execute();
			}
		});
		add(annotateMenu);		
		annotateMenu.add(menuItem = mkMenuItem(TICKPLUS));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				cf.CreateSetTickness(+1).Execute();
			}
		});
		annotateMenu.add(menuItem = mkMenuItem(STOP));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				component.removeMouseListener(mouseCon);
				component.removeMouseMotionListener(mouseCon);
			}
		});
		annotateMenu.add(menuItem = mkMenuItem(CLEAR));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				mouseCon.clear();
				parent.repaint();
			}
		});
		add(annotateMenu);		
		// helpmenu
		Menu helpMenu = new Menu(HELP);
		helpMenu.add(menuItem = mkMenuItem(ABOUT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				cf.CreateAbout().Execute();
			}
		});
		setHelpMenu(helpMenu); // nodig for portability (Motif, etc.).
	}

	// een menu-item aanmaken
	private MenuItem mkMenuItem(String name) {
//				return new MenuItem(name, new MenuShortcut(name.charAt(0))); // shortcuts kloppen niet...
		return new MenuItem(name);
	}

}
