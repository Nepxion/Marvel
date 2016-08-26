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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import twaver.DataBoxSelectionModel;
import twaver.Element;
import twaver.TDataBox;

public class TElementManager
{
	// �������ƻ�ȡNode����
	public static TNode getNode(TDataBox dataBox, String name)
	{
		for (Iterator iterator = dataBox.getAllElements().iterator(); iterator.hasNext();)
		{
			Element element = (Element) iterator.next();
			
			if (element instanceof TNode)
			{
				if (element.getName().equals(name))
				{
					return (TNode) element;
				}
			}
		}
		
		return null;
	}
	
	// ��ȡ����Node����
    public static List getNodes(TDataBox dataBox)
    {
        List nodes = new ArrayList();
        for (Iterator iterator = dataBox.getAllElements().iterator(); iterator.hasNext();)
        {
            Element element = (Element) iterator.next();
            
            if (element instanceof TNode)
            {
                nodes.add(element);
            }
        }
        
        return nodes;
    }
    
    // ��ȡGroup������Node����
    public static List getNodes(TGroup group)
    {
        List nodes = new ArrayList();
        for (Iterator iterator = group.children(); iterator.hasNext();)
        {
            nodes.add(iterator.next());
        }
        
        return nodes;
    }   
	
	// �������ƻ�ȡGroup����
	public static TGroup getGroup(TDataBox dataBox, String name)
	{
		for (Iterator iterator = dataBox.getAllElements().iterator(); iterator.hasNext();)
		{
			Element element = (Element) iterator.next();
			
			if (element instanceof TGroup)
			{
				if (element.getName().equals(name))
				{
					return (TGroup) element;
				}
			}
		}
		
		return null;
	}
	
    // ��ȡ����Group����
    public static List getGroups(TDataBox dataBox)
    {
        List groups = new ArrayList();
        for (Iterator iterator = dataBox.getAllElements().iterator(); iterator.hasNext();)
        {
            Element element = (Element) iterator.next();
            
            if (element instanceof TGroup)
            {
                groups.add(element);
            }
        }
        
        return groups;
    }   	
	
	// �������ƻ�ȡLink����
	public static TLink getLink(TDataBox dataBox, String name)
	{
		for (Iterator iterator = dataBox.getAllElements().iterator(); iterator.hasNext();)
		{
			Element element = (Element) iterator.next();
			
			if (element instanceof TLink)
			{
				if (element.getName().equals(name))
				{
					return (TLink) element;
				}
			}
		}
		
		return null;
	}
	
    // ��ȡ����Link����
    public static List getLinks(TDataBox dataBox)
    {
        List nodes = new ArrayList();
        for (Iterator iterator = dataBox.getAllElements().iterator(); iterator.hasNext();)
        {
            Element element = (Element) iterator.next();
            
            if (element instanceof TLink)
            {
                nodes.add(element);
            }
        }
        
        return nodes;
    }	
	
	// ���ѡ�е�һ��Element
	public static TElement getSelectedElement(TDataBox dataBox)
	{
		DataBoxSelectionModel selectionModel = dataBox.getSelectionModel();
		if (selectionModel == null || selectionModel.getAllSelectedElement().size() != 1 || !(selectionModel.lastElement() instanceof TElement))
		{
			return null;
		}
		
		return (TElement) selectionModel.lastElement();
	}
	
	// ���ѡ�е�һ��������Node
	public static List getSelectedNodes(TDataBox dataBox)
	{
		DataBoxSelectionModel selectionModel = dataBox.getSelectionModel();
		if (selectionModel == null || selectionModel.getAllSelectedElement().isEmpty())
		{
			return null;
		}
		
		List selectedNodes = new ArrayList();
		for (Iterator iterator = selectionModel.getAllSelectedElement().iterator(); iterator.hasNext();)
		{
			Object object = iterator.next();
			
			if (object instanceof TNode)
			{
				selectedNodes.add(object);
			}
		}
		
		return selectedNodes;
	}
	
	// ���ѡ�е�һ��Node
	public static TNode getSelectedNode(TDataBox dataBox)
	{
		DataBoxSelectionModel selectionModel = dataBox.getSelectionModel();
		if (selectionModel == null || selectionModel.getAllSelectedElement().size() != 1 || !(selectionModel.lastElement() instanceof TNode))
		{
			return null;
		}
		
		return (TNode) selectionModel.lastElement();
	}
	
	// ���ѡ�е�һ��������Group
	public static List getSelectedGroups(TDataBox dataBox)
	{
		DataBoxSelectionModel selectionModel = dataBox.getSelectionModel();
		if (selectionModel == null || selectionModel.getAllSelectedElement().isEmpty())
		{
			return null;
		}
		
		List selectedGroups = new ArrayList();
		for (Iterator iterator = selectionModel.getAllSelectedElement().iterator(); iterator.hasNext();)
		{
			Object object = iterator.next();
			
			if (object instanceof TGroup)
			{
				selectedGroups.add(object);
			}
		}
		
		return selectedGroups;
	}
	
	// ���ѡ�е�һ��Group
	public static TGroup getSelectedGroup(TDataBox dataBox)
	{
		DataBoxSelectionModel selectionModel = dataBox.getSelectionModel();
		if (selectionModel == null || selectionModel.getAllSelectedElement().size() != 1 || !(selectionModel.lastElement() instanceof TGroup))
		{
			return null;
		}
		
		return (TGroup) selectionModel.lastElement();
	}
	
	// ���ѡ�е�һ��������Link
	public static List getSelectedLinks(TDataBox dataBox)
	{
		DataBoxSelectionModel selectionModel = dataBox.getSelectionModel();
		if (selectionModel == null || selectionModel.getAllSelectedElement().isEmpty())
		{
			return null;
		}
		
		List selectedLinks = new ArrayList();
		for (Iterator iterator = selectionModel.getAllSelectedElement().iterator(); iterator.hasNext();)
		{
			Object object = iterator.next();
			
			if (object instanceof TNode)
			{
				selectedLinks.add(object);
			}
		}
		
		return selectedLinks;
	}
	
	// ���ѡ�е�һ��Link
	public static TLink getSelectedLink(TDataBox dataBox)
	{
		DataBoxSelectionModel selectionModel = dataBox.getSelectionModel();
		if (selectionModel == null || selectionModel.getAllSelectedElement().size() != 1 || !(selectionModel.lastElement() instanceof TLink))
		{
			return null;
		}
		
		return (TLink) selectionModel.lastElement();
	}
	
    public static void addGroupChildren(TDataBox dataBox, TGroup group) 
    {
        for (Iterator iterator = group.children(); iterator.hasNext();) 
        {
            dataBox.addElement((TNode) iterator.next());
        }
    }
    
    public static void removeGroupChildren(TDataBox dataBox, TGroup group) 
    {
        List children = new ArrayList();
        for (Iterator iterator = group.children(); iterator.hasNext();) 
        {
            children.add(iterator.next());
        }
        
        for (Iterator iterator = children.iterator(); iterator.hasNext();) 
        {
            dataBox.removeElement((TNode) iterator.next());
        }
        
        group.clearChildren();
    }
}