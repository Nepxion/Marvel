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

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class JTexturePainter
{
	/**
	 * The texture paint map.
	 */
	private static Map texturePaintMap;
	
	/**
	 * Gets the texture paint from the cache.
	 * @param image the instance of Image
	 * @return the instance of Image
	 */
	public static TexturePaint getCacheTexturePaint(Image image)
	{
		if (texturePaintMap == null)
		{
			texturePaintMap = new HashMap();
		}
		
		TexturePaint texturePaint = (TexturePaint) texturePaintMap.get(image);
		if (texturePaint == null)
		{
			texturePaint = getTexturePaint(image);
		}
		
		texturePaintMap.put(image, texturePaint);
		
		return texturePaint;
	}
	
	/**
	 * Gets the texture paint.
	 * @param image the instance of Image
	 * @return the instance of Image
	 */
	public static TexturePaint getTexturePaint(Image image)
	{
		int imageWidth = image.getWidth(null);
		int imageHeight = image.getHeight(null);
		
		BufferedImage bufferedImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = bufferedImage.createGraphics();
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();
		
		return new TexturePaint(bufferedImage, new Rectangle(0, 0, imageWidth, imageHeight));
	}
}