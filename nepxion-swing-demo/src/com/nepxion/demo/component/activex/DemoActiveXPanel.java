package com.nepxion.demo.component.activex;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.activex.ActiveXManager;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.checkbox.JBasicCheckBox;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.selector.file.JFileFilter;
import com.nepxion.swing.selector.file.JFileSelector;
import com.nepxion.swing.textfield.JBasicTextField;
import com.nepxion.util.data.CollectionUtil;

public class DemoActiveXPanel
	extends JPanel
{
	public DemoActiveXPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new CallWebToolBar());
		add(new CallWordToolBar());
		add(new CallExcelToolBar());
		add(new CallPowerPointToolBar());	
	}
	
	public class CallWebToolBar
		extends JPanel
	{
		public CallWebToolBar()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Call Web"));
			
			final JBasicTextField textField = new JBasicTextField("http://www.google.com");
			textField.setBackground(Color.white);
			add(textField);
			
			JBasicButton selectorButton = new JBasicButton(IconFactory.getSwingIcon("theme/filechooser/nimbus/up_folder.png"), "Open Web File");
			selectorButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					List webFilterWords = CollectionUtil.parseList(new String[] {"html", "htm"});
					String webFilterDescription = "Web File(*.html, *.htm)";
					JFileFilter webFileFilter = new JFileFilter(webFilterWords, webFilterDescription);
					
					List htmlFilterWords = CollectionUtil.parseList(new String[] {"html"});
					String htmlFilterDescription = "Web File(*.html)";
					JFileFilter htmlFileFilter = new JFileFilter(htmlFilterWords, htmlFilterDescription);
					
					List htmFilterWords = CollectionUtil.parseList(new String[] {"htm"});
					String htmFilterDescription = "Web File(*.htm)";
					JFileFilter htmFileFilter = new JFileFilter(htmFilterWords, htmFilterDescription);
					
					JFileSelector fileSelector = new JFileSelector(HandleManager.getFrame(DemoActiveXPanel.this), "Open Web File");
					fileSelector.addChoosableFileFilter(webFileFilter);
					fileSelector.addChoosableFileFilter(htmlFileFilter);
					fileSelector.addChoosableFileFilter(htmFileFilter);
					fileSelector.setFileFilter(webFileFilter);
					
					File file = fileSelector.openFile();
					if (file != null)
					{
						textField.setText(file.getAbsolutePath());
					}
				}
			}
			);
			add(selectorButton);
			
			JBasicButton callButton = new JBasicButton(IconFactory.getSwingIcon("property.png"), "Call Web");
			callButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						ActiveXManager.callWeb(DemoActiveXPanel.this, textField.getText());
					}
					catch (Exception ex)
					{
						ex.printStackTrace();
					}
				}
			}
			);
			add(callButton);
			
			ButtonManager.updateUI(this);
		}
	}
	
	public class CallWordToolBar
		extends JPanel
	{
		public CallWordToolBar()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Call Word File - Only supported in application"));
			
			final JBasicTextField textField = new JBasicTextField();
			textField.setBackground(Color.white);
			add(textField);
			
			final JBasicCheckBox readOnlyCheckBox = new JBasicCheckBox("Read Only");
			add(readOnlyCheckBox);
			
			JBasicButton selectorButton = new JBasicButton(IconFactory.getSwingIcon("theme/filechooser/nimbus/up_folder.png"), "Open Word File");
			selectorButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					List filterWords = CollectionUtil.parseList(new String[] {"doc"});
					String filterDescription = "Word File(*.doc)";
					JFileFilter fileFilter = new JFileFilter(filterWords, filterDescription);
					
					JFileSelector fileSelector = new JFileSelector(HandleManager.getFrame(DemoActiveXPanel.this), "Open Word File");
					fileSelector.addChoosableFileFilter(fileFilter);
					fileSelector.setFileFilter(fileFilter);
					
					File file = fileSelector.openFile();
					if (file != null)
					{
						textField.setText(file.getAbsolutePath());
					}
				}
			}
			);
			add(selectorButton);
			
			JBasicButton callButton = new JBasicButton(IconFactory.getSwingIcon("property.png"), "Call Word File");
			callButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						ActiveXManager.callWord(DemoActiveXPanel.this, textField.getText(), readOnlyCheckBox.isSelected());
					}
					catch (Exception ex)
					{
						ex.printStackTrace();
					}
				}
			}
			);
			add(callButton);
			
			ButtonManager.updateUI(this);
		}
	}
	
	public class CallExcelToolBar
		extends JPanel
	{
		public CallExcelToolBar()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Call Excel File - Only supported in application"));
			
			final JBasicTextField textField = new JBasicTextField();
			textField.setBackground(Color.white);
			add(textField);
			
			final JBasicCheckBox readOnlyCheckBox = new JBasicCheckBox("Read Only");
			add(readOnlyCheckBox);
			
			JBasicButton selectorButton = new JBasicButton(IconFactory.getSwingIcon("theme/filechooser/nimbus/up_folder.png"), "Open Excel File");
			selectorButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					List excelFilterWords = CollectionUtil.parseList(new String[] {"xls", "csv"});
					String excelFilterDescription = "Excel File(*.xls, *.csv)";
					JFileFilter excelFileFilter = new JFileFilter(excelFilterWords, excelFilterDescription);
					
					List xlsFilterWords = CollectionUtil.parseList(new String[] {"xls"});
					String xlsFilterDescription = "Excel File(*.xls)";
					JFileFilter xlsFileFilter = new JFileFilter(xlsFilterWords, xlsFilterDescription);
					
					List csvFilterWords = CollectionUtil.parseList(new String[] {"csv"});
					String csvFilterDescription = "Excel File(*.csv)";
					JFileFilter csvFileFilter = new JFileFilter(csvFilterWords, csvFilterDescription);

					JFileSelector fileSelector = new JFileSelector(HandleManager.getFrame(DemoActiveXPanel.this), "Open Excel File");
					fileSelector.addChoosableFileFilter(excelFileFilter);
					fileSelector.addChoosableFileFilter(xlsFileFilter);
					fileSelector.addChoosableFileFilter(csvFileFilter);
					fileSelector.setFileFilter(excelFileFilter);

					File file = fileSelector.openFile();
					if (file != null)
					{
						textField.setText(file.getAbsolutePath());
					}
				}
			}
			);
			add(selectorButton);
			
			JBasicButton callButton = new JBasicButton(IconFactory.getSwingIcon("property.png"), "Call Excel File");
			callButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						ActiveXManager.callExcel(DemoActiveXPanel.this, textField.getText(), readOnlyCheckBox.isSelected());
					}
					catch (Exception ex)
					{
						ex.printStackTrace();
					}
				}
			}
			);
			add(callButton);
			
			ButtonManager.updateUI(this);
		}
	}
	
	public class CallPowerPointToolBar
		extends JPanel
	{
		public CallPowerPointToolBar()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Call PowerPoint File - Only supported in application"));
			
			final JBasicTextField textField = new JBasicTextField();
			textField.setBackground(Color.white);
			add(textField);

			final JBasicCheckBox readOnlyCheckBox = new JBasicCheckBox("Read Only");
			add(readOnlyCheckBox);
			
			final JBasicCheckBox fullScreenCheckBox = new JBasicCheckBox("Full Screen");
			add(fullScreenCheckBox);
			
			JBasicButton selectorButton = new JBasicButton(IconFactory.getSwingIcon("theme/filechooser/nimbus/up_folder.png"), "Open PowerPoint File");
			selectorButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					List filterWords = CollectionUtil.parseList(new String[] {"ppt"});
					String filterDescription = "PowerPoint File(*.ppt)";
					JFileFilter fileFilter = new JFileFilter(filterWords, filterDescription);
					
					JFileSelector fileSelector = new JFileSelector(HandleManager.getFrame(DemoActiveXPanel.this), "Open PowerPoint File");
					fileSelector.addChoosableFileFilter(fileFilter);
					fileSelector.setFileFilter(fileFilter);
					
					File file = fileSelector.openFile();
					if (file != null)
					{
						textField.setText(file.getAbsolutePath());
					}
				}
			}
			);
			add(selectorButton);
			
			JBasicButton callButton = new JBasicButton(IconFactory.getSwingIcon("property.png"), "Call PowerPoint File");
			callButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						ActiveXManager.callPowerPoint(DemoActiveXPanel.this, textField.getText(), readOnlyCheckBox.isSelected(), fullScreenCheckBox.isSelected());
					}
					catch (Exception ex)
					{
						ex.printStackTrace();
					}
				}
			}
			);
			add(callButton);
			
			ButtonManager.updateUI(this);
		}
	}	
}