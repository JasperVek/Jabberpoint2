package controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

/** <p>This is the KeyController (KeyListener)</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2018/12/23 Marielle Fransen & Jasper Vek
*/

public class KeyController extends KeyAdapter implements IInputController  {
	private ICommandFactory cf;
   
	public KeyController(ICommandFactory cf) {

		this.cf = cf;
	}

	public void keyPressed(KeyEvent keyEvent) {
		switch(keyEvent.getKeyCode()) {
			case KeyEvent.VK_PAGE_DOWN:
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_ENTER:
			case '+':
				cf.CreateNextSlide().Execute();
				break;
			case KeyEvent.VK_PAGE_UP:
			case KeyEvent.VK_UP:
			case '-':
				cf.CreatePreviousSlide().Execute();
				break;
			case 'q':
			case 'Q':
				cf.CreateExit().Execute();
				break; // wordt nooit bereikt als het goed is
			default:
				break;
		}
	}
}
