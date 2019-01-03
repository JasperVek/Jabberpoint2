package commands;

import java.io.IOException;

import javax.swing.JOptionPane;

import io.DemoWriter;
import io.HTMLWriter;
import io.IWriter;
import io.XMLWriter;
import model.Presentation;

public class SaveFile implements ICommand {
	protected static final String SAVEFILE = "dump.xml";
	protected static final String IOERR = "IO Error: ";
	protected static final String JABERR = "Jabberpoint Error ";

	Presentation p = null;
	IWriter r = null;
	String fn = SAVEFILE;

	public SaveFile(Presentation p) {
		this.p = p;
	}

	@Override
	public void Execute() {
		if (fn.length() == 0) {
			r = new DemoWriter(p, "");
		} else {
			String fileExtension;
			fileExtension = fn.substring(fn.lastIndexOf(".") + 1, fn.length());
			switch (fileExtension) {
			case "html":
				r = new HTMLWriter(p,fn);
				break;
			case "xml":
				r = new XMLWriter(p,fn);
				break;

			}
		}
		try {
			r.write();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, IOERR + ex, JABERR, JOptionPane.ERROR_MESSAGE);
		}
	}

}
