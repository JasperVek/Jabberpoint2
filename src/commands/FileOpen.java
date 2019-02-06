package commands;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import factories.AccessorFactory;
import io.IReader;
import model.Presentation;

/** 
*
* @author  Marielle Fransen & Jasper Vek
* 
*/
public class FileOpen implements ICommand {
	protected static final String IOERR = "IO Error: ";
	protected static final String JABERR = "Jabberpoint Error ";

	private AccessorFactory accessorFactory = new AccessorFactory();

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
		if (fn == "DEMO")
			r = accessorFactory.createReader(p, fn);
		else {

			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			int result = fileChooser.showOpenDialog(null);
			fn = fileChooser.getSelectedFile().toString();
			r = accessorFactory.createReader(p, fn);
		}
		try {
			r.read();
			p.setSlideNumber(0);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, IOERR + ex, JABERR, JOptionPane.ERROR_MESSAGE);
		}
	}
}