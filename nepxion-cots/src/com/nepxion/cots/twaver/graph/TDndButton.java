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

import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragSourceDropEvent;

import javax.swing.ButtonModel;
import javax.swing.plaf.ButtonUI;

import twaver.network.toolbar.BaseNetworkDnDButton;

import com.nepxion.swing.button.BasicButtonModel;
import com.nepxion.swing.button.ButtonManager;

public class TDndButton
	extends BaseNetworkDnDButton
{
	private TGraph graph;
	private Object dndObject;
	
	public TDndButton(TGraph graph, Class elementType, Object dndObject)
	{
		super(graph, elementType);
		
		this.graph = graph;
		this.dndObject = dndObject;
		
		setModel(new BasicButtonModel());
		setUI((ButtonUI) ButtonManager.getButtonUI());
	}
	
	public Object getDndObject()
	{
		return dndObject;
	}
	
	public void setDnDObject(Object dndObject)
	{
		this.dndObject = dndObject;
	}
	
	public void dragGestureRecognized(DragGestureEvent e)
	{
		super.dragGestureRecognized(e);
		
		graph.setDnDObject(dndObject);
	}
	
	public void dragDropEnd(DragSourceDropEvent e)
	{
		ButtonModel buttonModel = getModel();
		buttonModel.setRollover(false);
		buttonModel.setArmed(false);
		buttonModel.setPressed(false);
		
		repaint();
	}
}