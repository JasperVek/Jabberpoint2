package io;

import java.io.IOException;

import model.BitmapItem;
import model.Presentation;
import model.Slide;

/** 
*
* @author  Marielle Fransen & Jasper Vek
* 
*/
public  class DemoReader implements IReader {
	private Presentation p;
	private String fn;
	
	public DemoReader(Presentation p, String fn) {
		this.p = p;
		this.fn = fn;
	}

	public void read() throws IOException {
		// TODO Auto-generated method stub
		p.setTitle("Demo Presentation");
		Slide slide;
		slide = new Slide();
		slide.setTitle("JabberPoint");
		slide.append(1, "Het Java Presentatie Tool");
		slide.append(2, "Copyright (c) 1996-2000: Ian Darwin");
		slide.append(2, "Copyright (c) 2000-now:");
		slide.append(2, "Gert Florijn en Sylvia Stuurman");
		slide.append(4, "JabberPoint aanroepen zonder bestandsnaam");
		slide.append(4, "laat deze presentatie zien");
		slide.append(1, "Navigeren:");
		slide.append(3, "Volgende slide: PgDn of Enter");
		slide.append(3, "Vorige slide: PgUp of up-arrow");
		slide.append(3, "Stoppen: q or Q");
		p.append(slide);

		slide = new Slide();
		slide.setTitle("Demonstratie van levels en stijlen");
		slide.append(1, "Level 1");
		slide.append(2, "Level 2");
		slide.append(1, "Nogmaals level 1");
		slide.append(1, "Level 1 heeft stijl nummer 1");
		slide.append(2, "Level 2 heeft stijl nummer 2");
		slide.append(3, "Zo ziet level 3 er uit");
		slide.append(4, "En dit is level 4");
		p.append(slide);

		slide = new Slide();
		slide.setTitle("De derde slide");
		slide.append(1, "Om een nieuwe presentatie te openen,");
		slide.append(2, "gebruik File->Open uit het menu.");
		slide.append(1, " ");
		slide.append(1, "Dit is het einde van de presentatie.");
		slide.append(new BitmapItem(1, "JabberPoint.jpg"));
		p.append(slide);
		
	}

	@Override
	public void write() throws IOException {
		// do nothing
	}



}
