package com.nepxion.demo.component.window;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.demo.component.splash.DemoSplashWindow;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;

public class DemoSplashWindowPanel
	extends JPanel
{
	public DemoSplashWindowPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new SplashWindowPanel());
	}
	
	public class SplashWindowPanel
		extends JPanel
	{
		public SplashWindowPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Splash Window"));
			
			JBasicButton splashWindowButton = new JBasicButton("Splash Window", IconFactory.getSwingIcon("component/internal_frame_16.png"), "Splash Window");
			splashWindowButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					DemoSplashWindow splashWindow = new DemoSplashWindow();
					splashWindow.setVisible(true);
				}
			}
			);
			add(splashWindowButton);
			
			ButtonManager.updateUI(this);
		}
	}
}