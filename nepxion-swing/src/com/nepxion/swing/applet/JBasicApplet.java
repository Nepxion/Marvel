package com.nepxion.swing.applet;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.net.URL;

import javax.swing.JApplet;

public class JBasicApplet
	extends JApplet
{			
	/**
	 * Constructs with the default.
	 */
	public JBasicApplet()
	{
	}
	
	/**
	 * Initializes the applet.
	 * It is overridden from JApplet.
	 */
	public void init()
	{
		super.init();
		
		initContext();
	}
	
	/**
	 * Initializes the applet context.
	 * If it is overridden by the child class, the method will be executed.
	 */
	public void initContext()
	{
		
	}
	
	/**
	 * Gets the host.
	 * @return the host string
	 */
	public String getHost()
	{
		URL codeBase = getCodeBase();
		String url = codeBase.toString();
		String host = url.substring(0, url.lastIndexOf(":"));
		
		return host;
	}
}