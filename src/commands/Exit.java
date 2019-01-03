package commands;

/** 
 *
 * @author  Marielle Fransen & Jasper Vek
 * 
 */
public class Exit implements ICommand {

	@Override
	public void Execute() {
		System.exit(0);
	}

}