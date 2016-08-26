package com.nepxion.swing.searcher.ip.tencent;

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

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.layout.toolbar.ToolBarLayout;
import com.nepxion.swing.scrollpane.JBasicScrollPane;

public class JTencentIPPanel
	extends JPanel
{
	/**
	 * The tencent ip table.
	 */
	private JTencentIPTable table;
	
	/**
	 * Constructs with the default.
	 */
	public JTencentIPPanel()
	{
		table = new JTencentIPTable();
		
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
			
			JBasicButton searchButton = new JBasicButton(TencentIPController.getSearchAction(JTencentIPPanel.this));
			JBasicButton clearButton = new JBasicButton(TencentIPController.getClearAction(table));
			
			add(searchButton);
			add(clearButton);
			
			add(Box.createHorizontalGlue());
			
			ButtonManager.updateUI(this);
		}
	}
	
	/**
	 * Gets the ip table.
	 * @return the instance of JTencentIPTable
	 */
	public JTencentIPTable getIPTable()
	{
		return table;
	}
}