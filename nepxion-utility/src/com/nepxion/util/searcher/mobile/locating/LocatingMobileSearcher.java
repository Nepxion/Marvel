package com.nepxion.util.searcher.mobile.locating;

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
import com.nepxion.util.net.http.apache.ClientRequestPost;
import com.nepxion.util.xml.dom4j.Dom4JReader;

public class LocatingMobileSearcher
	implements LocatingMobileConstants
{
	/**
	 * The charset string.
	 */
	private String charset = "UTF-8";
	
	/**
	 * The instance of ClientInvoker.
	 */
	private ClientInvoker clientInvoker;
	
	/**
	 * Constructs with the default.
	 * The charset is "UTF-8".
	 */
	public LocatingMobileSearcher()
	{
		this("UTF-8");
	}
	
	/**
	 * Constructs with the specified initial charset.
	 * @param charset the charset string
	 */
	public LocatingMobileSearcher(String charset)
	{
		this.charset = charset;
		
		this.clientInvoker = new ClientInvoker();
	}
	
	/**
	 * Searchs the mobile entity by a mobile.
	 * @param mobile the mobile string
	 * @return the instance of LocatingMobileEntity
	 * @throws Exception
	 */
	public LocatingMobileEntity search(String mobile)
		throws Exception
	{
		String text = getXML(mobile);
		
		return createEntity(text);
	}
	
	/**
	 * Creates the mobile entity by a xml.
	 * @param xml the xml string
	 * @return the instance of LocatingMobileEntity
	 */
	private LocatingMobileEntity createEntity(String xml)
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
		
		LocatingMobileEntity moblieEntity = new LocatingMobileEntity();	
		
		Element mobileElement = rootElement.element("Mobile");
		moblieEntity.setMobile(mobileElement.getText());
		
		Element provinceElement = rootElement.element("Province");
		moblieEntity.setProvince(provinceElement.getText());
		
		Element cityElement = rootElement.element("City");
		moblieEntity.setCity(cityElement.getText());
		
		Element areaCodeElement = rootElement.element("AreaCode");
		moblieEntity.setAreaCode(areaCodeElement.getText());
		
		Element postCodeElement = rootElement.element("PostCode");
		moblieEntity.setPostCode(postCodeElement.getText());
		
		Element corpElement = rootElement.element("Corp");
		moblieEntity.setCorp(corpElement.getText());
		
		Element cardElement = rootElement.element("Card");
		moblieEntity.setCard(cardElement.getText());
		
		return moblieEntity;
	}
	
	/**
	 * Gets the xml by a mobile.
	 * @param mobile the mobile string
	 * @return the xml string
	 * @throws Exception
	 */
	public String getXML(String mobile)
		throws Exception
	{
		ClientRequestPost clientRequestPost = new ClientRequestPost();
		clientRequestPost.setURI(URI.create(URL));
		
		ClientParameterList clientParameterList = new ClientParameterList();
		clientParameterList.put("m", mobile);
		clientParameterList.put("output", "xml");
		clientRequestPost.setParameterEntity(clientParameterList, charset);
		
		String responseText = clientInvoker.getResponseText(clientRequestPost, charset);
		
		return responseText;
	}
}