package com.nepxion.swing.list.toggle;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.toggle.IToggleContentPanel;
import com.nepxion.swing.toggle.ITogglePanel;
import com.nepxion.swing.toggle.JThreadTogglePanel;

public abstract class AbstractToggleAdapter
	implements IToggleAdapter
{
	/**
	 * The instance of IToggleList.
	 */
	private IToggleList toggleList;
	
	/**
	 * Constructs with the specified initial toggle list.
	 * @param toggleList the instance of IToggleList
	 */
	public AbstractToggleAdapter(IToggleList toggleList)
	{
		this.toggleList = toggleList;
		this.toggleList.setToggleAdapter(this);
	}
	
	/**
	 * Toggles the selection. 
	 * @param oldSelectedRow the old selected row index value
	 * @param newSelectedRow the new selected row index value
	 */
	public void toggle(int oldSelectedRow, int newSelectedRow)
	{
		if (newSelectedRow == -1)
		{
			return;
		}
		
		IToggleContentPanel toggleContentPanel = toggleList.getToggleContentPanel();
		if (toggleContentPanel == null)
		{
			return;
		}
		
		IElementNode elementNode = (IElementNode) toggleList.getModel().getElementAt(newSelectedRow);
		
		ITogglePanel togglePanel = getTogglePanel(elementNode);
		if (togglePanel == null)
		{
			return;
		}
		
		String text = elementNode.toString();
		
		if (togglePanel.getToggleText() == null)
		{
			togglePanel.setToggleText(text);
		}
		
		if (togglePanel.getToggleDescription() == null)
		{
			togglePanel.setToggleDescription(text);
		}
		
		toggleContentPanel.toggle(togglePanel);
		
		if (togglePanel instanceof JThreadTogglePanel)
		{
			JThreadTogglePanel threadTogglePanel = (JThreadTogglePanel) togglePanel;
			threadTogglePanel.execute();
		}
	}
	
	/**
	 * Gets the toggle list.
	 * @return the instance of IToggleList
	 */
	public IToggleList getToggleList()
	{
		return toggleList;
	}
	
	/**
	 * Gets the toggle panel by an element node.
	 * @param elementNode the instance of IElementNode 
	 * @return the instance of ITogglePanel
	 */
	public abstract ITogglePanel getTogglePanel(IElementNode elementNode);
}