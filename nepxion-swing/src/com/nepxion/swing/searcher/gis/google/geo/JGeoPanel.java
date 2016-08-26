package com.nepxion.swing.searcher.gis.google.geo;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.layout.toolbar.ToolBarLayout;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.textfield.JBasicTextField;

public class JGeoPanel
	extends JPanel
{
	/**
	 * The address text field.
	 */
	private JBasicTextField addressTextField;
	
	/**
	 * The geo table.
	 */
	private JGeoTable table;
	
	/**
	 * Constructs with the default.
	 */
	public JGeoPanel()
	{
		table = new JGeoTable();
		
		setLayout(new BorderLayout());
		add(new ToolBar(), BorderLayout.NORTH);
		add(new JBasicScrollPane(table), BorderLayout.CENTER);
	}
	
	public class ToolBar
		extends JPanel
	{
		/**
		 * Constructs with the default.
		 */
		public ToolBar()
		{
			setLayout(new ToolBarLayout());
			setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
			
			addressTextField = new JBasicTextField();
			DimensionManager.setDimension(addressTextField, new Dimension(180, 23));
			
			JBasicButton searchButton = new JBasicButton(GeoController.getSearchAction(JGeoPanel.this));			
			JBasicButton clearButton = new JBasicButton(GeoController.getClearAction(table));
			
			add(new JLabel(SwingLocale.getString("address")));
			add(addressTextField);
			
			add(searchButton);
			add(clearButton);
			
			add(Box.createHorizontalGlue());
			
			ButtonManager.updateUI(this);
		}
	}
	
	/**
	 * Gets the geo table.
	 * @return the instance of JGeoTable
	 */
	public JGeoTable getGeoTable()
	{
		return table;
	}
	
	/**
	 * Gets the address.
	 * @return the address string
	 */
	public String getAddress()
	{
		return addressTextField.getText().trim();
	}
	
	/**
	 * Sets the address.
	 * @param address the address string
	 */
	public void setAddress(String address)
	{
		addressTextField.setText(address.trim());
	}
}