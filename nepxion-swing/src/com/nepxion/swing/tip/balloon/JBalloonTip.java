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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.textarea.JAutoResizableTextArea;

public class JBalloonTip
	extends AbstractBalloonTip
{
	public static final ImageIcon TIP_ICON_ERROR_MESSAGE = IconFactory.getSwingIcon("error_message.png");
	public static final ImageIcon TIP_ICON_WARNING_MESSAGE = IconFactory.getSwingIcon("warning_message.png");
	public static final ImageIcon TIP_ICON_INFORMATION_MESSAGE = IconFactory.getSwingIcon("information_message.png");
	public static final ImageIcon TIP_ICON_QUESTION_MESSAGE = IconFactory.getSwingIcon("question_message.png");
	
	public static final ImageIcon TIP_ICON_ERROR = IconFactory.getSwingIcon("error.png");
	public static final ImageIcon TIP_ICON_WARNING = IconFactory.getSwingIcon("warning.png");
	public static final ImageIcon TIP_ICON_INFORMATION = IconFactory.getSwingIcon("information.png");
	public static final ImageIcon TIP_ICON_QUESTION = IconFactory.getSwingIcon("question.png");
	
	public static final int TIP_MINIMUM_ROWS = 1;
	public static final int TIP_MAXIMUM_ROWS = 50;
	public static final int TIP_COLUMNS = 20;
	
	public static final Border TIP_LABEL_BORDER = BorderFactory.createEmptyBorder(0, 0, 0, 0);
	public static final Border TIP_TEXTAREA_BORDER = BorderFactory.createEmptyBorder(0, 0, 0, 0);
	
	private JLabel label;
	private JAutoResizableTextArea textArea;
	
	public JBalloonTip(Component component)
	{
		this(component, "");
	}
	
	public JBalloonTip(Component component, String tipText)
	{
		this(component, TIP_MINIMUM_ROWS, TIP_MAXIMUM_ROWS, TIP_COLUMNS, tipText);
	}
	
	public JBalloonTip(Component component, int minimumRows, int maximumRows, int columns, String tipText)
	{
		this(component, minimumRows, maximumRows, columns, tipText, TIP_ICON_ERROR_MESSAGE, TIP_COLOR, TIP_OFFSET, TIP_LABEL_BORDER, TIP_TEXTAREA_BORDER);
	}
	
	public JBalloonTip(Component component, int minimumRows, int maximumRows, int columns, String tipText, Icon tipIcon, Color tipColor, int tipOffset, Border tipLabelBorder, Border tipTextAreaBorder)
	{
		super(component, tipColor, tipOffset);
		
		label = new JLabel();
		label.setBackground(tipColor);
		label.setOpaque(true);
		
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new BorderLayout());
		labelPanel.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
		labelPanel.setBackground(tipColor);
		labelPanel.add(label, BorderLayout.NORTH);
		
		textArea = new JAutoResizableTextArea(minimumRows, maximumRows, columns);
		textArea.setLabelStyle();
		textArea.setBackground(tipColor);
		textArea.setOpaque(true);
		
		JBasicScrollPane scrollPane = new JBasicScrollPane();
		scrollPane.setLabelStyle();
		scrollPane.setBackground(tipColor);
		scrollPane.getViewport().add(textArea);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(5, 5));
		panel.setBackground(tipColor);
		panel.setOpaque(true);
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 0));
		panel.add(labelPanel, BorderLayout.WEST);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		setLayout(new BorderLayout());
		add(panel, BorderLayout.CENTER);
		
		setTipLabelBorder(tipLabelBorder);
		setTipTextAreaBorder(tipTextAreaBorder);
		setText(tipText);
		setIcon(tipIcon);
		
		label.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				if (isVisible())
				{
					setVisible(false);
				}
			}
		}
		);
		textArea.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				if (isVisible())
				{
					setVisible(false);
				}
			}
		}
		);
	}
	
	public JLabel getLabel()
	{
		return label;
	}
	
	public JAutoResizableTextArea getTextArea()
	{
		return textArea;
	}
	
	public void setText(String text)
	{
		textArea.setText(text);
		textArea.setCaretPosition(0);
	}
	
	public void setIcon(Icon icon)
	{
		label.setIcon(icon);
	}
	
	public void setMinimumRows(int minimumRows)
	{
		textArea.setMinRows(minimumRows);
	}
	
	public void setMaximumRows(int maximumRows)
	{
		textArea.setMaxRows(maximumRows);
	}
	
	public void setColumns(int columns)
	{
		textArea.setColumns(columns);
	}
	
	public void setWidth(int width)
	{
		setPreferredSize(new Dimension(width, getPreferredSize().height));
	}
	
	public void setHeight(int height)
	{
		setPreferredSize(new Dimension(getPreferredSize().width, height));
	}
	
	private void setTipLabelBorder(Border tipLabelBorder)
	{
		label.setBorder(tipLabelBorder);
	}
	
	private void setTipTextAreaBorder(Border tipTextAreaBorder)
	{
		textArea.setBorder(tipTextAreaBorder);
	}
}