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
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.splitpane.DividerActionListener;

public class JCornerSplitScrollPane
	extends JCornerScrollPane
{
	/**
	 * The horizontal tool bar.
	 */
	private JPanel horizontalToolBar;
	
	/**
	 * The vertical tool bar.
	 */
	private JPanel verticalToolBar;
	
	/**
	 * The direct left button.
	 */
	private JBasicButton directLeftButton;
	
	/**
	 * The direct right button.
	 */
	private JBasicButton directRightButton;
	
	/**
	 * The direct top button.
	 */
	private JBasicButton directTopButton;
	
	/**
	 * The direct bottom button.
	 */
	private JBasicButton directBottomButton;
	
	/**
	 * Constructs with the default.
	 */
	public JCornerSplitScrollPane()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial vertical scroll bar policy and horizontal scroll bar policy.
	 * @param vsbPolicy the vertical scroll bar policy value
	 * @param hsbPolicy the horizontal scroll bar policy value
	 */
	public JCornerSplitScrollPane(int vsbPolicy, int hsbPolicy)
	{
		super(vsbPolicy, hsbPolicy);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial view.
	 * @param view the instance of Component
	 */
	public JCornerSplitScrollPane(Component view)
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
	public JCornerSplitScrollPane(Component view, int vsbPolicy, int hsbPolicy)
	{
		super(view, vsbPolicy, hsbPolicy);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		directLeftButton = new JBasicButton(IconFactory.getSwingIcon("direction_west.png"), SwingLocale.getString("direct_left"));
		directRightButton = new JBasicButton(IconFactory.getSwingIcon("direction_east.png"), SwingLocale.getString("direct_right"));
		
		horizontalToolBar = new JPanel();
		horizontalToolBar.setLayout(new BoxLayout(horizontalToolBar, BoxLayout.X_AXIS));
		horizontalToolBar.add(directLeftButton);
		horizontalToolBar.add(directRightButton);
		ButtonManager.updateUI(horizontalToolBar, new Dimension(16, 16));
		
		directTopButton = new JBasicButton(IconFactory.getSwingIcon("direction_north.png"), SwingLocale.getString("direct_top"));
		directBottomButton = new JBasicButton(IconFactory.getSwingIcon("direction_south.png"), SwingLocale.getString("direct_bottom"));
		
		verticalToolBar = new JPanel();
		verticalToolBar.setLayout(new BoxLayout(verticalToolBar, BoxLayout.Y_AXIS));
		verticalToolBar.add(directTopButton);
		verticalToolBar.add(directBottomButton);
		ButtonManager.updateUI(verticalToolBar, new Dimension(16, 16));
	}
	
	/**
	 * Sets the set horizontal split pane.
	 * @param horizontalSplitPane the instance of JSplitPane
	 */
	public void setHorizontalSplitPane(JSplitPane horizontalSplitPane)
	{
		for (int i = 0; i < directLeftButton.getActionListeners().length; i++)
		{
			directLeftButton.removeActionListener(directLeftButton.getActionListeners()[i]);
		}
		directLeftButton.addActionListener(new DividerActionListener(horizontalSplitPane, true));
		
		for (int i = 0; i < directRightButton.getActionListeners().length; i++)
		{
			directRightButton.removeActionListener(directRightButton.getActionListeners()[i]);
		}
		directRightButton.addActionListener(new DividerActionListener(horizontalSplitPane, false));
	}
	
	/**
	 * Sets the set vertical split pane.
	 * @param verticalSplitPane the instance of JSplitPane
	 */
	public void setVerticalSplitPane(JSplitPane verticalSplitPane)
	{
		for (int i = 0; i < directTopButton.getActionListeners().length; i++)
		{
			directTopButton.removeActionListener(directTopButton.getActionListeners()[i]);
		}
		directTopButton.addActionListener(new DividerActionListener(verticalSplitPane, true));
		
		for (int i = 0; i < directBottomButton.getActionListeners().length; i++)
		{
			directBottomButton.removeActionListener(directBottomButton.getActionListeners()[i]);
		}
		directBottomButton.addActionListener(new DividerActionListener(verticalSplitPane, false));
	}
	
	/**
	 * Shows the horizontal tool bar.
	 */
	public void showHorizontalToolBar()
	{
		setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_ALWAYS);
		setScrollBarCorner(JCornerScrollPane.HORIZONTAL_LEADING, horizontalToolBar);
	}
	
	/**
	 * Shows the vertical tool bar.
	 */
	public void showVerticalToolBar()
	{
		setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
		setScrollBarCorner(JCornerScrollPane.VERTICAL_BOTTOM, verticalToolBar);
	}
	
	/**
	 * Gets the horizontal tool bar. 
	 * @return the horizontal tool bar 
	 */
	public JPanel getHorizontalToolBar()
	{
		return horizontalToolBar;
	}
	
	/**
	 * Gets the vertical tool bar. 
	 * @return the vertical tool bar 
	 */
	public JPanel getVerticalToolBar()
	{
		return verticalToolBar;
	}
}