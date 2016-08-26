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

import java.awt.Color;

import twaver.Element;
import twaver.Link;
import twaver.Node;
import twaver.TDataBox;
import twaver.TUIManager;
import twaver.TWaverConst;

import com.nepxion.cots.twaver.locale.TLocale;

public class TLink
	extends Link implements TElement
{
	private Color highLightColor = Color.green;
	private boolean isHighLightable = false;
	
	private boolean isLeaf = false;
	private boolean isCategory = false;
	private boolean isSpecial = false;
	private boolean isDeletePermitted = true;
	
	public TLink()
	{
		super();
		
		initComponents();
	}
	
	public TLink(Node from, Node to)
	{
		super(from, to);
		
		initComponents();
	}
	
	public TLink(Object id)
	{
		super(id);
		
		initComponents();
	}
	
	public TLink(Object id, Node from, Node to)
	{
		super(id, from, to);
		
		initComponents();
	}
	
	private void initComponents()
	{
        putLinkAntialias(true);
		putClientProperty(TWaverConst.PROPERTYNAME_BORDER_UNDERNEATH, Boolean.FALSE);
		putClientProperty(TWaverConst.PROPERTYNAME_BORDER_TYPE, TWaverConst.BORDER_TYPE_DEFAULT);
		putClientProperty(TWaverConst.PROPERTYNAME_LINK_TO_ARROW_COLOR, Color.yellow);
	}
	
	public Color getHighLightColor()
	{
		return highLightColor;
	}
	
	public void setHighLightColor(Color highLightColor)
	{
		this.highLightColor = highLightColor;
	}
	
	public boolean isHighLightable()
	{
		return isHighLightable;
	}
	
	public void setHighLightable(boolean isHighLightable)
	{
		this.isHighLightable = isHighLightable;
		
		if (isSelected())
		{
			return;
		}
		if (this.isHighLightable)
		{
			putClientProperty(TWaverConst.PROPERTYNAME_LINK_COLOR, highLightColor);
		}
		else
		{
			putClientProperty(TWaverConst.PROPERTYNAME_LINK_COLOR, TUIManager.get(TWaverConst.PROPERTYNAME_LINK_COLOR));
		}
	}
	
	public Element copy()
	{
		TLink link = (TLink) super.copy();
		
		copyProperty(link, true);
		
		return link;
	}
	
	public Element copy(Object id)
	{
		TLink link = (TLink) super.copy(id);
		
		copyProperty(link, true);
		
		return link;
	}
	
	public Element copy(TDataBox box)
	{
		TLink link = (TLink) super.copy(box);
		
		copyProperty(link, true);
		
		return link;
	}
	
	public Element copy(Object id, TDataBox box)
	{
		TLink link = (TLink) super.copy(id, box);
		
		copyProperty(link, true);
		
		return link;
	}
	
	public Element copyAll()
	{
		TLink link = (TLink) super.copy();
		
		copyProperty(link, false);
		link.setUserObject(getUserObject());
		
		return link;
	}
	
	private void copyProperty(TLink link, boolean changeName)
	{
		if (changeName)
		{
			link.setName(TLocale.getString("element_copied") + " " + getName());
		}
	}
	
	// �ӽڵ�
	public boolean isLeaf()
	{
		return isLeaf;
	}
	
	public void setLeaf(boolean isLeaf)
	{
		this.isLeaf = isLeaf;
	}
	
	// Ŀ¼���͵Ľڵ�
	public boolean isCategory()
	{
		return isCategory;
	}
	
	public void setCategory(boolean isCategory)
	{
		this.isCategory = isCategory;
	}
	
	// �ر����õĽڵ�
	public boolean isSpecial()
	{
		return isSpecial;
	}
	
	public void setSpecial(boolean isSpecial)
	{
		this.isSpecial = isSpecial;
	}
	
	// �ڵ��ɾ��
	public boolean isDeletePermitted()
	{
		return isDeletePermitted;
	}
	
	public void setDeletePermitted(boolean isDeletePermitted)
	{
		this.isDeletePermitted = isDeletePermitted;
	}
	
	// ����Element ClientProperty��Ԫ�������ԣ�ʵ������ͬ��
	// ��������ֵ������Element ClientProperty��Ԫ�������Թ���
	public void putClientProperty(Object key, Object value)
	{
		if (TUIManager.isPredefinedClientPropertyKey(key.toString()))
		{
			super.putClientProperty(key, value);
		}
		else
		{
			putServiceClientProperty(key, value);
		}
	}
	
	public void putServiceClientProperty(Object key, Object value)
	{
		
	}
	
	// ����Element ClientProperty��Ԫ�������ԣ�ʵ������ͬ��
	// ��ȡ����ֵ������Element ClientProperty��Ԫ�������Թ���
	public Object getClientProperty(Object key)
	{
		if (TUIManager.isPredefinedClientPropertyKey(key.toString()))
		{
			return super.getClientProperty(key);
		}
		else
		{
			return getServiceClientProperty(key);
		}
	}
	
	public Object getServiceClientProperty(Object key)
	{
		return null;
	}
	
	// �������Ƹı�ʱ������Element UserObject�����Ӧ����������
	public void setName(String name)
	{
		super.setName(name);
		
		setServiceName(name);
	}
	
	public void setServiceName(String name)
	{
		
	}
	
	// ����Element UserObject��VEntity����
	public void setUserObject(Object userObject)
	{
		super.setUserObject(userObject);
		
		setServiceUserObject(userObject);
	}
	
	public void setServiceUserObject(Object userObject)
	{
		
	}
	
	public String toString()
	{
		return getName();
	}
}