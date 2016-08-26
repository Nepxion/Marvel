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
import java.awt.Component;

import com.nepxion.swing.container.ContainerManager;
import com.nepxion.swing.style.texture.shrink.IHeaderTextureStyle;
import com.nepxion.swing.toggle.IToggleContentPanel;
import com.nepxion.swing.toggle.ITogglePanel;

public class JShrinkBar
	extends BasicShrinkBar implements IToggleContentPanel
{
	private Component contentPane;
	
	public JShrinkBar(int placement)
	{
		this(placement, DEFAULT_CONTENT_PANE_TYPE);
	}
	
	public JShrinkBar(int placement, IHeaderTextureStyle headerTextureStyle)
	{
		this(placement, DEFAULT_CONTENT_PANE_TYPE, headerTextureStyle);
	}
	
	public JShrinkBar(int placement, int contentPaneType)
	{
		this(placement, contentPaneType, DEFAULT_HEADER_TEXTURE_STYLE);
	}
	
	public JShrinkBar(int placement, int contentPaneType, IHeaderTextureStyle headerTextureStyle)
	{
		super(placement, contentPaneType, headerTextureStyle);
	}
	
	public Component getContentPane()
	{
		return contentPane;
	}
	
	public void setContentPane(Component contentPane)
	{
		this.contentPane = contentPane;
		
		shrinkContentPane.removeAll();
		shrinkContentPane.add(contentPane, BorderLayout.CENTER);
		
		ContainerManager.update(shrinkContentPane);
	}
	
	/**
	 * Toggles.
	 * @param togglePanel the instance of ITogglePanel
	 */
	public void toggle(ITogglePanel togglePanel)
	{
		setContentPane((Component) togglePanel);
	}
}