package com.nepxion.swing.tree.lazyloader;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.ImageIcon;

import org.jdesktop.swingworker.SwingWorker;

import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;

public class LoadingTreeNode
	extends ElementNode
{
	public static final int ACTION_LOADING = 0;
	public static final int ACTION_QUEUEING = 1;
	
	private String loadText = SwingLocale.getString("loading");
	private String queueText = SwingLocale.getString("queueing");
	
	private ImageIcon loadIcon;
	private ImageIcon queueIcon;
	
	private SwingWorker swingWorker;
	
	public LoadingTreeNode()
	{
		this(null);
	}
	
	public LoadingTreeNode(SwingWorker swingWorker)
	{
		super(false);
		
		this.swingWorker = swingWorker;
		
		loadIcon = IconFactory.getSwingIcon("thread/loader_aero.gif");
		queueIcon = IconFactory.getSwingIcon("thread/loader_aero_arrow.gif");
		
		setName("");
		setText(loadText);
		setIcon(loadIcon);
		setToolTipText(loadText);
		setAnimation(true);
	}
	
	public void setAction(int action)
	{
		String text = null;
		ImageIcon icon = null;
		
		if (action == ACTION_QUEUEING)
		{
			text = queueText;
			icon = queueIcon;
		}
		else
		{
			text = loadText;
			icon = loadIcon;
		}
		
		setText(text);
		setIcon(icon);
		setToolTipText(text);
	}
	
	public SwingWorker getSwingWorker()
	{
		return swingWorker;
	}
	
	public void setSwingWorker(SwingWorker swingWorker)
	{
		this.swingWorker = swingWorker;
	}
}