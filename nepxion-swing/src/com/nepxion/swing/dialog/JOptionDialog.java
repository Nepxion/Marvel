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

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.Icon;

import com.nepxion.swing.panel.option.JOptionButtonPanel;
import com.nepxion.swing.panel.option.JOptionPanel;
import com.nepxion.swing.panel.option.OptionConstants;

public class JOptionDialog
	extends JBasicDialog implements OptionConstants
{
	/**
	 * The instance of JOptionPanel.
	 */
	private JOptionPanel optionPanel;
	
	/**
	 * The instance of JOptionButtonPanel.
	 */
	private JOptionButtonPanel optionButtonPanel;
	
	/**
	 * Constructs with the specified initial owner and title.
	 * @param owner the instance of Frame
	 * @param title the title string
	 */
	public JOptionDialog(Frame owner, String title)
	{
		super(owner, title);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial owner and title.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 */
	public JOptionDialog(Dialog owner, String title)
	{
		super(owner, title);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial owner, title and dimension.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 */
	public JOptionDialog(Frame owner, String title, Dimension dimension)
	{
		super(owner, title, dimension);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial owner, title and dimension.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 */
	public JOptionDialog(Dialog owner, String title, Dimension dimension)
	{
		super(owner, title, dimension);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial owner, title and modal.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param modal the boolean value of modal
	 */
	public JOptionDialog(Frame owner, String title, boolean modal)
	{
		super(owner, title, modal);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial owner, title and modal.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param modal the boolean value of modal
	 */
	public JOptionDialog(Dialog owner, String title, boolean modal)
	{
		super(owner, title, modal);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial owner, title, dimension and modal.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 * @param modal the boolean value of modal
	 */
	public JOptionDialog(Frame owner, String title, Dimension dimension, boolean modal)
	{
		super(owner, title, dimension, modal);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial owner, title, dimension and modal.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 * @param modal the boolean value of modal
	 */
	public JOptionDialog(Dialog owner, String title, Dimension dimension, boolean modal)
	{
		super(owner, title, dimension, modal);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial owner, title, modal and hint.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JOptionDialog(Frame owner, String title, boolean modal, boolean hint)
	{
		super(owner, title, modal, hint);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial owner, title, modal and hint.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JOptionDialog(Dialog owner, String title, boolean modal, boolean hint)
	{
		super(owner, title, modal, hint);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial owner, title, dimension, modal and hint.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JOptionDialog(Frame owner, String title, Dimension dimension, boolean modal, boolean hint)
	{
		super(owner, title, dimension, modal, hint);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial owner, title, dimension, modal and hint.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JOptionDialog(Dialog owner, String title, Dimension dimension, boolean modal, boolean hint)
	{
		super(owner, title, dimension, modal, hint);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial owner, title, modal, hint and adaptable.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 * @param adaptable the boolean value of adaptable
	 */
	public JOptionDialog(Frame owner, String title, boolean modal, boolean hint, boolean adaptable)
	{
		super(owner, title, modal, hint, adaptable);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial owner, title, modal, hint and adaptable.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 * @param adaptable the boolean value of adaptable
	 */
	public JOptionDialog(Dialog owner, String title, boolean modal, boolean hint, boolean adaptable)
	{
		super(owner, title, modal, hint, adaptable);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial owner, title, dimension, modal, hint and adaptable.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 * @param adaptable the boolean value of adaptable
	 */
	public JOptionDialog(Frame owner, String title, Dimension dimension, boolean modal, boolean hint, boolean adaptable)
	{
		super(owner, title, dimension, modal, hint, adaptable);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial owner, title, dimension, modal, hint and adaptable.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param dimension the instance of Dimension
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 * @param adaptable the boolean value of adaptable
	 */
	public JOptionDialog(Dialog owner, String title, Dimension dimension, boolean modal, boolean hint, boolean adaptable)
	{
		super(owner, title, dimension, modal, hint, adaptable);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */	
	private void initComponents()
	{
		optionPanel = new JOptionPanel();
		optionButtonPanel = new JOptionButtonPanel()
		{
			public boolean confirm()
			{
				return JOptionDialog.this.confirm();
			}
			
			public boolean cancel()
			{
				return JOptionDialog.this.cancel();
			}
			
			public boolean apply()
			{
				return JOptionDialog.this.apply();
			}
			
			public boolean close()
			{
				return JOptionDialog.this.close();
			}
		};
		optionButtonPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(optionPanel, BorderLayout.CENTER);
		contentPane.add(optionButtonPanel, BorderLayout.SOUTH);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				int option = optionButtonPanel.getOption();
				if (option == YES_NO_APPLY_OPTION || option == YES_NO_OPTION)
				{
					JOptionDialog.this.cancel();
				}
				else if (option == CLOSE_OPTION)
				{
					JOptionDialog.this.close();
				}
			}			
		}
		);
	}
	
	/**
	 * Gets the option panel.
	 * @return the instance of JOptionPanel
	 */
	public JOptionPanel getOptionPanel()
	{
		return optionPanel;
	}
	
	/**
	 * Gets the option button panel.
	 * @return the instance of JOptionButtonPanel
	 */
	public JOptionButtonPanel getOptionButtonPanel()
	{
		return optionButtonPanel;
	}
	
	/**
	 * Sets the option.
	 * @param option the option value
	 */
	public void setOption(int option)
	{
		optionButtonPanel.setOption(option);
	}
	
	/**
	 * Sets the icon.
	 * @param icon the instance of icon
	 */
	public void setIcon(Icon icon)
	{
		optionPanel.setIcon(icon);
	}
	
	/**
	 * Gets the content.
	 * @return the instance of Component
	 */
	public Component getContent()
	{
		return optionPanel.getContent();
	}
	
	/**
	 * Sets the content.
	 * @param component the instance of Component
	 */
	public void setContent(Component component)
	{
		optionPanel.setContent(component);
	}
	
	/**
	 * Gets the value.
	 * @return the value
	 */
	public String getValue()
	{
		return optionButtonPanel.getValue();
	}
	
	/**
	 * Returns true if confirmed.
	 * @return true if confirmed. 
	 */
	public boolean confirm()
	{
		return true;
	}
	
	/**
	 * Returns true if cancelled.
	 * @return true if cancelled. 
	 */
	public boolean cancel()
	{
		return true;
	}
	
	/**
	 * Returns true if applied.
	 * @return true if applied. 
	 */
	public boolean apply()
	{
		return true;
	}
	
	/**
	 * Returns true if closed.
	 * @return true if closed. 
	 */
	public boolean close()
	{
		return true;
	}
	
	/**
	 * Returns true if confirmed.
	 * @return true if confirmed. 
	 */
	public boolean isConfirmed()
	{
		String value = getValue();
		if (value != null && value.equals(COMFIRM))
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * Returns true if cancelled.
	 * @return true if cancelled. 
	 */
	public boolean isCancelled()
	{
		String value = getValue();
		if (value != null && value.equals(CANCEL))
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * Returns true if applied.
	 * @return true if applied. 
	 */
	public boolean isApplied()
	{
		String value = getValue();
		if (value != null && value.equals(APPLY))
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * Returns true if closed.
	 * @return true if closed. 
	 */
	public boolean isClosed()
	{
		String value = getValue();
		if (value != null && value.equals(CLOSE))
		{
			return true;
		}
		
		return false;
	}
}