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
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.demo.common.DemoSelectionValuePanel;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.selector.locale.JLocaleSelector;
import com.nepxion.swing.selector.locale.JLocaleSelectorDialog;
import com.nepxion.swing.selector.locale.JLocaleSelectorOptionPane;
import com.nepxion.swing.selector.locale.JLocaleSelectorPopupMenu;

public class DemoLocaleSelectorPanel
	extends JPanel
{
	private DemoSelectionValuePanel selectionValuePanel;
	
	public DemoLocaleSelectorPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		selectionValuePanel = new DemoSelectionValuePanel();
		
		add(new LocaleSelectorPanel());
		add(selectionValuePanel);
	}
	
	public class LocaleSelectorPanel
		extends JPanel
	{
		public LocaleSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Locale Selector"));
			
			JBasicButton dialogStyleButton = createDialogStyleButton();
			dialogStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					final JLocaleSelectorDialog dialog = new JLocaleSelectorDialog(HandleManager.getFrame(DemoLocaleSelectorPanel.this), new JLocaleSelector())
					{
						public boolean confirm()
						{
							Locale locale = getLocaleSelector().getLocale();
							if (locale == null)
							{
								return false;
							}
							
							selectionValuePanel.setValue(locale.toString());
							
							return true;
						}
						
						public boolean cancel()
						{							
							return true;
						}
					};
					
					dialog.setVisible(true);
					dialog.dispose();
				}
			}
			);
			add(dialogStyleButton);
			
			JBasicButton optionPaneStyleButton = createOptionPaneStyleButton();
			optionPaneStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JLocaleSelectorOptionPane optionPane = new JLocaleSelectorOptionPane(HandleManager.getFrame(DemoLocaleSelectorPanel.this), new JLocaleSelector());
					int selectedValue = optionPane.showLocaleDialog();
					if (selectedValue == JLocaleSelectorOptionPane.OK_OPTION)
					{
						Locale locale = optionPane.getLocaleSelector().getLocale();
						if (locale == null)
						{
							return;
						}
						
						selectionValuePanel.setValue(locale.toString());
					}
				}
			}
			);
			add(optionPaneStyleButton);
			
			JBasicButton popupMenuStyleButton = createPopupMenuStyleButton();
			JLocaleSelectorPopupMenu popupMenu = new JLocaleSelectorPopupMenu(new JLocaleSelector(), popupMenuStyleButton)
			{
				public boolean confirm()
				{
					Locale locale = getLocaleSelector().getLocale();
					if (locale == null)
					{
						return false;
					}
					
					selectionValuePanel.setValue(locale.toString());
					
					return true;
				}
				
				public boolean cancel()
				{
					return true;
				}
			};
			add(popupMenuStyleButton);
			
			ButtonManager.updateUI(this);
		}
	}
	
	private JBasicButton createDialogStyleButton()
	{
		JBasicButton button = new JBasicButton("Dialog Style", IconFactory.getSwingIcon("component/dialog_16.png"), "Dialog Style");
		
		return button;
	}
	
	private JBasicButton createOptionPaneStyleButton()
	{
		JBasicButton button = new JBasicButton("OptionPane Style", IconFactory.getSwingIcon("component/option_pane_16.png"), "OptionPane Style");
		
		return button;
	}
	
	private JBasicButton createPopupMenuStyleButton()
	{
		JBasicButton button = new JBasicButton("PopupMenu Style", IconFactory.getSwingIcon("component/popup_menu_16.png"), "PopupMenu Style");	
		
		return button;
	}	
}