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

import com.nepxion.swing.list.JBasicList;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.renderer.list.MultiRadioButtonListCellRenderer;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.util.data.CollectionUtil;

public class JMultiRadioButtonListPanel
	extends JBasicScrollPane
{
	private JBasicList selectionList;
	
	public JMultiRadioButtonListPanel()
	{
		this(null);
	}
	
	public JMultiRadioButtonListPanel(List allElementNodes)
	{
		this(allElementNodes, SwingLocale.getString("select_ignored"), SwingLocale.getString("select_contained"), SwingLocale.getString("select_not_contained"));
	}
	
	public JMultiRadioButtonListPanel(String ignoredText, String containedText, String notContainedText)
	{
		this(null, ignoredText, containedText, notContainedText);
	}
	
	public JMultiRadioButtonListPanel(List allElementNodes, String ignoredText, String containedText, String notContainedText)
	{
		if (allElementNodes == null)
		{
			selectionList = new JBasicList();
		}
		else
		{
			selectionList = new JBasicList(CollectionUtil.parseVector(allElementNodes));
		}
		selectionList.setCellRenderer(new MultiRadioButtonListCellRenderer(selectionList, 22, ignoredText, containedText, notContainedText));
		getViewport().add(selectionList);
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
	
	public void updateSelection()
	{
		selectionList.repaint();
	}
}