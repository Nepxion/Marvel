package com.nepxion.demo.swing.fullscreen;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.*;

import com.nepxion.swing.fullscreen.*;

public class DemoFullScreenApplet
    extends JFullScreenApplet
{
    public void init()
    {
        super.init();

        getWorkspace().setContentPane(new JButton("ABCD"));
    }
}
