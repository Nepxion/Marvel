package com.nepxion.util.net.http.apache;

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
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentProducer;
import org.apache.http.entity.EntityTemplate;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.SerializableEntity;
import org.apache.http.entity.StringEntity;

import com.nepxion.util.encoder.EncoderContext;
import com.nepxion.util.net.http.HttpConfig;
import com.nepxion.util.net.http.IClientRequest;

public class ClientRequestPost
	extends HttpPost implements IClientRequest
{
	/**
	 * The instance of HttpConfig.
	 */
	private HttpConfig httpConfig;
	
	/**
	 * Constructs with the default.
	 */
	public ClientRequestPost()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial http config.
	 * @param httpConfig the instance of HttpConfig
	 */	
	public ClientRequestPost(HttpConfig httpConfig)
	{
		super(httpConfig.toURI());
		
		this.httpConfig = httpConfig;
	}
	
	/**
	 * Gets the http config.
	 * @return the instance of HttpConfig
	 */
	public HttpConfig getHttpConfig()
	{
		return httpConfig;
	}

	/**
	 * Sets the http config.
	 * @param httpConfig the instance of HttpConfig
	 */
	public void setHttpConfig(HttpConfig httpConfig)
	{
		this.httpConfig = httpConfig;
		
		setURI(httpConfig.toURI());
	}
	
	/**
	 * Gets the url parameter.
	 * @return the url parameter string
	 */
	public String getURLParameter()
	{
		return "";
	}	
	
	/**
	 * Sets the parameter entity.
	 * The charset is registered in EncoderContext.
	 * @param parameterEntity the parameter entity
	 * @return the instance of UrlEncodedFormEntity
	 */
	public UrlEncodedFormEntity setParameterEntity(List parameterEntity)
	{
		return setParameterEntity(parameterEntity, EncoderContext.getHttpCharset());
	}
	
	/**
	 * Sets the parameter entity by a charset.
	 * @param parameterEntity the parameter entity
	 * @param charset the charset string
	 * @return the instance of UrlEncodedFormEntity
	 */
	public UrlEncodedFormEntity setParameterEntity(List parameterEntity, String charset)
	{		
		ClientLogger.requestInfo(POST, charset, "List - [URL Parameter]", parameterEntity);
		
		UrlEncodedFormEntity entity = null;
		try
		{
			entity = new UrlEncodedFormEntity(parameterEntity, charset);			
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		entity.setChunked(true);
		setEntity(entity);
		
		return entity;
	}
		
	/**
	 * Sets the serializable entity.
	 * @param serializable the serializable object
	 * @param bufferize the boolean value
	 * @return the instance of SerializableEntity
	 */
	public SerializableEntity setSerializableEntity(Serializable serializable, boolean bufferize)
	{		
		ClientLogger.requestInfo(POST, "Serializable Entity", serializable);
		
		SerializableEntity entity = null;
		try
		{
			entity = new SerializableEntity(serializable, bufferize);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		entity.setChunked(true);
		setEntity(entity);
		
		return entity;
	}
	
	/**
	 * Sets the inputStream entity.
	 * @param inputStream the instance of InputStream
	 * @return the instance of InputStreamEntity
	 */
	public InputStreamEntity setInputStreamEntity(InputStream inputStream)
	{
		return setInputStreamEntity(inputStream, -1);
	}
	
	/**
	 * Sets the inputStream entity.
	 * @param inputStream the instance of InputStream
	 * @param length the length
	 * @return the instance of InputStreamEntity
	 */
	public InputStreamEntity setInputStreamEntity(InputStream inputStream, long length)
	{		
		ClientLogger.requestInfo(POST, "InputStream Entity", inputStream);
		
		InputStreamEntity entity = new InputStreamEntity(inputStream, length);
		entity.setContentType("binary/octet-stream");
		entity.setChunked(true);
		setEntity(entity);
		
		return entity;
	}
	
	/**
	 * Sets the string entity.
	 * The charset is registered in EncoderContext.
	 * @param text the text string
	 * @return the instance of StringEntity
	 */
	public StringEntity setStringEntity(String text)
	{
		return setStringEntity(text, EncoderContext.getHttpCharset());
	}
	
	/**
	 * Sets the string entity by a chartset.
	 * @param text the text string
	 * @param charset the charset string
	 * @return the instance of StringEntity
	 */
	public StringEntity setStringEntity(String text, String charset)
	{		
		ClientLogger.requestInfo(POST, charset, "String - [Text, XML, JSON, Properties ...]", text);
		
		StringEntity entity = null;
		try
		{
			entity = new StringEntity(text, charset);
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		entity.setChunked(true);
		setEntity(entity);
		
		return entity;
	}
	
	/**
	 * Sets the file entity.
	 * @param file the instance of File
	 * @return the instance of FileEntity
	 */
	public FileEntity setFileEntity(File file)
	{		
		ClientLogger.requestInfo(POST, "File Entity", file);
		
		FileEntity entity = new FileEntity(file, "binary/octet-stream");
		entity.setChunked(true);
		setEntity(entity);
		
		return entity;
	}
	
	/**
	 * Sets the file entity by a content type.
	 * @param file the instance of File
	 * @param contentType the content type string
	 * @return the instance of FileEntity
	 */
	public FileEntity setFileEntity(File file, String contentType)
	{		
		ClientLogger.requestInfo(POST, "File Entity", file);
		
		FileEntity entity = new FileEntity(file, contentType);
		entity.setChunked(true);
		setEntity(entity);
		
		return entity;
	}	
	
	/**
	 * Sets the buffered entity.
	 * @param httpEntity the instance of HttpEntity
	 * @return the instance of HttpEntity
	 */
	public BufferedHttpEntity setBufferedEntity(HttpEntity httpEntity)
	{		
		ClientLogger.requestInfo(POST, "Buffered Entity", httpEntity);
		
		BufferedHttpEntity entity = null;
		try
		{
			entity = new BufferedHttpEntity(httpEntity);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		setEntity(entity);
		
		return entity;
	}
	
	/**
	 * Sets the byte array entity.
	 * @param bytes the byte array
	 * @return the instance of ByteArrayEntity
	 */
	public ByteArrayEntity setByteArrayEntity(byte[] bytes)
	{		
		ClientLogger.requestInfo(POST, "ByteArray Entity", bytes);
		
		ByteArrayEntity entity = new ByteArrayEntity(bytes);
		entity.setChunked(true);
		setEntity(entity);
		
		return entity;
	}
	
	/**
	 * Sets the entity template.
	 * @param contentProducer the instance of ContentProducer
	 * @return the instance of EntityTemplate
	 */
	public EntityTemplate setEntityTemplate(ContentProducer contentProducer)
	{
		EntityTemplate entityTemplate = new EntityTemplate(contentProducer);
		
		return entityTemplate;
	}
}