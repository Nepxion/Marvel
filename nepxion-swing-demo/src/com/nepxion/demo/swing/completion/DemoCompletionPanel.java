package com.nepxion.demo.swing.completion;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitledBorder;
import com.nepxion.swing.combobox.JAutoCompletionComboBox;
import com.nepxion.swing.completion.JAutoCompletion;
import com.nepxion.swing.layout.box.XBoxLayout;
import com.nepxion.swing.searchable.JListSearchable;
import com.nepxion.swing.searchable.JSearchableFactory;
import com.nepxion.swing.searchable.JTreeSearchable;
import com.nepxion.swing.selector.JSelectAllUtil;

public class DemoCompletionPanel
    extends JScrollPane
{
    private String[] fontNames;
    private ArrayList fontList;

    public DemoCompletionPanel()
    {
        fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontList = new ArrayList();
        for (int i = 0; i < fontNames.length; i++)
        {
            String fontName = fontNames[i];
            fontList.add(fontName);
        }

        JPanel panel1 = createPanel1();
        JPanel panel2 = createPanel2();

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(6, 6));
        panel.add(panel1, BorderLayout.BEFORE_FIRST_LINE);
        panel.add(panel2);

        getViewport().add(panel);
    }

    private JPanel createPanel1()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new XBoxLayout(panel, XBoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createCompoundBorder(new ComplexTitledBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "AutoCompletion combo box and text field", ComplexTitledBorder.LEADING, ComplexTitledBorder.ABOVE_TOP), BorderFactory.createEmptyBorder(0, 0, 0, 0)));

        JComboBox autoCompletionComboBox = new JAutoCompletionComboBox(fontNames);
        autoCompletionComboBox.setToolTipText("AutoCompletion JComboBox (Strict)");
        panel.add(new JLabel("AutoCompletion JComboBox (Strict)"));
        panel.add(Box.createVerticalStrut(3), XBoxLayout.FIX);
        panel.add(autoCompletionComboBox);
        panel.add(Box.createVerticalStrut(12), XBoxLayout.FIX);

        JAutoCompletionComboBox autoCompletionComboBoxNotStrict = new JAutoCompletionComboBox(fontNames);
        autoCompletionComboBoxNotStrict.setStrict(false);
        autoCompletionComboBoxNotStrict.setToolTipText("AutoCompletion JComboBox (Not strict)");
        panel.add(new JLabel("AutoCompletion JComboBox (Not strict)"));
        panel.add(Box.createVerticalStrut(3), XBoxLayout.FIX);
        panel.add(autoCompletionComboBoxNotStrict);
        panel.add(Box.createVerticalStrut(12), XBoxLayout.FIX);

        final JTextField textField = new JTextField();
        JSelectAllUtil.install(textField);
        new JAutoCompletion(textField, fontList);
        panel.add(new JLabel("AutoCompletion JTextField with a hidden data"));
        panel.add(Box.createVerticalStrut(3), XBoxLayout.FIX);
        panel.add(textField);
        panel.add(Box.createVerticalStrut(12), XBoxLayout.FIX);

        return panel;
    }

    private JPanel createPanel2()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new XBoxLayout(panel, XBoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createCompoundBorder(new ComplexTitledBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "AutoCompletion with list and tree", ComplexTitledBorder.LEADING, ComplexTitledBorder.ABOVE_TOP), BorderFactory.createEmptyBorder(0, 0, 0, 0)));

        JTextField treeTextField = new JTextField();
        JSelectAllUtil.install(treeTextField);
        JTree tree = new JTree();
        tree.setVisibleRowCount(10);
        JTreeSearchable treeSearchable = JSearchableFactory.installSearchable(tree);
        new JAutoCompletion(treeTextField, treeSearchable);
        panel.add(new JLabel("AutoCompletion JTextField with JTree"));
        panel.add(Box.createVerticalStrut(3), XBoxLayout.FIX);
        panel.add(treeTextField);
        panel.add(Box.createVerticalStrut(2), XBoxLayout.FIX);
        panel.add(new JScrollPane(tree));
        panel.add(Box.createVerticalStrut(12), XBoxLayout.FIX);

        final JTextField fontNameTextField = new JTextField();
        JSelectAllUtil.install(fontNameTextField);
        final JList fontNameList = new JList(fontNames);
        fontNameList.setVisibleRowCount(10);
        JListSearchable listSearchable = JSearchableFactory.installSearchable(fontNameList);
        new JAutoCompletion(fontNameTextField, listSearchable);
        panel.add(new JLabel("AutoCompletion JTextField with JList"));
        panel.add(Box.createVerticalStrut(3), XBoxLayout.FIX);
        panel.add(fontNameTextField);
        panel.add(Box.createVerticalStrut(2), XBoxLayout.FIX);
        panel.add(new JScrollPane(fontNameList));
        panel.add(Box.createVerticalStrut(12), XBoxLayout.FIX);

        return panel;
    }
}
