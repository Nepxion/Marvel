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

import com.nepxion.swing.panel.*;

public class DemoCheckBoxBorderPanel
    extends JPanel
{
    public DemoCheckBoxBorderPanel()
    {
        JCheckBox checkBox = new JCheckBox("food", false);
        checkBox.setRequestFocusEnabled(false);

        CheckPanel checkPanel = new CheckPanel(checkBox);

        setLayout(new BorderLayout());
        add(checkPanel);
    }

    public class CheckPanel
        extends JComponentTitledBorderPanel
    {
        public CheckPanel(JCheckBox checkBox)
        {
            super(checkBox, true);
            
            JButton btn1 = new JButton("hot dogs");
            JButton btn2 = new JButton("pizza");
            JButton btn3 = new JButton("ravioli");
            JButton btn4 = new JButton("bananas");

            getContentPane().add(btn1);
            getContentPane().add(btn2);
            getContentPane().add(btn3);
            getContentPane().add(btn4);

            setContentPaneEnabled(checkBox.isSelected());
        }
    }
}
