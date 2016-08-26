package com.nepxion.swing.table.columnconfig;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.PopupMenuEvent;

import com.nepxion.swing.button.JClassicButton;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.selector.button.JBasicSelectorMenuButton;
import com.nepxion.swing.selector.checkbox.JCheckBoxListPanel;

public class JColumnConfigBasicButton
	extends JBasicSelectorMenuButton
{
	private JColumnConfigListPanel columnConfigListPanel;
	
	public JColumnConfigBasicButton(JTable table)
	{
		super(SwingLocale.getString("column_config"), IconFactory.getSwingIcon("table_selection.png"), SwingLocale.getString("column_config"));
		
		columnConfigListPanel = new JColumnConfigListPanel(table);
		
		setContentPane(columnConfigListPanel);
		
		JPanel buttonContainer = getOptionButtonPanel().getContainer();
		
		JClassicButton selectAllButton = new JClassicButton(SwingLocale.getString("select_all"), IconFactory.getSwingIcon("stereo/redo_16.png"), SwingLocale.getString("select_all"));
		selectAllButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				columnConfigListPanel.adaptListFacade(JCheckBoxListPanel.SELECT_ALL);
			}
		}
		);
		buttonContainer.add(selectAllButton, 0);
		
		JClassicButton selectReverseButton = new JClassicButton(SwingLocale.getString("select_reverse"), IconFactory.getSwingIcon("stereo/undo_16.png"), SwingLocale.getString("select_reverse"));
		selectReverseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				columnConfigListPanel.adaptListFacade(JCheckBoxListPanel.SELECT_REVERSE);
			}
		}
		);
		buttonContainer.add(selectReverseButton, 1);
		
		buttonContainer.add(Box.createHorizontalStrut(5), 2);
	}
	
	public void popupMenuWillBecomeVisible(PopupMenuEvent e)
	{
		super.popupMenuWillBecomeVisible(e);
		
		columnConfigListPanel.updateListFacade();
	}
	
	public boolean confirm()
	{
		columnConfigListPanel.updateTableFacade();
		
		return true;
	}
	
	public boolean cancel()
	{
		return true;
	}
}