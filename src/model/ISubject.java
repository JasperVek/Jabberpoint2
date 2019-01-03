package model;
/**
 * 
 * @author   Marielle Fransen & Jasper Vek
 * 
*/
import view.IObserver;

public interface ISubject {
	public void addObserver(IObserver observer);
	public void removeObserver(IObserver observer);
	public void notifyAllObservers();
}