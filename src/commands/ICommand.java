package commands;

/** 
 * ICommand -> Command Design Pattern
 * 
 * Door gebruik van het Commmand Pattern kan kunnen undo/redo acties eenvoudig worden toegevoegd
 * Invoker: IInputController
 * Receiver: IPresentatieModel
 * Client : ISlideViewerFrame
 * 
 * @author  Marielle Fransen & Jasper Vek
 * 
 */
public interface ICommand {
	  void Execute();
}