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

import javax.swing.Icon;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.panel.JPasswordPanel;

public class JUserPreference
	extends JPreference
{	
	/**
	 * The password panel.
	 */
	private JPasswordPanel passwordPanel;
	
	/**
	 * Constructs with the default.
	 */
	public JUserPreference()
	{		
		passwordPanel = new JPasswordPanel();
		passwordPanel.setBorder(BorderManager.createComplexTitledBorder(SwingLocale.getString("modify_password")));

		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 5));
		add(passwordPanel);
	}
	
	/**
	 * Gets the password panel.
	 * @return the instance of JPasswordPanel
	 */
	public JPasswordPanel getPasswordPanel()
	{
		return passwordPanel;
	}
	
	/**
	 * Returns true if it is verified.
	 * @return true if it is verified
	 */
	public boolean verify()
	{
		return passwordPanel.verify();
	}
	
	/**
	 * Gets the toggle text.
	 * @return the toggle text string
	 */
	public String getToggleText()
	{
		return SwingLocale.getString("user_toggle_text");
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
		return IconFactory.getSwingIcon("banner/user.png");
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
		return IconFactory.getSwingIcon("banner/user.png");
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
		return SwingLocale.getString("user_toggle_description");
	}
	
	/**
	 * Sets the toggle description.
	 * @param toggleDescription the toggle description string
	 */
	public void setToggleDescription(String toggleDescription)
	{
		
	}
}