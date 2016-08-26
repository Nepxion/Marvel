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

import java.awt.Dimension;

import javax.swing.JLabel;

import com.nepxion.swing.frame.JBasicFrame;
import com.nepxion.swing.fullscreen.FullScreenRegister;
import com.nepxion.swing.fullscreen.FullScreenSupport;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.style.framework.JFervencyStyle;
import com.nepxion.swing.style.framework.StyleManager;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoFullScreenFrame
    extends JBasicFrame
{
    public DemoFullScreenFrame()
    {
        super("FullScreen Frame", IconFactory.getContextIcon("apply.png"), new Dimension(800, 600));

        JEclipseTabbedPane tabbedPane = new JEclipseTabbedPane();
        getContentPane().add(tabbedPane);


        tabbedPane.addTab("选项卡风格，用于实现多个组件的全屏化", IconFactory.getContextIcon("apply.png"), new JLabel("ABCD"));

        FullScreenSupport fullScreenSupport = new FullScreenSupport(tabbedPane);
        FullScreenRegister fullScreenRegister = new FullScreenRegister(fullScreenSupport);
        //fullScreenRegister.register(tabbedPane.getHeader());

        tabbedPane.addTab("选项卡风格，用于实现多个组件的全屏化", IconFactory.getContextIcon("apply.png"), new JLabel("ABCD"));
        tabbedPane.addTab("选项卡风格，用于实现多个组件的全屏化", IconFactory.getContextIcon("apply.png"), new JLabel("ABCD"));
        tabbedPane.addTab("选项卡风格，用于实现多个组件的全屏化", IconFactory.getContextIcon("apply.png"), new JLabel("ABCD"));
    }

    public static void main(String[] args)
    {
        LookAndFeelManager.setBedouinLookAndFeel();
        StyleManager.setStyle(JFervencyStyle.ID);
        new DemoFullScreenFrame().setVisible(true);
    }
}
