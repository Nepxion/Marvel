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
import com.nepxion.swing.border.HoverBorderDecoration;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.textfield.JBasicTextField;

public class DemoHoverBorderTextFieldPanel
	extends JPanel
{
	public DemoHoverBorderTextFieldPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new HoverBorderTextFieldPanel());
	}
	
	public class HoverBorderTextFieldPanel
		extends JPanel
	{
		public HoverBorderTextFieldPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Hover Border TextField"));
			
			JBasicTextField hoverBorderTextField = new JBasicTextField();
			new HoverBorderDecoration(hoverBorderTextField);
			hoverBorderTextField.setText("This is the Hover border textfield. Type the words here");
			hoverBorderTextField.setMaximumSize(new Dimension(350, hoverBorderTextField.getPreferredSize().height));
			add(hoverBorderTextField);
		}
	}
}