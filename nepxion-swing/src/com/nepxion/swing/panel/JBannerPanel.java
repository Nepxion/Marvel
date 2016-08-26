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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.border.BevelBorder;

import com.jidesoft.dialog.BannerPanel;

public class JBannerPanel
	extends BannerPanel
{
	/**
	 * 
	 */
	public JBannerPanel()
	{
		super();
		
		initComponents();
	}
	
	public JBannerPanel(String title)
	{
		super(title);
		
		initComponents();
	}
	
	public JBannerPanel(String title, String subtitle)
	{
		super(title, subtitle);
		
		initComponents();
	}
	
	public JBannerPanel(String title, String subtitle, ImageIcon titleIcon)
	{
		super(title, subtitle, titleIcon);
		
		initComponents();
	}
	
	public JBannerPanel(String title, String subtitle, JComponent iconComponent)
	{
		super(title, subtitle, iconComponent);
		
		initComponents();
	}
	
	private void initComponents()
	{
		// setFont(new Font("Tahoma", Font.PLAIN, 11));
		setBackground(Color.white);
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
	}
}