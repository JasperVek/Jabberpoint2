public interface IPresentatieModel extends ISubject {
	public int getState();
	public void ChangeState(int number);
	public void addObserver(IObserver observer);
	public void removeObserver(IObserver observer);
	public void notifyAllObservers();
}