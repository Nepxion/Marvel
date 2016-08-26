package com.nepxion.swing.framework.ribbon;

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

import javax.swing.UIManager;

public class RibbonContextInitializer
{
	public void initialize()
	{
		// UIManager.put("nimbusBlueGrey", ColorUtil.getDerivedColor(new Color(169, 176, 190)));
		UIManager.put("control", new Color(212, 226, 242));
	}
}