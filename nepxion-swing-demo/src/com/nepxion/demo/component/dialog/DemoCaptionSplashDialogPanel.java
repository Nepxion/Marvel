package com.nepxion.demo.component.dialog;

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

import com.nepxion.demo.component.splash.DemoCaptionSplashDialog;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;

public class DemoCaptionSplashDialogPanel
	extends JPanel
{
	public DemoCaptionSplashDialogPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new CaptionSplashDialogPanel());
	}
	
	public class CaptionSplashDialogPanel
		extends JPanel
	{
		public CaptionSplashDialogPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Caption Splash Dialog"));
			
			JBasicButton captionSplashDialogButton = new JBasicButton("Caption Splash Dialog", IconFactory.getSwingIcon("component/dialog_16.png"), "Caption Splash Dialog");
			captionSplashDialogButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					DemoCaptionSplashDialog captionSplashDialog = new DemoCaptionSplashDialog();
					captionSplashDialog.setVisible(true);
					captionSplashDialog.dispose();
				}
			}
			);
			add(captionSplashDialogButton);
			
			ButtonManager.updateUI(this);
		}
	}
}