package com.nepxion.swing.menuitem;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenuItem;

import com.nepxion.swing.checkbox.LiteCheckBoxModel;
import com.nepxion.swing.style.button.lite.JAcidLiteButtonStyle;
import com.nepxion.swing.style.menu.AbstractCheckBoxMenuItemUI;
import com.nepxion.swing.style.menu.lite.LiteCheckBoxMenuItemUI;

public class JLiteCheckBoxMenuItem
	extends JMenuItem
{
	/**
	 * Constructs with the default.
	 */
	public JLiteCheckBoxMenuItem()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial action.
	 * @param action the instance of Action
	 */
	public JLiteCheckBoxMenuItem(Action action)
	{
		super(action);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text.
	 * @param text the text string
	 */
	public JLiteCheckBoxMenuItem(String text)
	{
		super(text);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial icon.
	 * @param icon the instance of Icon
	 */
	public JLiteCheckBoxMenuItem(Icon icon)
	{
		super(icon);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text and icon.
	 * @param text the text string 
	 * @param icon the icon of Icon
	 */
	public JLiteCheckBoxMenuItem(String text, Icon icon)
	{
		super(text, icon);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text and tooltip text.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 */
	public JLiteCheckBoxMenuItem(String text, String toolTipText)
	{
		super(text);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial text and selected.
	 * @param text the text string
	 * @param selected the boolean value of selected
	 */
	public JLiteCheckBoxMenuItem(String text, boolean selected)
	{
		super(text);
		
		initComponents();
		
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial icon and tooltip text.
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JLiteCheckBoxMenuItem(Icon icon, String toolTipText)
	{
		super(icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial icon and selected.
	 * @param icon the instance of Icon
	 * @param selected the boolean value of selected
	 */
	public JLiteCheckBoxMenuItem(Icon icon, boolean selected)
	{
		super(icon);
		
		initComponents();
		
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial text, icon and tooltip text.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JLiteCheckBoxMenuItem(String text, Icon icon, String toolTipText)
	{
		super(text, icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial text, icon and selected.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param selected the boolean value of selected
	 */
	public JLiteCheckBoxMenuItem(String text, Icon icon, boolean selected)
	{
		super(text, icon);
		
		initComponents();
		
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial text, tooltip text and selected.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 */
	public JLiteCheckBoxMenuItem(String text, String toolTipText, boolean selected)
	{
		super(text);
		
		initComponents();
		
		setToolTipText(toolTipText);
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial icon, tooltip text and selected.
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 */
	public JLiteCheckBoxMenuItem(Icon icon, String toolTipText, boolean selected)
	{
		super(icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial text, icon, tooltip text and selected.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 */
	public JLiteCheckBoxMenuItem(String text, Icon icon, String toolTipText, boolean selected)
	{
		super(text, icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial text and mnemonic.
	 * @param text the text string
	 * @param mnemonic the mnemonic int value
	 */
	public JLiteCheckBoxMenuItem(String text, int mnemonic)
	{
		super(text, mnemonic);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text and mnemonic.
	 * @param text the text string
	 * @param mnemonic the mnemonic char value
	 */
	public JLiteCheckBoxMenuItem(String text, char mnemonic)
	{
		super(text);
		
		initComponents();
		
		setMnemonic(mnemonic);
	}
	
	/**
	 * Constructs with the specified initial text, icon and mnemonic.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param mnemonic the mnemonic int value
	 */
	public JLiteCheckBoxMenuItem(String text, Icon icon, int mnemonic)
	{
		super(text, mnemonic);
		
		initComponents();
		
		setIcon(icon);
	}
	
	/**
	 * Constructs with the specified initial text, icon and mnemonic.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param mnemonic the mnemonic char value
	 */
	public JLiteCheckBoxMenuItem(String text, Icon icon, char mnemonic)
	{
		super(text, icon);
		
		initComponents();
		
		setMnemonic(mnemonic);
	}
	
	/**
	 * Constructs with the specified initial text, tooltip text and mnemonic.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 * @param mnemonic the mnemonic int value
	 */
	public JLiteCheckBoxMenuItem(String text, String toolTipText, int mnemonic)
	{
		super(text, mnemonic);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial text, tooltip text and mnemonic.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 * @param mnemonic the mnemonic char value
	 */
	public JLiteCheckBoxMenuItem(String text, String toolTipText, char mnemonic)
	{
		super(text);
		
		initComponents();
		
		setToolTipText(toolTipText);
		setMnemonic(mnemonic);
	}
	
	/**
	 * Constructs with the specified initial text, selected and mnemonic.
	 * @param text the text string
	 * @param selected the boolean value of selected
	 * @param mnemonic the mnemonic int value
	 */
	public JLiteCheckBoxMenuItem(String text, boolean selected, int mnemonic)
	{
		super(text, mnemonic);
		
		initComponents();
		
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial text, selected and mnemonic.
	 * @param text the text string
	 * @param selected the boolean value of selected
	 * @param mnemonic the mnemonic char value
	 */
	public JLiteCheckBoxMenuItem(String text, boolean selected, char mnemonic)
	{
		super(text);
		
		initComponents();
		
		setSelected(selected);
		setMnemonic(mnemonic);
	}
	
	/**
	 * Constructs with the specified initial text, icon, tooltip text and mnemonic.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param mnemonic the mnemonic int value
	 */
	public JLiteCheckBoxMenuItem(String text, Icon icon, String toolTipText, int mnemonic)
	{
		super(text, mnemonic);
		
		initComponents();
		
		setIcon(icon);
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial text, icon, tooltip text and mnemonic.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param mnemonic the mnemonic char value
	 */
	public JLiteCheckBoxMenuItem(String text, Icon icon, String toolTipText, char mnemonic)
	{
		super(text, icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
		setMnemonic(mnemonic);
	}
	
	/**
	 * Constructs with the specified initial text, icon, selected and mnemonic.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param selected the boolean value of selected
	 * @param mnemonic the mnemonic int value
	 */
	public JLiteCheckBoxMenuItem(String text, Icon icon, boolean selected, int mnemonic)
	{
		super(text, mnemonic);
		
		initComponents();
		
		setIcon(icon);
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial text, icon, selected and mnemonic.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param selected the boolean value of selected
	 * @param mnemonic the mnemonic char value
	 */
	public JLiteCheckBoxMenuItem(String text, Icon icon, boolean selected, char mnemonic)
	{
		super(text, icon);
		
		initComponents();
		
		setSelected(selected);
		setMnemonic(mnemonic);
	}
	
	/**
	 * Constructs with the specified initial text, tooltip text, selected and mnemonic.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 * @param mnemonic the mnemonic int value
	 */
	public JLiteCheckBoxMenuItem(String text, String toolTipText, boolean selected, int mnemonic)
	{
		super(text, mnemonic);
		
		initComponents();
		
		setToolTipText(toolTipText);
		setSelected(selected);
	}
	
	/**
	 * Constructs with the specified initial text, tooltip text, selected and mnemonic.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 * @param mnemonic the mnemonic char value
	 */
	public JLiteCheckBoxMenuItem(String text, String toolTipText, boolean selected, char mnemonic)
	{
		super(text);
		
		initComponents();
		
		setToolTipText(toolTipText);
		setSelected(selected);
		setMnemonic(mnemonic);
	}
	
	/**
	 * Constructs with the specified initial text, icon, tooltip text, selected and mnemonic.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 * @param mnemonic the mnemonic int value
	 */
	public JLiteCheckBoxMenuItem(String text, Icon icon, String toolTipText, boolean selected, int mnemonic)
	{
		super(text, mnemonic);
		
		initComponents();
		
		setIcon(icon);
		setToolTipText(toolTipText);
		setSelected(selected);
	}	
	
	/**
	 * Constructs with the specified initial text, icon, tooltip text, selected and mnemonic.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 * @param mnemonic the mnemonic char value
	 */
	public JLiteCheckBoxMenuItem(String text, Icon icon, String toolTipText, boolean selected, char mnemonic)
	{
		super(text);
		
		initComponents();
		
		setIcon(icon);
		setToolTipText(toolTipText);
		setSelected(selected);
		setMnemonic(mnemonic);
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		LiteCheckBoxModel checkBoxModel = new LiteCheckBoxModel();
		setModel(checkBoxModel);
		
		AbstractCheckBoxMenuItemUI checkBoxUI = new LiteCheckBoxMenuItemUI(new JAcidLiteButtonStyle());
		setUI(checkBoxUI);
		
		setRolloverEnabled(true);
	}
	
	/**
	 * Updates the ui.
	 */
	public void updateUI()
	{
		setUI(getUI());
	}
}