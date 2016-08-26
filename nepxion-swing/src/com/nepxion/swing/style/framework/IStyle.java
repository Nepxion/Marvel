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
	public Color getGradientColor(); // ���俪ʼ����ɫ
	
	/**
	 * Gets the selection gradient color.
	 * @return the instance of Color
	 */
	public Color getSelectionGradientColor(); // ѡ�н��俪ʼ����ɫ
	
	/**
	 * Gets the foreground.
	 * @return the instance of Color
	 */
	public Color getForeground(); // ǰ��ɫ����ǩ������ɫ
	
	/**
	 * Gets the selection foreground.
	 * @return the instance of Color
	 */
	public Color getSelectionForeground(); // ѡ��ǰ��ɫ����ǩ������ɫ
	
	/**
	 * Gets the background.
	 * @return the instance of Color
	 */
	public Color getBackground(); // ����ɫ�������������ɫ
	
	/**
	 * Gets the selection background.
	 * @return the instance of Color
	 */
	public Color getSelectionBackground(); // ѡ�б���ɫ�������������ɫ
	
	/**
	 * Gets the border.
	 * @return the instance of Border.
	 */
	public Border getBorder(); // ��ܱ߽�
	
	/**
	 * Gets the header border.
	 * @return the instance of Border
	 */
	public Border getHeaderBorder(); // ���ͷ���߽�
	
	/**
	 * Gets the title border.
	 * @return the instance of Border
	 */
	public Border getTitleBorder(); // ��ܱ������߽�
	
	/**
	 * Gets the tabbed pane gradient color.
	 * @return the instance of Color
	 */
	public Color getTabbedPaneGradientColor(); // ѡ����俪ʼ����ɫ
	
	/**
	 * Gets the tabbed pane background.
	 * @return the instance of Color
	 */
	public Color getTabbedPaneBackground(); // ѡ������������ɫ, ����ɫ
	
	/**
	 * Gets the tabbed pane foreground.
	 * @return the instance of Color
	 */
	public Color getTabbedPaneForeground(); // ѡ�ǰ��ɫ����ǩ������ɫ
	
	/**
	 * Gets the tabbed pane selection foreground.
	 * @return the instance of Color
	 */
	public Color getTabbedPaneSelectionForeground(); // ѡ��ѡ�ǰ��ɫ����ǩ������ɫ
	
	/**
	 * Gets the tabbed pane border line color.
	 * @return the instance of Color
	 */
	public Color getTabbedPaneBorderLineColor(); // ѡ�������ɫ
}