package factories;

import model.BitmapItem;
import model.ISlideItem;
import model.TextItem;

public class SlideItemFactory {

	private final String TEXT = "text";
	private final String IMAGE = "image";
	private final String UNKNOWNTYPE = "Unknown Element type";
	
	public ISlideItem createSlideItem(int level, String textContent, String type)
	{
		if (TEXT.equals(type)) {
			return (ISlideItem) createTextItem(level, textContent);
		}
		else {
			if (IMAGE.equals(type)) {
				return (ISlideItem) createBitmapItem(level, textContent);
			}
			else {
				System.err.println(UNKNOWNTYPE);
				return null;
			}
		}
	}
	
	public TextItem createTextItem(int level, String string)
	{
		return new TextItem(level, string);
	}
	
	public TextItem createEmptyTextItem()
	{
		return new TextItem();
	}
	
	public BitmapItem createBitmapItem(int level, String name)
	{
		return new BitmapItem(level, name);
	}
	
	public BitmapItem createEmptyBitmapItem()
	{
		return new BitmapItem();
	}	
}