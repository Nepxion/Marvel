package com.nepxion.swing.textcomponent;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.text.JTextComponent;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.keystroke.KeyStrokeManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;

public class TextPopupMenuAdapter
	implements MouseListener
{
	/**
	 * The text component.
	 */
	private JTextComponent textComponent;
	
	/**
	 * The copy menu item.
	 */
	private JBasicMenuItem copyMenuItem;
	
	/**
	 * The paste menu item.
	 */
	private JBasicMenuItem pasteMenuItem;
	
	/**
	 * The cut menu item.
	 */
	private JBasicMenuItem cutMenuItem;
	
	/**
	 * The clear menu item.
	 */
	private JBasicMenuItem clearMenuItem;
	
	/**
	 * The select all menu item.
	 */
	private JBasicMenuItem selectAllMenuItem;
	
	/**
	 * The popup menu.
	 */
	private JBasicPopupMenu popupMenu;
	
	/**
	 * Constructs with the specified initial text component.
	 * @param textComponent the instance of JTextComponent
	 */
	public TextPopupMenuAdapter(final JTextComponent textComponent)
	{
		this.textComponent = textComponent;
		this.textComponent.addMouseListener(this);
		
		popupMenu = new JBasicPopupMenu();
		
		copyMenuItem = new JBasicMenuItem(SwingLocale.getString("copy"), IconFactory.getSwingIcon("copy.png"), SwingLocale.getString("copy"));
		KeyStrokeManager.registerButton(copyMenuItem, KeyEvent.VK_C, KeyEvent.CTRL_MASK, 'C');
		copyMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				textComponent.copy();
			}
		}
		);
		popupMenu.add(copyMenuItem);
		
		pasteMenuItem = new JBasicMenuItem(SwingLocale.getString("paste"), IconFactory.getSwingIcon("paste.png"), SwingLocale.getString("paste"));
		KeyStrokeManager.registerButton(pasteMenuItem, KeyEvent.VK_V, KeyEvent.CTRL_MASK, 'V');
		pasteMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				textComponent.paste();
			}
		}
		);
		popupMenu.add(pasteMenuItem);
		
		cutMenuItem = new JBasicMenuItem(SwingLocale.getString("cut"), IconFactory.getSwingIcon("cut.png"), SwingLocale.getString("cut"));
		KeyStrokeManager.registerButton(cutMenuItem, KeyEvent.VK_X, KeyEvent.CTRL_MASK, 'X');
		cutMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				textComponent.cut();
			}
		}
		);
		popupMenu.add(cutMenuItem);
		
		clearMenuItem = new JBasicMenuItem(SwingLocale.getString("clean"), IconFactory.getSwingIcon("clear.png"), SwingLocale.getString("clear"));
		ActionListener clearActionListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textComponent.setText("");
			}
		};
		clearMenuItem.addActionListener(clearActionListener);
		KeyStrokeManager.registerComponent(textComponent, clearActionListener, KeyEvent.VK_R, KeyEvent.CTRL_MASK);
		KeyStrokeManager.registerButton(clearMenuItem, KeyEvent.VK_R, KeyEvent.CTRL_MASK, 'R');
		popupMenu.add(clearMenuItem);
		
		selectAllMenuItem = new JBasicMenuItem(SwingLocale.getString("select_all"), IconFactory.getSwingIcon("select_all.png"), SwingLocale.getString("select_all"));
		KeyStrokeManager.registerButton(selectAllMenuItem, KeyEvent.VK_A, KeyEvent.CTRL_MASK, 'A');
		selectAllMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				textComponent.requestFocusInWindow();
				textComponent.selectAll();
			}
		}
		);
		popupMenu.add(selectAllMenuItem);
	}
	
	/**
	 * Returns true if the clip board has content.
	 * @return true if the clip board has content
	 */
	private boolean hasContent()
	{
		boolean hasContent = false;
		Clipboard clipboard = textComponent.getToolkit().getSystemClipboard();
		Transferable content = clipboard.getContents(textComponent);
		
		try
		{
			hasContent = content.getTransferData(DataFlavor.stringFlavor) instanceof String;
		}
		catch (UnsupportedFlavorException e)
		{
			
		}
		catch (IOException e)
		{
			
		}
		
		return hasContent;
	}
	
	/**
	 * Returns true if it can copy.
	 * @return true if it can copy
	 */
	private boolean canCopy()
	{
		return textComponent.getSelectionStart() != textComponent.getSelectionEnd();
	}
	
	/**
	 * Returns true if it can delete.
	 * @return true if it can delete
	 */
	private boolean canDelete()
	{
		return !textComponent.getText().equals("");
	}
	
	/**
	 * Gets the popup menu.
	 * @return the instance of JBasicPopupMenu
	 */
	public JBasicPopupMenu getPopupMenu()
	{
		return popupMenu;
	}
	
	/**
	 * Gets the copy menu item.
	 * @return the instance of JBasicMenuItem
	 */
	public JBasicMenuItem getCopyMenuItem()
	{
		return copyMenuItem;
	}
	
	/**
	 * Gets the paste menu item.
	 * @return the instance of JBasicMenuItem
	 */
	public JBasicMenuItem getPasteMenuItem()
	{
		return pasteMenuItem;
	}
	
	/**
	 * Gets the cut menu item.
	 * @return the instance of JBasicMenuItem
	 */
	public JBasicMenuItem getCutMenuItem()
	{
		return cutMenuItem;
	}
	
	/**
	 * Gets the clear menu item.
	 * @return the instance of JBasicMenuItem
	 */
	public JBasicMenuItem getClearMenuItem()
	{
		return clearMenuItem;
	}
	
	/**
	 * Gets the select all item.
	 * @return the instance of JBasicMenuItem
	 */
	public JBasicMenuItem getSelectAllMenuItem()
	{
		return selectAllMenuItem;
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
		if (!e.isPopupTrigger())
		{
			return;
		}
		
		if (!textComponent.isEnabled())
		{
			return;
		}
		
		if (textComponent.isEditable())
		{
			copyMenuItem.setEnabled(canCopy());
			pasteMenuItem.setEnabled(hasContent());
			cutMenuItem.setEnabled(canCopy());
			clearMenuItem.setEnabled(canDelete());
		}
		else
		{
			copyMenuItem.setEnabled(canCopy());
			pasteMenuItem.setEnabled(false);
			cutMenuItem.setEnabled(false);
			clearMenuItem.setEnabled(false);
		}
		
		popupMenu.show(e.getComponent(), e.getX(), e.getY());
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
}