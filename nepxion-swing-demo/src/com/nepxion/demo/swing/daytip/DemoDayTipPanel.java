package com.nepxion.demo.swing.daytip;

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
import com.nepxion.swing.optionpane.*;
import com.nepxion.swing.daytip.*;
import com.nepxion.swing.statusbar.*;
import com.nepxion.swing.icon.*;
import com.nepxion.swing.lookandfeel.*;

public class DemoDayTipPanel
    extends JPanel
{
    public DemoDayTipPanel()
    {
        LookAndFeelManager.addonWindowsLookAndFeel();

        final JDayTip.ShowOnStartupChoice choise = new JDayTip.ShowOnStartupChoice()
        {
            private boolean value = true;

            public boolean isShowingOnStartup()
            {
                return value;
            }

            public void setShowingOnStartup(boolean showOnStartup)
            {
                value = showOnStartup;
            }
        };

        TipModel tips = new TipModel();
        tips.add(new JTip(
            "Tip1",
            "Common Tip"));
        tips.add(new JTip("Tip2",
                          "<html>Html <b>Tip</b><br><center>"
                          + "<table border=\"1\">"
                          + "<tr><td>1</td><td>entry 1</td></tr>"
                          + "<tr><td>2</td><td>entry 2</td></tr>"
                          + "<tr><td>3</td><td>entry 3</td></tr>" + "</table>"));
        tips.add(new JTip("Tip3", new JTree()));
        tips.add(new JTip("Tip4", IconFactory.getContextIcon("apply.png")));

        final JDayTip dayTip = new JDayTip(tips);
        dayTip.setCurrentTip(0);

        JButton optionButton = new JButton("Tip Of The Day");
        optionButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (!choise.isShowingOnStartup())
                {
                    int selectedValue = JBasicOptionPane.showConfirmDialog(Frame.getFrames()[0], "系统禁止在启动时出现“每日提示”，是否要撤销该禁止？", "确认", JBasicOptionPane.YES_NO_OPTION);
                    if (selectedValue != JBasicOptionPane.YES_OPTION)
                    {
                        return;
                    }
                    choise.setShowingOnStartup(true);
                }

                dayTip.showDialog(Frame.getFrames()[0], choise);
            }
        }
        );

        double[][] size =
            {
            {0.35, 0.3, 0.35},
            {0.1, 0.06}
        };
        TableLayout tableLayout = new TableLayout(size);
        JPanel panel = new JPanel();
        panel.setLayout(tableLayout);
        panel.add(optionButton, "1, 1, 1, 1");

        JStatusBar statusBar = new JStatusBar();
        statusBar.addItem(new JStatusItem(new JLabel(" 每日提醒")), 400);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
    }
}
