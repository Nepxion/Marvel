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

public interface TElement
	extends Element
{
	// 子节点
	public boolean isLeaf();
	
	public void setLeaf(boolean isLeaf);
	
	// 目录类型的节点
	public boolean isCategory();
	
	public void setCategory(boolean isCategory);
	
	// 特别作用的节点
	public boolean isSpecial();
	
	public void setSpecial(boolean isSpecial);
	
	// 节点可删除
	public boolean isDeletePermitted();
	
	public void setDeletePermitted(boolean isDeletePermitted);
}