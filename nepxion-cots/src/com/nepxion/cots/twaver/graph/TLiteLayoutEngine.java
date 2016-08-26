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

import java.awt.geom.GeneralPath;
import java.util.HashMap;
import java.util.Map;

import twaver.Link;
import y.base.Edge;
import y.view.EdgeRealizer;
import y.view.Graph2D;

/**
 * This class provides the auto-layout engine function. The auto-layout feature
 * can make the network component auto-layout all nodes and links in a good
 * arrangment. This engine use the thirt-part auto-layout package to
 * re-calculate each node's position and link path. The current implementation
 * is using the yWorks's yFile package. JWaver also can use other auto-layout
 * package engine.
 */
public class TLiteLayoutEngine
	extends Graph2D
{
	private Map nodes = new HashMap();
	
	private Map links = new HashMap();
	
	/**
	 * Constructs the auto-layout engine.
	 */
	public TLiteLayoutEngine()
	{
	}
	
	/**
	 * Set the new link style.
	 * @param edgeRealizer
	 */
	public void setLinkStyle(EdgeRealizer edgeRealizer)
	{
		this.setDefaultEdgeRealizer(edgeRealizer);
	}
	
	/**
	 * Get the link style.
	 * @return
	 */
	public EdgeRealizer getLinkStype()
	{
		return this.getDefaultEdgeRealizer();
	}
	
	/**
	 * Get this link's path after auto-layout.
	 * @param link the element element.
	 * @return the link path.
	 */
	public GeneralPath getLinkPath(Link link)
	{
		if (links.containsKey(link))
		{
			Edge edge = (Edge) links.get(link);
			return getRealizer(edge).getPath();
		}
		
		return null;
	}
	
	/**
	 * Get all nodes.
	 * @return
	 */
	public Map getNodes()
	{
		return nodes;
	}
	
	/**
	 * Get all links.
	 * @return
	 */
	public Map getLinks()
	{
		return links;
	}
	
	/**
	 * Clear all data contains in this engine.
	 */
	public void clear()
	{
		super.clear();
		
		nodes.clear();
		links.clear();
	}
}