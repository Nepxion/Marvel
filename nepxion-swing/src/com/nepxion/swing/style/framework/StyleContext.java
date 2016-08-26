package com.nepxion.swing.style.framework;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

public class StyleContext
{
	/**
	 * The styla class string.
	 */
	private static String styleClass;
	
	/**
	 * The boolean value of isFrameDecorated.
	 */
	private static boolean isFrameDecorated = false;
	
	/**
	 * The boolean value of isDialogDecorated.
	 */
	private static boolean isDialogDecorated = false;
	
	/**
	 * Registers the style class.
	 * @param styleClass the style class string
	 */
	public static void registerStyle(String styleClass)
	{
		StyleContext.styleClass = styleClass;
	}
	
	/**
	 * Registers the frame decorated.
	 * @param isFrameDecorated the boolean value of isFrameDecorated
	 */
	public static void registerFrameDecorated(boolean isFrameDecorated)
	{
		StyleContext.isFrameDecorated = isFrameDecorated;
	}
	
	/**
	 * Registers the frame isDialogDecorated.
	 * @param isDialogDecorated the boolean value of isDialogDecorated
	 */
	public static void registerDialogDecorated(boolean isDialogDecorated)
	{
		StyleContext.isDialogDecorated = isDialogDecorated;
	}
	
	/**
	 * Gets the style class.
	 * @return the style class string.
	 */
	public static String getStyleClass()
	{
		return styleClass;
	}
	
	/**
	 * Returns true if it is frame decorated.
	 * @return true if it is frame decorated
	 */
	public static boolean isFrameDecorated()
	{
		return isFrameDecorated;
	}
	
	/**
	 * Returns true if it is dialog decorated.
	 * @return true if it is dialog decorated
	 */
	public static boolean isDialogDecorated()
	{
		return isDialogDecorated;
	}
	
	/**
	 * Sets the priority context.
	 * @return true if it is priority context set.
	 */
	public static boolean setPriorityContext()
	{
		if (styleClass != null)
		{
			StyleManager.setStyle(styleClass);
			
			return true;
		}
		
		return false;
	}
}