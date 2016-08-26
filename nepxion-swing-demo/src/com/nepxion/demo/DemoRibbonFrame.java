package com.nepxion.demo;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.SwingUtilities;

import com.nepxion.demo.component.splash.DemoSplashWindow;
import com.nepxion.swing.context.DataContextInitializer;
import com.nepxion.swing.context.UIContextInitializer;
import com.nepxion.swing.framework.JFrameWorkFrame;
import com.nepxion.swing.framework.ribbon.RibbonContextInitializer;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tray.JTray;

public class DemoRibbonFrame
	extends JFrameWorkFrame
{
	public DemoRibbonFrame()
	{
		super("Nepxion Swing", IconFactory.getSwingIcon("tray_java.png")); // new Dimension(850, 650)
				
		DemoRibbonHierarchy hierarchy = new DemoRibbonHierarchy();
		setHierarchy(hierarchy);
	}
	
	public static void main(String[] args)
	{		
		new DataContextInitializer().initialize();
		new UIContextInitializer().initialize();
		new RibbonContextInitializer().initialize();
		
		final DemoSplashWindow splashWindow = new DemoSplashWindow();
		splashWindow.setVisible(true);
		
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
			
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				DemoRibbonFrame frame = new DemoRibbonFrame();
				frame.setExtendedState(MAXIMIZED_BOTH);
				
				//JTray tray = new JTray(frame);
				
				splashWindow.setVisible(false);
				//tray.setVisible(true);
				frame.setVisible(true);
				frame.toFront();
			}
		}
		);
	}
}