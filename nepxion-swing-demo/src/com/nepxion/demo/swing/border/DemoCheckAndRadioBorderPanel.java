package com.nepxion.demo.swing.border;

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
import javax.swing.*;

import com.nepxion.swing.layout.table.*;
import com.nepxion.swing.statusbar.*;

public class DemoCheckAndRadioBorderPanel
    extends JPanel
{
    public DemoCheckAndRadioBorderPanel()
    {
        DemoCheckBoxBorderPanel checkBoxBorderPanel = new DemoCheckBoxBorderPanel();
        DemoRadioBorderPanel radioBorderPanel = new DemoRadioBorderPanel();

        double[][] size =
            {
            {TableLayout.FILL},
            {0.2, 0.4}
        };
        TableLayout tableLayout = new TableLayout(size);
        JPanel panel = new JPanel();
        panel.setLayout(tableLayout);
        panel.add(checkBoxBorderPanel, "0, 0");
        panel.add(radioBorderPanel, "0, 1");

        JStatusBar statusBar = new JStatusBar();
        statusBar.addItem(new JStatusItem(new JLabel(" Check & Radio Border")), 400);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
    }
}
