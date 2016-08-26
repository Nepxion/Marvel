package com.nepxion.swing.statusbar;

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
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.nepxion.swing.border.ButtonBorder;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.separator.JBasicSeparator;
import com.nepxion.swing.toolbar.JBasicToolBar;

public class JStatusBar
	extends JBasicToolBar implements SwingConstants
{	
	/**
	 * The left panel.
	 */
	private JPanel leftPanel;
	
	/**
	 * The right panel.
	 */
	private JPanel rightPanel;
	
	/**
	 * The left index value.
	 */
	private int leftIndex = 0;
	
	/**
	 * The right index value.
	 */
	private int rightIndex = 0;
	
	/**
	 * The separator height value.
	 */
	private int separatorHeight = 17;
	
	/**
	 * The boolean value of isCornerVisible.
	 */
	private boolean isCornerVisible = true;
	
	/**
	 * Constructs with the default.
	 */
	public JStatusBar()
	{
		leftPanel = new JPanel();
		leftPanel.setOpaque(false);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.X_AXIS));
		
		rightPanel = new JPanel();
		rightPanel.setOpaque(false);
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.X_AXIS));
		
		add(leftPanel);
		add(Box.createHorizontalGlue());
		add(rightPanel);
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorderVisible(true);
	}
	
	/**
	 * Sets the border visible.
	 * @param isBorderVisible the boolean value of isBorderVisible
	 */
	public void setBorderVisible(boolean isBorderVisible)
	{
		if (isBorderVisible)
		{
			setPreferredSize(new Dimension(getPreferredSize().width, 23));
			setBorder(new ButtonBorder(ButtonBorder.BORDER_LOWERED));
		}
		else
		{
			setPreferredSize(new Dimension(getPreferredSize().width, 21));
			setBorder(BorderFactory.createEmptyBorder());
		}
	}
	
	/**
	 * Sets the corner visible.
	 * @param isCornerVisible the boolean value of isCornerVisible
	 */
	public void setCornerVisible(boolean isCornerVisible)
	{
		this.isCornerVisible = isCornerVisible;
	}
	
	/**
	 * Sets the separator height.
	 * @param separatorHeight the separator height value
	 */
	public void setSeparatorHeight(int separatorHeight)
	{
		this.separatorHeight = separatorHeight;
	}
	
	/**
	 * Adds the item.
	 * @param item the instance of JStatusItem
	 * @param width the width value
	 */
	public void addItem(JStatusItem item, int width)
	{
		addItem(item, width, true);
	}
	
	/**
	 * Adds the item.
	 * @param item the instance of JStatusItem
	 * @param width the width value
	 * @param isSeparator the boolean value of isSeparator
	 */
	public void addItem(JStatusItem item, int width, boolean isSeparator)
	{
		addItem(item, width, LEFT, isSeparator);
	}
	
	/**
	 * Adds the item.
	 * @param item the instance of JStatusItem
	 * @param width the width value
	 * @param justification the justification value
	 */
	public void addItem(JStatusItem item, int width, int justification)
	{
		addItem(item, width, justification, true);
	}
	
	/**
	 * Adds the item.
	 * @param item the instance of JStatusItem
	 * @param width the width value
	 * @param justification the justification value
	 * @param isSeparator the boolean value of isSeparator
	 */
	public void addItem(JStatusItem item, int width, int justification, boolean isSeparator)
	{
		addItem(item, width, justification, JBasicSeparator.RAISED_STYLE, isSeparator);
	}
	
	/**
	 * Adds the item.
	 * @param item the instance of JStatusItem
	 * @param width the width value
	 * @param justification the justification value
	 * @param style the style string
	 */
	public void addItem(JStatusItem item, int width, int justification, String style)
	{
		addItem(item, width, justification, style, true);
	}
	
	/**
	 * Adds the item.
	 * @param item the instance of JStatusItem
	 * @param width the width value
	 * @param justification the justification value
	 * @param style the style string
	 * @param isSeparator the boolean value of isSeparator
	 */
	public void addItem(JStatusItem item, int width, int justification, String style, boolean isSeparator)
	{
		int cornerWidth = 0;
		
		JBasicSeparator separator = null;
		if (isSeparator)
		{	
			separator = new JBasicSeparator(style, separatorHeight != -1 ? separatorHeight : getPreferredSize().height);
			separator.setBackground(getBackground());
		}
		if (justification == LEFT)
		{
			leftPanel.add(item);
			if (separator != null)
			{	
				leftPanel.add(separator);
			}
			item.setIndex(leftIndex);
			leftIndex++;
		}
		else if (justification == RIGHT)
		{
			if (rightPanel.getComponentCount() == 0)
			{
				cornerWidth = 15;
			}
			if (separator != null)
			{
				rightPanel.add(separator, 0);
				rightPanel.add(item, 1);
			}
			else
			{
				leftPanel.add(item);
			}
			item.setIndex(rightIndex);
			rightIndex++;
		}
		DimensionManager.setDimension(item, new Dimension(width + cornerWidth, getPreferredSize().height));
	}
	
	/**
	 * Gets the item.
	 * @param index the index value
	 * @param justification the justification value
	 * @return the instance of JStatusItem
	 */
	public JStatusItem getItem(int index, int justification)
	{
		if (justification == LEFT)
		{
			return getItem(index, leftPanel);
		}
		else if (justification == RIGHT)
		{
			return getItem(index, rightPanel);
		}
		
		return null;
	}
	
	/**
	 * Gets the item.
	 * @param index the index value.
	 * @param panel the instance of JPanel
	 * @return the instance of JStatusItem
	 */
	private JStatusItem getItem(int index, JPanel panel)
	{
		for (int i = 0; i < panel.getComponentCount(); i++)
		{
			Component component = panel.getComponent(i);
			if (component instanceof JStatusItem)
			{
				JStatusItem item = (JStatusItem) component;
				if (item.getIndex() == index)
				{
					return item;
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Paints the children graphics.
	 * @param g the instance of Graphics
	 */
	public void paintChildren(Graphics g)
	{
		super.paintChildren(g);
		
		if (isCornerVisible)
		{
			int w = getWidth();
			int h = getHeight();
			g.setColor(Color.white);
			g.drawLine(w, h - 12, w - 12, h);
			g.drawLine(w, h - 8, w - 8, h);
			g.drawLine(w, h - 4, w - 4, h);
			g.setColor(Color.gray);
			g.drawLine(w, h - 11, w - 11, h);
			g.drawLine(w, h - 10, w - 10, h);
			g.drawLine(w, h - 7, w - 7, h);
			g.drawLine(w, h - 6, w - 6, h);
			g.drawLine(w, h - 3, w - 3, h);
			g.drawLine(w, h - 2, w - 2, h);
		}
		g.setColor(UIManager.getColor("Panel.background"));
	}
}