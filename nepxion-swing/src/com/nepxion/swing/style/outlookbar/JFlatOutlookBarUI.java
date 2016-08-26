package com.nepxion.swing.style.outlookbar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.l2fprod.common.swing.plaf.windows.WindowsOutlookBarUI;

public class JFlatOutlookBarUI
	extends WindowsOutlookBarUI
{
	/**
	 * The instance of JFlatOutlookBarButtonUI.
	 */
	private JFlatOutlookBarButtonUI buttonUI;
	
	/**
	 * Constructs with the default.
	 */
	public JFlatOutlookBarUI()
	{
		super();
		
		buttonUI = new JFlatOutlookBarButtonUI();
	}
	
	/**
	 * Updates the tab button by an index.
	 * @param index the tab index.
	 */
	protected void updateTabButtonAt(int index)
	{
		super.updateTabButtonAt(index);
		
		TabButton button = buttonForTab(index);
		button.setIconTextGap(5);
		button.setUI(buttonUI);
	}
	
	/**
	 * Gets the button ui.
	 * @return the instance of JFlatOutlookBarButtonUI
	 */
	public JFlatOutlookBarButtonUI getButtonUI()
	{
		return buttonUI;
	}
}