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

import java.awt.Color;
import java.awt.event.HierarchyEvent;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.listener.DisplayAbilityListener;
import com.nepxion.swing.panel.JCaptionPanel;

public class JCaptionSplash
	extends JPanel
{
	/**
	 * 
	 */
	private JCaptionPanel captionPanel;
	
	public JCaptionSplash(Icon splashIcon, Color splashColor, int[] captionStartPosition, int[] captionSize, String[] caption)
	{
		JLabel label = new JLabel(splashIcon);
		
		captionPanel = new JCaptionPanel();
		captionPanel.setForeground(splashColor);
		captionPanel.setCaption(caption);
		captionPanel.setAutoAdaptSize(true);
		captionPanel.setOpaque(false);
		captionPanel.setSpeed(50);
		
		double[][] size = 
		{ 
			{captionStartPosition[0], captionSize[0], TableLayout.FILL}, 
			{captionStartPosition[1], captionSize[1], TableLayout.FILL}
		};		
		
		setBorder(BorderFactory.createLineBorder(new Color(121, 121, 121)));
		setLayout(new TableLayout(size));
		add(captionPanel, "1, 1");
		add(label, "0, 0, 2, 2");
		
		captionPanel.addHierarchyListener(new DisplayAbilityListener()
		{
			public void displayAbilityChanged(HierarchyEvent e)
			{
				SwingUtilities.invokeLater(new Runnable()
				{
					public void run()
					{
						if (captionPanel.isShowing())
						{
							captionPanel.start();
						}
						else
						{
							captionPanel.stop();
						}
					}
				}
				);
			}
		}
		);
	}
	
	public void start()
	{
		captionPanel.start();
	}
	
	public void stop()
	{
		captionPanel.stop();
	}
	
	public JCaptionPanel getCaptionPanel()
	{
		return captionPanel;
	}
}