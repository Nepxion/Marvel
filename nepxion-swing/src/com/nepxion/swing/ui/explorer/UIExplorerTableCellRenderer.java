package com.nepxion.swing.ui.explorer;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.border.Border;

import com.nepxion.swing.icon.paint.GeoCellIcon;
import com.nepxion.swing.icon.paint.SelectionIcon;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.renderer.table.DefaultTableCellRenderer;

public class UIExplorerTableCellRenderer
	extends DefaultTableCellRenderer
{
	/**
	 * 
	 */
	public UIExplorerTableCellRenderer()
	{
		setHorizontalAlignment(CENTER);
		setOpaque(true);
	}
	
	/**
	 * 
	 */
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	{
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		setText("");
		setIcon(null);
		setBorder(null);
		
		if (value instanceof Boolean)
		{
			SelectionIcon icon = new SelectionIcon(((Boolean) value).booleanValue());
			setIcon(icon);
		}
		else if (value instanceof Border)
		{
			CellBorder border = new CellBorder(table.getValueAt(row, 0).toString(), (Border) value);
			setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2), border));
		}
		else if (value instanceof Color)
		{
			GeoCellIcon icon = new GeoCellIcon(GeoCellIcon.SHAPE_POLYGON, (Color) value);
			setIcon(icon);
		}
		else if (value instanceof Font)
		{
			setText(SwingLocale.getString("ui_sample_zh_cn") + " Sample");
			setFont((Font) value);
		}
		else if (value instanceof Icon)
		{
			CellIcon icon = new CellIcon(table.getValueAt(row, 0).toString(), (Icon) value);
			setIcon(icon);
		}
		else if (value instanceof Number)
		{
		}
		else if (value instanceof String)
		{
		}
		else
		{
		}
		
		return this;
	}
	
	public class CellIcon
		implements Icon
	{
		private Icon icon;
		private Component component;
		
		public CellIcon(String key, Icon icon)
		{
			this.icon = icon;
			
			try
			{
				int index = key.lastIndexOf('.');
				if (index != -1)
				{
					String classname = "javax.swing.J" + key.substring(0, index);
					component = (Component) Class.forName(classname).newInstance();
				}
			}
			catch (InstantiationException e)
			{
			}
			catch (IllegalAccessException e)
			{
			}
			catch (ClassNotFoundException e)
			{
			}
		}
		
		public int getIconWidth()
		{
			return icon.getIconWidth();
		}
		
		public int getIconHeight()
		{
			return icon.getIconHeight();
		}
		
		public void paintIcon(Component c, Graphics g, int x, int y)
		{
			if (component != null)
			{
				c = component;
			}
			try
			{
				icon.paintIcon(c, g, x, y);
			}
			catch (Exception e)
			{
			}
		}
	}
	
	public class CellBorder
		implements Border
	{
		private Border border;
		private Component component;
		
		public CellBorder(String key, Border border)
		{
			this.border = border;
			
			try
			{
				int index = key.lastIndexOf('.');
				if (index != -1)
				{
					String classname = "javax.swing.J" + key.substring(0, index);
					component = (Component) Class.forName(classname).newInstance();
				}
			}
			catch (InstantiationException e)
			{
			}
			catch (IllegalAccessException e)
			{
			}
			catch (ClassNotFoundException e)
			{
			}
		}
		
		public boolean isBorderOpaque()
		{
			return border.isBorderOpaque();
		}
		
		public Insets getBorderInsets(Component c)
		{
			if (component != null)
			{
				c = component;
			}
			
			return border.getBorderInsets(c);
		}
		
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
		{
			if (component != null)
			{
				c = component;
			}
			try
			{
				border.paintBorder(c, g, x, y, width, height);
			}
			catch (Exception e)
			{
			}
		}
	}
}