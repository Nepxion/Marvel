package com.nepxion.swing.label;

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
import java.awt.Stroke;

import com.jidesoft.swing.StyleRange;

public class JStyleRange
	extends StyleRange
{
	/**
     * Constructs with the specified initial font style.
     * @param fontStyle the valid values are Font.PLAIN, Font.ITALIC, Font.BOLD or Font.BOLD | Font.ITALIC
     */	
	public JStyleRange(int fontStyle)
	{
		super(fontStyle);
	}
	
	/**
     * Constructs with the specified initial font color.
     * @param fontColor the color of the text
     */	
	public JStyleRange(Color fontColor)
	{
		super(fontColor);
	}
	
	/**
     * Constructs with the specified initial font style and font color.
     * @param fontStyle the valid values are Font.PLAIN, Font.ITALIC, Font.BOLD or Font.BOLD | Font.ITALIC
     * @param fontColor the color of the text
     */	
	public JStyleRange(int fontStyle, Color fontColor)
	{
		super(fontStyle, fontColor);
	}
	
	/**
     * Constructs with the specified initial font style and additional style.
     * @param fontStyle the valid values are Font.PLAIN, Font.ITALIC, Font.BOLD or Font.BOLD | Font.ITALIC
     * @param additionalStyle the valid additional styles are defined as constants in {@link StyleRange}. The names begin 
     * with STYLE_. You can also use bitwise OR "|" to concatenate any two or more styles as long as it makes sense
     */	
	public JStyleRange(int fontStyle, int additionalStyle)
	{
		super(fontStyle, additionalStyle);
	}
	
	/**
     * Constructs with the specified initial font style, additional style and font shrink ratio.
     * @param fontStyle the valid values are Font.PLAIN, Font.ITALIC, Font.BOLD or Font.BOLD | Font.ITALIC
     * @param additionalStyle the valid additional styles are defined as constants in {@link StyleRange}. The names begin 
     * with STYLE_. You can also use bitwise OR "|" to concatenate any two or more styles as long as it makes sense
     * @param fontShrinkRatio the ratio that regular font size divides by subscript or superscript font size
     */	
	public JStyleRange(int fontStyle, int additionalStyle, float fontShrinkRatio)
	{
		super(fontStyle, additionalStyle, fontShrinkRatio);
	}
	
	/**
     * Constructs with the specified initial start, length and font style.
     * @param start the start index of the range in a string
     * @param length the length of the range
     * @param fontStyle the valid values are Font.PLAIN, Font.ITALIC, Font.BOLD or Font.BOLD | Font.ITALIC
     */	
	public JStyleRange(int start, int length, int fontStyle)
	{
		super(start, length, fontStyle);
	}
	
	/**
     * Constructs with the specified initial start, length, font style and font color.
     * @param start the start index of the range in a string
     * @param length the length of the range
     * @param fontStyle the valid values are Font.PLAIN, Font.ITALIC, Font.BOLD or Font.BOLD | Font.ITALIC
     * @param fontColor the color of the text
     */	
	public JStyleRange(int start, int length, int fontStyle, Color fontColor)
	{
		super(start, length, fontStyle, fontColor);
	}
	
	/**
     * Constructs with the specified initial start, length and font color.
     * @param start the start index of the range in a string
     * @param length the length of the range
     * @param fontColor the color of the text
     */	
	public JStyleRange(int start, int length, Color fontColor)
	{
		super(start, length, fontColor);
	}
	
	/**
     * Constructs with the specified initial start, length, font style and additional style.
     * @param start the start index of the range in a string
     * @param length the length of the range
     * @param fontStyle the valid values are Font.PLAIN, Font.ITALIC, Font.BOLD or Font.BOLD | Font.ITALIC
     * @param additionalStyle the valid additional styles are defined as constants in {@link StyleRange}. The names begin 
     * with STYLE_. You can also use bitwise OR "|" to concatenate any two or more styles as long as it makes sense
     */
	public JStyleRange(int start, int length, int fontStyle, int additionalStyle)
	{
		super(start, length, fontStyle, additionalStyle);
	}
	
	/**
     * Constructs with the specified initial start, length, font style, font color, background color, additional style, line color, line stroke and font shrink ratio.
     * @param start the start index of the range in a string
     * @param length the length of the range
     * @param fontStyle the valid values are Font.PLAIN, Font.ITALIC, Font.BOLD or Font.BOLD | Font.ITALIC
     * @param additionalStyle the valid additional styles are defined as constants in {@link StyleRange}. The names begin 
     * with STYLE_. You can also use bitwise OR "|" to concatenate any two or more styles as long as it makes sense
     * @param fontShrinkRatio the ratio that regular font size divides by subscript or superscript font size
     */	
	public JStyleRange(int start, int length, int fontStyle, int additionalStyle, float fontShrinkRatio)
	{
		super(start, length, fontStyle, additionalStyle, fontShrinkRatio);
	}
	
	/**
     * Constructs with the specified initial font style, font color, additional style and line color.
     * @param fontStyle the valid values are Font.PLAIN, Font.ITALIC, Font.BOLD or Font.BOLD | Font.ITALIC
     * @param fontColor the color of the text
     * @param additionalStyle the valid additional styles are defined as constants in {@link StyleRange}. The names begin 
     * with STYLE_. You can also use bitwise OR "|" to concatenate any two or more styles as long as it makes sense
     * @param lineColor the color of the line
     */	
	public JStyleRange(int fontStyle, Color fontColor, int additionalStyle, Color lineColor)
	{
		super(fontStyle, fontColor, additionalStyle, lineColor);
	}
	
	/**
     * Constructs with the specified initial font style, font color, background color, additional style and line color.
     * @param fontStyle the valid values are Font.PLAIN, Font.ITALIC, Font.BOLD or Font.BOLD | Font.ITALIC
     * @param fontColor the color of the text
     * @param backgroundColor the background color of the text
     * @param additionalStyle the valid additional styles are defined as constants in {@link StyleRange}. The names begin 
     * with STYLE_. You can also use bitwise OR "|" to concatenate any two or more styles as long as it makes sense
     * @param lineColor the color of the line
     */	
	public JStyleRange(int fontStyle, Color fontColor, Color backgroundColor, int additionalStyle, Color lineColor)
	{
		super(fontStyle, fontColor, backgroundColor, additionalStyle, lineColor);
	}
	
	/**
     * Constructs with the specified initial start, length, font style, font color, background color, additional style, line color, line stroke and font shrink ratio.
     * @param start the start index of the range in a string
     * @param length the length of the range
     * @param fontStyle the valid values are Font.PLAIN, Font.ITALIC, Font.BOLD or Font.BOLD | Font.ITALIC
     * @param fontColor the color of the text
     * @param additionalStyle the valid additional styles are defined as constants in {@link StyleRange}. The names begin 
     * with STYLE_. You can also use bitwise OR "|" to concatenate any two or more styles as long as it makes sense
     */	
	public JStyleRange(int start, int length, int fontStyle, Color fontColor, int additionalStyle)
	{
		super(start, length, fontStyle, fontColor, additionalStyle);
	}
	
	/**
     * Constructs with the specified initial start, length, font style, font color, background color and additional style.
     * @param start the start index of the range in a string
     * @param length the length of the range
     * @param fontStyle the valid values are Font.PLAIN, Font.ITALIC, Font.BOLD or Font.BOLD | Font.ITALIC
     * @param fontColor the color of the text
     * @param backgroundColor the background color of the text
     * @param additionalStyle the valid additional styles are defined as constants in {@link StyleRange}. The names begin 
     * with STYLE_. You can also use bitwise OR "|" to concatenate any two or more styles as long as it makes sense
     */	
	public JStyleRange(int start, int length, int fontStyle, Color fontColor, Color backgroundColor, int additionalStyle)
	{
		super(start, length, fontStyle, fontColor, backgroundColor, additionalStyle);
	}
	
	/**
     * Constructs with the specified initial font style, font color, additional style, line color and line stroke.
     * @param fontStyle the valid values are Font.PLAIN, Font.ITALIC, Font.BOLD or Font.BOLD | Font.ITALIC
     * @param fontColor the color of the text
     * @param additionalStyle the valid additional styles are defined as constants in {@link StyleRange}. The names begin 
     * with STYLE_. You can also use bitwise OR "|" to concatenate any two or more styles as long as it makes sense
     * @param lineColor the color of the line
     * @param lineStroke the stroke of the line
     * @param fontShrinkRatio the ratio that regular font size divides by subscript or superscript font size
     */	
	
	public JStyleRange(int fontStyle, Color fontColor, int additionalStyle, Color lineColor, Stroke lineStroke)
	{
		super(fontStyle, fontColor, additionalStyle, lineColor, lineStroke);
	}
	
	/**
     * Constructs with the specified initial start, length, font style, font color, additional style and line color,.
     * @param start the start index of the range in a string
     * @param length the length of the range
     * @param fontStyle the valid values are Font.PLAIN, Font.ITALIC, Font.BOLD or Font.BOLD | Font.ITALIC
     * @param fontColor the color of the text
     * @param additionalStyle the valid additional styles are defined as constants in {@link StyleRange}. The names begin 
     * with STYLE_. You can also use bitwise OR "|" to concatenate any two or more styles as long as it makes sense
     * @param lineColor the color of the line
     */
	public JStyleRange(int start, int length, int fontStyle, Color fontColor, int additionalStyle, Color lineColor)
	{
		super(start, length, fontStyle, fontColor, additionalStyle, lineColor);
	}
	
	/**
     * Constructs with the specified initial start, length, font style, font color, background color, additional style, line color.
     * @param start the start index of the range in a string
     * @param length the length of the range
     * @param fontStyle the valid values are Font.PLAIN, Font.ITALIC, Font.BOLD or Font.BOLD | Font.ITALIC
     * @param fontColor the color of the text
     * @param backgroundColor the background color of the text
     * @param additionalStyle the valid additional styles are defined as constants in {@link StyleRange}. The names begin 
     * with STYLE_. You can also use bitwise OR "|" to concatenate any two or more styles as long as it makes sense
     * @param lineColor the color of the line
     */	
	public JStyleRange(int start, int length, int fontStyle, Color fontColor, Color backgroundColor, int additionalStyle, Color lineColor)
	{
		super(start, length, fontStyle, fontColor, backgroundColor, additionalStyle, lineColor);
	}
	
	/**
     * Constructs with the specified initial start, length, font style, font color, additional style, line color and line stroke.
     * @param start the start index of the range in a string
     * @param length the length of the range
     * @param fontStyle the valid values are Font.PLAIN, Font.ITALIC, Font.BOLD or Font.BOLD | Font.ITALIC
     * @param fontColor the color of the text
     * @param additionalStyle the valid additional styles are defined as constants in {@link StyleRange}. The names begin 
     * with STYLE_. You can also use bitwise OR "|" to concatenate any two or more styles as long as it makes sense
     * @param lineColor the color of the line
     * @param lineStroke the stroke of the line
     */	
	public JStyleRange(int start, int length, int fontStyle, Color fontColor, int additionalStyle, Color lineColor, Stroke lineStroke)
	{
		super(start, length, fontStyle, fontColor, additionalStyle, lineColor, lineStroke);
	}
	
	/**
     * Constructs with the specified initial start, length, font style, font color, background color, additional style, line color and line stroke.
     * @param start the start index of the range in a string
     * @param length the length of the range
     * @param fontStyle the valid values are Font.PLAIN, Font.ITALIC, Font.BOLD or Font.BOLD | Font.ITALIC
     * @param fontColor the color of the text
     * @param backgroundColor the background color of the text
     * @param additionalStyle the valid additional styles are defined as constants in {@link StyleRange}. The names begin 
     * with STYLE_. You can also use bitwise OR "|" to concatenate any two or more styles as long as it makes sense
     * @param lineColor the color of the line
     * @param lineStroke the stroke of the line
     */	
	public JStyleRange(int start, int length, int fontStyle, Color fontColor, Color backgroundColor, int additionalStyle, Color lineColor, Stroke lineStroke)
	{
		super(start, length, fontStyle, fontColor, backgroundColor, additionalStyle, lineColor, lineStroke);
	}
	
	/**
     * Constructs with the specified initial start, length, font style, font color, additional style, line color, line stroke and font shrink ratio.
     * @param start the start index of the range in a string
     * @param length the length of the range
     * @param fontStyle the valid values are Font.PLAIN, Font.ITALIC, Font.BOLD or Font.BOLD | Font.ITALIC
     * @param fontColor the color of the text
     * @param additionalStyle the valid additional styles are defined as constants in {@link StyleRange}. The names begin 
     * with STYLE_. You can also use bitwise OR "|" to concatenate any two or more styles as long as it makes sense
     * @param lineColor the color of the line
     * @param lineStroke the stroke of the line
     * @param fontShrinkRatio the ratio that regular font size divides by subscript or superscript font size
     */	
	public JStyleRange(int start, int length, int fontStyle, Color fontColor, int additionalStyle, Color lineColor, Stroke lineStroke, float fontShrinkRatio)
	{
		super(start, length, fontStyle, fontColor, additionalStyle, lineColor, lineStroke, fontShrinkRatio);
	}
	
	/**
     * Constructs with the specified initial start, length, font style, font color, background color, additional style, line color, line stroke and font shrink ratio.
     * @param start the start index of the range in a string
     * @param length the length of the range
     * @param fontStyle the valid values are Font.PLAIN, Font.ITALIC, Font.BOLD or Font.BOLD | Font.ITALIC
     * @param fontColor the color of the text
     * @param backgroundColor the background color of the text
     * @param additionalStyle the valid additional styles are defined as constants in {@link StyleRange}. The names begin 
     * with STYLE_. You can also use bitwise OR "|" to concatenate any two or more styles as long as it makes sense
     * @param lineColor the color of the line
     * @param lineStroke the stroke of the line
     * @param fontShrinkRatio the ratio that regular font size divides by subscript or superscript font size
     */	
	public JStyleRange(int start, int length, int fontStyle, Color fontColor, Color backgroundColor, int additionalStyle, Color lineColor, Stroke lineStroke, float fontShrinkRatio)
	{
		super(start, length, fontStyle, fontColor, backgroundColor, additionalStyle, lineColor, lineStroke, fontShrinkRatio);
	}
}