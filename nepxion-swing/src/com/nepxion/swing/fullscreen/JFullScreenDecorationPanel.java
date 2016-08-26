package com.nepxion.swing.fullscreen;

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

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JPanel;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.panel.decoration.JDecorationPanel;
import com.nepxion.swing.style.framework.IStyle;

public class JFullScreenDecorationPanel
	extends JDecorationPanel
{
	/**
	 * The instance of ToolBar.
	 */
	private ToolBar toolBar;
	
	/**
	 * Constructs with the specified initial title and icon.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JFullScreenDecorationPanel(String title, Icon icon, String toolTipText)
	{
		this(title, icon, toolTipText, true);
	}
	
	/**
	 * Constructs with the specified initial title, icon and selected.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 */
	public JFullScreenDecorationPanel(String title, Icon icon, String toolTipText, boolean selected)
	{
		super(title, icon, toolTipText, selected);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial title, icon and style.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param style the instance of IStyle
	 */
	public JFullScreenDecorationPanel(String title, Icon icon, String toolTipText, IStyle style)
	{
		this(title, icon, toolTipText, true, style);
	}
	
	/**
	 * Constructs with the specified initial title, icon, selected and style.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 * @param style the instance of IStyle
	 */
	public JFullScreenDecorationPanel(String title, Icon icon, String toolTipText, boolean selected, IStyle style)
	{
		super(title, icon, toolTipText, selected, style);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		toolBar = new ToolBar();
		getHeader().add(toolBar, BorderLayout.EAST);
		
		FullScreenSupport fullScreenSupport = new FullScreenSupport(this);
		FullScreenRegister fullScreenRegister = new FullScreenRegister(fullScreenSupport);
		fullScreenRegister.register(getHeaderContainer());
		fullScreenRegister.register(getToolBar().getMaximizeButton());
	}
	
	/**
	 * Gets the tool bar.
	 * @return the instance of ToolBar
	 */
	public ToolBar getToolBar()
	{
		return toolBar;
	}
	
	public class ToolBar
		extends JPanel
	{
		/**
		 * The maximize button.
		 */
		private JBasicButton maximizeButton;
		
		/**
		 * Constructs with the default.
		 */
		public ToolBar()
		{
			maximizeButton = FullScreenManager.createMaximizeButton(false);
			add(maximizeButton);
			
			add(Box.createHorizontalStrut(1));
			
			ButtonManager.updateUI(this, new Dimension(20, 20), true);
			
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setOpaque(false);
		}
		
		/**
		 * Gets the maximize button.
		 * @return the instance of JBasicButton
		 */
		public JBasicButton getMaximizeButton()
		{
			return maximizeButton;
		}
	}
}