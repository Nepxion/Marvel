package com.nepxion.swing.tree.xml;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tree.lazyloader.JLazyLoaderTreeNode;
import com.nepxion.util.xml.dom4j.Dom4JReader;

public class Dom4JLazyLoaderTreeParser
	extends Dom4JBasicTreeParser
{
	private String leafTag;
	
	public Dom4JLazyLoaderTreeParser()
	{
		this(DEFAULT_MODE_ICON);
	}
	
	public Dom4JLazyLoaderTreeParser(String iconExtensionName)
	{
		this(DEFAULT_MODE_ICON, iconExtensionName);
	}
	
	public Dom4JLazyLoaderTreeParser(int iconFolderMode)
	{
		this(iconFolderMode, null);
	}
	
	public Dom4JLazyLoaderTreeParser(int iconFolderMode, String iconExtensionName)
	{
		this(TAG_INDEX, TAG_NAME, TAG_TEXT, TAG_ICON, TAG_TOOL_TIP_TEXT, TAG_CLASS, TAG_LEAF, iconFolderMode, iconExtensionName);
	}
	
	public Dom4JLazyLoaderTreeParser(String indexTag, String nameTag, String textTag, String iconTag, String toolTipTextTag, String classTag, String leafTag, int iconFolderMode, String iconExtensionName)
	{
		super(indexTag, nameTag, textTag, iconTag, toolTipTextTag, classTag, iconFolderMode, iconExtensionName);
		
		this.leafTag = leafTag;
	}
	
	public void parse(String text, JLazyLoaderTreeNode lazyLoaderTreeNode)
		throws DocumentException
	{
		Document document = Dom4JReader.getDocument(text);
		parse(document, lazyLoaderTreeNode);
	}
	
	public void parseFormat(String text, JLazyLoaderTreeNode lazyLoaderTreeNode)
		throws DocumentException, UnsupportedEncodingException
	{
		Document document = Dom4JReader.getFormatDocument(text);
		parse(document, lazyLoaderTreeNode);
	}
	
	public void parse(File file, JLazyLoaderTreeNode lazyLoaderTreeNode)
		throws DocumentException, IOException, UnsupportedEncodingException
	{
		Document document = Dom4JReader.getDocument(file);
		parse(document, lazyLoaderTreeNode);
	}
	
	public void parseFormat(File file, JLazyLoaderTreeNode lazyLoaderTreeNode)
		throws DocumentException, IOException, UnsupportedEncodingException
	{
		Document document = Dom4JReader.getFormatDocument(file);
		parse(document, lazyLoaderTreeNode);
	}
	
	public void parse(InputStream inputStream, JLazyLoaderTreeNode lazyLoaderTreeNode)
		throws DocumentException, IOException
	{
		Document document = Dom4JReader.getDocument(inputStream);
		parse(document, lazyLoaderTreeNode);
	}
	
	public void parseFormat(InputStream inputStream, JLazyLoaderTreeNode lazyLoaderTreeNode)
		throws DocumentException, IOException, UnsupportedEncodingException
	{
		Document document = Dom4JReader.getFormatDocument(inputStream);
		parse(document, lazyLoaderTreeNode);
	}
	
	public void parse(Document document, JLazyLoaderTreeNode lazyLoaderTreeNode)
	{
		Element rootElement = document.getRootElement();
		parseElement(rootElement, lazyLoaderTreeNode);
	}
	
	public void parseElement(Element element, JLazyLoaderTreeNode lazyLoaderTreeNode)
	{
		for (Iterator elementIterator = element.elementIterator(); elementIterator.hasNext();)
		{
			Object childElementObject = elementIterator.next();
			if (childElementObject instanceof Element)
			{
				Element childElement = (Element) childElementObject;
				
				JLazyLoaderTreeNode childLazyLoaderTreeNode = new JLazyLoaderTreeNode();
				lazyLoaderTreeNode.add(childLazyLoaderTreeNode);
				
				parseAttribute(childElement, childLazyLoaderTreeNode);
			}
		}
	}
	
	public void parseAttribute(Element element, JLazyLoaderTreeNode lazyLoaderTreeNode)
	{
		HashMap userObject = null;
		
		for (Iterator attributeIterator = element.attributeIterator(); attributeIterator.hasNext();)
		{
			Attribute attribute = (Attribute) attributeIterator.next();
			String attributeName = attribute.getName().trim();
			String attributeText = attribute.getText().trim();
			
			if (attributeName.equals(indexTag))
			{
				lazyLoaderTreeNode.setIndex(Integer.parseInt(attributeText));
			}
			else if (attributeName.equals(textTag))
			{
				lazyLoaderTreeNode.setText(attributeText);
			}
			else if (attributeName.equals(iconTag))
			{
				String iconName = attributeText + (iconExtensionName != null ? iconExtensionName : "");
				switch (iconFolderMode)
				{
					case ICON_FOLDER_MODE_SWING :
						lazyLoaderTreeNode.setIcon(IconFactory.getSwingIcon(iconName));
						break;
					case ICON_FOLDER_MODE_CONTEXT :
						lazyLoaderTreeNode.setIcon(IconFactory.getContextIcon(iconName));
						break;
					case ICON_FOLDER_MODE_FULL :
						lazyLoaderTreeNode.setIcon(IconFactory.getIcon(iconName));
						break;
					default :
						lazyLoaderTreeNode.setIcon(IconFactory.getContextIcon(iconName));
						break;
				}
			}
			else if (attributeName.equals(toolTipTextTag))
			{
				lazyLoaderTreeNode.setToolTipText(attributeText);
			}
			else if (attributeName.equals(classTag))
			{
				if (userObject == null)
				{
					userObject = new HashMap();
					lazyLoaderTreeNode.setUserObject(userObject);
				}
				Object instance = null;
				try
				{
					instance = Class.forName(attributeText).newInstance();
				}
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}
				catch (IllegalAccessException e)
				{
					e.printStackTrace();
				}
				catch (InstantiationException e)
				{
					e.printStackTrace();
				}
				userObject.put(classTag, instance);
			}
			else if (attributeName.equals(leafTag))
			{
				boolean isLeaf = Boolean.valueOf(attributeText);
				lazyLoaderTreeNode.setLoaded(isLeaf);
				lazyLoaderTreeNode.setLeaf(isLeaf);
			}
			else
			{
				if (userObject == null)
				{
					userObject = new HashMap();
					lazyLoaderTreeNode.setUserObject(userObject);
				}
				userObject.put(attributeName, attributeText);
			}
		}
	}
}