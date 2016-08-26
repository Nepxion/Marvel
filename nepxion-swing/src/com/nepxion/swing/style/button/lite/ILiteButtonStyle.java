package com.nepxion.swing.style.button.lite;

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

import com.nepxion.swing.style.button.IButtonStyle;

public interface ILiteButtonStyle
	extends IButtonStyle
{
	/**
	 * Gets the roll over background.
	 * @return the instance of Color
	 */
	public Color getRolloverBackground(); // 鼠标悬浮在上面的时候，按钮的背景色
	
	/**
	 * Gets the roll over border color.
	 * @return the instance of Color
	 */
	public Color getRolloverBorderColor(); // 鼠标悬浮在上面的时候，按钮的边界色
	
	/**
	 * Gets the selection background.
	 * @return the instance of Color
	 */
	public Color getSelectionBackground(); // 鼠标按下或者按钮被选取的时候，按钮的背景色
	
	/**
	 * Gets the selection border color.
	 * @return the instance of Color
	 */
	public Color getSelectionBorderColor(); // 鼠标按下或者按钮被选取的时候，按钮的边界色
	
	/**
	 * Gets the check color.
	 * @return the instance of Color
	 */
	public Color getCheckColor(); // 勾选的颜色，只适用于CheckBox和RadioButton
	
	/**
	 * Gets the check focus color.
	 * @return the instance of Color
	 */
	public Color getCheckFocusColor(); // 焦点框的颜色，只适用于CheckBox和RadioButton
}