package com.nepxion.swing.selector.calendar;

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
import java.awt.Dimension;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.panel.option.JOptionPanel;
import com.nepxion.swing.selector.dropdown.IDropDownPopupMenu;
import com.nepxion.swing.selector.dropdown.JDropDownDraggablePopupMenu;
import com.nepxion.swing.selector.dropdown.JDropDownPane;

public abstract class JYearSelectorPopupMenu
	extends JDropDownDraggablePopupMenu implements IYearSelectorComponent
{
	/**
	 * The instance of JYearSelector.
	 */
	private JYearSelector yearSelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial year selector and button.
	 * @param yearSelector the instance of JYearSelector
	 * @param button the instance of AbstractButton
	 */
	public JYearSelectorPopupMenu(JYearSelector yearSelector, AbstractButton button)
	{		
		this.yearSelector = yearSelector;		
		this.yearSelector.setPreferredSize(new Dimension(180, yearSelector.getPreferredSize().height));
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(yearSelector, BorderLayout.NORTH);
		
		JOptionPanel optionPanel = new JOptionPanel();
		optionPanel.setIcon(IconFactory.getSwingIcon("component/calendar_48.png"));
		optionPanel.setContent(layoutPanel);
		
		DropDownPane dropDownPane = new DropDownPane(this, optionPanel);
		dropDownPane.getOptionButtonPanel().setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		registerOwner(button);
		registerRenderer(button);
		registerButton(button);
		
		setPopupMenuWidth(yearSelector.getPreferredSize().width + 85);
		setPopupMenuHeight(yearSelector.getPreferredSize().height + 95);
		setResizable(false);
	}
	
	/**
	 * Gets the year selector.
	 * @return the instance of JYearSelector
	 */
	public JYearSelector getYearSelector()
	{
		return yearSelector;
	}
	
	/**
	 * Sets the year selector.
	 * @param yearSelector the instance of JYearSelector
	 */
	public void setYearSelector(JYearSelector yearSelector)
	{
		this.yearSelector = yearSelector;
		this.yearSelector.setPreferredSize(new Dimension(180, this.yearSelector.getPreferredSize().height));
		
		layoutPanel.removeAll();
		layoutPanel.add(yearSelector);
	}
	
	public class DropDownPane
		extends JDropDownPane
	{
		/**
		 * Constructs with the specified initial popup menu and content pane.
		 * @param popupMenu the instance of IDropDownPopupMenu
		 * @param contentPane the instance of Component
		 */
		public DropDownPane(IDropDownPopupMenu popupMenu, Component contentPane)
		{
			super(popupMenu, contentPane);
		}
		
		/**
		 * Returns true if it is confirmed.
		 * @return true if it is confirmed
		 */
		public boolean confirm()
		{
			return JYearSelectorPopupMenu.this.confirm();
		}
		
		/**
		 * Returns true if it is cancelled.
		 * @return true if it is cancelled
		 */
		public boolean cancel()
		{
			return JYearSelectorPopupMenu.this.cancel();
		}
	}
	
	/**
	 * Returns true if it is confirmed.
	 * @return true if it is confirmed
	 */
	public abstract boolean confirm();
	
	/**
	 * Returns true if it is cancelled.
	 * @return true if it is cancelled
	 */
	public abstract boolean cancel();
}