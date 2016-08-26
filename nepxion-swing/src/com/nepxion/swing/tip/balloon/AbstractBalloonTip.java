package com.nepxion.swing.tip.balloon;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;

import javax.swing.JApplet;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import com.nepxion.swing.border.BalloonBorder;

public abstract class AbstractBalloonTip
	extends JPanel
{
	/**
	 * 
	 */
	public static final Color TIP_COLOR = new Color(255, 255, 225);
	public static final int TIP_OFFSET = 10;
	
	private Component component;
	private JLayeredPane parentLayeredPane;
	
	public AbstractBalloonTip(Component component, Color tipColor, int tipOffset)
	{
		this.component = component;
		
		setOpaque(false);
		setBorder(new BalloonBorder(tipColor, tipOffset));
		
		// if the attached component is moved while the balloon tip is
		// visible, we need to move as well
		component.addComponentListener(new ComponentAdapter()
		{
			public void componentMoved(ComponentEvent e)
			{
				if (isVisible())
				{
					validateBounds();
				}
			}
			
			public void componentResized(ComponentEvent e)
			{
				if (isVisible())
				{
					validateBounds();
				}
			}
		}
		);
		component.addHierarchyBoundsListener(new HierarchyBoundsListener()
		{
			public void ancestorMoved(HierarchyEvent e)
			{
				if (isVisible())
				{
					validateBounds();
				}
			}
			
			public void ancestorResized(HierarchyEvent e)
			{
				if (isVisible())
				{
					validateBounds();
				}
			}
		}
		);
		component.addHierarchyListener(new HierarchyListener()
		{
			public void hierarchyChanged(HierarchyEvent e)
			{
				if (isVisible())
				{
					setVisible(false);
				}
			}
		}
		);
		component.addFocusListener(new FocusAdapter()
		{
			public void focusLost(FocusEvent e)
			{
				if (isVisible())
				{
					setVisible(false);
				}
			}
		}
		);
	}
	
	public void setVisible(boolean visible)
	{
		if (visible)
		{
			validateBounds();
			validateLayeredPane();
		}
		
		super.setVisible(visible);
	}
	
	protected void validateBounds()
	{
		Point location = getPointOfLayeredPane(component);
		setBounds(location.x, location.y - getPreferredSize().height, getPreferredSize().width, getPreferredSize().height);
	}
	
	protected void validateLayeredPane()
	{
		// we use the popup layer of the top level container (frame or
		// dialog or applet) to show the balloon tip
		// first we need to determine the top level container...
		Container parent = component.getParent();
		JLayeredPane layeredPane = null;
		while (true)
		{
			if (parent == null)
			{
				return;
			}
			
			if (parent instanceof JFrame)
			{
				layeredPane = ((JFrame) parent).getLayeredPane();
				break;
			}
			else if (parent instanceof JDialog)
			{
				layeredPane = ((JDialog) parent).getLayeredPane();
				break;
			}
			else if (parent instanceof JApplet)
			{
				layeredPane = ((JApplet) parent).getLayeredPane();
				break;
			}
			parent = parent.getParent();
		}
		
		// 当attachedComponent被放置到其他的最上层父组件的时候，例如从一个Dialog移到另一个Dialog，会出现在新的Dialog里Tip显示不出来的Bug。
		// 所以需维护一个句柄layeredPane，去判断layeredPane是否已改变，据此来判断最上层父组件是否改变；
		// 如改变，则用已改变的最上层父组件的layeredPane
		if (parentLayeredPane == layeredPane)
		{
			return;
		}
		
		layeredPane.add(this, JLayeredPane.POPUP_LAYER);
		parentLayeredPane = layeredPane;
	}
	
	protected Point getPointOfLayeredPane(Component component)
	{
		if (component == null)
		{
			throw new IllegalArgumentException("Component can't be null");
		}
		
		int x = component.getX();
		int y = component.getY();
		
		Container parent = component.getParent();
		
		while (true)
		{
			if (parent == null)
			{
				return new Point(x, y);
			}
			
			if (parent instanceof JLayeredPane)
			{
				break;
			}
			
			x = x + parent.getX();
			y = y + parent.getY();
			
			parent = parent.getParent();
		}
		
		return new Point(x, y);
	}
}