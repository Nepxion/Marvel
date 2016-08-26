package com.nepxion.swing.tabbedpane;

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
import java.util.List;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.JTabbedPane;

import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.selector.checkbox.JCheckBoxSelector;

public class TabbedPaneManager
{
	/**
	 * Sets the preference style for the tabbed pane.
	 * @param tabbedPane the instance of JTabbedPane
	 */
	public static void setPreferenceStyle(JTabbedPane tabbedPane)
	{
		tabbedPane.setFocusable(false);
		
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{	
			if (tabbedPane instanceof JBasicTabbedPane)
			{
				JBasicTabbedPane basicTabbedPane = (JBasicTabbedPane) tabbedPane;
				basicTabbedPane.setDrawBorder(false);
				basicTabbedPane.setDrawCenter(false);
			}
		}
	}
	
	/**
	 * Shows the close dialog.
	 * @param tabbedPane the instance of ITabbedPane
	 * @param checkBoxSelector the instance of JCheckBoxSelector
	 */
	public static void showCloseDialog(ITabbedPane tabbedPane, JCheckBoxSelector checkBoxSelector)
	{
		if (tabbedPane == null)
		{
			return;
		}
		
		Vector selectionElementNodes = new Vector();
		for (int i = 0; i < tabbedPane.getTabCount(); i++)
		{
			if (tabbedPane.isTabClosableAt(i))
			{
				String title = tabbedPane.getTitleAt(i);
				String toolTipText = tabbedPane.getToolTipTextAt(i);
				Icon icon = tabbedPane.getIcon(i);
				Component component = tabbedPane.getComponentAt(i);
				IElementNode elementNode = new ElementNode(title, title, icon, toolTipText, component);
				selectionElementNodes.add(elementNode);
			}
		}
		
		if (selectionElementNodes.size() == 0)
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame((Component) tabbedPane), SwingLocale.getString("no_close_item"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return;
		}	
		
		if (checkBoxSelector == null)
		{
			checkBoxSelector = new JCheckBoxSelector(HandleManager.getFrame((Component) tabbedPane), SwingLocale.getString("select_close"));
		}
		checkBoxSelector.getCheckBoxList().setListData(selectionElementNodes);
		checkBoxSelector.setVisible(true);
		checkBoxSelector.dispose();
		
		if (checkBoxSelector.isConfirmed())
		{
			List selectedComponents = checkBoxSelector.getSelectedUserObjects();
			if (selectedComponents != null)
			{
				tabbedPane.removeTabs(selectedComponents);
			}
		}
	}
	
	/**
	 * Gets the tab height for a tabbed pane.
	 * @param tabbedPane the instance of JTabbedPane
	 * @return the tab height value
	 */
	public static int getTabHeight(JTabbedPane tabbedPane)
	{
		int maxContentHeight = getMaxContentHeight(tabbedPane);
		int tabHeight = tabbedPane.getSize().height - maxContentHeight;
		
		return tabHeight;
	}
	
	/**
	 * Gets the preferred tab height for a tabbed pane.
	 * @param tabbedPane the instance of JTabbedPane
	 * @return the preferred tab height value
	 */
	public static int getPreferredTabHeight(JTabbedPane tabbedPane)
	{
		int maxContentHeight = getMaxPreferredContentHeight(tabbedPane);
		int tabHeight = tabbedPane.getPreferredSize().height - maxContentHeight;
		
		return tabHeight;
	}
	
	/**
	 * Gets the max content height for a tabbed pane.
	 * @param tabbedPane the instance of JTabbedPane
	 * @return the max content height value
	 */
	public static int getMaxContentHeight(JTabbedPane tabbedPane)
	{
		int contentHeight = -1;
		
		for (int i = 0; i < tabbedPane.getTabCount(); i++)
		{
			Component component = tabbedPane.getComponentAt(i);
			if (component.getSize().height > contentHeight)
			{
				contentHeight = component.getSize().height;
			}
		}
		
		return contentHeight;
	}
	
	/**
	 * Gets the max preferred content height for a tabbed pane.
	 * @param tabbedPane the instance of JTabbedPane
	 * @return the max preferred content height value
	 */
	public static int getMaxPreferredContentHeight(JTabbedPane tabbedPane)
	{
		int contentHeight = -1;
		
		for (int i = 0; i < tabbedPane.getTabCount(); i++)
		{
			Component component = tabbedPane.getComponentAt(i);
			if (component.getPreferredSize().height > contentHeight)
			{
				contentHeight = component.getPreferredSize().height;
			}
		}
		
		return contentHeight;
	}
}