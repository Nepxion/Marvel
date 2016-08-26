package com.nepxion.swing.renderer.list;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.StringTokenizer;

import javax.swing.DefaultListCellRenderer;

public class TabbedListCellRenderer
	extends DefaultListCellRenderer
{
	/**
	 * The width value.
	 */
	private int width = 0;
	
	/**
	 * The tab delimiter string.
	 */
	private String tabDelimiter = "\t";
	
	/**
	 * The tab size value array.
	 */
	private int[] tabSizes = null;
	
	/**
	 * The default tab size value.
	 */
	private int defaultTabSize = 50;
	
	/**
	 * Constructs with the default.
	 */	
	public TabbedListCellRenderer()
	{
		this("\t");
	}
	
	/**
	 * Constructs with the specified initial tab sizes.
	 * @param tabSizes the tab size value array
	 */
	public TabbedListCellRenderer(int[] tabSizes)
	{
		this(tabSizes, 50);
	}
	
	/**
	 * Constructs with the specified initial tab delimiter.
	 * @param tabDelimiter the tab delimiter string
	 */
	public TabbedListCellRenderer(String tabDelimiter)
	{
		this(tabDelimiter, null);
	}
	
	/**
	 * Constructs with the specified initial width.
	 * @param width the width value
	 */
	public TabbedListCellRenderer(int width)
	{
		this(width, 50);
	}
	
	/**
	 * Constructs with the specified initial tab sizes and default tab size.
	 * @param tabSizes the tab size value array
	 * @param defaultTabSize the default tab size value
	 */
	public TabbedListCellRenderer(int[] tabSizes, int defaultTabSize)
	{
		this("\t", tabSizes, defaultTabSize);
	}
	
	/**
	 * Constructs with the specified initial tab delimiter and default tab size.
	 * @param tabDelimiter the tab delimiter string
	 * @param defaultTabSize the default tab size value 
	 */
	public TabbedListCellRenderer(String tabDelimiter, int defaultTabSize)
	{
		this(tabDelimiter, null, defaultTabSize);
	}
	
	/**
	 * Constructs with the specified initial tab delimiter and tab sizes.
	 * @param tabDelimiter the tab delimiter string
	 * @param tabSizes the tab size value array
	 */
	public TabbedListCellRenderer(String tabDelimiter, int[] tabSizes)
	{
		this(tabDelimiter, tabSizes, 50);
	}
	
	/**
	 * Constructs with the specified initial width and default tab size.
	 * @param width the width value
	 * @param defaultTabSize the default tab size value
	 */
	public TabbedListCellRenderer(int width, int defaultTabSize)
	{
		this(width, (String) null, defaultTabSize);
	}
	
	/**
	 * Constructs with the specified initial width and tab sizes.
	 * @param width the width value
	 * @param tabSizes the tab size value array
	 */
	public TabbedListCellRenderer(int width, int[] tabSizes)
	{
		this(width, tabSizes, 50);
	}
	
	/**
	 * Constructs with the specified initial width and tab delimiter.
	 * @param width the width value
	 * @param tabDelimiter the tab delimiter string
	 */
	public TabbedListCellRenderer(int width, String tabDelimiter)
	{
		this(width, tabDelimiter, 50);
	}
	
	/**
	 * Constructs with the specified initial tab delimiter, tab sizes and default tab size.
	 * @param tabDelimiter the tab delimiter string
	 * @param tabSizes the tab size value array
	 * @param defaultTabSize the default tab size value
	 */
	public TabbedListCellRenderer(String tabDelimiter, int[] tabSizes, int defaultTabSize)
	{
		this(-1, tabDelimiter, tabSizes, defaultTabSize);
	}
	
	/**
	 * Constructs with the specified initial width, tab sizes and default tab size.
	 * @param width the width value
	 * @param tabSizes the tab size value array
	 * @param defaultTabSize the default tab size value
	 */
	public TabbedListCellRenderer(int width, int[] tabSizes, int defaultTabSize)
	{
		this(width, "\t", tabSizes, defaultTabSize);
	}
	
	/**
	 * Constructs with the specified initial width, tab delimiter and default tab size.
	 * @param width the width value
	 * @param tabDelimiter the tab delimiter string
	 * @param defaultTabSize the default tab size value
	 */
	public TabbedListCellRenderer(int width, String tabDelimiter, int defaultTabSize)
	{
		this(width, tabDelimiter, null, defaultTabSize);
	}
	
	/**
	 * Constructs with the specified initial width, tab delimiter and tab sizes.
	 * @param width the width value
	 * @param tabDelimiter the tab delimiter string
	 * @param tabSizes the tab size value array
	 */
	public TabbedListCellRenderer(int width, String tabDelimiter, int[] tabSizes)
	{
		this(width, tabDelimiter, tabSizes, 50);
	}
	
	/**
	 * Constructs with the specified initial width, tab delimiter, tab sizes and default tab size.
	 * @param width the width value
	 * @param tabDelimiter the tab delimiter string
	 * @param tabSizes the tab size value array
	 * @param defaultTabSize the default tab size value
	 */
	public TabbedListCellRenderer(int width, String tabDelimiter, int[] tabSizes, int defaultTabSize)
	{
		this.width = width;
		this.tabDelimiter = tabDelimiter;
		this.tabSizes = tabSizes;
		this.defaultTabSize = defaultTabSize;
	}
	
	/**
	 * Gets the tab delimiter.
	 * @return the tab delimiter string
	 */
	public String getTabDelimiter()
	{
		return tabDelimiter;
	}
	
	/**
	 * Sets the tab delimiter.
	 * @param tabDelimiter the tab delimiter string
	 */
	public void setTabDelimiter(String tabDelimiter)
	{
		this.tabDelimiter = tabDelimiter;
	}
	
	/**
	 * Gets the tab sizes.
	 * @return the tab size value array
	 */
	public int[] getTabSizes()
	{
		return tabSizes;
	}
	
	/**
	 * Sets the tab sizes.
	 * @param tabSizes the tab size value array 
	 */
	public void setTabSizes(int[] tabSizes)
	{
		this.tabSizes = tabSizes;
	}
	
	/**
	 * Gets the default tab size.
	 * @return the default tab size value
	 */
	public int getDefaultTabSize()
	{
		return defaultTabSize;
	}
	
	/**
	 * Sets the default tab size.
	 * @param defaultTabSize the default tab size value
	 */
	public void setDefaultTabSize(int defaultTabSize)
	{
		this.defaultTabSize = defaultTabSize;
	}
	
	/**
	 * Gets the tab size.
	 * @param index the index value
	 * @return the tab size value
	 */
	public int getTabSize(int index)
	{
		if (tabSizes == null)
		{
			return defaultTabSize * index;
		}
		
		int length = tabSizes.length;
		if (index >= 0 && index < length)
		{
			return tabSizes[index];
		}
		
		return tabSizes[length - 1] + defaultTabSize * (index - length + 1);
	}
	
	/**
	 * Gets the preferred size.
	 * @return the instance of Dimension
	 */
	public Dimension getPreferredSize()
	{
		Dimension preferredSize = super.getPreferredSize();
		
		return new Dimension(width > 0 ? width : preferredSize.width, preferredSize.height);
	}
	
	/**
	 * Paints the graphics.
	 * @param g the instance of Graphics
	 */
	public void paint(Graphics g)
	{
		FontMetrics fontMetrics = g.getFontMetrics();
		
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		getBorder().paintBorder(this, g, 0, 0, getWidth(), getHeight());
		
		g.setColor(getForeground());
		g.setFont(getFont());
		
		Insets insets = getInsets();
		int x = insets.left;
		int y = insets.top + fontMetrics.getAscent();
		
		StringTokenizer stringTokenizer = new StringTokenizer(getText(), tabDelimiter);
		while (stringTokenizer.hasMoreTokens())
		{
			String next = stringTokenizer.nextToken();
			g.drawString(next, x, y);
			
			// x += fontMetrics.stringWidth(next);
			
			if (!stringTokenizer.hasMoreTokens())
			{
				break;
			}
			
			int index = 0;
			while (x >= getTabSize(index))
			{
				index++;
			}
			x = getTabSize(index);
		}
	}
}