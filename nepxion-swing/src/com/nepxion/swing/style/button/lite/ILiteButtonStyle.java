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
	public Color getRolloverBackground(); // ��������������ʱ�򣬰�ť�ı���ɫ
	
	/**
	 * Gets the roll over border color.
	 * @return the instance of Color
	 */
	public Color getRolloverBorderColor(); // ��������������ʱ�򣬰�ť�ı߽�ɫ
	
	/**
	 * Gets the selection background.
	 * @return the instance of Color
	 */
	public Color getSelectionBackground(); // ��갴�»��߰�ť��ѡȡ��ʱ�򣬰�ť�ı���ɫ
	
	/**
	 * Gets the selection border color.
	 * @return the instance of Color
	 */
	public Color getSelectionBorderColor(); // ��갴�»��߰�ť��ѡȡ��ʱ�򣬰�ť�ı߽�ɫ
	
	/**
	 * Gets the check color.
	 * @return the instance of Color
	 */
	public Color getCheckColor(); // ��ѡ����ɫ��ֻ������CheckBox��RadioButton
	
	/**
	 * Gets the check focus color.
	 * @return the instance of Color
	 */
	public Color getCheckFocusColor(); // ��������ɫ��ֻ������CheckBox��RadioButton
}