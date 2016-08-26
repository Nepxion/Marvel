package com.nepxion.swing.dialog;

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
import java.awt.event.HierarchyEvent;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;

import com.nepxion.swing.listener.DisplayAbilityListener;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.window.WindowManager;

public class JBasicDialog
	extends JDialog
{
	/**
	 * the boolean value of hint.
	 */
	private boolean hint = false;
	
	/**
	 * The boolean value of adaptable.
	 */
	private boolean adaptable = false;
	
	/**
	 * The dimension value.
	 */
	private Dimension dimension;
	
	/**
	 * The minimum dimension value.
	 */
	private Dimension minimumDimension;
	
	/**
	 * The maximum dimension value.
	 */
	private Dimension maximumDimension;
	
	/**
	 * The instance of DialogResizer.
	 */
	private DialogResizer resizer;
	
	/**
	 * Constructs with the specified initial owner and title.
	 * @param owner the instance of Frame
	 * @param title the title string
	 */
	public JBasicDialog(Frame owner, String title)
	{
		this(owner, title, null);
	}
	
	/**
	 * Constructs with the specified initial owner and title.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 */
	public JBasicDialog(Dialog owner, String title)
	{
		this(owner, title, null);
	}	
	
	/**
	 * Constructs with the specified initial owner, title and dimension.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 */
	public JBasicDialog(Frame owner, String title, Dimension dimension)
	{
		this(owner, title, dimension, true);
	}
	
	/**
	 * Constructs with the specified initial owner, title and dimension.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 */
	public JBasicDialog(Dialog owner, String title, Dimension dimension)
	{
		this(owner, title, dimension, true);
	}
	
	/**
	 * Constructs with the specified initial owner, title and modal.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param modal the boolean value of modal
	 */
	public JBasicDialog(Frame owner, String title, boolean modal)
	{
		this(owner, title, null, modal, false);
	}
	
	/**
	 * Constructs with the specified initial owner, title and modal.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param modal the boolean value of modal
	 */
	public JBasicDialog(Dialog owner, String title, boolean modal)
	{
		this(owner, title, null, modal, false);
	}	
	
	/**
	 * Constructs with the specified initial owner, title, dimension and modal.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 * @param modal the boolean value of modal
	 */
	public JBasicDialog(Frame owner, String title, Dimension dimension, boolean modal)
	{
		this(owner, title, dimension, modal, false);
	}
	
	/**
	 * Constructs with the specified initial owner, title, dimension and modal.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 * @param modal the boolean value of modal
	 */
	public JBasicDialog(Dialog owner, String title, Dimension dimension, boolean modal)
	{
		this(owner, title, dimension, modal, false);
	}
	
	/**
	 * Constructs with the specified initial owner, title, modal and hint.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JBasicDialog(Frame owner, String title, boolean modal, boolean hint)
	{
		this(owner, title, null, modal, hint, false);
	}
	
	/**
	 * Constructs with the specified initial owner, title, modal and hint.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JBasicDialog(Dialog owner, String title, boolean modal, boolean hint)
	{
		this(owner, title, null, modal, hint, false);
	}	
	
	/**
	 * Constructs with the specified initial owner, title, dimension, modal and hint.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JBasicDialog(Frame owner, String title, Dimension dimension, boolean modal, boolean hint)
	{
		this(owner, title, dimension, modal, hint, false);
	}
	
	/**
	 * Constructs with the specified initial owner, title, dimension, modal and hint.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JBasicDialog(Dialog owner, String title, Dimension dimension, boolean modal, boolean hint)
	{
		this(owner, title, dimension, modal, hint, false);
	}
	
	/**
	 * Constructs with the specified initial owner, title, modal, hint and adaptable.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 * @param adaptable the boolean value of adaptable
	 */
	public JBasicDialog(Frame owner, String title, boolean modal, boolean hint, boolean adaptable)
	{
		this(owner, title, null, modal, hint, adaptable);
	}
	
	/**
	 * Constructs with the specified initial owner, title, modal, hint and adaptable.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 * @param adaptable the boolean value of adaptable
	 */
	public JBasicDialog(Dialog owner, String title, boolean modal, boolean hint, boolean adaptable)
	{
		this(owner, title, null, modal, hint, adaptable);
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
	public JBasicDialog(Frame owner, String title, Dimension dimension, boolean modal, boolean hint, boolean adaptable)
	{
		super(owner, title, modal);
		
		this.dimension = dimension;
		this.hint = hint;
		this.adaptable = adaptable;
		
		initComponents();
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
	public JBasicDialog(Dialog owner, String title, Dimension dimension, boolean modal, boolean hint, boolean adaptable)
	{
		super(owner, title, modal);
		
		this.dimension = dimension;
		this.hint = hint;
		this.adaptable = adaptable;
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		resizer = new DialogResizer();		
		
		if (dimension != null)
		{	
			setDimension(dimension);
		}
		else
		{
			addHierarchyListener(new DisplayAbilityListener()
			{
				public void displayAbilityChanged(HierarchyEvent e)
				{
					setDimension(getContentPane().getPreferredSize());
					
					removeHierarchyListener(this);
				}
			}
			);
		}
		setAdaptable(adaptable);
		setResizable(true);
	}
	
	/**
	 * Returns true if hint.
	 * @return true if hint
	 */
	public boolean isHint()
	{
		return hint;
	}
	
	/**
	 * Sets the hint.
	 * @param hint the boolean value of hint.
	 */
	public void setHint(boolean hint)
	{
		this.hint = hint;
	}
	
	/**
	 * Returns true if adaptable.
	 * @return true if adaptable
	 */
	public boolean isAdaptable()
	{
		return adaptable;
	}
	
	/**
	 * Sets the adaptable.
	 * @param adaptable the boolean value of adaptable
	 */
	public void setAdaptable(boolean adaptable)
	{
		this.adaptable = adaptable;
		
		if (adaptable)
		{
			if (minimumDimension == null)
			{
				setMinimumDimension(dimension);
			}
			addComponentListener(resizer);
		}
		else
		{
			removeComponentListener(resizer);
		}
	}
	
	/**
	 * Gets the decorated margin.
	 * If decorated, it will return the margin value of 27, otherwise return the margin value of 0. 
	 * @return the decorated margin value
	 */
	public int getDecoratedMargin()
	{
		return JDialog.isDefaultLookAndFeelDecorated() ? 27 : 0;
	}
	
	/**
	 * Gets the dimension.
	 * @return the dimension value
	 */
	public Dimension getDimension()
	{
		return dimension;
	}
	
	/**
	 * Sets the dimension.
	 * @param dimension the dimension value
	 */
	public void setDimension(Dimension dimension)
	{
		this.dimension = dimension;
		
		WindowManager.setCenter(this, dimension);
		resizer.setDimension(dimension);
	}
	
	/**
	 * Gets the minimum dimension.
	 * @return the minimum dimension value
	 */
	public Dimension getMinimumDimension()
	{
		return minimumDimension;
	}
	
	/**
	 * Sets the minimum dimension.
	 * @param minimumDimension the minimum dimension value
	 */
	public void setMinimumDimension(Dimension minimumDimension)
	{
		this.minimumDimension = minimumDimension;
		
		resizer.setMinimumDimension(minimumDimension);
	}
	
	/**
	 * Gets the maximum dimension.
	 * @return the maximum dimension value
	 */
	public Dimension getMaximumDimension()
	{
		return maximumDimension;
	}
	
	/**
	 * Sets the maximum dimension.
	 * @param maximumDimension the maximum dimension value
	 */
	public void setMaximumDimension(Dimension maximumDimension)
	{
		this.maximumDimension = maximumDimension;
		
		resizer.setMaximumDimension(maximumDimension);
	}
	
	/**
	 * Invoked when a window event occurs.
	 * @param e the instance of WindowEvent
	 */
	protected void processWindowEvent(WindowEvent e)
	{
		if (hint)
		{
			if (e.getID() == WindowEvent.WINDOW_CLOSING)
			{
				int selectedValue = JBasicOptionPane.showConfirmDialog(getParent(), SwingLocale.getString("confirm_to_exit"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
				if (selectedValue != JBasicOptionPane.YES_OPTION)
				{
					return;
				}
			}
		}
		
		super.processWindowEvent(e);
	}
}