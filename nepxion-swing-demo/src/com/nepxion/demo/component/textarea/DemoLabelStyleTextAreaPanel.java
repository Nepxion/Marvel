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
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.textarea.JBasicTextArea;

public class DemoLabelStyleTextAreaPanel
	extends JPanel
{
	public DemoLabelStyleTextAreaPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new LabelStyleTextAreaPanel());
	}
	
	public class LabelStyleTextAreaPanel
		extends JPanel
	{
		public LabelStyleTextAreaPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Label Style TextArea"));
			
			JBasicTextArea labelStyleTextArea = new JBasicTextArea();
			labelStyleTextArea.setLabelStyle();
			labelStyleTextArea.setText("This is the Label style textfield");
			
			JBasicScrollPane labelStyleScrollPane = new JBasicScrollPane();
			labelStyleScrollPane.setLabelStyle();
			labelStyleScrollPane.getViewport().add(labelStyleTextArea);			
			add(labelStyleScrollPane);
		}
	}
}