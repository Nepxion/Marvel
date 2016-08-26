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

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import twaver.Element;
import twaver.MouseActionEvent;
import twaver.network.ui.Attachment;
import twaver.network.ui.ElementUI;
import twaver.network.ui.LabelAttachment;

public class TGraphMouseAdapter
	implements ActionListener
{
	private TGraph graph;
	
	public TGraphMouseAdapter(TGraph graph)
	{
		this.graph = graph;
		this.graph.addElementClickedActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		MouseActionEvent mouseActionEvent = (MouseActionEvent) e;
		MouseEvent mouseEvent = mouseActionEvent.getMouseEvent();
		
		Element element = (Element) e.getSource();
		ElementUI elementUI = graph.getElementUI(element);
		Point point = graph.getLogicalPoint(mouseEvent.getPoint());
		
		Attachment attachment = elementUI.getAttachmentAt(point);
		if (attachment instanceof LabelAttachment)
		{
			return;
		}
		
		if (mouseEvent.getClickCount() == 1)
		{
			doClicked(mouseActionEvent);
		}
		else if (mouseEvent.getClickCount() > 1)
		{
			doDoubleClicked(mouseActionEvent);
		}
	}
	
	public TGraph getGraph()
	{
		return graph;
	}
	
	public void doClicked(MouseActionEvent mouseActionEvent)
	{
		
	}
	
	public void doDoubleClicked(MouseActionEvent mouseActionEvent)
	{
		TGraphManager.hideChildren(graph);
	}
}