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
import com.nepxion.swing.panel.*;

public class DemoRadioBorderPanel
    extends JPanel
{
    public DemoRadioBorderPanel()
    {
        JRadioButton radioButton0 = new JRadioButton("colors", true);
        radioButton0.setRequestFocusEnabled(false);

        JRadioButton radioButton1 = new JRadioButton("sports", false);
        radioButton1.setRequestFocusEnabled(false);

        JRadioButton radioButton2 = new JRadioButton("food", false);
        radioButton2.setRequestFocusEnabled(false);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton0);
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);

        RadioPanel radioPanel0 = new RadioPanel(radioButton0, new String[]{"blue", "violet", "red", "yellow"});
        RadioPanel radioPanel1 = new RadioPanel(radioButton1, new String[]{"basketball", "soccer", "football", "hockey"});
        RadioPanel radioPanel2 = new RadioPanel(radioButton2, new String[]{"hot dogs", "pizza", "ravioli", "bananas"});

        double[][] size =
            {
            {0.33, 0.33, 0.33},
            {TableLayout.FILL}
        };
        TableLayout tableLayout = new TableLayout(size);
        setLayout(tableLayout);

        add(radioPanel0, "0, 0, 0, 0");
        add(radioPanel1, "1, 0, 1, 0");
        add(radioPanel2, "2, 0, 2, 0");
    }

    public class RadioPanel
        extends JComponentTitledBorderPanel
    {
        public RadioPanel(JRadioButton radioButton, String[] text)
        {
            super(radioButton, true);
            
            JButton btn1 = new JButton(text[0]);
            JButton btn2 = new JButton(text[1]);
            JButton btn3 = new JButton(text[2]);
            JButton btn4 = new JButton(text[3]);

            getContentPane().add(btn1);
            getContentPane().add(btn2);
            getContentPane().add(btn3);
            getContentPane().add(btn4);

            setContentPaneEnabled(radioButton.isSelected());
        }
    }
}
