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

import java.awt.Color;

import javax.swing.border.Border;

public abstract class AbstractStyle
	implements IStyle
{
	/**
	 * The gradient color.
	 */
	protected Color gradientColor;
	
	/**
	 * The selection gradient color.
	 */
	protected Color selectionGradientColor;
	
	/**
	 * The foreground.
	 */
	protected Color foreground;
	
	/**
	 * The selection foreground.
	 */
	protected Color selectionForeground;
	
	/**
	 * The background.
	 */
	protected Color background;
	
	/**
	 * The selection background.
	 */
	protected Color selectionBackground;
	
	/**
	 * The border.
	 */	
	protected Border border;
	
	/**
	 * The header border.
	 */	
	protected Border headerBorder;
	
	/**
	 * The title border.
	 */	
	protected Border titleBorder;
	
	/**
	 * The tabbed pane gradient color.
	 */	
	protected Color tabbedPaneGradientColor;
	
	/**
	 * The tabbed pane background.
	 */	
	protected Color tabbedPaneBackground;
	
	/**
	 * The tabbed pane foreground.
	 */	
	protected Color tabbedPaneForeground;
	
	/**
	 * The tabbed pane selection foreground.
	 */	
	protected Color tabbedPaneSelectionForeground;
	
	/**
	 * The tabbed pane border line color.
	 */	
	protected Color tabbedPaneBorderLineColor;
	
	/**
	 * Constructs with the default.
	 */
	public AbstractStyle()
	{
	}
	
	/**
	 * Gets the gradient color.
	 * @return the instance of Color
	 */
	public Color getGradientColor()
	{
		return gradientColor;
	}
	
	/**
	 * Gets the selection gradient color.
	 * @return the instance of Color
	 */
	public Color getSelectionGradientColor()
	{
		return selectionGradientColor;
	}
	
	/**
	 * Gets the foreground.
	 * @return the instance of Color
	 */
	public Color getForeground()
	{
		return foreground;
	}
	
	/**
	 * Gets the selection foreground.
	 * @return the instance of Color
	 */
	public Color getSelectionForeground()
	{
		return selectionForeground;
	}
	
	/**
	 * Gets the background.
	 * @return the instance of Color
	 */
	public Color getBackground()
	{
		return background;
	}
	
	/**
	 * Gets the selection background.
	 * @return the instance of Color
	 */
	public Color getSelectionBackground()
	{
		return selectionBackground;
	}
	
	/**
	 * Gets the border.
	 * @return the instance of Border.
	 */
	public Border getBorder()
	{
		return border;
	}
	
	/**
	 * Gets the header border.
	 * @return the instance of Border
	 */
	public Border getHeaderBorder()
	{
		return headerBorder;
	}
	
	/**
	 * Gets the title border.
	 * @return the instance of Border
	 */
	public Border getTitleBorder()
	{
		return titleBorder;
	}
	
	/**
	 * Gets the tabbed pane gradient color.
	 * @return the instance of Color
	 */
	public Color getTabbedPaneGradientColor()
	{
		return tabbedPaneGradientColor;
	}
	
	/**
	 * Gets the tabbed pane background.
	 * @return the instance of Color
	 */
	public Color getTabbedPaneBackground()
	{		
		return tabbedPaneBackground;
	}
	
	/**
	 * Gets the tabbed pane foreground.
	 * @return the instance of Color
	 */
	public Color getTabbedPaneForeground()
	{
		return tabbedPaneForeground;
	}
	
	/**
	 * Gets the tabbed pane selection foreground.
	 * @return the instance of Color
	 */
	public Color getTabbedPaneSelectionForeground()
	{
		return tabbedPaneSelectionForeground;
	}
	
	/**
	 * Gets the tabbed pane border line color.
	 * @return the instance of Color
	 */
	public Color getTabbedPaneBorderLineColor()
	{
		return tabbedPaneBorderLineColor;
	}
}