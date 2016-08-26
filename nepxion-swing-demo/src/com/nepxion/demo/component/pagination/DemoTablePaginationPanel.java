package com.nepxion.demo.component.pagination;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.pagination.PaginationBar;
import com.nepxion.swing.pagination.PaginationContext;
import com.nepxion.swing.table.JBasicTable;

public class DemoTablePaginationPanel
	extends JPanel
{
	public DemoTablePaginationPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new TablePaginationPanel());
	}
	
	public class TablePaginationPanel
		extends JPanel
	{
		public TablePaginationPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Table Pagination"));			
		}
	}
	
	public static class DemoPaginationBar
		extends PaginationBar
	{
		public DemoPaginationBar(JBasicTable table)
		{
			super(table, new PaginationContext());
		}
		
		public String[] getSortNameList()
		{
			return new String[] {"Name", "Value"};
		}
				
		public void directRowIndex(int rowIndex)
			throws Exception
		{
			JBasicTable table = (JBasicTable) getTable();
			
			direct(table);
		}
		
		public void directRowCount(int rowCount)
			throws Exception
		{
			JBasicTable table = (JBasicTable) getTable();
			
			PaginationContext paginationContext = getPaginationContext();
			paginationContext.setRowCount(rowCount);
			
			direct(table);
		}
		
		private void direct(JTable table)
			throws Exception
		{
			PaginationContext paginationContext = getPaginationContext();
			paginationContext.setTotalRowCount(10000); // 10000是数据库的总记录数
			
			int rowIndex = paginationContext.getRowIndex();
			int rowCount = paginationContext.getRowCount();
			
//			List pageList = DataBase.getPageList(rowIndex, rowCount);			
//			table.setRowDatas(drList);
			
			updatePagination();
		}
		
		public void sort(ElementNode sortName, ElementNode sortType)
			throws Exception
		{
			
		}
		
		public void clearRowDatas()
			throws Exception
		{
			JBasicTable table = (JBasicTable) getTable();			
		}
	}
}