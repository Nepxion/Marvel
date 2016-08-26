package com.nepxion.demo.swing.hint;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import com.nepxion.swing.hint.FileIntelliHint;
import com.nepxion.swing.hint.ListIntelliHint;
import com.nepxion.swing.layout.box.XBoxLayout;
import com.nepxion.swing.selector.JSelectAllUtil;
import com.nepxion.util.io.ZipUtil;

public class DemoHintPanel
    extends JScrollPane
{
    private String[] fontNames;
    private java.util.List urls;

    public DemoHintPanel()
    {
        fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        try
		{
			urls = ZipUtil.getZipFileList("url.txt.gz", false);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}


        JTextField fontTextField = new JTextField();
        JSelectAllUtil.install(fontTextField);
        ListIntelliHint listIntellihints = new ListIntelliHint(fontTextField, fontNames);
        listIntellihints.setCaseSensitive(false);

        JTextField urlTextField = new JTextField("http://");
        JSelectAllUtil.install(urlTextField);
        ListIntelliHint listIntelliHint = new ListIntelliHint(urlTextField, urls);
        listIntelliHint.setCaseSensitive(false);

        JTextField pathTextField = new JTextField();
        JSelectAllUtil.install(pathTextField);
        FileIntelliHint folderIntelliHint = new FileIntelliHint(pathTextField);
        folderIntelliHint.setFolderOnly(true);

        JTextField fileTextField = new JTextField();
        JSelectAllUtil.install(fileTextField);
        FileIntelliHint fileIntelliHint = new FileIntelliHint(fileTextField);

        JTextArea fileTextArea = new JTextArea();
        fileTextArea.setRows(4);
        FileIntelliHint fileIntelliHint1 = new FileIntelliHint(fileTextArea);

        DefaultTableModel model = new DefaultTableModel(0, 1)
        {
            public Class getColumnClass(int columnIndex)
            {
                return String.class;
            }

            public String getColumnName(int column)
            {
                return "Font";
            }
        };
        model.addRow(new Object[]
                     {"Arial"});
        model.addRow(new Object[]
                     {"Tahoma"});
        JTable table = new JTable(model);
        table.getColumnModel().getColumn(0).setCellEditor(new CustomerTableCellEditor());
        table.setPreferredScrollableViewportSize(new Dimension(100, 100));

        JPanel panel = new JPanel();
        panel.setLayout(new XBoxLayout(panel, XBoxLayout.Y_AXIS, 3));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("IntelliHints TextField to choose font name:"));
        panel.add(fontTextField);
        panel.add(Box.createVerticalStrut(6), XBoxLayout.FIX);

        panel.add(new JLabel("ListIntelliHint TextField for URLs: "));
        panel.add(urlTextField);
        panel.add(Box.createVerticalStrut(6), XBoxLayout.FIX);

        panel.add(new JLabel("FileIntelliHint TextField for path (folders only):"));
        panel.add(pathTextField);
        panel.add(Box.createVerticalStrut(6), XBoxLayout.FIX);

        panel.add(new JLabel("FileIntelliHint TextField for file (files and folders):"));
        panel.add(fileTextField);
        panel.add(Box.createVerticalStrut(6), XBoxLayout.FIX);

        panel.add(new JLabel("FileIntelliHint TextArea for files (each line is a new file):"));
        panel.add(new JScrollPane(fileTextArea));
        panel.add(Box.createVerticalStrut(6), XBoxLayout.FIX);

        panel.add(new JLabel("Using IntelliHint in JTable's cell editor"));
        panel.add(new JScrollPane(table), XBoxLayout.FLEXIBLE);

        panel.add(Box.createGlue(), XBoxLayout.VARY);

        getViewport().add(panel);
    }

    public class CustomerTableCellEditor
        extends AbstractCellEditor implements
        TableCellEditor
    {
        public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected,
            int row, int column)
        {
            JTextField cellEditorTextField = new JTextField();
            ListIntelliHint fontIntellihints = new ListIntelliHint(cellEditorTextField, fontNames);
            fontIntellihints.setCaseSensitive(false);
            return cellEditorTextField;
        }

        public Object getCellEditorValue()
        {
            return null;
        }
    }
}
