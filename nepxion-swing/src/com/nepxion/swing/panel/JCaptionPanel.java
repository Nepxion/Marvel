package com.nepxion.swing.panel;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class JCaptionPanel
	extends JPanel implements Runnable, SwingConstants
{	
	private String[] caption;
	
	private BufferedImage image;
	
	private int alignment = TOP;
	
	private int speed = 100;
	
	private int rollOffset = 0;
	
	private Thread internalThread;
	
	private volatile boolean noStopRequested;
	
	private volatile boolean onceRoll = false;
	
	private boolean autoAdaptSize = false;
	
	private boolean isAntialiasing = false;
	
	public JCaptionPanel()
	{
	}
	
	public JCaptionPanel(String[] caption)
	{
		setCaption(caption);
	}
	
	public void run()
	{
		if (getCaption() == null || getCaption().length == 0)
		{
			return;
		}
		
		while (noStopRequested)
		{
			if (image == null)
			{
				SwingUtilities.invokeLater(new Runnable() // invokeAndWait
				{
					public void run()
					{
						rollOffset = getHeight();
						repaint();
					}
				}
				);
				
				if (image == null)
				{
					continue;
				}
				else
				{
					if (isAutoAdaptSize())
					{
						SwingUtilities.invokeLater(new Runnable()
						{
							public void run()
							{
								setSize(new Dimension(image.getWidth(), getHeight()));
							}
						}
						);
					}
				}
			}
			
			if (!onceRoll)
			{
				if (getAlignment() == TOP)
				{
					rollOffset = getHeight();
				}
				else
				{
					rollOffset = -image.getHeight();
				}
				onceRoll = true;
			}
			
			try
			{
				Thread.sleep(getSpeed());
				
				if (image != null)
				{
					if (getAlignment() == TOP)
					{
						rollOffset = (rollOffset - 1) % (getHeight() + image.getHeight());
						if (rollOffset == -image.getHeight())
						{
							rollOffset = getHeight();
						}
					}
					else
					{
						rollOffset = (rollOffset + 1) % (getHeight() + image.getHeight());
						if (rollOffset == getHeight())
						{
							rollOffset = -image.getHeight();
						}
					}
				}
				SwingUtilities.invokeLater(new Runnable()
				{
					public void run()
					{
						repaint();
					}
				}
				);
			}
			catch (InterruptedException e)
			{
				Thread.currentThread().interrupt();
			}
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if (image == null && rollOffset != 0)
		{
			image = generateImage(getCaption(), g, getAlignment(), getBackground(), getForeground(), getFont());
		}
		
		if (image != null)
		{
			g.drawImage(image, 0, rollOffset, this);
		}
	}
	
	private BufferedImage generateImage(String[] caption, Graphics g, int alignment, Color background, Color foreground, Font font)
	{
		if (caption == null || caption.length == 0)
		{
			return null;
		}
		
		if (g == null)
		{
			return null;
		}
		
		if (background == null)
		{
			background = Color.white;
		}
		
		if (foreground == null)
		{
			foreground = Color.black;
		}
		
		Dimension size = getImageSize(caption, g.getFontMetrics());
		
		if (size == null)
		{
			return null;
		}
		
		BufferedImage image = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2d = image.createGraphics();
		
		if (isOpaque())
		{
			g2d.setColor(getBackground());
		}
		else
		{
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR, 0.0f));
		}
		g2d.fillRect(0, 0, size.width, size.height);
		
		if (!isOpaque())
		{
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		}
		
		g2d.setColor(foreground);
		
		int baselineOffset = g.getFontMetrics().getHeight();
		
		// 请求绘制时，打开反锯齿，并运用高质量选项
		if (isAntialiasing)
		{
			RenderingHints renderHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			renderHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			g2d.setRenderingHints(renderHints);
		}
		
		FontRenderContext frc = g2d.getFontRenderContext();
		for (int i = 0; i < caption.length; i++)
		{
			TextLayout textLayout = null;
			
			if (alignment == TOP)
			{
				textLayout = new TextLayout(caption[i], font, frc);
			}
			else
			{
				textLayout = new TextLayout(caption[caption.length - (i + 1)], font, frc);
			}
			
			textLayout.draw(g2d, 0, baselineOffset);
			baselineOffset += g.getFontMetrics().getHeight();
		}
		
		g2d.dispose();
		g2d = null;
		
		return image;
	}
	
	private Dimension getImageSize(String[] caption, FontMetrics fm)
	{
		if (caption == null || caption.length == 0)
		{
			return null;
		}
		
		if (fm == null)
		{
			return null;
		}
		
		int width = 0;
		int height = 0;
		
		width = fm.stringWidth(caption[0]);
		for (int i = 1; i < caption.length; i++)
		{
			if (width < fm.stringWidth(caption[i]))
			{
				width = fm.stringWidth(caption[i]);
			}
		}
		
		height = fm.getHeight() * caption.length + fm.getHeight();
		
		return new Dimension(width, height);
	}
	
	public void start()
	{
		noStopRequested = true;
		internalThread = new Thread(this);
		internalThread.start();
	}
	
	public void stop()
	{
		noStopRequested = false;
		if (internalThread != null)
		{
			internalThread.interrupt();
		}
	}
	
	public void reStart()
	{
		if (internalThread != null && internalThread.isAlive())
		{
			stop();
		}
		
		onceRoll = false;
		
		start();
	}
	
	public int getAlignment()
	{
		return alignment;
	}
	
	public void setAlignment(int alignment)
	{
		this.alignment = alignment;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	public String[] getCaption()
	{
		return caption;
	}
	
	public void setCaption(String[] caption)
	{
		this.caption = caption;
	}
	
	public boolean isAutoAdaptSize()
	{
		return autoAdaptSize;
	}
	
	public void setAutoAdaptSize(boolean autoAdaptSize)
	{
		this.autoAdaptSize = autoAdaptSize;
	}
	
	public boolean isAntialiasing()
	{
		return isAntialiasing;
	}
	
	public void setAntialiasing(boolean isAntialiasing)
	{
		this.isAntialiasing = isAntialiasing;
	}
}