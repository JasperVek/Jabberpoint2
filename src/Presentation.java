import java.util.ArrayList;
import java.util.Iterator;

/**
 * <p>Presentation houdt de slides in de presentatie bij.</p>
 * <p>Er is slechts één instantie van deze klasse aanwezig.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Presentation implements IPresentatieModel  {
		
	private String showTitle; // de titel van de presentatie
	private ArrayList<Slide> showList = null; // een ArrayList met de Slides
	private int currentSlideNumber = 0; // het slidenummer van de huidige Slide (de State)
	
	public Presentation() {
		clear();
	}

	public Presentation(SlideViewerComponent slideViewerComponent) {
		addObserver(slideViewerComponent);
		clear();
	}

	public int getSize() {
		return showList.size();
	}

	public String getTitle() {
		return showTitle;
	}

	public void setTitle(String nt) {
		showTitle = nt;
	}

	public void setShowView(SlideViewerComponent slideViewerComponent) {
		addObserver(slideViewerComponent);
	}
	
	// geef het nummer van de huidige slide (de State)
	public int getSlideNumber() {
		return currentSlideNumber;
	}
	
	// verander het huidige-slide-nummer en laat het aan het window weten.
	public void setSlideNumber(int number) {
		currentSlideNumber = number;
		notifyAllObservers();
	}

	// Verwijder de presentatie, om klaar te zijn voor de volgende
	void clear() {
		showList = new ArrayList<Slide>();
		setSlideNumber(-1);
	}

	// Voeg een slide toe aan de presentatie
	public void append(Slide slide) {
		showList.add(slide);
	}

	// Geef een slide met een bepaald slidenummer
	public Slide getSlide(int number) {
		if (number < 0 || number >= getSize()){
			return null;
	    }
			return (Slide)showList.get(number);
	}

	// Geef de huidige Slide
	public Slide getCurrentSlide() {
		return getSlide(currentSlideNumber);
	}

	public void exit(int n) {
		System.exit(n);
	}	
	
	// Subject
	private ArrayList<IObserver> observers = new ArrayList<IObserver>();
	
	public int getState() {
		return currentSlideNumber;
	}
	
	@Override
	public void ChangeState(int number) 
	{
		if(number == -1)
		{
		 // min
		 if (currentSlideNumber > 0) {
			setSlideNumber(currentSlideNumber + number);
	     }
		}
		if(number == 1)
		 {
		 // plus
		 if (currentSlideNumber < (showList.size()-1)) {
			setSlideNumber(currentSlideNumber + number);
		 }	
		}
	}

	public void addObserver(IObserver observer) {
		this.observers.add(observer);
	}

	public void removeObserver(IObserver observer) {
		this.observers.remove(observer);
	}

	// update aanroepen van alle observers
	public void notifyAllObservers() {
		if(observers.isEmpty() == false)
		{
			for (Iterator<IObserver> observer = observers.iterator(); observer.hasNext();) 
			{
		    IObserver item = observer.next();
		    item.update(this, getCurrentSlide());
			}
		}
	}
}