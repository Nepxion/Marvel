package com.nepxion.util.searcher.id.netease;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.net.URI;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.nepxion.util.locale.UtilityLocale;
import com.nepxion.util.net.http.apache.ClientInvoker;
import com.nepxion.util.net.http.apache.ClientParameterList;
import com.nepxion.util.net.http.apache.ClientRequestGet;
import com.nepxion.util.xml.dom4j.Dom4JReader;

public class NeteaseIDSearcher
	implements NeteaseIDConstants
{
	/**
	 * The chaset string.
	 */
	private String charset = "GBK";
	
	/**
	 * The instance of ClientInvoker.
	 */
	private ClientInvoker clientInvoker;
	
	/**
	 * Constructs with the default.
	 * The charset is "GBK".
	 */
	public NeteaseIDSearcher()
	{
		this("GBK");
	}
	
	/**
	 * Constructs with the specified initial charset.
	 * @param charset the charset string
	 */
	public NeteaseIDSearcher(String charset)
	{
		this.charset = charset;
		
		this.clientInvoker = new ClientInvoker();
	}
	
	/**
	 * Searchs the id entity by an id.
	 * @param id the id string
	 * @return the instance of NeteaseIDEntity
	 * @throws Exception
	 */
	public NeteaseIDEntity search(String id)
		throws Exception
	{
		String xml = getXML(id);
		
		return createEntity(xml);
	}
	
	/**
	 * Creates the id entity by a xml.
	 * @param xml the xml string
	 * @return the instance of NeteaseIDEntity
	 */
	private NeteaseIDEntity createEntity(String xml)
	{
		if (xml == null || xml.equals(""))
		{
			return null;
		}
		
		Document document = null;
		try
		{
			document = Dom4JReader.getDocument(xml);
		}
		catch (DocumentException e)
		{
			e.printStackTrace();
		}
		Element rootElement = document.getRootElement();
		Element productElement = rootElement.element("product");
		
		NeteaseIDEntity idEntity = new NeteaseIDEntity();
		
		Element codeElement = productElement.element("code");
		idEntity.setCode(codeElement.getText());
		
		Element locationElement = productElement.element("location");
		idEntity.setLocation(locationElement.getText());
		
		Element birthdayElement = productElement.element("birthday");
		String birthday = birthdayElement.getText();
		birthday = birthday.substring(0, 4) + "-" + birthday.substring(4, 6) + "-" + birthday.substring(6);
		idEntity.setBirthday(birthday);
		
		Element genderElement = productElement.element("gender");
		String gender = genderElement.getText();
		if (gender.equals("m"))
		{
			gender = UtilityLocale.getString("male");
		}
		else if (gender.equals("f"))
		{
			gender = UtilityLocale.getString("femal");
		}
		else
		{
			gender = UtilityLocale.getString("unknown");
		}
		idEntity.setGender(gender);
		
		return idEntity;
	}
	
	/**
	 * Gets the xml by an id.
	 * @param id the id string
	 * @return the xml string
	 * @throws Exception
	 */
	public String getXML(String id)
		throws Exception
	{
		ClientRequestGet clientRequestGet = new ClientRequestGet();
		clientRequestGet.setURI(URI.create(URL));
		
		ClientParameterList clientParameterList = new ClientParameterList();
		clientParameterList.put("q", id);
		clientParameterList.put("type", TYPE);
		clientRequestGet.setParameterEntity(clientParameterList, charset);
		
		String responseText = clientInvoker.getResponseText(clientRequestGet, charset);
		
		return responseText;
	}
}