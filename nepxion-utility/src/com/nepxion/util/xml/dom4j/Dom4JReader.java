package com.nepxion.util.xml.dom4j;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import com.nepxion.util.encoder.EncoderContext;
import com.nepxion.util.encoder.EncoderUtil;

public class Dom4JReader
{
	/**
	 * Gets the document by a xml.
	 * @param text the xml string string
	 * @return the instance of Document
	 * @throws DocumentException
	 */
	public static Document getDocument(String text)
		throws DocumentException
	{
		return DocumentHelper.parseText(text);
	}
		
	/**
	 * Gets the document by a xml and charset.
	 * The charset is registered in EncoderContext.
	 * @param text the xml string string
	 * @return the instance of Document
	 * @throws DocumentException
	 * @throws UnsupportedEncodingException
	 */
	public static Document getFormatDocument(String text) 
		throws DocumentException, UnsupportedEncodingException
	{
		return getFormatDocument(text, EncoderContext.getIOCharset());
	}
	
	/**
	 * Gets the document by a xml and charset.
	 * @param text the xml string string
	 * @param charset the charset string
	 * @return the instance of Document
	 * @throws DocumentException
	 * @throws UnsupportedEncodingException
	 */
	public static Document getFormatDocument(String text, String charset) 
		throws DocumentException, UnsupportedEncodingException
	{
		String formatText = EncoderUtil.format(text, charset);
		
		return getDocument(formatText);
	}
	
	/**
	 * Gets the document by a file.
	 * @param file the instance of File
	 * @return the instance of Document
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Document getDocument(File file)
		throws DocumentException, IOException
	{
		InputStream inputStream = new FileInputStream(file);
		
		return getDocument(inputStream);
	}
	
	/**
	 * Gets the document by a file.
	 * The charset is registered in EncoderContext.
	 * @param file the instance of File
	 * @return the instance of Document
	 * @throws DocumentException
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	public static Document getFormatDocument(File file)
		throws DocumentException, IOException, UnsupportedEncodingException
	{
		return getFormatDocument(file, EncoderContext.getIOCharset());
	}
	
	/**
	 * Gets the document by a file and charset.
	 * @param file the instance of File
	 * @param charset the charset string
	 * @return the instance of Document
	 * @throws DocumentException
	 * @throws IOException
	 * @throws UnsupportedEncodingException 
	 */
	public static Document getFormatDocument(File file, String charset)
		throws DocumentException, IOException, UnsupportedEncodingException
	{
		InputStream inputStream = new FileInputStream(file);
		
		return getFormatDocument(inputStream, charset);
	}
	
	/**
	 * Gets the document by an inputSource.
	 * @param inputSource the instance of InputSource
	 * @return the instance of Document
	 * @throws DocumentException
	 */
	public static Document getDocument(InputSource inputSource)
		throws DocumentException
	{
		SAXReader saxReader = new SAXReader();
		
		return saxReader.read(inputSource);
	}
	
	/**
	 * Gets the document by an inputSource.
	 * The charset is registered in EncoderContext.
	 * @param inputSource the instance of InputSource
	 * @return the instance of Document
	 * @throws DocumentException
	 */
	public static Document getFormatDocument(InputSource inputSource)
		throws DocumentException
	{
		return getFormatDocument(inputSource, EncoderContext.getIOCharset());
	}
	
	/**
	 * Gets the document by an inputSource and charset.
	 * @param inputSource the instance of InputSource
	 * @param charset the charset string
	 * @return the instance of Document
	 * @throws DocumentException
	 */
	public static Document getFormatDocument(InputSource inputSource, String charset)
		throws DocumentException
	{
		inputSource.setEncoding(charset);
		
		return getDocument(inputSource);
	}
	
	/**
	 * Gets the document by an inputStream.
	 * @param inputStream the instance of InputStream
	 * @return the instance of Document
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Document getDocument(InputStream inputStream)
		throws DocumentException, IOException
	{
		SAXReader saxReader = new SAXReader();
		
		Document document = null;
		try
		{
			document = saxReader.read(inputStream);
		}
		catch (DocumentException e)
		{
			throw e;
		}
		finally
		{
			if (inputStream != null)
			{
				inputStream.close();
			}	
		}
		
		return document;
	}
	
	/**
	 * Gets the document by an inputStream.
	 * The charset is registered in EncoderContext.
	 * @param inputStream the instance of InputStream
	 * @return the instance of Document
	 * @throws DocumentException
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	public static Document getFormatDocument(InputStream inputStream)
		throws DocumentException, IOException, UnsupportedEncodingException
	{
		return getFormatDocument(inputStream, EncoderContext.getIOCharset());
	}
	
	/**
	 * Gets the document by an inputStream and charset.
	 * @param inputStream the instance of InputStream
	 * @param charset the charset string
	 * @return the instance of Document
	 * @throws DocumentException
	 * @throws IOException
	 * @throws UnsupportedEncodingException 
	 */
	public static Document getFormatDocument(InputStream inputStream, String charset)
		throws DocumentException, IOException, UnsupportedEncodingException
	{
		Reader inputStreamReader = new InputStreamReader(inputStream, charset);
		
		return getDocument(inputStreamReader);
	}
	
	/**
	 * Gets the document by a reader.
	 * @param reader the instance of Reader
	 * @return the instance of Document
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Document getDocument(Reader reader)
		throws DocumentException, IOException
	{
		SAXReader saxReader = new SAXReader();
	
		Document document = null;
		try
		{
			document = saxReader.read(reader);
		}
		catch (DocumentException e)
		{
			throw e;
		}
		finally
		{
			if (reader != null)
			{
				reader.close();
			}	
		}
		
		return document;
	}
	
	/**
	 * Gets the document by an url.
	 * @param url the instance of URL
	 * @return the instance of Document
	 * @throws DocumentException
	 */
	public static Document getDocument(URL url)
		throws DocumentException
	{
		SAXReader saxReader = new SAXReader();
		
		return saxReader.read(url);
	}
}