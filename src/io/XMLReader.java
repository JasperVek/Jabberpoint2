package io;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import factories.GUIBuilder;
import factories.SlideItemFactory;
import model.BitmapItem;
import model.ISlide;
import model.Presentation;
import model.Slide;
import model.TextItem;
/** 
*
* @author  Marielle Fransen & Jasper Vek
* 
*/
public class XMLReader implements IReader {
    /** Default API to use. */
    protected static final String DEFAULT_API_TO_USE = "dom";
    /** tekst van messages */
    protected static final String PCE = "Parser Configuration Exception";
    protected static final String UNKNOWNTYPE = "Unknown Element type";
    protected static final String NFE = "Number Format Exception";
    
    
	private Presentation p;
	private String fn;
	
	private GUIBuilder guiBuilder;
	private SlideItemFactory slideItemFactory;
	
    private String getTitle(Element element, String tagName) {
    	NodeList titles = element.getElementsByTagName(tagName);
    	return titles.item(0).getTextContent();
    }

    private void loadSlideItem(ISlide slide, Element item) {
		int level = 1; // default
		NamedNodeMap attributes = item.getAttributes();
		String leveltext = attributes.getNamedItem(LEVEL).getTextContent();
		if (leveltext != null) {
			try {
				level = Integer.parseInt(leveltext);
			}
			catch(NumberFormatException x) {
				System.err.println(NFE);
			}
		}
		// TODO het kiezen overlaten aan de create..
		String type = attributes.getNamedItem(KIND).getTextContent();
		slideItemFactory.createSlideItem(level, item.getTextContent(), type);
		
		slide.append(slideItemFactory.createSlideItem(level, item.getTextContent(), type));
	}	
    
	public XMLReader(Presentation p, String fn) {
		this.p = p;
		this.fn = fn;
	}

	@Override
	public void read() throws IOException {
		int slideNumber, itemNumber, max = 0, maxItems = 0;
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();    
			Document document = builder.parse(new File(fn)); // maak een JDOM document
			Element doc = document.getDocumentElement();
			p.setTitle(getTitle(doc, SHOWTITLE));

			NodeList slides = doc.getElementsByTagName(SLIDE);
			max = slides.getLength();
			for (slideNumber = 0; slideNumber < max; slideNumber++) {
				Element xmlSlide = (Element) slides.item(slideNumber);
				ISlide slide = guiBuilder.createSlide();
				// Slide slide = new Slide(); // TODO nog factory
				slide.setTitle(getTitle(xmlSlide, SLIDETITLE));
				p.append(slide);
				
				NodeList slideItems = xmlSlide.getElementsByTagName(ITEM);
				maxItems = slideItems.getLength();
				for (itemNumber = 0; itemNumber < maxItems; itemNumber++) {
					Element item = (Element) slideItems.item(itemNumber);
					loadSlideItem(slide, item);
				}
			}
		} 
		catch (IOException iox) {
			System.err.println(iox.toString());
		}
		catch (SAXException sax) {
			System.err.println(sax.getMessage());
		}
		catch (ParserConfigurationException pcx) {
			System.err.println(PCE);
		}
	}
}