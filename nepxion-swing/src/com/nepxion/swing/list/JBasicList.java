package com.nepxion.swing.list;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.nepxion.util.data.CollectionUtil;

public class JBasicList
	extends JList implements IList, ListSelectionListener, MouseListener
{
	/**
	 * The selected index value.
	 */
	private int selectedIndex = -1;
	
	/**
	 * Constructs with the default.
	 */
	public JBasicList()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial list model.
	 * @param listModel the instance of BasicListModel
	 */
	public JBasicList(BasicListModel listModel)
	{
		super(listModel);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial list data array.
	 * @param listData the list data array
	 */
	public JBasicList(Object[] listData)
	{
		setListData(listData);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial list data.
	 * @param listData the instance of Vector
	 */
	public JBasicList(Vector listData)
	{
		setListData(listData);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		ListManager.setPreferenceStyle(this);
		
		addMouseListener(this);
		addListSelectionListener(this);
	}
	
	/**
	 * Gets the list data.
	 * @return the instance of Vector
	 */
	public Vector getListData()
	{
		BasicListModel listModel = (BasicListModel) getModel();
		
		return listModel.getRowDatas();
	}
	
	/**
	 * Sets the list data.
	 * @param listData the list data array.
	 */
	public void setListData(Object[] listData)
	{
		Vector rowDatas = CollectionUtil.parseVector(listData);
		setListData(rowDatas);
	}
	
	/**
	 * Sets the list data.
	 * @param listData the instance of Vector
	 */
	public void setListData(Vector listData)
	{
		ListModel model = getModel();
		if (model instanceof BasicListModel)
		{
			BasicListModel listModel = (BasicListModel) model;
			listModel.setRowDatas(listData);
		}
		else
		{
			BasicListModel listModel = new BasicListModel(listData);
			setModel(listModel);
		}
	}
	
	/**
	 * Gets the selected index array.
	 * @return the selected index array
	 */
	public int[] getSelectedIndexes()
	{
		BasicListModel listModel = (BasicListModel) getModel();
		
		Object[] selectedValues = getSelectedValues();
		int[] selectedIndexes = new int[selectedValues.length];
		
		for (int i = 0; i < selectedValues.length; i++)
		{
			Object object = selectedValues[i];
			
			int index = listModel.indexOf(object);
			
			selectedIndexes[i] = index;
		}
		
		return selectedIndexes;
	}
	
	/**
	 * Moves the row up by an row index.
	 * @param index the row index value
	 */
	public void moveUp(int index)
	{		
		BasicListModel listModel = (BasicListModel) getModel();
		
		if (index > 0)
		{		
			listModel.moveUp(index);
			
			setSelectedIndex(index - 1);
		}
	}
	
	/**
	 * Moves the row down by an row index.
	 * @param index the row index value
	 */
	public void moveDown(int index)
	{		
		BasicListModel listModel = (BasicListModel) getModel();
		
		if (index > -1 && index < listModel.size() - 1)
		{
			listModel.moveDown(index);
			
			setSelectedIndex(index + 1);
		}
	}
	
	/**
	 * Gets the index by a point.
	 * @param point the instance of Point
	 * @return the index value
	 */
	public int getIndex(Point point)
	{
		return ListManager.getIndex(this, point);
	}
	
	/**
	 * Invoked when the selection value is changed.
	 * @param e the instance of ListSelectionEvent
	 */
	public void valueChanged(ListSelectionEvent e)
	{
		int[] selectedRows = getSelectedIndexes();
		
		if (selectedRows.length == 0)
		{
			boolean isAdjusting = e.getValueIsAdjusting();
			if (isAdjusting)
			{
				int oldSelectedRow = selectedIndex;
				int newSelectedRow = -1;
				selectedIndex = -1;
				
				executeSelection(oldSelectedRow, newSelectedRow);
			}
		}
		else if (selectedRows.length == 1)
		{
			if (getSelectedIndex() == selectedIndex)
			{
				return;
			}
						
			selectedIndex = getSelectedIndex();
			
			int oldSelectedRow = -1;
			int newSelectedRow = -1;
			
			int firstIndex = e.getFirstIndex();
			int lastIndex = e.getLastIndex();
			
			if (e.getFirstIndex() == e.getLastIndex())
			{
				newSelectedRow = selectedIndex;
			}
			else if (e.getFirstIndex() == selectedIndex)
			{
				oldSelectedRow = lastIndex;
				newSelectedRow = firstIndex;
			}
			else if (e.getLastIndex() == selectedIndex)
			{
				oldSelectedRow = firstIndex;
				newSelectedRow = lastIndex;
			}
			else
			{
				oldSelectedRow = -1;
				newSelectedRow = selectedIndex;
			}
			
			executeSelection(oldSelectedRow, newSelectedRow);
		}
	}
	
	/**
	 * Executes the selection.
	 * @param oldSelectedRow the old selected row index value
	 * @param newSelectedRow the new selected row index value
	 */
	public void executeSelection(int oldSelectedRow, int newSelectedRow)
	{

	}
	
	/**
	 * Invoked when the mouse button has been clicked (pressed and released) on a component.
	 * @param e the instance of MouseEvent
	 */
	public void mouseClicked(MouseEvent e)
	{
		int selectedRow = getSelectedIndex();
		
		executeClicked(selectedRow, e);
	}
	
	/**
	 * Executes the mouse clicked event when a row selected.
	 * @param selectedRow the selected row index value
	 * @param e the instance of MouseEvent
	 */
	public void executeClicked(int selectedRow, MouseEvent e)
	{
		if (e.getClickCount() > 1)
		{
			executeDoubleClicked(selectedRow);
		}
		else
		{
			executeClicked(selectedRow);
		}
	}
	
	/**
	 * Executes the mouse clicked event when a row selected.
	 * @param selectedRow the selected row index value
	 */
	public void executeClicked(int selectedRow)
	{
		
	}
	
	/**
	 * Executes the mouse double-clicked event when a row selected.
	 * @param selectedRow the selected row index value
	 */
	public void executeDoubleClicked(int selectedRow)
	{
		
	}
		
	/**
	 * Invoked when the mouse button has been pressed on a component.
	 * @param e the instance of MouseEvent
	 */
	public void mousePressed(MouseEvent e)
	{
		
	}
	
	/**
	 * Invoked when the mouse button has been released on a component.
	 * @param e the instance of MouseEvent
	 */
	public void mouseReleased(MouseEvent e)
	{
		if (!e.isPopupTrigger())
		{
			return;
		}
		
		int x = e.getX();
		int y = e.getY();
		
		int selectedRow = getSelectedIndex();
		if (selectedRow > -1)
		{
			executePopupMenu(selectedRow, x, y);
		}
		else
		{
			executePopupMenu(x, y);
		}
	}
	
	/**
	 * Executes the popup menu shown when a row selected.
	 * @param selectedRow the selected row index value
	 * @param x the x value
	 * @param y the y value
	 */
	public void executePopupMenu(int selectedRow, int x, int y)
	{
		
	}
	
	/**
	 * Executes the popup menu shown.
	 * @param x the x value
	 * @param y the y value
	 */
	public void executePopupMenu(int x, int y)
	{
		
	}
	
	/**
	 * Invoked when the mouse enters a component.
	 * @param e the instance of MouseEvent
	 */
	public void mouseEntered(MouseEvent e)
	{
		
	}
	
	/**
	 * Invoked when the mouse exits a component.
	 * @param e the instance of MouseEvent
	 */
	public void mouseExited(MouseEvent e)
	{
		
	}
}