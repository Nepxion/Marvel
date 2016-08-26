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
import javax.swing.border.*;

import com.nepxion.swing.border.*;
import com.nepxion.swing.layout.box.*;

public class DemoTitleBorderPanel
    extends JPanel
{
    public DemoTitleBorderPanel()
    {
        setLayout(new XBoxLayout(this, XBoxLayout.Y_AXIS, 10));

        JTextArea textField = new JTextArea();
        JPanel border = new JPanel(new BorderLayout());
        border.setPreferredSize(new Dimension(300, 100));
        border.add(new JScrollPane(textField), BorderLayout.CENTER);
        border.setBorder(BorderManager.createComplexTitledBorder("ComplexEtchedBorder"));

        JTextArea textField2 = new JTextArea();
        JPanel border2 = new JPanel(new BorderLayout());
        border2.setPreferredSize(new Dimension(300, 100));
        border2.add(new JScrollPane(textField2), BorderLayout.CENTER);
        border2.setBorder(new ComplexTitledBorder(new ComplexLineBorder(Color.darkGray, 1, ComplexSide.NORTH), "ComplexLineBorder"));

        JTextArea textField3 = new JTextArea();
        JPanel border3 = new JPanel(new BorderLayout());
        border3.setPreferredSize(new Dimension(300, 100));
        border3.add(new JScrollPane(textField3), BorderLayout.CENTER);
        border3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(
            new ComplexLineBorder(Color.gray, 1, true), "Rounded Corners Border",
            TitledBorder.TRAILING, TitledBorder.ABOVE_TOP), BorderFactory.createEmptyBorder(6, 4, 4, 4)));

        JTextArea textField4 = new JTextArea();
        JPanel border4 = new JPanel(new BorderLayout());
        border4.setPreferredSize(new Dimension(400, 100));
        border4.add(new JScrollPane(textField4), BorderLayout.CENTER);
        border4.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(
            new ComplexGradientLineBorder(new Color[]
                                          {new Color(0, 0, 128), Color.red}, 2, ComplexSide.NORTH), "Gradient Border",
            TitledBorder.CENTER, TitledBorder.ABOVE_TOP), BorderFactory.createEmptyBorder(6, 4, 4, 4)));

        add(border, XBoxLayout.FLEXIBLE);
        add(Box.createVerticalStrut(12));
        add(border2, XBoxLayout.FLEXIBLE);
        add(Box.createVerticalStrut(12));
        add(border3, XBoxLayout.FLEXIBLE);
        add(Box.createVerticalStrut(12));
        add(border4, XBoxLayout.FLEXIBLE);
        add(Box.createGlue(), XBoxLayout.VARY);

    }
}
