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

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.radiobutton.JBasicRadioButton;

public class JRadioButtonPanel
	extends JPanel
{
	private JBasicRadioButton trueRadioButton;
	private JBasicRadioButton falseRadioButton;
	
	public JRadioButtonPanel()
	{
		this(true);
	}
	
	public JRadioButtonPanel(boolean flag)
	{
		trueRadioButton = new JBasicRadioButton(SwingLocale.getString("true"), flag);
		falseRadioButton = new JBasicRadioButton(SwingLocale.getString("false"), !flag);
		
		ButtonGroup enableButtonGroup = new ButtonGroup();
		enableButtonGroup.add(trueRadioButton);
		enableButtonGroup.add(falseRadioButton);
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(trueRadioButton);
		add(Box.createHorizontalStrut(10));
		add(falseRadioButton);
	}
	
	public JBasicRadioButton getTrueRadioButton()
	{
		return trueRadioButton;
	}
	
	public JBasicRadioButton getFalseRadioButton()
	{
		return falseRadioButton;
	}	
	
	public boolean isTrue()
	{
		return trueRadioButton.isSelected();
	}
	
	public void setTrue(boolean flag)
	{
		trueRadioButton.setSelected(flag);
	}
	
	public void setEnabled(boolean enabled)
	{
		super.setEnabled(enabled);
		
		trueRadioButton.setEnabled(enabled);
		falseRadioButton.setEnabled(enabled);
	}
}