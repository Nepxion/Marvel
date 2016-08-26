package com.nepxion.swing.tree.lazyloader;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.Vector;

import javax.swing.tree.TreeNode;

import com.nepxion.swing.locale.SwingLocale;

public class SearchDescription
{
	private String searchText;
	
	private boolean isCaseSensitive;
	private boolean isTextMatched;
	
	private TreeNode treeNode;
	private Vector result;
	private int resultIndex;
	
	public SearchDescription()
	{
		result = new Vector();
		resultIndex = 0;
	}
	
	public String getSearchText()
	{
		return searchText;
	}
	
	public void setSearchText(String searchText)
	{
		this.searchText = searchText;
	}
	
	public boolean isCaseSensitive()
	{
		return isCaseSensitive;
	}
	
	public void setCaseSensitive(boolean isCaseSensitive)
	{
		this.isCaseSensitive = isCaseSensitive;
	}
	
	public boolean isTextMatched()
	{
		return isTextMatched;
	}
	
	public void setTextMatched(boolean isTextMatched)
	{
		this.isTextMatched = isTextMatched;
	}
	
	public TreeNode getTreeNode()
	{
		return treeNode;
	}
	
	public void setTreeNode(TreeNode treeNode)
	{
		this.treeNode = treeNode;
	}
	
	public Vector getResult()
	{
		return result;
	}
	
	public void setResult(Vector result)
	{
		this.result = result;
	}
	
	public int getResultIndex()
	{
		return resultIndex;
	}
	
	public void setResultIndex(int resultIndex)
	{
		this.resultIndex = resultIndex;
	}
	
	public void forward()
	{
		if (result == null || result.isEmpty())
		{
			return;
		}
		
		if (resultIndex >= result.size() - 1)
		{
			resultIndex = 0;
		}
		else
		{
			resultIndex++;
		}
	}
	
	public void backward()
	{
		if (result == null || result.isEmpty())
		{
			return;
		}
		if (resultIndex <= 0)
		{
			resultIndex = result.size() - 1;
		}
		else
		{
			resultIndex--;
		}
	}
	
	public String toString()
	{
		return SwingLocale.getString("search") + " " + SwingLocale.getString("quotation_left") + searchText + SwingLocale.getString("quotation_right") + " " + SwingLocale.getString("at") + SwingLocale.getString("node") + " " + SwingLocale.getString("quotation_left") + treeNode.toString() + SwingLocale.getString("quotation_right");
	}
}