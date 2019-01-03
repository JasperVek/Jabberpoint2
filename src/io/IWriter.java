package io;

import java.io.IOException;

import model.Presentation;

/** 
*
* @author  Marielle Fransen & Jasper Vek
* 
*/
public interface IWriter extends IAccessor {
	 
	public void write() throws IOException;
}
