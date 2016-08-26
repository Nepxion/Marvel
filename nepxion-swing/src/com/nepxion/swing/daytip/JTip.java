package com.nepxion.swing.daytip;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.l2fprod.common.swing.tips.DefaultTip;

public class JTip
	extends DefaultTip
{
	/**
	 * Constructs with the default.
	 */
	public JTip()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial name and tip.
	 * @param name the name string
	 * @param tip the tip object
	 */
	public JTip(String name, Object tip)
	{
		super(name, tip);
	}
}