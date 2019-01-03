package commands;
/** 
*
* @author  Marielle Fransen & Jasper Vek
* 
*/
import view.AboutBox;
import view.SlideViewerFrame;;

public class About implements ICommand {

	private SlideViewerFrame f;

	public About(SlideViewerFrame f) {
		this.f = f;
	}

	@Override
	public void Execute() {
		AboutBox.show(f);
	}

}