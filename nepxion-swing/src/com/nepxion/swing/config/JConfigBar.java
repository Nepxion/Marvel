package com.nepxion.swing.config;

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
import java.awt.Container;
import java.awt.Dimension;
import java.util.Enumeration;

import javax.swing.JPanel;

import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.toggle.ITogglePanel;
import com.nepxion.swing.toggle.JToggleActionButton;

public class JConfigBar
	extends JPanel
{
	/**
	 * The instance of JConfigButtonBar.
	 */
	private JConfigButtonBar configButtonBar;
	
	/**
	 * The instance of JConfigContentPanel.
	 */
	private JConfigContentPanel configContentPanel;
	
	/**
	 * Constructs with the default.
	 */
	public JConfigBar()
	{
		configButtonBar = new JConfigButtonBar();
		configContentPanel = new JConfigContentPanel();
		
		setLayout(new BorderLayout(10, 0));
		add(new JBasicScrollPane(configButtonBar), BorderLayout.WEST);
		add(configContentPanel, BorderLayout.CENTER);
		
		setConfigButtonBarWidth(80);
		setConfigContentPanelWidth(480);
		setHeight(480);
	}
	
	/**
	 * Sets the config button bar width.
	 * @param configButtonBarWidth the config button bar width value
	 */
	public void setConfigButtonBarWidth(int configButtonBarWidth)
	{
		Container configButtonBarContainer = configButtonBar.getParent();
		configButtonBarContainer.setPreferredSize(new Dimension(configButtonBarWidth, configButtonBarContainer.getPreferredSize().height));
	}
	
	/**
	 * Sets the config content panel width.
	 * @param configContentPanelWidth the config content panel width value
	 */
	public void setConfigContentPanelWidth(int configContentPanelWidth)
	{
		configContentPanel.setPreferredSize(new Dimension(configContentPanelWidth, configContentPanel.getPreferredSize().height));
	}
	
	/**
	 * Sets the height.
	 * @param height the height value
	 */
	public void setHeight(int height)
	{
		setPreferredSize(new Dimension(getPreferredSize().width, height));
	}
	
	/**
	 * Gets the config button bar.
	 * @return the instance of JConfigButtonBar
	 */
	public JConfigButtonBar getConfigButtonBar()
	{
		return configButtonBar;
	}
	
	/**
	 * Gets the config content panel.
	 * @return the instance of JConfigContentPanel
	 */
	public JConfigContentPanel getConfigContentPanel()
	{
		return configContentPanel;
	}
	
	/**
	 * Gets the toggle panel by a toggle text.
	 * @param toggleText the toggle text string
	 * @return the instance of ITogglePanel
	 */
	public ITogglePanel getTogglePanel(String toggleText)
	{
		for (Enumeration enumeration = configButtonBar.getButtonGroup().getElements(); enumeration.hasMoreElements();)
		{
			JToggleActionButton toggleActionButton = (JToggleActionButton) enumeration.nextElement();
			ITogglePanel togglePanel = toggleActionButton.getTogglePanel();
			if (togglePanel.getToggleText().equals(toggleText))
			{
				return togglePanel;
			}
		}
		
		return null;
	}
	
	/**
	 * Gets the toggle action button by a toggle panel.
	 * @param togglePanel the instance of ITogglePanel
	 * @return the instance of JToggleActionButton
	 */
	public JToggleActionButton getToggleActionButton(ITogglePanel togglePanel)
	{
		for (Enumeration enumeration = configButtonBar.getButtonGroup().getElements(); enumeration.hasMoreElements();)
		{
			JToggleActionButton toggleActionButton = (JToggleActionButton) enumeration.nextElement();
			if (toggleActionButton.getTogglePanel() == togglePanel)
			{
				return toggleActionButton;
			}
		}
		
		return null;
	}
	
	/**
	 * Adds the toggle panel.
	 * @param togglePanel the instance of ITogglePanel
	 */
	public void addTogglePanel(ITogglePanel togglePanel)
	{
		JToggleActionButton toggleActionButton = new JToggleActionButton(configContentPanel, togglePanel);
		configButtonBar.addButton(toggleActionButton);
	}
	
	/**
	 * Removes the toggle panel.
	 * @param togglePanel the instance of ITogglePanel
	 */
	public void removeTogglePanel(ITogglePanel togglePanel)
	{
		JToggleActionButton toggleActionButton = getToggleActionButton(togglePanel);
		configButtonBar.removeButton(toggleActionButton);
	}
	
	/**
	 * Sets the selection toggle panel.
	 * @param togglePanel the instance of ITogglePanel
	 */
	public void setSelectionTogglePanel(ITogglePanel togglePanel)
	{
		for (Enumeration enumeration = configButtonBar.getButtonGroup().getElements(); enumeration.hasMoreElements();)
		{
			JToggleActionButton toggleActionButton = (JToggleActionButton) enumeration.nextElement();
			if (toggleActionButton.getTogglePanel() == togglePanel)
			{
				toggleActionButton.doClick();
				
				return;
			}
		}
	}
	
	/**
	 * Sets the selection toggle panel by a toggle text.
	 * @param toggleText the toggle text string
	 */
	public void setSelectionTogglePanel(String toggleText)
	{
		if (toggleText == null)
		{
			return;
		}
		
		for (Enumeration enumeration = configButtonBar.getButtonGroup().getElements(); enumeration.hasMoreElements();)
		{
			JToggleActionButton toggleActionButton = (JToggleActionButton) enumeration.nextElement();
			ITogglePanel togglePanel = toggleActionButton.getTogglePanel();
			if (togglePanel.getToggleText().equals(toggleText))
			{
				toggleActionButton.doClick();
				
				return;
			}
		}
	}
	
	/**
	 * Sets the selection toggle panel by a toggle index.
	 * @param toggleIndex the toggle index value
	 */
	public void setSelectionTogglePanel(int toggleIndex)
	{
		if (toggleIndex < 0 || toggleIndex > configButtonBar.getButtonGroup().getButtonCount() - 1)
		{
			return;
		}
		
		int togglePanelIndex = 0;
		for (Enumeration enumeration = configButtonBar.getButtonGroup().getElements(); enumeration.hasMoreElements();)
		{
			JToggleActionButton toggleActionButton = (JToggleActionButton) enumeration.nextElement();
			if (togglePanelIndex == toggleIndex)
			{
				toggleActionButton.doClick();
				
				return;
			}
			togglePanelIndex++;
		}
	}
}