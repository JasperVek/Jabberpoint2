package io;

import java.io.IOException;

import model.Presentation;

/** 
*
* @author  Marielle Fransen & Jasper Vek
* 
*/
public interface IReader extends IAccessor{
    /** namen van xml tags of attributen */
    static final String SHOWTITLE = "showtitle";
    static final String SLIDETITLE = "title";
    static final String SLIDE = "slide";
    static final String ITEM = "item";
    static final String LEVEL = "level";
    static final String KIND = "kind";
    static final String TEXT = "text";
    static final String IMAGE = "image";
    
	public void read() throws IOException;

}
