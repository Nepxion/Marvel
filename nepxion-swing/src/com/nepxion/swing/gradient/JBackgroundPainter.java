package com.nepxion.swing.gradient;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TexturePaint;

import javax.swing.ImageIcon;

import com.nepxion.swing.style.texture.ITextureStyle;

public class JBackgroundPainter
{
	/**
	 * Paints the background.
	 * It supports painting the background of a component with a gradient image.
	 * @param c the instance of Component
	 * @param g the instance of Graphics
	 * @param textureStyle the instance of ITextureStyle
	 */
	public static void paintBackground(Component c, Graphics g, ITextureStyle textureStyle)
	{
		ImageIcon backgroundImageIcon = textureStyle.getBackgroundImageIcon();
		ImageIcon backgroundLeftImageIcon = textureStyle.getBackgroundLeftImageIcon();
		ImageIcon backgroundRightImageIcon = textureStyle.getBackgroundRightImageIcon();
		
		paintBackground(c, g, backgroundImageIcon, backgroundLeftImageIcon, backgroundRightImageIcon);
	}
	
	/**
	 * Paints the background.
	 * It supports painting the background of a component with a gradient image.
	 * @param c the instance of Component
	 * @param g the instance of Graphics
	 * @param backgroundImageIcon the background image icon
	 */
	public static void paintBackground(Component c, Graphics g, ImageIcon backgroundImageIcon)
	{
		paintBackground(c, g, JTexturePainter.getCacheTexturePaint(backgroundImageIcon.getImage()));
	}
	
	/**
	 * Paints the background.
	 * It supports painting the background of a component with a gradient image.
	 * @param c the instance of Component
	 * @param g the instance of Graphics
	 * @param backgroundTexturePaint the background texture paint
	 */
	public static void paintBackground(Component c, Graphics g, TexturePaint backgroundTexturePaint)
	{
		paintBackground(c, g, backgroundTexturePaint, null, null);
	}
	
	/**
	 * Paints the background.
	 * It supports painting the background of a component with a gradient image.
	 * @param c the instance of Component
	 * @param g the instance of Graphics
	 * @param backgroundImageIcon the background image icon
	 * @param backgroundLeftImageIcon the background left image icon
	 * @param backgroundRightImageIcon the background right image icon 
	 */
	public static void paintBackground(Component c, Graphics g, ImageIcon backgroundImageIcon, ImageIcon backgroundLeftImageIcon, ImageIcon backgroundRightImageIcon)
	{
		paintBackground(c, g, JTexturePainter.getCacheTexturePaint(backgroundImageIcon.getImage()), backgroundLeftImageIcon, backgroundRightImageIcon);
	}
	
	/**
	 * Paints the background.
	 * It supports painting the background of a component with a gradient image.
	 * @param c the instance of Component
	 * @param g the instance of Graphics
	 * @param backgroundTexturePaint the background texture paint
	 * @param backgroundLeftImageIcon the background left image icon
	 * @param backgroundRightImageIcon the background right image icon 
	 */
	public static void paintBackground(Component c, Graphics g, TexturePaint backgroundTexturePaint, ImageIcon backgroundLeftImageIcon, ImageIcon backgroundRightImageIcon)
	{
		Graphics2D g2d = (Graphics2D) g;
		
		int width = c.getWidth();
		int height = c.getHeight();
		
		g2d.setPaint(backgroundTexturePaint);
		g2d.fillRect(0, 0, width, height);
		
		if (backgroundLeftImageIcon != null)
		{
			g2d.drawImage(backgroundLeftImageIcon.getImage(), 0, 0, null);
		}
		
		if (backgroundRightImageIcon != null)
		{
			int x = width - backgroundRightImageIcon.getImage().getWidth(null);
			int y = 0;
			g2d.drawImage(backgroundRightImageIcon.getImage(), x, y, null);
		}
	}
}