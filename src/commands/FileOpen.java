package commands;

import java.io.IOException;

import javax.swing.JOptionPane;

import factories.AccessorFactory;
import io.DemoReader;
import io.HTMLReader;
import io.IReader;
import io.XMLReader;
import model.Presentation;

public class FileOpen implements ICommand {
	protected static final String IOERR = "IO Error: ";
	protected static final String JABERR = "Jabberpoint Error ";

	private AccessorFactory accessorFactory;
	
	String fn;
	IReader r = null;
	Presentation p = null;

	public FileOpen(String fn, IReader r, Presentation p) {
		this.fn = fn;
		this.r = r;
		this.p = p;
	}

	@Override
	public void Execute() {
		p.clear();
		
		r = accessorFactory.createReader(p, fn);
				
		try {
			r.read();
			p.setSlideNumber(0);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, IOERR + ex, JABERR, JOptionPane.ERROR_MESSAGE);
		}
	}
}