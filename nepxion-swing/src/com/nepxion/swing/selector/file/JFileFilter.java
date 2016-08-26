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
import java.util.List;

import javax.swing.filechooser.FileFilter;

public class JFileFilter
	extends FileFilter
{
	private List filterWords;
	private String filterDescription;
	
	public JFileFilter(List filterWords, String filterDescription)
	{
		this.filterWords = filterWords;
		this.filterDescription = filterDescription;
	}
	
	public boolean accept(File file)
	{
		boolean accept = file.isDirectory();
		if (!accept)
		{
			String suffix = getSuffix(file);
			if (filterWords != null && suffix != null)
			{
				accept = filterWords.contains(suffix);
			}
		}
		
		return accept;
	}
	
	public List getWords()
	{
		return filterWords;
	}
	
	public String getDescription()
	{
		return filterDescription;
	}
	
	public String getSuffix(File file)
	{
		String path = file.getPath();
		String suffix = null;
		int index = path.lastIndexOf('.');
		if (index > 0 && index < path.length() - 1)
		{
			suffix = path.substring(index + 1).toLowerCase();
		}
		
		return suffix;
	}
}