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
import com.nepxion.swing.textfield.number.JNumberTextField;

public class DemoNumberTextFieldPanel
	extends JPanel
{
	public DemoNumberTextFieldPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new NumberTextFieldPanel());
		add(new InformationPanel());
	}
	
	public class NumberTextFieldPanel
		extends JPanel
	{
		public NumberTextFieldPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Number TextField"));
			
			JNumberTextField numberTextField = new JNumberTextField(5, 2, -1000.05, 1000.95);
			numberTextField.setMaximumSize(new Dimension(350, numberTextField.getPreferredSize().height));
			add(numberTextField);
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
			stringBuffer.append("3. Selection all text contents once focus is gained\n");
			stringBuffer.append("4. Limitation to input number, for example :\n");
			stringBuffer.append("   JNumberTextField(5, 2, -1000.05, 1000.95)\n");
			stringBuffer.append("   Maximum length = 5");
			stringBuffer.append("   Maximum decimal length = 2");
			stringBuffer.append("   Minimum value = -1000.05");			
			stringBuffer.append("   Maximum value = 1000.95\n");
			stringBuffer.append("   (See TextField above)");
			
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