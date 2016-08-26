package com.nepxion.demo.component.splash;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.splash.JSplashWindow;

public class DemoSplashWindow
	extends JSplashWindow
{	
	public DemoSplashWindow()
	{
        super(IconFactory.getSwingIcon("splash.png"));
    }
}