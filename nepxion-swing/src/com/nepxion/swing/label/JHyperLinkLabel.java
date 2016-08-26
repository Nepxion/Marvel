package com.nepxion.swing.label;

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
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;

public class JHyperLinkLabel
	extends JStyledLabel implements MouseListener
{
	/**
	 * The hyperLink style range.
	 */
	private JStyleRange hyperLinkStyleRange;
	
	/**
	 * Constructs with the default.
	 */
	public JHyperLinkLabel()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text.
	 * @param text the text string
	 */
	public JHyperLinkLabel(String text)
	{
		super(text);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text and toolTipText.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 */
	public JHyperLinkLabel(String text, String toolTipText)
	{
		super(text, toolTipText);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text and horizontal alignment.
	 * @param text the text string
	 * @param horizontalAlignment the horizontal alignment value
	 */
	public JHyperLinkLabel(String text, int horizontalAlignment)
	{
		super(text, horizontalAlignment);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text, tooltip text and horizontal alignment.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 * @param horizontalAlignment the horizontal alignment value
	 */
	public JHyperLinkLabel(String text, String toolTipText, int horizontalAlignment)
	{
		super(text, toolTipText, horizontalAlignment);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text and horizontal alignment.
	 * @param icon the instance of Icon
	 */
	public JHyperLinkLabel(Icon icon)
	{
		super(icon);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial icon and tooltip text.
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JHyperLinkLabel(Icon icon, String toolTipText)
	{
		super(icon, toolTipText);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial icon and horizontal alignment.
	 * @param icon the instance of Icon
	 * @param horizontalAlignment the horizontal alignment value
	 */
	public JHyperLinkLabel(Icon icon, int horizontalAlignment)
	{
		super(icon, horizontalAlignment);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text, tooltip text and horizontal alignment.
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param horizontalAlignment the horizontal alignment value
	 */
	public JHyperLinkLabel(Icon icon, String toolTipText, int horizontalAlignment)
	{
		super(icon, toolTipText, horizontalAlignment);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text, icon and horizontal alignment.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param horizontalAlignment the horizontal alignment value
	 */
	public JHyperLinkLabel(String text, Icon icon, int horizontalAlignment)
	{
		super(text, icon, horizontalAlignment);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text, icon and horizontal alignment.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JHyperLinkLabel(String text, Icon icon, String toolTipText)
	{
		super(text, icon, toolTipText);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text, icon, tooltip text and horizontal alignment.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text
	 * @param horizontalAlignment the horizontal alignment value
	 */
	public JHyperLinkLabel(String text, Icon icon, String toolTipText, int horizontalAlignment)
	{
		super(text, icon, toolTipText, horizontalAlignment);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		hyperLinkStyleRange = new JStyleRange(Font.PLAIN, Color.red, JStyleRange.STYLE_UNDERLINED, Color.black);
		
		addMouseListener(this);
	}
	
	/**
	 * Gets the hyperLink style range.
	 * @return the instance of JStyleRange
	 */
	public JStyleRange getHyperLinkStyleRange()
	{
		return hyperLinkStyleRange;
	}

	/**
	 * Sets the hyperLink style range.
	 * @param hyperLinkStyleRange the instance of JStyleRange
	 */
	public void setHyperLinkStyleRange(JStyleRange hyperLinkStyleRange)
	{
		this.hyperLinkStyleRange = hyperLinkStyleRange;
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
		addStyleRange(hyperLinkStyleRange);
		
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	/**
	 * Invoked when the mouse exits a component.
	 * @param e the instance of MouseEvent
	 */
	public void mouseExited(MouseEvent e)
	{
		clearStyleRanges();
		
		setCursor(Cursor.getDefaultCursor());
	}
}