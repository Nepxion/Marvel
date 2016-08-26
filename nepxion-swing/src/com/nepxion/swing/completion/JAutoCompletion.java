package com.nepxion.swing.completion;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.text.JTextComponent;

import com.jidesoft.swing.AutoCompletion;
import com.jidesoft.swing.Searchable;

public class JAutoCompletion
	extends AutoCompletion
{
	/**
	 * Constructs with the specified initial comboBox.
	 * @param comboBox the instance of JComboBox
	 */
	public JAutoCompletion(JComboBox comboBox)
	{
		super(comboBox);
	}
	
	/**
	 * Constructs with the specified initial comboBox and searchable.
	 * @param comboBox the instance of JComboBox
	 * @param searchable the instance of Searchable
	 */
	public JAutoCompletion(JComboBox comboBox, Searchable searchable)
	{
		super(comboBox, searchable);
	}
	
	/**
	 * Constructs with the specified initial textComponent and searchable.
	 * @param textComponent the instance of JTextComponent
	 * @param searchable the instance of Searchable
	 */
	public JAutoCompletion(JTextComponent textComponent, Searchable searchable)
	{
		super(textComponent, searchable);
	}
	
	/**
	 * Constructs with the specified initial textComponent and list.
	 * @param textComponent the instance of JTextComponent
	 * @param list the instance of List
	 */
	public JAutoCompletion(JTextComponent textComponent, List list)
	{
		super(textComponent, list);
	}
	
	/**
	 * Constructs with the specified initial textComponent and array.
	 * @param textComponent the instance of JTextComponent
	 * @param array the object array
	 */
	public JAutoCompletion(JTextComponent textComponent, Object[] array)
	{
		super(textComponent, array);
	}
}