package com.nepxion.swing.tray;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.jeans.trayicon.TrayIconCallback;
import com.jeans.trayicon.TrayIconException;
import com.jeans.trayicon.WindowsTrayIcon;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.popupmenu.PopupMenuContext;
import com.nepxion.swing.topic.TopicContext;

public class JTray
{
	/**
	 * The instance of WindowsTrayIcon.
	 */
	private WindowsTrayIcon trayIcon;
	
	/**
	 * The instance of ITrayIconPopupMenu.
	 */
	private ITrayIconPopupMenu trayIconPopupMenu;
	
	/**
	 * The show balloon times value.
	 */
	private int showBalloonTimes = 0;
	
	/**
	 * The boolean value of alwaysShowBalloon.
	 */
	private boolean alwaysShowBalloon = false;
	
	/**
	 * The instance of JFrame.
	 */
	private JFrame frame;
	
	/**
	 * Constructs with the specified initial frame.
	 * @param frame the instance of JFrame
	 */
	public JTray(JFrame frame)
	{
		this(frame, PopupMenuContext.getTitle());
	}
	
	/**
	 * Constructs with the specified initial frame and title.
	 * @param frame the instance of JFrame
	 * @param title the title string
	 */
	public JTray(JFrame frame, String title)
	{
		this(frame, title, IconFactory.getSwingIcon("tray_java.png"), 16, 16);
	}
	
	/**
	 * Constructs with the specified initial frame and image icon.
	 * @param frame the instance of JFrame
	 * @param imageIcon the instance of ImageIcon
	 */
	public JTray(JFrame frame, ImageIcon imageIcon)
	{
		this(frame, PopupMenuContext.getTitle(), imageIcon);
	}
	
	/**
	 * Constructs with the specified initial frame, title and image icon.
	 * @param frame the instance of JFrame
	 * @param title the title string
	 * @param imageIcon the instance of ImageIcon
	 */
	public JTray(JFrame frame, String title, ImageIcon imageIcon)
	{
		this(frame, title, imageIcon, 16, 16);
	}
	
	/**
	 * Constructs with the specified initial frame, image icon, image icon width and image icon height.
	 * @param frame the instance of JFrame
	 * @param imageIcon the instance of ImageIcon
	 * @param imageIconWidth the image icon width value
	 * @param imageIconHeight the image icon height value
	 */
	public JTray(JFrame frame, ImageIcon imageIcon, int imageIconWidth, int imageIconHeight)
	{
		this(frame, PopupMenuContext.getTitle(), imageIcon, imageIconWidth, imageIconHeight);
	}
	
	/**
	 * Constructs with the specified initial frame, title, image icon, image icon width and image icon height.
	 * @param frame the instance of JFrame
	 * @param title the title string
	 * @param imageIcon the instance of ImageIcon
	 * @param imageIconWidth the image icon width value
	 * @param imageIconHeight the image icon height value
	 */
	public JTray(JFrame frame, String title, ImageIcon imageIcon, int imageIconWidth, int imageIconHeight)
	{
		this.frame = frame;
		this.frame.addWindowListener(new TrayWindowListener());
		
		WindowsTrayIcon.initTrayIcon(frame.getTitle());
		// WindowsTrayIcon.setWindowsMessageCallback(new TrayWindowsMessageCallback());
		// WindowsTrayIcon.sendWindowsMessage(frame.getTitle(), 1234);
		
		try
		{
			trayIcon = new WindowsTrayIcon(imageIcon.getImage(), imageIconWidth, imageIconHeight);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		catch (TrayIconException e)
		{
			e.printStackTrace();
		}
		trayIcon.setToolTipText(frame.getTitle());
		// trayIcon.addActionListener(new TrayIconActionListener());
		trayIcon.addMouseListener(new TrayIconMouseListener());
		// trayIcon.addBalloonListener(new TrayIconBalloonListener(this));
		
		if (System.getProperty("java.version").indexOf("1.6.0") > -1) // Swing TrayIcon PopupMenu can't fit for the JDK 1.6.0, should choose Awt TrayIcon PopupMenu
		{
			trayIconPopupMenu = new AwtTrayIconPopupMenu(this);
			trayIcon.setPopup((AwtTrayIconPopupMenu) trayIconPopupMenu);
		}
		else
		{
			trayIconPopupMenu = new SwingTrayIconPopupMenu(this, title);
			((SwingTrayIconPopupMenu) trayIconPopupMenu).setTrayIcon(trayIcon);
		}
	}
	
	/**
	 * Gets the tray icon.
	 * @return the instance of WindowsTrayIcon
	 */
	public WindowsTrayIcon getTrayIcon()
	{
		return trayIcon;
	}
	
	/**
	 * Gets the tray icon popup menu.
	 * @return the instance of ITrayIconPopupMenu
	 */
	public ITrayIconPopupMenu getTrayIconPopupMenu()
	{
		return trayIconPopupMenu;
	}
	
	/**
	 * Sets the visible.
	 * @param visible the instance of visible
	 */
	public void setVisible(boolean visible)
	{
		trayIcon.setVisible(visible);
	}
	
	/**
	 * Sets the always balloon shown.
	 * @param alwaysShowBalloon the instance of alwaysShowBalloon
	 */
	public void setAlwaysShowBalloon(boolean alwaysShowBalloon)
	{
		this.alwaysShowBalloon = alwaysShowBalloon;
	}
	
	/**
	 * Shows the balloon.
	 */
	public void showBalloon()
	{
		if (alwaysShowBalloon)
		{
			showBalloon(SwingLocale.getString("tray_title"), frame.getTitle());
		}
		else
		{
			if (showBalloonTimes == 0)
			{
				showBalloon(SwingLocale.getString("tray_title"), frame.getTitle());
				
				showBalloonTimes++;
			}
		}
	}
	
	/**
	 * Shows the balloon by a title and message.
	 * @param message the message string
	 * @param title the title string
	 */
	public void showBalloon(String message, String title)
	{
		showBalloon(message, title, 10000, WindowsTrayIcon.BALLOON_INFO);
	}
	
	/**
	 * Shows the balloon by a title and message.
	 * @param message the message string
	 * @param title the title string
	 * @param timeout the time out value
	 * @param flag the flag value
	 */
	public void showBalloon(String message, String title, int timeout, int flag)
	{
		WindowsTrayIcon.enableUnicodeConversion(WindowsTrayIcon.UNICODE_CONV_BALLOON, true);
		try
		{
			trayIcon.showBalloon(title, message, timeout, flag);
		}
		catch (TrayIconException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Flashes the window.
	 */
	public void flash()
	{
		try
		{
			WindowsTrayIcon.flashWindow(frame);
		}
		catch (TrayIconException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Restores the tray.
	 */
	public void restore()
	{
		frame.setVisible(!frame.isVisible());
		/*if (frame.isVisible())
		{
			if (frame.getExtendedState() == JFrame.ICONIFIED)
			{
				frame.setExtendedState(JFrame.NORMAL);
			}
		}*/
		
		trayIconPopupMenu.restore(frame.isVisible());
		if (!frame.isVisible())
		{
			showBalloon();
		}
	}
	
	/**
	 * Shows tha about component.
	 */
	public void about()
	{
		Component topicComponent = TopicContext.getTopicComponent();
		if (topicComponent == null)
		{
			return;
		}
		
		topicComponent.setVisible(true);
	}
	
	/**
	 * Exits the tray.
	 */
	public void exit()
	{
		WindowsTrayIcon.cleanUp();
		System.exit(0);
	}
	
	public class TrayIconActionListener
		implements ActionListener
	{
	    /**
	     * Invoked when an action occurs.
	     * @param e the instance of ActionEvent
	     */
		public void actionPerformed(ActionEvent e)
		{
			restore();
		}
	}
	
	public class TrayIconMouseListener
		extends MouseAdapter
	{
	    /**
	     * Invoked when the mouse button has been pressed on a component.
	     * @param e the instance of MouseEvent
	     */
		public void mousePressed(MouseEvent e)
		{
			if (e.getModifiers() == MouseEvent.BUTTON1_MASK)
			{
				restore();
			}
		}
	}
	
	public class TrayWindowListener
		extends WindowAdapter
	{
	    /**
	     * Invoked when the window is iconified.
	     * @param e the instance of WindowEvent
	     */
		public void windowIconified(WindowEvent e)
		{
			restore();
		}
		
	    /**
	     * Invoked when the window is closing.
	     * @param e the instance of WindowEvent
	     */
		public void windowClosing(WindowEvent e)
		{
			exit();
		}
	}
	
	public class TrayWindowsMessageCallback
		implements TrayIconCallback
	{
		/**
		 * Calls back.
		 * @param param the param value
		 */
		public int callback(int param)
		{
			return 4321;
		}
	}
}