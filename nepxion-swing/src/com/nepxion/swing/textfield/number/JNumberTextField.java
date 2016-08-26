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

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

import com.nepxion.swing.textfield.JBasicTextField;
import com.nepxion.swing.tip.balloon.JBalloonTip;

public class JNumberTextField
	extends JBasicTextField
{
	public JNumberTextField()
	{
		this(Double.MIN_VALUE);
	}
	
	public JNumberTextField(double minimumValue)
	{
		this(minimumValue, Double.MAX_VALUE);
	}
	
	public JNumberTextField(int maximumLength, int decimalLength)
	{
		this(maximumLength, decimalLength, Double.MIN_VALUE, Double.MAX_VALUE);
	}
	
	public JNumberTextField(double minimumValue, double maximumValue)
	{
		this(NumberDocument.MAXIMUM_LENGTH, 0, minimumValue, maximumValue);
	}
	
	public JNumberTextField(int maximumLength, int decimalLength, double minimumValue, double maximumValue)
	{
		super();
		
		setDocument(new NumberDocument(maximumLength, decimalLength, minimumValue, maximumValue)
		{
			public void insertString(int offset, String value, AttributeSet attributeSet)
				throws BadLocationException
			{
				boolean isExclude = exclude(value);
				if (isExclude)
				{
					return;
				}
				
				try
				{
					super.insertString(offset, value, attributeSet);
				}
				catch (NumberFormatException e)
				{
					showTip(e.getMessage(), JBalloonTip.TIP_ICON_ERROR);
				}
				catch (IllegalArgumentException e)
				{
					showTip(e.getMessage(), JBalloonTip.TIP_ICON_WARNING);
				}
			}
		}
		);
	}
	
	public boolean exclude(String value)
	{
		return false;
	}
}