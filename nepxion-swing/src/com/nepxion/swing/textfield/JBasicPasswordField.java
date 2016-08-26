package com.nepxion.swing.textfield;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.JPasswordField;
import javax.swing.text.Document;

public class JBasicPasswordField
	extends JPasswordField
{
	/**
	 * 
	 */
	public JBasicPasswordField()
	{
		super();
	}
	
	public JBasicPasswordField(String text)
	{
		super(text);
	}
	
	public JBasicPasswordField(int columns)
	{
		super(columns);
	}
	
	public JBasicPasswordField(String text, int columns)
	{
		super(text, columns);
	}
	
	public JBasicPasswordField(Document doc, String txt, int columns)
	{
		super(doc, txt, columns);
	}
	
	public String getPasswordText()
	{
		char[] password = getPassword();
		if (password == null || password.length == 0)
		{
			return "";
		}
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(password);
		
		return stringBuffer.toString();
	}
}