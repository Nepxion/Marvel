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

import javax.swing.Icon;
import javax.swing.tree.DefaultMutableTreeNode;

import com.nepxion.util.data.CloneUtil;

public class ElementNode
	extends DefaultMutableTreeNode implements IElementNode
{
	private static final long serialVersionUID = -8432382270356530085L;

	/**
	 * The index value.
	 */
	private int index = -1;
	
	/**
	 * The name string.
	 */
	private String name;
	
	/**
	 * The text string.
	 */
	private String text;
	
	/**
	 * The instance of Icon.
	 */
	private Icon icon;
	
	/**
	 * The tooltip text String.
	 */
	private String toolTipText;
	
	/**
	 * The selected index value.
	 */
	private int selectedIndex = 0;
	
	/**
	 * The boolean value of selected.
	 */
	private boolean selected = false;
	
	/**
	 * The boolean value of enabled.
	 */
	private boolean enabled = true;
	
	/**
	 * The boolean value of animation.
	 */
	private boolean animation = false;	
	
	/**
	 * Constructs with the default.
	 */
	public ElementNode()
	{
		this(null, null, null);
	}
	
	/**
	 * Constructs with the specified initial text, icon and tooltip text.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public ElementNode(String text, Icon icon, String toolTipText)
	{
		this(null, text, icon, toolTipText);
	}	
	
	/**
	 * Constructs with the specified initial text, icon, tooltip text and selected.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 */
	public ElementNode(String text, Icon icon, String toolTipText, boolean selected)
	{
		this(-1, text, icon, toolTipText, selected);
	}		
	
	/**
	 * Constructs with the specified initial text, icon, tooltip text and user object.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param userObject the user object
	 */
	public ElementNode(String text, Icon icon, String toolTipText, Object userObject)
	{
		this(-1, text, icon, toolTipText, userObject);
	}	

	/**
	 * Constructs with the specified initial index, text, icon and tooltip text.
	 * @param index the index value
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public ElementNode(int index, String text, Icon icon, String toolTipText)
	{
		this(index, text, icon, toolTipText, null);
	}	

	/**
	 * Constructs with the specified initial name, text, icon and tooltip text.
	 * @param name the name string
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public ElementNode(String name, String text, Icon icon, String toolTipText)
	{
		this(-1, name, text, icon, toolTipText);
	}
	
	/**
	 * Constructs with the specified initial text, icon, tooltip text, selected and enabled.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 * @param enabled the boolean value of enabled
	 */
	public ElementNode(String text, Icon icon, String toolTipText, boolean selected, boolean enabled)
	{
		this(-1, text, icon, toolTipText, selected, enabled);
	}			

	/**
	 * Constructs with the specified initial text, icon, tooltip text, user object and selected.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param userObject the user object
	 * @param selected the boolean value of selected
	 */
	public ElementNode(String text, Icon icon, String toolTipText, Object userObject, boolean selected)
	{
		this(-1, text, icon, toolTipText, userObject, selected);
	}		

	/**
	 * Constructs with the specified initial name, text, icon, tooltip text and selected.
	 * @param name the name string
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 */
	public ElementNode(String name, String text, Icon icon, String toolTipText, boolean selected)
	{
		this(-1, name, text, icon, toolTipText, selected);
	}	

	/**
	 * Constructs with the specified initial index, text, icon, tooltip text and selected.
	 * @param index the index value
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 */
	public ElementNode(int index, String text, Icon icon, String toolTipText, boolean selected)
	{
		this(index, null, text, icon, toolTipText, selected);
	}		

	/**
	 * Constructs with the specified initial name, text, icon, tooltip text and user object.
	 * @param name the name string
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param userObject the user object
	 */
	public ElementNode(String name, String text, Icon icon, String toolTipText, Object userObject)
	{
		this(-1, name, text, icon, toolTipText, userObject);
	}

	/**
	 * Constructs with the specified initial index, text, icon, tooltip text and user object.
	 * @param index the index value
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param userObject the user object
	 */
	public ElementNode(int index, String text, Icon icon, String toolTipText, Object userObject)
	{
		this(index, null, text, icon, toolTipText, userObject);
	}	

	/**
	 * Constructs with the specified initial index, name, text, icon and tooltip text.
	 * @param index the index value
	 * @param name the name string
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public ElementNode(int index, String name, String text, Icon icon, String toolTipText)
	{
		this(index, name, text, icon, toolTipText, null);
	}
	
	/**
	 * Constructs with the specified initial text, icon, tooltip text, user object, selected and enabled.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param userObject the user object
	 * @param selected the boolean value of selected
	 * @param enabled the boolean value of enabled
	 */
	public ElementNode(String text, Icon icon, String toolTipText, Object userObject, boolean selected, boolean enabled)
	{
		this(-1, text, icon, toolTipText, userObject, selected, enabled);
	}
	
	/**
	 * Constructs with the specified initial name, text, icon, tooltip text, selected and enabled.
	 * @param name the name string
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 * @param enabled the boolean value of enabled
	 */
	public ElementNode(String name, String text, Icon icon, String toolTipText, boolean selected, boolean enabled)
	{
		this(-1, name, text, icon, toolTipText, selected, enabled);
	}	

	/**
	 * Constructs with the specified initial index, text, icon, tooltip text, selected and enabled.
	 * @param index the index value
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 * @param enabled the boolean value of enabled
	 */
	public ElementNode(int index, String text, Icon icon, String toolTipText, boolean selected, boolean enabled)
	{
		this(index, null, text, icon, toolTipText, selected, enabled);
	}
	
	/**
	 * Constructs with the specified initial name, text, icon, tooltip text, user object and selected.
	 * @param name the name string
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param userObject the user object
	 * @param selected the boolean value of selected
	 */
	public ElementNode(String name, String text, Icon icon, String toolTipText, Object userObject, boolean selected)
	{
		this(-1, name, text, icon, toolTipText, userObject, selected);
	}	
	
	/**
	 * Constructs with the specified initial index, text, icon, tooltip text, user object and selected.
	 * @param index the index value
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param userObject the user object
	 * @param selected the boolean value of selected
	 */
	public ElementNode(int index, String text, Icon icon, String toolTipText, Object userObject, boolean selected)
	{
		this(index, null, text, icon, toolTipText, userObject, selected);
	}	
	
	/**
	 * Constructs with the specified initial index, name, text, icon, tooltip text and selected.
	 * @param index the index value
	 * @param name the name string
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 */
	public ElementNode(int index, String name, String text, Icon icon, String toolTipText, boolean selected)
	{
		this(index, name, text, icon, toolTipText, null, selected);
	}	
	
	/**
	 * Constructs with the specified initial index, name, text, icon, tooltip text and user object.
	 * @param index the index value
	 * @param name the name string
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param userObject the user object
	 */
	public ElementNode(int index, String name, String text, Icon icon, String toolTipText, Object userObject)
	{
		this(index, name, text, icon, toolTipText, userObject, false);
	}
	
	/**
	 * Constructs with the specified initial name, text, icon, tooltip text, user object, selected and enabled.
	 * @param name the name string
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param userObject the user object
	 * @param selected the boolean value of selected
	 * @param enabled the boolean value of enabled
	 */
	public ElementNode(String name, String text, Icon icon, String toolTipText, Object userObject, boolean selected, boolean enabled)
	{
		this(-1, name, text, icon, toolTipText, userObject, selected, enabled);
	}
	
	/**
	 * Constructs with the specified initial index, text, icon, tooltip text, user object, selected and enabled.
	 * @param index the index value
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param userObject the user object
	 * @param selected the boolean value of selected
	 * @param enabled the boolean value of enabled
	 */
	public ElementNode(int index, String text, Icon icon, String toolTipText, Object userObject, boolean selected, boolean enabled)
	{
		this(index, null, text, icon, toolTipText, userObject, selected, enabled);
	}
	
	/**
	 * Constructs with the specified initial index, name, text, icon, tooltip text, selected and enabled.
	 * @param index the index value
	 * @param name the name string
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param selected the boolean value of selected
	 * @param enabled the boolean value of enabled
	 */
	public ElementNode(int index, String name, String text, Icon icon, String toolTipText, boolean selected, boolean enabled)
	{
		this(index, name, text, icon, toolTipText, null, selected, enabled);
	}
	
	/**
	 * Constructs with the specified initial index, name, text, icon, tooltip text, user object and selected.
	 * @param index the index value
	 * @param name the name string
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param userObject the user object
	 * @param selected the boolean value of selected
	 */
	public ElementNode(int index, String name, String text, Icon icon, String toolTipText, Object userObject, boolean selected)
	{
		this(index, name, text, icon, toolTipText, userObject, selected, true);
	}
	
	/**
	 * Constructs with the specified initial index, name, text, icon, tooltip text, user object, selected and enabled.
	 * @param index the index value
	 * @param name the name string
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param userObject the user object
	 * @param selected the boolean value of selected
	 * @param enabled the boolean value of enabled
	 */
	public ElementNode(int index, String name, String text, Icon icon, String toolTipText, Object userObject, boolean selected, boolean enabled)
	{
		this(userObject);
		
		this.index = index;
		this.name = name;
		this.text = text;
		this.icon = icon;
		this.toolTipText = toolTipText;
		this.selected = selected;
		this.enabled = enabled;
	}	
	
	
	/**
	 * Constructs with the specified initial user object.
	 * @param userObject
	 */
	public ElementNode(Object userObject)
	{
		super(userObject);
	}
	
	/**
	 * Constructs with the specified initial user object and allowsChildren.
	 * @param userObject the user object
	 * @param allowsChildren the boolean value of allowsChildren
	 */
	public ElementNode(Object userObject, boolean allowsChildren)
	{
		super(userObject, allowsChildren);
	}	
	
	/**
	 * Gets the index.
	 * @return the index value
	 */
	public int getIndex()
	{
		return index;
	}
	
	/**
	 * Sets the index.
	 * @param index the index value
	 */
	public void setIndex(int index)
	{
		this.index = index;
	}
	
	/**
	 * Gets the name. 
	 * @return the name string
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name.
	 * @param name the name string
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Gets the text.
	 * @return the text sring
	 */
	public String getText()
	{
		return text;
	}
	
	/**
	 * Sets the text.
	 * @param text the text string
	 */
	public void setText(String text)
	{
		this.text = text;
	}
	
	/**
	 * Gets the icon.
	 * @return the instance of Icon
	 */
	public Icon getIcon()
	{
		return icon;
	}
	
	/**
	 * Sets the icon.
	 * @param icon the instance of Icon
	 */
	public void setIcon(Icon icon)
	{
		this.icon = icon;
	}
	
	/**
	 * Gets the tooltip text.
	 * @return the tooltip text string
	 */
	public String getToolTipText()
	{
		return toolTipText;
	}
	
	/**
	 * Sets the tooltip text.
	 * @param toolTipText the tooltip text string
	 */
	public void setToolTipText(String toolTipText)
	{
		this.toolTipText = toolTipText;
	}	
	
	/**
	 * Returns true if selected.
	 * @return true if selected
	 */
	public boolean isSelected()
	{
		return selected;
	}
	
	/**
	 * Sets the selected.
	 * @param selected the boolean value of selected
	 */
	public void setSelected(boolean selected)
	{
		this.selected = selected;
	}
	
	/**
	 * Gets the selected index.
	 * @return the selected index value
	 */
	public int getSelectedIndex()
	{
		return selectedIndex;
	}
	
	/**
	 * Sets the selected index.
	 * @param selectedIndex the selected index value 
	 */
	public void setSelectedIndex(int selectedIndex)
	{
		this.selectedIndex = selectedIndex;
	}
	
	/**
	 * Returns true if enabled.
	 * @return true if enabled
	 */
	public boolean isEnabled()
	{
		return enabled;
	}
	
	/**
	 * Sets the enabled.
	 * @param enabled the boolean value of enabled
	 */
	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}	
	
	/**
	 * Returns true if animation.
	 * @return true if animation
	 */
	public boolean isAnimation()
	{
		return animation;
	}
	
	/**
	 * Sets the animation.
	 * @param animation the boolean value of animation
	 */
	public void setAnimation(boolean animation)
	{
		this.animation = animation;
	}	
	
	/**
	 * To string.
	 * @return the string
	 */
	public String toString()
	{
		return text;
	}
	
	/**
	 * Deep clones.
	 * @return the instance of IElementNode
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public ElementNode deepClone()
		throws IOException, ClassNotFoundException
	{
		return (ElementNode) CloneUtil.deepClone(this);
	}
}