package com.nepxion.swing.pagination;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.swing.element.ElementNode;

public class PaginationContext
{	
	private int rowIndex = 1; // 起始行序号，对于数据库中记录序号
	private int rowCount = 100; // 单页的显示的行数
	private int totalRowCount = -1; // 总行数，对于数据库中的全部记录数
	private int pageIndex = 1; // 跳转页序号
	
	private ElementNode sortName; // 排序名称
	private ElementNode sortType; // 排序方式 ：升序/降序
	
	private boolean isValidation = true; // 上下文和状态检验，当分页上下文没有任何改变，则不执行数据库操作（例如当前页是5，进行“跳转到第5页”的操作时候，不执行）
	
	public PaginationContext()
	{
		
	}
	
	public PaginationContext(int totalRowCount)
	{
		this.totalRowCount = totalRowCount;
	}
	
	public int getRowIndex()
	{
		return rowIndex;
	}
	
	public void setRowIndex(int rowIndex)
	{
		this.rowIndex = rowIndex;
	}
	
	public int getRowCount()
	{
		return rowCount;
	}
	
	public void setRowCount(int rowCount)
	{
		this.rowCount = rowCount;
		this.pageIndex = 1;
		
		if (this.rowCount > this.totalRowCount && this.totalRowCount != -1)
		{
			this.rowCount = this.totalRowCount;
		}
	}
	
	public int getTotalRowCount()
	{
		return totalRowCount;
	}
	
	public void setTotalRowCount(int totalRowCount)
	{
		this.totalRowCount = totalRowCount;
		
		if (this.rowCount > this.totalRowCount && this.totalRowCount != -1)
		{
			this.rowCount = this.totalRowCount;
		}
	}
	
	public int getPageIndex()
	{
		return pageIndex;
	}
	
	public void setPageIndex(int pageIndex)
	{
		this.pageIndex = pageIndex;
		this.rowIndex = (pageIndex - 1) * rowCount + 1;
	}
	
	public ElementNode getSortName()
	{
		return sortName;
	}
	
	public void setSortName(ElementNode sortName)
	{
		this.sortName = sortName;
		this.rowIndex = 1;
	}
	
	public ElementNode getSortType()
	{
		return sortType;
	}
	
	public void setSortType(ElementNode sortType)
	{
		this.sortType = sortType;
		this.rowIndex = 1;
	}
	
	public boolean isAscending()
	{
		return sortType.getName().equals("asc");
	}
	
	public boolean isValidation()
	{
		return isValidation;
	}
	
	public void setValidation(boolean isValidation)
	{
		this.isValidation = isValidation;
	}
	
	// 第X页
	protected int getCurrentPageIndex()
	{
		int rowIndex = getRowIndex();
		int rowCount = getRowCount();
		int totalRowCount = getTotalRowCount();
		
		if (rowCount == 0)
		{
			return 1;
		}
		
		return (rowIndex / rowCount) + (rowIndex % rowCount == 0 ? 0 : 1);
	}
	
	// 当前页有X条
	protected int getCurrentPageRowCount()
	{
		int rowIndex = getRowIndex();
		int rowCount = getRowCount();
		int totalRowCount = getTotalRowCount();
		
		int currentPageIndex = getCurrentPageIndex();
		int totalPageCount = getTotalPageCount();
		if (currentPageIndex == totalPageCount)
		{
			return totalRowCount - (currentPageIndex - 1) * rowCount;
		}
		
		return rowCount;
	}
	
	// 共X页
	protected int getTotalPageCount()
	{
		int rowIndex = getRowIndex();
		int rowCount = getRowCount();
		int totalRowCount = getTotalRowCount();
		
		if (rowCount == 0)
		{
			return 1;
		}
		
		int totalPageCount = (totalRowCount / rowCount) + (totalRowCount % rowCount == 0 ? 0 : 1);
		if (totalPageCount < 1)
		{
			totalPageCount = 1;
		}
		
		return totalPageCount;
	}
	
	/*
	 * 01.A 06.F 11.K 16.P 21.U 26.Z 02.B 07.G 12.L 17.Q 22.V 03.C 08.H 13.M
	 * 18.R 23.W 04.D 09.I 14.N 19.S 24.X 05.E 10.J 15.O 20.T 25.Y
	 */
	public static void main(String[] args)
	{
		PaginationContext context = new PaginationContext(26);
		context.setRowIndex(16); // P
		context.setRowCount(5);
		// context.setTotalRowCount(26);
		
		System.out.println(context.getCurrentPageIndex());
		System.out.println(context.getCurrentPageRowCount());
		System.out.println(context.getTotalPageCount());
	}
}