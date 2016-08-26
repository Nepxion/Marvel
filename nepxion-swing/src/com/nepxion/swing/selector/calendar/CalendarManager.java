package com.nepxion.swing.selector.calendar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import com.nepxion.swing.combobox.ComboBoxManager;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;

public class CalendarManager
{
	/**
	 * Sets the preference style for the combo box.
	 * @param comboBox the instance of JComboBox
	 */
	public static void setPreferenceStyle(JComboBox comboBox)
	{
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			JComboBox component = new JComboBox();
			
			comboBox.setBorder(component.getBorder());
		}
		else
		{
			ComboBoxManager.setPreferenceStyle(comboBox);
		}
	}
	
	/**
	 * Sets the preference style for the button.
	 * @param button the instance of JButton
	 */
	public static void setPreferenceStyle(JButton button)
	{
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			DimensionManager.setDimension(button, new Dimension(26, 26));
		}
	}
	
	/**
	 * Sets the preference style for the spinner.
	 * @param spinner the instance of JSpinner
	 */
	public static void setPreferenceStyle(JSpinner spinner)
	{
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			JTextField component = new JTextField();
			
			spinner.getEditor().setBorder(component.getBorder());
		}
	}
	
	/**
	 * Gets the calendar selector dialog height.
	 * @return the height value
	 */
	public static int getCalendarSelectorDialogHeight()
	{
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			return 310;
		}
		else
		{	
			return 280;
		}
	}
	
	/**
	 * Gets the day selector dialog height.
	 * @return the height value
	 */
	public static int getDaySelectorDialogHeight()
	{
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			return 280;
		}
		else
		{	
			return 250;
		}
	}	
}