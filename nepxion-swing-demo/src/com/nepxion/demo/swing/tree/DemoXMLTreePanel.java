package com.nepxion.demo.swing.tree;

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
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.selector.file.JFileFilter;
import com.nepxion.swing.selector.file.JFileSelector;
import com.nepxion.swing.statusbar.JStatusBar;
import com.nepxion.swing.statusbar.JStatusItem;
import com.nepxion.swing.textfield.JBasicTextField;

public class DemoXMLTreePanel
    extends JPanel
{
    private JBasicTextField filePathTextField;
//    private JXMLTree xmlTree;
    private JFileSelector fileSelector;

    public DemoXMLTreePanel()
    {
        JLabel filePathLabel = new JLabel("文件路径");
        filePathLabel.setPreferredSize(new Dimension(50, 24));

        filePathTextField = new JBasicTextField();
        filePathTextField.setEditable(false);

        JButton filePathChooserButton = new JButton(IconFactory.getContextIcon("search.png"));
        filePathChooserButton.setPreferredSize(new Dimension(25, 25));
        filePathChooserButton.addActionListener(new ChooseFilePathAction());

        JPanel filePathPanel = new JPanel();
        filePathPanel.setLayout(new BoxLayout(filePathPanel, BoxLayout.X_AXIS));
        filePathPanel.add(Box.createHorizontalStrut(1));
        filePathPanel.add(filePathLabel);
        filePathPanel.add(Box.createHorizontalStrut(1));
        filePathPanel.add(filePathTextField);
        filePathPanel.add(Box.createHorizontalStrut(1));
        filePathPanel.add(filePathChooserButton);
        filePathPanel.add(Box.createHorizontalStrut(1));

//        xmlTree = new JXMLTree();
//        JScrollPane xmlTreeScrollPane = new JScrollPane();
//        xmlTreeScrollPane.getViewport().add(xmlTree);

        JStatusBar statusBar = new JStatusBar();
        statusBar.addItem(new JStatusItem(new JLabel(" 把XML文件解析成JTree样式")), 400);

        setLayout(new BorderLayout());
        add(filePathPanel, BorderLayout.NORTH);
//        add(xmlTreeScrollPane, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
    }

    public class ChooseFilePathAction
        implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        	List filterWords = new ArrayList(Arrays.asList(new String[] {"xml"}));
            String filterDescription = "文档(*.xml)";
            JFileFilter fileFilter = new JFileFilter(filterWords, filterDescription);              
            if (fileSelector == null)
            {
                fileSelector = new JFileSelector(Frame.getFrames()[0], "选择XML文件");
            }
            File file = fileSelector.openFile();
            if (file == null)
            {
                return;
            }
            filePathTextField.setText(file.getAbsolutePath());
//            xmlTree.loadByFilePath(file.getAbsolutePath());
        }
    }
}
