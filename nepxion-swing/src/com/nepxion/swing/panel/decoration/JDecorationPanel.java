package com.nepxion.swing.panel.decoration;

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
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JPanel;

import com.nepxion.swing.style.framework.IStyle;
import com.nepxion.swing.style.framework.StyleManager;

public class JDecorationPanel
	extends JPanel
{
	private JDecorationHeader header;
	private JPanel headContainer;
	
	public JDecorationPanel()
	{
		this((String) null, null);
	}
	
	public JDecorationPanel(String title, String toolTipText)
	{
		this(title, null, toolTipText, true, null, StyleManager.getStyle());
	}
	
	public JDecorationPanel(String title, String toolTipText, boolean selected)
	{
		this(title, null, toolTipText, selected, null, StyleManager.getStyle());
	}
	
	public JDecorationPanel(String title, String toolTipText, IStyle style)
	{
		this(title, null, toolTipText, true, null, style);
	}
	
	public JDecorationPanel(String title, String toolTipText, boolean selected, IStyle style)
	{
		this(title, null, toolTipText, selected, null, style);
	}
	
	public JDecorationPanel(Icon icon, String toolTipText)
	{
		this(null, icon, toolTipText, true, null, StyleManager.getStyle());
	}
	
	public JDecorationPanel(Icon icon, String toolTipText, boolean selected)
	{
		this(null, icon, toolTipText, selected, null, StyleManager.getStyle());
	}
	
	public JDecorationPanel(Icon icon, String toolTipText, IStyle style)
	{
		this(null, icon, toolTipText, true, null, style);
	}
	
	public JDecorationPanel(Icon icon, String toolTipText, boolean selected, IStyle style)
	{
		this(null, icon, toolTipText, selected, null, style);
	}
	
	public JDecorationPanel(String title, Icon icon, String toolTipText)
	{
		this(title, icon, toolTipText, true, null, StyleManager.getStyle());
	}
	
	public JDecorationPanel(String title, Icon icon, String toolTipText, boolean selected)
	{
		this(title, icon, toolTipText, selected, null, StyleManager.getStyle());
	}
	
	public JDecorationPanel(String title, Icon icon, String toolTipText, IStyle style)
	{
		this(title, icon, toolTipText, true, null, style);
	}
	
	public JDecorationPanel(String title, Icon icon, String toolTipText, boolean selected, IStyle style)
	{
		this(title, icon, toolTipText, selected, null, style);
	}
	
	public JDecorationPanel(String title, Icon icon, String toolTipText, Component contentPane)
	{
		this(title, icon, toolTipText, true, contentPane, StyleManager.getStyle());
	}
	
	public JDecorationPanel(String title, Icon icon, String toolTipText, Component contentPane, IStyle style)
	{
		this(title, icon, toolTipText, true, contentPane, style);
	}
	
	public JDecorationPanel(String title, Icon icon, String toolTipText, boolean selected, Component contentPane)
	{
		this(title, icon, toolTipText, selected, contentPane, StyleManager.getStyle());
	}
	
	public JDecorationPanel(String title, Icon icon, String toolTipText, boolean selected, Component contentPane, IStyle style)
	{
		header = new JDecorationHeader(title, icon, toolTipText, selected, style);
		
		headContainer = new JPanel();
		headContainer.setLayout(new BorderLayout());
		headContainer.setOpaque(false);
		headContainer.add(header, BorderLayout.CENTER);
		if (style.getHeaderBorder() != null)
		{
			headContainer.setBorder(style.getHeaderBorder());
		}
		
		Dimension minimumSize = new Dimension(headContainer.getMinimumSize());
		minimumSize.height += 3;
		setMinimumSize(minimumSize);
		
		if (style.getBorder() != null)
		{
			setBorder(style.getBorder());
		}
		
		setLayout(new BorderLayout());
		add(headContainer, BorderLayout.NORTH);
		
		if (contentPane != null)
		{
			setContentPane(contentPane);
		}
	}
	
	public void addHeaderMouseListener(MouseListener listener)
	{
		header.addMouseListener(listener);
	}
	
	public JPanel getHeaderContainer()
	{
		return headContainer;
	}
	
	public JDecorationHeader getHeader()
	{
		return header;
	}
	
	public Component getContentPane()
	{
		return getComponentCount() > 1 ? getComponent(1) : null;
	}
	
	public void setContentPane(Component contentPane)
	{
		Component oldContentPane = getContentPane();
		if (getComponentCount() > 1)
		{
			remove(oldContentPane);
		}
		add(contentPane, BorderLayout.CENTER);
		firePropertyChange("contentPane", oldContentPane, contentPane);
	}
	
	public String getTitle()
	{
		return header.getTitle();
	}
	
	public void setTitle(String title)
	{
		header.setTitle(title);
	}
	
	public Icon getIcon()
	{
		return header.getIcon();
	}
	
	public void setIcon(Icon icon)
	{
		header.setIcon(icon);
	}
	
	public String getToolTipText()
	{
		return header.getToolTipText();
	}
	
	public void setToolTipText(String toolTipText)
	{
		header.setToolTipText(toolTipText);
	}
	
	public boolean isSelected()
	{
		return header.isSelected();
	}
	
	public void setSelected(boolean selected)
	{
		header.setSelected(selected);
	}
}