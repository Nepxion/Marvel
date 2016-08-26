package com.nepxion.swing.list.toggle;

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

import com.nepxion.swing.list.BasicListModel;
import com.nepxion.swing.list.JBasicList;
import com.nepxion.swing.toggle.IToggleContentPanel;

public class JToggleList
	extends JBasicList implements IToggleList
{
	/**
	 * The toggle mode value.
	 */
	private int toggleMode = TOGGLE_MODE_SELECTED;
	
	/**
	 * The instance of IToggleContentPanel.
	 */
	private IToggleContentPanel toggleContentPanel;
	
	/**
	 * The instance of IToggleAdapter.
	 */
	private IToggleAdapter toggleAdapter;
	
	/**
	 * Constructs with the default.
	 */
	public JToggleList()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial list model.
	 * @param listModel the instance of BasicListModel
	 */
	public JToggleList(BasicListModel listModel)
	{
		super(listModel);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial list data array.
	 * @param listData the list data array
	 */
	public JToggleList(Object[] listData)
	{
		setListData(listData);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial list data.
	 * @param listData the instance of Vector
	 */
	public JToggleList(Vector listData)
	{
		setListData(listData);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{

	}
	
	/**
	 * Gets the toggle mode.
	 * @return the toggle mode value
	 */
	public int getToggleMode()
	{
		return toggleMode;
	}
	
	/**
	 * Sets the toggle mode.
	 * @param toggleMode the toggle mode value
	 */
	public void setToggleMode(int toggleMode)
	{
		this.toggleMode = toggleMode;
	}
	
	/**
	 * Gets the toggle content panel.
	 * @return the instance of IToggleContentPanel
	 */
	public IToggleContentPanel getToggleContentPanel()
	{
		return toggleContentPanel;
	}
	
	/**
	 * Sets the toggle content panel.
	 * @param toggleContentPanel the instance of IToggleContentPanel
	 */
	public void setToggleContentPanel(IToggleContentPanel toggleContentPanel)
	{
		this.toggleContentPanel = toggleContentPanel;
	}
	
	/**
	 * Gets the toggle adapter.
	 * @return the instance of IToggleAdapter
	 */
	public IToggleAdapter getToggleAdapter()
	{
		return toggleAdapter;
	}
	
	/**
	 * Gets the toggle adapter.
	 * @return the instance of IToggleAdapter
	 */
	public void setToggleAdapter(IToggleAdapter toggleAdapter)
	{
		this.toggleAdapter = toggleAdapter;
	}
	
	/**
	 * Executes the selection.
	 * @param oldSelectedRow the old selected row index value
	 * @param newSelectedRow the new selected row index value
	 */
	public void executeSelection(int oldSelectedRow, int newSelectedRow)
	{
		if (toggleMode == TOGGLE_MODE_SELECTED)
		{
			toggleAdapter.toggle(oldSelectedRow, newSelectedRow);
		}
	}
	
	/**
	 * Executes the mouse clicked event when a row selected.
	 * @param selectedRow the selected row index value
	 */
	public void executeClicked(int selectedRow)
	{
		if (toggleMode == TOGGLE_MODE_CLICKED)
		{
			toggleAdapter.toggle(-1, selectedRow);
		}
	}
	
	/**
	 * Executes the mouse double-clicked event when a row selected.
	 * @param selectedRow the selected row index value
	 */
	public void executeDoubleClicked(int selectedRow)
	{
		if (toggleMode == TOGGLE_MODE_DOUBLE_CLICKED)
		{
			toggleAdapter.toggle(-1, selectedRow);
		}
	}
}