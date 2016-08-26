package com.nepxion.demo.component.textarea;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.textarea.JAutoResizableTextArea;

public class DemoAutoResizableTextAreaPanel
	extends JPanel
{
	public DemoAutoResizableTextAreaPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new AutoResizableTextAreaPanel());
	}
	
	public class AutoResizableTextAreaPanel
		extends JPanel
	{
		public AutoResizableTextAreaPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Auto Resizable TextArea"));
			
			JAutoResizableTextArea autoResizableTextArea = new JAutoResizableTextArea();
			autoResizableTextArea.setMinRows(10);
			autoResizableTextArea.setMaxRows(15);
			autoResizableTextArea.setText("Typing in new line here to see the text area growing automatically. \nMinimum 10 rows and maximum 20 rows");
			
			JBasicScrollPane autoResizableScrollPane = new JBasicScrollPane();
			autoResizableScrollPane.getViewport().add(autoResizableTextArea);				
			add(autoResizableScrollPane);
		}
	}
}