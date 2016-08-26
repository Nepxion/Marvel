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

import com.jeans.trayicon.TrayBalloonEvent;
import com.jeans.trayicon.TrayBalloonListener;

public class TrayIconBalloonListener
	implements TrayBalloonListener
{
	/**
	 * The instance of JTray.
	 */
	private JTray tray;
	
	/**
	 * Constructs with the specified initial tray.
	 * @param tray the instance of JTray
	 */
	public TrayIconBalloonListener(JTray tray)
	{
		this.tray = tray;
	}
	
	/**
	 * Invoked when the balloon is changed.
	 * @param e the instance of TrayBalloonEvent
	 */
	public void balloonChanged(TrayBalloonEvent e)
	{
		if ((e.getMask() & TrayBalloonEvent.SHOW) != 0)
		{
		}
		else if ((e.getMask() & TrayBalloonEvent.HIDE) != 0)
		{
		}
		else if ((e.getMask() & TrayBalloonEvent.TIMEOUT) != 0)
		{
		}
		else if ((e.getMask() & TrayBalloonEvent.CLICK) != 0)
		{
		}
	}
}