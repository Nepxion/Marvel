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

import twaver.Element;
import twaver.GeoCoordinate;
import twaver.Node;
import twaver.TDataBox;
import twaver.TUIManager;
import twaver.TWaverConst;
import twaver.TWaverUtil;
import twaver.gis.TWaverGisConst;

import com.nepxion.cots.twaver.icon.TIconFactory;
import com.nepxion.cots.twaver.locale.TLocale;

public class TNode
	extends Node implements TElement
{
	static
	{
		TUIManager.registerAttachment("expand", "/" + TIconFactory.ICON_FOLDER + "expand.png", TWaverConst.POSITION_TOPLEFT, -15, 13);
		TUIManager.registerAttachment("collapse", "/" + TIconFactory.ICON_FOLDER + "collapse.png", TWaverConst.POSITION_TOPLEFT, -15, 13);
		TUIManager.registerAttachment("pin", "/" + TIconFactory.ICON_FOLDER + "pin.png", TWaverConst.POSITION_TOPRIGHT, 20, 13);
	}
	
	private boolean isMovable = true;
	private boolean isChildrenHidden = false;
	private boolean isChildrenHiddenPermitted = false;
	
	private boolean isLeaf = false;
	private boolean isCategory = false;
	private boolean isSpecial = false;
	private boolean isDeletePermitted = true;
	
	public TNode()
	{
		super();
		
		initComponents();
	}
	
	public TNode(Object id)
	{
		super(id);
		
		initComponents();
	}
	
	private void initComponents()
	{
		putClientProperty(TWaverConst.PROPERTYNAME_LABEL_YOFFSET, TWaverUtil.valueOf(4)); // 7
	}
	
	public GeoCoordinate getGeoCoordinate()
	{
		GeoCoordinate geoCoordinate = (GeoCoordinate) getClientProperty(TWaverGisConst.GEOCOORDINATE);;
		
		return geoCoordinate;
	}
	
	public void setGeoCoordinate(GeoCoordinate geoCoordinate)
	{
		putClientProperty(TWaverGisConst.GEOCOORDINATE, geoCoordinate);
	}
	
	public boolean isMovable()
	{
		return isMovable;
	}
	
	public void setMovable(boolean isMovable)
	{
		this.isMovable = isMovable;
		
		if (this.isMovable)
		{
			removeAttachment("pin");
		}
		else
		{
			addAttachment("pin");
		}
	}
	
	public boolean isChildrenHidden()
	{
		return isChildrenHidden;
	}
	
	public void setChildrenHidden(boolean isChildrenHidden)
	{
		this.isChildrenHidden = isChildrenHidden;
		
		if (isChildrenHiddenPermitted)
		{
			if (this.isChildrenHidden)
			{
				addAttachment("expand");
				
				removeAttachment("collapse");
			}
			else
			{
				addAttachment("collapse");
				
				removeAttachment("expand");
			}
		}
	}
	
	public void enableChildrenHidden()
	{
		if (childrenSize() == 0)
		{
			isChildrenHiddenPermitted = false;
			
			removeAttachment("expand");
			removeAttachment("collapse");
		}
		else
		{
			isChildrenHiddenPermitted = true;
			
			setChildrenHidden(isChildrenHidden);
		}
	}
	
	public Element copy()
	{
		TNode node = (TNode) super.copy();
		
		copyProperty(node, true);
		
		return node;
	}
	
	public Element copy(Object id)
	{
		TNode node = (TNode) super.copy(id);
		
		copyProperty(node, true);
		
		return node;
	}
	
	public Element copy(TDataBox box)
	{
		TNode node = (TNode) super.copy(box);
		
		copyProperty(node, true);
		
		return node;
	}
	
	public Element copy(Object id, TDataBox box)
	{
		TNode node = (TNode) super.copy(id, box);
		
		copyProperty(node, true);
		
		return node;
	}
	
	public Element copyAll()
	{
		TNode node = (TNode) super.copy();
		
		copyProperty(node, false);
		node.setUserObject(getUserObject());
		
		return node;
	}
	
	private void copyProperty(TNode node, boolean changeName)
	{
		if (changeName)
		{
			node.setName(TLocale.getString("element_copied") + " " + getName());
		}
		node.setMovable(true);
		node.enableChildrenHidden();
	}
	
	// 子节点
	public boolean isLeaf()
	{
		return isLeaf;
	}
	
	public void setLeaf(boolean isLeaf)
	{
		this.isLeaf = isLeaf;
	}
	
	// 目录类型的节点
	public boolean isCategory()
	{
		return isCategory;
	}
	
	public void setCategory(boolean isCategory)
	{
		this.isCategory = isCategory;
	}
	
	// 特别作用的节点
	public boolean isSpecial()
	{
		return isSpecial;
	}
	
	public void setSpecial(boolean isSpecial)
	{
		this.isSpecial = isSpecial;
	}
	
	// 节点可删除
	public boolean isDeletePermitted()
	{
		return isDeletePermitted;
	}
	
	public void setDeletePermitted(boolean isDeletePermitted)
	{
		this.isDeletePermitted = isDeletePermitted;
	}
	
	public String toString()
	{
		return getName();
	}
}