package com.nepxion.swing.selector.checkbox;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;

import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.list.JBasicList;
import com.nepxion.swing.renderer.list.CheckBoxListCellRenderer;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.util.data.CollectionUtil;

public class JCheckBoxListPanel
	extends JBasicScrollPane
{
	public static final byte SELECT_ALL = 0;
	public static final byte SELECT_NONE = 1;
	public static final byte SELECT_REVERSE = 2;
	
	private JBasicList selectionList;
	
	private List selectedElementNodes;
	private List selectedUserObjects;
	
	public JCheckBoxListPanel()
	{
		this(null);
	}
	
	public JCheckBoxListPanel(List allElementNodes)
	{
		if (allElementNodes == null)
		{
			selectionList = new JBasicList();
		}
		else
		{
			selectionList = new JBasicList(CollectionUtil.parseVector(allElementNodes));
		}
		selectionList.setCellRenderer(new CheckBoxListCellRenderer(selectionList, 22));
		
		getViewport().add(selectionList);
	}
	
	public void adaptListFacade(byte selectType)
	{
		ListModel listModel = selectionList.getModel();
		for (int i = 0; i < listModel.getSize(); i++)
		{
			IElementNode elementNode = (IElementNode) listModel.getElementAt(i);
			switch (selectType)
			{
				case SELECT_ALL :
					elementNode.setSelected(true);
					break;
				case SELECT_NONE :
					elementNode.setSelected(false);
					break;
				case SELECT_REVERSE :
					elementNode.setSelected(!elementNode.isSelected());
					break;
			}
		}
		
		updateSelection();
	}
	
	private void adaptSelection()
	{
		selectedElementNodes = new ArrayList();
		selectedUserObjects = new ArrayList();
		ListModel listModel = selectionList.getModel();
		for (int i = 0; i < listModel.getSize(); i++)
		{
			IElementNode elementNode = (IElementNode) listModel.getElementAt(i);
			if (elementNode.isSelected())
			{
				selectedElementNodes.add(elementNode);
				selectedUserObjects.add(elementNode.getUserObject());
			}
		}
	}
	
	public JBasicList getList()
	{
		return selectionList;
	}
	
	public List getAllElementNodes()
	{
		return selectionList.getListData();
	}
	
	public void setAllElementNodes(List allElementNodes)
	{
		selectionList.setListData(CollectionUtil.parseVector(allElementNodes));	
	}
	
	public List getSelectedElementNodes()
	{
		adaptSelection();
		
		return selectedElementNodes;
	}
	
	public List getSelectedUserObjects()
	{
		adaptSelection();
		
		return selectedUserObjects;
	}
	
	public void updateSelection()
	{
		selectionList.repaint();
	}
}