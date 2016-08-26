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

import javax.swing.JComponent;

import com.nepxion.swing.color.ColorUtil;

public class UnderlineBorderDecoration
{
	/**
	 * Constructs with the specified initial component.
	 * @param component the instance of JComponent
	 */
	public UnderlineBorderDecoration(JComponent component)
	{
		component.setBorder(new UnderlineBorder());
		component.setBackground(ColorUtil.getUIManagerColor("Panel.background"));
	}
}