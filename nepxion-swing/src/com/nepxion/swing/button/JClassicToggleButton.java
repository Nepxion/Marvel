package com.nepxion.swing.button;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JToggleButton;

public class JClassicToggleButton
	extends JToggleButton implements IToggleButton
{
	/**
	 * The boolean value of the button is grouped.
	 * If true, the toggle button will be added to a ButtonGroup automatically.
	 */
	protected boolean isGrouped = true;
	
	/**
	 * Constructs with the default.
	 */
	public JClassicToggleButton()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial action.
	 * @param action the instance of Action
	 */
	public JClassicToggleButton(Action action)
	{
		super(action);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text.
	 * @param text the text string
	 */
	public JClassicToggleButton(String text)
	{
		super(text);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial icon.
	 * @param icon the instance of Icon
	 */
	public JClassicToggleButton(Icon icon)
	{
		super(icon);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text and icon.
	 * @param text the text string 
	 * @param icon the icon of Icon
	 */
	public JClassicToggleButton(String text, Icon icon)
	{
		super(text, icon);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text and tooltip text.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 */
	public JClassicToggleButton(String text, String toolTipText)
	{
		super(text);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial text and selected.
	 * @param text the text string
	 * @param selected the boolean value of selected
	 */
	public JClassicToggleButton(String text, boolean selected)
	{
		super(text);
		
		initComponents();
		
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial icon and tooltip text.
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JClassicToggleButton(Icon icon, String toolTipText)
	{
		super(icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial icon and selected.
	 * @param icon the instance of Icon
	 * @param selected the boolean value of selected
	 */
	public JClassicToggleButton(Icon icon, boolean selected)
	{
		super(icon);
		
		initComponents();
		
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial text, icon and tooltip text.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JClassicToggleButton(String text, Icon icon, String toolTipText)
	{
		super(text, icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial text, icon and selected.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param selected the boolean value of selected
	 */
	public JClassicToggleButton(String text, Icon icon, boolean selected)
	{
		super(text, icon);
		
		initComponents();
		
		setSelected(selected);
	}
		
	/**
	 * Constructs with the specified initial text, tooltip text and selected.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 */
	public JClassicToggleButton(String text, String toolTipText, boolean selected)
	{
		super(text);
		
		initComponents();
		
		setToolTipText(toolTipText);
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial icon, tooltip text and selected.
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 */
	public JClassicToggleButton(Icon icon, String toolTipText, boolean selected)
	{
		super(icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial text, icon, tooltip text and selected.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 */
	public JClassicToggleButton(String text, Icon icon, String toolTipText, boolean selected)
	{
		super(text, icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
		setSelected(selected);
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		ButtonManager.setPreferenceStyle(this);
	}
	
	/**
	 * Returns true if the button is grouped.
	 * If true, the toggle button will be added to a ButtonGroup automatically.
	 * @return true if the button is grouped
	 */
	public boolean isGrouped()
	{
		return isGrouped;
	}
	
	/**
	 * Sets the button grouped.
	 * @param isGrouped the boolean value of isGrouped
	 */
	public void setGrouped(boolean isGrouped)
	{
		this.isGrouped = isGrouped;
	}
}