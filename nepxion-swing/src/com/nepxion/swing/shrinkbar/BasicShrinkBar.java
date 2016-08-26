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
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.nepxion.swing.border.LineBorder;
import com.nepxion.swing.style.texture.shrink.IHeaderTextureStyle;
import com.nepxion.swing.toolbar.JBasicToolBar;

public class BasicShrinkBar
	extends JPanel implements ShrinkContants
{
	/**
	 * The instance of JShrinkHeader.
	 */
	protected JShrinkHeader shrinkHeader;
	
	/**
	 * The instance of JSplitBar.
	 */
	protected JSplitBar splitBar;
	
	/**
	 * The shrink content pane.
	 */
	protected JPanel shrinkContentPane;
	
	/**
	 * The split width value.
	 */
	protected int splitWidth = 2;
	
	public BasicShrinkBar(int placement)
	{
		this(placement, DEFAULT_CONTENT_PANE_TYPE);
	}
	
	public BasicShrinkBar(int placement, IHeaderTextureStyle headerTextureStyle)
	{
		this(placement, DEFAULT_CONTENT_PANE_TYPE, headerTextureStyle);
	}
	
	public BasicShrinkBar(int placement, int contentPaneType)
	{
		this(placement, contentPaneType, DEFAULT_HEADER_TEXTURE_STYLE);
	}
	
	public BasicShrinkBar(int placement, int contentPaneType, IHeaderTextureStyle headerTextureStyle)
	{
		shrinkHeader = new JShrinkHeader(placement, contentPaneType, headerTextureStyle)
		{
			public void setShrinked(boolean shrinked)
			{
				super.setShrinked(shrinked);
				
				splitBar.setShrinked(shrinked);
				
				shrinkChanged(shrinked);
			}
		};
		splitBar = new JSplitBar(shrinkHeader, splitWidth);
		
		shrinkContentPane = new JPanel();
		shrinkContentPane.setLayout(new BorderLayout());
		
		setLayout(new BorderLayout());
		add(shrinkHeader, BorderLayout.NORTH);
		add(shrinkContentPane, BorderLayout.CENTER);
		
		togglePlacement();
	}
	
	protected void togglePlacement()
	{
		if (!isShrinkable())
		{
			throw new IllegalArgumentException("The shrinking is disabled");
		}
		
		int placement = getPlacement();
		if (placement == PLACEMENT_EAST)
		{
			shrinkContentPane.add(splitBar, BorderLayout.WEST);
			shrinkContentPane.setBorder(createBorder(splitWidth - 1, 0, splitWidth, splitWidth));
		}
		else if (placement == PLACEMENT_WEST)
		{
			shrinkContentPane.add(splitBar, BorderLayout.EAST);
			shrinkContentPane.setBorder(createBorder(splitWidth - 1, splitWidth, splitWidth, 0));
		}
	}
	
	protected void shrinkChanged(boolean shrinked)
	{
	}
	
	public JShrinkHeader getShrinkHeader()
	{
		return shrinkHeader;
	}
	
	public JLabel getShrinkLabel()
	{
		return shrinkHeader.getLabel();
	}
	
	public JBasicToolBar getShrinkToolBar()
	{
		return shrinkHeader.getToolBar();
	}
	
	/**
	 * Gets the title.
	 * @return the title string
	 */
	public String getTitle()
	{
		if (shrinkHeader.getLabel() == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		return shrinkHeader.getLabel().getText();
	}
	
	/**
	 * Sets the title.
	 * @param title the title string
	 */
	public void setTitle(String title)
	{
		if (shrinkHeader.getLabel() == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		shrinkHeader.getLabel().setText(title);
	}
	
	/**
	 * Gets the icon.
	 * @return the instance of Icon
	 */
	public Icon getIcon()
	{
		if (shrinkHeader.getLabel() == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		return shrinkHeader.getLabel().getIcon();
	}
	
	/**
	 * Sets the icon.
	 * @param icon the instance of Icon
	 */
	public void setIcon(Icon icon)
	{
		if (shrinkHeader.getLabel() == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		shrinkHeader.getLabel().setIcon(icon);
	}
	
	/**
	 * Gets the tooltip text.
	 * @return the tooltip text string
	 */
	public String getToolTipText()
	{
		if (shrinkHeader.getLabel() == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		return shrinkHeader.getLabel().getToolTipText();
	}
	
	/**
	 * Sets the tooltip text.
	 * @param the toolTipText the tooltip text string
	 */
	public void setToolTipText(String toolTipText)
	{
		if (shrinkHeader.getLabel() == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		shrinkHeader.getLabel().setToolTipText(toolTipText);
	}
	
	/**
	 * Gets the title color.
	 * @return the instance of Color
	 */
	public Color getTitleColor()
	{
		if (shrinkHeader.getLabel() == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		return shrinkHeader.getLabel().getForeground();
	}
	
	/**
	 * Sets the title color.
	 * @param color the instance of Color
	 */
	public void setTitleColor(Color color)
	{
		if (shrinkHeader.getLabel() == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		shrinkHeader.getLabel().setForeground(color);
	}
	
	/**
	 * Gets the title font.
	 * @return the instance of Font
	 */
	public Font getTitleFont()
	{
		if (shrinkHeader.getLabel() == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		return shrinkHeader.getLabel().getFont();
	}
	
	/**
	 * Sets the title font.
	 * @param font the instance of Font
	 */
	public void setTitleFont(Font font)
	{
		if (shrinkHeader.getLabel() == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		shrinkHeader.getLabel().setFont(font);
	}
	
	public int getPlacement()
	{
		return shrinkHeader.getPlacement();
	}
	
	public void setPlacement(int placement)
	{
		shrinkHeader.setPlacement(placement);
		
		togglePlacement();
	}
	
	public int getContentPaneType()
	{
		return shrinkHeader.getContentPaneType();
	}
	
	public void setContentPaneType(int contentPaneType)
	{
		shrinkHeader.setContentPaneType(contentPaneType);
	}
	
	public boolean isShrinked()
	{
		return shrinkHeader.isShrinked();
	}
	
	public void setShrinked(boolean shrinked)
	{
		shrinkHeader.setShrinked(shrinked);
	}
	
	public boolean isShrinkable()
	{
		return shrinkHeader.isShrinkable();
	}
	
	public void setShrinkable(boolean shrinkable)
	{
		shrinkHeader.setShrinkable(shrinkable);
		
		if (shrinkable)
		{
			togglePlacement();
		}
		else
		{
			if (retrieveComponent(splitBar))
			{	
				shrinkContentPane.remove(splitBar);
				shrinkContentPane.setBorder(createBorder(splitWidth - 1, splitWidth, splitWidth, splitWidth));
			}
		}
	}
	
	private boolean retrieveComponent(Component component)
	{
		for (int i = 0; i < shrinkContentPane.getComponentCount(); i++)
		{
			Component c = shrinkContentPane.getComponent(i);
			
			if (c == component)
			{
				return true;
			}	
		}
		
		return false;
	}
	
	public int getShrinkedWidth()
	{
		return shrinkHeader.getShrinkedWidth();
	}
	
	public void setShrinkedWidth(int shrinkedWidth)
	{
		shrinkHeader.setShrinkedWidth(shrinkedWidth);
	}
	
	private Border createBorder(int top, int left, int bottom, int right)
	{
		LineBorder lineBorder = new LineBorder(shrinkHeader.getHeaderTextureStyle().getBorderColor());
		lineBorder.setColor(null, LineBorder.NORTH);
		
		return BorderFactory.createCompoundBorder(lineBorder, BorderFactory.createEmptyBorder(top, left, bottom, right));
	}
}