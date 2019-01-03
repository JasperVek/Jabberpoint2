package io;

import java.io.IOException;

import model.Presentation;

public class DemoWriter implements IWriter {
	public DemoWriter(Presentation p, String fn) {		
	}

	@Override
	public void write() throws IOException {
		javax.swing.JOptionPane.showMessageDialog(null,"Oops...", "Demo Presentation can not save..", 0);

	}
	
	@Override
	public void read() throws IOException {
		// do nothing

	}

}
