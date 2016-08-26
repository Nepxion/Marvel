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
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import com.nepxion.demo.common.DemoSelectionValuePanel;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.button.JBasicMenuButton;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.menuitem.JBasicRadioButtonMenuItem;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;
import com.nepxion.swing.selector.calendar.JCalendarSelector;
import com.nepxion.swing.selector.calendar.JCalendarSelectorDialog;
import com.nepxion.swing.selector.calendar.JCalendarSelectorOptionPane;
import com.nepxion.swing.selector.calendar.JCalendarSelectorPopupMenu;
import com.nepxion.swing.selector.calendar.JDateSelector;
import com.nepxion.swing.selector.calendar.JDateSelectorDialog;
import com.nepxion.swing.selector.calendar.JDateSelectorOptionPane;
import com.nepxion.swing.selector.calendar.JDateSelectorPopupMenu;
import com.nepxion.swing.selector.calendar.JDateTimeSelector;
import com.nepxion.swing.selector.calendar.JDateTimeSelectorDialog;
import com.nepxion.swing.selector.calendar.JDateTimeSelectorOptionPane;
import com.nepxion.swing.selector.calendar.JDateTimeSelectorPopupMenu;
import com.nepxion.swing.selector.calendar.JDaySelector;
import com.nepxion.swing.selector.calendar.JDaySelectorDialog;
import com.nepxion.swing.selector.calendar.JDaySelectorOptionPane;
import com.nepxion.swing.selector.calendar.JDaySelectorPopupMenu;
import com.nepxion.swing.selector.calendar.JMonthSelector;
import com.nepxion.swing.selector.calendar.JMonthSelectorDialog;
import com.nepxion.swing.selector.calendar.JMonthSelectorOptionPane;
import com.nepxion.swing.selector.calendar.JMonthSelectorPopupMenu;
import com.nepxion.swing.selector.calendar.JTimeSelector;
import com.nepxion.swing.selector.calendar.JTimeSelectorDialog;
import com.nepxion.swing.selector.calendar.JTimeSelectorOptionPane;
import com.nepxion.swing.selector.calendar.JTimeSelectorPopupMenu;
import com.nepxion.swing.selector.calendar.JYearSelector;
import com.nepxion.swing.selector.calendar.JYearSelectorDialog;
import com.nepxion.swing.selector.calendar.JYearSelectorOptionPane;
import com.nepxion.swing.selector.calendar.JYearSelectorPopupMenu;
import com.nepxion.swing.selector.calendar.editor.JSpinnerDateTimeEditor;

public class DemoCalendarSelectorPanel
	extends JPanel
{
	private DemoSelectionValuePanel selectionValuePanel;
	
	public DemoCalendarSelectorPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		selectionValuePanel = new DemoSelectionValuePanel();
		
		add(new CalendarSelectorPanel());
		add(new DateTimeSelectorPanel());
		add(new DateSelectorPanel());
		add(new YearSelectorPanel());
		add(new MonthSelectorPanel());
		add(new DaySelectorPanel());
		add(new TimeSelectorPanel());
		add(selectionValuePanel);
	}
	
	public class CalendarSelectorPanel
		extends JPanel
	{
		public CalendarSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Calendar Selector"));
						
			JBasicButton dialogStyleButton = createDialogStyleButton();
			dialogStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{										
					final JCalendarSelectorDialog dialog = new JCalendarSelectorDialog(HandleManager.getFrame(DemoCalendarSelectorPanel.this), new JCalendarSelector())
					{
						public boolean confirm()
						{
							Date date = getCalendarSelector().getDate();
							if (date == null)
							{
								return false;
							}	
							
							selectionValuePanel.setValue(date.toString());
							
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
					JCalendarSelectorOptionPane optionPane = new JCalendarSelectorOptionPane(HandleManager.getFrame(DemoCalendarSelectorPanel.this), new JCalendarSelector());
					int selectedValue = optionPane.showCalendarDialog();
					if (selectedValue == JCalendarSelectorOptionPane.OK_OPTION)
					{
						Date date = optionPane.getCalendarSelector().getDate();
						if (date == null)
						{
							return;
						}	
						selectionValuePanel.setValue(date.toString());
					}
				}
			}
			);			
			add(optionPaneStyleButton);
			
			JBasicButton popupMenuStyleButton = createPopupMenuStyleButton();	
			JCalendarSelectorPopupMenu popupMenu = new JCalendarSelectorPopupMenu(new JCalendarSelector(), popupMenuStyleButton)
			{
				public boolean confirm()
				{
					Date date = getCalendarSelector().getDate();
					if (date == null)
					{
						return false;
					}	
					
					selectionValuePanel.setValue(date.toString());
					
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
	
	public class DateTimeSelectorPanel
		extends FormatPanel
	{		
		public DateTimeSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Date Time Selector"));
			
			JBasicButton dialogStyleButton = createDialogStyleButton();
			dialogStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					final JDateTimeSelectorDialog dialog = new JDateTimeSelectorDialog(HandleManager.getFrame(DemoCalendarSelectorPanel.this), new JDateTimeSelector(new Date(), "yyyy-MM-dd HH:mm:ss", new JSpinnerDateTimeEditor()))
					{
						public boolean confirm()
						{
							Date date = getDateTimeSelector().getDate();
							if (date == null)
							{
								return false;
							}
							
							selectionValuePanel.setValue(date.toString());
							
							return true;
						}
						
						public boolean cancel()
						{
							return true;
						}
					};
					dialog.getDateTimeSelector().setDateFormatString(getDateFormat() + " " + getTimeFormat());
					
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
					JDateTimeSelectorOptionPane optionPane = new JDateTimeSelectorOptionPane(HandleManager.getFrame(DemoCalendarSelectorPanel.this), new JDateTimeSelector(new Date(), "yyyy-MM-dd HH:mm:ss", new JSpinnerDateTimeEditor()));
					optionPane.getDateTimeSelector().setDateFormatString(getDateFormat() + " " + getTimeFormat());
					int selectedValue = optionPane.showDateTimeDialog();					
					if (selectedValue == JCalendarSelectorOptionPane.OK_OPTION)
					{
						Date date = optionPane.getDateTimeSelector().getDate();
						if (date == null)
						{
							return;
						}	
						
						selectionValuePanel.setValue(date.toString());
					}
				}
			}
			);			
			add(optionPaneStyleButton);
			
			JBasicButton popupMenuStyleButton = createPopupMenuStyleButton();	
			final JDateTimeSelectorPopupMenu popupMenu = new JDateTimeSelectorPopupMenu(new JDateTimeSelector(new Date(), "yyyy-MM-dd HH:mm:ss", new JSpinnerDateTimeEditor()), popupMenuStyleButton)
			{
				public boolean confirm()
				{					
					Date date = getDateTimeSelector().getDate();
					if (date == null)
					{
						return false;
					}	
					
					selectionValuePanel.setValue(date.toString());
					
					return true;
				}
				
				public boolean cancel()
				{
					return true;
				}	
				
				public void showPopupMenu()
				{
					super.showPopupMenu();
					
					getDateTimeSelector().setDateFormatString(getDateFormat() + " " + getTimeFormat());
				}				
			};			
			add(popupMenuStyleButton);				
			
			JBasicMenuButton dateFormatButton = createFormatButton(this, new String[] {"yyyy-MM-dd", "MM/dd/yyyy", "MMMMM d, yyyy", }, true);
			add(dateFormatButton);
			
			JBasicMenuButton timeFormatButton = createFormatButton(this, new String[] {"HH:mm:ss",  "HH:mm:ss:SSS", "hh:mm:ss a", "hh:mm:ss:SSS a"}, false);
			add(timeFormatButton);			
			
			ButtonManager.updateUI(this);
		}
	}	
	
	public class DateSelectorPanel
		extends FormatPanel
	{		
		public DateSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Date Selector"));
		
			JBasicButton dialogStyleButton = createDialogStyleButton();
			dialogStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{					
					final JDateSelectorDialog dialog = new JDateSelectorDialog(HandleManager.getFrame(DemoCalendarSelectorPanel.this), new JDateSelector(new Date(), "yyyy-MM-dd", new JSpinnerDateTimeEditor()))
					{						
						public boolean confirm()
						{													
							Date date = getDateSelector().getDate();
							if (date == null)
							{
								return false;
							}	
							
							selectionValuePanel.setValue(date.toString());
							
							return true;
						}
						
						public boolean cancel()
						{
							return true;
						}						
					};
					dialog.getDateSelector().setDateFormatString(getDateFormat());
					
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
					JDateSelectorOptionPane optionPane = new JDateSelectorOptionPane(HandleManager.getFrame(DemoCalendarSelectorPanel.this), new JDateSelector(new Date(), "yyyy-MM-dd", new JSpinnerDateTimeEditor()));
					optionPane.getDateSelector().setDateFormatString(getDateFormat());
					int selectedValue = optionPane.showDateDialog();					
					if (selectedValue == JCalendarSelectorOptionPane.OK_OPTION)
					{
						Date date = optionPane.getDateSelector().getDate();
						if (date == null)
						{
							return;
						}	
						
						selectionValuePanel.setValue(date.toString());
					}
				}
			}
			);			
			add(optionPaneStyleButton);
			
			JBasicButton popupMenuStyleButton = createPopupMenuStyleButton();	
			final JDateSelectorPopupMenu popupMenu = new JDateSelectorPopupMenu(new JDateSelector(new Date(), "yyyy-MM-dd", new JSpinnerDateTimeEditor()), popupMenuStyleButton)
			{
				public boolean confirm()
				{					
					Date date = getDateSelector().getDate();
					if (date == null)
					{
						return false;
					}	
					
					selectionValuePanel.setValue(date.toString());
					
					return true;
				}
				
				public boolean cancel()
				{
					return true;
				}	
				
				public void showPopupMenu()
				{
					super.showPopupMenu();
					
					getDateSelector().setDateFormatString(getDateFormat());
				}				
			};			
			add(popupMenuStyleButton);			
			
			JBasicMenuButton dateFormatButton = createFormatButton(this, new String[] {"yyyy-MM-dd", "MM/dd/yyyy", "MMMMM d, yyyy"}, true);
			add(dateFormatButton);
			
			ButtonManager.updateUI(this);			
		}
	}

	public class YearSelectorPanel
		extends JPanel
	{
		public YearSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Year Selector"));
			
			JBasicButton dialogStyleButton = createDialogStyleButton();
			dialogStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					final JYearSelectorDialog dialog = new JYearSelectorDialog(HandleManager.getFrame(DemoCalendarSelectorPanel.this), new JYearSelector())
					{
						public boolean confirm()
						{
							int year = getYearSelector().getYear();
							selectionValuePanel.setValue(year + "");
							
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
					JYearSelectorOptionPane optionPane = new JYearSelectorOptionPane(HandleManager.getFrame(DemoCalendarSelectorPanel.this), new JYearSelector());
					int selectedValue = optionPane.showYearDialog();
					if (selectedValue == JCalendarSelectorOptionPane.OK_OPTION)
					{
						int year = optionPane.getYearSelector().getYear();
						selectionValuePanel.setValue(year + "");
					}
				}
			}
			);
			add(optionPaneStyleButton);
			
			JBasicButton popupMenuStyleButton = createPopupMenuStyleButton();
			JYearSelectorPopupMenu popupMenu = new JYearSelectorPopupMenu(new JYearSelector(), popupMenuStyleButton)
			{
				public boolean confirm()
				{
					int year = getYearSelector().getYear();
					selectionValuePanel.setValue(year + "");
					
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
	
	public class MonthSelectorPanel
		extends JPanel
	{
		public MonthSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Month Selector"));
			
			JBasicButton dialogStyleButton = createDialogStyleButton();
			dialogStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					final JMonthSelectorDialog dialog = new JMonthSelectorDialog(HandleManager.getFrame(DemoCalendarSelectorPanel.this), new JMonthSelector())
					{
						public boolean confirm()
						{
							int month = getMonthSelector().getMonth();
							selectionValuePanel.setValue(month + "");
							
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
					JMonthSelectorOptionPane optionPane = new JMonthSelectorOptionPane(HandleManager.getFrame(DemoCalendarSelectorPanel.this), new JMonthSelector());
					int selectedValue = optionPane.showMonthDialog();
					if (selectedValue == JCalendarSelectorOptionPane.OK_OPTION)
					{
						int month = optionPane.getMonthSelector().getMonth();
						selectionValuePanel.setValue(month + "");
					}
				}
			}
			);
			add(optionPaneStyleButton);
			
			JBasicButton popupMenuStyleButton = createPopupMenuStyleButton();
			JMonthSelectorPopupMenu popupMenu = new JMonthSelectorPopupMenu(new JMonthSelector(), popupMenuStyleButton)
			{
				public boolean confirm()
				{
					int month = getMonthSelector().getMonth();
					selectionValuePanel.setValue(month + "");
					
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
	
	public class DaySelectorPanel
		extends JPanel
	{
		public DaySelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Day Selector"));
			
			JBasicButton dialogStyleButton = createDialogStyleButton();
			dialogStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					final JDaySelectorDialog dialog = new JDaySelectorDialog(HandleManager.getFrame(DemoCalendarSelectorPanel.this), new JDaySelector(true))
					{
						public boolean confirm()
						{
							int day = getDaySelector().getDay();
							selectionValuePanel.setValue(day + "");
							
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
					JDaySelectorOptionPane optionPane = new JDaySelectorOptionPane(HandleManager.getFrame(DemoCalendarSelectorPanel.this), new JDaySelector(true));
					int selectedValue = optionPane.showDayDialog();
					if (selectedValue == JCalendarSelectorOptionPane.OK_OPTION)
					{
						int day = optionPane.getDaySelector().getDay();
						selectionValuePanel.setValue(day + "");
					}
				}
			}
			);
			add(optionPaneStyleButton);
			
			JBasicButton popupMenuStyleButton = createPopupMenuStyleButton();
			JDaySelectorPopupMenu popupMenu = new JDaySelectorPopupMenu(new JDaySelector(true), popupMenuStyleButton)
			{
				public boolean confirm()
				{
					int day = getDaySelector().getDay();
					selectionValuePanel.setValue(day + "");
					
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
	
	public class TimeSelectorPanel
		extends FormatPanel
	{		
		public TimeSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Time Selector"));
			
			JBasicButton dialogStyleButton = createDialogStyleButton();
			dialogStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					final JTimeSelectorDialog dialog = new JTimeSelectorDialog(HandleManager.getFrame(DemoCalendarSelectorPanel.this), new JTimeSelector())
					{
						public boolean confirm()
						{
							Date time = getTimeSelector().getTime();
							if (time == null)
							{
								return false;
							}	
							
							selectionValuePanel.setValue(time.toString());
							
							return true;
						}
						
						public boolean cancel()
						{
							return true;
						}
					};
					String dateFormat = getDateFormat().equals("Null") ? "" : getDateFormat();
					String timeFormat = getTimeFormat().equals("Null") ? "" : getTimeFormat();
					dialog.getTimeSelector().setFormat((dateFormat + " " + timeFormat).trim());
					
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
					JTimeSelectorOptionPane optionPane = new JTimeSelectorOptionPane(HandleManager.getFrame(DemoCalendarSelectorPanel.this), new JTimeSelector());
					
					String dateFormat = getDateFormat().equals("Null") ? "" : getDateFormat();
					String timeFormat = getTimeFormat().equals("Null") ? "" : getTimeFormat();
					optionPane.getTimeSelector().setFormat((dateFormat + " " + timeFormat).trim());
					
					int selectedValue = optionPane.showTimeDialog();
					if (selectedValue == JCalendarSelectorOptionPane.OK_OPTION)
					{
						Date time = optionPane.getTimeSelector().getTime();
						if (time == null)
						{
							return;
						}
						
						selectionValuePanel.setValue(time.toString());
					}
				}
			}
			);
			add(optionPaneStyleButton);
			
			JBasicButton popupMenuStyleButton = createPopupMenuStyleButton();
			JTimeSelectorPopupMenu popupMenu = new JTimeSelectorPopupMenu(new JTimeSelector(), popupMenuStyleButton)
			{
				public boolean confirm()
				{
					Date time = getTimeSelector().getTime();
					if (time == null)
					{
						return false;
					}	
					
					selectionValuePanel.setValue(time.toString());
					
					return true;
				}
				
				public boolean cancel()
				{
					return true;
				}
				
				public void showPopupMenu()
				{
					super.showPopupMenu();
					
					String dateFormat = getDateFormat().equals("Null") ? "" : getDateFormat();
					String timeFormat = getTimeFormat().equals("Null") ? "" : getTimeFormat();
					getTimeSelector().setFormat((dateFormat + " " + timeFormat).trim());
				}					
			};
			add(popupMenuStyleButton);				
			
			JBasicMenuButton dateFormatButton = createFormatButton(this, new String[] {"yyyy-MM-dd", "MM/dd/yyyy", "MMMMM d, yyyy", "Null"}, true);
			add(dateFormatButton);
			
			JBasicMenuButton timeFormatButton = createFormatButton(this, new String[] {"HH:mm:ss",  "HH:mm:ss:SSS", "hh:mm:ss a", "hh:mm:ss:SSS a", "Null"}, false);
			add(timeFormatButton);
			
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
		JBasicButton button = new JBasicButton("PopupMenu Style", IconFactory.getSwingIcon("component/popup_menu_16.png"));
		
		return button;
	}	
	
	private JBasicMenuButton createFormatButton(final FormatPanel panel, String[] formatList, final boolean isDateFormat)
	{
		JBasicMenuButton button = new JBasicMenuButton(isDateFormat ? "Date Format" : "Time Format", IconFactory.getSwingIcon("component/button_16.png"), isDateFormat ? "Date Format" : "Time Format");
		
		JBasicPopupMenu popupMenu = new JBasicPopupMenu();
		ButtonGroup buttonGroup = new ButtonGroup();
		for (int i = 0; i < formatList.length; i++)
		{
			final JBasicRadioButtonMenuItem menuItem = new JBasicRadioButtonMenuItem(formatList[i], formatList[i]);
			menuItem.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (isDateFormat)
					{	
						panel.setDateFormat(menuItem.getText());
					}
					else
					{
						panel.setTimeFormat(menuItem.getText());
					}	
				}
			}
			);				
			popupMenu.add(menuItem);
			buttonGroup.add(menuItem);
			if (i == 0)
			{
				menuItem.doClick();
			}
		}		
		button.setPopupMenu(popupMenu);	
		
		return button;
	}
	
	public class FormatPanel
		extends JPanel
	{
		private String dateFormat;
		private String timeFormat;
		
		public FormatPanel()
		{			
		}
		
		public String getDateFormat()
		{
			return dateFormat;
		}
		
		public void setDateFormat(String dateFormat)
		{
			this.dateFormat = dateFormat;
		}
		
		public String getTimeFormat()
		{
			return timeFormat;
		}
		
		public void setTimeFormat(String timeFormat)
		{
			this.timeFormat = timeFormat;
		}		
	}
}