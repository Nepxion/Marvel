package com.nepxion.swing.framework;

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

import javax.swing.JComponent;

import com.nepxion.swing.applet.JBasicApplet;
import com.nepxion.swing.style.framework.IStyle;
import com.nepxion.swing.style.framework.StyleManager;

public class JFrameWorkApplet
	extends JBasicApplet implements JFrameWorkWindow
{
	/**
	 * The instance of JFrameWorkHierarchy.
	 */
	private JFrameWorkHierarchy frameWorkHierarchy;
	
	/**
	 * Initializes the applet.
	 * It is overridden from JBasicApplet.
	 */
	public void init()
	{
		super.init();
		
		JComponent contentPane = (JComponent) getContentPane();
		
		IStyle style = StyleManager.getStyle();
		contentPane.setBorder(style.getBorder());
		contentPane.setBackground(Color.white);
	}
	
	/**
	 * Sets the hierarchy.
	 * @param frameWorkHierarchy the instance of JFrameWorkHierarchy
	 */
	public void setHierarchy(JFrameWorkHierarchy frameWorkHierarchy)
	{
		this.frameWorkHierarchy = frameWorkHierarchy;
		
		if (getContentPane().getComponentCount() > 0)
		{
			getContentPane().removeAll();
		}
		getContentPane().add(frameWorkHierarchy);
	}
	
	/**
	 * Gets the hierarchy.
	 * @return the instance of JFrameWorkHierarchy
	 */
	public JFrameWorkHierarchy getHierarchy()
	{
		return frameWorkHierarchy;
	}
}