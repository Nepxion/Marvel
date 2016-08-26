package com.nepxion.swing.searchable;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.text.JTextComponent;

import com.jidesoft.swing.NullPanel;
import com.jidesoft.swing.Searchable;
import com.jidesoft.swing.SearchableBar;

public class JSearchableFactory
{
	/**
	 * Installs the searchable for a tree.
	 * @param tree the instance of JTree
	 * @return the instance of JTreeSearchable
	 */
	public static JTreeSearchable installSearchable(JTree tree)
	{
		JTreeSearchable treeSearchable = new JTreeSearchable(tree);
		treeSearchable.setRepeats(true);
		treeSearchable.setRecursive(true);
		
		return treeSearchable;
	}
	
	/**
	 * Installs the searchable for a table.
	 * @param table the instance of JTable
	 * @return the instance of JTableSearchable
	 */
	public static JTableSearchable installSearchable(JTable table)
	{
		JTableSearchable tableSearchable = new JTableSearchable(table);
		tableSearchable.setRepeats(true);
		
		return tableSearchable;
	}
	
	/**
	 * Installs the searchable for a list.
	 * @param list the instance of JList
	 * @return the instance of JListSearchable
	 */
	public static JListSearchable installSearchable(JList list)
	{
		JListSearchable listSearchable = new JListSearchable(list);
		listSearchable.setRepeats(true);
		
		return listSearchable;
	}
	
	/**
	 * Installs the searchable for a combo box.
	 * @param comboBox the instance of JComboBox
	 * @return the instance of JComboBoxSearchable
	 */
	public static JComboBoxSearchable installSearchable(JComboBox comboBox)
	{
		JComboBoxSearchable comboBoxSearchable = new JComboBoxSearchable(comboBox);
		comboBoxSearchable.setRepeats(true);
		
		return comboBoxSearchable;
	}
	
	/**
	 * Installs the searchable for a text component.
	 * @param textComponent the instance of JTextComponent
	 * @return the instance of JTextComponentSearchable
	 */
	public static JTextComponentSearchable installSearchable(JTextComponent textComponent)
	{
		JTextComponentSearchable textComponentSearchable = new JTextComponentSearchable(textComponent);
		textComponentSearchable.setRepeats(true);
		
		return textComponentSearchable;
	}
	
	/**
	 * Uninstalls the searchable.
	 * @param searchable the instance of Searchable
	 */
	public static void uninstallSearchable(Searchable searchable)
	{
		searchable.uninstallListeners();
	}

    /**
     * Install the searchable bar.
     * @param component the instance of JComponent
     * @param searchableContainer the instance of JSearchableContainer
     */
    public static void installSearchableBar(JComponent component, JSearchableContainer searchableContainer)
    {
        installSearchableBar(component, searchableContainer, false);
    }
	
	/**
	 * Install the searchable bar.
	 * @param component the instance of JComponent
	 * @param searchableContainer the instance of JSearchableContainer
	 * @param disableEscKeyboard the flag of disableEscKeyboard. If true, it maybe has minor bugs
	 */
	public static void installSearchableBar(JComponent component, final JSearchableContainer searchableContainer, boolean disableEscKeyboard)
	{
		Searchable searchable = null;
		if (component instanceof JTree)
		{
			searchable = installSearchable((JTree) component);
		}
		else if (component instanceof JTable)
		{
			searchable = installSearchable((JTable) component);
		}
		else if (component instanceof JList)
		{
			searchable = installSearchable((JList) component);
		}
		else if (component instanceof JComboBox)
		{
			searchable = installSearchable((JComboBox) component);
		}
		else if (component instanceof JTextComponent)
		{
			searchable = installSearchable((JTextComponent) component);
		}
		
		if (searchable == null)
		{
			return;
		}
		
		searchable.setRepeats(true);
		SearchableBar searchableBar = SearchableBar.install(searchable, KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_MASK), new SearchableBar.Installer()
		{
			public void openSearchBar(SearchableBar searchableBar)
			{
				searchableContainer.show(searchableBar);
			}
			
			public void closeSearchBar(SearchableBar searchableBar)
			{
				searchableContainer.hide(searchableBar);
			}
		}
		);
		
		if (disableEscKeyboard) 
		{
		    NullPanel nullPanel = (NullPanel) searchableBar.getComponent(5);
		    JTextField textField = (JTextField) nullPanel.getComponent(0);
		    textField.unregisterKeyboardAction(KeyStroke.getKeyStroke(27, 0));
		}
	}
}