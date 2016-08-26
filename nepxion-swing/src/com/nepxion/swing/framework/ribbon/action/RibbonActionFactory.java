package com.nepxion.swing.framework.ribbon.action;

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

import com.nepxion.swing.framework.ribbon.JRibbonContainer;

public class RibbonActionFactory
{	
	/**
	 * Creates the ribbon action.
	 * @param text the text string
	 * @param icon the icon
	 * @param toolTipText the tooltip text string
	 * @param ribbonTitle the ribbon title string
	 * @param ribbonIcon the ribbon icon
	 * @param ribbonToolTipText the ribbon tooltip text string
	 * @param ribbonComponentClass the ribbon component class string
	 * @param ribbonContainer the instance of JRibbonContainer
	 * @return the instance of JRibbonAction
	 */
	public static JRibbonAction createRibbonAction(String text, Icon icon, String toolTipText, String ribbonTitle, Icon ribbonIcon, String ribbonToolTipText, String ribbonComponentClass, JRibbonContainer ribbonContainer)
	{
		return createRibbonAction(null, text, icon, toolTipText, null, ribbonTitle, ribbonIcon, ribbonToolTipText, ribbonComponentClass, ribbonContainer);
	}
	
	/**
	 * Creates the ribbon action.
	 * @param name the name string
	 * @param text the text string
	 * @param icon the icon
	 * @param toolTipText the tooltip text string
	 * @param ribbonName the ribbon name string
	 * @param ribbonTitle the ribbon title string
	 * @param ribbonIcon the ribbon icon
	 * @param ribbonToolTipText the ribbon tooltip text string
	 * @param ribbonComponentClass the ribbon component class string
	 * @param ribbonContainer the instance of JRibbonContainer
	 * @return the instance of JRibbonAction
	 */
	public static JRibbonAction createRibbonAction(String name, String text, Icon icon, String toolTipText, String ribbonName, String ribbonTitle, Icon ribbonIcon, String ribbonToolTipText, String ribbonComponentClass, JRibbonContainer ribbonContainer)
	{
		return createRibbonAction(name, text, null, null, icon, null, null, toolTipText, ribbonName, ribbonTitle, ribbonIcon, ribbonToolTipText, ribbonComponentClass, ribbonContainer);
	}
	
	/**
	 * Creates the ribbon action.
	 * @param name the name string
	 * @param text the text string
	 * @param smallText the small text string
	 * @param largeText the large text string
	 * @param icon the icon
	 * @param smallIcon the small icon
	 * @param largeIcon the large icon
	 * @param toolTipText the tooltip text string
	 * @param ribbonName the ribbon name string
	 * @param ribbonTitle the ribbon title string
	 * @param ribbonIcon the ribbon icon
	 * @param ribbonToolTipText the ribbon tooltip text string
	 * @param ribbonComponentClass the ribbon component class string
	 * @param ribbonContainer the instance of JRibbonContainer
	 * @return the instance of JRibbonAction
	 */
	public static JRibbonAction createRibbonAction(String name, String text, String smallText, String largeText, Icon icon, Icon smallIcon, Icon largeIcon, String toolTipText, String ribbonName, String ribbonTitle, Icon ribbonIcon, String ribbonToolTipText, String ribbonComponentClass, JRibbonContainer ribbonContainer)
	{
		JRibbonAction action = new JRibbonAction(name, text, icon, toolTipText);
		action.setSmallText(smallText);
		action.setLargeText(largeText);
		action.setSmallIcon(smallIcon);
		action.setLargeIcon(largeIcon);
		action.setRibbonName(ribbonName);
		action.setRibbonTitle(ribbonTitle);
		action.setRibbonIcon(ribbonIcon);
		action.setRibbonToolTipText(ribbonToolTipText);
		action.setRibbonComponentClass(ribbonComponentClass);
		action.setRibbonContainer(ribbonContainer);
		
		return action;
	}
}