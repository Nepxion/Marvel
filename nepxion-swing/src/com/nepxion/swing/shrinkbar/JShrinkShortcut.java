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
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.SwingConstants;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.separator.JBasicSeparator;
import com.nepxion.swing.style.button.lite.LiteButtonUI;

public class JShrinkShortcut
	extends JPanel implements SwingConstants
{	
	private JLabel label;
	private JBasicSeparator separator;
	private JPanel separatorPanel;
	
	private JPanel buttonPanel;
	
	public JShrinkShortcut()
	{		
		initComponents();
	}
	
	private void initComponents()
	{		
		separator = new JBasicSeparator(JBasicSeparator.HORIZONTAL, JBasicSeparator.LOWERED_STYLE, -1);
		
		separatorPanel = new JPanel();
		separatorPanel.setLayout(new BorderLayout());
		separatorPanel.add(separator, BorderLayout.CENTER);
		separatorPanel.setOpaque(false);
		
		label = new JLabel();
		label.setOpaque(true);
		label.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 3));
		
		JPanel labelPanel = new JPanel();
		labelPanel.setOpaque(false);
		labelPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		labelPanel.setLayout(new BorderLayout());
		labelPanel.add(label, BorderLayout.WEST);
		
		JPanel borderPanel = new JPanel();
		borderPanel.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 1));
		borderPanel.setLayout(new OverlayLayout(borderPanel));
		borderPanel.add(labelPanel);
		borderPanel.add(separatorPanel);
		
		buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		buttonPanel.setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		
		setLayout(new BorderLayout());
		add(borderPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);
	}
	
	public String getTitle()
	{
		return label.getText();
	}
	
	public void setTitle(String title)
	{
		label.setText(title);
	}
	
	public Icon getIcon()
	{
		return label.getIcon();
	}
	
	public void setIcon(Icon icon)
	{
		label.setIcon(icon);
	}
	
	public String getToolTipText()
	{
		return label.getToolTipText();
	}
	
	public void setToolTipText(String toolTipText)
	{
		label.setToolTipText(toolTipText);
	}
	
	public Color getTitleColor()
	{	
		return label.getForeground();
	}
	
	public void setTitleColor(Color color)
	{		
		label.setForeground(color);
	}
	
	public Font getTitleFont()
	{
		return label.getFont();
	}
	
	public void setTitleFont(Font font)
	{
		label.setFont(font);
	}
	
	public void setSeparatorColor(Color[] colors)
	{
		if (colors != null)
		{	
			separator.setBrightColor(colors[0]);
			separator.setDarkColor(colors[1]);
		}
		else
		{
			separator.setBrightColor(Color.white);
			separator.setDarkColor(Color.gray);
		}
	}
	
	public JLabel getLabel()
	{
		return label;
	}
	
	protected void shrinkChanged(boolean shrinked)
	{
		label.setVisible(!shrinked);
		
		for (int i = 0; i < buttonPanel.getComponentCount(); i++)
		{
			Component component = buttonPanel.getComponent(i);
			
			if (component instanceof JBasicButton)
			{
				JBasicButton button = (JBasicButton) component;
				LiteButtonUI liteButtonUI = (LiteButtonUI) button.getUI();
				
				if (shrinked)
				{
					button.setText(null);
					liteButtonUI.setWidthOffset(0);
					liteButtonUI.setHeightOffset(0);
					
					ButtonManager.setButtonLayout(button, new int[] {HORIZONTAL, CENTER});
				}
				else
				{
					String text = (String) button.getClientProperty("shrinkText");
					button.setText(text);
					
					int widthOffset = ((Integer) button.getClientProperty("shrinkWidthOffset")).intValue();
					liteButtonUI.setWidthOffset(widthOffset);
					
					int heightOffset = ((Integer) button.getClientProperty("shrinkHeightOffset")).intValue();
					liteButtonUI.setHeightOffset(heightOffset);
					
					ButtonManager.setButtonLayout(button, new int[] {HORIZONTAL, LEFT});
				}
			}	
		}	
	}
	
	public JBasicButton getButton(int index)
	{
		return (JBasicButton) buttonPanel.getComponent(index);
	}
	
	public void addButton(JBasicButton button)
	{
		LiteButtonUI liteButtonUI = (LiteButtonUI) button.getUI();
		
		String text = button.getText();
		button.putClientProperty("shrinkText", text);
		
		int widthOffset = liteButtonUI.getWidthOffset();
		button.putClientProperty("shrinkWidthOffset", Integer.valueOf(widthOffset));
		
		int heightOffset = liteButtonUI.getHeightOffset();
		button.putClientProperty("shrinkHeightOffset", Integer.valueOf(heightOffset));
		
		ButtonManager.setButtonLayout(button, new int[] {HORIZONTAL, LEFT});
		
		buttonPanel.add(button);
	}
	
	public void deleteButton(JBasicButton button)
	{
		buttonPanel.remove(button);
	}
	
	public void deleteButton(int index)
	{
		buttonPanel.remove(index);
	}
	
	public void deleteAllButtons()
	{
		buttonPanel.removeAll();
	}
	
	public void setButtonList(List buttonList)
	{
		if (buttonList == null || buttonList.isEmpty())
		{
			return;
		}
		
		for (Iterator iterator = buttonList.iterator(); iterator.hasNext();)
		{
			JBasicButton button = (JBasicButton) iterator.next();
			
			addButton(button);
		}	
	}
}