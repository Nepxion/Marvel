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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.nepxion.swing.layout.table.*;
import com.nepxion.swing.statusbar.*;

public class DemoFrameWorkPanel
    extends JPanel
{
    public DemoFrameWorkPanel()
    {
        JButton frameWorkFrameButton = new JButton("FrameWork Frame");
        frameWorkFrameButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new DemoFrameWorkFrame().setVisible(true);
            }
        }
        );

        JButton frameWorkDialogButton = new JButton("FrameWork Dialog");
        frameWorkDialogButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new DemoFrameWorkDialog().setVisible(true);
            }
        }
        );

        double[][] size =
            {
            {0.35, 0.3, 0.35},
            {0.1, 0.06, 0.05, 0.06, TableLayout.FILL}
        };
        TableLayout tableLayout = new TableLayout(size);
        JPanel panel = new JPanel();
        panel.setLayout(tableLayout);
        panel.add(frameWorkFrameButton, "1, 1, 1, 1");
        panel.add(frameWorkDialogButton, "1, 3, 1, 3");

        JStatusBar statusBar = new JStatusBar();
        statusBar.addItem(new JStatusItem(new JLabel(" Java×ÀÃæ¿ò¼Ü")), 400);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
    }
}
