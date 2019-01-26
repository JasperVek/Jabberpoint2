package main;

import java.io.IOException;
import javax.swing.JOptionPane;
import factories.GUIBuilder;
import factories.PresentationBuilder;
import factories.SlideBuilder;
import factories.SlideViewerFactory;
import io.DemoReader;
import io.HTMLReader;
import io.IAccessor;
import io.IReader;
import io.XMLReader;
import model.IPresentationModel;
import model.Presentation;
import model.Style;
import view.SlideViewerFrame;


/**
 * JabberPoint Main Programma
 * <p>
 * This program is distributed under the terms of the accompanying COPYRIGHT.txt
 * file (which is NOT the GNU General Public License). Please read it. Your use
 * of the software constitutes acceptance of the terms in the COPYRIGHT.txt
 * file.
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

public class JabberPoint {
//	protected static final String IOERR = "IO Error: ";
//	protected static final String JABERR = "Jabberpoint Error ";
	protected static final String JABVERSION = "Jabberpoint 1.7 - OU+Marielle+Jasper's version";

	/** Het Main Programma */
	public static void main(String argv[]) {
		IReader r = null;
		String fileExtension;
		
		GUIBuilder pBuilder = new PresentationBuilder();
		GUIBuilder sBuilder = new SlideBuilder();
		SlideViewerFactory viewFactory = new SlideViewerFactory();
		// slideItems

		IPresentationModel presentation = pBuilder.createPresentation();

		Style.createStyles();
		
		SlideViewerFrame svf = viewFactory.createSlideViewerFrame(JABVERSION, presentation);
		svf.cf.CreateFileOpen("", r).Execute();

	}
}