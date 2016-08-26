package com.nepxion.swing.optionpane;

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
import java.awt.Container;
import java.awt.HeadlessException;
import java.util.Locale;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.nepxion.swing.button.ButtonFocusListener;
import com.nepxion.swing.dialog.DialogResizer;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.validation.IValidation;

public class JBasicOptionPane
	extends JOptionPane
{
	/**
	 * Constructs with the default.
	 */
	public JBasicOptionPane()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial message.
	 * @param message the message object
	 */
	public JBasicOptionPane(Object message)
	{
		super(message);
	}
	
	/**
	 * Constructs with the specified initial message and message type.
	 * @param message the message object
	 * @param messageType the message type
	 */
	public JBasicOptionPane(Object message, int messageType)
	{
		super(message, messageType);
	}
	
	/**
	 * Constructs with the specified initial message, message type and option type.
	 * @param message the message object
	 * @param messageType the message type
	 * @param optionType the option type
	 */
	public JBasicOptionPane(Object message, int messageType, int optionType)
	{
		super(message, messageType, optionType);
	}
	
	/**
	 * Constructs with the specified initial message, message type, option type and icon.
	 * @param message the message object
	 * @param messageType the message type
	 * @param optionType the option type
	 * @param icon the instance of Icon
	 */
	public JBasicOptionPane(Object message, int messageType, int optionType, Icon icon)
	{
		super(message, messageType, optionType, icon);
	}
	
	/**
	 * Constructs with the specified initial message, message type, option type, icon and option array.
	 * @param message the message object
	 * @param messageType the message type
	 * @param optionType the option type
	 * @param icon the instance of Icon
	 * @param options the option array
	 */
	public JBasicOptionPane(Object message, int messageType, int optionType, Icon icon, Object[] options)
	{
		super(message, messageType, optionType, icon, options);
	}
	
	/**
	 * Constructs with the specified initial message, message type, option type, icon, option array and initial value.
	 * @param message the message object
	 * @param messageType the message type
	 * @param optionType the option type
	 * @param icon the instance of Icon
	 * @param options the option array
	 * @param initialValue the initial value
	 */
	public JBasicOptionPane(Object message, int messageType, int optionType, Icon icon, Object[] options, Object initialValue)
	{
		super(message, messageType, optionType, icon, options, initialValue);
	}
	
	/**
	 * Shows the dialog by a parent component, message and title.
	 * @param parentComponent the instance of Component
	 * @param message the message object
	 * @param title the title string
	 * @return the selected value
	 */
	public static int showDialog(Component parentComponent, Object message, String title)
	{
		return showDialog(parentComponent, message, title, null);
	}
	
	/**
	 * Shows the dialog by a parent component, message, title and icon.
	 * @param parentComponent the instance of Component
	 * @param message the message object
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @@return the selected value
	 */
	public static int showDialog(Component parentComponent, Object message, String title, Icon icon)
	{
		return showDialog(parentComponent, message, title, icon, false);
	}
	
	/**
	 * Shows the dialog by a parent component, message, title and resizable.
	 * @param parentComponent the instance of Component
	 * @param message the message object
	 * @param title the title string
	 * @param resizable the boolean value of resizable
	 * @return the selected value
	 */
	public static int showDialog(Component parentComponent, Object message, String title, boolean resizable)
	{
		return showDialog(parentComponent, message, title, null, resizable);
	}
	
	/**
	 * Shows the dialog by a parent component, message, title, icon and resizable.
	 * @param parentComponent the instance of Component
	 * @param message the message object
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param resizable the boolean value of resizable
	 * @return the selected value
	 */
	public static int showDialog(Component parentComponent, Object message, String title, Icon icon, boolean resizable)
	{
		return showDialog(parentComponent, message, title, icon, new Object[] {SwingLocale.getString("yes"), SwingLocale.getString("no")}, resizable);
	}
	
	/**
	 * Shows the dialog by a parent component, message, title, icon and option array.
	 * @param parentComponent the instance of Component
	 * @param message the message object
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param options the option array
	 * @return the selected value
	 */
	public static int showDialog(Component parentComponent, Object message, String title, Icon icon, Object[] options)
	{
		return showDialog(parentComponent, message, title, icon, options, false);
	}
	
	/**
	 * Shows the dialog by a parent component, message, title, icon, option array and resizable.
	 * @param parentComponent the instance of Component
	 * @param message the message object
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param options the option array
	 * @param resizable the boolean value of resizable
	 * @return the selected value
	 */
	public static int showDialog(Component parentComponent, Object message, String title, Icon icon, Object[] options, boolean resizable)
	{
		return showDialog(parentComponent, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, null, resizable);
	}
	
	/**
	 * Shows the dialog by a parent component, message, title, option type, message type, icon, option array, initial value and resizable.
	 * @param parentComponent the instance of Component
	 * @param message the message object
	 * @param title the title string
	 * @param optionType the option type value
	 * @param messageType the message type value
	 * @param icon the instance of Icon
	 * @param options the option array
	 * @param initialValue the initial value
	 * @param resizable the boolean value of resizable
	 * @return the selected value
	 */
	public static int showDialog(Component parentComponent, Object message, String title, int optionType, int messageType, Icon icon, Object[] options, Object initialValue, boolean resizable)
	{
		int selectedValue = showOptionDialog(parentComponent, message, title, optionType, messageType, icon, options, initialValue, resizable);
		
		return showDialog(selectedValue, parentComponent, message, title, optionType, messageType, icon, options, initialValue, resizable);
	}
	
	/**
	 * Shows the dialog by a selected value, parent component, message, title, option type, message type, icon, option array, initial value and resizable.
	 * @param selectedValue the selected value
	 * @param parentComponent the instance of Component
	 * @param message the message object
	 * @param title the title string
	 * @param optionType the option type value
	 * @param messageType the message type value
	 * @param icon the instance of Icon
	 * @param options the option array
	 * @param initialValue the initial value
	 * @param resizable the boolean value of resizable
	 * @return the selected value
	 */
	private static int showDialog(int selectedValue, Component parentComponent, Object message, String title, int optionType, int messageType, Icon icon, Object[] options, Object initialValue, boolean resizable)
	{
		if (selectedValue != JOptionPane.YES_OPTION)
		{
			return selectedValue;
		}
		
		if (message instanceof IValidation)
		{
			IValidation validation = (IValidation) message;
			if (!validation.verify())
			{
				selectedValue = showOptionDialog(parentComponent, message, title, optionType, messageType, icon, options, initialValue, resizable);
				
				return showDialog(selectedValue, parentComponent, message, title, optionType, messageType, icon, options, initialValue, resizable);
			}
		}
		
		return selectedValue;
	}
	
	/**
	 * Shows the option dialog by a parent component, message, title, option type, message type, icon, option array, initial value and resizable.
	 * @param parentComponent the instance of Component
	 * @param message the message object
	 * @param title the title string
	 * @param optionType the option type value
	 * @param messageType the message type value
	 * @param icon the instance of Icon
	 * @param options the option array
	 * @param initialValue the initial value
	 * @param resizable the boolean value of resizable
	 * @return the selected value
	 * @throws HeadlessException
	 */
	public static int showOptionDialog(Component parentComponent, Object message, String title, int optionType, int messageType, Icon icon, Object[] options, Object initialValue, boolean resizable)
		throws HeadlessException
	{
		JBasicOptionPane pane = new JBasicOptionPane(message, messageType, optionType, icon, options, initialValue);
		
		pane.setInitialValue(initialValue);
		pane.setComponentOrientation(((parentComponent == null) ? getRootFrame() : parentComponent).getComponentOrientation());
		
		JDialog dialog = pane.createDialog(parentComponent, title, resizable);
		
		pane.selectInitialValue();
		dialog.show();
		dialog.dispose();
		
		Object selectedValue = pane.getValue();
		
		if (selectedValue == null)
		{
			return CLOSED_OPTION;
		}
		
		if (options == null)
		{
			if (selectedValue instanceof Integer)
			{
				return ((Integer) selectedValue).intValue();
			}
			
			return CLOSED_OPTION;
		}
		
		for (int counter = 0, maxCounter = options.length; counter < maxCounter; counter++)
		{
			if (options[counter].equals(selectedValue))
			{
				return counter;
			}
		}
		
		return CLOSED_OPTION;
	}
	
	/**
	 * Shows the input dialog by a message.
	 * @param message the message object
	 * @return the input string
	 * @throws HeadlessException
	 */
	public static String showInputDialog(Object message)
		throws HeadlessException
	{
		return showInputDialog(null, message);
	}
	
	/**
	 * Shows the input dialog by a message and initial selection value.
	 * @param message the message object
	 * @param initialSelectionValue the initial selection value
	 * @return the input string
	 */
	public static String showInputDialog(Object message, Object initialSelectionValue)
	{
		return showInputDialog(null, message, initialSelectionValue);
	}
	
	/**
	 * Shows the input dialog by a parent component and message.
	 * @param parentComponent the instance of Component
	 * @param message the message object
	 * @return the input string
	 * @throws HeadlessException
	 */
	public static String showInputDialog(Component parentComponent, Object message)
		throws HeadlessException
	{
		return showInputDialog(parentComponent, message, getString("OptionPane.inputDialogTitle", parentComponent), QUESTION_MESSAGE);
	}
	
	/**
	 * Shows the input dialog by a parent component, message, title and initial selection value.
	 * @param parentComponent the instance of Component
	 * @param message the message object
	 * @param initialSelectionValue the initial selection value
	 * @return the input string
	 */
	public static String showInputDialog(Component parentComponent, Object message, Object initialSelectionValue)
	{
		return (String) showInputDialog(parentComponent, message, getString("OptionPane.inputDialogTitle", parentComponent), QUESTION_MESSAGE, null, null, initialSelectionValue);
	}
	
	/**
	 * Shows the input dialog by a parent component, message, title and message type.
	 * @param parentComponent the instance of Component
	 * @param message the message object
	 * @param title the title string
	 * @param messageType the message type value
	 * @return the input string
	 * @throws HeadlessException
	 */
	public static String showInputDialog(Component parentComponent, Object message, String title, int messageType)
		throws HeadlessException
	{
		return (String) showInputDialog(parentComponent, message, title, messageType, null, null, null);
	}
	
	/**
	 * Shows the input dialog by a parent component, message, title, message type, icon, selection value array and initial selection value.
	 * @param parentComponent the instance of Component
	 * @param message the message object
	 * @param title the title string
	 * @param messageType the message type value
	 * @param icon the instance of Icon
	 * @param selectionValues the selection value array
	 * @param initialSelectionValue the initial selection value
	 * @return the input string
	 * @throws HeadlessException
	 */
	public static Object showInputDialog(Component parentComponent, Object message, String title, int messageType, Icon icon, Object[] selectionValues, Object initialSelectionValue)
		throws HeadlessException
	{
		return (String) showInputDialog(parentComponent, message, title, messageType, icon, selectionValues, initialSelectionValue, false);
	}
	
	/**
	 * Shows the input dialog by a parent component, message, title, message type, icon, selection value array, initial selection value and resizable.
	 * @param parentComponent the instance of Component
	 * @param message the message object
	 * @param title the title string
	 * @param messageType the message type value
	 * @param icon the instance of Icon
	 * @param selectionValues the selection value array
	 * @param initialSelectionValue the initial selection value
	 * @param resizable the boolean value of resizable
	 * @return the input string
	 * @throws HeadlessException
	 */
	public static Object showInputDialog(Component parentComponent, Object message, String title, int messageType, Icon icon, Object[] selectionValues, Object initialSelectionValue, boolean resizable)
		throws HeadlessException
	{
		JBasicOptionPane pane = new JBasicOptionPane(message, messageType, OK_CANCEL_OPTION, icon, null, null);
		
		pane.setWantsInput(true);
		pane.setSelectionValues(selectionValues);
		pane.setInitialSelectionValue(initialSelectionValue);
		pane.setComponentOrientation(((parentComponent == null) ? getRootFrame() : parentComponent).getComponentOrientation());
		
		JDialog dialog = pane.createDialog(parentComponent, title, resizable);
		
		pane.selectInitialValue();
		dialog.show();
		dialog.dispose();
		
		Object value = pane.getInputValue();
		
		if (value == UNINITIALIZED_VALUE)
		{
			return null;
		}
		
		return value;
	}
	
	/**
	 * Shows the message dialog by a parent component and message.
	 * @param parentComponent the instance of Component
	 * @param message the message object
	 * @throws HeadlessException
	 */
	public static void showMessageDialog(Component parentComponent, Object message)
		throws HeadlessException
	{
		showMessageDialog(parentComponent, message, getString("OptionPane.messageDialogTitle", parentComponent), INFORMATION_MESSAGE);
	}
	
	/**
	 * Shows the message dialog by a parent component, message, title and message type.
	 * @param parentComponent the instance of Component
	 * @param message the message object
	 * @param title the title string
	 * @param messageType the message type value
	 * @throws HeadlessException
	 */
	public static void showMessageDialog(Component parentComponent, Object message, String title, int messageType)
		throws HeadlessException
	{
		showMessageDialog(parentComponent, message, title, messageType, null);
	}
	
	/**
	 * Shows the message dialog by a parent component, message, title and message type.
	 * @param parentComponent the instance of Component
	 * @param message the message object
	 * @param title the title string 
	 * @param messageType the message type value
	 * @param icon the instance of Icon
	 * @throws HeadlessException
	 */
	public static void showMessageDialog(Component parentComponent, Object message, String title, int messageType, Icon icon)
		throws HeadlessException
	{
		showOptionDialog(parentComponent, message, title, DEFAULT_OPTION, messageType, icon, null, null, false);
	}
	
	/**
	 * Shows the confirm dialog by a parent component and message.
	 * @param parentComponent the instance of Component
	 * @param message the message object
	 * @return the selected value
	 * @throws HeadlessException
	 */
	public static int showConfirmDialog(Component parentComponent, Object message)
		throws HeadlessException
	{
		return showConfirmDialog(parentComponent, message, UIManager.getString("OptionPane.titleText"), YES_NO_CANCEL_OPTION);
	}
	
	/**
	 * Shows the confirm dialog by a parent component, message, title and option type.
	 * @param parentComponent the instance of Component
	 * @param message the message object
	 * @param title the title string
	 * @param optionType the option type value
	 * @return the selected value
	 * @throws HeadlessException
	 */
	public static int showConfirmDialog(Component parentComponent, Object message, String title, int optionType)
		throws HeadlessException
	{
		return showConfirmDialog(parentComponent, message, title, optionType, QUESTION_MESSAGE);
	}
	
	/**
	 * Shows the confirm dialog by a parent component, message, title, option type and message type.
	 * @param parentComponent the instance of Component
	 * @param message the message object
	 * @param title the title string
	 * @param optionType the option type value
	 * @param messageType the message type value
	 * @return the selected value
	 * @throws HeadlessException
	 */
	public static int showConfirmDialog(Component parentComponent, Object message, String title, int optionType, int messageType)
		throws HeadlessException
	{
		return showConfirmDialog(parentComponent, message, title, optionType, messageType, null);
	}
	
	/**
	 * Shows the confirm dialog by a parent component, message, title, option type, message type and icon.
	 * @param parentComponent the instance of Component
	 * @param message the message object
	 * @param title the title string
	 * @param optionType the option type value
	 * @param messageType the message type value
	 * @param icon the instance of Icon
	 * @return the selected value
	 * @throws HeadlessException
	 */
	public static int showConfirmDialog(Component parentComponent, Object message, String title, int optionType, int messageType, Icon icon)
		throws HeadlessException
	{
		return showOptionDialog(parentComponent, message, title, optionType, messageType, icon, null, null, false);
	}
	
	/**
	 * Creates the dialog by a parent component, title and resizable
	 * @param parentComponent the instance of Component
	 * @param title the title string
	 * @param resizable the boolean value of resizable
	 * @return the instance of JDialog
	 * @throws HeadlessException
	 */
	public JDialog createDialog(Component parentComponent, String title, boolean resizable)
		throws HeadlessException
	{
		JDialog dialog = createDialog(parentComponent, title);
		/*dialog.setResizable(true);
		if (resizable)
		{
			dialog.addComponentListener(new ComponentSizeAdapter(dialog.getSize(), dialog.getSize(), null));
		}
		else
		{
			dialog.addComponentListener(new ComponentSizeAdapter(dialog.getSize()));
		}*/
		
		if (resizable)
		{
			dialog.setResizable(true);
			dialog.addComponentListener(new DialogResizer(dialog.getSize(), dialog.getSize(), null));
		}
		
		Container container = (Container) getComponent(getComponentCount() - 1);
		for (int i = 0; i < container.getComponentCount(); i++)
		{
			Component component = container.getComponent(i);
			if (component instanceof JButton)
			{
				JButton button = (JButton) component;
				button.addFocusListener(new ButtonFocusListener(this));
			}
		}
		
		return dialog;
	}
	
	/**
	 * Gets the string.
	 * @param key the key object
	 * @param c the instance of Component
	 * @return the string
	 */
	public static String getString(Object key, Component c)
	{
		Locale l = (c == null) ? Locale.getDefault() : c.getLocale();
		
		return UIManager.getString(key, l);
	}
}