package com.nepxion.swing.table;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.tree.TreeSelectionModel;

public interface ITable
{
	public static final int SINGLE_TREE_SELECTION = TreeSelectionModel.SINGLE_TREE_SELECTION;
	public static final int CONTIGUOUS_TREE_SELECTION = TreeSelectionModel.CONTIGUOUS_TREE_SELECTION;
	public static final int DISCONTIGUOUS_TREE_SELECTION = TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION;
	
	public TableModel getModel();
	
	public void setModel(TableModel tableModel);
	
	public int getSelectionMode();
	
	public void setSelectionMode(int mode);
	
	public TableColumn getColumn(int column);
	
	public int getRowIndexToModel(int rowIndex);
	
	public int[] getRowIndexesToModel(int[] rowIndexes);
	
	public int getColumnWidthGap();
	
	public void setColumnWidthGap(int columnWidthGap);
	
	public int getRowHeightGap();
	
	public void setRowHeightGap(int rowHeightGap);
	
	public boolean isAutoLayout();
	
	public void setAutoLayout(boolean isAutoLayout);
	
	public void adaptLayout(String layoutMode);
	
	public void executeSelection(int selectedRow);
	
	public void executeClicked(int selectedRow);
	
	public void executeDoubleClicked(int selectedRow);
	
	public void executePopupMenu(int selectedRow, int x, int y);
	
	public void executePopupMenu(int x, int y);
}