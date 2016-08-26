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
import com.nepxion.swing.border.HoverBorderDecoration;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.textarea.JBasicTextArea;

public class DemoHoverBorderTextAreaPanel
	extends JPanel
{
	public DemoHoverBorderTextAreaPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new HoverBorderTextAreaPanel());
	}
	
	public class HoverBorderTextAreaPanel
		extends JPanel
	{
		public HoverBorderTextAreaPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Hover Border TextArea"));
			
			JBasicTextArea hoverBorderTextArea = new JBasicTextArea();
			new HoverBorderDecoration(hoverBorderTextArea);
			hoverBorderTextArea.setText("This is the Hover border textfield. Type the words here");
			
			JBasicScrollPane hoverBorderScrollPane = new JBasicScrollPane();
			hoverBorderScrollPane.getViewport().add(hoverBorderTextArea);			
			add(hoverBorderScrollPane);
		}
	}
}