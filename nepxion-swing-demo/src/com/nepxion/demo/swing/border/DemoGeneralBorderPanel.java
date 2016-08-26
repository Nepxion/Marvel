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
import com.nepxion.swing.border.*;

public class DemoGeneralBorderPanel
    extends JPanel
{
    public DemoGeneralBorderPanel()
    {
        DemoOvalBorderPanel ovalBorderPanel = new DemoOvalBorderPanel();
        DemoButtonBorderPanel buttonBorderPanel1 = new DemoButtonBorderPanel(ButtonBorder.BORDER_RAISED);
        DemoButtonBorderPanel buttonBorderPanel2 = new DemoButtonBorderPanel(ButtonBorder.BORDER_LOWERED);
        DemoRaisedHeaderBorderPanel raisedHeaderBorderPanel = new DemoRaisedHeaderBorderPanel();
        DemoShadowBorderPanel shadowBorderPanel = new DemoShadowBorderPanel();
        DemoUnderlineBorderPanel underlineBorderPanel = new DemoUnderlineBorderPanel();

        double[][] size =
            {
            {TableLayout.FILL, TableLayout.FILL, TableLayout.FILL},
            {0.18, 0.18}
        };
        TableLayout tableLayout = new TableLayout(size);
        JPanel panel = new JPanel();
        panel.setLayout(tableLayout);
        panel.add(ovalBorderPanel, "0, 0");
        panel.add(buttonBorderPanel1, "1, 0");
        panel.add(buttonBorderPanel2, "2, 0");
        panel.add(raisedHeaderBorderPanel, "0, 1");
        panel.add(shadowBorderPanel, "1, 1");
        panel.add(underlineBorderPanel, "2, 1");

        JStatusBar statusBar = new JStatusBar();
        statusBar.addItem(new JStatusItem(new JLabel(" 各种样式的边界")), 400);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
    }
}
