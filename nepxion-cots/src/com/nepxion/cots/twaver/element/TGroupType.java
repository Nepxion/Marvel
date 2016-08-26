package com.nepxion.cots.twaver.element;

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

import com.nepxion.cots.twaver.locale.TLocale;

import twaver.TWaverConst;

public class TGroupType
	extends TType
{
	public static final TGroupType RECTANGLE_GROUP_TYPE = new TGroupType(TLocale.getString("group_type_rectangle"), TWaverConst.GROUP_TYPE_RECTANGLE);
	public static final TGroupType ROUND_RECTANGLE_GROUP_TYPE = new TGroupType(TLocale.getString("group_type_round_rectangle"), TWaverConst.GROUP_TYPE_ROUND_RECTANGLE);
	public static final TGroupType ROUND_GROUP_TYPE = new TGroupType(TLocale.getString("group_type_round"), TWaverConst.GROUP_TYPE_ROUND);
	public static final TGroupType OCTAGON_GROUP_TYPE = new TGroupType(TLocale.getString("group_type_octagon"), TWaverConst.GROUP_TYPE_OCTAGON);
	public static final TGroupType PARALLELOGRAM_GROUP_TYPE = new TGroupType(TLocale.getString("group_type_parallelogram"), TWaverConst.GROUP_TYPE_PARALLELOGRAM);
	public static final TGroupType ELLIPSE_GROUP_TYPE = new TGroupType(TLocale.getString("group_type_ellipse"), TWaverConst.GROUP_TYPE_ELLIPSE);
	
	private int type;
	
	private TGroupType(String name, int type)
	{
		super(name);
		
		this.type = type;
	}
	
	public int getType()
	{
		return type;
	}
}