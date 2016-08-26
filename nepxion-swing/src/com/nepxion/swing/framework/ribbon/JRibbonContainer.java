package com.nepxion.swing.framework.ribbon;

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
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.border.Border;

import com.nepxion.swing.container.JContainer;
import com.nepxion.swing.exception.ExceptionTracer;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.internalframe.InternalFrameManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.panel.JReflectionPanel;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;
import com.nepxion.swing.selector.checkbox.JCheckBoxSelector;
import com.nepxion.swing.tabbedpane.ITabbedPane;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;
import com.nepxion.swing.tabbedpane.TabbedPaneManager;

public class JRibbonContainer
	extends JContainer
{
	/**
	 * The container style of internal frame.
	 * The ribbon container displays as InternalFrame style which is a multi-windows style.
	 */
	public static final int CONTAINER_STYLE_INTERNAL_FRAME = 0;
	
	/**
	 * The container style of tabbed pane.
	 * The ribbon container displays as TabbedPane style which is a multi-windows style.
	 */
	public static final int CONTAINER_STYLE_TABBEDPANE = 1;
	
	/**
	 * The container style of panel.
	 * The ribbon container displays as Panel style which is a single-window style.
	 */
	public static final int CONTAINER_STYLE_PANEL = 2;
	
	/**
	 * The internal frame border.
	 */
	public static final Border INTERNAL_FRAME_BORDER = BorderFactory.createEmptyBorder(0, 0, 0, 0);
	
	/**
	 * The eclipse tabbed pane border.
	 */
	public static final Border ECLIPSE_TABBEDPANE_BORDER = BorderFactory.createEmptyBorder(-1, 0, 0, 0);
	
	/**
	 * The panel border.
	 */
	public static final Border PANEL_BORDER = BorderFactory.createEmptyBorder(2, 0, 0, 0);
	
	/**
	 * The instance of JDesktopPane.
	 */
	private JDesktopPane desktopPane;
	
	/**
	 * The instance of ITabbedPane.
	 */
	private ITabbedPane tabbedPane;
	
	/**
	 * The instance of JRibbonTweenPanel.
	 */
	private JRibbonTweenPanel panel;
	
	/**
	 * The instance of JCheckBoxSelector.
	 */
	private JCheckBoxSelector checkBoxSelector;
	
	/**
	 * The container style value.
	 */
	private int containerStyle = CONTAINER_STYLE_INTERNAL_FRAME;
	
	/**
	 * The maximum count.
	 * It is limited the count of ribbon components.
	 * If the count of ribbon components >= the maximum count, a warning dialog will show and it can't open more ribbon components.
	 */
	private int maximumCount = 8;
	
	/**
	 * Constructs with the default.
	 */
	public JRibbonContainer()
	{
		this(CONTAINER_STYLE_INTERNAL_FRAME);
	}
	
	/**
	 * Constructs with the specified initial container style.
	 * @param containerStyle the container style value
	 */
	public JRibbonContainer(final int containerStyle)
	{		
		this.containerStyle = containerStyle;
		
		desktopPane = new JDesktopPane();
		desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

		setLayout(new BorderLayout());
		addComponent(desktopPane, BorderLayout.CENTER);
		
		addContainerListener(new ContainerAdapter()
		{
		    public void componentAdded(ContainerEvent e)
		    {
		    	Object child = e.getChild();

		    	if (child instanceof JDesktopPane)
		    	{
		    		setBorder(INTERNAL_FRAME_BORDER);
		    	}
		    	else if (child instanceof JEclipseTabbedPane)
		    	{
		    		setBorder(ECLIPSE_TABBEDPANE_BORDER);
		    	}
		    	else if (child instanceof JContainer)
		    	{
		    		setBorder(PANEL_BORDER);
		    	}
		    }
		}
		);
	}
	
	/**
	 * Adds the ribbon component to the ribbon container.
	 * If the name is as the handle of ribbon component, it should be exclusive.
	 * @param name the name string
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text
	 * @param component the instance of IRibbonComponent and it also is the instanceof JComponent
	 */
	public void addRibbonComponent(String name, String title, Icon icon, String toolTipText, IRibbonComponent component)
	{
		JComponent ribbonComponent = (JComponent) component;
		JComponent handler = retrieveRibbonComponent(ribbonComponent);
		
		switch (containerStyle)
		{
			case CONTAINER_STYLE_INTERNAL_FRAME :
			{	
				JInternalFrame internalFrame = null;
				
				if (handler == null)
				{
					JInternalFrame[] internalFrames = desktopPane.getAllFrames();
					
					if (internalFrames.length >= maximumCount)
					{
						JBasicOptionPane.showMessageDialog(HandleManager.getFrame(this), SwingLocale.getString("open_panel_count_limited") + " " + maximumCount + " " + SwingLocale.getString("open_panel_suffix"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
						
						return;
					}	
					
					int x = 0;
					int y = 0;
					
					if (internalFrames.length != 0)
					{	
						x = (6 + 10) * internalFrames.length;
						y = (25 + 10) * internalFrames.length;
					}
					
					int width = ribbonComponent.getSize().width;
					int height = ribbonComponent.getSize().height;
					
					ribbonComponent.setName(name);
					
					internalFrame = new JInternalFrame(title, true, true, true, true);
					internalFrame.setName(name);
					internalFrame.setFrameIcon(icon);
					internalFrame.setToolTipText(toolTipText);
					internalFrame.setContentPane(ribbonComponent);
					internalFrame.setSize(width != 0 ? width  + 50 : 640, height != 0 ? height + 50 : 480);
					internalFrame.setLocation(x, y);
					internalFrame.setVisible(true);
					
					desktopPane.add(internalFrame);
				}
				else
				{
					internalFrame = (JInternalFrame) handler;
				}
				
				try
				{
					internalFrame.toFront();
					internalFrame.setSelected(true);
				}
				catch (PropertyVetoException e)
				{
					e.printStackTrace();
				}
				break;
			}
			case CONTAINER_STYLE_TABBEDPANE :
			{
				JComponent tabbedComponent = (JComponent) tabbedPane;
				if (tabbedComponent.getParent() == null)
				{
					addComponent(tabbedComponent, BorderLayout.CENTER);
				}
				
				if (handler == null)
				{
					if (tabbedPane.getTabCount() >= maximumCount)
					{
						JBasicOptionPane.showMessageDialog(HandleManager.getFrame(this), SwingLocale.getString("open_panel_count_limited") + " " + maximumCount + " " + SwingLocale.getString("open_panel_suffix"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
						
						return;
					}	
					
					tabbedPane.addTab(title, icon, ribbonComponent, toolTipText, true);
					tabbedPane.setSelectedComponent(ribbonComponent);
					
					ribbonComponent.setName(name);
				}
				else
				{
					tabbedPane.setSelectedComponent(handler);
				}
				break;
			}
			case CONTAINER_STYLE_PANEL :
			{
				if (panel.getParent() == null)
				{
					desktopPane.add(panel);
				}
				
				if (handler == null)
				{
					panel.setTitle(title);
					panel.setIcon(icon != null ? icon : IconFactory.getSwingIcon("component/internal_frame_16.png"));
					panel.setToolTipText(toolTipText);
					panel.setContentPane(ribbonComponent);
				}
				break;
			}
		}
	}
	
	/**
	 * Closes the ribbon components by a check box selector.
	 */
	public void closeRibbonComponent()
	{
		switch (containerStyle)
		{
			case CONTAINER_STYLE_INTERNAL_FRAME :
				InternalFrameManager.showCloseDialog(desktopPane, checkBoxSelector);
				break;
			case CONTAINER_STYLE_TABBEDPANE :
				TabbedPaneManager.showCloseDialog(tabbedPane, checkBoxSelector);
				break;
			case CONTAINER_STYLE_PANEL :
				closePanelChildren();
				break;
		}
	}
	
	/**
	 * Closes the panel children.
	 */
	private void closePanelChildren()
	{
		if (panel.getParent() != null && panel.getParent() == desktopPane)
		{	
			desktopPane.remove(panel);
		}
		
		addComponent(desktopPane, BorderLayout.CENTER);
		setBorder(INTERNAL_FRAME_BORDER);
	}
	
	/**
	 * Retrieves the ribbon component.
	 * If a given component is existed in the ribbon container, it will return the component, otherwise return null.
	 * @param component the instance of JComponent
	 * @return the instance of JComponent
	 */
	private JComponent retrieveRibbonComponent(JComponent component)
	{
		switch (containerStyle)
		{
			case CONTAINER_STYLE_INTERNAL_FRAME :
			{
				JInternalFrame[] internalFrames = desktopPane.getAllFrames();
				
				for (int i = 0; i < internalFrames.length; i++)
				{
					JInternalFrame internalFrame = internalFrames[i];
					
					JComponent c = (JComponent) internalFrame.getContentPane();
					
					if (c == component)
					{
						return internalFrame;
					}
				}
				
				return null;
			}
			case CONTAINER_STYLE_TABBEDPANE :
			{
				if (tabbedPane == null)
				{
					IllegalArgumentException e = new IllegalArgumentException(SwingLocale.getString("ribbon_tabbedpane_not_register"));
					
					ExceptionTracer.traceException(HandleManager.getFrame(this), e);
					
					throw e;
				}
				
				for (int i = 0; i < tabbedPane.getTabCount(); i++)
				{
					JComponent c = (JComponent) tabbedPane.getComponentAt(i);
					
					if (c == component)
					{
						return component;
					}
				}
				
				return null;
			}
			case CONTAINER_STYLE_PANEL :
			{
				if (panel == null)
				{
					IllegalArgumentException e = new IllegalArgumentException(SwingLocale.getString("ribbon_panel_not_register"));
					
					ExceptionTracer.traceException(HandleManager.getFrame(this), e);
					
					throw e;
				}
				
				for (int i = 0; i < panel.getComponentCount(); i++)
				{
					JComponent c = (JComponent) panel.getComponent(i);
					
					if (c == component)
					{
						return component;
					}
				}
				
				return null;
			} 
		}
		
		return null;
	}
	
	/**
	 * Gets the container style.
	 * @return the container style value
	 */
	public int getContainerStyle()
	{
		return containerStyle;
	}
	
	/**
	 * Sets the container style.
	 * @param containerStyle the container style value
	 */
	public void setContainerStyle(int containerStyle)
	{
		this.containerStyle = containerStyle;
	}
	
	/**
	 * Gets the maximum count.
	 * @return the maximum count value
	 */
	public int getMaximumCount()
	{
		return maximumCount;
	}
	
	/**
	 * Sets the maximum count.
	 * @param maximumCount the maximum count value
	 */
	public void setMaximumCount(int maximumCount)
	{
		this.maximumCount = maximumCount;
	}
	
	/**
	 * Gets the desktop pane.
	 * @return the instance of JDesktopPane
	 */
	public JDesktopPane getDesktopPane()
	{
		return desktopPane;
	}
	
	/**
	 * Gets the tabbed pane.
	 * @return the instance of ITabbedPane
	 */
	public ITabbedPane getTabbedPane()
	{
		return tabbedPane;
	}
	
	/**
	 * Sets the tabbed pane.
	 * @param tabbedPane the instance of ITabbedPane
	 */
	public void setTabbedPane(final ITabbedPane tabbedPane)
	{
		this.tabbedPane = tabbedPane;
		
		tabbedPane.setPopupMenu(new JBasicPopupMenu(), true);
		
		JComponent tabbedComponent = (JComponent) tabbedPane;
		tabbedComponent.addPropertyChangeListener(new PropertyChangeListener()
		{
			public void propertyChange(PropertyChangeEvent e)
			{
				if (e.getPropertyName().equals("__index_to_remove__"))
				{
					if (tabbedPane.getTabCount() == 0)
					{
						addComponent(desktopPane, BorderLayout.CENTER);
						
						setBorder(INTERNAL_FRAME_BORDER);
					}
				}
			}
		}
		);
	}	
	
	/**
	 * Gets the panel.
	 * @return the instance of JReflectionPanel
	 */
	public JReflectionPanel getPanel()
	{
		return panel;
	}
	
	/**
	 * Sets the panel.
	 * @param panel the instance of JRibbonTweenPanel
	 */
	public void setPanel(final JRibbonTweenPanel panel)
	{
		this.panel = panel;
		
		addComponentListener(new ComponentAdapter()
		{
			public void componentResized(ComponentEvent e)
			{
				if (containerStyle == CONTAINER_STYLE_PANEL)
				{
					Dimension desktopSize = desktopPane.getSize();
					Point desktopPoint = desktopPane.getLocation();
					
					Dimension panelSize = new Dimension(desktopSize.width - panel.getWidthOffset() * 2, desktopSize.height - panel.getHeightOffset() * 2);
					
					panel.setSize(panelSize);
					panel.setLocation((int) (desktopSize.width - panelSize.width) / 2 + desktopPoint.x, (int) (desktopSize.height - panelSize.height) / 2 + desktopPoint.y);
				}
			}
		}
		);
	}
}