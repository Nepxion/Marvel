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

import java.io.File;

import javax.swing.filechooser.FileSystemView;

import com.jidesoft.swing.FolderChooser;

public class JFolderSelector
	extends FolderChooser
{
	/**
	 * Constructs with the default.
	 */
	public JFolderSelector()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial current directory path.
	 * @param currentDirectoryPath
	 */
	public JFolderSelector(String currentDirectoryPath)
	{
		super(currentDirectoryPath);
	}
	
	public JFolderSelector(File currentDirectory)
	{
		super(currentDirectory);
	}
	
	public JFolderSelector(FileSystemView fsv)
	{
		super(fsv);
	}
	
	public JFolderSelector(File currentDirectory, FileSystemView fsv)
	{
		super(currentDirectory, fsv);
	}
	
	public JFolderSelector(String currentDirectoryPath, FileSystemView fsv)
	{
		super(currentDirectoryPath, fsv);
	}
}