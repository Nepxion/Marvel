package com.nepxion.swing.internalframe;

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
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import com.nepxion.swing.container.ContainerManager;
import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.selector.checkbox.JCheckBoxSelector;

public class InternalFrameManager
{
	/**
	 * Closes the internal frames by a checkBox selector.
	 * @param desktopPane the instance of JDesktopPane
	 * @param checkBoxSelector the instance of JCheckBoxSelector
	 */
	public static void showCloseDialog(JDesktopPane desktopPane, JCheckBoxSelector checkBoxSelector)
	{
		if (desktopPane == null)
		{
			return;
		}
		
		JInternalFrame[] internalFrames = desktopPane.getAllFrames();
		if (internalFrames.length == 0)
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(desktopPane), SwingLocale.getString("no_close_item"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return;
		}	
		
		Vector slectionElementNodes = new Vector();
		for (int i = 0; i < internalFrames.length; i++)
		{
			JInternalFrame internalFrame = internalFrames[i];
						
			String title = internalFrame.getTitle();
			String toolTipText = internalFrame.getToolTipText();
			Icon icon = internalFrame.getFrameIcon();
			Component component = internalFrame.isIcon() ? internalFrame.getDesktopIcon() : internalFrame;
			
			IElementNode elementNode = new ElementNode(title, title, icon, toolTipText, component);
			slectionElementNodes.add(elementNode);
		}
		
		if (checkBoxSelector == null)
		{
			checkBoxSelector = new JCheckBoxSelector(HandleManager.getFrame(desktopPane), SwingLocale.getString("select_close"));
		}
		checkBoxSelector.getCheckBoxList().setListData(slectionElementNodes);
		checkBoxSelector.setVisible(true);
		checkBoxSelector.dispose();
		
		if (checkBoxSelector.isConfirmed())
		{
			List selectedComponents = checkBoxSelector.getSelectedUserObjects();
			for (Iterator iterator = selectedComponents.iterator(); iterator.hasNext();)
			{
				Component component = (Component) iterator.next();
				desktopPane.remove(component);
			}
			
			ContainerManager.update(desktopPane);
		}
	}
}