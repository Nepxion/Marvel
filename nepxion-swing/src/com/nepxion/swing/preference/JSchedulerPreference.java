package com.nepxion.swing.preference;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JPanel;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.checkbox.JBasicCheckBox;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.panel.JTimePanel;

public class JSchedulerPreference
	extends JPreference
{
	/**
	 * The instance of JTimePanel.
	 */
	private JTimePanel timePanel;
	
	/**
	 * The instance of JBasicCheckBox.
	 */
	private JBasicCheckBox bubbleTipCheckBox;
	
	/**
	 * Constructs with the default.
	 */
	public JSchedulerPreference()
	{
		timePanel = new JTimePanel(JTimePanel.VERTICAL);
		timePanel.setInterval(new int[] {0, 0, 0, 15, 0});
		timePanel.showMilliSecond(false);
		timePanel.setBorder(BorderManager.createComplexTitledBorder(SwingLocale.getString("timer_interval")));
		
		bubbleTipCheckBox = new JBasicCheckBox(SwingLocale.getString("timer_bubble_tip"), true);
		bubbleTipCheckBox.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel scheduleMessagePanel = new JPanel();
		scheduleMessagePanel.setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.LEFT, 5));
		scheduleMessagePanel.setBorder(BorderManager.createComplexTitledBorder(SwingLocale.getString("timer_message_hint")));
		scheduleMessagePanel.add(bubbleTipCheckBox);
		
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 5));
		add(timePanel);
		add(scheduleMessagePanel);
	}
	
	/**
	 * Gets the time panel.
	 * @return the instance of JTimePanel
	 */
	public JTimePanel getTimePanel()
	{
		return timePanel;
	}
	
	/**
	 * Gets the interval.
	 * @return the interval array value.
	 */
	public int[] getInterval()
	{
		return timePanel.getInterval();
	}
	
	/**
	 * Returns true the bubble tip showing.
	 * @return true the bubble tip showing 
	 */
	public boolean isBubbleTipShown()
	{
		return bubbleTipCheckBox.isSelected();
	}
	
	/**
	 * Returns true if it is verified.
	 * @return true if it is verified
	 */
	public boolean verify()
	{
		return timePanel.verify();
	}
	
	/**
	 * Gets the toggle text.
	 * @return the toggle text string
	 */
	public String getToggleText()
	{
		return SwingLocale.getString("scheduler_toggle_text");
	}
	
	/**
	 * Sets the toggle text.
	 * @param toggleText the toggle text string
	 */
	public void setToggleText(String toggleText)
	{
		
	}
	
	/**
	 * Gets the toggle icon.
	 * @return the instance of Icon
	 */
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("banner/timer.png");
	}
	
	/**
	 * Sets the toggle icon.
	 * @param toggleIcon the instance of Icon
	 */
	public void setToggleIcon(Icon toggleIcon)
	{
		
	}
	
	/**
	 * Gets the toggle banner icon.
	 * @return the instance of Icon
	 */
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("banner/timer.png");
	}
	
	/**
	 * Sets the toggle banner icon.
	 * @param toggleBannerIcon the instance of Icon
	 */
	public void setToggleBannerIcon(Icon toggleBannerIcon)
	{
		
	}
	
	/**
	 * Gets the toggle description.
	 * @return the toggle description string
	 */
	public String getToggleDescription()
	{
		return SwingLocale.getString("scheduler_toggle_description");
	}
	
	/**
	 * Sets the toggle description.
	 * @param toggleDescription the toggle description string
	 */
	public void setToggleDescription(String toggleDescription)
	{
		
	}
}