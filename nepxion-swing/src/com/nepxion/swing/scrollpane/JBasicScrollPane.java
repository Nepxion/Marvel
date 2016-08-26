package com.nepxion.swing.scrollpane;

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

import javax.swing.JScrollPane;

public class JBasicScrollPane
	extends JScrollPane
{
	/**
	 * Constructs with the default.
	 */
	public JBasicScrollPane()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial vertical scroll bar policy and horizontal scroll bar policy.
	 * @param vsbPolicy the vertical scroll bar policy value
	 * @param hsbPolicy the horizontal scroll bar policy value
	 */
	public JBasicScrollPane(int vsbPolicy, int hsbPolicy)
	{
		super(vsbPolicy, hsbPolicy);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial view.
	 * @param view the instance of Component
	 */
	public JBasicScrollPane(Component view)
	{
		super(view);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial view, vertical scroll bar policy and horizontal scroll bar policy.
	 * @param view the instance of Component
	 * @param vsbPolicy the vertical scroll bar policy value
	 * @param hsbPolicy the horizontal scroll bar policy value
	 */
	public JBasicScrollPane(Component view, int vsbPolicy, int hsbPolicy)
	{
		super(view, vsbPolicy, hsbPolicy);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		ScrollPaneManager.setPreferenceStyle(this);
	}
	
	/**
	 * Sets the label style.
	 */
	public void setLabelStyle()
	{
		ScrollPaneManager.setLabelStyle(this);
	}
}