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

import com.nepxion.demo.component.splash.DemoCaptionSplashWindow;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;

public class DemoCaptionSplashWindowPanel
	extends JPanel
{
	public DemoCaptionSplashWindowPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new CaptionSplashWindowPanel());
	}
	
	public class CaptionSplashWindowPanel
		extends JPanel
	{
		public CaptionSplashWindowPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Caption Splash Window"));
			
			JBasicButton captionSplashWindowButton = new JBasicButton("Caption Splash Window", IconFactory.getSwingIcon("component/internal_frame_16.png"), "Caption Splash Window");
			captionSplashWindowButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					DemoCaptionSplashWindow captionSplashWindow = new DemoCaptionSplashWindow();
					captionSplashWindow.setVisible(true);
				}
			}
			);
			add(captionSplashWindowButton);
			
			ButtonManager.updateUI(this);
		}
	}
}