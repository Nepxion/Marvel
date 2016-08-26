package com.nepxion.demo.swing.selector;

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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.dialog.JBasicDialog;
import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.selector.checkbox.JCheckBoxSelector;
import com.nepxion.swing.selector.color.JColorSelector;
import com.nepxion.swing.selector.dropdown.IDropDownPopupMenu;
import com.nepxion.swing.selector.dropdown.JDropDownPane;
import com.nepxion.swing.selector.dropdown.JDropDownPopupMenu;
import com.nepxion.swing.selector.dropdown.JDropDownSelector;
import com.nepxion.swing.selector.file.JFileFilter;
import com.nepxion.swing.selector.file.JFileSelector;
import com.nepxion.swing.selector.file.JFolderSelector;
import com.nepxion.swing.selector.locale.JLocaleSelector;
import com.nepxion.swing.selector.radiobutton.JRadioButtonSelector;
import com.nepxion.swing.statusbar.JStatusBar;
import com.nepxion.swing.statusbar.JStatusItem;

//锦绣花木

public class DemoCommonSelectorPanel
    extends JPanel
{
    public DemoCommonSelectorPanel()
    {
        JButton componentCheckSelectorButton = new JButton("Component Check Selector");
        componentCheckSelectorButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
//                ElementNode elementNode1 = new ElementNode("hot dogs", IconFactory.getContextIcon("apply.png"), "", false);
//                ElementNode elementNode2 = new ElementNode("pizza", IconFactory.getContextIcon("apply.png"), "", false);
//                ElementNode elementNode3 = new ElementNode("ravioli", IconFactory.getContextIcon("display.png"), "", false);
//                ElementNode elementNode4 = new ElementNode("bananas", IconFactory.getContextIcon("display.png"), "", false);

                List elementNodes = new ArrayList();
//                elementNodes.add(elementNode1);
//                elementNodes.add(elementNode2);
//                elementNodes.add(elementNode3);
//                elementNodes.add(elementNode4);

                JCheckBoxSelector componentCheckSelector = new JCheckBoxSelector(Frame.getFrames()[0], "选择", elementNodes);
                componentCheckSelector.setVisible(true);
                JBasicOptionPane.showMessageDialog(Frame.getFrames()[0], componentCheckSelector.getSelectedElementNodes(), "信息", JBasicOptionPane.INFORMATION_MESSAGE);
            }
        }
        );

        JButton componentRadioSelectorButton = new JButton("Component Radio Selector");
        componentRadioSelectorButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
//                ElementNode elementNode1 = new ElementNode("hot dogs", IconFactory.getContextIcon("apply.png"), "", false);
//                ElementNode elementNode2 = new ElementNode("pizza", IconFactory.getContextIcon("apply.png"), "", false);
//                ElementNode elementNode3 = new ElementNode("ravioli", IconFactory.getContextIcon("display.png"), "", false);
//                ElementNode elementNode4 = new ElementNode("bananas", IconFactory.getContextIcon("display.png"), "", false);

                List elementNodes = new ArrayList();
//                elementNodes.add(elementNode1);
//                elementNodes.add(elementNode2);
//                elementNodes.add(elementNode3);
//                elementNodes.add(elementNode4);

                JRadioButtonSelector componentRadioSelector = new JRadioButtonSelector(Frame.getFrames()[0], "选择", elementNodes);
                componentRadioSelector.setVisible(true);
                JBasicOptionPane.showMessageDialog(Frame.getFrames()[0], componentRadioSelector.getSelectedElementNode(), "信息", JBasicOptionPane.INFORMATION_MESSAGE);
            }
        }
        );

        JButton folderSelectorButton = new JButton("Folder Selector");
        folderSelectorButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JFolderSelector folderChooser = new JFolderSelector();
                ArrayList recentList = new ArrayList();
                File currentFolder = folderChooser.getFileSystemView().createFileObject("D:/");
                folderChooser.setCurrentDirectory(currentFolder);
                folderChooser.setRecentList(recentList);
                folderChooser.setFileHidingEnabled(true);

                int result = folderChooser.showOpenDialog(Frame.getFrames()[0]);
                if (result == JFolderSelector.APPROVE_OPTION)
                {
                    currentFolder = folderChooser.getSelectedFile();
                    recentList.add(currentFolder);
                    File selectedFile = folderChooser.getSelectedFile();
                    JBasicOptionPane.showMessageDialog(Frame.getFrames()[0], selectedFile.toString(), "信息", JBasicOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        );

        JButton fileSelectorButton = new JButton("File Selector");
        fileSelectorButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	List filterWords = new ArrayList(Arrays.asList(new String[]{"pdf"}));
                String filterDescription = "PDF文档(*.pdf)";
                JFileFilter fileFilter = new JFileFilter(filterWords, filterDescription);                
                JFileSelector fileSelector = new JFileSelector(Frame.getFrames()[0], "导出PDF文档");
                fileSelector.openDirectory();
//                File file = fileSelector.openFile();
//                if (file != null)
//                {
//                    JBasicOptionPane.showMessageDialog(Frame.getFrames()[0], file.getAbsolutePath(), "信息", JBasicOptionPane.INFORMATION_MESSAGE);
//                }
            }
        }
        );

        JButton dropDownSelectorButton = new JButton("DropDown Selector");
        dropDownSelectorButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
//                JColorSelector colorSelector = new JColorSelector(Frame.getFrames()[0]);
//
//                JDropDownPopupMenu dropDownPopupMenu = new JDropDownPopupMenu();
//                DropDownPane dropDownPane = new DropDownPane(dropDownPopupMenu, (JPanel) colorSelector.getContentPane().getComponent(0));
//                JDropDownSelector dropDownSelector = new JDropDownSelector(dropDownPane);
//
//                JBasicDialog dialog = new JBasicDialog(Frame.getFrames()[0], "DropDown Selector", new Dimension(300, 60));
//                dialog.getContentPane().add(dropDownSelector);
//                dialog.setVisible(true);
            }
        }
        );

        JButton colorSelectorButton = new JButton("Color Selector");
        colorSelectorButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
//                JColorSelector colorSelector = new JColorSelector(Frame.getFrames()[0]);
//                colorSelector.setVisible(true);
//                JBasicOptionPane.showMessageDialog(Frame.getFrames()[0], colorSelector.getColorPane().getColor(), "信息", JBasicOptionPane.INFORMATION_MESSAGE);
            }
        }
        );

        JButton localeSelectorButton = new JButton("Locale Selector");
        localeSelectorButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JBasicDialog dialog = new JBasicDialog(Frame.getFrames()[0], "Locale Selector", new Dimension(300, 60));
                dialog.getContentPane().add(new JLocaleSelector());
                dialog.setVisible(true);
            }
        }
        );

        double[][] size =
            {
            {0.35, 0.3, 0.35},
            {TableLayout.FILL, 0.06, 0.05, 0.06, 0.05, 0.06, 0.05, 0.06, 0.05, 0.06, 0.05, 0.06, 0.05, 0.06, TableLayout.FILL}
        };
        TableLayout tableLayout = new TableLayout(size);
        JPanel panel = new JPanel();
        panel.setLayout(tableLayout);
        panel.add(componentCheckSelectorButton, "1, 1, 1, 1");
        panel.add(componentRadioSelectorButton, "1, 3, 1, 3");
        panel.add(folderSelectorButton, "1, 5, 1, 5");
        panel.add(fileSelectorButton, "1, 7, 1, 7");
        panel.add(dropDownSelectorButton, "1, 9, 1, 9");
        panel.add(colorSelectorButton, "1, 11, 1, 11");
        panel.add(localeSelectorButton, "1, 13, 1, 13");

        JStatusBar statusBar = new JStatusBar();
        statusBar.addItem(new JStatusItem(new JLabel(" 多种用途的选择器")), 400);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
    }

    public class DropDownPane
        extends JDropDownPane
    {
        public DropDownPane(IDropDownPopupMenu popupMenu, Component contentPane)
        {
            super(popupMenu, contentPane);
        }

        public boolean confirm()
        {
            return true;
        }

        public boolean cancel()
        {
            return true;
        }
    }
}
