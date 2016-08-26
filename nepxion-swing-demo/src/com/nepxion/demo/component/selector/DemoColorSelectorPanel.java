package com.nepxion.demo.component.selector;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.demo.common.DemoSelectionValuePanel;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.icon.paint.ColorCombinationIcon;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.selector.color.JBasicColorSelectorButton;
import com.nepxion.swing.selector.color.JColorSelectorDialog;

public class DemoColorSelectorPanel
	extends JPanel
{
	private DemoSelectionValuePanel selectionValuePanel;
	
	public DemoColorSelectorPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		selectionValuePanel = new DemoSelectionValuePanel();
		
		add(new ColorSelectorPanel());
		add(selectionValuePanel);
	}
	
	public class ColorSelectorPanel
		extends JPanel
	{
		public ColorSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Color Selector"));
			
			final JBasicButton dialogStyleButton = new JBasicButton("Dialog Style", new ColorCombinationIcon(IconFactory.getContextIcon("paragraph_background.png"), Color.white), "Dialog Style");
			dialogStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					final JColorSelectorDialog dialog = new JColorSelectorDialog(HandleManager.getFrame(DemoColorSelectorPanel.this))
					{
						public void executeSelection(Color color)
						{
							ColorCombinationIcon colorCombinationIcon = (ColorCombinationIcon) dialogStyleButton.getIcon();
							colorCombinationIcon.setFillColor(color);
							
							dialogStyleButton.repaint();
							
							selectionValuePanel.setValue(color != null ? color.toString() : "null");
						}
					};
					
					dialog.setVisible(true);
					dialog.dispose();
				}
			}
			);
			add(dialogStyleButton);
			
			JBasicColorSelectorButton popupMenuStyleButton = new JBasicColorSelectorButton("PopupMenu Style", new ColorCombinationIcon(IconFactory.getContextIcon("paragraph_background.png"), Color.white), "PopupMenu Style")
			{
				public void executeSelection(Color color)
				{
					selectionValuePanel.setValue(color != null ? color.toString() : "null");
				}
				
			};
			add(popupMenuStyleButton);
			
			ButtonManager.updateUI(this);
		}
	}
}