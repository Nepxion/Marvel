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

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.locale.SwingLocale;

public class MultiRadioButtonCellRendererPanel
	extends JPanel
{
	/**
	 * The ignored radio button.
	 */
	private JRadioButton ignoredRadioButton;
	
	/**
	 * The contained radio button.
	 */
	private JRadioButton containedRadioButton;
	
	/**
	 * The not contained radio button.
	 */
	private JRadioButton notContainedRadioButton;
	
	/**
	 * The instance of CellRendererLabel.
	 */
	private CellRendererLabel label;
	
	/**
	 * Constructs with the default.
	 */
	public MultiRadioButtonCellRendererPanel()
	{
		this(SwingLocale.getString("select_ignored"), SwingLocale.getString("select_contained"), SwingLocale.getString("select_not_contained"));
	}
	
	/**
	 * Constructs with the specified initial ignored text, contained text and not contained text.
	 * @param ignoredText the ignored text string
	 * @param containedText the contained text string
	 * @param notContainedText the not contained text string
	 */
	public MultiRadioButtonCellRendererPanel(String ignoredText, String containedText, String notContainedText)
	{
		ignoredRadioButton = new JRadioButton(ignoredText);
		containedRadioButton = new JRadioButton(containedText);
		notContainedRadioButton = new JRadioButton(notContainedText);
		label = new CellRendererLabel();
		
		ignoredRadioButton.setBackground(UIManager.getColor("Tree.textBackground"));
		containedRadioButton.setBackground(UIManager.getColor("Tree.textBackground"));
		notContainedRadioButton.setBackground(UIManager.getColor("Tree.textBackground"));
		label.setForeground(UIManager.getColor("Tree.textForeground"));
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(ignoredRadioButton);
		buttonGroup.add(containedRadioButton);
		buttonGroup.add(notContainedRadioButton);
		
		add(ignoredRadioButton);
		add(containedRadioButton);
		add(notContainedRadioButton);
		add(label);
		
		setBackground(Color.white);
	}
	
	/**
	 * Gets the ignored radio button.
	 * @return the instance of JRadioButton
	 */
	public JRadioButton getIgnoredRadioButton()
	{
		return ignoredRadioButton;
	}
	
	/**
	 * Gets the contained radio button
	 * @return the instance of JRadioButton
	 */
	public JRadioButton getContainedRadioButton()
	{
		return containedRadioButton;
	}
	
	/**
	 * Gets the not contained radio button.
	 * @return the instance of JRadioButton
	 */
	public JRadioButton getNotContainedRadioButton()
	{
		return notContainedRadioButton;
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
	 * Gets the selected radio index.
	 * @param x the x value
	 * @return the selected radio index value
	 */
	protected int getSelectedRadioIndex(int x)
	{
		if (x >= ignoredRadioButton.getBounds().x && x <= ignoredRadioButton.getBounds().x + ignoredRadioButton.getBounds().width)
		{
			return IElementNode.SELECTION_INDEX_IGNORED;
		}
		else if (x >= containedRadioButton.getBounds().x && x <= containedRadioButton.getBounds().x + containedRadioButton.getBounds().width)
		{
			return IElementNode.SELECTION_INDEX_CONTAINED;
		}
		else if (x >= notContainedRadioButton.getBounds().x && x <= notContainedRadioButton.getBounds().x + notContainedRadioButton.getBounds().width)
		{
			return IElementNode.SELECTION_INDEX_NOT_CONTAINED;
		}
		
		return -1;
	}
	
	/**
	 * Gets the preferred size.
	 * @return the instance of Dimension
	 */
	public Dimension getPreferredSize()
	{
		Dimension ignoredRadioDimension = ignoredRadioButton.getPreferredSize();
		Dimension containedRadioDimension = containedRadioButton.getPreferredSize();
		Dimension notContainedRadioDimension = notContainedRadioButton.getPreferredSize();
		Dimension labelDimension = label.getPreferredSize();
		
		return new Dimension(ignoredRadioDimension.width + containedRadioDimension.width + notContainedRadioDimension.width + labelDimension.width, (ignoredRadioDimension.height < labelDimension.height ? labelDimension.height : ignoredRadioDimension.height));
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
		Dimension ignoredRadioDimension = ignoredRadioButton.getPreferredSize();
		Dimension containedRadioDimension = containedRadioButton.getPreferredSize();
		Dimension notContainedRadioDimension = notContainedRadioButton.getPreferredSize();
		Dimension labelDimension = label.getPreferredSize();
		int radioHeight = 0;
		int labelHeight = 0;
		if (ignoredRadioDimension.height < labelDimension.height)
		{
			radioHeight = (labelDimension.height - ignoredRadioDimension.height) / 2;
		}
		else
		{
			labelHeight = (ignoredRadioDimension.height - labelDimension.height) / 2;
		}
		ignoredRadioButton.setBounds(2, radioHeight, ignoredRadioDimension.width, ignoredRadioDimension.height);
		containedRadioButton.setBounds(ignoredRadioDimension.width + 2, radioHeight, containedRadioDimension.width, containedRadioDimension.height);
		notContainedRadioButton.setBounds(ignoredRadioDimension.width + containedRadioDimension.width + 2, radioHeight, notContainedRadioDimension.width, notContainedRadioDimension.height);
		label.setBounds(ignoredRadioDimension.width + containedRadioDimension.width + notContainedRadioDimension.width + 12, labelHeight, labelDimension.width, labelDimension.height);
	}
}