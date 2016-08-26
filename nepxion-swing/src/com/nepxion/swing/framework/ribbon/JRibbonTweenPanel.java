package com.nepxion.swing.framework.ribbon;

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
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.nepxion.swing.border.LineBorder;
import com.nepxion.swing.container.ContainerManager;
import com.nepxion.swing.panel.JReflectionPanel;
import com.nepxion.swing.shrinkbar.JShrinkHeader;
import com.nepxion.swing.style.texture.shrink.IHeaderTextureStyle;
import com.nepxion.swing.style.texture.shrink.JBlueHeaderTextureStyle;

public class JRibbonTweenPanel
	extends JReflectionPanel
{
	/**
	 * The content bar.
	 */
	private JPanel contentBar;
	
	/**
	 * The content pane.
	 */
	private JComponent contentPane;
	
	/**
	 * The width offset value.
	 */
	private int widthOffset;
	
	/**
	 * The height offset value.
	 */
	private int heightOffset;
	
	/**
	 * The instance of IHeaderTextureStyle.
	 */
	private IHeaderTextureStyle headerTextureStyle;
	
	/**
	 * The instance of JShrinkHeader.
	 */
	private JShrinkHeader shrinkHeader;
	
	/**
	 * Constructs with the default.
	 */
	public JRibbonTweenPanel()
	{
		this(new JBlueHeaderTextureStyle());
	}
	
	/**
	 * Constructs with the specified initial header texture style.
	 * @param headerTextureStyle the instance of IHeaderTextureStyle
	 */
	public JRibbonTweenPanel(IHeaderTextureStyle headerTextureStyle)
	{
		this(20, 20, headerTextureStyle);
	}
	
	/**
	 * Constructs with the specified initial width offset and height offset.
	 * @param widthOffset the width offset value
	 * @param heightOffset the height offset value
	 */
	public JRibbonTweenPanel(int widthOffset, int heightOffset)
	{
		this(widthOffset, heightOffset, new JBlueHeaderTextureStyle());
	}
	
	/**
	 * Constructs with the specified initial width offset, height offset and header texture style.
	 * @param widthOffset the width offset value
	 * @param heightOffset the height offset value
	 * @param headerTextureStyle the instance of IHeaderTextureStyle
	 */
	public JRibbonTweenPanel(int widthOffset, int heightOffset, IHeaderTextureStyle headerTextureStyle)
	{	
		this.widthOffset = widthOffset;
		this.heightOffset = heightOffset;
		this.headerTextureStyle = headerTextureStyle;
		
		shrinkHeader = new JShrinkHeader(JShrinkHeader.PLACEMENT_WEST, headerTextureStyle);
		shrinkHeader.setShrinkable(false);
		
		contentBar = new JPanel();
		contentBar.setLayout(new BorderLayout());
		contentBar.add(shrinkHeader, BorderLayout.NORTH);

		setContent(contentBar);
	}
	
	/**
	 * Gets the width offset.
	 * @return the width offset value
	 */
	public int getWidthOffset()
	{
		return widthOffset;
	}
	
	/**
	 * Gets the height offset.
	 * @return the height offset value
	 */
	public int getHeightOffset()
	{
		return heightOffset;
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
	
	/**
	 * Gets the content pane.
	 * @return the instance of JComponent
	 */
	public JComponent getContentPane()
	{
		return contentPane;
	}
	
	/**
	 * Sets the content pane.
	 * @param contentPane the instance of JComponent
	 */
	public void setContentPane(JComponent contentPane)
	{
		if (this.contentPane == contentPane)
		{
			return;
		}	
		
		if (this.contentPane != null)
		{
			contentBar.remove(this.contentPane);
		}	
		
		LineBorder lineBorder = new LineBorder(headerTextureStyle.getBorderColor());
		lineBorder.setColor(null, LineBorder.NORTH);
		
		this.contentPane = contentPane;
		this.contentPane.setBorder(BorderFactory.createCompoundBorder(lineBorder, this.contentPane.getBorder()));
		contentBar.add(this.contentPane, BorderLayout.CENTER);
		
		ContainerManager.update(contentBar);
	}
}