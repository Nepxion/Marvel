package com.nepxion.swing.keystroke;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.nepxion.swing.button.ButtonAncestorListener;

public class KeyStrokeManager
{
	/**
	 * Registers the key stroke for the component by an action listener and key code.
	 * @param component the instance of JComponent
	 * @param actionListener the instance of ActionListener
	 * @param keyCode the key code value
	 */
	public static void registerComponent(JComponent component, ActionListener actionListener, int keyCode)
	{
		registerComponent(component, actionListener, keyCode, 0);
	}
	
	/**
	 * Registers the key stroke for the component by an action listener, key code and modifiers.
	 * @param component the instance of JComponent
	 * @param actionListener the instance of ActionListener
	 * @param keyCode the key code value
	 * @param modifiers the modifiers value
	 */
	public static void registerComponent(JComponent component, ActionListener actionListener, int keyCode, int modifiers)
	{
		KeyStroke keyStroke = KeyStroke.getKeyStroke(keyCode, modifiers);
		registerComponent(component, actionListener, keyStroke);
	}
	
	/**
	 * Registers the key stroke for the component by an action listener.
	 * @param component the instance of JComponent
	 * @param actionListener the instance of ActionListener
	 * @param keyStroke the instance of KeyStroke
	 */
	public static void registerComponent(JComponent component, ActionListener actionListener, KeyStroke keyStroke)
	{
		component.registerKeyboardAction(actionListener, keyStroke, JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
	}
	
	/**
	 * Registers the key stroke of "Enter" for the component by an action listener.
	 * @param component the instance of JComponent
	 * @param actionListener the instance of ActionListener
	 */
	public static void registerComponentToEnterKey(JComponent component, ActionListener actionListener)
	{
		registerComponent(component, actionListener, KeyEvent.VK_ENTER, 0);
	}
	
	/**
	 * Registers the key stroke of "Escape" for the component by an action listener.
	 * @param component the instance of JComponent
	 * @param actionListener the instance of ActionListener
	 */
	public static void registerComponentToEscapeKey(JComponent component, ActionListener actionListener)
	{
		registerComponent(component, actionListener, KeyEvent.VK_ESCAPE, 0);
	}	
	
	/**
	 * Registers the key stroke for the button by the default action listener and key code.
	 * @param button the instance of AbstractButton
	 * @param keyCode the key code value
	 */
	public static void registerButton(AbstractButton button, int keyCode)
	{
		registerButton(button, button.getAction(), keyCode);
	}
	
	/**
	 * Registers the key stroke for the button with an action listener and key code.
	 * @param button the instance of AbstractButton
	 * @param actionListener the instance of ActionListener
	 * @param keyCode the key code value
	 */
	public static void registerButton(AbstractButton button, ActionListener actionListener, int keyCode)
	{
		registerButton(button, actionListener, keyCode, 0);
	}	
	
	/**
	 * Registers the key stroke for the button by the default action listener, key code and modifiers.
	 * @param button the instance of AbstractButton
	 * @param keyCode the key code value
	 * @param modifiers the modifiers value
	 */
	public static void registerButton(AbstractButton button, int keyCode, int modifiers)
	{
		registerButton(button, button.getAction(), keyCode, modifiers);
	}
	
	/**
	 * Registers the key stroke for the button by an action listener, key code and modifiers.
	 * @param button the instance of AbstractButton
	 * @param actionListener the instance of ActionListener
	 * @param keyCode the key code value
	 * @param modifiers the modifiers value
	 */
	public static void registerButton(AbstractButton button, ActionListener actionListener, int keyCode, int modifiers)
	{
		KeyStroke keyStroke = KeyStroke.getKeyStroke(keyCode, modifiers);
		registerButton(button, actionListener, keyStroke);
	}
	
	/**
	 * Registers the key stroke for the button.
	 * @param button the instance of AbstractButton
	 * @param keyStroke the instance of KeyStroke
	 */
	public static void registerButton(AbstractButton button, KeyStroke keyStroke)
	{
		registerButton(button, button.getAction(), keyStroke);
	}
	
	/**
	 * Registers the key stroke for the button by an action listener.
	 * @param button the instance of AbstractButton
	 * @param actionListener the instance of ActionListener
	 * @param keyStroke the instance of KeyStroke
	 */
	public static void registerButton(AbstractButton button, ActionListener actionListener, KeyStroke keyStroke)
	{
		if (button instanceof JMenuItem)
		{
			JMenuItem menuItem = (JMenuItem) button;
			menuItem.setAccelerator(keyStroke);
		}
		else
		{
			button.registerKeyboardAction(actionListener, keyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
		}
	}
	
	/**
	 * Registers the key stroke for the button by the default action listener, key code and mnemonic.
	 * @param button the instance of AbstractButton
	 * @param keyCode the key code value
	 * @param mnemonic the mnemonic value
	 */
	public static void registerButton(AbstractButton button, int keyCode, char mnemonic)
	{
		registerButton(button, button.getAction(), keyCode, mnemonic);
	}
	
	/**
	 * Registers the key stroke for the button by the an action listener, key code and mnemonic.
	 * @param button the instance of AbstractButton
	 * @param actionListener the instance of ActionListener
	 * @param keyCode the key code value
	 * @param mnemonic the mnemonic value
	 */
	public static void registerButton(AbstractButton button, ActionListener actionListener, int keyCode, char mnemonic)
	{
		registerButton(button, actionListener, keyCode, 0, mnemonic);
	}	
	
	/**
	 * Registers the key stroke for the button by the default action listener, modifiers and mnemonic.
	 * @param button the instance of AbstractButton
	 * @param keyCode the key code value
	 * @param modifiers the modifiers value
	 * @param mnemonic the mnemonic value
	 */
	public static void registerButton(AbstractButton button, int keyCode, int modifiers, char mnemonic)
	{
		registerButton(button, button.getAction(), keyCode, modifiers, mnemonic);
	}
	
	/**
	 * Registers the key stroke for the button by an action listener, key code, modifiers and mnemonic.
	 * @param button the instance of AbstractButton
	 * @param actionListener the instance of ActionListener
	 * @param keyCode the key code value
	 * @param modifiers the modifiers value
	 * @param mnemonic the mnemonic value
	 */
	public static void registerButton(AbstractButton button, ActionListener actionListener, int keyCode, int modifiers, char mnemonic)
	{
		KeyStroke keyStroke = KeyStroke.getKeyStroke(keyCode, modifiers);
		registerButton(button, actionListener, keyStroke, mnemonic);
	}
	
	/**
	 * Registers the key stroke for the button by the default action listener and mnemonic.
	 * @param button the instance of AbstractButton
	 * @param keyStroke the instance of KeyStroke
	 * @param mnemonic the mnemonic value
	 */
	public static void registerButton(AbstractButton button, KeyStroke keyStroke, char mnemonic)
	{
		registerButton(button, button.getAction(), keyStroke, mnemonic);
	}
	
	/**
	 * Registers the key stroke for the button by an action listener and mnemonic.
	 * @param button the instance of AbstractButton
	 * @param actionListener the instance of ActionListener
	 * @param keyStroke the instance of KeyStroke
	 * @param mnemonic the mnemonic value
	 */
	public static void registerButton(AbstractButton button, ActionListener actionListener, KeyStroke keyStroke, char mnemonic)
	{	
		registerButton(button, actionListener, keyStroke);
		button.setMnemonic(mnemonic);
	}
	
	/**
	 * Registers the key stroke of "Enter" for the button by the default action listener.
	 * @param button the instance of AbstractButton
	 */
	public static void registerButtonToEnterKey(AbstractButton button)
	{
		registerButtonToEnterKey(button, button.getAction());
	}	
	
	/**
	 * Registers the key stroke of "Enter" for the button by an action listener.
	 * @param button the instance of AbstractButton
	 * @param actionListener the instance of ActionListener
	 */
	public static void registerButtonToEnterKey(AbstractButton button, ActionListener actionListener)
	{
		registerButton(button, actionListener, KeyEvent.VK_ENTER, 0, 'Y');
		button.addAncestorListener(new ButtonAncestorListener());
	}
	
	/**
	 * Registers the key stroke of "Escape" for the button by the default action listener.
	 * @param button the instance of AbstractButton
	 */
	public static void registerButtonToEscapeKey(AbstractButton button)
	{
		registerButtonToEscapeKey(button, button.getAction());
	}
	
	/**
	 * Registers the key stroke of "Escape" for the button by an action listener.
	 * @param button the instance of AbstractButton
	 * @param actionListener the instance of ActionListener
	 */
	public static void registerButtonToEscapeKey(AbstractButton button, ActionListener actionListener)
	{
		registerButton(button, actionListener, KeyEvent.VK_ESCAPE, 0, 'N');
	}
}