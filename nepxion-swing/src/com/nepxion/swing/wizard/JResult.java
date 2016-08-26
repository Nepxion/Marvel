package com.nepxion.swing.wizard;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.textarea.JBasicTextArea;

public class JResult
{
	/**
	 * 
	 */
	private static JResultPane resultPane;
	
	public static void show(JWizard wizard, String result)
	{
		show(wizard, result, "information.png");
	}
	
	public static void show(JWizard wizard, Exception e)
	{
		show(wizard, e.toString(), "error.png");
	}
	
	private static void show(JWizard wizard, String result, String icon)
	{
		if (resultPane == null)
		{
			resultPane = new JResultPane();
		}
		resultPane.setResult(result);
		int selectedValue = JBasicOptionPane.showDialog(HandleManager.getFrame(wizard), resultPane, "信息", IconFactory.getSwingIcon(icon), new Object[] {" 重复向导 ", " 退出向导 "});
		if (selectedValue == JBasicOptionPane.YES_OPTION)
		{
			wizard.setCurrentStep(0);
		}
		else
		{
			HandleManager.getWindow(wizard).setVisible(false);
		}
	}
	
	public static class JResultPane
		extends JPanel
	{
		private JBasicTextArea textArea;
		
		public JResultPane()
		{
			textArea = new JBasicTextArea();
			// textArea.setEnabled(false);
			
			setPreferredSize(new Dimension(250, 250));
			setBorder(BorderManager.createComplexTitledBorder("结果信息"));
			setLayout(new BorderLayout());
			add(new JBasicScrollPane(textArea), BorderLayout.CENTER);
		}
		
		public void setResult(String result)
		{
			textArea.setText(result);
		}
	}
}