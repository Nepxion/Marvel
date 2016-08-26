package com.nepxion.demo.component.ribbon;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Component;
import java.awt.event.ActionEvent;

import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.optionpane.JBasicOptionPane;

public class DemoAction
	extends JSecurityAction
{
	public void execute(ActionEvent e)
	{
		Component component = (Component) e.getSource();

		JBasicOptionPane.showMessageDialog(HandleManager.getFrame(component), "Action Name : " + getName() + "\n" + "Action Trigger : " + component.getClass().getName());		
	}
}
