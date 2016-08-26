package com.nepxion.swing.button;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.HierarchyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import com.nepxion.swing.listener.DisplayAbilityListener;

public class JClassicMenuButton
	extends JClassicButton implements MouseListener, PopupMenuListener
{
	/**
	 * The button width inset value.
	 */
	protected int widthInset = ButtonConstants.DEFAULT_BUTTON_WIDTH_INSET;
	
	/**
	 * The button height inset value.
	 */
	protected int heightInset = ButtonConstants.DEFAULT_BUTTON_HEIGHT_INSET;
	
	/**
	 * The instance of JPopupMenu.
	 */
	protected JPopupMenu popupMenu;
	
	/**
	 * The boolean value of arrow shown
	 */
	protected boolean isShowArrow = true;
	
	/**
	 * The boolean value of arrow at right position.
	 */
	protected boolean isShowArrowRight = true;

	/**
	 * Constructs with the default.
	 */
	public JClassicMenuButton()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial action.
	 * @param action the instance of Action
	 */
	public JClassicMenuButton(Action action)
	{
		super(action);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text.
	 * @param text the text string
	 */
	public JClassicMenuButton(String text)
	{
		super(text);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial icon.
	 * @param icon the instance of Icon
	 */
	public JClassicMenuButton(Icon icon)
	{
		super(icon);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text and icon.
	 * @param text the text string 
	 * @param icon the icon of Icon
	 */
	public JClassicMenuButton(String text, Icon icon)
	{
		super(text, icon);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text and tooltip text.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 */
	public JClassicMenuButton(String text, String toolTipText)
	{
		super(text);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial icon and tooltip text.
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JClassicMenuButton(Icon icon, String toolTipText)
	{
		super(icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial text and icon.
	 * @param text the text string 
	 * @param icon the icon of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JClassicMenuButton(String text, Icon icon, String toolTipText)
	{
		super(text, icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{				
		addMouseListener(this);
		
		addHierarchyListener(new DisplayAbilityListener()
		{
			public void displayAbilityChanged(HierarchyEvent e)
			{
				adaptDimension();
				
				removeHierarchyListener(this);
			}
		}
		);
	}
	
	/**
	 * Adapts the dimension.
	 * If the boolean value of isShowArrow and isShowArrowRight are true, 
	 * it will be executed to set the button dimension by its preferred size and inset fitly. 
	 */
	private void adaptDimension()
	{
		if (!isShowArrow)
		{
			return;
		}	
		
		if (!isShowArrowRight)
		{
			return;
		}	
		
		Insets insets = getMargin();
		
		if (getParent() instanceof JToolBar)
		{	
			if (insets.right < widthInset + 5)
			{
				setMargin(new Insets(insets.top, insets.left, insets.bottom, widthInset + 5));
			}			
		}
		else
		{
			if (insets.right < widthInset)
			{
				setMargin(new Insets(insets.top, insets.left, insets.bottom, widthInset));
			}
		}
	}
	
	/**
	 * Gets the popup menu.
	 * @return the instance of JPopupMenu
	 */
	public JPopupMenu getPopupMenu()
	{
		return popupMenu;
	}
	
	/**
	 * Sets the popup menu.
	 * @param popupMenu the instance of JPopupMenu 
	 */
	public void setPopupMenu(JPopupMenu popupMenu)
	{
		this.popupMenu = popupMenu;
		this.popupMenu.addPopupMenuListener(this);
	}
	
	/**
	 * Returns true if the arrow is shown on the button.
	 * @return true if the arrow is shown on the button
	 */
	public boolean isShowArrow()
	{
		return isShowArrow;
	}

	/**
	 * Sets the arrow shown.
	 * @param isShowArrow the boolean value of arrow shown
	 */
	public void setShowArrow(boolean isShowArrow)
	{
		this.isShowArrow = isShowArrow;
	}
	
	/**
	 * Return true if the arrow is shown at right position on the button.
	 * @return true if the arrow is shown at right position on the button
	 */
	public boolean isShowArrowRight()
	{
		return isShowArrowRight;
	}

	/**
	 * Sets the arrow shown at right position on the button.
	 * @param isShowArrow the boolean value of arrow shown at right position on the button
	 */
	public void setShowArrowRight(boolean isShowArrowRight)
	{
		this.isShowArrowRight = isShowArrowRight;
	}
	
	/**
	 * Invoked when the mouse button has been clicked (pressed and released) on a component.
	 * @param e the instance of MouseEvent
	 */
	public void mouseClicked(MouseEvent e)
	{
	}
	
	/**
	 * Invoked when the mouse button has been pressed on a component.
	 * @param e the instance of MouseEvent
	 */
	public void mousePressed(MouseEvent e)
	{
		ButtonModel buttonModel = getModel();
		if (!buttonModel.isEnabled())
		{
			return;
		}
		
		if (SwingUtilities.isLeftMouseButton(e))
		{
			if (popupMenu != null)
			{
				popupMenu.show(this, 2, getSize().height - 2);
			}
		}
	}
	
	/**
	 * Invoked when the mouse button has been released on a component.
	 * @param e the instance of MouseEvent
	 */
	public void mouseReleased(MouseEvent e)
	{
	}
	
	/**
	 * Invoked when the mouse enters a component.
	 * @param e the instance of MouseEvent
	 */
	public void mouseEntered(MouseEvent e)
	{
	}
	
	/**
	 * Invoked when the mouse exits a component.
	 * @param e the instance of MouseEvent
	 */
	public void mouseExited(MouseEvent e)
	{
	}
	
	/**
	 * Invoked before the popup menu becomes visible.
	 * @param e the instance of PopupMenuEvent
	 */
	public void popupMenuWillBecomeVisible(PopupMenuEvent e)
	{
	}
	
	/**
	 * Invoked before the popup menu becomes invisible.
	 * @param e the instance of PopupMenuEvent
	 */
	public void popupMenuWillBecomeInvisible(PopupMenuEvent e)
	{
	}
	
	/**
	 * Invoked when the popup menu is canceled.
	 * @param e the instance of PopupMenuEvent
	 */
	public void popupMenuCanceled(PopupMenuEvent e)
	{
	}
	
	/**
	 * Paints the graphics.
	 * @param g the instance of Graphics
	 */
	public void paint(Graphics g)
	{
		super.paint(g);
		
		if (isShowArrow)
		{
			ButtonModel buttonModel = getModel();
			if (!buttonModel.isEnabled())
			{
				g.setColor(UIManager.getColor("controlShadow"));
			}
			
			if (isShowArrowRight)
			{	
				g.drawLine(getWidth() - 6 - 5, getHeight() / 2 - 1, getWidth() - 6 - 1, getHeight() / 2 - 1);
				g.drawLine(getWidth() - 6 - 4, getHeight() / 2, getWidth() - 6 - 2, getHeight() / 2);
				g.drawLine(getWidth() - 6 - 3, getHeight() / 2 + 1, getWidth() - 6 - 3, getHeight() / 2 + 1);
			}
			else
			{
				g.drawLine(getWidth() / 2 - 1, getHeight() - 6 - 3, getWidth() / 2 + 3, getHeight() - 6 - 3);
				g.drawLine(getWidth() / 2, getHeight() - 6 - 2, getWidth() / 2 + 2, getHeight() - 6 - 2);
				g.drawLine(getWidth() / 2 + 1, getHeight() - 6 - 1, getWidth() / 2 + 1, getHeight() - 6 - 1);
			}
		}
	}
}