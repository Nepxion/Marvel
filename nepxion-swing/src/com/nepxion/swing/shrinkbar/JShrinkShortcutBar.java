package com.nepxion.swing.shrinkbar;

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
import java.awt.Component;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.style.texture.shrink.IHeaderTextureStyle;

public class JShrinkShortcutBar
	extends BasicShrinkBar
{
	private JPanel contentBar;
	
	public JShrinkShortcutBar(int placement)
	{
		this(placement, DEFAULT_CONTENT_PANE_TYPE);
	}
	
	public JShrinkShortcutBar(int placement, IHeaderTextureStyle headerTextureStyle)
	{
		this(placement, DEFAULT_CONTENT_PANE_TYPE, headerTextureStyle);
	}
	
	public JShrinkShortcutBar(int placement, int contentPaneType)
	{
		this(placement, contentPaneType, DEFAULT_HEADER_TEXTURE_STYLE);
	}
	
	public JShrinkShortcutBar(int placement, int contentPaneType, IHeaderTextureStyle headerTextureStyle)
	{
		super(placement, contentPaneType, headerTextureStyle);
		
		initComponents();
	}
	
	private void initComponents()
	{
		contentBar = new JPanel();
		contentBar.setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 5));
		
		shrinkContentPane.add(contentBar, BorderLayout.CENTER);
	}
	
	public JShrinkShortcut addShrinkShortcut(String title, Icon icon, String toolTipText, List buttonList)
	{
		JShrinkShortcut shrinkShortcut = new JShrinkShortcut();
		shrinkShortcut.setTitle(title);
		shrinkShortcut.setIcon(icon);
		shrinkShortcut.setToolTipText(toolTipText);
		shrinkShortcut.setButtonList(buttonList);
		shrinkShortcut.shrinkChanged(isShrinked());
		shrinkShortcut.setSeparatorColor(shrinkHeader.getHeaderTextureStyle().getSeparatorColors());
		
		contentBar.add(shrinkShortcut);
	
		Color background = shrinkHeader.getHeaderTextureStyle().getContentBackground();
		if (background != null)
		{	
			setBackground(background);
		}
		
		return shrinkShortcut;
	}
	
	protected void shrinkChanged(boolean shrinked)
	{
		super.shrinkChanged(shrinked);
		
		for (int i = 0; i < contentBar.getComponentCount(); i++)
		{
			Component component = contentBar.getComponent(i);
			if (component instanceof JShrinkShortcut)
			{
				JShrinkShortcut shrinkShortcut = (JShrinkShortcut) component;
				
				shrinkShortcut.shrinkChanged(shrinked);
			}
		}
	}
	
	public void setBackground(Color background)
	{
		super.setBackground(background);
		
		setBackground(this, background);
	}
	
	private void setBackground(JComponent component, Color background)
	{
		for (int i = 0; i < component.getComponentCount(); i++)
		{
			Component c = component.getComponent(i);
			
			if (c instanceof JComponent)
			{
				JComponent childComponent = (JComponent) c;
				childComponent.setBackground(background);
				
				setBackground(childComponent, background);
			}
		}
	}
	
	public JShrinkShortcut getShrinkOutlook(int index)
	{
		Component component = contentBar.getComponent(index);
		if (component instanceof JShrinkShortcut)
		{
			JShrinkShortcut shrinkShortcut = (JShrinkShortcut) component;
			
			return shrinkShortcut;
		}
		
		return null;
	}
	
	public JShrinkShortcut getShrinkOutlook(String title)
	{
		for (int i = 0; i < contentBar.getComponentCount(); i++)
		{
			Component component = contentBar.getComponent(i);
			if (component instanceof JShrinkShortcut)
			{
				JShrinkShortcut shrinkShortcut = (JShrinkShortcut) component;
				
				if (shrinkShortcut.getTitle().equals(title))
				{
					return shrinkShortcut;
				}
			}
		}
		
		return null;
	}
}