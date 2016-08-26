package com.nepxion.cots.twaver.graph;

/**
 * <p>Title: Nepxion Cots For TWaver</p>
 * <p>Description: Nepxion Cots Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * <p>Announcement: It depends on the commercial software of TWaver, the repository only references the trial version.</p>
 * <p>If you want to use Nepxion Cots, please contact with Serva Corporation to buy the genuine version.</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import twaver.network.background.ColorBackground;

import com.nepxion.swing.font.FontContext;
import com.nepxion.swing.font.FontManager;

public class TGraphBackground
	extends ColorBackground
{	
	public static final Color BLUE_STYLE_COLOR = new Color(172, 193, 212);
	public static final Color GREEN_STYLE_COLOR = new Color(170, 190, 160);
	
	public static final int TOP = 0;
	public static final int BOTTOM = 1;
	
	private String title;
	
	private int titleAlignment = TOP;
	private int titleHorizontalGap = 0;
	private int titleVerticalGap = 0;
	private int titleMaximumHeight = 50;

	private Color titleColor = Color.black;
	private Font titleFont = FontContext.getChartTitleFont();

	public TGraphBackground(Color color, Color gradientColor)
	{		
		setColor(color);
		setGradientColor(gradientColor);
		setGradient(true);	
	}
	
	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public int getTitleAlignment()
	{
		return titleAlignment;
	}

	public void setTitleAlignment(int titleAlignment)
	{
		this.titleAlignment = titleAlignment;
	}
	
	public int getTitleHorizontalGap()
	{
		return titleHorizontalGap;
	}

	public void setTitleHorizontalGap(int titleHorizontalGap)
	{
		this.titleHorizontalGap = titleHorizontalGap;
	}

	public int getTitleVerticalGap()
	{
		return titleVerticalGap;
	}

	public void setTitleVerticalGap(int titleVerticalGap)
	{
		this.titleVerticalGap = titleVerticalGap;
	}
	
	public int getTitleMaximumHeight()
	{
		return titleMaximumHeight;
	}

	public void setTitleMaximumHeight(int titleMaximumHeight)
	{
		this.titleMaximumHeight = titleMaximumHeight;
	}
	
	public Color getTitleColor()
	{
		return titleColor;
	}
	
	public void setTitleColor(Color titleColor)
	{
		this.titleColor = titleColor;
	}
	
	public Font getTitleFont()
	{
		return titleFont;
	}

	public void setTitleFont(Font titleFont)
	{
		this.titleFont = titleFont;
	}

	public void paintContent(Graphics2D g, double zoom, Rectangle viewportRect)
	{
		super.paintContent(g, zoom, viewportRect);
		
		if (title != null && !title.trim().equals(""))
		{	
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setColor(titleColor);
			g2d.setFont(titleFont);
			
			int width = viewportRect.width;
			int height = viewportRect.height;
			
			if (titleAlignment == TOP)
			{	
				FontManager.drawCenterString(g2d, title, width, titleMaximumHeight, titleHorizontalGap, titleVerticalGap);
			}
			else
			{				
				FontManager.drawCenterString(g2d, title, width, titleMaximumHeight, titleHorizontalGap, height - titleMaximumHeight - titleVerticalGap);
			}
		}
	}
}