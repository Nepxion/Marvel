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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.nepxion.swing.layout.table.*;
import com.nepxion.swing.statusbar.*;

public class DemoFullScreenPanel
    extends JPanel
{
    public DemoFullScreenPanel()
    {
        JButton fullScreenFrameButton = new JButton("FullScreen Frame");
        fullScreenFrameButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new DemoFullScreenFrame().setVisible(true);
            }
        }
        );

        JButton fullScreenDialogButton = new JButton("FullScreen Dialog");
        fullScreenDialogButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new DemoFullScreenDialog().setVisible(true);
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
        panel.add(fullScreenFrameButton, "1, 1, 1, 1");
        panel.add(fullScreenDialogButton, "1, 3, 1, 3");

        JStatusBar statusBar = new JStatusBar();
        statusBar.addItem(new JStatusItem(new JLabel(" È«ÆÁ×é¼þ")), 400);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
    }
}
