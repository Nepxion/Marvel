package com.nepxion.swing.border;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalBorders.ScrollPaneBorder;

public class BorderManager
{
	/**
	 * The instance of Border for scrollPane border.
	 */
	private static Border scrollPaneBorder;
	
	/**
	 * Creates the scrollPane border.
	 * @return the instance of Border
	 */
	public static Border createScrollPaneBorder()
	{
		if (scrollPaneBorder == null)
		{
			scrollPaneBorder = UIManager.getBorder("ScrollPane.border");
			if (scrollPaneBorder == null || scrollPaneBorder instanceof ScrollPaneBorder)
			{
				scrollPaneBorder = BorderFactory.createEtchedBorder();
			}
		}
		
		return scrollPaneBorder;
	}
	
	/**
	 * Creates the complex titled border.
	 * @param title the title string
	 * @return the instance of Border
	 */
	public static Border createComplexTitledBorder()
	{
		return createComplexTitledBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH));
	}
	
	/**
	 * Creates the complex titled border.
	 * @param border the instance of Border
	 * @return the instance of Border
	 */
	public static Border createComplexTitledBorder(Border border)
	{
		return new ComplexTitledBorder(border);
	}
	
	/**
	 * Creates the complex titled border.
	 * @param title the title string
	 * @return the instance of Border
	 */
	public static Border createComplexTitledBorder(String title)
	{
		return createComplexTitledBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), title);
	}
	
	/**
	 * Creates the complex titled border.
	 * @param border the instance of Border
	 * @param title the title string
	 * @return the instance of Border
	 */
	public static Border createComplexTitledBorder(Border border, String title)
	{
		return new ComplexTitledBorder(border, title);
	}
	
	/**
	 * Creates the complex titled border.
	 * @param title the title string
	 * @param titleJustification the title justification value
	 * @param titlePosition the title position value
	 * @return the instance of Border
	 */
	public static Border createComplexTitledBorder(String title, int titleJustification, int titlePosition)
	{
		return createComplexTitledBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), title, titleJustification, titlePosition);
	}
	
	/**
	 * Creates the complex titled border.
	 * @param border the instance of Border
	 * @param title the title string
	 * @param titleJustification the title justification value
	 * @param titlePosition the title position value
	 * @return the instance of Border
	 */
	public static Border createComplexTitledBorder(Border border, String title, int titleJustification, int titlePosition)
	{
		return new ComplexTitledBorder(border, title, titleJustification, titlePosition);
	}
	
	/**
	 * Creates the complex titled border.
	 * @param title the title string
	 * @param titleJustification the title justification value
	 * @param titlePosition the title position value
	 * @param titleFont the title font
	 * @return the instance of Border
	 */
	public static Border createComplexTitledBorder(String title, int titleJustification, int titlePosition, Font titleFont)
	{
		return createComplexTitledBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), title, titleJustification, titlePosition, titleFont);
	}
	
	/**
	 * Creates the complex titled border.
	 * @param border the instance of Border
	 * @param title the title string
	 * @param titleJustification the title justification value
	 * @param titlePosition the title position value
	 * @param titleFont the title font
	 * @return the instance of Border
	 */
	public static Border createComplexTitledBorder(Border border, String title, int titleJustification, int titlePosition, Font titleFont)
	{
		return new ComplexTitledBorder(border, title, titleJustification, titlePosition, titleFont);
	}
	
	/**
	 * Creates the complex titled border.
	 * @param title the title string
	 * @param titleJustification the title justification value
	 * @param titlePosition the title position value
	 * @param titleFont the title font
	 * @param titleColor the title color
	 * @return the instance of Border
	 */
	public static Border createComplexTitledBorder(String title, int titleJustification, int titlePosition, Font titleFont, Color titleColor)
	{
		return createComplexTitledBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), title, titleJustification, titlePosition, titleFont, titleColor);
	}
	
	/**
	 * Creates the complex titled border.
	 * @param border the instance of Border
	 * @param title the title string
	 * @param titleJustification the title justification value
	 * @param titlePosition the title position value
	 * @param titleFont the title font
	 * @param titleColor the title color
	 * @return the instance of Border
	 */
	public static Border createComplexTitledBorder(Border border, String title, int titleJustification, int titlePosition, Font titleFont, Color titleColor)
	{
		return new ComplexTitledBorder(border, title, titleJustification, titlePosition, titleFont, titleColor);
	}
}