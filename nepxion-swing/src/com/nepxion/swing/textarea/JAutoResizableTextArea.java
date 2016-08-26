package com.nepxion.swing.textarea;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.text.Document;

import com.jidesoft.swing.AutoResizingTextArea;
import com.nepxion.swing.textcomponent.TextPopupMenuAdapter;

public class JAutoResizableTextArea
	extends AutoResizingTextArea
{
	/**
	 * The instance of TextPopupMenuAdapter.
	 */
	private TextPopupMenuAdapter popupMenuAdapter;
	
	/**
	 * Constructs with the default.
	 */
	public JAutoResizableTextArea()
	{
		super();
		
		popupMenuAdapter = new TextPopupMenuAdapter(this);
	}
	
	/**
	 * Constructs with the specified initial minimum row count.
	 * @param minRows the minimum row count value
	 */
	public JAutoResizableTextArea(int minRows)
	{
		super(minRows);
		
		popupMenuAdapter = new TextPopupMenuAdapter(this);
	}
	
	/**
	 * Constructs with the specified initial minimum row count and maximum row count.
	 * @param minRows the minimum row count value
	 * @param maxRows the maximum row count value
	 */
	public JAutoResizableTextArea(int minRows, int maxRows)
	{
		super(minRows, maxRows);
		
		popupMenuAdapter = new TextPopupMenuAdapter(this);
	}
	
	/**
	 * Constructs with the specified initial text.
	 * @param text the text string 
	 */
	public JAutoResizableTextArea(String text)
	{
		super(text);
		
		popupMenuAdapter = new TextPopupMenuAdapter(this);
	}
	
	/**
	 * Constructs with the specified initial minimum row count, maximum row count and column count.
	 * @param minRows the minimum row count value
	 * @param maxRows the maximum row count value
	 * @param columns the column count value
	 */
	public JAutoResizableTextArea(int minRows, int maxRows, int columns)
	{
		super(minRows, maxRows, columns);
		
		popupMenuAdapter = new TextPopupMenuAdapter(this);
	}
	
	/**
	 * Constructs with the specified initial text, minimum row count, maximum row count and column count.
	 * @param text the text string
	 * @param minRows the minimum row count value
	 * @param maxRows the maximum row count value
	 * @param columns the column count value
	 */
	public JAutoResizableTextArea(String text, int minRows, int maxRows, int columns)
	{
		super(text, minRows, maxRows, columns);
		
		popupMenuAdapter = new TextPopupMenuAdapter(this);
	}
	
	/**
	 * Constructs with the specified initial doc.
	 * @param doc the instance of Document
	 */
	public JAutoResizableTextArea(Document doc)
	{
		super(doc);
		
		popupMenuAdapter = new TextPopupMenuAdapter(this);
	}
	
	/**
	 * Constructs with the specified initial doc, text, minimum row count, maximum row count and column count.
	 * @param doc the instance of Document
	 * @param text the text string
	 * @param minRows the minimum row count value
	 * @param maxRows the maximum row count value
	 * @param columns the column count value
	 */
	public JAutoResizableTextArea(Document doc, String text, int minRows, int maxRows, int columns)
	{
		super(doc, text, minRows, maxRows, columns);
		
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
	
	/**
	 * Sets the label style.
	 */
	public void setLabelStyle()
	{
		TextAreaManager.setLabelStyle(this);
		
		removeMouseListener(popupMenuAdapter);
	}
}