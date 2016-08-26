package com.nepxion.swing.selector.file;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Component;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.File;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JRootPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.FileChooserUI;
import javax.swing.plaf.basic.BasicFileChooserUI;
import javax.swing.text.JTextComponent;

import com.nepxion.swing.listener.SelectionListener;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;

public class JBasicFileChooser
	extends JFileChooser
{
	private JDialog dialog;
	private Component parentComponent;
	
	public JBasicFileChooser(Component parentComponent)
	{
		super();
		
		this.parentComponent = parentComponent;
	}
	
	public JBasicFileChooser(Component parentComponent, String currentDirectoryPath)
	{
		super(currentDirectoryPath);
		
		this.parentComponent = parentComponent;
	}
	
	public JBasicFileChooser(Component parentComponent, File currentDirectory)
	{
		super(currentDirectory);
		
		this.parentComponent = parentComponent;
	}
	
	public JBasicFileChooser(Component parentComponent, FileSystemView fsv)
	{
		super(fsv);
		
		this.parentComponent = parentComponent;
	}
	
	public JBasicFileChooser(Component parentComponent, File currentDirectory, FileSystemView fsv)
	{
		super(currentDirectory, fsv);
		
		this.parentComponent = parentComponent;
	}
	
	public JBasicFileChooser(Component parentComponent, String currentDirectoryPath, FileSystemView fsv)
	{
		super(currentDirectoryPath, fsv);
		
		this.parentComponent = parentComponent;
	}
	
	protected JDialog createDialog(Component parent)
		throws HeadlessException
	{
		dialog = super.createDialog(parent);
		
		verifyFileFilterComboBox();
		verifyApprovalButton();
		
		return dialog;
	}
	
	public void approveSelection()
	{
		super.approveSelection();
		
		if (getDialogType() != SAVE_DIALOG)
		{
			File file = getSelectedFile();
			if (!file.exists())
			{
				JBasicOptionPane.showMessageDialog(parentComponent, getType() + SwingLocale.getString("file_error_not_existed"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
				dialog.setVisible(true);
			}
		}
	}
	
	public void verifyFileFilterComboBox()
	{		
		Container container = (Container) getComponent(getComponentCount() - 1);
		
		Container textFieldContainer = (Container) container.getComponent(0);
		Component textFieldComponent = textFieldContainer.getComponent(textFieldContainer.getComponentCount() - 1);
		
		Container comboBoxContainer = (Container) container.getComponent(container.getComponentCount() - 2);
		Component comboBoxComponent = comboBoxContainer.getComponent(1);
		
		if (comboBoxComponent instanceof JComboBox && textFieldComponent instanceof JTextComponent)
		{
			final JTextComponent textField = (JTextComponent) textFieldComponent;
			JComboBox comboBox = (JComboBox) comboBoxComponent;
			comboBox.addItemListener(new SelectionListener()
			{
				public void itemSelectionStateChanged(ItemEvent e)
				{
					String fileName = textField.getText();
					if (fileName.lastIndexOf(".") > -1)
					{	
						fileName = fileName.substring(0, fileName.lastIndexOf("."));
					}
					
					String fileSuffix = getFileSuffix();					
					textField.setText(fileSuffix != null ? fileName + "." + fileSuffix : fileName);
				}
			}
			);
		}	
	}
	
	public void verifyApprovalButton()
	{
		Container container = (Container) getComponent(getComponentCount() - 1);
		Container buttonContainer = (Container) container.getComponent(container.getComponentCount() - 1);
		Component approvalButtonComponent = buttonContainer.getComponent(0);
		
		if (approvalButtonComponent instanceof JButton)
		{
			JButton approvalButton = (JButton) approvalButtonComponent;
			
			JRootPane rootPane = getRootPane();
			if (rootPane != null)
			{
				rootPane.setDefaultButton(approvalButton);
			}
			
			boolean isActionListener = false;
			ActionListener[] actionListeners = approvalButton.getActionListeners();
			for (int i = 0; i < actionListeners.length; i++)
			{
				ActionListener actionListener = actionListeners[i];
				if (actionListener instanceof ApprovalActionListener)
				{
					isActionListener = true;
					break;
				}
			}
			
			if (!isActionListener)
			{	
				approvalButton.addActionListener(new ApprovalActionListener());
			}
		}
	}
	
	public Component getParentComponent()
	{
		return parentComponent;
	}
	
	public String getFileSuffix()
	{
		FileFilter fileFilter = getFileFilter();
		if (fileFilter instanceof JFileFilter)
		{	
			List filterWords = ((JFileFilter) fileFilter).getWords();
		
			return filterWords.get(0).toString();
		}
		
		return null;
	}
	
	public String getType()
	{
		String type = null;
		
		int fileSelectionMode = getFileSelectionMode();
		switch (fileSelectionMode)
		{
			case FILES_ONLY :
				type = SwingLocale.getString("file");
				break;
			case DIRECTORIES_ONLY :
				type = SwingLocale.getString("directory");
				break;
			case FILES_AND_DIRECTORIES :
				type = SwingLocale.getString("file_or_directory");
				break;
			default :
				type = SwingLocale.getString("file_or_directory");
				break;
		}
		
		return type;
	}
	
	public class ApprovalActionListener
		implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			FileChooserUI fileChooserUI = getUI();
			if (fileChooserUI instanceof BasicFileChooserUI)
			{
				BasicFileChooserUI basicFileChooserUI = (BasicFileChooserUI) fileChooserUI;
				String fileName = basicFileChooserUI.getFileName();
				if (fileName == null || fileName.trim().equals(""))
				{
					JBasicOptionPane.showMessageDialog(parentComponent, getType() + SwingLocale.getString("name_not_null"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}
}