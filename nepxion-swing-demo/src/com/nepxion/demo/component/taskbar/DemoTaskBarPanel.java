package com.nepxion.demo.component.taskbar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.container.ContainerManager;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;
import com.nepxion.swing.taskbar.JTaskAction;
import com.nepxion.swing.taskbar.JTaskBar;
import com.nepxion.swing.taskbar.JTaskGroup;
import com.nepxion.swing.taskbar.JTaskManager;

public class DemoTaskBarPanel
	extends JPanel
{
	public DemoTaskBarPanel()
	{
		JEclipseTabbedPane tabbedPane = new JEclipseTabbedPane();
		tabbedPane.setTabPlacement(JEclipseTabbedPane.BOTTOM);
		
		JTaskManager.installTaskPlainFont();
		
		LookAndFeelManager.addonMetalLookAndFeel();
		tabbedPane.addTab("Metal", IconFactory.getSwingIcon("component/color_16.png"), new TaskBarPanel("Metal L&F"), "Metal L&F");
		
		LookAndFeelManager.addonWindowsLookAndFeel();
		tabbedPane.addTab("Windows", IconFactory.getSwingIcon("component/color_16.png"), new TaskBarPanel("Windows L&F"), "Windows L&F");
		
		LookAndFeelManager.addonLunaLookAndFeel();
		tabbedPane.addTab("Luna", IconFactory.getSwingIcon("component/color_16.png"), new TaskBarPanel("Luna L&F"), "Luna L&F");
		
		LookAndFeelManager.addonHomesteadLookAndFeel();
		tabbedPane.addTab("Homestead", IconFactory.getSwingIcon("component/color_16.png"), new TaskBarPanel("Homestead L&F"), "Homestead L&F");
		
		LookAndFeelManager.addonMetallicLookAndFeel();
		tabbedPane.addTab("Metallic", IconFactory.getSwingIcon("component/color_16.png"), new TaskBarPanel("Metallic L&F"), "Metallic L&F");
		
		LookAndFeelManager.addonGlossyLookAndFeel();
		tabbedPane.addTab("Glossy", IconFactory.getSwingIcon("component/color_16.png"), new TaskBarPanel("Glossy L&F"), "Glossy L&F");
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(tabbedPane);
	}
	
	public class TaskBarPanel
		extends JPanel
	{
		public TaskBarPanel(String title)
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder(title));
			
			final JTaskBar taskBar = new JTaskBar();
			
			// System TaskGroup
			JTaskGroup systemTaskGroup = new JTaskGroup("File and Folder Tasks", IconFactory.getIcon("com/l2fprod/common/demo/icons/tasks-email.png"), "Everything you can execute on files and folders", new Font("Dialog", Font.BOLD, 12));
			systemTaskGroup.setSpecial(true);
			systemTaskGroup.add(new JTaskAction("Send by email", IconFactory.getIcon("com/l2fprod/common/demo/icons/tasks-email.png"), "Send by email")
			{
				public void execute(ActionEvent e)
				{
					JBasicOptionPane.showMessageDialog(HandleManager.getFrame(DemoTaskBarPanel.this), "Send by email", "Message", JBasicOptionPane.INFORMATION_MESSAGE);
				}
			}
			);
			systemTaskGroup.add(new JTaskAction("Delete", IconFactory.getIcon("com/l2fprod/common/demo/icons/tasks-recycle.png"), "Delete")
			{
				public void execute(ActionEvent e)
				{
					JBasicOptionPane.showMessageDialog(HandleManager.getFrame(DemoTaskBarPanel.this), "Delete", "Message", JBasicOptionPane.INFORMATION_MESSAGE);
				}
			}
			);
			taskBar.add(systemTaskGroup);
			
			// Office TaskGroup
			JTaskGroup officeTaskGroup = new JTaskGroup("Office Tasks", IconFactory.getIcon("com/l2fprod/common/demo/icons/tasks-writedoc.png"), "Office Tasks");
			officeTaskGroup.setExpanded(false);
			officeTaskGroup.setScrollOnExpand(true);
			officeTaskGroup.add(new JTaskAction("Write Document", IconFactory.getIcon("com/l2fprod/common/demo/icons/tasks-writedoc.png"), "Write Document")
			{
				public void execute(ActionEvent e)
				{
					JBasicOptionPane.showMessageDialog(HandleManager.getFrame(DemoTaskBarPanel.this), "Write Document", "Message", JBasicOptionPane.INFORMATION_MESSAGE);
				}
			}
			);
			taskBar.add(officeTaskGroup);
			
			// SeeAlso TaskGroup
			JTaskGroup seeAlsoTaskGroup = new JTaskGroup("See Also", "See Also");
			seeAlsoTaskGroup.setCollapsable(false);
			seeAlsoTaskGroup.add(new JTaskAction("The Internet", IconFactory.getIcon("com/l2fprod/common/demo/icons/tasks-internet.png"), "A cool web resource")
			{
				public void execute(ActionEvent e)
				{
					JBasicOptionPane.showMessageDialog(HandleManager.getFrame(DemoTaskBarPanel.this), "The Internet", "Message", JBasicOptionPane.INFORMATION_MESSAGE);
				}
			}
			);
			seeAlsoTaskGroup.add(new JTaskAction("Help Center", IconFactory.getIcon("com/l2fprod/common/demo/icons/tasks-question.png"), "The place where you can't find anything")
			{
				public void execute(ActionEvent e)
				{
					JBasicOptionPane.showMessageDialog(HandleManager.getFrame(DemoTaskBarPanel.this), "Help Center", "Message", JBasicOptionPane.INFORMATION_MESSAGE);
				}
			}
			);
			taskBar.add(seeAlsoTaskGroup);

			// Management
			JTaskGroup managementTaskGroup = new JTaskGroup("Management", "Management");
			managementTaskGroup.add(new JTaskAction("Add TaskGroup", "Add TaskGroup")
			{
				public void execute(ActionEvent e)
				{
					JTaskGroup newTaskGroup = new JTaskGroup("New TaskGroup", "New TaskGroup");
					newTaskGroup.add(new JTaskAction("New Task", "New Task")
					{
						public void execute(ActionEvent e)
						{
							JBasicOptionPane.showMessageDialog(HandleManager.getFrame(DemoTaskBarPanel.this), "New Task", "Message", JBasicOptionPane.INFORMATION_MESSAGE);
						}
					}
					);
					taskBar.add(newTaskGroup);

					ContainerManager.update(TaskBarPanel.this);
				}
			}
			);
			managementTaskGroup.add(new JTaskAction("Delete TaskGroup", "Delete TaskGroup")
			{
				public void execute(ActionEvent e)
				{
					taskBar.remove(0);
					ContainerManager.update(TaskBarPanel.this);				
				}
			}
			);			
			taskBar.add(managementTaskGroup);
			
			JBasicScrollPane taskBarScrollPane = new JBasicScrollPane();
			taskBarScrollPane.getViewport().add(taskBar);				
			add(taskBarScrollPane);
		}
	}
}