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

import com.nepxion.cots.twaver.element.TNode;

public class TGraphGridLocator
{
	public static final int DIRECTION_NORTH_EAST = 0;
	public static final int DIRECTION_NORTH_WEST = 1;
	public static final int DIRECTION_SOUTH_EAST = 2;
	public static final int DIRECTION_SOUTH_WEST = 3;
	
	public void locate(TNode previouseNode, TNode currentNode, double angle, double distance, int direction)
	{
		double x = previouseNode.getLocation().getX();
		double y = previouseNode.getLocation().getY();
		
		locate(currentNode, x, y, angle, distance, direction);
	}
	
	public void locate(TNode node, double x, double y, double angle, double distance, int direction)
	{
		double hSpace = distance * Math.cos(angle);
		double vSpace = distance * Math.sin(angle);
		
		switch (direction)
		{
			case DIRECTION_NORTH_EAST :
			{
				vSpace = -vSpace;
				break;
			}
			case DIRECTION_NORTH_WEST :
			{
				hSpace = -hSpace;
				vSpace = -vSpace;
				break;
			}
			case DIRECTION_SOUTH_EAST :
			{
				break;
			}
			case DIRECTION_SOUTH_WEST :
			{
				hSpace = -hSpace;
				break;
			}
		}
		
		node.setLocation(x + hSpace, y + vSpace);
	}
}