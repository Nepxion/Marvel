package com.nepxion.swing.popupmenu;

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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;

import javax.swing.JPopupMenu;

import com.nepxion.swing.gradient.JGradientPainter;
import com.nepxion.swing.style.framework.IStyle;
import com.nepxion.swing.style.framework.StyleManager;

public class PopupMenuPainter
{
	/**
	 * The instance of JPopupMenu.
	 */
	private JPopupMenu popupMenu;
	
	/**
	 * The title string.
	 */
	private String title;
	
	/**
	 * The width value.
	 */
	private int width;
	
	/**
	 * The instance of Font.
	 */
	private Font font;
	
	/**
	 * The gradient color.
	 */
	private Color gradientColor;
	
	/**
	 * The foreground.
	 */
	private Color foreground;
	
	/**
	 * The background.
	 */
	private Color background;
	
	/**
	 * Constructs with the specified initial title.
	 * @param title the title string
	 */
	public PopupMenuPainter(String title)
	{
		this(title, StyleManager.getStyle());
	}
	
	/**
	 * Constructs with the specified initial style.
	 * @param style the instance of IStyle
	 */
	public PopupMenuPainter(IStyle style)
	{
		this("", style);
	}
	
	/**
	 * Constructs with the specified initial title and style.
	 * @param title the title string
	 * @param style the instance of IStyle
	 */
	public PopupMenuPainter(String title, IStyle style)
	{
		this(title, 25, new Font("Verdana", Font.BOLD, 9), style.getSelectionGradientColor(), style.getSelectionForeground(), style.getSelectionBackground());
	}
	
	/**
	 * Constructs with the specified initial title, width, font, gradient color, foreground and background.
	 * @param title the title string
	 * @param width the width value
	 * @param font the instance of Font
	 * @param gradientColor the gradient color
	 * @param foreground the foreground
	 * @param background the background
	 */
	public PopupMenuPainter(String title, int width, Font font, Color gradientColor, Color foreground, Color background)
	{
		this.font = font;
		this.title = title;
		this.width = width;
		this.font = font;
		this.gradientColor = gradientColor;
		this.foreground = foreground;
		this.background = background;
	}
	
	/**
	 * Gets the title.
	 * @return the title string
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * Sets the title.
	 * @param title the title string
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	/**
	 * Gets the width.
	 * @return the width value
	 */
	public int getWidth()
	{
		return width;
	}
	
	/**
	 * Sets the width.
	 * @param width the width value
	 */
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	/**
	 * Gets the font.
	 * @return the instance of Font
	 */
	public Font getFont()
	{
		return font;
	}
	
	/**
	 * Sets the font.
	 * @param font the instance of Font
	 */
	public void setFont(Font font)
	{
		this.font = font;
	}
	
	/**
	 * Gets the gradient color.
	 * @return the instance of Color
	 */
	public Color getGradientColor()
	{
		return gradientColor;
	}
	
	/**
	 * Sets the gradient color.
	 * @param gradientColor the instance of Color
	 */
	public void setGradientColor(Color gradientColor)
	{
		this.gradientColor = gradientColor;
	}
	
	/**
	 * Gets the foreground.
	 * @return the instance of Color
	 */
	public Color getForeground()
	{
		return foreground;
	}
	
	/**
	 * Sets the foreground.
	 * @param foreground the instance of Color
	 */
	public void setForeground(Color foreground)
	{
		this.foreground = foreground;
	}
	
	/**
	 * Gets the background.
	 * @return the instance of Color
	 */
	public Color getBackground()
	{
		return background;
	}
	
	/**
	 * Sets the background.
	 * @param background the instance of Color
	 */
	public void setBackground(Color background)
	{
		this.background = background;
	}
	
	/**
	 * Gets the popup menu.
	 * @return the instance of JPopupMenu
	 */
	public JPopupMenu getPopupMenu()
	{
		return popupMenu;
	}
	
	/**
	 * Sets the popup menu.
	 * @param popupMenu the instance of JPopupMenu 
	 */
	public void setPopupMenu(JPopupMenu popupMenu)
	{
		this.popupMenu = popupMenu;
	}
	
	/**
	 * Gets the insets.
	 * @param insets the instance of Insets
	 * @return the instance of Insets
	 */
	public Insets getInsets(Insets insets)
	{
		// Insets insets = (Insets) super.getInsets().clone();
		insets.left += width;
		
		return insets;
	}
	
	/**
	 * Gets the text size.
	 * @param text the text string
	 * @param font the instance of Font
	 * @param graphics2D the instance of Graphics2D
	 * @return the instance of Dimension
	 */
	protected Dimension getTextSize(String text, Font font, Graphics2D graphics2D)
	{
		Font graphics2DFont = graphics2D.getFont();
		graphics2D.setFont(font);
		FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
		int i = (int) font.getStringBounds(text, fontRenderContext).getWidth();
		int j = (int) font.getStringBounds(text, fontRenderContext).getHeight();
		graphics2D.setFont(graphics2DFont);
		
		return new Dimension(i, j);
	}
	
	/**
	 * Gets the text offset.
	 * @param text the text string
	 * @param font the instance of Font
	 * @param graphics2D the instance of Graphics2D
	 * @return the offset value.
	 */
	protected int getTextOffset(String text, Font font, Graphics2D graphics2D)
	{
		Font graphics2DFont = graphics2D.getFont();
		graphics2D.setFont(font);
		FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
		int i = (int) font.getStringBounds(text, fontRenderContext).getHeight();
		LineMetrics linemetrics = font.getLineMetrics(text, fontRenderContext);
		int j = (int) linemetrics.getDescent();
		graphics2D.setFont(graphics2DFont);
		
		return i - j;
	}
	
	/**
	 * Paints the string.
	 * @param title the title string
	 * @param graphics2D the instance of Graphics2D
	 * @param x the x value
	 * @param y the y value
	 * @param angle the angle value
	 */
	protected void paintString(String title, Graphics2D graphics2D, double x, double y, double angle)
	{
		graphics2D.translate(x, y);
		graphics2D.rotate(angle);
		graphics2D.drawString(title, 0, 0);
		graphics2D.rotate(-angle);
		graphics2D.translate(-x, -y);
	}
	
	/**
	 * Paints the component.
	 * @param g the instance of Graphics
	 */
	public void paintComponent(Graphics g)
	{
		// super.paintComponent(g);
		
		// Dimension size = getSize();
		Dimension size = popupMenu.getSize();
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle rectangle = new Rectangle(0, 0, width, size.height - PopupMenuManager.getMargin());
		JGradientPainter.fastFill((Graphics2D) g, rectangle, background, gradientColor, true);
		
		// GradientPaint gp = new GradientPaint(0.0F, 0.0F, background, 0.0F, size.height, gradientColor, false);
		// g2.setPaint(gp);
		// g2.fillRect(0, 0, width, size.height - 2);
		
		if (title != null && font != null)
		{
			g2.setColor(foreground);
			g2.setFont(font);
			Dimension textSize = getTextSize(title, font, g2);
			int y = (size.height + textSize.width) / 2;
			int xOffset = getTextOffset(title, font, g2);
			
			if (size.height - textSize.width > 5)
			{
				paintString(title, g2, (width - textSize.height) / 2 + xOffset, y, -1.5707963267948966D);
			}
		}
	}
}