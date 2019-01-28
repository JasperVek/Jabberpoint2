package factories;

import model.AnnotateItem;
import model.BitmapItem;
import model.DrawBitmapStrategy;
import model.DrawTextStrategy;
import model.DrawAnnotateItemStrategy;
import model.SlideItem;
import model.TextItem;
/**
*
* @author Marielle Fransen & Jasper Vek
* 
* 
*/
public class SlideItemFactory {

	private final String TEXT = "text";
	private final String IMAGE = "image";
	private final String UNKNOWNTYPE = "Unknown Element type";
	
	public SlideItem createSlideItem(int level, String textContent, String type)
	{
		if (TEXT.equals(type)) {
			return (SlideItem) createTextItem(level, textContent);
		}
		else {
			if (IMAGE.equals(type)) {
				return (SlideItem) createBitmapItem(level, textContent);
			}
			else {
				System.err.println(UNKNOWNTYPE);
				return null;
			}
		}
	}
	
	public TextItem createTextItem(int level, String string)
	{
		return new TextItem(level, string, new DrawTextStrategy());
	}
	
	public TextItem createEmptyTextItem()
	{
		return new TextItem();
	}
	
	public BitmapItem createBitmapItem(int level, String name)
	{
		
		return new BitmapItem(level, name,new DrawBitmapStrategy());
	}
	
	public BitmapItem createEmptyBitmapItem()
	{
		return new BitmapItem(new DrawBitmapStrategy());
	}	
	
	public AnnotateItem createAnnotateItem() {
		return new AnnotateItem(new DrawAnnotateItemStrategy());
	}
}