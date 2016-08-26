package com.nepxion.demo.component.outlookbar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import com.nepxion.demo.common.DemoComponentFactory;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.JBasicToggleButton;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.outlookbar.JFlatOutlook;
import com.nepxion.swing.outlookbar.JFlatOutlookBar;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.style.button.AbstractButtonUI;
import com.nepxion.swing.style.button.flat.FlatButtonUI;
import com.nepxion.swing.style.button.lite.JAcidLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JAlloyLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JBedouinLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JBlueLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JBorlandLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JEclipseLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JGlassLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JNimbusLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JYellowLiteButtonStyle;
import com.nepxion.swing.style.button.lite.LiteButtonUI;

public class DemoOutlookBarPanel
	extends JBasicScrollPane
{
	public DemoOutlookBarPanel()
	{		
		JPanel panel = new JPanel();
		panel.setLayout(new FiledLayout(FiledLayout.ROW, FiledLayout.FULL, 0));
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		panel.add(new OutlookBarPanel(new FlatButtonUI(), "JFlat Style"));
		panel.add(new OutlookBarPanel(new LiteButtonUI(new JAlloyLiteButtonStyle()), "JAlloy Style"));
		panel.add(new OutlookBarPanel(new LiteButtonUI(new JAcidLiteButtonStyle()), "JAcid Style"));
		panel.add(new OutlookBarPanel(new LiteButtonUI(new JBedouinLiteButtonStyle()), "JBedouin Style"));
		panel.add(new OutlookBarPanel(new LiteButtonUI(new JGlassLiteButtonStyle()), "JGlass Style"));
		panel.add(new OutlookBarPanel(new LiteButtonUI(new JEclipseLiteButtonStyle()), "JEclipse Style"));			
		panel.add(new OutlookBarPanel(new LiteButtonUI(new JBorlandLiteButtonStyle()), "JBorland Style"));		
		panel.add(new OutlookBarPanel(new LiteButtonUI(new JNimbusLiteButtonStyle()), "JNimbus Style"));		
		panel.add(new OutlookBarPanel(new LiteButtonUI(new JBlueLiteButtonStyle()), "JBlue Style"));
		panel.add(new OutlookBarPanel(new LiteButtonUI(new JYellowLiteButtonStyle()), "JYellow Style"));
		
		getViewport().add(panel);
	}
	
	public class OutlookBarPanel
		extends JPanel
	{
		public OutlookBarPanel(AbstractButtonUI buttonUI, String text)
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder(text));
			
			JFlatOutlookBar outlookBar = new JFlatOutlookBar();
			outlookBar.setPreferredSize(new Dimension(115, outlookBar.getPreferredSize().height));			
			
			// Mails Outlook
			JFlatOutlook mailOutlook = new JFlatOutlook();			
			ButtonGroup buttonGroup = new ButtonGroup();            
			JBasicToggleButton[] toggleButtons = {
				new JBasicToggleButton("Inbox", IconFactory.getIcon("com/l2fprod/common/demo/icons/outlook-inbox.gif"), "Inbox", true),
				new JBasicToggleButton("Outbox", IconFactory.getIcon("com/l2fprod/common/demo/icons/outlook-outbox.gif"), "Outbox"),
				new JBasicToggleButton("Drafts", IconFactory.getIcon("com/l2fprod/common/demo/icons/outlook-inbox.gif"), "Drafts"),
				new JBasicToggleButton("Templates", IconFactory.getIcon("com/l2fprod/common/demo/icons/outlook-inbox.gif"), "Templates"),
				new JBasicToggleButton("Deleted Items", IconFactory.getIcon("com/l2fprod/common/demo/icons/outlook-trash.gif"), "Deleted Items")
			}; 

			for (int i = 0; i < toggleButtons.length; i++)
			{
				toggleButtons[i].setUI(buttonUI);
				mailOutlook.addButton(toggleButtons[i]);
				buttonGroup.add(toggleButtons[i]);
			}
			outlookBar.addTab("Button", IconFactory.getSwingIcon("component/button_16.png"), outlookBar.makeScrollPane(mailOutlook), "Button Outlook");
			
			// Tree Outlook
			outlookBar.addTab("Tree", IconFactory.getSwingIcon("component/tree_16.png"), outlookBar.makeScrollPane(DemoComponentFactory.getTree()), "Tree Outlook");
			
			// Table Outlook
			outlookBar.addTab("Table", IconFactory.getSwingIcon("component/table_16.png"), outlookBar.makeScrollPane(DemoComponentFactory.getTable()), "Table Outlook");			
			add(outlookBar);
			
			// Table Outlook
			outlookBar.addTab("Disabled", new JPanel());			
			add(outlookBar);
			
			outlookBar.setEnabledAt(3, false);
			outlookBar.setAllTabsAlignment(JFlatOutlookBar.LEFT, 5);
		}
	}
}