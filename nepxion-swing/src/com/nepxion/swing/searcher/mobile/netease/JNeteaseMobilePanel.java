package com.nepxion.swing.searcher.mobile.netease;

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

public class JNeteaseMobilePanel
	extends JPanel
{
	/**
	 * The mobile text field.
	 */
	private JBasicTextField textField;
	
	/**
	 * The netease mobile table.
	 */
	private JNeteaseMobileTable table;
	
	/**
	 * Constructs with the default.
	 */
	public JNeteaseMobilePanel()
	{
		table = new JNeteaseMobileTable();
		
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
			
			textField = new JBasicTextField();
			DimensionManager.setDimension(textField, new Dimension(150, 23));
			
			JBasicButton searchButton = new JBasicButton(NeteaseMobileController.getSearchAction(JNeteaseMobilePanel.this));
			JBasicButton clearButton = new JBasicButton(NeteaseMobileController.getClearAction(table));
			
			add(new JLabel(SwingLocale.getString("mobile")));
			add(textField);
			
			add(searchButton);
			add(clearButton);
			
			add(Box.createHorizontalGlue());
			
			ButtonManager.updateUI(this);
		}
	}
	
	/**
	 * Gets the mobile table.
	 * @return the instance of JNeteaseMobileTable
	 */
	public JNeteaseMobileTable getMobileTable()
	{
		return table;
	}
	
	/**
	 * Gets the mobile.
	 * @return the moble string
	 */
	public String getMobile()
	{
		return textField.getText().trim();
	}
	
	/**
	 * Sets the mobile.
	 * @param mobile the mobile string
	 */
	public void setMobile(String mobile)
	{
		textField.setText(mobile);
	}
}