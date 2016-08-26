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
	// ����Ӧ�ߴ�����
	// 1. �����õ�Ԫ��Ŀ��ʱ����Ƚϱ��Ԫ�������CellRenderer�ͱ��ͷ��Ԫ�������Ŀ�ȣ�ȡ���ֵ�����õ�Ԫ��Ŀ��
	// 2. �����õ�Ԫ��ĸ߶�ʱ��ȡ���Ԫ�������CellRenderer�ĸ߶ȣ����õ�Ԫ��ĸ߶�
	public static final int PREFERRED = -1;
	
	// �����гߴ�����
	public static final int IGNORE = -2;
	
	// ����ģʽ����
	public static final String ROW_COLUMN_LAYOUT_MODE = "rowColumnLayoutMode"; 
	public static final String ROW_LAYOUT_MODE = "rowLayoutMode";
	public static final String COLUMN_LAYOUT_MODE = "columnLayoutMode";
	
	// �ߴ�����
	public static final int COLUMN_WIDTH_GAP = 20;
	public static final int LOW_ROW_HEIGHT_GAP = -4;
	public static final int HIHG_ROW_HEIGHT_GAP = 5;
	public static final int HIGH_ROW_HEIGHT = 24;
}