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

import java.awt.Dimension;

import com.nepxion.swing.framework.JFrameWorkFrame;
import com.nepxion.swing.framework.dockable.JDockableHierarchy;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.style.framework.JFervencyStyle;
import com.nepxion.swing.style.framework.StyleManager;

public class DemoFrameWorkFrame
    extends JFrameWorkFrame
{
    public DemoFrameWorkFrame()
    {
        super("FrameWork Frame", IconFactory.getContextIcon("apply.png"), new Dimension(800, 600));
        
        DemoFrameWorkInitializer frameWorkInitializer = new DemoFrameWorkInitializer((JDockableHierarchy) getHierarchy());
        frameWorkInitializer.initializer();
    }

    public static void main(String[] args)
    {
//        LookAndFeelManager.setPlasticXPLookAndFeel();
//        StyleManager.setStyle(JInternalEclipseStyle.ID);

//        LookAndFeelManager.setBedouinThemeAlloyLookAndFeel();
//        StyleManager.setStyle(JInternalLiteStyle.ID);

        LookAndFeelManager.setMetalLookAndFeel();
//        StyleManager.setStyle(JInternalLiteStyle.ID);
        StyleManager.setStyle(JFervencyStyle.ID);

        new DemoFrameWorkFrame().setVisible(true);
    }
}
