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
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

import com.nepxion.cots.twaver.locale.TLocale;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.renderer.list.RadioButtonListCellRenderer;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.textfield.JBasicTextField;
import com.nepxion.util.data.CollectionUtil;

public class TExportImageConfig
	extends JPanel
{
	private JList areaList;
	private JBasicTextField zoomTextField;
	private JBasicTextField marginTextField;
	
	private TGraph graph;
	
	public TExportImageConfig(TGraph graph)
	{
		this.graph = graph;
		
		List areaElementNodes = new ArrayList();
		areaElementNodes.add(new ElementNode(TLocale.getString("export_image_whole_area"), null, TLocale.getString("export_image_whole_area"), true));
		areaElementNodes.add(new ElementNode(TLocale.getString("export_image_suitable_area"), null, TLocale.getString("export_image_suitable_area"), false));
	
		areaList = new JList(CollectionUtil.parseArray(areaElementNodes));
		areaList.setCellRenderer(new RadioButtonListCellRenderer(areaList));
		
		double size1[][] = 
		{
			{TableLayout.FILL}, 
			{100}
		};
			
		JPanel areaPanel = new JPanel();
		areaPanel.setBorder(BorderManager.createComplexTitledBorder(TLocale.getString("export_image_area_setting")));
		areaPanel.setLayout(new TableLayout(size1));
		areaPanel.add(new JBasicScrollPane(areaList), "0, 0");
		
		zoomTextField = new JBasicTextField();
		
		double size2[][] = 
		{
			{0.3, 0.7}, 
			{22}
		};
				
		JPanel zoomePanel = new JPanel();
		zoomePanel.setBorder(BorderManager.createComplexTitledBorder(TLocale.getString("export_image_zoom_setting")));
		zoomePanel.setLayout(new TableLayout(size2));
		zoomePanel.add(new JLabel(TLocale.getString("export_image_zoom")), "0, 0");
		zoomePanel.add(zoomTextField, "1, 0");
		
		marginTextField = new JBasicTextField("0");
		double size3[][] = 
		{ 
			{0.3, 0.7}, 
			{22}
		};
		
		JPanel marginPanel = new JPanel();
		marginPanel.setBorder(BorderManager.createComplexTitledBorder(TLocale.getString("export_image_margin_setting")));
		marginPanel.setLayout(new TableLayout(size3));
		marginPanel.add(new JLabel(TLocale.getString("export_image_margin")), "0, 0");
		marginPanel.add(marginTextField, "1, 0");
		
		setPreferredSize(new Dimension(220, getPreferredSize().height));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(areaPanel);
		add(zoomePanel);
		add(marginPanel);
	}
	
	public boolean isSaveWhole()
	{		
		return isElementNodeSelected(0);
	}
	
	public boolean isSaveElement()
	{
		return isElementNodeSelected(1);
	}
	
	private boolean isElementNodeSelected(int index)
	{
		ListModel listModel = areaList.getModel();
		
		ElementNode elementNode = (ElementNode) listModel.getElementAt(index);
		
		return elementNode.isSelected();
	}
	
	public double getZoom()
	{
		try
		{
			return Double.parseDouble(zoomTextField.getText());
		}
		catch (NumberFormatException e)
		{
			return graph.getZoom();
		}
	}
	
	public void setZoom()
	{
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(2);
		
		String zoomValue = numberFormat.format(graph.getZoom());
		
		zoomTextField.setText(zoomValue);
	}
	
	public int getMargin()
	{
		try
		{
			return Integer.parseInt(marginTextField.getText());
		}
		catch (NumberFormatException e)
		{
			return 0;
		}
	}
}