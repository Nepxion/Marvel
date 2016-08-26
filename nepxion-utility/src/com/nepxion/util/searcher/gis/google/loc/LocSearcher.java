package com.nepxion.util.searcher.gis.google.loc;

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

import org.json.JSONException;
import org.json.JSONObject;

import com.nepxion.util.locale.LocaleConstants;
import com.nepxion.util.net.http.apache.ClientInvoker;
import com.nepxion.util.net.http.apache.ClientRequestPost;

public class LocSearcher
	implements LocConstants, LocaleConstants
{	
	/**
	 * The language string.
	 */
	private String language = ZH_CN;
	
	/**
	 * The charset string.
	 */
	private String charset = "UTF-8";
	
	/**
	 * The boolean value of requestAddress.
	 */
	private boolean requestAddress = true;
	
	/**
	 * The instance of ClientInvoker.
	 */
	private ClientInvoker clientInvoker;
	
	/**
	 * Constructs with the default.
	 */
	public LocSearcher()
	{
		this(true);
	}
	
	/**
	 * Constructs with the specified initial requestAddress.
	 * The language is ZH_CN.
	 * @param requestAddress boolean value of requestAddress 
	 */
	public LocSearcher(boolean requestAddress)
	{
		this(ZH_CN, requestAddress);
	}
	
	/**
	 * Constructs with the specified initial language.
	 * The requestAddress is true.
	 * @param language the language string
	 */
	public LocSearcher(String language)
	{
		this(language, true);
	}
	
	/**
	 * Constructs with the specified initial language and requestAddress.
	 * The charset is "UTF-8".
	 * @param language the language string 
	 * @param requestAddress the boolean value of requestAddress
	 */
	public LocSearcher(String language, boolean requestAddress)
	{
		this(language, "UTF-8", requestAddress);
	}
	
	/**
	 * Constructs with the specified initial language and charset.
	 * The requestAddress is true.
	 * @param language the language string
	 * @param charset the charset string
	 */
	public LocSearcher(String language, String charset)
	{
		this(language, charset, true);
	}
	
	/**
	 * Constructs with the specified initial language, charset and requestAddress.
	 * @param language the language string
	 * @param charset the charset string
	 * @param requestAddress the boolean value of requestAddress
	 */
	public LocSearcher(String language, String charset, boolean requestAddress)
	{
		this.language = language;
		this.charset = charset;
		this.requestAddress = requestAddress;
		
		this.clientInvoker = new ClientInvoker();
	}
	
	/**
	 * Searchs the loc entity by a latitude and longitude.
	 * @param latitude the latitude value
	 * @param longitude the longitude value
	 * @return the instance of LocEntity
	 * @throws Exception
	 */
	public LocEntity search(double latitude, double longitude)
		throws Exception
	{
		String requestJSON = createCoordinateJSON(latitude, longitude);
		String responseJSON = getJSON(requestJSON);
		
		return createEntity(responseJSON);
	}
	
	/**
	 * Searchs the loc entity by a cell id, lac, mcc and mnc.
	 * @param cellID the cell id value
	 * @param lac the lac value
	 * @param mcc the mcc value
	 * @param mnc the mnc value
	 * @return the instance of LocEntity
	 * @throws Exception
	 */
	public LocEntity search(int cellID, int lac, int mcc, int mnc)
		throws Exception
	{
		String requestJSON = createCellJSON(cellID, lac, mcc, mnc);
		String responseJSON = getJSON(requestJSON);
		
		return createEntity(responseJSON);
	}
	
	/**
	 * Creates the coordinate json string by a latitude and longitude.
	 * @param latitude the latitude value
	 * @param longitude the longitude value
	 * @return the coordinate json string 
	 */
	public String createCoordinateJSON(double latitude, double longitude)
	{
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("{\n");
		stringBuffer.append("  \"version\": \"1.1.0\",\n");
		stringBuffer.append("  \"host\": \"maps.google.com\",\n");
		
		stringBuffer.append("  \"request_address\": " + requestAddress + ",\n");
		stringBuffer.append("  \"address_language\": \"" + language + "\",\n");
		
		stringBuffer.append("  \"location\": \n");
		stringBuffer.append("  {\n");
		stringBuffer.append("    \"latitude\": " + latitude + ",\n");
		stringBuffer.append("    \"longitude\": " + longitude + "\n");
		stringBuffer.append("  }\n");
		stringBuffer.append("}");
		
		return stringBuffer.toString();
	}
	
	/**
	 * Creates the cell json string by a cell id, lac, mcc and mnc.
	 * @param cellID the cell id value - 全球唯一的小区ID
	 * @param lac the lac value - 全球唯一的位置码
	 * @param mcc the mcc value - 移动国家号码，中国为460
	 * @param mnc the mnc value - 移动网号，中国移动为00，中国中国联通为01
	 * @return the cell json string
	 */
	public String createCellJSON(int cellID, int lac, int mcc, int mnc)
	{
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("{\n");
		stringBuffer.append("  \"version\": \"1.1.0\",\n");
		stringBuffer.append("  \"host\": \"maps.google.com\",\n");
		
		stringBuffer.append("  \"request_address\": " + requestAddress + ",\n");
		stringBuffer.append("  \"address_language\": \"" + language + "\",\n");
		
		stringBuffer.append("  \"cell_towers\": \n");
		stringBuffer.append("  [\n");
		stringBuffer.append("    {\n");
		stringBuffer.append("      \"cell_id\": " + cellID + ",\n");
		stringBuffer.append("      \"location_area_code\": " + lac + ",\n");
		stringBuffer.append("      \"mobile_country_code\": " + mcc + ",\n");
		stringBuffer.append("      \"mobile_network_code\": " + mnc + "\n");
		stringBuffer.append("    }\n");
		stringBuffer.append("  ]\n");
		stringBuffer.append("}");
		
		return stringBuffer.toString();
	}
	
	/**
	 * Creates the loc entity by a request json.
	 * @param requestJSON the request json string
	 * @return the instance of LocEntity
	 */
	private LocEntity createEntity(String requestJSON)
	{
		if (requestJSON == null || requestJSON.equals("") || requestJSON.equals("{}"))
		{
			return null;
		}
		
		LocEntity locEntity = new LocEntity();
		try
		{
			JSONObject jsonObject = new JSONObject(requestJSON);
			
			String accessToken = jsonObject.getString("access_token");
			locEntity.setAccessToken(accessToken);
			
			JSONObject locationJSONObject = (JSONObject) jsonObject.get("location");
			
			double latitude = locationJSONObject.getDouble("latitude");
			locEntity.setLatitude(latitude);
			
			double longitude = locationJSONObject.getDouble("longitude");
			locEntity.setLongitude(longitude);
			
			Object addressObject = locationJSONObject.get("address");
			if (addressObject != null)
			{
				JSONObject addressJSONObject = (JSONObject) addressObject;
				
				String country = addressJSONObject.getString("country");
				locEntity.setCountry(country);
				
				String countryCode = addressJSONObject.getString("country_code");
				locEntity.setCountryCode(countryCode);
				
				String region = addressJSONObject.getString("region");
				locEntity.setRegion(region);
				
				String city = addressJSONObject.getString("city");
				locEntity.setCity(city);
				
				String street = addressJSONObject.getString("street");
				locEntity.setStreet(street);
				
				String streetNumber = addressJSONObject.getString("street_number");
				locEntity.setStreetNumber(streetNumber);
				
				String postalCode = addressJSONObject.getString("postal_code");
				locEntity.setPostalCode(postalCode);
				
				double accuracy = addressJSONObject.getDouble("accuracy");
				locEntity.setAccuracy(accuracy);
			}
		}
		catch (JSONException e)
		{
			
		}
		
		return locEntity;
	}
	
	/**
	 * Gets the json string by a request json.
	 * @param requestJSON the request json string
	 * @return the json string
	 * @throws Exception
	 */
	public String getJSON(String requestJSON)
		throws Exception
	{
		ClientRequestPost clientRequestPost = new ClientRequestPost();
		clientRequestPost.setURI(URI.create(URL));
		clientRequestPost.setStringEntity(requestJSON);
		
		String responseText = clientInvoker.getResponseText(clientRequestPost, charset);
		
		return responseText;
	}
}