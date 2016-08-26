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
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class TGraphPointBackground
	extends TGraphBackground
{
	private int pointGap = 10;
	private Color pointColor = Color.gray;
	
	public TGraphPointBackground(Color color, Color gradientColor)
	{
		super(color, gradientColor);
	}
	
	public int getPointGap()
	{
		return pointGap;
	}
	
	public void setPointGap(int pointGap)
	{
		this.pointGap = pointGap;
	}
	
	public Color getPointColor()
	{
		return pointColor;
	}
	
	public void setPointColor(Color pointColor)
	{
		this.pointColor = pointColor;
	}
		
	public void paintContent(Graphics2D g, double zoom, Rectangle viewportRect)
	{
		super.paintContent(g, zoom, viewportRect);
		
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(pointColor);
		
		int width = viewportRect.width;
		int height = viewportRect.height;
		
		int xCount = width / pointGap;
		int yCount = height / pointGap;
		
		for (int i = 1; i < xCount; i++)
		{
			for (int j = 1; j < yCount; j++)
			{
				g2d.drawString(".", i * pointGap, j * pointGap);
			}
		}
	}
}