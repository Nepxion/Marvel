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

public class DemoBasicTextAreaPanel
	extends JPanel
{
	public DemoBasicTextAreaPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new BasicTextAreaPanel());
	}
	
	public class BasicTextAreaPanel
		extends JPanel
	{
		public BasicTextAreaPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Basic TextArea"));
			
			JBasicTextArea basicTextArea = new JBasicTextArea();
			basicTextArea.setText("Right-clicked popupMenu to 'Copy' 'Paste' 'Cut' & 'Clean'");

			JBasicScrollPane basicScrollPane = new JBasicScrollPane();
			basicScrollPane.getViewport().add(basicTextArea);				
			add(basicScrollPane);			
		}
	}
}