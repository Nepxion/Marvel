package com.nepxion.demo.control.text;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Dimension;

import com.nepxion.demo.common.DemoToggleActionButton;
import com.nepxion.demo.common.DemoToggleOutlook;
import com.nepxion.swing.button.ButtonManager;

public class DemoTextControlOutlook
	extends DemoToggleOutlook
{
	public DemoTextControlOutlook()
	{
		DemoToggleActionButton labelButton = new DemoToggleActionButton(new DemoLabelTogglePanel());
        addButton(labelButton);
        
		DemoToggleActionButton textFieldButton = new DemoToggleActionButton(new DemoTextFieldTogglePanel());
        addButton(textFieldButton); 
        
		DemoToggleActionButton formattedTextFieldButton = new DemoToggleActionButton(new DemoFormattedTextFieldTogglePanel());
        addButton(formattedTextFieldButton);
        
		DemoToggleActionButton passwordFieldButton = new DemoToggleActionButton(new DemoPasswordFieldTogglePanel());
        addButton(passwordFieldButton);
        
		DemoToggleActionButton textAreaButton = new DemoToggleActionButton(new DemoTextAreaTogglePanel());
        addButton(textAreaButton);
        
		DemoToggleActionButton textPaneButton = new DemoToggleActionButton(new DemoTextPaneTogglePanel());
        addButton(textPaneButton);  
        
		DemoToggleActionButton editorPaneButton = new DemoToggleActionButton(new DemoEditorPaneTogglePanel());
        addButton(editorPaneButton);    
        
        ButtonManager.updateUI(this, new Dimension(50, 70), new int[] {VERTICAL, CENTER});
	}
}