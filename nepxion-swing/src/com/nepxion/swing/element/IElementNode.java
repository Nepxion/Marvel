package com.nepxion.swing.element;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.io.IOException;
import java.io.Serializable;

import javax.swing.Icon;

public interface IElementNode
	extends Serializable
{
	/**
	 * The selection index for ignored.
	 */
	public static final int SELECTION_INDEX_IGNORED = 0;
	
	/**
	 * The selection index for contained.
	 */
	public static final int SELECTION_INDEX_CONTAINED = 1;
	
	/**
	 * The selection index for not contained.
	 */
	public static final int SELECTION_INDEX_NOT_CONTAINED = 2;
	
	/**
	 * Gets the index.
	 * @return the index value
	 */
	public int getIndex();
	
	/**
	 * Sets the index.
	 * @param index the index value
	 */
	public void setIndex(int index);
	
	/**
	 * Gest the name. 
	 * @return the name string
	 */
	public String getName();

	/**
	 * Sets the name.
	 * @param name the name string
	 */
	public void setName(String name);
	
	/**
	 * Gets the text.
	 * @return the text sring
	 */
	public String getText();

	/**
	 * Sets the text.
	 * @param text the text string
	 */
	public void setText(String text);
	
	/**
	 * Gets the icon.
	 * @return the instance of Icon
	 */
	public Icon getIcon();
	
	/**
	 * Sets the icon.
	 * @param icon the instance of Icon
	 */
	public void setIcon(Icon icon);
	
	/**
	 * Gets the tooltip text.
	 * @return the tooltip text string
	 */
	public String getToolTipText();
	
	/**
	 * Sets the tooltip text.
	 * @param toolTipText the tooltip text string
	 */
	public void setToolTipText(String toolTipText);	
			
	/**
	 * Returns true if selected.
	 * @return true if selected
	 */
	public boolean isSelected();
	
	/**
	 * Sets the selected.
	 * @param selected the boolean value of selected
	 */
	public void setSelected(boolean selected);
	
	/**
	 * Gets the selected index.
	 * @return the selected index value
	 */
	public int getSelectedIndex();
	
	/**
	 * Sets the selected index.
	 * @param selectedIndex the selected index value 
	 */
	public void setSelectedIndex(int selectedIndex);
	
	/**
	 * Returns true if enabled.
	 * @return true if enabled
	 */
	public boolean isEnabled();
	
	/**
	 * Sets the enabled.
	 * @param enabled the boolean value of enabled
	 */
	public void setEnabled(boolean enabled);	
	
	/**
	 * Returns true if animation.
	 * @return true if animation
	 */
	public boolean isAnimation();
	
	/**
	 * Sets the animation.
	 * @param animation the boolean value of animation
	 */
	public void setAnimation(boolean animation);
	
	/**
	 * Gets the user object.
	 * @return the user object
	 */
	public Object getUserObject();
	
	/**
	 * Sets the user object.
	 * @param userObject the user object
	 */
	public void setUserObject(Object userObject);
	
	/**
	 * To string.
	 * @return the string
	 */
	public String toString();
	
	/**
	 * Deep clones.
	 * @return the instance of IElementNode
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public IElementNode deepClone() throws IOException, ClassNotFoundException;
}