package view;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;

import view.IObserver;
import model.Slide;
import controller.KeyController;
import controller.MenuController;
import factories.CommandFactory;
import factories.ControllerFactory;
import factories.ICommandFactory;
import factories.SlideViewerFactory;
import model.IPresentationModel;
import model.Presentation;

/**
 * <p>Het applicatiewindow voor een slideviewcomponent</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2018/12/23 Marielle Fransen & Jasper Vek
*/

public class SlideViewerFrame extends JFrame implements IObserver {
	//observer dingen TODO
	// private int observerState = subject->GetState();
	
	private static final long serialVersionUID = 3227L;
	
	private static final String JABTITLE = "Jabberpoint 1.7 - Marielle+Jasper's version";
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	public ICommandFactory cf;
	public ControllerFactory controllerF;
	
	private SlideViewerComponent component;
	private SlideViewerFactory viewerFactory;
	
	public SlideViewerFrame(String title, IPresentationModel presentation) {
		super(title);
		this.component = viewerFactory.createSlideViewerComponent(presentation, this);
		((Presentation) presentation).setShowView(this.component);
		setupWindow(this.component, presentation);
	}

// De GUI opzetten
	public void setupWindow(SlideViewerComponent 
			slideViewerComponent, IPresentationModel presentation) {
		setTitle(JABTITLE);
		addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});

		cf = new CommandFactory(this,presentation);  // commando's creeeren
		getContentPane().add(slideViewerComponent);
		addKeyListener(controllerF.createKeyController(cf)); // een controller toevoegen
		setMenuBar(controllerF.createMenuController(this, (Presentation) presentation,cf)); // presentation moet eruit; Commands aanpassen
//		// mousecontroller toevoegen
//		//......		
		setSize(new Dimension(WIDTH, HEIGHT)); // Dezelfde maten als Slide hanteert.
		setVisible(true);
	}

	public void update(Presentation subject, Slide data) {
		// krijgt het model mee
		// voert de update uit door dit weer door te geven naar viewerComponent	
		this.component.update(subject, data);
	}
}
