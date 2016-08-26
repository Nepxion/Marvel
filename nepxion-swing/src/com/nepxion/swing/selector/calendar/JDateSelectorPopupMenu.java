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

public abstract class JDateSelectorPopupMenu
	extends JDropDownDraggablePopupMenu implements IDateSelectorComponent
{
	/**
	 * The instance of JDateSelector.
	 */
	private JDateSelector dateSelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial date selector and button.
	 * @param dateSelector the instance of JDateSelector
	 * @param button the instance of AbstractButton
	 */
	public JDateSelectorPopupMenu(JDateSelector dateSelector, AbstractButton button)
	{		
		this.dateSelector = dateSelector;
		this.dateSelector.setPreferredSize(new Dimension(180, dateSelector.getPreferredSize().height));
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(dateSelector, BorderLayout.NORTH);
		
		JOptionPanel optionPanel = new JOptionPanel();
		optionPanel.setIcon(IconFactory.getSwingIcon("component/calendar_48.png"));
		optionPanel.setContent(layoutPanel);
		
		DropDownPane dropDownPane = new DropDownPane(this, optionPanel);
		dropDownPane.getOptionButtonPanel().setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		registerOwner(button);
		registerRenderer(button);
		registerButton(button);
		
		setPopupMenuWidth(dateSelector.getPreferredSize().width + 85);
		setPopupMenuHeight(dateSelector.getPreferredSize().height + 95);
		setResizable(false);
	}
	
	/**
	 * Gets the date selector.
	 * @return the instance of JDateSelector
	 */
	public JDateSelector getDateSelector()
	{
		return dateSelector;
	}
	
	/**
	 * Sets the date selector.
	 * @param dateSelector the instance of JDateSelector
	 */
	public void setDateSelector(JDateSelector dateSelector)
	{
		this.dateSelector = dateSelector;
		this.dateSelector.setPreferredSize(new Dimension(180, this.dateSelector.getPreferredSize().height));
		
		layoutPanel.removeAll();
		layoutPanel.add(dateSelector);
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
			return JDateSelectorPopupMenu.this.confirm();
		}
		
		/**
		 * Returns true if it is cancelled.
		 * @return true if it is cancelled
		 */
		public boolean cancel()
		{
			return JDateSelectorPopupMenu.this.cancel();
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