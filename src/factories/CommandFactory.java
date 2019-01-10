package factories;
import commands.About;
import commands.Exit;
import commands.FileOpen;
import commands.GotoSlide;
import commands.ICommand;
import commands.NextSlide;
import commands.PreviousSlide;
import commands.SaveFile;
import io.IReader;
import io.IWriter;
import model.IPresentationModel;

import model.Presentation;
import view.SlideViewerFrame;
/** 
*
* @author  Marielle Fransen & Jasper Vek
* 
*/
public class CommandFactory implements ICommandFactory {

	private SlideViewerFrame f;
	private Presentation p;
	
	public CommandFactory(SlideViewerFrame f, IPresentationModel presentation){
		this.f = f;
		this.p = (Presentation) presentation;
	}
	
	@Override
	public ICommand CreateAbout() {
		return new About(f);
	}

	@Override
	public ICommand CreateExit() {
		return new Exit();
	}

	@Override
	public ICommand CreateNextSlide() {		
		return new NextSlide(p);
	}

	@Override
	public ICommand CreatePreviousSlide() {		
		return new PreviousSlide(p);
	}

	@Override
	public ICommand CreateGotoSlide(int slideNumber) {
		return new GotoSlide(p,slideNumber);
 
	}

	@Override
	public ICommand CreateFileOpen(String fn, IReader r){
		// TODO Auto-generated method stub
		return new FileOpen( fn,  r,p);
	}

	@Override
	public ICommand CreateSaveFile() {
		// TODO Auto-generated method stub
		return new SaveFile(p);
	}
}