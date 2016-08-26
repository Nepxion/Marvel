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

import java.util.List;

public abstract interface TAdapter
{
	public boolean addElementPermitted();
	
	public void addElement();
	
	
	public boolean modifyElementPermitted();
	
	public void modifyElement();
	

	public boolean renameElementPermitted();
	
	public void renameElement();
	
	
	public boolean deleteElementPermitted();

	public void deleteElement();
	
	
	public boolean deleteElementsPermitted();
	
	public void deleteElements();
	

	public boolean refreshPermitted();
	
	public List refresh();
	
	
	public boolean clearPermitted();
	
	public boolean clear();
	
	
	public boolean savePermitted();
	
	public List save();
}