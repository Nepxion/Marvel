package com.nepxion.swing.searcher.id.netease;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.ArrayList;

import javax.swing.DefaultCellEditor;

import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;
import com.nepxion.swing.table.JBasicTable;
import com.nepxion.swing.textfield.JBasicTextField;

public class JNeteaseIDTable
	extends JBasicTable
{
	/**
	 * The instance of JBasicPopupMenu.
	 */
	private JBasicPopupMenu popupMenu;
	
	/**
	 * Constructs with the default.
	 */	
	public JNeteaseIDTable()
	{
		super(new NeteaseIDTableModel(new ArrayList()));
		
		JBasicTextField textField = new JBasicTextField();
		for (int i = 0; i < getColumnCount(); i++)
		{
			getColumn(i).setCellEditor(new DefaultCellEditor(textField));
		}
		
		popupMenu = new JBasicPopupMenu();
		JBasicMenuItem clearMenuItem = new JBasicMenuItem(NeteaseIDController.getClearAction(this));
		popupMenu.add(clearMenuItem);
	}
	
	/**
	 * Executes the popup menu.
	 * @param selectedRow the selected row index value
	 * @param x the x value
	 * @param y the y value
	 */
	public void executePopupMenu(int selectedRow, int x, int y)
	{
		popupMenu.show(this, x, y);
	}
	
	/**
	 * Executes the popup menu.
	 * @param x the x value
	 * @param y the y value
	 */
	public void executePopupMenu(int x, int y)
	{
		popupMenu.show(this, x, y);
	}
}