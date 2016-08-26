package com.nepxion.demo.component.searchable;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.text.Position;
import javax.swing.tree.TreePath;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.searchable.JSearchableContainer;
import com.nepxion.swing.searchable.JSearchableFactory;

public class DemoSearchableTreePanel
	extends JPanel
{
	public DemoSearchableTreePanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new SearchableTreePanel());
	}
	
	public class SearchableTreePanel
		extends JPanel
	{
		public SearchableTreePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Searchable Tree"));
			
			add(createTree());
			add(createTreeContainer());	
		}
	}
	
    private JScrollPane createTree()
    {
        JTree tree = new JTree()
        {
            public TreePath getNextMatch(String prefix, int startingRow, Position.Bias bias)
            {
                return null;
            }
        };

        JSearchableFactory.installSearchable(tree);
        return new JScrollPane(tree);
    }

    private JSearchableContainer createTreeContainer()
    {
        JTree tree = new JTree()
        {
            public TreePath getNextMatch(String prefix, int startingRow, Position.Bias bias)
            {
                return null;
            }
        };

        JSearchableContainer container = new JSearchableContainer();
        container.add(new JScrollPane(tree));

        JSearchableFactory.installSearchableBar(tree, container);
        return container;
    }	
}