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

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;

import com.nepxion.swing.dialog.JBasicDialog;

public class JFrameWorkDialog
	extends JBasicDialog implements JFrameWorkWindow
{
	/**
	 * The instance of JFrameWorkHierarchy.
	 */
	private JFrameWorkHierarchy frameWorkHierarchy;
	
	/**
	 * Constructs with the specified initial owner and title.
	 * @param owner the instance of Frame
	 * @param title the title string
	 */
	public JFrameWorkDialog(Frame owner, String title)
	{
		super(owner, title);
	}
	
	/**
	 * Constructs with the specified initial owner and title.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 */
	public JFrameWorkDialog(Dialog owner, String title)
	{
		super(owner, title);
	}	
	
	/**
	 * Constructs with the specified initial owner, title and dimension.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 */
	public JFrameWorkDialog(Frame owner, String title, Dimension dimension)
	{
		super(owner, title, dimension);
	}
	
	/**
	 * Constructs with the specified initial owner, title and dimension.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 */
	public JFrameWorkDialog(Dialog owner, String title, Dimension dimension)
	{
		super(owner, title, dimension);
	}
	
	/**
	 * Constructs with the specified initial owner, title and modal.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param modal the boolean value of modal
	 */
	public JFrameWorkDialog(Frame owner, String title, boolean modal)
	{
		super(owner, title, modal);
	}
	
	/**
	 * Constructs with the specified initial owner, title and modal.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param modal the boolean value of modal
	 */
	public JFrameWorkDialog(Dialog owner, String title, boolean modal)
	{
		super(owner, title, modal);
	}	
	
	/**
	 * Constructs with the specified initial owner, title, dimension and modal.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 * @param modal the boolean value of modal
	 */
	public JFrameWorkDialog(Frame owner, String title, Dimension dimension, boolean modal)
	{
		super(owner, title, dimension, modal);
	}
	
	/**
	 * Constructs with the specified initial owner, title, dimension and modal.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 * @param modal the boolean value of modal
	 */
	public JFrameWorkDialog(Dialog owner, String title, Dimension dimension, boolean modal)
	{
		super(owner, title, dimension, modal);
	}
	
	/**
	 * Constructs with the specified initial owner, title, modal and hint.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JFrameWorkDialog(Frame owner, String title, boolean modal, boolean hint)
	{
		super(owner, title, modal, hint);
	}
	
	/**
	 * Constructs with the specified initial owner, title, modal and hint.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JFrameWorkDialog(Dialog owner, String title, boolean modal, boolean hint)
	{
		super(owner, title, modal, hint);
	}	
	
	/**
	 * Constructs with the specified initial owner, title, dimension, modal and hint.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JFrameWorkDialog(Frame owner, String title, Dimension dimension, boolean modal, boolean hint)
	{
		super(owner, title, dimension, modal, hint);
	}
	
	/**
	 * Constructs with the specified initial owner, title, dimension, modal and hint.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JFrameWorkDialog(Dialog owner, String title, Dimension dimension, boolean modal, boolean hint)
	{
		super(owner, title, dimension, modal, hint);
	}
	
	/**
	 * Constructs with the specified initial owner, title, modal, hint and adaptable.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 * @param adaptable the boolean value of adaptable
	 */
	public JFrameWorkDialog(Frame owner, String title, boolean modal, boolean hint, boolean adaptable)
	{
		super(owner, title, modal, hint, adaptable);
	}
	
	/**
	 * Constructs with the specified initial owner, title, modal, hint and adaptable.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 * @param adaptable the boolean value of adaptable
	 */
	public JFrameWorkDialog(Dialog owner, String title, boolean modal, boolean hint, boolean adaptable)
	{
		super(owner, title, modal, hint, adaptable);
	}	
	
	/**
	 * Constructs with the specified initial owner, title, dimension, modal, hint and adaptable.
	 * The boolean value of hint means that it will be shown confirming hint or not when closing the dialog.
	 * The boolean value of adaptable means that the dialog size can't be out of minimum dimension and maximum dimension (if set).
	 * If the maximum dimension isn't set, the dialog can be resize to any large size.
	 * If the minimum dimension isn't set, the dialog will choose the dimension as the minimum dimension.
	 * If the dimension isn't set, the dialog will choose the preferred size as the dimension.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 * @param adaptable the boolean value of adaptable
	 */
	public JFrameWorkDialog(Frame owner, String title, Dimension dimension, boolean modal, boolean hint, boolean adaptable)
	{
		super(owner, title, dimension, modal, hint, adaptable);
	}
	
	/**
	 * Constructs with the specified initial owner, title, dimension, modal, hint and adaptable.
	 * The boolean value of hint means that it will be shown confirming hint or not when closing the dialog.
	 * The boolean value of adaptable means that the dialog size can't be out of minimum dimension and maximum dimension (if set).
	 * If the maximum dimension isn't set, the dialog can be resize to any large size.
	 * If the minimum dimension isn't set, the dialog will choose the dimension as the minimum dimension.
	 * If the dimension isn't set, the dialog will choose the preferred size as the dimension.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 * @param adaptable the boolean value of adaptable
	 */
	public JFrameWorkDialog(Dialog owner, String title, Dimension dimension, boolean modal, boolean hint, boolean adaptable)
	{
		super(owner, title, dimension, modal, hint, adaptable);
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