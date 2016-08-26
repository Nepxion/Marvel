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

import java.awt.event.ActionEvent;

import javax.swing.Icon;

import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.exception.ExceptionTracer;
import com.nepxion.swing.framework.ribbon.IRibbonComponent;
import com.nepxion.swing.framework.ribbon.JRibbonContainer;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.locale.SwingLocale;

public class JRibbonAction
	extends JSecurityAction
{
	/**
	 * The instance of JRibbonContainer.
	 */
	private JRibbonContainer ribbonContainer;
	
	/**
	 * The ribbon name string.
	 */
	private String ribbonName;
	
	/**
	 * The ribbon title string.
	 */
	private String ribbonTitle;
	
	/**
	 * The ribbon icon.
	 */
	private Icon ribbonIcon;
	
	/**
	 * The ribbon tooltip text string.
	 */
	private String ribbonToolTipText;
	
	/**
	 * The ribbon component class string.
	 */
	private String ribbonComponentClass;
	
	/**
	 * The instance of IRibbonComponent.
	 */
	private IRibbonComponent ribbonComponent;
	
	/**
	 * Constructs with the default.
	 */
	public JRibbonAction()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial text.
	 * @param text the text string
	 */
	public JRibbonAction(String text)
	{
		super(text);
	}
	
	/**
	 * Constructs with the specified initial icon.
	 * @param icon the instance of Icon
	 */
	public JRibbonAction(Icon icon)
	{
		super(icon);
	}
	
	/**
	 * Constructs with the specified initial text and icon.
	 * @param text the text string
	 * @param icon the instance of Icon
	 */
	public JRibbonAction(String text, Icon icon)
	{
		super(text, icon);
	}
	
	/**
	 * Constructs with the specified initial text and tooltip text.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 */
	public JRibbonAction(String text, String toolTipText)
	{
		super(text, toolTipText);
	}
	
	/**
	 * Constructs with the specified initial icon and tooltip text.
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JRibbonAction(Icon icon, String toolTipText)
	{
		super(icon, toolTipText);
	}

	/**
	 * Constructs with the specified initial text, icon and tooltip text.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JRibbonAction(String text, Icon icon, String toolTipText)
	{
		super(text, icon, toolTipText);
	}
	
	/**
	 * Constructs with the specified initial name, text and tooltip text.
	 * @param name the name string
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 */
	public JRibbonAction(String name, String text, String toolTipText)
	{
		super(name, text, toolTipText);
	}
	
	/**
	 * Constructs with the specified initial name, text, icon and tooltip text.
	 * @param name the name string
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JRibbonAction(String name, String text, Icon icon, String toolTipText)
	{
		super(name, text, icon, toolTipText);
	}
	
	/**
	 * Gets the ribbon container.
	 * @return the instance of JRibbonContainer
	 */
	public JRibbonContainer getRibbonContainer()
	{
		return ribbonContainer;
	}
	
	/**
	 * Sets the ribbon container.
	 * @param ribbonContainer the instance of JRibbonContainer
	 */
	public void setRibbonContainer(JRibbonContainer ribbonContainer)
	{
		this.ribbonContainer = ribbonContainer;
	}
	
	/**
	 * Gets the ribbon name.
	 * @return the ribbon name string
	 */
	public String getRibbonName()
	{
		return ribbonName;
	}
	
	/**
	 * Sets the ribbon name.
	 * @param ribbonName the ribbon name string
	 */
	public void setRibbonName(String ribbonName)
	{
		this.ribbonName = ribbonName;
	}
	
	/**
	 * Gets the ribbon title.
	 * @return the ribbon title string
	 */
	public String getRibbonTitle()
	{
		return ribbonTitle;
	}
	
	/**
	 * Sets the ribbon title.
	 * @param ribbonTitle the ribbon title string
	 */
	public void setRibbonTitle(String ribbonTitle)
	{
		this.ribbonTitle = ribbonTitle;
	}
	
	/**
	 * Gets the ribbon icon.
	 * @return the instance of Icon
	 */
	public Icon getRibbonIcon()
	{
		return ribbonIcon;
	}
	
	/**
	 * Sets the ribbon icon.
	 * @param ribbonIcon the instance of Icon
	 */
	public void setRibbonIcon(Icon ribbonIcon)
	{
		this.ribbonIcon = ribbonIcon;
	}
	
	/**
	 * Gets the ribbon tooltip text.
	 * @return the ribbon tooltip text string
	 */
	public String getRibbonToolTipText()
	{
		return ribbonToolTipText;
	}
	
	/**
	 * Sets the ribbon tooltip text.
	 * @param ribbonToolTipText the ribbon tooltip text string
	 */
	public void setRibbonToolTipText(String ribbonToolTipText)
	{
		this.ribbonToolTipText = ribbonToolTipText;
	}
	
	/**
	 * Gets the ribbon component class.
	 * @return the ribbon component class string
	 */
	public String getRibbonComponentClass()
	{
		return ribbonComponentClass;
	}
	
	/**
	 * Sets the ribbon component class.
	 * @param ribbonComponentClass the ribbon component class string
	 */
	public void setRibbonComponentClass(String ribbonComponentClass)
	{
		this.ribbonComponentClass = ribbonComponentClass;
	}
	
	/**
	 * Gets the ribbon component.
	 * @return the instance of IRibbonComponent
	 */
	public IRibbonComponent getRibbonComponent()
	{
		return ribbonComponent;
	}
	
	/**
	 * Sets the ribbon component.
	 * @param ribbonComponent the instance of IRibbonComponent
	 */
	public void setRibbonComponent(IRibbonComponent ribbonComponent)
	{
		this.ribbonComponent = ribbonComponent;
	}
	
    /**
     * Invoked when an action occurs.
     * @param e the instance of ActionEvent
     */
	public void execute(ActionEvent e)
	{		
		if (ribbonComponent == null)
		{			
			try
			{
				ribbonComponent = (IRibbonComponent) Class.forName(ribbonComponentClass).newInstance();
			}
			catch (NullPointerException ex)
			{				
				ExceptionTracer.traceException(HandleManager.getFrame(ribbonContainer), SwingLocale.getString("component_initialization_failed") + " [" + ribbonComponentClass + "]", ex);
			
				ex.printStackTrace();
				
				return;
			}
			catch (ClassCastException ex)
			{
				ExceptionTracer.traceException(HandleManager.getFrame(ribbonContainer), SwingLocale.getString("component_implementation_failed") + " " + IRibbonComponent.class.getSimpleName() + " [" + ribbonComponentClass + "]", ex);
				
				ex.printStackTrace();
				
				return;
			}
			catch (Exception ex)
			{
				ExceptionTracer.traceException(HandleManager.getFrame(ribbonContainer), SwingLocale.getString("component_instantiation_failed") + " [" + ribbonComponentClass + "]", ex);
				
				ex.printStackTrace();
				
				return;
			}
		}
		
		ribbonContainer.addRibbonComponent(ribbonName, ribbonTitle, ribbonIcon, ribbonToolTipText, ribbonComponent);
	}
}