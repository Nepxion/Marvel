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
import java.awt.geom.GeneralPath;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.SwingUtilities;

import twaver.BaseElement;
import twaver.Element;
import twaver.Link;
import twaver.TDataBox;
import twaver.network.ui.LinkUI;
import y.base.Edge;
import y.base.Node;
import y.layout.Layouter;
import y.layout.circular.CircularLayouter;
import y.layout.circular.SingleCycleLayouter;
import y.layout.hierarchic.HierarchicLayouter;
import y.layout.organic.OrganicLayouter;
import y.layout.organic.SmartOrganicLayouter;
import y.layout.orthogonal.OrthogonalLayouter;
import y.layout.random.RandomLayouter;
import y.layout.tree.ARTreeLayouter;
import y.layout.tree.BalloonLayouter;
import y.layout.tree.HVTreeLayouter;
import y.layout.tree.TreeLayouter;
import y.view.EdgeRealizer;

import com.nepxion.cots.twaver.locale.TLocale;
import com.nepxion.swing.exception.ExceptionTracer;
import com.nepxion.swing.handle.HandleManager;

public class TLiteLayouter
{
	public static final int MINIMUM_GAP = 1;
	public static final int MAXIMUM_GAP = 500;
	public static final int DEFAULT_GAP = 100;
	
	private TGraph graph;
	private TLiteLayoutEngine layoutEngine;
	
	public TLiteLayouter(TGraph graph)
	{
		this.graph = graph;
		this.layoutEngine = new TLiteLayoutEngine();
	}
	
	public void doOrganicLayout(int gap, boolean isAnimated)
	{
		OrganicLayouter layouter = new OrganicLayouter();
		layouter.setGravityFactor(2.00);
		layouter.setPreferredEdgeLength(gap);
		
		try
		{
			doLayout(layouter, isAnimated);
		}
		catch (Exception e)
		{
			ExceptionTracer.traceException(HandleManager.getFrame(graph), TLocale.getString("layout_execption"), e);
		}
	}
	
	public void doSmartOrganicLayout(int gap, boolean isAnimated)
	{
		SmartOrganicLayouter layouter = new SmartOrganicLayouter();
		layouter.setMinimalNodeDistance(1);
		layouter.setCompactness(0.01);
		layouter.setPreferredEdgeLength(gap);

		try
		{
			doLayout(layouter, isAnimated);
		}
		catch (Exception e)
		{
			ExceptionTracer.traceException(HandleManager.getFrame(graph), TLocale.getString("layout_execption"), e);
		}
	}
	
	public void doHierarchicLayout(int gap, boolean isAnimated)
	{
		HierarchicLayouter layouter = new HierarchicLayouter();
		layouter.setMinimalNodeDistance(gap);
		
		try
		{
			doLayout(layouter, isAnimated);
		}
		catch (Exception e)
		{
			ExceptionTracer.traceException(HandleManager.getFrame(graph), TLocale.getString("layout_execption"), e);
		}
	}
	
	public void doOrthogonalLayout(int gap, boolean isAnimated)
	{
		OrthogonalLayouter layouter = new OrthogonalLayouter();
		layouter.setGrid(gap);
		
		try
		{
			doLayout(layouter, isAnimated);
		}
		catch (Exception e)
		{
			ExceptionTracer.traceException(HandleManager.getFrame(graph), TLocale.getString("layout_execption"), e);
		}
	}
	
	public void doCircularLayout(boolean isAnimated)
	{
		CircularLayouter layouter = new CircularLayouter();
		
		try
		{
			doLayout(layouter, isAnimated);
		}
		catch (Exception e)
		{
			ExceptionTracer.traceException(HandleManager.getFrame(graph), TLocale.getString("layout_execption"), e);
		}
	}
	
	public void doSingleCycleLayout(int gap, boolean isAnimated)
	{
		SingleCycleLayouter layouter = new SingleCycleLayouter();
		layouter.setMinimalNodeDistance(gap);

		try
		{
			doLayout(layouter, isAnimated);
		}
		catch (Exception e)
		{
			ExceptionTracer.traceException(HandleManager.getFrame(graph), TLocale.getString("layout_execption"), e);
		}
	}
	
	public void doTreeLayout(int gap, boolean isAnimated)
	{
		TreeLayouter layouter = new TreeLayouter();
		layouter.setMinimalNodeDistance(gap);

		try
		{
			doLayout(layouter, isAnimated);
		}
		catch (Exception e)
		{
			ExceptionTracer.traceException(HandleManager.getFrame(graph), TLocale.getString("layout_execption"), e);
		}
	}
	
	public void doARTreeLayout(boolean isAnimated)
	{
		ARTreeLayouter layouter = new ARTreeLayouter();

		try
		{
			doLayout(layouter, isAnimated);
		}
		catch (Exception e)
		{
			ExceptionTracer.traceException(HandleManager.getFrame(graph), TLocale.getString("layout_execption"), e);
		}
	}
	
	public void doHVTreeLayout(boolean isAnimated)
	{
		HVTreeLayouter layouter = new HVTreeLayouter();
		
		try
		{
			doLayout(layouter, isAnimated);
		}
		catch (Exception e)
		{
			ExceptionTracer.traceException(HandleManager.getFrame(graph), TLocale.getString("layout_execption"), e);
		}
	}
	
	public void doBalloonTreeLayout(int gap, boolean isAnimated)
	{
		BalloonLayouter layouter = new BalloonLayouter();
		layouter.setMinimalEdgeLength(gap);
		
		try
		{
			doLayout(layouter, isAnimated);
		}
		catch (Exception e)
		{
			ExceptionTracer.traceException(HandleManager.getFrame(graph), TLocale.getString("layout_execption"), e);
		}
	}
	
	public void doRandomLayout(boolean isAnimated)
	{
		RandomLayouter layouter = new RandomLayouter();
		
		try
		{
			doLayout(layouter, isAnimated);
		}
		catch (Exception e)
		{
			ExceptionTracer.traceException(HandleManager.getFrame(graph), TLocale.getString("layout_execption"), e);
		}
	}
	
	public void doLayout(Layouter layouter, final boolean isAnimated)
	{
		syncEngineData();
		layouter.doLayout(layoutEngine);
		
		final Map newLocations = new HashMap();
		final Map oldLocations = new HashMap();
		Iterator itKey = layoutEngine.getNodes().keySet().iterator();
		while (itKey.hasNext())
		{
			Element element = (Element) itKey.next();
			Node yNode = (Node) layoutEngine.getNodes().get(element);
			Point newPoint = new Point((int) layoutEngine.getLocation(yNode).x, (int) layoutEngine.getLocation(yNode).y);
			newLocations.put(element, newPoint);
			oldLocations.put(element, element.getLocation());
		}
		
		Thread thread = new Thread()
		{
			public void run()
			{
				final int size = isAnimated ? 20 : 1;
				
				for (int i = 0; i <= size; i++)
				{
					final int step = i;
					try
					{
						SwingUtilities.invokeAndWait(new Runnable()
						{
							public void run()
							{
								Iterator it = newLocations.keySet().iterator();
								while (it.hasNext())
								{
									BaseElement element = (BaseElement) it.next();
									Point oldLocation = (Point) oldLocations.get(element);
									Point newLocation = (Point) newLocations.get(element);
									if (step < size)
									{
										int x = oldLocation.x + step * (newLocation.x - oldLocation.x) / size;
										int y = oldLocation.y + step * (newLocation.y - oldLocation.y) / size;
										element.setLocation(x, y);
									}
									else
									{
										element.setLocation(newLocation);
									}
								}
								
								if (step == size)
								{
									it = layoutEngine.getLinks().keySet().iterator();
									while (it.hasNext())
									{
										Link link = (Link) it.next();
										LinkUI linkUI = (LinkUI) graph.getRenderer().getElementUI(link);
										Edge edge = (Edge) layoutEngine.getLinks().get(link);
										EdgeRealizer realizer = layoutEngine.getRealizer(edge);
										GeneralPath path = realizer.getPath();
										GeneralPath newPath = new GeneralPath();
										Point fromPoint = linkUI.getFromPoint();
										Point toPoint = linkUI.getToPoint();
										newPath.moveTo(fromPoint.x, fromPoint.y);
										newPath.append(path.getPathIterator(null), true);
										newPath.lineTo(toPoint.x, toPoint.y);
										linkUI.setPath(newPath);
									}
									graph.adjustCanvasSize();
									graph.getCanvas().repaint();
								}
							}
						}
						);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					
					if (isAnimated)
					{
						try
						{
							Thread.sleep(10);
						}
						catch (InterruptedException e)
						{
						}
					}
				}
				
			}
		};
		thread.start();
	}
	
	private void syncEngineData()
	{
		layoutEngine.clear();
		TDataBox dataBox = graph.getDataBox();
		
		Iterator iterator = dataBox.iterator();
		while (iterator.hasNext())
		{
			Object object = iterator.next();
			if (object instanceof BaseElement)
			{
				BaseElement elementNode = (BaseElement) object;
				if (!graph.isVisible(elementNode))
				{
					continue;
				}
				
				if (!graph.isMovable(elementNode))
				{
					continue;
				}
				
				Node yNode = layoutEngine.createNode();
				layoutEngine.setSize(yNode, elementNode.getWidth(), elementNode.getHeight());
				layoutEngine.getNodes().put(elementNode, yNode);
			}
		}
		
		iterator = dataBox.iterator();
		while (iterator.hasNext())
		{
			Object object = iterator.next();
			if (object instanceof Link)
			{
				Link link = (Link) object;
				if (!graph.isVisible(link))
				{
					continue;
				}
				
				BaseElement fromNode = link.getFrom();
				BaseElement toNode = link.getTo();
				if (fromNode == null || toNode == null)
				{
					continue;
				}
				
				Node fromYNode = (Node) layoutEngine.getNodes().get(fromNode);
				Node toYNode = (Node) layoutEngine.getNodes().get(toNode);
				if (fromYNode == null || toYNode == null)
				{
					continue;
				}
				
				Edge edge = layoutEngine.createEdge(fromYNode, toYNode);
				layoutEngine.getLinks().put(link, edge);
			}
		}
	}
}