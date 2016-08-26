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

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JPanel;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.radiobutton.JBasicRadioButton;

public class JLazyLoaderPreference
	extends JPreference
{
	/**
	 * The sync load strategy radio button.
	 */
	private JBasicRadioButton syncLoadStrategyRadioButton;
	
	/**
	 * The asyn load strategy radio button.
	 */
	private JBasicRadioButton asynLoadStrategyRadioButton;
	
	/**
	 * Constructs with the default.
	 */
	public JLazyLoaderPreference()
	{
		syncLoadStrategyRadioButton = new JBasicRadioButton(SwingLocale.getString("sync_loader_strategy"), true);
		asynLoadStrategyRadioButton = new JBasicRadioButton(SwingLocale.getString("asyn_loader_strategy"), false);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(syncLoadStrategyRadioButton);
		buttonGroup.add(asynLoadStrategyRadioButton);
		
		JPanel loadStrategyPanel = new JPanel();
		loadStrategyPanel.setLayout(new FiledLayout(FiledLayout.ROW, FiledLayout.LEFT, 5));
		loadStrategyPanel.setBorder(BorderManager.createComplexTitledBorder(SwingLocale.getString("loader_strategy")));
		loadStrategyPanel.add(syncLoadStrategyRadioButton);
		loadStrategyPanel.add(asynLoadStrategyRadioButton);
		
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 5));
		add(loadStrategyPanel);
	}
	
	/**
	 * Returns true if the lazy loader is synchronized. 
	 * @return true if the lazy loader is synchronized
	 */
	public boolean isSynchronized()
	{
		return syncLoadStrategyRadioButton.isSelected();
	}
	
	/**
	 * Returns true if it is verified.
	 * @return true if it is verified
	 */
	public boolean verify()
	{
		return true;
	}
	
	/**
	 * Gets the toggle text.
	 * @return the toggle text string
	 */
	public String getToggleText()
	{
		return SwingLocale.getString("loader_toggle_text");
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
		return IconFactory.getSwingIcon("banner/query.png");
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
		return IconFactory.getSwingIcon("banner/query.png");
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
		return SwingLocale.getString("loader_toggle_description");
	}
	
	/**
	 * Sets the toggle description.
	 * @param toggleDescription the toggle description string
	 */
	public void setToggleDescription(String toggleDescription)
	{
		
	}
}