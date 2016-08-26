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

import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.util.xml.dom4j.Dom4JReader;

public class Dom4JTreeParser
	extends Dom4JBasicTreeParser
{
	public Dom4JTreeParser()
	{
		super();
	}
	
	public Dom4JTreeParser(String iconExtensionName)
	{
		super(iconExtensionName);
	}
	
	public Dom4JTreeParser(int iconFolderMode)
	{
		super(iconFolderMode);
	}
	
	public Dom4JTreeParser(int iconFolderMode, String iconExtensionName)
	{
		super(iconFolderMode, iconExtensionName);
	}
	
	public Dom4JTreeParser(String indexTag, String nameTag, String textTag, String iconTag, String toolTipTextTag, String classTag, int iconFolderMode, String iconExtensionName)
	{
		super(indexTag, nameTag, textTag, iconTag, toolTipTextTag, classTag, iconFolderMode, iconExtensionName);
	}
	
	public ElementNode parse(String text)
		throws DocumentException
	{
		Document document = Dom4JReader.getDocument(text);
		
		return parse(document);
	}
	
	public ElementNode parseFormat(String text)
		throws DocumentException, UnsupportedEncodingException
	{
		Document document = Dom4JReader.getFormatDocument(text);
		
		return parse(document);
	}
	
	public ElementNode parse(File file)
		throws DocumentException, IOException
	{
		Document document = Dom4JReader.getDocument(file);
		
		return parse(document);
	}
	
	public ElementNode parseFormat(File file)
		throws DocumentException, IOException, UnsupportedEncodingException
	{
		Document document = Dom4JReader.getFormatDocument(file);
		
		return parse(document);
	}
	
	public ElementNode parse(InputStream inputStream)
		throws DocumentException, IOException
	{
		Document document = Dom4JReader.getDocument(inputStream);
		
		return parse(document);
	}
	
	public ElementNode parseFormat(InputStream inputStream)
		throws DocumentException, IOException, UnsupportedEncodingException
	{
		Document document = Dom4JReader.getFormatDocument(inputStream);
		
		return parse(document);
	}
	
	public ElementNode parse(Document document)
	{
		Element rootElement = document.getRootElement();
		ElementNode rootTreeNode = new ElementNode();
		
		parseAttribute(rootElement, rootTreeNode);
		parseElement(rootElement, rootTreeNode);
		
		return rootTreeNode;
	}
	
	public void parseElement(Element element, ElementNode treeNode)
	{
		for (Iterator elementIterator = element.elementIterator(); elementIterator.hasNext();)
		{
			Object childElementObject = elementIterator.next();
			if (childElementObject instanceof Element)
			{
				Element childElement = (Element) childElementObject;
				
				ElementNode childTreeNode = new ElementNode();
				treeNode.add(childTreeNode);
				
				parseAttribute(childElement, childTreeNode);
				parseElement(childElement, childTreeNode);
			}
		}
	}
	
	public void parseAttribute(Element element, ElementNode treeNode)
	{
		HashMap userObject = null;
		
		for (Iterator attributeIterator = element.attributeIterator(); attributeIterator.hasNext();)
		{
			Attribute attribute = (Attribute) attributeIterator.next();
			String attributeName = attribute.getName().trim();
			String attributeText = attribute.getText().trim();
			
			if (attributeName.equals(indexTag))
			{
				treeNode.setIndex(Integer.parseInt(attributeText));
			}
			else if (attributeName.equals(nameTag))
			{
				treeNode.setName(attributeText);
			}
			else if (attributeName.equals(textTag))
			{
				treeNode.setText(attributeText);
			}
			else if (attributeName.equals(iconTag))
			{
				String iconName = attributeText + (iconExtensionName != null ? iconExtensionName : "");
				switch (iconFolderMode)
				{
					case ICON_FOLDER_MODE_SWING :
						treeNode.setIcon(IconFactory.getSwingIcon(iconName));
						break;
					case ICON_FOLDER_MODE_CONTEXT :
						treeNode.setIcon(IconFactory.getContextIcon(iconName));
						break;
					case ICON_FOLDER_MODE_FULL :
						treeNode.setIcon(IconFactory.getIcon(iconName));
						break;
					default :
						treeNode.setIcon(IconFactory.getContextIcon(iconName));
						break;
				}
			}
			else if (attributeName.equals(toolTipTextTag))
			{
				treeNode.setToolTipText(attributeText);
			}
			else if (attributeName.equals(classTag))
			{
				if (userObject == null)
				{
					userObject = new HashMap();
					treeNode.setUserObject(userObject);
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
			else
			{
				if (userObject == null)
				{
					userObject = new HashMap();
					treeNode.setUserObject(userObject);
				}
				userObject.put(attributeName, attributeText);
			}
			if (treeNode.getText() == null && treeNode.getName() != null)
			{
				treeNode.setText(treeNode.getName());
			}
			if (treeNode.getToolTipText() == null && treeNode.getName() != null)
			{
				treeNode.setToolTipText(treeNode.getName());
			}
		}
	}
}