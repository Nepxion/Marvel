package com.nepxion.swing.table.layoutable;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

public interface TableCellRendererConstants
{
	// 自适应尺寸设置
	// 1. 当设置单元格的宽度时候，需比较表格单元格绘制器CellRenderer和表格头单元绘制器的宽度，取最大值，设置单元格的宽度
	// 2. 当设置单元格的高度时候，取表格单元格绘制器CellRenderer的高度，设置单元格的高度
	public static final int PREFERRED = -1;
	
	// 不进行尺寸设置
	public static final int IGNORE = -2;
	
	// 部署模式设置
	public static final String ROW_COLUMN_LAYOUT_MODE = "rowColumnLayoutMode"; 
	public static final String ROW_LAYOUT_MODE = "rowLayoutMode";
	public static final String COLUMN_LAYOUT_MODE = "columnLayoutMode";
	
	// 尺寸设置
	public static final int COLUMN_WIDTH_GAP = 20;
	public static final int LOW_ROW_HEIGHT_GAP = -4;
	public static final int HIHG_ROW_HEIGHT_GAP = 5;
	public static final int HIGH_ROW_HEIGHT = 24;
}