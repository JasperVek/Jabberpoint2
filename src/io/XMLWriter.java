package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import model.BitmapItem;
import model.Presentation;
import model.Slide;
import model.SlideItem;
import model.TextItem;

public class XMLWriter implements IWriter {
	private Presentation p;
	private String fn;

	public XMLWriter(Presentation p, String fn) {
		this.p = p;
		this.fn = fn;
	}

	@Override
	public void write() throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(fn));
		out.println("<?xml version=\"1.0\"?>");
		out.println("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");
		out.println("<presentation>");
		out.print("<showtitle>");
		out.print(p.getTitle());
		out.println("</showtitle>");
		for (int slideNumber = 0; slideNumber < p.getSize(); slideNumber++) {
			Slide slide = p.getSlide(slideNumber);
			out.println("<slide>");
			out.println("<title>" + slide.getTitle() + "</title>");
			Vector<SlideItem> slideItems = slide.getSlideItems();
			for (int itemNumber = 0; itemNumber < slideItems.size(); itemNumber++) {
				SlideItem slideItem = (SlideItem) slideItems.elementAt(itemNumber);
				out.print("<item kind=");
				if (slideItem instanceof TextItem) {
					out.print("\"text\" level=\"" + slideItem.getLevel() + "\">");
					out.print(((TextItem) slideItem).getText());
				} else {
					if (slideItem instanceof BitmapItem) {
						out.print("\"image\" level=\"" + slideItem.getLevel() + "\">");
						out.print(((BitmapItem) slideItem).getName());
					} else {
						System.out.println("Ignoring " + slideItem);
					}
				}
				out.println("</item>");
			}
			out.println("</slide>");
		}
		out.println("</presentation>");
		out.close();
	}

}
