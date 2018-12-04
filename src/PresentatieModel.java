import java.util.ArrayList;
import java.util.Iterator;

public class PresentatieModel implements ISubject {

	private ArrayList<IObserver> observers = new ArrayList<IObserver>();
	
	public int getState() {
		// aanpassen
		return 0;
	}

	@Override
	public void addObserver(IObserver observer) {
		this.observers.add(observer);
	}

	@Override
	public void removeObserver(IObserver observer) {
		this.observers.remove(observer);
	}

	@Override
	public void notifyAllObservers() {
		if(observers.isEmpty() == false)
		{
			for (Iterator<IObserver> observer = observers.iterator(); observer.hasNext();) 
			{
		    IObserver item = observer.next();
		    item.update(this);
			}
		}
	}
}
