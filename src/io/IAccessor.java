package io;

import java.io.IOException;
import model.Presentation;
/** 
*
* @author  Marielle Fransen & Jasper Vek
* 
*/
public interface IAccessor {
	public void read() throws IOException;

	public void write(Presentation p, String fn) throws IOException;

}
