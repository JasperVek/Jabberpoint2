package commands;

import java.io.IOException;

import javax.swing.JOptionPane;

import io.DemoReader;
import io.HTMLReader;
import io.IReader;
import io.XMLReader;
import model.Presentation;

public class FileOpen implements ICommand {
	protected static final String IOERR = "IO Error: ";
	protected static final String JABERR = "Jabberpoint Error ";

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
		if (fn.length() == 0) {
			r = new DemoReader(p, "");
		} else {
			String fileExtension;
			fileExtension = fn.substring(fn.lastIndexOf(".") + 1, fn.length());
			switch (fileExtension) {
			case "html":
				r = new HTMLReader(p, fn);
				break;
			case "xml":
				r = new XMLReader(p, fn);
				break;
			default:
				r = new DemoReader(p, ""); // of foutmelding?
				break;
			}
		}
		try {
			r.read();
			p.setSlideNumber(0);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, IOERR + ex, JABERR, JOptionPane.ERROR_MESSAGE);
		}

	}

}
