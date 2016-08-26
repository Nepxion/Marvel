package com.nepxion.swing.panel.option;

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

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.container.ContainerManager;

public class JOptionPanel
	extends JPanel
{
	private JLabel label;
	
	private Component content;
	
	public JOptionPanel()
	{
		label = new JLabel();
		
		JPanel iconPanel = new JPanel();
		iconPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
		iconPanel.setLayout(new BorderLayout());
		iconPanel.add(label, BorderLayout.NORTH);
		iconPanel.add(Box.createVerticalGlue(), BorderLayout.CENTER);
		
		setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
		setLayout(new BorderLayout());
		add(iconPanel, BorderLayout.WEST);		
	}
	
	public void setIcon(Icon icon)
	{
		label.setIcon(icon);
	}
	
	public Component getContent()
	{
		return content;
	}
	
	public void setContent(Component content)
	{
		if (this.content == content)
		{
			return;
		}	
		
		if (this.content != null)
		{
			remove(this.content);
		}
		
		this.content = content;
		
		add(content, BorderLayout.CENTER);
		
		ContainerManager.update(this);
	}
}