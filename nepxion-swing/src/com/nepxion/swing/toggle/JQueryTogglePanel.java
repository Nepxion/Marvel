package com.nepxion.swing.toggle;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;

public abstract class JQueryTogglePanel
	extends JThreadTogglePanel
{
	/**
	 * Constructs with the default.
	 * @param queryTarget the query target
	 */
	public JQueryTogglePanel(String queryTarget)
	{
		super(SwingLocale.getString("query_and_wait"));
		
		setToggleBannerIcon(IconFactory.getSwingIcon("banner/edit.png"));
		setInformationText(SwingLocale.getString("query") + " " + SwingLocale.getString("quotation_left") + queryTarget + SwingLocale.getString("quotation_right") + " " + SwingLocale.getString("relative_data"));
		setInformationIcon(IconFactory.getSwingIcon("banner/query_128.png"));
		setErrorText(SwingLocale.getString("query") + " " + SwingLocale.getString("quotation_left") + queryTarget + SwingLocale.getString("quotation_right") + " " + SwingLocale.getString("relative_data_exception"));
		setErrorIcon(IconFactory.getSwingIcon("banner/error_128.png"));
		setThreadPanelWidth(300);
		
		showInformation();
	}
}