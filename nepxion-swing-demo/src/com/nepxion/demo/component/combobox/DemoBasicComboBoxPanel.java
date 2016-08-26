package com.nepxion.demo.component.combobox;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.checkbox.JBasicCheckBox;
import com.nepxion.swing.combobox.JBasicComboBox;
import com.nepxion.swing.layout.filed.FiledLayout;

public class DemoBasicComboBoxPanel
	extends JPanel
{
	private JBasicComboBox comboBox;
	
	public DemoBasicComboBoxPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new BasicComboBoxPanel());
		add(new ConfigPanel());
	}
	
	public class BasicComboBoxPanel
		extends JPanel
	{
		public BasicComboBoxPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Basic ComboBox"));
			
			String[] items = new String[] {"The standard JComboBox doesn't support the long width for combobox's popupmenu", "The popupmenu item width is only determinded by combobox width", "The JBasicComboBox will help you to resolve the issue.You can set its length by api"};
			comboBox = new JBasicComboBox(items);
			comboBox.setMaximumSize(new Dimension(350, comboBox.getPreferredSize().height));
			comboBox.setPopupMenuWidth(500);
			comboBox.setPopupMenuShownUp(true);	
			add(comboBox);
		}
	}
	
	public class ConfigPanel
		extends JPanel
	{
		public ConfigPanel()
		{
			setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
			setBorder(BorderManager.createComplexTitledBorder("Configuration"));
			
			final JBasicCheckBox popupMenuWithCheckBox = new JBasicCheckBox("Set PopupMenu width (=500)", "Set PopupMenu width (=500)", true);
			popupMenuWithCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					comboBox.setPopupMenuWidth(popupMenuWithCheckBox.isSelected() ? 500 : 0);
				}				
			}
			);				
			add(popupMenuWithCheckBox);		
			
			final JBasicCheckBox popupMenuShowUpCheckBox = new JBasicCheckBox("Show PopupMenu Up", "Show PopupMenu Up", true);
			popupMenuShowUpCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					comboBox.setPopupMenuShownUp(popupMenuShowUpCheckBox.isSelected());
				}				
			}
			);				
			add(popupMenuShowUpCheckBox);				
		}
	}
}