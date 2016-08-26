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

import com.l2fprod.common.swing.JTipOfTheDay;

public class JDayTip
	extends JTipOfTheDay
{
	/**
	 * Constructs with the default.
	 */
	public JDayTip()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial model.
	 * @param model the instance of TipModel
	 */
	public JDayTip(TipModel model)
	{
		super(model);
	}
}