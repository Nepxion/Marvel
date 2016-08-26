package com.nepxion.swing.outlookbar;

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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.l2fprod.common.swing.JOutlookBar;
import com.l2fprod.common.swing.plaf.OutlookBarUI;
import com.nepxion.swing.style.outlookbar.JFlatOutlookBarUI;

public class JFlatOutlookBar
	extends JOutlookBar implements SwingConstants
{
	/**
	 * Constructs with the default.
	 */
	public JFlatOutlookBar()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial tab placement.
	 * @param tabPlacement the tab placement value
	 */
	public JFlatOutlookBar(int tabPlacement)
	{
		super(tabPlacement);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		JFlatOutlookBarUI outlookBarUI = new JFlatOutlookBarUI();
		setUI((OutlookBarUI) outlookBarUI);
		setBackground(UIManager.getColor("Panel.background"));
		setAnimated(false);
	}
	
	/**
	 * Makes the scroll pane for the component.
	 * @param component the instance of Component
	 * @return JScrollPane the instance of JScrollPane
	 */
	public JScrollPane makeScrollPane(Component component)
	{
		JScrollPane scrollPane = super.makeScrollPane(component);
				
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		FlatOutlookBarManager.setPreferenceStyle(scrollPane);
		
		return scrollPane;
	}
	
	/**
	 * Sets the all tabs alignment.
	 * @param alignment the alignment value
	 */
	public void setAllTabsAlignment(int alignment)
	{
		setAllTabsAlignment(alignment, 10);
	}
	
	/**
	 * Sets the all tabs alignment.
	 * @param alignment the alignment value
	 * @param indent the indent value
	 */
	public void setAllTabsAlignment(int alignment, int indent)
	{
		JFlatOutlookBarUI outlookBarUI = (JFlatOutlookBarUI) getUI();
		switch (alignment)
		{
			case LEFT :
				break;
			case CENTER :
				indent = 0;
				break;
			case RIGHT :
				indent = -indent;
				break;
		}
		outlookBarUI.getButtonUI().setIndent(indent);
		
		super.setAllTabsAlignment(alignment);
	}
	
	/**
	 * Gets the selected title.
	 * @return the title string
	 */
	public String getSelectedTitle()
	{
		int index = getSelectedIndex();
		if (index == -1)
		{
			return null;
		}
		
		return getTitleAt(index);
	}
	
	/**
	 * Gets the tab by a title.
	 * @param title the title string
	 * @return the instance of Component
	 */
	public Component getTabAt(String title)
	{
		for (int i = 0; i < getTabCount(); i++)
		{
			if (getTitleAt(i).equals(title))
			{
				return getComponentAt(i);
			}
		}
		
		return null;
	}
	
	/**
	 * Removed the tab by a title.
	 * @param title the title string
	 */
	public void removeTabAt(String title)
	{
		for (int i = 0; i < getTabCount(); i++)
		{
			if (getTitleAt(i).equals(title))
			{
				removeTabAt(i);
				break;
			}
		}
	}
	
	/**
	 * Removes tabs by the closed component list.
	 * @param closedComponents the instance of List
	 */
	public void removeTabs(List closedComponents)
	{
		for (int i = 0; i < closedComponents.size(); i++)
		{
			Component closedComponent = (Component) closedComponents.get(i);
			
			super.removeTabAt(indexOfComponent(closedComponent));
		}
	}
	
	/**
	 * Removes reverse tabs by an index.
	 * @param index the index value
	 */
	public void removeReverseTabsAt(int index)
	{
		List closedComponents = new ArrayList();
		for (int i = 0; i < getTabCount(); i++)
		{
			if (i != index)
			{
				Component component = getComponentAt(i);
				closedComponents.add(component);
			}
		}
		removeTabs(closedComponents);
	}
	
	/**
	 * Removes all tabs.
	 */
	public void removeAllTabs()
	{
		List components = new ArrayList();
		for (int i = 0; i < getTabCount(); i++)
		{
			Component component = getComponentAt(i);
			components.add(component);
		}
		removeTabs(components);
	}
}