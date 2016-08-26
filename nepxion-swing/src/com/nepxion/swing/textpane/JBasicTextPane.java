package com.nepxion.swing.textpane;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

import com.nepxion.swing.textcomponent.TextPopupMenuAdapter;

public class JBasicTextPane
	extends JTextPane
{
	/**
	 * The instance of TextPopupMenuAdapter.
	 */
	private TextPopupMenuAdapter popupMenuAdapter;
	
	/**
	 * Constructs with the default.
	 */
	public JBasicTextPane()
	{
		super();
		
		popupMenuAdapter = new TextPopupMenuAdapter(this);
	}
	
	/**
	 * Constructs with the specified initial doc.
	 * @param doc the instance of StyledDocument
	 */
	public JBasicTextPane(StyledDocument doc)
	{
		super(doc);
		
		popupMenuAdapter = new TextPopupMenuAdapter(this);
	}
	
	/**
	 * Gets the text popup menu adapter.
	 * @return the instance of TextPopupMenuAdapter
	 */
	public TextPopupMenuAdapter getPopupMenuAdapter()
	{
		return popupMenuAdapter;
	}
	
	/**
	 * Sets enabled.
	 * @param enabled the boolean value of enabled
	 */
	public void setEnabled(boolean enabled)
	{
		super.setEnabled(enabled);
		
		if (enabled)
		{
			addMouseListener(popupMenuAdapter);
		}
		else
		{
			removeMouseListener(popupMenuAdapter);
		}
	}	
}