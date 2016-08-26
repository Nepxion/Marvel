package com.nepxion.swing.selector.radiobutton;

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
import java.util.List;

import javax.swing.Box;
import javax.swing.JPanel;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JClassicButton;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.selector.button.ISelectorMenuButton;
import com.nepxion.swing.selector.button.JBasicSelectorMenuButton;
import com.nepxion.swing.selector.button.JClassicSelectorMenuButton;
import com.nepxion.swing.textfield.JBasicTextField;

public class JMultiRadioButtonSelectorBar
	extends JPanel
{
	private JBasicTextField textField;
	private ISelectorMenuButton menuButton;
	private JMultiRadioButtonListPanel radioButtonListPanel;
	
	public JMultiRadioButtonSelectorBar(List allElementNodes)
	{
		this(allElementNodes, false);
	}
	
	public JMultiRadioButtonSelectorBar(List allElementNodes, boolean isClassicStyle)
	{
		textField = new JBasicTextField();
		textField.setEditable(false);
		
		radioButtonListPanel = new JMultiRadioButtonListPanel(allElementNodes);
		radioButtonListPanel.setPreferredSize(new Dimension(300, 300));
		
		if (isClassicStyle)
		{
			menuButton = new JClassicSelectorMenuButton(IconFactory.getSwingIcon("property.png"), SwingLocale.getString("selection"))
			{
				public boolean confirm()
				{
					return JMultiRadioButtonSelectorBar.this.confirm();
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
					return JMultiRadioButtonSelectorBar.this.confirm();
				}
				
				public boolean cancel()
				{
					return true;
				}
			};
		}
		menuButton.setContentPane(radioButtonListPanel);
		
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
		
		buttonContainer.add(Box.createHorizontalStrut(5), 1);
		
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
	
	public JMultiRadioButtonListPanel getRadioButtonListPanel()
	{
		return radioButtonListPanel;
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