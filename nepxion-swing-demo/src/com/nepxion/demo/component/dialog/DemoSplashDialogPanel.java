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

import com.nepxion.demo.component.splash.DemoSplashDialog;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;

public class DemoSplashDialogPanel
	extends JPanel
{
	public DemoSplashDialogPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new SplashDialogPanel());
	}
	
	public class SplashDialogPanel
		extends JPanel
	{
		public SplashDialogPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Splash Dialog"));
			
			JBasicButton splashDialogButton = new JBasicButton("Splash Dialog", IconFactory.getSwingIcon("component/dialog_16.png"), "Splash Dialog");
			splashDialogButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					DemoSplashDialog splashDialog = new DemoSplashDialog();
					splashDialog.setVisible(true);
					splashDialog.dispose();
				}
			}
			);
			add(splashDialogButton);
			
			ButtonManager.updateUI(this);
		}
	}
}