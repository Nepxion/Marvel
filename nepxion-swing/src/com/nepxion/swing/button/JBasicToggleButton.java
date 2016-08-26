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
import javax.swing.JToggleButton;
import javax.swing.plaf.ButtonUI;

import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.listener.DisplayAbilityListener;

public class JBasicToggleButton
	extends JToggleButton implements IButton, IToggleButton
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
	 * The boolean value of the button is grouped.
	 * If true, the toggle button will be added to a ButtonGroup automatically.
	 */
	protected boolean isGrouped = true;
	
	/**
	 * Constructs with the default.
	 */
	public JBasicToggleButton()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial action.
	 * @param action the instance of Action
	 */
	public JBasicToggleButton(Action action)
	{
		super(action);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text.
	 * @param text the text string
	 */
	public JBasicToggleButton(String text)
	{
		super(text);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial icon.
	 * @param icon the instance of Icon
	 */
	public JBasicToggleButton(Icon icon)
	{
		super(icon);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text and icon.
	 * @param text the text string 
	 * @param icon the icon of Icon
	 */
	public JBasicToggleButton(String text, Icon icon)
	{
		super(text, icon);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text and tooltip text.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 */
	public JBasicToggleButton(String text, String toolTipText)
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
	public JBasicToggleButton(String text, boolean selected)
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
	public JBasicToggleButton(Icon icon, String toolTipText)
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
	public JBasicToggleButton(Icon icon, boolean selected)
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
	public JBasicToggleButton(String text, Icon icon, String toolTipText)
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
	public JBasicToggleButton(String text, Icon icon, boolean selected)
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
	public JBasicToggleButton(String text, String toolTipText, boolean selected)
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
	public JBasicToggleButton(Icon icon, String toolTipText, boolean selected)
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
	public JBasicToggleButton(String text, Icon icon, String toolTipText, boolean selected)
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
		setModel(new BasicToggleButtonModel());
		
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
	
	/**
	 * Sets ui.
	 * @param buttonUI the instance of ButtonUI
	 */
	public void setUI(ButtonUI buttonUI)
	{
		super.setUI(buttonUI);
		
		setOpaque(false);
	}
	
	/**
	 * Updates ui.
	 */
	public void updateUI()
	{
		setUI(getUI());
	}
}