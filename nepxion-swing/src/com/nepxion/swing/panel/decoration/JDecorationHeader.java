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
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.nepxion.swing.panel.JGradientPanel;
import com.nepxion.swing.style.framework.IStyle;
import com.nepxion.swing.style.framework.StyleManager;

public class JDecorationHeader
	extends JGradientPanel implements SwingConstants
{
	private JLabel label;
	private boolean selected;
	
	private IStyle style;
	
	public JDecorationHeader()
	{
		this((String) null, null);
	}
	
	public JDecorationHeader(String title, String toolTipText)
	{
		this(title, null, toolTipText, true, StyleManager.getStyle());
	}
	
	public JDecorationHeader(String title, String toolTipText, boolean selected)
	{
		this(title, null, toolTipText, selected, StyleManager.getStyle());
	}
	
	public JDecorationHeader(String title, String toolTipText, IStyle style)
	{
		this(title, null, toolTipText, true, style);
	}
	
	public JDecorationHeader(String title, String toolTipText, boolean selected, IStyle style)
	{
		this(title, null, toolTipText, selected, style);
	}
	
	public JDecorationHeader(Icon icon, String toolTipText)
	{
		this(null, icon, toolTipText, true, StyleManager.getStyle());
	}
	
	public JDecorationHeader(Icon icon, String toolTipText, boolean selected)
	{
		this(null, icon, toolTipText, selected, StyleManager.getStyle());
	}
	
	public JDecorationHeader(Icon icon, String toolTipText, IStyle style)
	{
		this(null, icon, toolTipText, true, style);
	}
	
	public JDecorationHeader(Icon icon, String toolTipText, boolean selected, IStyle style)
	{
		this(null, icon, toolTipText, selected, style);
	}
	
	public JDecorationHeader(String title, Icon icon, String toolTipText)
	{
		this(title, icon, toolTipText, true, StyleManager.getStyle());
	}
	
	public JDecorationHeader(String title, Icon icon, String toolTipText, boolean selected)
	{
		this(title, icon, toolTipText, selected, StyleManager.getStyle());
	}
	
	public JDecorationHeader(String title, Icon icon, String toolTipText, IStyle style)
	{
		this(title, icon, toolTipText, true, style);
	}
	
	public JDecorationHeader(String title, Icon icon, String toolTipText, boolean selected, IStyle style)
	{
		super(new BorderLayout(), null, null);
		
		this.style = style;
		this.selected = selected;
		
		label = new JLabel(title, icon, LEADING);
		label.setToolTipText(toolTipText);
		
		if (style.getTitleBorder() != null)
		{
			setBorder(style.getTitleBorder());
		}
		add(label, BorderLayout.WEST);
		
		updateHeader();
	}
	
	private void updateHeader()
	{
		label.setForeground(getTextForeground(selected));
		
		setGradientColor(getHeaderGradientColor(selected));
		setBackground(getHeaderBackground(selected));
	}
	
	public JLabel getLabel()
	{
		return label;
	}
	
	public String getTitle()
	{
		return label.getText();
	}
	
	public void setTitle(String newText)
	{
		String oldText = getTitle();
		label.setText(newText);
		firePropertyChange("title", oldText, newText);
	}
	
	public Icon getIcon()
	{
		return label.getIcon();
	}
	
	public void setIcon(Icon newIcon)
	{
		Icon oldIcon = getIcon();
		label.setIcon(newIcon);
		firePropertyChange("icon", oldIcon, newIcon);
	}
	
	public String getToolTipText()
	{
		return label.getToolTipText();
	}
	
	public void setToolTipText(String newToolTipText)
	{
		String oldToolTipText = getToolTipText();
		label.setToolTipText(newToolTipText);
		firePropertyChange("toolTipText", oldToolTipText, newToolTipText);
	}
	
	public boolean isSelected()
	{
		return selected;
	}
	
	public void setSelected(boolean newValue)
	{
		boolean oldValue = isSelected();
		selected = newValue;
		updateHeader();
		firePropertyChange("selected", oldValue, newValue);
	}
	
	public Color getTextForeground(boolean selected)
	{
		if (selected)
		{
			return style.getSelectionForeground();
		}
		else
		{
			return style.getForeground();
		}
	}
	
	public Color getHeaderBackground(boolean selected)
	{
		if (selected)
		{
			return style.getSelectionBackground();
		}
		else
		{
			return style.getBackground();
		}
	}
	
	public Color getHeaderGradientColor(boolean selected)
	{
		if (selected)
		{
			return style.getSelectionGradientColor();
		}
		else
		{
			return style.getGradientColor();
		}
	}
}