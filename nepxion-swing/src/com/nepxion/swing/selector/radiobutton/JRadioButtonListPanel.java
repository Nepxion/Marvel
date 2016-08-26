package com.nepxion.swing.selector.radiobutton;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.List;

import javax.swing.ListModel;

import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.list.JBasicList;
import com.nepxion.swing.renderer.list.RadioButtonListCellRenderer;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.util.data.CollectionUtil;

public class JRadioButtonListPanel
	extends JBasicScrollPane
{
	private JBasicList selectionList;
	
	private IElementNode selectedElementNode;
	private Object selectedUserObject;
	
	public JRadioButtonListPanel()
	{
		this(null);
	}
	
	public JRadioButtonListPanel(List allElementNodes)
	{
		if (allElementNodes == null)
		{
			selectionList = new JBasicList();
		}
		else
		{
			selectionList = new JBasicList(CollectionUtil.parseVector(allElementNodes));
		}
		selectionList.setCellRenderer(new RadioButtonListCellRenderer(selectionList, 22));
		getViewport().add(selectionList);
	}
	
	private void adapterSelection()
	{
		ListModel listModel = selectionList.getModel();
		for (int i = 0; i < listModel.getSize(); i++)
		{
			IElementNode elementNode = (IElementNode) listModel.getElementAt(i);
			if (elementNode.isSelected())
			{
				selectedElementNode = elementNode;
				selectedUserObject = elementNode.getUserObject();
				
				return;
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
	
	public IElementNode getSelectedElementNode()
	{
		adapterSelection();
		
		return selectedElementNode;
	}
	
	public Object getSelectedUserObject()
	{
		adapterSelection();
		
		return selectedUserObject;
	}
	
	public void updateSelection()
	{
		selectionList.repaint();
	}
}