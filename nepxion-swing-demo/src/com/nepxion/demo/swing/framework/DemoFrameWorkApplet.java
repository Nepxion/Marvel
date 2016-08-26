package com.nepxion.demo.swing.framework;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.swing.framework.JFrameWorkApplet;
import com.nepxion.swing.framework.dockable.JDockableHierarchy;

public class DemoFrameWorkApplet
    extends JFrameWorkApplet
{
    public void init()
    {
        super.init();
        
        DemoFrameWorkInitializer frameWorkInitializer = new DemoFrameWorkInitializer((JDockableHierarchy) getHierarchy());
        frameWorkInitializer.initializer();
    }
}
