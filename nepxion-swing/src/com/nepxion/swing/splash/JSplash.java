package com.nepxion.swing.splash;

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
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JSplash
	extends JPanel
{
	private JLabel label;
	
	public JSplash(Icon splashIcon)
	{
		label = new JLabel(splashIcon);

		setBorder(BorderFactory.createLineBorder(new Color(121, 121, 121)));
		setLayout(new BorderLayout());
		add(label, BorderLayout.CENTER);
	}
	
	public JLabel getLabel()
	{
		return label;
	}
}