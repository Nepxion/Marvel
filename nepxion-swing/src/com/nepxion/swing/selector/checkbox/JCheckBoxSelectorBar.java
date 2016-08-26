package com.nepxion.swing.selector.checkbox;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.Box;
import javax.swing.JPanel;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JClassicButton;
import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.selector.button.ISelectorMenuButton;
import com.nepxion.swing.selector.button.JBasicSelectorMenuButton;
import com.nepxion.swing.selector.button.JClassicSelectorMenuButton;
import com.nepxion.swing.textfield.JBasicTextField;

public class JCheckBoxSelectorBar
	extends JPanel
{
	private JBasicTextField textField;
	private ISelectorMenuButton menuButton;
	private JCheckBoxListPanel checkBoxListPanel;
	
	public JCheckBoxSelectorBar(List allElementNodes)
	{
		this(allElementNodes, false);
	}
	
	public JCheckBoxSelectorBar(List allElementNodes, boolean isClassicStyle)
	{
		textField = new JBasicTextField();
		textField.setEditable(false);
		
		checkBoxListPanel = new JCheckBoxListPanel(allElementNodes);
		checkBoxListPanel.setPreferredSize(new Dimension(300, 300));
		
		if (isClassicStyle)
		{
			menuButton = new JClassicSelectorMenuButton(IconFactory.getSwingIcon("property.png"), SwingLocale.getString("selection"))
			{
				public boolean confirm()
				{
					return JCheckBoxSelectorBar.this.confirm();
				}
				
				public boolean cancel()
				{
					return true;
				}
			};
		}
		else
		{
			menuButton = new JBasicSelectorMenuButton(IconFactory.getSwingIcon("property.png"), SwingLocale.getString("selection"))
			{
				public boolean confirm()
				{
					return JCheckBoxSelectorBar.this.confirm();
				}
				
				public boolean cancel()
				{
					return true;
				}
			};
		}
		menuButton.setContentPane(checkBoxListPanel);
		
		JPanel buttonContainer = menuButton.getOptionButtonPanel().getContainer();
		
		JClassicButton refreshButton = new JClassicButton(SwingLocale.getString("refresh"), IconFactory.getSwingIcon("stereo/refresh_16.png"), SwingLocale.getString("refresh"));
		refreshButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				refresh();
			}
		}
		);
		buttonContainer.add(refreshButton, 0);
		
		JClassicButton selectAllButton = new JClassicButton(SwingLocale.getString("select_all"), IconFactory.getSwingIcon("stereo/redo_16.png"), SwingLocale.getString("select_all"));
		selectAllButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				checkBoxListPanel.adaptListFacade(JCheckBoxListPanel.SELECT_ALL);
			}
		}
		);
		buttonContainer.add(selectAllButton, 1);
		
		JClassicButton selectReverseButton = new JClassicButton(SwingLocale.getString("select_reverse"), IconFactory.getSwingIcon("stereo/undo_16.png"), SwingLocale.getString("select_reverse"));
		selectReverseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				checkBoxListPanel.adaptListFacade(JCheckBoxListPanel.SELECT_REVERSE);
			}
		}
		);
		buttonContainer.add(selectReverseButton, 2);
		
		buttonContainer.add(Box.createHorizontalStrut(5), 3);
		
		setLayout(new BorderLayout());
		add(textField, BorderLayout.CENTER);
		add((Component) menuButton, BorderLayout.EAST);
		
		ButtonManager.updateUI(this, new Dimension(26, 26));
	}
	
	public void refresh()
	{
		
	}
		
	public boolean confirm()
	{				
		List selectedElementNodes = checkBoxListPanel.getSelectedElementNodes();
		if (selectedElementNodes == null || selectedElementNodes.size() == 0)
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(this), SwingLocale.getString("select_not_null"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return false;
		}
		
		StringBuffer stringBuffer = new StringBuffer();
		for (Iterator iterator = selectedElementNodes.iterator(); iterator.hasNext();)
		{
			ElementNode elementNode = (ElementNode) iterator.next();
			
			String text = elementNode.getText();
			stringBuffer.append(text + ",");
		}
		
		String content = stringBuffer.toString();
		content = content.substring(0, content.lastIndexOf(","));
		
		textField.setText(content);
		
		return true;
	}
	
	public JBasicTextField getTextField()
	{
		return textField;
	}
	
	public ISelectorMenuButton getMenuButton()
	{
		return menuButton;
	}
	
	public JCheckBoxListPanel getCheckBoxListPanel()
	{
		return checkBoxListPanel;
	}
	
	public void setEnabled(boolean enabled)
	{
		textField.setEditable(enabled);
		((Component) menuButton).setEnabled(enabled);
	}
	
	public Object getValue()
	{
		return textField.getText();
	}
	
	public void setValue(Object value)
	{
		textField.setText(value != null ? value.toString() : "");
	}
}