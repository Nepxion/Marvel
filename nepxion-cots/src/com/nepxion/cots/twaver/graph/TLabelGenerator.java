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

import twaver.Element;
import twaver.Generator;

import com.nepxion.cots.twaver.element.TGroup;
import com.nepxion.cots.twaver.element.TLink;
import com.nepxion.cots.twaver.element.TNode;

public class TLabelGenerator
	implements Generator
{
	private TGraph graph;
	private TLabelConfigData nodeLabelConfigData;
	private TLabelConfigData groupLabelConfigData;
	private TLabelConfigData linkLabelConfigData;
	
	public TLabelGenerator(TGraph graph)
	{
		this(graph, null, null, null);
	}
	
	public TLabelGenerator(TGraph graph, TLabelConfigData nodeLabelConfigData, TLabelConfigData groupLabelConfigData, TLabelConfigData linkLabelConfigData)
	{
		this.graph = graph;
		this.nodeLabelConfigData = nodeLabelConfigData;
		this.groupLabelConfigData = groupLabelConfigData;
		this.linkLabelConfigData = linkLabelConfigData;
		this.graph.setElementLabelGenerator(this);
	}
	
	public TLabelConfigData getNodeLabelConfigData()
	{
		return nodeLabelConfigData;
	}
	
	public TLabelConfigData getGroupLabelConfigData()
	{
		return groupLabelConfigData;
	}
	
	public TLabelConfigData getLinkLabelConfigData()
	{
		return linkLabelConfigData;
	}
	
	public Object generate(Object object)
	{
		if (object instanceof TNode)
		{
			return generateNodeLabel((TNode) object);
		}
		else if (object instanceof TGroup)
		{
			return generateGroupLabel((TGroup) object);
		}
		else if (object instanceof TLink)
		{
			return generateLinkLabel((TLink) object);
		}
		if (object instanceof Element)
		{
			return ((Element) object).getName();
		}
		
		return null;
	}
	
	public Object generateNodeLabel(TNode node)
	{
		if (nodeLabelConfigData == null)
		{
			return node.getName();
		}
		
		String key = nodeLabelConfigData.getKey();
		if (key != null)
		{
			if (key.equals(TLabelConfigData.NAME))
			{
				return node.getName();
			}
			else
			{
				return getServiceNodeLabel(node);
			}
		}
		
		return "";
	}
	
	public Object getServiceNodeLabel(TNode node)
	{
		return "";
	}
	
	public Object generateGroupLabel(TGroup group)
	{
		if (groupLabelConfigData == null)
		{
			return group.getName();
		}
		String key = groupLabelConfigData.getKey();
		if (key != null)
		{
			if (key.equals(TLabelConfigData.NAME))
			{
				return group.getName();
			}
			else
			{
				return getServiceGroupLabel(group);
			}
		}
		
		return "";
	}
	
	public Object getServiceGroupLabel(TGroup group)
	{
		return "";
	}
	
	public Object generateLinkLabel(TLink link)
	{
		if (linkLabelConfigData == null)
		{
			if (link.isBundleAgent())
			{
				return "";
			}
			else
			{
				return link.getName();
			}
		}
		
		String key = linkLabelConfigData.getKey();
		if (key != null)
		{
			if (link.isBundleAgent())
			{
				return "";
			}
			else if (key.equals(TLabelConfigData.NAME))
			{
				return link.getName();
			}
			else
			{
				return getServiceLinkLabel(link);
			}
		}
		
		return "";
	}
	
	public Object getServiceLinkLabel(TLink link)
	{
		return "";
	}
	
	public TGraph getGraph()
	{
		return graph;
	}
}