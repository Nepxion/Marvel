package com.nepxion.cots.twaver.gis;

/**
 * <p>Title: Nepxion Cots For TWaver</p>
 * <p>Description: Nepxion Cots Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * <p>Announcement: It depends on the commercial software of TWaver, the repository only references the trial version.</p>
 * <p>If you want to use Nepxion Cots, please contact with Serva Corporation to buy the genuine version.</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import twaver.gis.TWaverGisConst;

import com.nepxion.cots.twaver.element.TType;
import com.nepxion.cots.twaver.locale.TLocale;

public class TMapType
	extends TType
{
	public static final TMapType GOOGLE_MAP_TYPE = new TMapType(TLocale.getString("graph_google_map"), TWaverGisConst.EXECUTOR_TYPE_GOOGLEMAP);
	public static final TMapType GOOGLE_SATELLITE_MAP_TYPE = new TMapType(TLocale.getString("graph_google_satellite_map"), TWaverGisConst.EXECUTOR_TYPE_GOOGLESATELLITEMAP);
	public static final TMapType GOOGLE_TERRAIN_MAP_TYPE = new TMapType(TLocale.getString("graph_google_terrain_map"), TWaverGisConst.EXECUTOR_TYPE_GOOGLETERRAINMAP);
	public static final TMapType GOOGLE_LABEL_MAP_TYPE = new TMapType(TLocale.getString("graph_google_label_map"), TWaverGisConst.EXECUTOR_TYPE_GOOGLELABELMAP);
	public static final TMapType MICROSOFT_BINT_MAP_TYPE = new TMapType(TLocale.getString("graph_microsoft_map"), TWaverGisConst.EXECUTOR_TYPE_BINGMAP);
	public static final TMapType OPENSTREET_MAP_TYPE = new TMapType(TLocale.getString("graph_openstreet_map"), TWaverGisConst.EXECUTOR_TYPE_OPENSTREET);
	public static final TMapType ARCGIS_OGC_MAP_TYPE = new TMapType(TLocale.getString("graph_arcgis_map"), TWaverGisConst.EXECUTOR_TYPE_ARCGIS_OGC);
	public static final TMapType ARCGIS_NOTILES_MAP_TYPE = new TMapType(TLocale.getString("graph_arcgis_notiles_map"), TWaverGisConst.EXECUTOR_TYPE_ARCGIS_NOTILES);
	public static final TMapType MAPINFO_OGC_MAP_TYPE = new TMapType(TLocale.getString("graph_mapinfo_map"), TWaverGisConst.EXECUTOR_TYPE_MAPINFO_OGC);
	public static final TMapType MAPINFO_NOTILES_MAP_TYPE = new TMapType(TLocale.getString("graph_mapinfo_notiles_map"), TWaverGisConst.EXECUTOR_TYPE_MAPINFO_NOTILES);
	public static final TMapType MAPABC_MAP_TYPE = new TMapType(TLocale.getString("graph_mapabc_map"), TWaverGisConst.EXECUTOR_TYPE_MAPABC);
	public static final TMapType TIANDITU_MAP_TYPE = new TMapType(TLocale.getString("graph_tianditu_map"), TWaverGisConst.EXECUTOR_TYPE_TIANDITUMAP);
	public static final TMapType GEOSERVER_MAP_TYPE = new TMapType(TLocale.getString("graph_geoserver_map"), TWaverGisConst.EXECUTOR_TYPE_GEOSERVER);
	public static final TMapType GEOSERVER_NOTILES_MAP_TYPE = new TMapType(TLocale.getString("graph_geoserver_notiles_map"), TWaverGisConst.EXECUTOR_TYPE_GEOSERVER_NOTILES);
	public static final TMapType GEOSERVER_CACHE_MAP_TYPE = new TMapType(TLocale.getString("graph_geoserver_cache_map"), TWaverGisConst.EXECUTOR_TYPE_GEOSERVER_CACHE);
	
	private int type;
	
	private TMapType(String name, int type)
	{
		super(name);
		
		this.type = type;
	}
	
	public int getType()
	{
		return type;
	}
}