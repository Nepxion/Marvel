package com.nepxion.swing.selector.button;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JPanel;

import com.nepxion.swing.button.JBasicMenuButton;
import com.nepxion.swing.panel.option.JOptionButtonPanel;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;

public abstract class JBasicSelectorMenuButton
	extends JBasicMenuButton implements ISelectorMenuButton
{
	/**
	 * The instance of JPanel.
	 */
	private JPanel container;
	
	/**
	 * The instance of JOptionButtonPanel.
	 */
	private JOptionButtonPanel optionButtonPanel;
	
	/**
	 * Constructs with the default.
	 */
	public JBasicSelectorMenuButton()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial action.
	 * @param action the instance of Action
	 */
	public JBasicSelectorMenuButton(Action action)
	{
		super(action);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text.
	 * @param text the text string
	 */
	public JBasicSelectorMenuButton(String text)
	{
		super(text);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial icon.
	 * @param icon the instance of Icon
	 */
	public JBasicSelectorMenuButton(Icon icon)
	{
		super(icon);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text and icon.
	 * @param text the text string 
	 * @param icon the icon of Icon
	 */
	public JBasicSelectorMenuButton(String text, Icon icon)
	{
		super(text, icon);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text and tooltip text.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 */
	public JBasicSelectorMenuButton(String text, String toolTipText)
	{
		super(text, toolTipText);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial icon and tooltip text.
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JBasicSelectorMenuButton(Icon icon, String toolTipText)
	{
		super(icon, toolTipText);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text and icon.
	 * @param text the text string 
	 * @param icon the icon of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JBasicSelectorMenuButton(String text, Icon icon, String toolTipText)
	{
		super(text, icon, toolTipText);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		final JBasicPopupMenu popupMenu = new JBasicPopupMenu();
		setPopupMenu(popupMenu);
		
		optionButtonPanel = new JOptionButtonPanel(JOptionButtonPanel.YES_NO_OPTION)
		{
			public boolean confirm()
			{
				return JBasicSelectorMenuButton.this.doConfirm();
			}
			
			public boolean cancel()
			{
				return JBasicSelectorMenuButton.this.doCancel();
			}
		};
		
		container = new JPanel();
		container.setLayout(new BorderLayout());
		container.add(optionButtonPanel, BorderLayout.SOUTH);
		
		popupMenu.add(container);
	}
	
	/**
	 * Sets the content pane.
	 * @param component the instance of Component
	 */
	public void setContentPane(Component component)
	{
		container.add(component, BorderLayout.CENTER);
	}
	
	/**
	 * Gets the option button panel.
	 * @return the instance of JOptionButtonPanel
	 */
	public JOptionButtonPanel getOptionButtonPanel()
	{
		return optionButtonPanel;
	}
	
	/**
	 * Does confirming.
	 * @return true if confirmed successfully
	 */
	public boolean doConfirm()
	{
		if (confirm())
		{
			popupMenu.setVisible(false);
		}
		
		return false;
	}
	
	/**
	 * Does cancelling.
	 * @return true if cancelled successfully
	 */
	public boolean doCancel()
	{
		if (cancel())
		{
			popupMenu.setVisible(false);
		}
		
		return false;
	}
}