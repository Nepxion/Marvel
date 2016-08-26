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
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.action.JAction;
import com.nepxion.swing.border.LineBorder;
import com.nepxion.swing.gradient.JGradientPainter;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.toolbar.JBasicToolBar;

public class JRibbon
	extends JPanel
{	
	/**
	 * The button style of normal.
	 */
	public static final int BUTTON_STYLE_NORMAL = 0;
	
	/**
	 * The button style of hover.
	 */
	public static final int BUTTON_STYLE_HOVER = 1;
	
	/**
	 * The button style of selected.
	 */
	public static final int BUTTON_STYLE_SELECTED = 2;
	
	/**
	 * The button style string.
	 */
	public static final String BUTTON_STYLE = "buttonStyle";	
	
	/**
	 * The instance of JBasicToolBar.
	 */
	private JBasicToolBar toolBar;
	
	/**
	 * The instance of JLabel.
	 */
	private JLabel label;
	
	/**
	 * The corner action.
	 */
	private JAction cornerAction;
	
	/**
	 * Constructs with the default.
	 */
	public JRibbon()
	{
		this(null, null);
	}
	
	/**
	 * Constructs with the specified initial title and tooltip text.
	 * @param title the title string
	 * @param toolTipText the tooltip text string
	 */
	public JRibbon(String title, String toolTipText)
	{
		this(title, null, toolTipText);
	}
	
	/**
	 * Constructs with the specified initial title, icon and tooltip text.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JRibbon(String title, Icon icon, String toolTipText)
	{
		toolBar = new JBasicToolBar()
		{
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				
				Graphics2D g2d = (Graphics2D) g;
				
				int width = getWidth();
				int height = getHeight();
				
				// Paint Background
				JGradientPainter.fastFill(g2d, new Rectangle(0, 0, width, 14), new Color(222, 235, 247), new Color(210, 224, 241), true);
				JGradientPainter.fastFill(g2d, new Rectangle(0, 14, width, height - 14), new Color(199, 216, 237), new Color(231, 242, 255), true);
			}
		};
		
		label = new JLabel(title, icon, JLabel.CENTER)
		{
			public void paintComponent(Graphics g)
			{
				Graphics2D g2d = (Graphics2D) g;
				
				int width = getWidth();
				int height = getHeight();
				
				// Paint Background
				Rectangle rectangle = new Rectangle(0, 0, width, height);
				JGradientPainter.fastFill(g2d, rectangle, new Color(194, 216, 241), new Color(192, 216, 240), true);
				
				// Paint Corner Button
				if (cornerAction != null)
				{	
					Integer buttonStyle = (Integer) cornerAction.getValue(BUTTON_STYLE);
					if (buttonStyle != null)
					{	
						switch (buttonStyle.intValue())
						{
							case BUTTON_STYLE_NORMAL :
							{
								break;
							}
							case BUTTON_STYLE_HOVER :
							{
								g2d.drawImage(IconFactory.getSwingIcon("ribbon/button_bg_hover_small.png").getImage(), width - 16, height - 15, null);
								break;
							}	
							case BUTTON_STYLE_SELECTED :
							{
								g2d.drawImage(IconFactory.getSwingIcon("ribbon/button_bg_selected_small.png").getImage(), width - 16, height - 15, null);
								break;
							}
						}
					}
					
					g.setColor(new Color(102, 142, 175));
					g.drawLine(width - 12, height - 12, width - 7, height - 12);
					g.drawLine(width - 12, height - 12, width - 12, height - 7);
					
					g.drawLine(width - 9, height - 9, width - 9, height - 9);
					g.drawLine(width - 8, height - 8, width - 6, height - 8);
					g.drawLine(width - 8, height - 7, width - 6, height - 7);
					g.drawLine(width - 9, height - 6, width - 6, height - 6);
					g.drawLine(width - 6, height - 9, width - 6, height - 6);
					
					g.setColor(Color.white);
					g.drawLine(width - 11, height - 11, width - 7, height - 11);
					g.drawLine(width - 11, height - 11, width - 11, height - 7);
					
					g.drawLine(width - 8, height - 9, width - 8, height - 9);
					g.drawLine(width - 8, height - 5, width - 6, height - 5);
					g.drawLine(width - 5, height - 9, width - 5, height - 5);
				}
				
				super.paintComponent(g);
			}
		};
		label.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				boolean isAtCorner = isAtCorner(e);
				if (isAtCorner)
				{					
					paintCorner(BUTTON_STYLE_SELECTED);
					
					if (cornerAction != null)
					{	
						if (cornerAction.getSource() == null)
						{
							cornerAction.setSource(JRibbon.this);
						}	
						cornerAction.actionPerformed(null);
					}
				}
			}
			
			public void mouseReleased(MouseEvent e)
			{
				boolean isAtCorner = isAtCorner(e);
				if (isAtCorner)
				{	
					paintCorner(BUTTON_STYLE_HOVER);
				}
			}
			
			public void mouseExited(MouseEvent e)
			{				
				paintCorner(BUTTON_STYLE_NORMAL);
			}
		}
		);
		label.addMouseMotionListener(new MouseAdapter()
		{
			public void mouseMoved(MouseEvent e)
			{
				boolean isAtCorner = isAtCorner(e);
				if (isAtCorner)
				{						
					paintCorner(BUTTON_STYLE_HOVER);
				}
				else
				{
					paintCorner(BUTTON_STYLE_NORMAL);
				}
			}
		}
		);
		label.setToolTipText(toolTipText);
		label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 23));
		
		setLayout(new BorderLayout());
		// setBorder(new RoundBorder(new Color(175, 195, 213), new Color(225, 234, 244)));
		setBackground(new Color(231, 239, 248));
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1), new LineBorder(RibbonManager.getStyle().getTabbedPaneBorderLineColor())));
		
		add(toolBar, BorderLayout.CENTER);
		add(label, BorderLayout.SOUTH);
		
		setCornerAction(new JAction()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		}
		);
	}
	
	/**
	 * Returns true if the mouse point is at the corner.
	 * @param e the instance of MouseEvent
	 * @return true if the mouse point is at the corner
	 */
	private boolean isAtCorner(MouseEvent e)
	{
		int width = label.getWidth();
		int height = label.getHeight();
		
		int x = e.getX();
		int y = e.getY();
		
		return x >= width - 16 && x <= width - 2 && y >= 1 && y <= height - 2;
	}
	
	/**
	 * Paints the corner.
	 * @param buttonStyle the button style value
	 */
	private void paintCorner(int buttonStyle)
	{
		if (cornerAction == null)
		{
			return;
		}
		
		cornerAction.putValue(BUTTON_STYLE, Integer.valueOf(buttonStyle));
		label.repaint();
	}
	
	/**
	 * Sets the corner action.
	 * @param cornerAction the instance of JAction
	 */
	public void setCornerAction(JAction cornerAction)
	{
		this.cornerAction = cornerAction;
	}
	
	/**
	 * Gets the corner action.
	 * @return the instance of JAction
	 */
	public JAction getCornerAction()
	{
		return cornerAction;
	}
	
	/**
	 * Gets the tool bar.
	 * @return the instance of JBasicToolBar
	 */
	public JBasicToolBar getToolBar()
	{
		return toolBar;
	}
	
	/**
	 * Gets the label.
	 * @return the instance of JLabel
	 */
	public JLabel getLabel()
	{
		return label;
	}
	
	/**
	 * Gets the title.
	 * @return the title string
	 */
	public String getTitle()
	{
		return label.getText();
	}
	
	/**
	 * Sets the title.
	 * @param title the title string
	 */
	public void setTitle(String title)
	{
		label.setText(title);
	}
	
	/**
	 * Gets the icon.
	 * @return the instance of Icon
	 */
	public Icon getIcon()
	{
		return label.getIcon();
	}
	
	/**
	 * Sets the icon.
	 * @param icon the instance of Icon
	 */
	public void setIcon(Icon icon)
	{
		label.setIcon(icon);
	}
	
	/**
	 * Gets the tooltip text.
	 * @return the tooltip text string
	 */
	public String getToolTipText()
	{
		return label.getToolTipText();
	}
	
	/**
	 * Sets the tooltip text.
	 * @param toolTipText the tooltip text string
	 */
	public void setToolTipText(String toolTipText)
	{
		label.setToolTipText(toolTipText);
	}
	
	/**
	 * Toggles the facade by a show type and show value.
	 * The show type values are "text" and "icon".
	 * The show value values are SHOW_SMALL, SHOW_LARGE and SHOW_NO. (See JAction definition).
	 * For example, if the showType is "icon" and the showValue is SHOW_LARGE, the component will display the icon as a large style.
	 * @param showType the show type
	 * @param showValue the show value
	 */
	public void toggleFacade(String showType, int showValue)
	{
		for (int i = 0; i < toolBar.getComponentCount(); i++)
		{
			Component ribbonComponent = toolBar.getComponent(i);
			if (ribbonComponent instanceof AbstractButton)
			{
				AbstractButton button = (AbstractButton) ribbonComponent;
				
				Action action = button.getAction();
				if (action instanceof JAction)
				{
					if (showType.equals(JAction.TEXT))
					{
						((JAction) action).showText(showValue);
					}
					else if (showType.equals(JAction.ICON))
					{
						((JAction) action).showIcon(showValue);
					}
				}
			}
		}
	}
}