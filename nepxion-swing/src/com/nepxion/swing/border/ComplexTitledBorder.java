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

import javax.swing.border.Border;

import com.jidesoft.swing.JideTitledBorder;

public class ComplexTitledBorder
	extends JideTitledBorder
{
	/**
	 * Constructs with the specified initial title.
	 * @param title the title string
	 */
	public ComplexTitledBorder(String title)
	{
		super(title);
	}
	
	/**
	 * Constructs with the specified initial border.
	 * @param border the instance of Border
	 */
	public ComplexTitledBorder(Border border)
	{
		super(border);
	}
	
	/**
	 * Constructs with the specified initial border and title.
	 * @param border the instance of Border
	 * @param title the title string
	 */
	public ComplexTitledBorder(Border border, String title)
	{
		super(border, title);
	}
	
	/**
	 * Constructs with the specified initial border, title, title justification and title position.
	 * @param border the instance of Border
	 * @param title the title string
	 * @param titleJustification the title justification value
	 * @param titlePosition the title position value
	 */
	public ComplexTitledBorder(Border border, String title, int titleJustification, int titlePosition)
	{
		super(border, title, titleJustification, titlePosition);
	}
	
	/**
	 * Constructs with the specified initial border, title, title justification, title position and title font.
	 * @param border the instance of Border
	 * @param title the title string
	 * @param titleJustification the title justification value
	 * @param titlePosition the title position value
	 * @param titleFont the title font
	 */
	public ComplexTitledBorder(Border border, String title, int titleJustification, int titlePosition, Font titleFont)
	{
		super(border, title, titleJustification, titlePosition, titleFont);
	}
	
	/**
	 * Constructs with the specified initial border, title, title justification, title position, title font and title color.
	 * @param border the instance of Border
	 * @param title the title string
	 * @param titleJustification the title justification value
	 * @param titlePosition the title position value
	 * @param titleFont the title font
	 * @param titleColor the title color
	 */
	public ComplexTitledBorder(Border border, String title, int titleJustification, int titlePosition, Font titleFont, Color titleColor)
	{
		super(border, title, titleJustification, titlePosition, titleFont, titleColor);
	}
}