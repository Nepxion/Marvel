package com.nepxion.demo.component.thread;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.selector.file.JFileSelector;
import com.nepxion.swing.table.BasicTableModel;
import com.nepxion.swing.table.JBasicTable;
import com.nepxion.swing.textfield.JBasicTextField;
import com.nepxion.swing.thread.dialog.JThreadDialog;
import com.nepxion.util.data.CollectionUtil;
import com.nepxion.util.time.TimeUtil;

public class DemoThreadDialoglPanel
	extends JPanel
{
	private FileSystemView fileSystemView = FileSystemView.getFileSystemView();
	private File file;
	
	public DemoThreadDialoglPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new ThreadDialoglPanel());
	}
	
	public class ThreadDialoglPanel
		extends JPanel
	{
		public ThreadDialoglPanel()
		{
			setLayout(new BorderLayout());
			setBorder(BorderManager.createComplexTitledBorder("File Loader"));
			
			JBasicTable fileTable = new JBasicTable(new FileTableModel(new ArrayList()));
			
			FileToolBar fileTooBar = new FileToolBar(fileTable);
			
			setLayout(new BorderLayout());
			add(fileTooBar, BorderLayout.NORTH);
			add(new JBasicScrollPane(fileTable), BorderLayout.CENTER);
		}
	}
	
	public class FileTableModel
		extends BasicTableModel
	{
		public FileTableModel(List rowDatas)
		{
			super(rowDatas, new String[] {"File Name", "Last Modified Time", "Directory Or File", "Length", "Can Read", "Can Write"});
		}
		
		public Object getValueAt(int row, int column)
		{
			File file = (File) rowDatas.get(row);
			
			switch (column)
			{
				case 0 :
					return file.getName();
				case 1 :
					return TimeUtil.getDateTime(new Date(file.lastModified())) ;
				case 2 :
					return file.isFile() ? "File" : "Directory";
				case 3 :
					return file.length();					
				case 4 :
					return file.canRead() ? "Yes" : "No";
				case 5 :
					return file.canWrite() ? "Yes" : "No";	
				case 6 :
					return file.canWrite() ? "Yes" : "No";			
			}
			
			return null;
		}
	}
	
	public class FileToolBar
		extends JPanel
	{
		public FileToolBar(final JBasicTable fileTable)
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
			
			final JBasicTextField textField = new JBasicTextField();
			textField.setBackground(Color.white);
			add(textField);
			
			JBasicButton selectorButton = new JBasicButton(IconFactory.getSwingIcon("theme/filechooser/nimbus/up_folder.png"), "Open Directory");
			selectorButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JFileSelector fileSelector = new JFileSelector(HandleManager.getFrame(DemoThreadDialoglPanel.this), "Open Directory");
					File direcotory = fileSelector.openDirectory();
					if (direcotory != null)
					{
						file = direcotory;
						textField.setText(file.getAbsolutePath());
					}
				}
			}
			);
			add(selectorButton);
			
			JBasicButton loaderButton = new JBasicButton(IconFactory.getSwingIcon("stereo_search.png"), "File Load");
			loaderButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JThreadDialog dialog = new JThreadDialog(HandleManager.getFrame(DemoThreadDialoglPanel.this), "File Load", "Loading, please wait...")
					{
						protected void loadForeground(Object data)
							throws Exception
						{
							List fileList = (List) data;
							
							FileTableModel tableModel = (FileTableModel) fileTable.getModel();
							tableModel.setRowDatas(fileList);
						}
						
						protected Object loadBackground()
							throws Exception
						{
							File[] files = fileSystemView.getFiles(file, true);
							List fileList = CollectionUtil.parseList(files);
							
							try
							{
								Thread.sleep(3000);
							}
							catch (InterruptedException e)
							{
							}
							
							return fileList;
						}
					};
					dialog.execute();
				}
			}
			);
			add(loaderButton);
			
			ButtonManager.updateUI(this);
		}
	}
}