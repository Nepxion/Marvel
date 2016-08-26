package com.nepxion.swing.color;

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

import javax.swing.LookAndFeel;
import javax.swing.UIManager;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;

public class ColorUtil
{
	/**
	 * Transforms the rgb color to 16 bit value.
	 * @param red the red value
	 * @param green the green value
	 * @param blue the blue value
	 * @return the 16 bit string
	 */
	public static String transformTo16Bit(int red, int green, int blue)
	{
		return Integer.toHexString(red) + Integer.toHexString(green) + Integer.toHexString(blue);
	}
	
	/**
	 * Gets the color by the decode string. 
	 * The decode string is the same as "#CFE2F8".
	 * @param decode the decode string
	 * @return Color the instance of Color
	 */
	public static Color getColor(String decode)
	{
		return Color.decode(decode);
	}
	
	/**
	 * Gets the color from UIManager.
	 * @param key the key string
	 * @return the instance of Color
	 */
	public static Color getUIManagerColor(String key)
	{
		Color background = UIManager.getColor(key);
		
		return new Color(background.getRed(), background.getGreen(), background.getBlue(), background.getAlpha());
	}
	
	/**
	 * Gets the random color.
	 * @return the instance of Color
	 */
	public static Color getRandomColor()
	{
		return new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
	}
	
	/**
	 * Gets the hsb offsets between color1 and color2.
	 * @param color1 the instance of Color
	 * @param color2 the instance of Color
	 * @return the float array
	 */
	public static float[] getHSBOffsets(Color color1, Color color2)
	{
		float[] colorHSB1 = Color.RGBtoHSB(color1.getRed(), color1.getGreen(), color1.getBlue(), null);
		float[] colorHSB2 = Color.RGBtoHSB(color2.getRed(), color2.getGreen(), color2.getBlue(), null);
		
		return new float[] {colorHSB1[0] - colorHSB2[0], colorHSB1[1] - colorHSB2[1], colorHSB1[2] - colorHSB2[2]};
	}
	
	/**
	 * Gets the derived color by a color.
	 * The derived color only supports Nimbus LookAndFeel.
	 * @param color the instance of Color
	 * @return the instance of DerivedColor
	 */
	public static Color getDerivedColor(Color color)
	{
		LookAndFeel lookAndFeel = UIManager.getLookAndFeel();
		if (!(lookAndFeel instanceof NimbusLookAndFeel))
		{
			throw new IllegalArgumentException("The derived color only supports Nimbus LookAndFeel");
		}
		
		NimbusLookAndFeel nimbusLookAndFeel = (NimbusLookAndFeel) lookAndFeel;
		
		Color baseColor = UIManager.getColor("nimbusBase");
		
		float[] hsbOffsets = getHSBOffsets(color, baseColor);
		
		Color derivedColor = nimbusLookAndFeel.getDerivedColor("nimbusBase", hsbOffsets[0], hsbOffsets[1], hsbOffsets[2], 0, true);
		
		return derivedColor;
	}
}