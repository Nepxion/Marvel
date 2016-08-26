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

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.scrollpane.JBasicScrollPane;

public class JInformationPanel
	extends JBasicScrollPane implements SwingConstants
{
	private JLabel label;
	private JPanel panel;
	
	public JInformationPanel()
	{
		this(HORIZONTAL);
	}
	
	public JInformationPanel(int iconTextLayout)
	{
		this(iconTextLayout, 10);
	}
	
	public JInformationPanel(int iconTextLayout, int iconTextGap)
	{
		this(null, null, iconTextLayout, iconTextGap);
	}
	
	public JInformationPanel(Icon icon)
	{
		this(null, icon);
	}
	
	public JInformationPanel(Icon icon, int iconTextLayout)
	{
		this(null, icon, iconTextLayout);
	}
	
	public JInformationPanel(Icon icon, int iconTextLayout, int iconTextGap)
	{
		this(null, icon, iconTextLayout, iconTextGap);
	}
	
	public JInformationPanel(String text, Icon icon)
	{
		this(text, icon, HORIZONTAL);
	}
	
	public JInformationPanel(String text, Icon icon, int iconTextLayout)
	{
		this(text, icon, iconTextLayout, 10);
	}
	
	public JInformationPanel(String text, Icon icon, int iconTextLayout, int iconTextGap)
	{
		label = new JLabel();
		
		setText(text);
		setIcon(icon);
		setIconTextLayout(iconTextLayout);
		setIconTextGap(iconTextGap);
		
		double[][] size = 
		{ 
			{TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL}, 
			{TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL}
		};
		panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLayout(new TableLayout(size));
		panel.add(label, "1, 1");
		
		getViewport().add(panel);
	}
	
	public void setIconTextLayout(int iconTextLayout)
	{
		if (iconTextLayout == VERTICAL)
		{
			label.setHorizontalTextPosition(CENTER);
			label.setVerticalTextPosition(BOTTOM);
		}
		else if (iconTextLayout == HORIZONTAL)
		{
			label.setHorizontalTextPosition(TRAILING);
			label.setVerticalTextPosition(CENTER);
		}
	}
	
	public void setIconTextGap(int iconTextGap)
	{
		label.setIconTextGap(iconTextGap);
	}
	
	public void setText(String text)
	{
		label.setText(text);
	}
	
	public void setIcon(Icon icon)
	{
		label.setIcon(icon);
	}
	
	public JLabel getLabel()
	{
		return label;
	}
	
	public void setViewBackground(Color background)
	{
		getViewport().setBackground(background);
		panel.setBackground(background);
	}
}