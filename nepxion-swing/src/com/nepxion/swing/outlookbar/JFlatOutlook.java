package com.nepxion.swing.outlookbar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.nepxion.swing.layout.ratio.RatioLayout;

public class JFlatOutlook
	extends JPanel implements SwingConstants
{
	/**
	 * Constructs with the default.
	 */
	public JFlatOutlook()
	{
		setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		setOpaque(false);
		setLayout(new RatioLayout(RatioLayout.VERTICAL, 2));
	}
	
	/**
	 * Adds the button to the outlook.
	 * @param button the instance of AbstractButton
	 */
	public void addButton(AbstractButton button)
	{
		addButton(button, VERTICAL);
	}
	
	/**
	 * Adds the button to the outlook.
	 * @param button the instance of AbstractButton
	 * @param iconTextLayout the icon text layout value
	 */
	public void addButton(AbstractButton button, int iconTextLayout)
	{
		super.add(button);
		
		if (iconTextLayout == VERTICAL)
		{
			button.setHorizontalTextPosition(CENTER);
			button.setVerticalTextPosition(BOTTOM);
		}
		else if (iconTextLayout == HORIZONTAL)
		{
			button.setHorizontalTextPosition(TRAILING);
			button.setVerticalTextPosition(CENTER);
		}
	}
}