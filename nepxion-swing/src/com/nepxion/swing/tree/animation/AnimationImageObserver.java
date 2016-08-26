package com.nepxion.swing.tree.animation;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.JTree;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import com.nepxion.swing.tree.TreeManager;

public class AnimationImageObserver
	implements ImageObserver
{
	private JTree tree;
	
	private TreeNode treeNode;
	
	public AnimationImageObserver(JTree tree, TreeNode treeNode)
	{
		this.tree = tree;
		this.treeNode = treeNode;
	}
	
	public boolean imageUpdate(Image img, int flags, int x, int y, int w, int h)
	{
		if ((flags & (FRAMEBITS | ALLBITS)) != 0)
		{
			TreePath treePath = TreeManager.getTreePath(treeNode);
			Rectangle rectangle = tree.getPathBounds(treePath);
			if (rectangle != null)
			{
				tree.repaint(rectangle);
			}
		}
		
		return (flags & (ALLBITS | ABORT)) == 0;
	}
}