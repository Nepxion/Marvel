package com.nepxion.swing.selector.color;

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
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.BorderFactory;

import com.nepxion.swing.dialog.JBasicDialog;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.panel.option.JOptionPanel;

public abstract class JColorSelectorDialog
	extends JBasicDialog implements IColorSelectorComponent
{	
	/**
	 * The instance of JColorSelector.
	 */
	private JColorSelector colorSelector;
	
	/**
	 * Constructs with the specified initial frame.
	 * @param owner the instance of Frame
	 */
	public JColorSelectorDialog(Frame owner)
	{
		this(owner, true);
	}
	
	/**
	 * Constructs with the specified initial dialog.
	 * @param owner the instance of Dialog
	 */
	public JColorSelectorDialog(Dialog owner)
	{
		this(owner, true);
	}
	
	/**
	 * Constructs with the specified initial frame and modal.
	 * @param owner the instance of Frame
	 * @param modal the boolean value of modal
	 */
	public JColorSelectorDialog(Frame owner,  boolean modal)
	{
		this(owner, modal, false);
	}
	
	/**
	 * Constructs with the specified initial dialog and modal.
	 * @param owner the instance of Dialog
	 * @param modal the boolean value of modal
	 */
	public JColorSelectorDialog(Dialog owner, boolean modal)
	{
		this(owner, modal, false);
	}
	
	/**
	 * Constructs with the specified initial frame, modal and hint.
	 * @param owner the instance of Frame
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JColorSelectorDialog(Frame owner, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("color_selector"), new Dimension(247, 263), modal, hint, true);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial dialog, modal and hint.
	 * @param owner the instance of Dialog
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JColorSelectorDialog(Dialog owner, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("color_selector"), new Dimension(247, 263), modal, hint, true);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{		
		colorSelector = new JColorSelector()
		{
			public void executeSelection()
			{
				Color color = getColor();
				
				JColorSelectorDialog.this.executeSelection(color);
			}
		};
		
		JOptionPanel optionPanel = new JOptionPanel();
		optionPanel.setIcon(IconFactory.getSwingIcon("component/color_32.png"));
		optionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		optionPanel.setContent(colorSelector);
		
		getContentPane().add(optionPanel);
		
		Dimension size = getSize();
		setMinimumDimension(size);
		setMaximumDimension(size);
	}
	
	/**
	 * Gets the color selector.
	 * @return the instance of JColorSelector
	 */
	public JColorSelector getColorSelector()
	{
		return colorSelector;
	}
}