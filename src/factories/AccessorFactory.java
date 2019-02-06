package factories;

import java.io.File;

import io.DemoReader;
import io.DemoWriter;
import io.HTMLReader;
import io.HTMLWriter;
import io.IReader;
import io.IWriter;
import io.XMLReader;
import io.XMLWriter;
import model.Presentation;

public class AccessorFactory {
	
	public IReader createReader(Presentation p, String fn)
	{
		if (fn.length() == 0) {
			return createDemoReader(p, "");

		}
		else {
			String fileExtension;
			fileExtension = fn.substring(fn.lastIndexOf(".") + 1, fn.length());
			switch (fileExtension) {
			case "html":
				return createHTMLReader(p, fn);
			case "xml":
				
				return createXMLReader(p, fn);
			default:
				return createDemoReader(p, ""); // of foutmelding?
			}
		}
	}
	

	public IWriter createWriter(Presentation p, String fn)
	{
		if (fn.length() == 0) {
			return createDemoWriter(p, "");
		} else {
			String fileExtension;
			fileExtension = fn.substring(fn.lastIndexOf(".") + 1, fn.length());
			switch (fileExtension) {
			case "html":
				return createHTMLWriter(p,fn);
			case "xml":
				return createXMLWriter(p,fn);
			default:
				return null; // of foutmelding..
			}
		}
	}
	
	public DemoWriter createDemoWriter(Presentation p, String fn)
	{
		return new DemoWriter(p, fn);
	}
	
	public DemoReader createDemoReader(Presentation p, String fn)
	{
		return new DemoReader(p, fn);
	}
	
	public XMLReader createXMLReader(Presentation p, String fn)
	{
		return new XMLReader(p, fn);
	}
	
	public XMLWriter createXMLWriter(Presentation p, String fn)
	{
		return new XMLWriter(p, fn);
	}
	
	public HTMLReader createHTMLReader(Presentation p, String fn)
	{
		return new HTMLReader(p, fn);
	}
	
	public HTMLWriter createHTMLWriter(Presentation p, String fn)
	{
		return new HTMLWriter(p, fn);
	}
}