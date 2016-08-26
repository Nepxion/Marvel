package com.nepxion.demo.common;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.textfield.JBasicTextField;

public class DemoSelectionValuePanel
	extends JPanel
{
	private JBasicTextField textField;
	
	public DemoSelectionValuePanel()
	{
		this(225);
	}
	
	public DemoSelectionValuePanel(int textFieldWidth)
	{
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(BorderManager.createComplexTitledBorder("Selection Value"));
		
		textField = new JBasicTextField();
		textField.setOpaque(false);
		DimensionManager.setDimension(textField, new Dimension(textFieldWidth, textField.getPreferredSize().height));
		
		add(new JLabel("Your Selection Value"));
		add(textField);
	}
	
	public void setValue(String value)
	{
		textField.setText(value);
	}
}