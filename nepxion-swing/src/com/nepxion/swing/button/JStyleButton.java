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

import java.awt.Dimension;
import java.awt.event.HierarchyEvent;

import javax.swing.Action;
import javax.swing.Icon;

import com.jidesoft.swing.JideButton;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.listener.DisplayAbilityListener;

public class JStyleButton
	extends JideButton implements IButton
{
	/**
	 * The button width inset value.
	 */
	protected int widthInset = ButtonConstants.DEFAULT_BUTTON_WIDTH_INSET;
	
	/**
	 * The button height inset value.
	 */
	protected int heightInset = ButtonConstants.DEFAULT_BUTTON_HEIGHT_INSET;
	
	/**
	 * The boolean value of the button dimension is adaptive.
	 * If true, It will be executed to set the button dimension by its preferred size and inset fitly.
	 */
	protected boolean isDimensionAdaptive = true;
	
	/**
	 * Constructs with the default.
	 */
	public JStyleButton()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial action.
	 * @param action the instance of Action
	 */
	public JStyleButton(Action action)
	{
		super(action);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text.
	 * @param text the text string
	 */
	public JStyleButton(String text)
	{
		super(text);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial icon.
	 * @param icon the instance of Icon
	 */
	public JStyleButton(Icon icon)
	{
		super(icon);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text and icon.
	 * @param text the text string 
	 * @param icon the icon of Icon
	 */
	public JStyleButton(String text, Icon icon)
	{
		super(text, icon);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text and tooltip text.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 */
	public JStyleButton(String text, String toolTipText)
	{
		super(text);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial icon and tooltip text.
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JStyleButton(Icon icon, String toolTipText)
	{
		super(icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial text and icon.
	 * @param text the text string 
	 * @param icon the icon of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JStyleButton(String text, Icon icon, String toolTipText)
	{
		super(text, icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		addHierarchyListener(new DisplayAbilityListener()
		{
			public void displayAbilityChanged(HierarchyEvent e)
			{
				adaptDimension();
				
				removeHierarchyListener(this);
			}
		}
		);
	}
	
	/**
	 * Adapts the dimension.
	 * If the boolean value of isDimensionAdaptive is true, 
	 * it will be executed to set the button dimension by its preferred size and inset fitly. 
	 */
	private void adaptDimension()
	{
		if (isDimensionAdaptive)
		{
			Dimension dimension = getPreferredSize();
			
			int width = dimension.width;
			if (width % 2 != 0)
			{
				width += widthInset;
			}
			else
			{
				width += widthInset + 1;
			}
			dimension.width = width;
			
			int height = dimension.height;
			if (height % 2 != 0)
			{
				height += heightInset;
			}
			else
			{
				height += heightInset + 1;
			}
			dimension.height = height;
			
			setDimension(dimension);
		}
	}
	
	/**
	 * Gets the width inset.
	 * @return the width inset value
	 */
	public int getWidthInset()
	{
		return widthInset;
	}
	
	/**
	 * Sets the width inset.
	 * @param widthInset the width inset value
	 */
	public void setWidthInset(int widthInset)
	{
		this.widthInset = widthInset;
	}
	
	/**
	 * Gets the height inset.
	 * @return the height inset value
	 */
	public int getHeightInset()
	{
		return heightInset;
	}
	
	/**
	 * Sets the height inset.
	 * @param heightInset the height inset value
	 */
	public void setHeightInset(int heightInset)
	{
		this.heightInset = heightInset;
	}
	
	/**
	 * Sets the dimension.
	 * @param dimension the instance of Dimension
	 */
	public void setDimension(Dimension dimension)
	{
		DimensionManager.setDimension(this, dimension);
		
		isDimensionAdaptive = false;
	}
}