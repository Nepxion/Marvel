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

public interface JFrameWorkWindow
{
	/**
	 * Sets the hierarchy to the framework window.
	 * The hierarchy is exclusive in the framework window which usually is JFrameWorkFrame, JFrameWorkApplet or JFrameWorkDialog.
	 * @param frameWorkHierarchy the instance of JFrameWorkHierarchy
	 */
	public void setHierarchy(JFrameWorkHierarchy frameWorkHierarchy);
	
	/**
	 * Gets the hierarchy from the framework window.
	 * The hierarchy is exclusive in the framework window which usually is JFrameWorkFrame, JFrameWorkApplet or JFrameWorkDialog.
	 * @return the instance of JFrameWorkHierarchy
	 */
	public JFrameWorkHierarchy getHierarchy();
}