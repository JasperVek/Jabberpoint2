package factories;

import commands.ICommand;
import io.IReader;
import io.IWriter;
import model.Presentation;

/** 
 * 
 * @author  Marielle Fransen & Jasper Vek
 * 
 */
public interface ICommandFactory {
  ICommand CreateAbout();
  ICommand CreateExit();
  ICommand CreateNextSlide();
  ICommand CreatePreviousSlide();
  ICommand CreateGotoSlide(int slideNumber);
  ICommand CreateFileOpen(String fn, IReader r);
  ICommand CreateSaveFile();
  ICommand CreateNew();
}