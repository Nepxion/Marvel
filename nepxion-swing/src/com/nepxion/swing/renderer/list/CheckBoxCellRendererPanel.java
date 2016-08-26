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

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class CheckBoxCellRendererPanel
	extends JPanel
{
	/**
	 * The instance of JCheckBox.
	 */
	private JCheckBox checkBox;
	
	/**
	 * The instance of CellRendererLabel.
	 */
	private CellRendererLabel label;
	
	/**
	 * Constructs with the default.
	 */
	public CheckBoxCellRendererPanel()
	{
		checkBox = new JCheckBox();
		label = new CellRendererLabel();
		
		checkBox.setBackground(UIManager.getColor("Tree.textBackground"));
		label.setForeground(UIManager.getColor("Tree.textForeground"));
		
		add(checkBox);
		add(label);
		
		setBackground(Color.white);
	}
	
	/**
	 * Gets the check box.
	 * @return the instance of JCheckBox
	 */
	public JCheckBox getCheckBox()
	{
		return checkBox;
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
		Dimension checkBoxDimension = checkBox.getPreferredSize();
		Dimension labelDimension = label.getPreferredSize();
		
		return new Dimension(checkBoxDimension.width + labelDimension.width, (checkBoxDimension.height < labelDimension.height ? labelDimension.height : checkBoxDimension.height));
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
		Dimension checkBoxDimension = checkBox.getPreferredSize();
		Dimension labelDimension = label.getPreferredSize();
		int checkBoxHeight = 0;
		int labelHeight = 0;
		if (checkBoxDimension.height < labelDimension.height)
		{
			checkBoxHeight = (labelDimension.height - checkBoxDimension.height) / 2;
		}
		else
		{
			labelHeight = (checkBoxDimension.height - labelDimension.height) / 2;
		}
		checkBox.setBounds(2, checkBoxHeight, checkBoxDimension.width, checkBoxDimension.height);
		label.setBounds(checkBoxDimension.width + 4, labelHeight, labelDimension.width, labelDimension.height);
	}
}