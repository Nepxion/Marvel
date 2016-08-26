package com.nepxion.demo.component.selector;

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
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.demo.common.DemoDataFactory;
import com.nepxion.demo.common.DemoSelectionValuePanel;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.selector.checkbox.JCheckBoxSelector;

public class DemoCheckBoxSelectorPanel
	extends JPanel
{
	private DemoSelectionValuePanel selectionValuePanel;
	
	public DemoCheckBoxSelectorPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		selectionValuePanel = new DemoSelectionValuePanel();
		
		add(new CheckBoxSelectorPanel());
		add(selectionValuePanel);
	}
	
	public class CheckBoxSelectorPanel
		extends JPanel
	{
		public CheckBoxSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("CheckBox Selector"));
			
			JBasicButton checkBoxSelectorButton = new JBasicButton("CheckBox Selector", IconFactory.getSwingIcon("component/check_box_16.png"), "CheckBox Selector");
			checkBoxSelectorButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{					
					JCheckBoxSelector checkBoxSelector = new JCheckBoxSelector(HandleManager.getFrame(DemoCheckBoxSelectorPanel.this), "Selection", DemoDataFactory.getComponentElementNodes());
					checkBoxSelector.setVisible(true);
					checkBoxSelector.dispose();
					
					if (checkBoxSelector.isConfirmed())
					{	
						String value = "";
						for (Iterator iterator = checkBoxSelector.getSelectedElementNodes().iterator(); iterator.hasNext();)
						{
							value += iterator.next() + ";";
						}
						selectionValuePanel.setValue(value);
					}
				}
			}
			);
			add(checkBoxSelectorButton);
			
			ButtonManager.updateUI(this);
		}
	}
}