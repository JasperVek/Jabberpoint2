package io;

import java.io.IOException;
import javax.swing.JOptionPane;

import model.Presentation;
/** 
*
* @author  Marielle Fransen & Jasper Vek
* 
*/
public class HTMLReader implements IReader {

	
	public HTMLReader(Presentation p, String fn) {

	}


	@Override
	public void read() throws IOException {
		javax.swing.JOptionPane.showMessageDialog(null,"Oops...", "not yet implemented...", 0);
	}

	@Override
	public void write(Presentation p, String fn) throws IOException {
		// do nothing

	}

}
