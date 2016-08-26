package com.nepxion.swing.framework.reflection;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JDesktopPane;
import javax.swing.JPanel;

import com.nepxion.swing.container.ContainerManager;
import com.nepxion.swing.panel.JReflectionPanel;

public class JReflectionHierarchy
	extends JPanel
{
	/**
	 * The desktop pane.
	 */
	private JDesktopPane desktopPane;
	
	/**
	 * The reflection panel.
	 */
	private JReflectionPanel reflectionPanel;
	
	/**
	 * The content pane.
	 */
	private Component contentPane;
	
	/**
	 * The width offset value.
	 */
	private int widthOffset;
	
	/**
	 * The height offset value.
	 */
	private int heightOffset;
	
	/**
	 * Constructs with the specified initial width offset and height offset.
	 * @param widthOffset the width offset value
	 * @param heightOffset the height offset value
	 */
	public JReflectionHierarchy(final int widthOffset, final int heightOffset)
	{	
		this.widthOffset = widthOffset;
		this.heightOffset = heightOffset;
		
		reflectionPanel = new JReflectionPanel();
		
		desktopPane = new JDesktopPane();
		desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		desktopPane.add(reflectionPanel);
		
		setLayout(new BorderLayout());
		add(desktopPane, BorderLayout.CENTER);
		addComponentListener(new ComponentAdapter()
		{
			public void componentResized(ComponentEvent e)
			{
				Dimension desktopSize = desktopPane.getSize();
				Point desktopPoint = desktopPane.getLocation();
				
				Dimension panelSize = new Dimension(desktopSize.width - widthOffset * 2, desktopSize.height - heightOffset * 2);
				
				reflectionPanel.setSize(panelSize);
				reflectionPanel.setLocation((int) (desktopSize.width - panelSize.width) / 2 + desktopPoint.x, (int) (desktopSize.height - panelSize.height) / 2 + desktopPoint.y);
				
				ContainerManager.update(reflectionPanel);
			}
		}
		);
	}
	
	/**
	 * Gets the width offset.
	 * @return the width offset value
	 */
	public int getWidthOffset()
	{
		return widthOffset;
	}
	
	/**
	 * Gets the height offset.
	 * @return the height offset value
	 */
	public int getHeightOffset()
	{
		return heightOffset;
	}
	
	/**
	 * Gets the content pane.
	 * @return the instance of Component
	 */
	public Component getContentPane()
	{
		return contentPane;
	}
	
	/**
	 * Sets the content pane.
	 * @param contentPane the instance of Component
	 */
	public void setContentPane(Component contentPane)
	{
		if (this.contentPane == contentPane)
		{
			return;
		}	
		
		if (this.contentPane != null)
		{
			reflectionPanel.remove(this.contentPane);
		}
		
		this.contentPane = contentPane;
		
		reflectionPanel.setContent(contentPane);
		
		ContainerManager.update(reflectionPanel);
	}
}