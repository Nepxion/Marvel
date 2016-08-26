package com.nepxion.swing.textfield.number;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Toolkit;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import com.nepxion.swing.locale.SwingLocale;

public class NumberDocument
	extends PlainDocument
{
	public static final int MAXIMUM_LENGTH = 16;
	public static final int DECIMAL_LENGTH = 0;
	
	private int maximumLength;
	private int decimalLength;
	
	private double minimumValue;
	private double maximumValue;
	
	public NumberDocument()
	{
		this(Double.MIN_VALUE);
	}
	
	public NumberDocument(double minimumValue)
	{
		this(minimumValue, Double.MAX_VALUE);
	}
	
	public NumberDocument(int maximumLength, int decimalLength)
	{
		this(maximumLength, decimalLength, Double.MIN_VALUE, Double.MAX_VALUE);
	}
	
	public NumberDocument(double minimumValue, double maximumValue)
	{
		this(MAXIMUM_LENGTH, DECIMAL_LENGTH, minimumValue, maximumValue);
	}
	
	/**
	 * @param maximumLength int    最大长度(含小数位和小数点)
	 * @param decimalLength int    小数位长度
	 * @param minimumValue double  最小值
	 * @param maximumValue double  最大值
	 */
	public NumberDocument(int maximumLength, int decimalLength, double minimumValue, double maximumValue)
	{
		if (maximumLength < 0 || decimalLength < 0)
		{
			throw new IllegalArgumentException(SwingLocale.getString("length_not_less_than_0"));
		}
		
		if (minimumValue >= maximumValue)
		{
			throw new IllegalArgumentException(SwingLocale.getString("minimum_value_not_more_than_or_equal_maximum_value"));
		}
		
		this.maximumLength = maximumLength;
		this.decimalLength = decimalLength;
		this.minimumValue = minimumValue;
		this.maximumValue = maximumValue;
	}
	
	public void insertString(int offset, String value, AttributeSet attributeSet)
		throws BadLocationException
	{
		int length = getLength();
		String text = getText(0, length);
		int decimalIndex = text.indexOf(".");
		if (value.equals("F") || value.equals("f") || value.equals("D") || value.equals("d") || (text + value).length() > maximumLength || (decimalIndex > -1 && offset > decimalIndex && ((text.substring(decimalIndex + 1)) + value).length() > decimalLength) || (text.trim().equals("0") && !value.substring(0, 1).equals(".") && offset != 0) || (value.equals(".") && decimalLength == 0) || (value.indexOf(".") > -1 && value.substring(value.indexOf(".") + 1).length() > decimalLength))
		{
			Toolkit.getDefaultToolkit().beep();
			
			throw new NumberFormatException(SwingLocale.getString("invalid_data_format"));
		}
		try
		{
			text = text.substring(0, offset) + value + text.substring(offset, length);
			if (!text.equals("-"))
			{
				double doubleValue = Double.parseDouble(text);
				if (doubleValue < minimumValue || doubleValue > maximumValue)
				{
					Toolkit.getDefaultToolkit().beep();
					
					throw new IllegalArgumentException(SwingLocale.getString("data_overflow") + " [" + minimumValue + ", " + maximumValue + "]");
				}
			}
			else
			{
				if (minimumValue >= 0)
				{
					Toolkit.getDefaultToolkit().beep();
					throw new NumberFormatException(SwingLocale.getString("invalid_data_format"));
				}
			}
		}
		catch (NumberFormatException e)
		{
			Toolkit.getDefaultToolkit().beep();
			
			throw new NumberFormatException(SwingLocale.getString("invalid_data_format"));
		}
		
		super.insertString(offset, value, attributeSet);
	}
}