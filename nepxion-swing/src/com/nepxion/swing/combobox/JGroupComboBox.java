package com.nepxion.swing.combobox;

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
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ComboBoxModel;

import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.renderer.combobox.GroupComboBoxCellRenderer;

public class JGroupComboBox
	extends JBasicComboBox
{
	/**
	 * Constructs with the specified initial combo box model.
	 * @param aModel the instance of ComboBoxModel
	 */
	public JGroupComboBox(ComboBoxModel aModel)
	{
		super(aModel);
		
		addActionListener(new ComboBoxGroupActionListener());
	}
	
	/**
	 * Constructs with the specified initial items.
	 * @param items the object array
	 */
	public JGroupComboBox(final Object items[])
	{
		super(items);
		
		addActionListener(new ComboBoxGroupActionListener());
	}
	
	/**
	 * Constructs with the specified initial items.
	 * @param items the instance of Vector
	 */
	public JGroupComboBox(Vector items)
	{
		super(items);
		
		addActionListener(new ComboBoxGroupActionListener());
	}
	
	/**
	 * Constructs with the default.
	 */
	public JGroupComboBox()
	{
		super();
		
		addActionListener(new ComboBoxGroupActionListener());
	}
	
	public class ComboBoxGroupActionListener
		implements ActionListener
	{
		/**
		 * The current item object.
		 */
		private Object currentItem;
		
		/**
		 * Constructs with the default.
		 */
		public ComboBoxGroupActionListener()
		{
			setSelectedIndex(0);
			currentItem = getSelectedItem();
		}

		/**
		 * Invoked when an action occurs.
		 * @param e the instance of ActionEvent
		 */
		public void actionPerformed(ActionEvent e)
		{
			Object selectedItem = getSelectedItem();
			
			if (selectedItem instanceof IElementNode)
			{
				IElementNode elementNode = (IElementNode) selectedItem;
				if (!elementNode.isEnabled())
				{
					setSelectedItem(currentItem);
					
					return;
				}
			}
			if (selectedItem.toString().equals(GroupComboBoxCellRenderer.SEPARATOR))
			{
				setSelectedItem(currentItem);
				
				return;
			}
			
			currentItem = selectedItem;
		}
	}
}