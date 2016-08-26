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

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.nepxion.swing.dialog.JBasicDialog;
import com.nepxion.swing.fullscreen.JFullScreenDecorationPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.style.framework.JEclipseStyle;
import com.nepxion.swing.style.framework.StyleManager;

public class DemoFullScreenDialog
    extends JBasicDialog
{
    public DemoFullScreenDialog()
    {
        super(new JFrame(), "FullScreen Dialog", new Dimension(800, 600));

        JFullScreenDecorationPanel internalPanel = new JFullScreenDecorationPanel("标题栏风格，用于实现单个组件的全屏化", IconFactory.getContextIcon("apply.png"), "", true);
        internalPanel.setContentPane(new JLabel("ABCD"));

        getContentPane().add(internalPanel);
    }

    public static void main(String[] args)
    {
        LookAndFeelManager.setJGoodiesWindowsLookAndFeel();
        StyleManager.setStyle(JEclipseStyle.ID);
        new DemoFullScreenDialog().setVisible(true);
    }
}
