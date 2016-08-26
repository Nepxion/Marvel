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
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.demo.common.DemoDataFactory;
import com.nepxion.demo.common.DemoSelectionValuePanel;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.selector.radiobutton.JMultiRadioButtonSelector;
import com.nepxion.swing.selector.radiobutton.JRadioButtonSelector;

public class DemoRadioButtonSelectorPanel
	extends JPanel
{
	private DemoSelectionValuePanel selectionValuePanel;
	
	public DemoRadioButtonSelectorPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		selectionValuePanel = new DemoSelectionValuePanel();
		
		add(new RadioButtonSelectorPanel());
		add(new MultiRadioButtonSelectorPanel());
		add(selectionValuePanel);
	}
	
	public class RadioButtonSelectorPanel
		extends JPanel
	{
		public RadioButtonSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("RadioButton Selector"));
			
			JBasicButton radioButtonSelectorButton = new JBasicButton("RadioButton Selector", IconFactory.getSwingIcon("component/radio_button_16.png"), "RadioButton Selector");
			radioButtonSelectorButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{					
					JRadioButtonSelector radioButtonSelector = new JRadioButtonSelector(HandleManager.getFrame(DemoRadioButtonSelectorPanel.this), "Selection", DemoDataFactory.getComponentElementNodes());
					radioButtonSelector.setVisible(true);
					radioButtonSelector.dispose();
					
					if (radioButtonSelector.isConfirmed())
					{	
						if (radioButtonSelector.getSelectedElementNode() != null)
						{	
							selectionValuePanel.setValue(radioButtonSelector.getSelectedElementNode().toString());
						}
					}
				}
			}
			);
			add(radioButtonSelectorButton);
			
			ButtonManager.updateUI(this);
		}
	}
	
	public class MultiRadioButtonSelectorPanel
		extends JPanel
	{
		public MultiRadioButtonSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Multi RadioButton Selector"));
			
			JBasicButton radioButtonSelectorButton = new JBasicButton("Multi RadioButton Selector", IconFactory.getSwingIcon("component/radio_button_16.png"), "RadioButton Selector");
			radioButtonSelectorButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JMultiRadioButtonSelector radioButtonSelector = new JMultiRadioButtonSelector(HandleManager.getFrame(DemoRadioButtonSelectorPanel.this), "Selection", DemoDataFactory.getComponentElementNodes());
					radioButtonSelector.setVisible(true);
					radioButtonSelector.dispose();
					
					if (radioButtonSelector.isConfirmed())
					{
						StringBuffer stringBuffer = new StringBuffer();
						
						List allElementNodes = radioButtonSelector.getAllElementNodes();
						for (Iterator iterator = allElementNodes.iterator(); iterator.hasNext();)
						{
							IElementNode elementNode = (IElementNode) iterator.next();
							String text = null;
							int selectedIndex = elementNode.getSelectedIndex();
							switch (selectedIndex)
							{
								case IElementNode.SELECTION_INDEX_IGNORED :
								{
									text = "";
									break;
								}
								case IElementNode.SELECTION_INDEX_CONTAINED :
								{
									text = elementNode.getText();
									break;
								}
								case IElementNode.SELECTION_INDEX_NOT_CONTAINED :
								{
									text = "!" + elementNode.getText();
									break;
								}
							}
							
							if (!text.equals(""))
							{	
								stringBuffer.append(text + ",");
							}
						}
						
						String content = stringBuffer.toString();
						if (stringBuffer.lastIndexOf(",") > -1)
						{	
							content = content.substring(0, stringBuffer.lastIndexOf(","));
						}
						selectionValuePanel.setValue(content);
					}
				}
			}
			);
			add(radioButtonSelectorButton);
			
			ButtonManager.updateUI(this);
		}
	}
}