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

import twaver.Element;
import twaver.Generator;
import twaver.Group;
import twaver.SpringLayouter;

public class TLayouter
{
	public static final int MINIMUM_FORCE_SIZE = 10;
	public static final int MAXIMUM_FORCE_SIZE = 500;
	public static final int DEFAULT_FORCE_SIZE = 100;
	
	public static final int MINIMUM_STEP_SIZE = 1;
	public static final int MAXIMUM_STEP_SIZE = 1000;
	public static final int DEFAULT_STEP_SIZE = 500;
	
	public static final int MINIMUM_UPDATE_DURATION = 1;
	public static final int MAXIMUM_UPDATE_DURATION = 500;
	public static final int DEFAULT_UPDATE_DURATION = 10;
	
	public static final int MINIMUM_X_OFFSET = 0;
	public static final int MAXIMUM_X_OFFSET = 2000;
	public static final int DEFAULT_X_OFFSET = 150;
	
	public static final int MINIMUM_Y_OFFSET = 0;
	public static final int MAXIMUM_Y_OFFSET = 2000;
	public static final int DEFAULT_Y_OFFSET = 50;
	
	public static final int MINIMUM_X_GAP = 1;
	public static final int MAXIMUM_X_GAP = 500;
	public static final int DEFAULT_X_GAP = 50;
	
	public static final int MINIMUM_Y_GAP = 1;
	public static final int MAXIMUM_Y_GAP = 500;
	public static final int DEFAULT_Y_GAP = 50;
	
	private TGraph graph;
	private SpringLayouter layouter;
	
	public TLayouter(TGraph graph)
	{
		this.graph = graph;
		this.layouter = graph.getSpringLayouter();
		
		setForceSize(DEFAULT_FORCE_SIZE);
		setStepSize(DEFAULT_STEP_SIZE);
		setUpdateDuration(DEFAULT_UPDATE_DURATION);
	}
	
	public int getForceSize()
	{
		return layouter.getForceSize();
	}
	
	public void setForceSize(int forceSize)
	{
		layouter.setForceSize(forceSize);
	}
	
	public int getStepSize()
	{
		return layouter.getStepSize();
	}
	
	public void setStepSize(int stepSize)
	{
		layouter.setStepSize(stepSize);
	}
	
	public int getUpdateDuration()
	{
		return layouter.getUpdateDuration();
	}
	
	public void setUpdateDuration(int updateDuration)
	{
		layouter.setUpdateDuration(updateDuration);
	}
	
	public TGraph getGraph()
	{
		return graph;
	}
	
	public SpringLayouter getSpringLayouter()
	{
		return layouter;
	}
	
	public void start()
	{
		layouter.start();
	}
	
	public void stop()
	{
		layouter.stop();
	}
	
	public void doLayout(TLayoutType layoutType)
	{
		doLayout(layoutType, DEFAULT_X_OFFSET, DEFAULT_Y_OFFSET, DEFAULT_X_GAP, DEFAULT_Y_GAP);
	}
	
	public void doLayout(TLayoutType layoutType, int xOffset, int yOffset, final int xGap, final int yGap)
	{
		doLayout(layoutType, true, true, xOffset, yOffset, xGap, yGap);
	}
	
	public void doLayout(TLayoutType layoutType, boolean isAllElementsLayouted, boolean isAnimated, int xOffset, int yOffset, final int xGap, final int yGap)
	{
		if (layoutType.equals(TLayoutType.SPRING_LAYOUT_TYPE))
		{
			layouter.start();
		}
		else if (layoutType.equals(TLayoutType.RANDOM_LAYOUT_TYPE))
		{
			layouter.stop();
			layouter.random(0, 600);
		}
		else
		{
			layouter.stop();
			
			graph.doLayout(isAllElementsLayouted ? graph.getDataBox().getAllElements().iterator() : graph.getDataBox().getSelectionModel().getAllSelectedElement().iterator(), layoutType.getType(), isAnimated, null, xOffset, yOffset, new Generator()
			{
				public Object generate(Object object)
				{
					Element element = (Element) object;
					if (element instanceof Group)
					{
						return null;
					}
					
					return new Dimension(xGap, yGap);
				}
			}
			);
		}
	}
}