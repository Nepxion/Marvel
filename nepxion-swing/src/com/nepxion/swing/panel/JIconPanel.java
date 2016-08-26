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
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.dimension.DimensionManager;

public class JIconPanel
	extends JPanel
{
	public JIconPanel(Icon icon, Dimension imageDimension)
	{
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0), BorderFactory.createLineBorder(Color.gray)));
		panel.setLayout(new BorderLayout());
		panel.add(new JLabel(icon), BorderLayout.CENTER);
		DimensionManager.setDimension(panel, imageDimension);
		
		setLayout(new BorderLayout());
		add(panel, BorderLayout.NORTH);
		add(Box.createVerticalGlue(), BorderLayout.CENTER);
	}
}