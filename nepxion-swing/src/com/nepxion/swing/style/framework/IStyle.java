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

public interface IStyle
{
	/**
	 * Gets the gradient color.
	 * @return the instance of Color
	 */
	public Color getGradientColor(); // 渐变开始的颜色
	
	/**
	 * Gets the selection gradient color.
	 * @return the instance of Color
	 */
	public Color getSelectionGradientColor(); // 选中渐变开始的颜色
	
	/**
	 * Gets the foreground.
	 * @return the instance of Color
	 */
	public Color getForeground(); // 前景色，标签文字颜色
	
	/**
	 * Gets the selection foreground.
	 * @return the instance of Color
	 */
	public Color getSelectionForeground(); // 选中前景色，标签文字颜色
	
	/**
	 * Gets the background.
	 * @return the instance of Color
	 */
	public Color getBackground(); // 背景色，渐变结束的颜色
	
	/**
	 * Gets the selection background.
	 * @return the instance of Color
	 */
	public Color getSelectionBackground(); // 选中背景色，渐变结束的颜色
	
	/**
	 * Gets the border.
	 * @return the instance of Border.
	 */
	public Border getBorder(); // 框架边界
	
	/**
	 * Gets the header border.
	 * @return the instance of Border
	 */
	public Border getHeaderBorder(); // 框架头部边界
	
	/**
	 * Gets the title border.
	 * @return the instance of Border
	 */
	public Border getTitleBorder(); // 框架标题栏边界
	
	/**
	 * Gets the tabbed pane gradient color.
	 * @return the instance of Color
	 */
	public Color getTabbedPaneGradientColor(); // 选项卡渐变开始的颜色
	
	/**
	 * Gets the tabbed pane background.
	 * @return the instance of Color
	 */
	public Color getTabbedPaneBackground(); // 选项卡渐变结束的颜色, 背景色
	
	/**
	 * Gets the tabbed pane foreground.
	 * @return the instance of Color
	 */
	public Color getTabbedPaneForeground(); // 选项卡前景色，标签文字颜色
	
	/**
	 * Gets the tabbed pane selection foreground.
	 * @return the instance of Color
	 */
	public Color getTabbedPaneSelectionForeground(); // 选中选项卡前景色，标签文字颜色
	
	/**
	 * Gets the tabbed pane border line color.
	 * @return the instance of Color
	 */
	public Color getTabbedPaneBorderLineColor(); // 选项卡线条颜色
}