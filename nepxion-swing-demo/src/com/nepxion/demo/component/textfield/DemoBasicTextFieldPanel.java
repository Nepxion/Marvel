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
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.textarea.JBasicTextArea;
import com.nepxion.swing.textfield.JBasicTextField;

public class DemoBasicTextFieldPanel
	extends JPanel
{
	public DemoBasicTextFieldPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new BasicTextFieldPanel());
		add(new InformationPanel());
	}
	
	public class BasicTextFieldPanel
		extends JPanel
	{
		public BasicTextFieldPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Basic TextField"));

			JBasicTextField basicTextField = new JBasicTextField();
			basicTextField.setText("Right-clicked popupMenu to 'Copy' 'Paste' 'Cut' & 'Clean'");
			basicTextField.supportSelectionAll(true);
			basicTextField.setMaximumSize(new Dimension(350, basicTextField.getPreferredSize().height));			
			add(basicTextField);
		}
	}
	
	public class InformationPanel
		extends JPanel
	{
		public InformationPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("Support functions as follows:\n");
			stringBuffer.append("1. Copy, paste, cut & clean the specified text contents\n");
			stringBuffer.append("2. Enter key accelerator to transfer focus\n");
			stringBuffer.append("3. Selection all text contents once focus is gained");
			
			JBasicTextArea informationTextArea = new JBasicTextArea();
			informationTextArea.setLabelStyle();
			informationTextArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));			
			informationTextArea.setText(stringBuffer.toString());
			
			JBasicScrollPane informationScrollPane = new JBasicScrollPane();
			informationScrollPane.setLabelStyle();
			informationScrollPane.getViewport().add(informationTextArea);
			add(informationScrollPane);
		}
	}	
}