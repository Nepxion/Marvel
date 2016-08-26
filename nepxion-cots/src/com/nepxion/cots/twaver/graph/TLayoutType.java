package com.nepxion.cots.twaver.graph;

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

import twaver.TWaverConst;

import com.nepxion.cots.twaver.element.TType;
import com.nepxion.cots.twaver.locale.TLocale;

public class TLayoutType
	extends TType
{
	public static final TLayoutType SPRING_LAYOUT_TYPE = new TLayoutType(TLocale.getString("layout_type_spring"), 0);
	public static final TLayoutType CIRCULAR_LAYOUT_TYPE = new TLayoutType(TLocale.getString("layout_type_circular"), TWaverConst.LAYOUT_CIRCULAR);
	public static final TLayoutType HIERARCHIC_LAYOUT_TYPE = new TLayoutType(TLocale.getString("layout_type_hierarchic"), TWaverConst.LAYOUT_HIERARCHIC);
	public static final TLayoutType SYMMETRIC_LAYOUT_TYPE = new TLayoutType(TLocale.getString("layout_type_symmetric"), TWaverConst.LAYOUT_SYMMETRIC);
	public static final TLayoutType TREE_LAYOUT_TYPE = new TLayoutType(TLocale.getString("layout_type_tree"), TWaverConst.LAYOUT_TREE);
	public static final TLayoutType REVERSE_TREE_LAYOUT_TYPE = new TLayoutType(TLocale.getString("layout_type_reverse_tree"), TWaverConst.LAYOUT_REVERSETREE);
	public static final TLayoutType RANDOM_LAYOUT_TYPE = new TLayoutType(TLocale.getString("layout_type_random"), -1);
	
	public static final TLayoutType LITE_ORGANIC_LAYOUT_TYPE = new TLayoutType(TLocale.getString("layout_type_lite_organic"), 5);
	public static final TLayoutType LITE_SMART_ORGANIC_LAYOUT_TYPE = new TLayoutType(TLocale.getString("layout_type_lite_smart_organic"), 6);
	public static final TLayoutType LITE_HIERARCHIC_LAYOUT_TYPE = new TLayoutType(TLocale.getString("layout_type_lite_hierarchic"), 7);
	public static final TLayoutType LITE_ORTHOGONAL_LAYOUT_TYPE = new TLayoutType(TLocale.getString("layout_type_lite_orthogonal"), 8);
	public static final TLayoutType LITE_CIRCULAR_LAYOUT_TYPE = new TLayoutType(TLocale.getString("layout_type_lite_circular"), 9);
	public static final TLayoutType LITE_SINGLE_CYCLE_LAYOUT_TYPE = new TLayoutType(TLocale.getString("layout_type_lite_single_cycle"), 10);
	public static final TLayoutType LITE_TREE_LAYOUT_TYPE = new TLayoutType(TLocale.getString("layout_type_lite_tree"), 11);
	public static final TLayoutType LITE_AR_TREE_LAYOUT_TYPE = new TLayoutType(TLocale.getString("layout_type_lite_ar_tree"), 12);
	public static final TLayoutType LITE_HV_TREE_LAYOUT_TYPE = new TLayoutType(TLocale.getString("layout_type_lite_hv_tree"), 13);
	public static final TLayoutType LITE_BALLOON_TREE_LAYOUT_TYPE = new TLayoutType(TLocale.getString("layout_type_lite_balloon_tree"), 14);
	public static final TLayoutType LITE_RANDOM_LAYOUT_TYPE = new TLayoutType(TLocale.getString("layout_type_lite_random"), 15);
	
	private int type;
	
	private TLayoutType(String name, int type)
	{
		super(name);
		
		this.type = type;
	}
	
	public int getType()
	{
		return type;
	}
}