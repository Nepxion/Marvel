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

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.panel.option.JOptionPanel;
import com.nepxion.swing.selector.dropdown.IDropDownPopupMenu;
import com.nepxion.swing.selector.dropdown.JDropDownDraggablePopupMenu;
import com.nepxion.swing.selector.dropdown.JDropDownPane;

public abstract class JDaySelectorPopupMenu
	extends JDropDownDraggablePopupMenu implements IDaySelectorComponent
{
	/**
	 * The instance of JDaySelector.
	 */
	private JDaySelector daySelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial day selector and button.
	 * @param daySelector the instance of JDaySelector
	 * @param button the instance of AbstractButton
	 */
	public JDaySelectorPopupMenu(JDaySelector daySelector, AbstractButton button)
	{		
		this.daySelector = daySelector;
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(daySelector, BorderLayout.NORTH);
		
		JOptionPanel optionPanel = new JOptionPanel();
		optionPanel.setIcon(IconFactory.getSwingIcon("component/calendar_48.png"));
		optionPanel.setContent(layoutPanel);
		
		DropDownPane dropDownPane = new DropDownPane(this, optionPanel);
		dropDownPane.getOptionButtonPanel().setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		registerOwner(button);
		registerRenderer(button);
		registerButton(button);
		
		setPopupMenuWidth(daySelector.getPreferredSize().width + 85);
		setPopupMenuHeight(daySelector.getPreferredSize().height + 75);
		setResizable(false);		
	}
	
	/**
	 * Gets the day selector.
	 * @return the instance of JDaySelector
	 */
	public JDaySelector getDaySelector()
	{
		return daySelector;
	}
	
	/**
	 * Sets the day selector.
	 * @param daySelector the instance of JDaySelector
	 */
	public void setDaySelector(JDaySelector daySelector)
	{
		this.daySelector = daySelector;
		
		layoutPanel.removeAll();
		layoutPanel.add(daySelector);
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
			return JDaySelectorPopupMenu.this.confirm();
		}
		
		/**
		 * Returns true if it is cancelled.
		 * @return true if it is cancelled
		 */
		public boolean cancel()
		{
			return JDaySelectorPopupMenu.this.cancel();
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