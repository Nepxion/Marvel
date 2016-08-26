package com.nepxion.swing.panel;

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
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.nepxion.swing.border.ComponentTitledBorder;

public class JComponentTitledBorderPanel
	extends JPanel
{
	private ComponentTitledBorder titledBorder;
	private JPanel titledBorderContainer;
	
	private JPanel contentPane;
	
	private boolean isToggleAllowed = false;
	
	public JComponentTitledBorderPanel(JCheckBox checkBox, boolean isToggleAllowed)
	{
		this(checkBox);
		
		this.isToggleAllowed = isToggleAllowed;
		
		if (this.isToggleAllowed)
		{
			checkBox.addItemListener(new ItemListener()
			{
				public void itemStateChanged(ItemEvent e)
				{
					setContentPaneEnabled(e.getStateChange() == ItemEvent.SELECTED);
				}
			}
			);
		}
	}
	
	public JComponentTitledBorderPanel(JRadioButton radioButton, boolean isToggleAllowed)
	{
		this(radioButton);
		
		this.isToggleAllowed = isToggleAllowed;
		
		if (this.isToggleAllowed)
		{
			radioButton.addItemListener(new ItemListener()
			{
				public void itemStateChanged(ItemEvent e)
				{
					setContentPaneEnabled(e.getStateChange() == ItemEvent.SELECTED);
				}
			}
			);
		}
	}
	
	public JComponentTitledBorderPanel(JComponent component)
	{
		titledBorderContainer = new JPanel();
		titledBorderContainer.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 1));
		titledBorderContainer.setLayout(new BorderLayout());
		titledBorderContainer.add(component, BorderLayout.CENTER);
		
		titledBorder = new ComponentTitledBorder(titledBorderContainer);
		setBorder(titledBorder);
		
		contentPane = new JPanel();
		
		setLayout(null);
		add(titledBorderContainer);
		add(contentPane);
	}
	
	public void setTitledBorderWidth(int width)
	{
		titledBorderContainer.setPreferredSize(new Dimension(width, titledBorderContainer.getPreferredSize().height));
	}
	
	public void setTitledBorderHeight(int height)
	{
		titledBorderContainer.setPreferredSize(new Dimension(titledBorderContainer.getPreferredSize().width, height));
	}
	
	public void setTitledBorderDimension(Dimension dimension)
	{
		titledBorderContainer.setPreferredSize(dimension);
	}
	
	public JPanel getContentPane()
	{
		return contentPane;
	}
	
	public void setContentPaneEnabled(boolean enabled)
	{
		setChildEnabled(contentPane, enabled);
	}
	
	private void setChildEnabled(JComponent component, boolean enabled)
	{
		component.setEnabled(enabled);
		if (component.getComponentCount() > 0)
		{
			for (int i = 0; i < component.getComponentCount(); i++)
			{
				Component c = component.getComponent(i);
				if (c instanceof JComponent)
				{
					JComponent childComponent = (JComponent) c;
					childComponent.setEnabled(enabled);
					setChildEnabled(childComponent, enabled);
				}
			}
		}
	}
	
	public void doLayout()
	{
		Insets insets = getInsets();
		Rectangle rectangle = getBounds();
		rectangle.x = 0;
		rectangle.y = 0;
		
		Rectangle componentRectangle = titledBorder.getComponentRectangle(rectangle, insets);
		titledBorder.getComponent().setBounds(componentRectangle);
		rectangle.x += insets.left;
		rectangle.y += insets.top;
		rectangle.width -= insets.left + insets.right;
		rectangle.height -= insets.top + insets.bottom;
		contentPane.setBounds(rectangle);
	}
}