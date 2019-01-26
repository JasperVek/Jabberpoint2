package commands;

import java.io.IOException;

import javax.swing.JOptionPane;

import factories.AccessorFactory;
import io.DemoWriter;
import io.HTMLWriter;
import io.IWriter;
import io.XMLWriter;
import model.Presentation;

public class SaveFile implements ICommand {
	protected static final String SAVEFILE = "dump.xml";
	protected static final String IOERR = "IO Error: ";
	protected static final String JABERR = "Jabberpoint Error ";

	private AccessorFactory accessorFactory;
	
	Presentation p = null;
	IWriter r = null;
	String fn = SAVEFILE;

	public SaveFile(Presentation p) {
		this.p = p;
	}

	@Override
	public void Execute() {
		
		r = accessorFactory.createWriter(p, fn);
		
		try {
			r.write();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, IOERR + ex, JABERR, JOptionPane.ERROR_MESSAGE);
		}
	}
}