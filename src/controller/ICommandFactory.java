package controller;

import commands.ICommand;

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
}