package com.nepxion.swing.textfield;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.text.Document;

import com.nepxion.swing.textcomponent.TextPopupMenuAdapter;
import com.nepxion.swing.tip.balloon.BalloonTipDecoration;
import com.nepxion.swing.tip.balloon.JBalloonTip;

public class JBasicTextField
	extends JTextField implements ActionListener, FocusListener
{
	private boolean isEnterAcceleratorSupported; // 支持回车切换到下一焦点
	private boolean isSelectionAllSupported; // 支持得到焦点就全选文字
	
	private BalloonTipDecoration toolTipDecoration;
	
	private TextPopupMenuAdapter popupMenuAdapter;
	
	public JBasicTextField()
	{
		super();
		
		initComponents();
	}
	
	public JBasicTextField(Document doc, String text, int columns)
	{
		super(doc, text, columns);
		
		initComponents();
	}
	
	public JBasicTextField(int columns)
	{
		super(columns);
		
		initComponents();
	}
	
	public JBasicTextField(String text, int columns)
	{
		super(text, columns);
		
		initComponents();
	}
	
	public JBasicTextField(String text)
	{
		super(text);
		
		initComponents();
	}
	
	private void initComponents()
	{
		popupMenuAdapter = new TextPopupMenuAdapter(this);
		
		toolTipDecoration = new BalloonTipDecoration(this);
		
		supportEnterAccelerator(true);
		// supportSelectionAll(true);
	}
	
	public boolean isEnterAcceleratorSupported()
	{
		return isEnterAcceleratorSupported;
	}
	
	public void supportEnterAccelerator(boolean isEnterAcceleratorSupported)
	{
		this.isEnterAcceleratorSupported = isEnterAcceleratorSupported;
		
		if (isEnterAcceleratorSupported)
		{
			addActionListener(this);
		}
		else
		{
			removeActionListener(this);
		}
	}
	
	public boolean isSelectionAllSupported()
	{
		return isSelectionAllSupported;
	}
	
	public void supportSelectionAll(boolean isSelectionAllSupported)
	{
		this.isSelectionAllSupported = isSelectionAllSupported;
		
		if (isSelectionAllSupported)
		{
			addFocusListener(this);
		}
		else
		{
			removeFocusListener(this);
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		transferFocus();
	}
	
	public void focusGained(FocusEvent e)
	{
		selectAll();
	}
	
	public void focusLost(FocusEvent e)
	{
		
	}
	
	public TextPopupMenuAdapter getPopupMenuAdapter()
	{
		return popupMenuAdapter;
	}
	
	public void showTip(String tipText)
	{
		showTip(tipText, JBalloonTip.TIP_ICON_ERROR, 2, 16);
	}
	
	public void showTip(String tipText, int rows, int columns)
	{
		showTip(tipText, JBalloonTip.TIP_ICON_ERROR, rows, columns);
	}
	
	public void showTip(String tipText, Icon tipIcon)
	{
		showTip(tipText, JBalloonTip.TIP_ICON_ERROR, 2, 16);
	}
	
	public void showTip(String tipText, Icon tipIcon, int rows, int columns)
	{
		JBalloonTip balloonTip = getBalloonTip();
		if (balloonTip.isVisible())
		{
			return;
		}
		
		requestFocus();
		
		balloonTip.setMinimumRows(rows);
		balloonTip.setColumns(columns);
		balloonTip.setText(tipText);
		balloonTip.setIcon(tipIcon);
		balloonTip.setVisible(true);
	}
	
	public JBalloonTip getBalloonTip()
	{
		return toolTipDecoration.getBalloonTip();
	}
	
	public void setEnabled(boolean enabled)
	{
		super.setEnabled(enabled);
		
		if (enabled)
		{
			addMouseListener(popupMenuAdapter);
		}
		else
		{
			removeMouseListener(popupMenuAdapter);
		}
	}
	
	public void setLabelStyle()
	{
		TextFieldManager.setLabelStyle(this);
		
		removeMouseListener(popupMenuAdapter);
	}
}