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

import javax.swing.JTextArea;
import javax.swing.text.Document;

import com.nepxion.swing.textcomponent.TextPopupMenuAdapter;

public class JBasicTextArea
	extends JTextArea
{
	/**
	 * The instance of TextPopupMenuAdapter.
	 */
	private TextPopupMenuAdapter popupMenuAdapter;
	
	/**
	 * Constructs with the default.
	 */
	public JBasicTextArea()
	{
		super();
		
		popupMenuAdapter = new TextPopupMenuAdapter(this);
	}
	
	/**
	 * Constructs with the specified initial text.
	 * @param text the text string 
	 */
	public JBasicTextArea(String text)
	{
		super(text);
		
		popupMenuAdapter = new TextPopupMenuAdapter(this);
	}
	
	/**
	 * Constructs with the specified initial row count and column count.
	 * @param rows the row count value
	 * @param columns the column count value
	 */
	public JBasicTextArea(int rows, int columns)
	{
		super(rows, columns);
		
		popupMenuAdapter = new TextPopupMenuAdapter(this);
	}
	
	/**
	 * Constructs with the specified initial text, row count and column count.
	 * @param text the text string
	 * @param rows the row count value
	 * @param columns the column count value
	 */
	public JBasicTextArea(String text, int rows, int columns)
	{
		super(text, rows, columns);
		
		popupMenuAdapter = new TextPopupMenuAdapter(this);
	}
	
	/**
	 * Constructs with the specified initial doc.
	 * @param doc the instance of Document
	 */
	public JBasicTextArea(Document doc)
	{
		super(doc);
		
		popupMenuAdapter = new TextPopupMenuAdapter(this);
	}
	
	/**
	 * Constructs with the specified initial doc, text, row count and column count.
	 * @param doc the instance of Document
	 * @param text the text string
	 * @param rows the row count value
	 * @param columns the column count value
	 */
	public JBasicTextArea(Document doc, String text, int rows, int columns)
	{
		super(doc, text, rows, columns);
		
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