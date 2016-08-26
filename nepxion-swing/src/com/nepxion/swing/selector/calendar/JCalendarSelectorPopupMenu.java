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

public abstract class JCalendarSelectorPopupMenu
	extends JDropDownDraggablePopupMenu implements ICalendarSelectorComponent
{
	/**
	 * The instance of JCalendarSelector.
	 */
	private JCalendarSelector calendarSelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial calendar selector and button.
	 * @param calendarSelector the instance of JCalendarSelector
	 * @param button the instance of AbstractButton
	 */
	public JCalendarSelectorPopupMenu(JCalendarSelector calendarSelector, AbstractButton button)
	{
		this.calendarSelector = calendarSelector;
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(calendarSelector, BorderLayout.NORTH);
		
		JOptionPanel optionPanel = new JOptionPanel();
		optionPanel.setIcon(IconFactory.getSwingIcon("component/calendar_48.png"));
		optionPanel.setContent(layoutPanel);
		
		DropDownPane dropDownPane = new DropDownPane(this, optionPanel);
		dropDownPane.getOptionButtonPanel().setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		registerOwner(button);
		registerRenderer(button);
		registerButton(button);
		
		setPopupMenuWidth(calendarSelector.getPreferredSize().width + 85);
		setPopupMenuHeight(calendarSelector.getPreferredSize().height + 75);
		setResizable(false);
	}
	
	/**
	 * Gets the calendar selector.
	 * @return the instance of JCalendarSelector
	 */
	public JCalendarSelector getCalendarSelector()
	{
		return calendarSelector;
	}
	
	/**
	 * Sets the calendar selector.
	 * @param calendarSelector the instance of JCalendarSelector
	 */
	public void setCalendarSelector(JCalendarSelector calendarSelector)
	{
		this.calendarSelector = calendarSelector;
		
		layoutPanel.removeAll();
		layoutPanel.add(calendarSelector);
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
			return JCalendarSelectorPopupMenu.this.confirm();
		}
		
		/**
		 * Returns true if it is cancelled.
		 * @return true if it is cancelled.
		 */
		public boolean cancel()
		{
			return JCalendarSelectorPopupMenu.this.cancel();
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