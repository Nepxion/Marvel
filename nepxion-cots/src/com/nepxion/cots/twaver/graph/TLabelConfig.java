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

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import com.nepxion.cots.twaver.locale.TLocale;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.renderer.list.RadioButtonListCellRenderer;
import com.nepxion.swing.scrollpane.JBasicScrollPane;

public class TLabelConfig
	extends JPanel
{
	private JList nodeLabelList;
	private JList groupLabelList;
	private JList linkLabelList;
	
	public TLabelConfig()
	{
		double[][] size = 
		{
			{TableLayout.FILL}, 
			{100}
		};
		
		nodeLabelList = new JList();
		
		JPanel nodeLabelPanel = new JPanel();
		nodeLabelPanel.setBorder(BorderManager.createComplexTitledBorder(TLocale.getString("label_node")));
		nodeLabelPanel.setLayout(new TableLayout(size));
		nodeLabelPanel.add(new JBasicScrollPane(nodeLabelList), "0, 0");
		
		groupLabelList = new JList();
		
		JPanel groupLabelPanel = new JPanel();
		groupLabelPanel.setBorder(BorderManager.createComplexTitledBorder(TLocale.getString("label_group")));
		groupLabelPanel.setLayout(new TableLayout(size));
		groupLabelPanel.add(new JBasicScrollPane(groupLabelList), "0, 0");
		
		linkLabelList = new JList();
		
		JPanel linkLabelPanel = new JPanel();
		linkLabelPanel.setBorder(BorderManager.createComplexTitledBorder(TLocale.getString("label_link")));
		linkLabelPanel.setLayout(new TableLayout(size));
		linkLabelPanel.add(new JBasicScrollPane(linkLabelList), "0, 0");
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(nodeLabelPanel);
		add(groupLabelPanel);
		add(linkLabelPanel);
		
		setPreferredSize(new Dimension(250, getPreferredSize().height));
	}
	
	public void setNodeLabelList(TLabelConfigData[] labelConfigDatas, int selectedIndex)
	{
		setLabelList(nodeLabelList, labelConfigDatas, selectedIndex);
	}
	
	public void setGroupLabelList(TLabelConfigData[] labelConfigDatas, int selectedIndex)
	{
		setLabelList(groupLabelList, labelConfigDatas, selectedIndex);
	}
	
	public void setLinkLabelList(TLabelConfigData[] labelConfigDatas, int selectedIndex)
	{
		setLabelList(linkLabelList, labelConfigDatas, selectedIndex);
	}
	
	private void setLabelList(JList list, TLabelConfigData[] labelConfigDatas, int selectedIndex)
	{
		DefaultListModel listModel = new DefaultListModel();
		for (int i = 0; i < labelConfigDatas.length; i++)
		{
			TLabelConfigData labelConfigData = labelConfigDatas[i];
			
			boolean isSelected = false;
			if (i == selectedIndex)
			{
				isSelected = true;
			}
			
			ElementNode labelData = new ElementNode(labelConfigData.getName(), null, labelConfigData.getName(), labelConfigData, isSelected);
			listModel.addElement(labelData);
		}
		
		list.setModel(listModel);
		list.setCellRenderer(new RadioButtonListCellRenderer(list));
	}
	
	public TLabelConfigData getNodeLabelData()
	{
		return getLabelData(nodeLabelList);
	}
	
	public TLabelConfigData getGroupLabelData()
	{
		return getLabelData(groupLabelList);
	}
	
	public TLabelConfigData getLinkLabelData()
	{
		return getLabelData(linkLabelList);
	}
	
	private TLabelConfigData getLabelData(JList list)
	{
		for (int i = 0; i < list.getModel().getSize(); i++)
		{
			ElementNode nodeElementNode = (ElementNode) list.getModel().getElementAt(i);
			if (nodeElementNode.isSelected())
			{
				TLabelConfigData selecetdLabelConfigData = (TLabelConfigData) nodeElementNode.getUserObject();
		
				return selecetdLabelConfigData;
			}
		}
		
		return null;
	}
}