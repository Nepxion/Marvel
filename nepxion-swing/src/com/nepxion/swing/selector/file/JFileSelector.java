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
import java.awt.Dimension;
import java.io.File;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;

import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;

public class JFileSelector
{
	public static final int FILES_ONLY = JBasicFileChooser.FILES_ONLY;
	public static final int DIRECTORIES_ONLY = JBasicFileChooser.DIRECTORIES_ONLY;
	public static final int FILES_AND_DIRECTORIES = JBasicFileChooser.FILES_AND_DIRECTORIES;
	
	private JBasicFileChooser fileChooser;
	private String title;
	
	public JFileSelector(Component parentComponent, String title)
	{
		this.title = title;
		
		fileChooser = new JBasicFileChooser(parentComponent);
		
		initComponents();
	}
	
	public JFileSelector(Component parentComponent, String title, String currentDirectoryPath)
	{
		this.title = title;
		
		fileChooser = new JBasicFileChooser(parentComponent, currentDirectoryPath);
		
		initComponents();
	}
	
	public JFileSelector(Component parentComponent, String title, File currentDirectory)
	{
		this.title = title;
		
		fileChooser = new JBasicFileChooser(parentComponent, currentDirectory);
		
		initComponents();
	}
	
	public JFileSelector(Component parentComponent, String title, FileSystemView fsv)
	{
		this.title = title;
		
		fileChooser = new JBasicFileChooser(parentComponent, fsv);
		
		initComponents();
	}
	
	public JFileSelector(Component parentComponent, String title, File currentDirectory, FileSystemView fsv)
	{
		this.title = title;
		
		fileChooser = new JBasicFileChooser(parentComponent, currentDirectory, fsv);
		
		initComponents();;
	}
	
	public JFileSelector(Component parentComponent, String title, String currentDirectoryPath, FileSystemView fsv)
	{
		this.title = title;
		
		fileChooser = new JBasicFileChooser(parentComponent, currentDirectoryPath, fsv);

		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		fileChooser.setPreferredSize(new Dimension(500, 325));
		fileChooser.setDialogTitle(title);
	}
	
	public void addChoosableFileFilter(FileFilter fileFilter)
	{
		fileChooser.addChoosableFileFilter(fileFilter);
	}
	
	public FileFilter getFileFilter()
	{
		return fileChooser.getFileFilter();
	}
	
	public void setFileFilter(FileFilter fileFilter)
	{
		fileChooser.setFileFilter(fileFilter);
	}
	
	public String getFileSuffix()
	{
		return fileChooser.getFileSuffix();
	}
	
	public JBasicFileChooser getChooser()
	{
		return fileChooser;
	}
	
	public String saveFile(String fileName)
	{
		fileChooser.setFileSelectionMode(FILES_ONLY);
		if (fileName != null)
		{
			String fileSuffix = getFileSuffix();
			if (fileSuffix != null)
			{
				fileName += "." + fileSuffix;
			}	

			fileChooser.setSelectedFile(new File(fileName));
		}
		int returnValue = fileChooser.showSaveDialog(fileChooser.getParentComponent());
		String selectedFilePath = null;
		if (returnValue == JBasicFileChooser.APPROVE_OPTION)
		{
			File file = fileChooser.getSelectedFile();
			if (file.isFile() && file.exists())
			{
				int selectedValue = JBasicOptionPane.showConfirmDialog(fileChooser.getParentComponent(), SwingLocale.getString("file_overwrite"), SwingLocale.getString("information"), JBasicOptionPane.YES_NO_CANCEL_OPTION);
				if (selectedValue == JBasicOptionPane.OK_OPTION)
				{
					selectedFilePath = fileChooser.getSelectedFile().getAbsolutePath();
				}
				else if (selectedValue == JBasicOptionPane.CANCEL_OPTION)
				{
					selectedFilePath = saveFile(fileChooser.getSelectedFile().getAbsolutePath());
				}
			}
			else
			{
				selectedFilePath = fileChooser.getSelectedFile().getAbsolutePath();
			}
		}
		
		return selectedFilePath;
	}
	
	public File openFile()
	{
		fileChooser.setFileSelectionMode(FILES_ONLY);
		File selectedFile = null;
		int returnValue = fileChooser.showOpenDialog(fileChooser.getParentComponent());
		if (returnValue == JBasicFileChooser.APPROVE_OPTION)
		{
			File file = fileChooser.getSelectedFile();
			if (file.exists())
			{
				if (fileChooser.getFileFilter() != null)
				{
					if (fileChooser.getFileFilter().accept(file))
					{
						selectedFile = file;
					}
					else
					{
						JBasicOptionPane.showMessageDialog(fileChooser.getParentComponent(), SwingLocale.getString("file_error_format"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
						selectedFile = openFile();
					}
				}
			}
		}
		
		return selectedFile;
	}
	
	public File openDirectory()
	{
		fileChooser.setFileSelectionMode(DIRECTORIES_ONLY);
		File selectedFile = null;
		int returnValue = fileChooser.showOpenDialog(fileChooser.getParentComponent());
		if (returnValue == JBasicFileChooser.APPROVE_OPTION)
		{
			selectedFile = fileChooser.getSelectedFile();
		}
		
		return selectedFile;
	}
}