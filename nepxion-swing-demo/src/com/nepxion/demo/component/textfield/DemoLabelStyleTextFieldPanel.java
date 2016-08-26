package com.nepxion.demo.component.textfield;

/* <p>Title: Nepxion Swing</p>
* <p>Description: Nepxion Swing Repository</p>
* <p>Copyright: Copyright (c) 2010</p>
* <p>Company: Nepxion</p>
* @author Neptune
* @email 1394997@qq.com
* @version 1.0
*/

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.textfield.JBasicTextField;

public class DemoLabelStyleTextFieldPanel
	extends JPanel
{
	public DemoLabelStyleTextFieldPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new LabelStyleTextFieldPanel());
	}
	
	public class LabelStyleTextFieldPanel
		extends JPanel
	{
		public LabelStyleTextFieldPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Label Style TextField"));

			JBasicTextField labelStyleTextField = new JBasicTextField();
			labelStyleTextField.setLabelStyle();
			labelStyleTextField.setText("This is the Label style textfield");
			labelStyleTextField.setMaximumSize(new Dimension(350, labelStyleTextField.getPreferredSize().height));
			add(labelStyleTextField);
		}
	}	
}