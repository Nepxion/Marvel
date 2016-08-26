package com.nepxion.swing.toggle;

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
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.nepxion.swing.container.JContainer;
import com.nepxion.swing.panel.decoration.JDecorationHeader;

public class JToggleContentPanel
	extends JPanel implements IToggleContentPanel
{
	/**
	 * The instance of JContainer.
	 */
	private JContainer container;
	
	/**
	 * The instance of JDecorationHeader.
	 */
	private JDecorationHeader header;
	
	/**
	 * The banner panel.
	 */
	private JPanel bannerPanel;
	
	/**
	 * Constructs with the default.
	 */
	public JToggleContentPanel()
	{
		this(false);
	}
	
	/**
	 * Constructs with the specified initial header decorated.
	 * @param isHeaderDecorated the boolean value of isHeaderDecorated
	 */
	public JToggleContentPanel(boolean isHeaderDecorated)
	{
		this(isHeaderDecorated, true);
	}
	
	/**
	 * Constructs with the specified initial header decorated and header visible.
	 * @param isHeaderDecorated the boolean value of isHeaderDecorated
	 * @param isHeaderVisible the boolean value of isHeaderVisible
	 */
	public JToggleContentPanel(boolean isHeaderDecorated, boolean isHeaderVisible)
	{
		header = new JDecorationHeader();
		if (!isHeaderDecorated)
		{	
			header.setGradientColor(UIManager.getColor("Panel.background"));
			header.setBackground(UIManager.getColor("Panel.background"));
			header.getLabel().setForeground(Color.black);
		}
		
		if (isHeaderVisible)
		{	
			bannerPanel = new JPanel();
			bannerPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
			bannerPanel.setLayout(new BorderLayout());
			bannerPanel.add(header, BorderLayout.CENTER);
		}
		container = new JContainer();
		container.setLayout(new BorderLayout());
		
		setLayout(new BorderLayout());
		if (isHeaderVisible)
		{	
			add(bannerPanel, BorderLayout.NORTH);
		}
		add(container, BorderLayout.CENTER);
	}
	
	/**
	 * Gets the workspace.
	 * @return the instance of JContainer
	 */
	public JContainer getWorkspace()
	{
		return container;
	}
	
	/**
	 * Gets the header.
	 * @return the instance of JDecorationHeader
	 */
	public JDecorationHeader getHeader()
	{
		return header;
	}
	
	/**
	 * Gets the banner panel.
	 * @return the banner panel
	 */
	public JPanel getBannerPanel()
	{
		return bannerPanel;
	}
	
	/**
	 * Sets the title.
	 * @param title the title string
	 */
	public void setTitle(String title)
	{
		header.setTitle(title);
	}
	
	/**
	 * Sets the icon.
	 * @param icon the instance of Icon
	 */
	public void setIcon(Icon icon)
	{
		header.setIcon(icon);
	}
	
	/**
	 * Toggles.
	 * @param togglePanel the instance of ITogglePanel
	 */
	public void toggle(ITogglePanel togglePanel)
	{
		setTitle(togglePanel.getToggleDescription());
		setIcon(togglePanel.getToggleBannerIcon());
		
		container.addComponent((JPanel) togglePanel, BorderLayout.CENTER);
	}
}