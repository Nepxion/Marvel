package com.nepxion.util.searcher.ip.netease;

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

import com.nepxion.util.net.http.apache.ClientInvoker;
import com.nepxion.util.net.http.apache.ClientParameterList;
import com.nepxion.util.net.http.apache.ClientRequestGet;
import com.nepxion.util.xml.dom4j.Dom4JReader;

public class NeteaseIPSearcher
	implements NeteaseIPConstants
{
	/**
	 * The charset string.
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
	public NeteaseIPSearcher()
	{
		this("GBK");
	}
	
	/**
	 * Constructs with the specified initial charset.
	 * @param charset the charset string
	 */
	public NeteaseIPSearcher(String charset)
	{
		this.charset = charset;
		
		this.clientInvoker = new ClientInvoker();
	}
	
	/**
	 * Searchs the ip entity by an ip.
	 * @param ip the ip string
	 * @return the instance of NeteaseIPEntity
	 * @throws Exception
	 */
	public NeteaseIPEntity search(String ip)
		throws Exception
	{
		String xml = getXML(ip);
		
		return createEntity(xml);
	}
	
	/**
	 * Creates the ip entity by a xml.
	 * @param xml the xml string
	 * @return the instance of NeteaseIPEntity
	 */
	private NeteaseIPEntity createEntity(String xml)
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
		
		NeteaseIPEntity ipEntity = new NeteaseIPEntity();
		
		Element ipElement = productElement.element("ip");
		ipEntity.setIP(ipElement.getText());
		
		Element locationElement = productElement.element("location");
		String location = locationElement.getText();
		String country = "";
		String region = "";
		int index = location.indexOf(" ");
		if (index > -1)
		{
			country = location.substring(0, index);
			region = location.substring(index + 1).equals("") ? location : location.substring(index + 1);
		}
		else
		{
			country = "";
			region = location;
		}
		ipEntity.setCountry(country);
		ipEntity.setRegion(region);
		
		return ipEntity;
	}
	
	/**
	 * Gets the xml by an ip.
	 * @param ip the ip string
	 * @return the xml string
	 * @throws Exception
	 */
	public String getXML(String ip)
		throws Exception
	{
		ClientRequestGet clientRequestGet = new ClientRequestGet();
		clientRequestGet.setURI(URI.create(URL));
		
		ClientParameterList clientParameterList = new ClientParameterList();
		clientParameterList.put("q", ip);
		clientParameterList.put("type", TYPE);
		clientRequestGet.setParameterEntity(clientParameterList, charset);
		
		String responseText = clientInvoker.getResponseText(clientRequestGet, charset);
		
		return responseText;
	}
}