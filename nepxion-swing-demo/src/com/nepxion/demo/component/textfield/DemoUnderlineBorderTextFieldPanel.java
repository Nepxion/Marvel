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
import com.nepxion.swing.border.UnderlineBorderDecoration;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.textfield.JBasicTextField;

public class DemoUnderlineBorderTextFieldPanel
	extends JPanel
{
	public DemoUnderlineBorderTextFieldPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new UnderlineBorderTextFieldPanel());
	}
	
	public class UnderlineBorderTextFieldPanel
		extends JPanel
	{
		public UnderlineBorderTextFieldPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Underline Border TextField"));

			JBasicTextField underlineBorderTextField = new JBasicTextField();
			new UnderlineBorderDecoration(underlineBorderTextField);
			underlineBorderTextField.setText("This is the UnderLine border textfield. Type the words here");
			underlineBorderTextField.setMaximumSize(new Dimension(350, underlineBorderTextField.getPreferredSize().height));
			add(underlineBorderTextField);
		}
	}	
}