package com.nepxion.swing.query.result;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.thread.container.JThreadContainer;

public abstract class JQueryThreadContainer
	extends JThreadContainer
{
	/**
	 * The context element node.
	 */
	private ElementNode contextElementNode;
	
	/**
	 * Constructs with the specified initial query target.
	 * @param queryTarget the query target string
	 */
	public JQueryThreadContainer(String queryTarget)
	{
		super(SwingLocale.getString("query_and_wait"));
		
		contextElementNode = new ElementNode();
		
		setInformationText(SwingLocale.getString("query") + " " + SwingLocale.getString("quotation_left") + queryTarget + SwingLocale.getString("quotation_right") + " " + SwingLocale.getString("relative_data"));
		setInformationIcon(IconFactory.getSwingIcon("banner/query_128.png"));
		setErrorText(SwingLocale.getString("query") + " " + SwingLocale.getString("quotation_left") + queryTarget + SwingLocale.getString("quotation_right") + " " + SwingLocale.getString("relative_data_exception"));
		setErrorIcon(IconFactory.getSwingIcon("banner/error_128.png"));
		setThreadPanelWidth(300);
		
		showInformation();
	}
	
	/**
	 * Gets the context element node.
	 * @return the instance of ElementNode
	 */
	public ElementNode getContextElementNode()
	{
		return contextElementNode;
	}
	
	/**
	 * Sets the context element node.
	 * @param contextElementNode the instance of ElementNode
	 */
	public void setContextElementNode(ElementNode contextElementNode)
	{
		this.contextElementNode = contextElementNode;
	}
	
	/**
	 * Returns true if the container loads the cached component.
	 * @return true if the container loads the cached component
	 */
	public boolean isLoadCache()
	{
		return false;
	}
}