package com.nepxion.swing.chart.pie;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Paint;
import java.awt.Stroke;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.PieDataset;

public class PieChartPlot
	extends PiePlot	implements IPieChartPlot
{
	/**
	 * The instance of PieChartPlotAdapter.
	 */
	private PieChartPlotAdapter adapter;
	
	/**
	 * The section outline stroke map.
	 */
	private Map sectionOutlineStrokeMap = new HashMap();
	
	/**
	 * The section outline paint map.
	 */
	private Map sectionOutlinePaintMap = new HashMap();
	
	/**
	 * The explode percent map.
	 */
	private Map explodePercentMap = new HashMap();
	
	/**
	 * Constructs with the default.
	 */
	public PieChartPlot()
	{
		super();
		
		adapter = new PieChartPlotAdapter();
		
		updateSelectionData();
	}
	
	/**
	 * Constructs with the specified initial dataset.
	 * @param dataset the instance of PieDataset
	 */
	public PieChartPlot(PieDataset dataset)
	{
		super(dataset);
		
		adapter = new PieChartPlotAdapter();
		
		updateSelectionData();
	}
	
	/**
	 * Updates the selection data.
	 */
	public void updateSelectionData()
	{
		sectionOutlineStrokeMap.clear();
		sectionOutlinePaintMap.clear();
		explodePercentMap.clear();

		for (Iterator iterator = getDataset().getKeys().iterator(); iterator.hasNext();)
		{
			Comparable key = (Comparable) iterator.next();
			
			Stroke stroke = super.getSectionOutlineStroke(key);
			
			if (stroke == null)
			{
				stroke = DEFAULT_OUTLINE_STROKE;
			}
			sectionOutlineStrokeMap.put(key, stroke);
			
			Paint paint = super.getSectionOutlinePaint(key);
			
			if (paint == null)
			{
				paint = DEFAULT_OUTLINE_PAINT;
			}
			sectionOutlinePaintMap.put(key, paint);
			
			Double explodePercent = super.getExplodePercent(key);
			if (explodePercent == null)
			{
				explodePercent = Double.valueOf(0.00D);
			}
			explodePercentMap.put(key, explodePercent);
		}
	}
	
	/**
	 * Updates the selection ui.
	 */
	public void updateSelectionUI()
	{
		for (Iterator iterator = getDataset().getKeys().iterator(); iterator.hasNext();)
		{
			Comparable key = (Comparable) iterator.next();
			
			Stroke stroke = adapter.getSectionOutlineStroke(key);
			if (stroke == null)
			{
				stroke = (Stroke) sectionOutlineStrokeMap.get(key);
			}
			
			super.setSectionOutlineStroke(key, stroke);
			
			Paint paint = adapter.getSectionOutlinePaint(key);
			if (paint == null)
			{
				paint = (Paint) sectionOutlinePaintMap.get(key);
			}
			
			super.setSectionOutlinePaint(key, paint);
			
			Double explodePercent = adapter.getExplodePercent(key);
			if (explodePercent == null)
			{
				explodePercent = (Double) explodePercentMap.get(key);
			}
			
			super.setExplodePercent(key, explodePercent.doubleValue());
		}
	}
	
	/**
	 * Dispatched when the mouse is over a chart.
	 * @param key the instance of Comparable
	 */
	public void dispatchMouseOver(Comparable key)
	{
		adapter.dispatchMouseOver(key);
		
		updateSelectionUI();
	}
	
	/**
	 * Dispatched when the mouse is down a chart.
	 * @param key the instance of Comparable
	 */
	public void dispatchMouseDown(Comparable key)
	{
		adapter.dispatchMouseDown(key);
		
		updateSelectionUI();
	}
	
	/**
	 * Sets the section outline stroke.
	 * @param key the instance of Comparable
	 * @param stroke the instance of Stroke
	 */
	public void setSectionOutlineStroke(Comparable key, Stroke stroke)
	{
		super.setSectionOutlineStroke(key, stroke);
		
		sectionOutlineStrokeMap.put(key, stroke);
	}
	
	/**
	 * Sets the section outline paint.
	 * @param key the instance of Comparable
	 * @param paint the instance of Paint
	 */
	public void setSectionOutlinePaint(Comparable key, Paint paint)
	{
		super.setSectionOutlinePaint(key, paint);
		
		sectionOutlinePaintMap.put(key, paint);
	}
	
	/**
	 * Sets the explode percent.
	 * @param key the instance of Comparable
	 * @param explodePercent the boolean value of explodePercent
	 */
	public void setExplodePercent(Comparable key, double explodePercent)
	{
		super.setExplodePercent(key, explodePercent);
		
		explodePercentMap.put(key, Double.valueOf(explodePercent));
	}
	
	/**
	 * Gets the selection key.
	 * @return the instance of Comparable
	 */
	public Comparable getSelectionKey()
	{
		return adapter.getSelectionKey();
	}
	
	/**
	 * Gets the adapter.
	 * @return the instance of PieChartPlotAdapter
	 */
	public PieChartPlotAdapter getAdapter()
	{
		return adapter;
	}
}