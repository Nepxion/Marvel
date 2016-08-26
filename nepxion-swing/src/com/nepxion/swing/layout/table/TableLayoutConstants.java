package com.nepxion.swing.layout.table;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

/**
 * TableLayoutConstants define the constants used by all the TableLayout
 * classes.
 *
 * @version 3.0 February 15, 2004
 * @author  Daniel E. Barbalace
 */

public interface TableLayoutConstants
{
	/** Indicates that the component is left justified in its cell */
	public static final int LEFT = 0;
	
	/** Indicates that the component is top justified in its cell */
	public static final int TOP = 0;
	
	/** Indicates that the component is centered in its cell */
	public static final int CENTER = 1;
	
	/** Indicates that the component is full justified in its cell */
	public static final int FULL = 2;
	
	/** Indicates that the component is bottom justified in its cell */
	public static final int BOTTOM = 3;
	
	/** Indicates that the component is right justified in its cell */
	public static final int RIGHT = 3;
	
	/** Indicates that the component is leading justified in its cell.
	    Leading justification means components are left justified if their container
	    is left-oriented and right justified if their container is right-oriented.
	    Trailing justification is opposite.
	    see java.awt.Component#getComponentOrientation */ 
	public static final int LEADING = 4;
	
	/** Indicates that the component is trailing justified in its cell.
	    Trailing justification means components are right justified if their
	    container is left-oriented and left justified if their container is
	    right-oriented. Leading justification is opposite.
	    see java.awt.Component#getComponentOrientation */ 
	public static final int TRAILING = 5;
	
	/** Indicates that the row/column should fill the available space */
	public static final double FILL = -1.0;
	
	/** Indicates that the row/column should be allocated just enough space to
	    accommodate the preferred size of all components contained completely within
	    this row/column. */
	public static final double PREFERRED = -2.0;
	
	/** Indicates that the row/column should be allocated just enough space to
	    accommodate the minimum size of all components contained completely within
	    this row/column. */
	public static final double MINIMUM = -3.0;
}