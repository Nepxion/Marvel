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

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractListModel;

public class BasicListModel
	extends AbstractListModel
{
	/**
	 * The row datas.
	 */
	private Vector rowDatas;
	
	/**
	 * Constructs with the default.
	 */
	public BasicListModel()
	{
		this(null);
	}
	
	/**
	 * Constructs with the specified initial row datas.
	 * @param rowDatas the instance of Vector
	 */
	public BasicListModel(Vector rowDatas)
	{
		if (rowDatas != null)
		{
			this.rowDatas = rowDatas;
		}
		else
		{
			this.rowDatas = new Vector();
		}
	}
	
	/**
	 * Gets the row datas.
	 * @return the instance of Vector
	 */
	public Vector getRowDatas()
	{
		return rowDatas;
	}
	
	/**
	 * Sets the row datas.
	 * @param rowDatas the instance of Vector
	 */
	public void setRowDatas(Vector rowDatas)
	{
		int size = this.rowDatas.size();
		
		this.rowDatas = rowDatas;
		
		fireContentsChanged(this, 0, size);
	}
	
	/**
	 * Gets the size.
	 * @return the size of the row datas.
	 */
	public int getSize()
	{
		return rowDatas.size();
	}
	
	/**
	 * Gets the element by an index.
	 * @param index the index value
	 * @return the row data object
	 */
	public Object getElementAt(int index)
	{
		return rowDatas.elementAt(index);
	}
	
	/**
	 * Copies the array into the row datas.
	 * @param array the copied array
	 */
	public void copyInto(Object[] array)
	{
		rowDatas.copyInto(array);
	}
	
	/**
	 * Trims to size of the row datas.
	 * @return the row datas trimed size
	 */
	public void trimToSize()
	{
		rowDatas.trimToSize();
	}
	
	/**
	 * Ensures the capacity of the row datas.
	 * @param minCapacity the min capacity value
	 */
	public void ensureCapacity(int minCapacity)
	{
		rowDatas.ensureCapacity(minCapacity);
	}
	
	/**
	 * Sets the size for the row datas.
	 * @param newSize the new size value
	 */
	public void setSize(int newSize)
	{
		int oldSize = rowDatas.size();
		rowDatas.setSize(newSize);
		
		if (oldSize > newSize)
		{
			fireIntervalRemoved(this, newSize, oldSize - 1);
		}
		else if (oldSize < newSize)
		{
			fireIntervalAdded(this, oldSize, newSize - 1);
		}
	}
	
	/**
	 * Returns the capacity of the row datas.
	 * @return the capacity of the row datas
	 */
	public int capacity()
	{
		return rowDatas.capacity();
	}
	
	/**
	 * Returns the size of the row datas.
	 * @return the size of the row datas
	 */
	public int size()
	{
		return rowDatas.size();
	}
	
	/**
	 * Returns true if the row datas is empty.
	 * @return true if the row datas is empty
	 */
	public boolean isEmpty()
	{
		return rowDatas.isEmpty();
	}
	
	/**
	 * Gets the elements.
	 * @return the instance of Enumerations
	 */
	public Enumeration elements()
	{
		return rowDatas.elements();
	}
	
	/**
	 * Returns true if the row datas contains the element. 
	 * @param element the element object
	 * @return true if the row datas contains the element
	 */
	public boolean contains(Object element)
	{
		return rowDatas.contains(element);
	}
	
	/**
	 * Gets the index of the element.
	 * @param element the element object
	 * @return the index of element
	 */
	public int indexOf(Object element)
	{
		return rowDatas.indexOf(element);
	}
	
	/**
	 * Gets the index of the element.
	 * @param element the element object
	 * @param index the index value
	 * @return the index of element
	 */
	public int indexOf(Object element, int index)
	{
		return rowDatas.indexOf(element, index);
	}
	
	/**
	 * Gets the last index of the element.
	 * @param element the element object
	 * @return the last index of element 
	 */
	public int lastIndexOf(Object element)
	{
		return rowDatas.lastIndexOf(element);
	}
	
	/**
	 * Gets the last index of the element.
	 * @param element the element object
	 * @param index the index value
	 * @return the last index of element 
	 */
	public int lastIndexOf(Object element, int index)
	{
		return rowDatas.lastIndexOf(element, index);
	}
	
	/**
	 * Gets the element.
	 * @param index the index value
	 * @return the element object
	 */
	public Object elementAt(int index)
	{
		return rowDatas.elementAt(index);
	}
	
	/**
	 * Gets the first element.
	 * @return the element object
	 */
	public Object firstElement()
	{
		return rowDatas.firstElement();
	}
	
	/**
	 * Gets the last element.
	 * @return the element object
	 */
	public Object lastElement()
	{
		return rowDatas.lastElement();
	}
	
	/**
	 * Sets the element.
	 * @param object the element object
	 * @param index the index value
	 */
	public void setElementAt(Object object, int index)
	{
		rowDatas.setElementAt(object, index);
		
		fireContentsChanged(this, index, index);
	}
	
	/**
	 * Removes the element.
	 * @param index the index value
	 */
	public void removeElementAt(int index)
	{
		rowDatas.removeElementAt(index);
		
		fireIntervalRemoved(this, index, index);
	}
	
	/**
	 * Inserts the element.
	 * @param object the element object
	 * @param index the index value
	 */
	public void insertElementAt(Object object, int index)
	{
		rowDatas.insertElementAt(object, index);
		
		fireIntervalAdded(this, index, index);
	}
	
	/**
	 * Adds the element to the row datas.
	 * @param object the element object
	 */
	public void addElement(Object object)
	{
		int index = rowDatas.size();
		rowDatas.addElement(object);
		
		fireIntervalAdded(this, index, index);
	}
	
	/**
	 * Adds the elements to the row datas.
	 * @param objects  the instance of List
	 */
	public void addElements(List objects)
	{
		int index = rowDatas.size();
		rowDatas.addAll(objects);
		
		fireIntervalAdded(this, index, index);
	}
	
	/**
	 * Adds the elements to the row datas.
	 * @param objects the instance of List
	 * @param index the index value
	 */
	public void addElements(List objects, int index)
	{
		rowDatas.addAll(index, objects);
		
		fireIntervalAdded(this, index, index);
	}
	
	/**
	 * Removes the element.
	 * @param object the element object
	 * @return true if removing the element successfully
	 */
	public boolean removeElement(Object object)
	{
		int index = indexOf(object);
		boolean value = rowDatas.removeElement(object);
		
		if (index >= 0)
		{
			fireIntervalRemoved(this, index, index);
		}
		
		return value;
	}
		
	/**
	 * Removes all the elements.
	 */
	public void removeAllElements()
	{
		int index = rowDatas.size() - 1;
		rowDatas.removeAllElements();
		
		if (index >= 0)
		{
			fireIntervalRemoved(this, 0, index);
		}
	}
	
	/**
	 * Limits the element count for the row datas.
	 * @param limitedElementCount the limited element count value 
	 * @param isFromTop the boolean value of isFromTop
	 */
	public void limitElements(int limitedElementCount, boolean isFromTop)
	{
		int rowCount = rowDatas.size();
		if (rowCount > limitedElementCount)
		{
			int deletedCount = rowCount - limitedElementCount;
			int[] deletedRows = new int[deletedCount];
			for (int i = 0; i < deletedCount; i++)
			{
				if (isFromTop)
				{
					deletedRows[i] = i;
				}
				else
				{
					deletedRows[i] = rowCount - i - 1;
				}
			}
			removeElements(deletedRows);
		}
	}
	
	/**
	 * To string.
	 * @return the string
	 */
	public String toString()
	{
		return rowDatas.toString();
	}
	
	/**
	 * Transforms the row datas to the array.
	 * @return the array.
	 */
	public Object[] toArray()
	{
		Object[] array = new Object[rowDatas.size()];
		rowDatas.copyInto(array);
		
		return array;
	}
	
	/**
	 * Gets the element.
	 * @param index the index value.
	 * @return the element object
	 */
	public Object get(int index)
	{
		return rowDatas.elementAt(index);
	}
	
	/**
	 * Sets the element to the row datas.
	 * @param index the index value
	 * @param element the element object
	 * @return the set element object
	 */
	public Object set(int index, Object element)
	{
		Object object = rowDatas.elementAt(index);
		rowDatas.setElementAt(element, index);
		
		fireContentsChanged(this, index, index);
		
		return object;
	}
	
	/**
	 * Adds the element to the row datas.
	 * @param index the index value
	 * @param element the element object
	 */
	public void add(int index, Object element)
	{
		rowDatas.insertElementAt(element, index);
		
		fireIntervalAdded(this, index, index);
	}
	
	/**
	 * Remove the element in the row datas.
	 * @param index the index value.
	 * @return the removed element object
	 */
	public Object remove(int index)
	{
		Object object = rowDatas.elementAt(index);
		rowDatas.removeElementAt(index);
		
		fireIntervalRemoved(this, index, index);
		
		return object;
	}
	
	/**
	 * Removes the elements in the row datas.
	 * @param indexes the index array
	 */
	public void removeElements(int[] indexes)
	{
		List elements = new ArrayList();
		for (int i = 0; i < indexes.length; i++)
		{
			int row = indexes[i];
			Object element = rowDatas.elementAt(row);
			elements.add(element);
		}
		removeElements(elements);
	}
	
	/**
	 * Removes the elements in the row datas.
	 * @param elements the instance of List
	 */
	public void removeElements(List elements)
	{
		int index = rowDatas.size() - 1;
		
		rowDatas.removeAll(elements);
		
		if (index >= 0)
		{
			fireIntervalRemoved(this, 0, index);
		}
	}
	
	/**
	 * Clears the row datas.
	 */
	public void clear()
	{
		int index = rowDatas.size() - 1;
		rowDatas.removeAllElements();
		
		if (index >= 0)
		{
			fireIntervalRemoved(this, 0, index);
		}
	}
	
	/**
	 * Removes the range.
	 * @param fromIndex the form index value
	 * @param toIndex the to index value
	 */
	public void removeRange(int fromIndex, int toIndex)
	{
		if (fromIndex > toIndex)
		{
			throw new IllegalArgumentException("fromIndex must be <= toIndex");
		}
		for (int i = toIndex; i >= fromIndex; i--)
		{
			rowDatas.removeElementAt(i);
		}
		
		fireIntervalRemoved(this, fromIndex, toIndex);
	}
	
	/**
	 * Moves the row up by an row index.
	 * @param index the row index value
	 */
	public void moveUp(int index)
	{
		if (index <= 0)
		{
			return;
		}	
		
		Object object = rowDatas.elementAt(index);
		
		rowDatas.remove(index);
		rowDatas.add(index - 1, object);
		
		fireContentsChanged(this, index - 1, index);
	}
	
	/**
	 * Moves the row down by an row index.
	 * @param index the row index value
	 */
	public void moveDown(int index)
	{
		if (index >= rowDatas.size() - 1)
		{
			return;
		}	
		
		Object object = rowDatas.elementAt(index);
		
		rowDatas.remove(index);
		rowDatas.add(index + 1, object);
		
		fireContentsChanged(this, index, index + 1);
	}	
}