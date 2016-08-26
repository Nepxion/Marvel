package com.nepxion.demo.test.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;

import com.nepxion.util.io.FileUtil;
import com.nepxion.util.searcher.gis.google.loc.LocConstants;
import com.nepxion.util.searcher.gis.google.loc.LocEntity;
import com.nepxion.util.searcher.gis.google.loc.LocSearcher;
import com.nepxion.util.xml.dom4j.Dom4JReader;

public class XMLDemo
{
	public static void main(String[] args)
	{
		LocSearcher locSearcher = new LocSearcher();
	
		Document document = null;
		try
		{
			document = Dom4JReader.getDocument(new File("D:/laccell-top100-night.xml"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		StringBuffer stringBuffer = new StringBuffer();
		Element rootElement = document.getRootElement();
		
		for (Iterator elementIterator = rootElement.elementIterator(); elementIterator.hasNext();)
		{
			Object childElementObject = elementIterator.next();			
			if (childElementObject instanceof Element)
			{
				Element childElement = (Element) childElementObject;				
				
				int cell = 0;
				int lac = 0;
				
				for (Iterator attributeIterator = childElement.attributeIterator(); attributeIterator.hasNext();)
				{
					Attribute attribute = (Attribute) attributeIterator.next();						
					String attributeName = attribute.getName().trim();
					String attributeText = attribute.getText().trim();	
					
					if (attributeName.equals("cell"))
					{
						cell = Integer.parseInt(attributeText);
					}					
					else if (attributeName.equals("lac"))
					{
						lac = Integer.parseInt(attributeText);
					}				
				}	
				
				LocEntity loc = null;
				try
				{
					loc = locSearcher.search(cell, lac, LocConstants.DEFAULT_MCC, LocConstants.DEFAULT_MNC);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
//				System.out.println("latitude : " + locEntity.getLatitude());
//				System.out.println("longitude : " + locEntity.getLongitude());
//				System.out.println("address : " + locEntity);
				
				if (loc != null)
				{	
					System.out.println("	<record lac=\"" + lac + "\" cell=\"" + cell + "\" latitude=\"" + loc.getLatitude() + "\" longitude=\"" + loc.getLongitude() + "\" address=\"" + loc + "\" />");
					stringBuffer.append("	<record lac=\"" + lac + "\" cell=\"" + cell + "\" latitude=\"" + loc.getLatitude() + "\" longitude=\"" + loc.getLongitude() + "\" address=\"" + loc + "\" />\n");
				}
			}
		}		
		
		try
		{
			FileUtil.writeString(stringBuffer.toString(), "D:/Cell_Renew.xml");
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}	
}