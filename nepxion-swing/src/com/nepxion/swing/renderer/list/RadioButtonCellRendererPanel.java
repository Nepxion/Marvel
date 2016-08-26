package com.nepxion.swing.renderer.list;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class RadioButtonCellRendererPanel
	extends JPanel
{
	/**
	 * The instance of JRadioButton.
	 */
	private JRadioButton radioButton;
	
	/**
	 * The instance of CellRendererLabel.
	 */
	private CellRendererLabel label;
	
	/**
	 * Constructs with the default.
	 */
	public RadioButtonCellRendererPanel()
	{
		radioButton = new JRadioButton();
		label = new CellRendererLabel();
		
		radioButton.setBackground(UIManager.getColor("Tree.textBackground"));
		label.setForeground(UIManager.getColor("Tree.textForeground"));
		
		add(radioButton);
		add(label);
		
		setBackground(Color.white);
	}
	
	/**
	 * Gets the check box.
	 * @return the instance of JCheckBox
	 */
	public JRadioButton getRadioButton()
	{
		return radioButton;
	}
	
	/**
	 * Gets the label.
	 * @return the instance of CellRendererLabel
	 */
	public CellRendererLabel getLabel()
	{
		return label;
	}
	
	/**
	 * Gets the preferred size.
	 * @return the instance of Dimension
	 */
	public Dimension getPreferredSize()
	{
		Dimension radioDimension = radioButton.getPreferredSize();
		Dimension labelDimension = label.getPreferredSize();
		
		return new Dimension(radioDimension.width + labelDimension.width, (radioDimension.height < labelDimension.height ? labelDimension.height : radioDimension.height));
	}
	
	/**
	 * Sets the background.
	 * @param background the instance of Color
	 */
	public void setBackground(Color background)
	{
		if (background instanceof ColorUIResource)
		{
			background = null;
		}
		
		super.setBackground(background);
	}
	
	/**
	 * Does the layout.
	 */
	public void doLayout()
	{
		Dimension radioDimension = radioButton.getPreferredSize();
		Dimension labelDimension = label.getPreferredSize();
		int radioHeight = 0;
		int labelHeight = 0;
		if (radioDimension.height < labelDimension.height)
		{
			radioHeight = (labelDimension.height - radioDimension.height) / 2;
		}
		else
		{
			labelHeight = (radioDimension.height - labelDimension.height) / 2;
		}
		radioButton.setBounds(2, radioHeight, radioDimension.width, radioDimension.height);
		label.setBounds(radioDimension.width + 4, labelHeight, labelDimension.width, labelDimension.height);
	}
}