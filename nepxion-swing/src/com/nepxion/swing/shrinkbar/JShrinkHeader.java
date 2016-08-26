package com.nepxion.swing.shrinkbar;

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
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.gradient.JBackgroundPainter;
import com.nepxion.swing.style.texture.shrink.IHeaderTextureStyle;
import com.nepxion.swing.toolbar.JBasicToolBar;

public class JShrinkHeader
	extends JPanel implements ShrinkContants
{
	private int placement = PLACEMENT_WEST;
	private int contentPaneType = DEFAULT_CONTENT_PANE_TYPE;
	
	private JLabel resizeHandlerLabel;
	private JLabel shrinkHandlerLabel;
	
	private JLabel label;
	private JBasicToolBar toolBar;
	
	private int shrinkedWidth = 40;
	private int preferredWidth = 0;
	
	private IHeaderTextureStyle headerTextureStyle;
	
	private boolean shrinked = false;
	private boolean shrinkable = true;
	
	public JShrinkHeader(int placement)
	{
		this(placement, DEFAULT_CONTENT_PANE_TYPE);
	}
	
	public JShrinkHeader(int placement, IHeaderTextureStyle headerTextureStyle)
	{
		this(placement, DEFAULT_CONTENT_PANE_TYPE, headerTextureStyle);
	}
	
	public JShrinkHeader(int placement, int contentPaneType)
	{
		this(placement, contentPaneType, DEFAULT_HEADER_TEXTURE_STYLE);
	}
	
	public JShrinkHeader(int placement, int contentPaneType, IHeaderTextureStyle headerTextureStyle)
	{
		this.placement = placement;
		this.contentPaneType = contentPaneType;
		this.headerTextureStyle = headerTextureStyle;
		
		initComponents();
	}
	
	private void initComponents()
	{
		SplitListener splitListener = new SplitListener(this);
		ShrinkListener shrinkListener = new ShrinkListener(this);
		
		resizeHandlerLabel = new JLabel(headerTextureStyle.getResizeHandlerImageIcon());
		resizeHandlerLabel.addMouseListener(splitListener);
		resizeHandlerLabel.addMouseMotionListener(splitListener);
		resizeHandlerLabel.setBorder(BorderFactory.createEmptyBorder(2, 7, 2, 7));
		
		shrinkHandlerLabel = new JLabel();
		shrinkHandlerLabel.addMouseListener(shrinkListener);
		shrinkHandlerLabel.setBorder(BorderFactory.createEmptyBorder(2, 7, 2, 7));
		
		setOpaque(false);
		setLayout(new BorderLayout());
				
		togglePlacement();
		toggleContentPaneType();
		updateShrinkIcon();
		updateCursor();
	}
		
	public JLabel getLabel()
	{
		return label;
	}
	
	public JBasicToolBar getToolBar()
	{
		return toolBar;
	}
	
	public IHeaderTextureStyle getHeaderTextureStyle()
	{
		return headerTextureStyle;
	}
	
	public String getTitle()
	{
		if (label == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		return label.getText();
	}
	
	public void setTitle(String title)
	{
		if (label == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		label.setText(title);
	}
	
	public Icon getIcon()
	{
		if (label == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		return label.getIcon();
	}
	
	public void setIcon(Icon icon)
	{
		if (label == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		label.setIcon(icon);
	}
	
	public String getToolTipText()
	{
		if (label == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		return label.getToolTipText();
	}
	
	public void setToolTipText(String toolTipText)
	{
		if (label == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		label.setToolTipText(toolTipText);
	}
	
	public Color getTitleColor()
	{
		if (label == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		return label.getForeground();
	}
	
	public void setTitleColor(Color color)
	{
		if (label == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		label.setForeground(color);
	}
	
	public Font getTitleFont()
	{
		if (label == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		return label.getFont();
	}
	
	public void setTitleFont(Font font)
	{
		if (label == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		label.setFont(font);
	}
	
	public int getPlacement()
	{
		return placement;
	}
	
	public void setPlacement(int placement)
	{
		this.placement = placement;
		
		togglePlacement();
	}
	
	protected void togglePlacement()
	{
		if (!shrinkable)
		{
			throw new IllegalArgumentException("The shrinking is disabled");
		}
		
		if (placement == PLACEMENT_EAST)
		{
			add(shrinkHandlerLabel, BorderLayout.EAST);
			add(resizeHandlerLabel, BorderLayout.WEST);
		}
		else if (placement == PLACEMENT_WEST)
		{
			add(resizeHandlerLabel, BorderLayout.EAST);
			add(shrinkHandlerLabel, BorderLayout.WEST);
		}
	}
	
	public int getContentPaneType()
	{
		return contentPaneType;
	}
	
	public void setContentPaneType(int contentPaneType)
	{
		this.contentPaneType = contentPaneType;
		
		toggleContentPaneType();
	}
	
	protected void toggleContentPaneType()
	{
		if (contentPaneType == CONTENT_PANE_TYPE_LABEL)
		{	
			if (label == null)
			{
				label = new JLabel();
				label.setForeground(headerTextureStyle.getForeground());
				label.setBorder(BorderFactory.createEmptyBorder());
			}
			
			add(label, BorderLayout.CENTER);
		}
		else if (contentPaneType == CONTENT_PANE_TYPE_TOOLBAR)
		{
			if (toolBar == null)
			{
				toolBar = new JBasicToolBar();
				toolBar.setOpaque(false);
				toolBar.setBorder(BorderFactory.createEmptyBorder());
			}
			
			add(toolBar, BorderLayout.CENTER);
		}	
	}
	
	public boolean isShrinked()
	{
		return shrinked;
	}
	
	public void setShrinked(boolean shrinked)
	{
		if (!shrinkable)
		{
			throw new IllegalArgumentException("The shrinking is disabled");
		}
		
		if (this.shrinked == shrinked)
		{
			return;
		}
		
		Container parent = getParent();
		Dimension size = parent.getPreferredSize();
		if (shrinked)
		{
			preferredWidth = size.width;
			size = new Dimension(shrinkedWidth, size.height);
		}
		else
		{
			int width = preferredWidth;
			int height = parent.getPreferredSize().height;
			size = new Dimension(width, height);
		}
		parent.setPreferredSize(size);
			
		this.shrinked = shrinked;
		
		resizeHandlerLabel.setVisible(!shrinked);
		
		if (label != null)
		{	
			label.setVisible(!shrinked);
		}
		if (toolBar != null)
		{
			toolBar.setVisible(!shrinked);
		}	
		
		revalidateParent();
		updateShrinkIcon();
		updateCursor();
	}
	
	protected void toggleShrinked()
	{
		boolean shrinked = isShrinked();
		
		setShrinked(!shrinked);
	}
	
	public boolean isShrinkable()
	{
		return shrinkable;
	}
	
	public void setShrinkable(boolean shrinkable)
	{
		this.shrinkable = shrinkable;
		
		if (shrinkable)
		{
			togglePlacement();
			
			if (label != null)
			{	
				label.setBorder(BorderFactory.createEmptyBorder());
			}
			
			if (toolBar != null)
			{	
				toolBar.setBorder(BorderFactory.createEmptyBorder());
			}
		}
		else
		{
			if (retrieveComponent(resizeHandlerLabel))
			{	
				remove(resizeHandlerLabel);
			}
			
			if (retrieveComponent(shrinkHandlerLabel))
			{	
				remove(shrinkHandlerLabel);
			}
			
			if (label != null)
			{	
				label.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));
			}
			
			if (toolBar != null)
			{	
				toolBar.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));
			}
		}
	}
	
	private boolean retrieveComponent(Component component)
	{
		for (int i = 0; i < getComponentCount(); i++)
		{
			Component c = getComponent(i);
			
			if (c == component)
			{
				return true;
			}	
		}
		
		return false;
	}
	
	public int getShrinkedWidth()
	{
		return shrinkedWidth;
	}
	
	public void setShrinkedWidth(int shrinkedWidth)
	{
		this.shrinkedWidth = shrinkedWidth;
	}
	
	public Dimension getPreferredSize()
	{
		int height = headerTextureStyle.getHeight();
		
		return new Dimension(super.getPreferredSize().width, height);
	}
	
	protected void revalidateParent()
	{
		Container container = getParent();
		if (container instanceof JComponent)
		{
			JComponent component = (JComponent) container;
			component.revalidate();
		}
	}
	
    protected void updateShrinkIcon()
	{
    	Icon shrinkIcon = null;
    	
		if (shrinked)
		{
			if (placement == PLACEMENT_EAST)
			{
				shrinkIcon = headerTextureStyle.getShrinkHandlerLeftImageIcon();
			}
			else if (placement == PLACEMENT_WEST)
			{
				shrinkIcon = headerTextureStyle.getShrinkHandlerRightImageIcon();
			}
		}
		else
		{
			if (placement == PLACEMENT_EAST)
			{
				shrinkIcon = headerTextureStyle.getShrinkHandlerRightImageIcon();		
			}
			else if (placement == PLACEMENT_WEST)
			{
				shrinkIcon = headerTextureStyle.getShrinkHandlerLeftImageIcon();
			}
		}
		
		shrinkHandlerLabel.setIcon(shrinkIcon);
	}
    
	protected void updateCursor()
	{
		if (shrinked)
		{
			resizeHandlerLabel.setCursor(Cursor.getDefaultCursor());
		}
		else
		{
			resizeHandlerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
		}
	}
	
	protected void paintComponent(Graphics g)
	{
		JBackgroundPainter.paintBackground(this, g, headerTextureStyle);
	}
}