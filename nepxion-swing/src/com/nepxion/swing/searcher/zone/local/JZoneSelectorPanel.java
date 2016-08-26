package com.nepxion.swing.searcher.zone.local;

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

import javax.swing.JPanel;
import javax.swing.tree.TreeNode;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.selector.button.ISelectorMenuButton;
import com.nepxion.swing.selector.button.JBasicSelectorMenuButton;
import com.nepxion.swing.selector.button.JClassicSelectorMenuButton;
import com.nepxion.swing.textfield.JBasicTextField;
import com.nepxion.swing.textfield.number.JNumberTextField;

public class JZoneSelectorPanel
	extends JPanel
{
	/**
	 * The instance of JNumberTextField.
	 */
	private JNumberTextField textField;
	
	/**
	 * The instance of ISelectorMenuButton.
	 */
	private ISelectorMenuButton menuButton;
	
	/**
	 * The instance of JZoneTree.
	 */
	private JZoneTree tree;
	
	/**
	 * The maximum length value.
	 */
	private int maximumLength = 12;
	
	/**
	 * Constructs with the default.
	 */
	public JZoneSelectorPanel()
	{
		this(false);
	}
	
	/**
	 * Constructs with the specified initial classic style.
	 * @param isClassicStyle the boolean value of isClassicStyle
	 */
	public JZoneSelectorPanel(boolean isClassicStyle)
	{
		this("", isClassicStyle);
	}
	
	/**
	 * Constructs with the specified initial value.
	 * @param value the value string
	 */
	public JZoneSelectorPanel(String value)
	{
		this(value, false);
	}
	
	/**
	 * Constructs with the specified initial value and classic style.
	 * @param value the value string
	 * @param isClassicStyle the boolean value of isClassicStyle
	 */
	public JZoneSelectorPanel(String value, boolean isClassicStyle)
	{
		this(value, 12, isClassicStyle);
	}
	
	/**
	 * Constructs with the specified initial maximum length.
	 * @param maximumLength the maximum length value
	 */
	public JZoneSelectorPanel(int maximumLength)
	{
		this(maximumLength, false);
	}
	
	/**
	 * Constructs with the specified initial maximum length and classic style.
	 * @param maximumLength the maximum length value
	 * @param isClassicStyle the boolean value of isClassicStyle
	 */
	public JZoneSelectorPanel(int maximumLength, boolean isClassicStyle)
	{
		this("", maximumLength, isClassicStyle);
	}
	
	/**
	 * Constructs with the specified initial value and maximum length.
	 * @param value the value string
	 * @param maximumLength the maximum length value
	 */
	public JZoneSelectorPanel(String value, int maximumLength)
	{
		this(value, maximumLength, false);
	}
	
	/**
	 * Constructs with the specified initial value, maximum length and classic style.
	 * @param value the value string
	 * @param maximumLength the maximum length value
	 * @param isClassicStyle the boolean value of isClassicStyle
	 */
	public JZoneSelectorPanel(String value, int maximumLength, boolean isClassicStyle)
	{
		textField = new JNumberTextField(maximumLength, 0);
		
		tree = new JZoneTree();
		
		JBasicScrollPane scrollPane = new JBasicScrollPane(tree);
		scrollPane.setPreferredSize(new Dimension(300, 300));
		
		if (isClassicStyle)
		{
			menuButton = new JClassicSelectorMenuButton(IconFactory.getSwingIcon("property.png"), SwingLocale.getString("select_province_city_code"))
			{
				public boolean confirm()
				{
					return JZoneSelectorPanel.this.confirm();
				}
				
				public boolean cancel()
				{
					return true;
				}
			};
		}
		else
		{
			menuButton = new JBasicSelectorMenuButton(IconFactory.getSwingIcon("property.png"), SwingLocale.getString("select_province_city_code"))
			{
				public boolean confirm()
				{
					return JZoneSelectorPanel.this.confirm();
				}
				
				public boolean cancel()
				{
					return true;
				}
			};
		}
		menuButton.setContentPane(scrollPane);
		
		setLayout(new BorderLayout());
		add(textField, BorderLayout.CENTER);
		add((Component) menuButton, BorderLayout.EAST);
		
		ButtonManager.updateUI(this, new Dimension(26, 26));
		
		setValue(value);
	}
	
	/**
	 * Returns true if it is confirmed.
	 * @return true if it is confirmed
	 */
	public boolean confirm()
	{
		TreeNode treeNode = tree.getSelectionTreeNode();
		if (treeNode == null || !treeNode.isLeaf())
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(this), SwingLocale.getString("select_city_node"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);		
			
			return false;
		}
		
		IElementNode cityTreeNode = (IElementNode) treeNode;
		IElementNode provinceTreeNode = (IElementNode) treeNode.getParent();
		String text = provinceTreeNode.getName() + cityTreeNode.getName();
		
		textField.setText(text);
		
		return true;
	}
	
	/**
	 * Gets the text field.
	 * @return the instance of JBasicTextField
	 */
	public JBasicTextField getTextField()
	{
		return textField;
	}
	
	/**
	 * Gets the menu button.
	 * @return the instance of ISelectorMenuButton
	 */
	public ISelectorMenuButton getMenuButton()
	{
		return menuButton;
	}
	
	/**
	 * Gets the tree.
	 * @return the instance of JZoneTree
	 */
	public JZoneTree getTree()
	{
		return tree;
	}
	
	/**
	 * Sets the enabled.
	 * @param enabled the boolean value of enabled
	 */
	public void setEnabled(boolean enabled)
	{
		textField.setEditable(enabled);
		((Component) menuButton).setEnabled(enabled);
	}
	
	/**
	 * Gets the value.
	 * @return the value object
	 */
	public Object getValue()
	{
		return textField.getText();
	}
	
	/**
	 * Sets the value.
	 * @param value the value object
	 */
	public void setValue(Object value)
	{
		String text = null;
		
		if (value == null)
		{
			text = "";
		}
		
		text = value.toString().trim();
		
		if (text.length() > maximumLength)
		{
			throw new IllegalArgumentException("Invalid value");
		}
		
		if (!text.equals(""))
		{
			boolean flag = text.matches("[0-9]+");
			if (!flag)
			{
				throw new IllegalArgumentException("Invalid value");
			}
		}
		
		textField.setText(text);
	}
}