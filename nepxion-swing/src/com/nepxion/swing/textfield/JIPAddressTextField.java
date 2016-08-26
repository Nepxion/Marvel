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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.textfield.number.JNumberTextField;
import com.nepxion.swing.tip.balloon.JBalloonTip;

public class JIPAddressTextField
	extends JBasicTextField
{
	private JNumberTextField ipAddressTextField1;
	private JNumberTextField ipAddressTextField2;
	private JNumberTextField ipAddressTextField3;
	private JNumberTextField ipAddressTextField4;
	
	private int align = LEFT;
	
	public JIPAddressTextField()
	{
		this(LEFT);
	}
	
	public JIPAddressTextField(int align)
	{
		this(null, align);
	}
	
	public JIPAddressTextField(String ipAddress)
	{
		this(ipAddress, LEFT);
	}
	
	public JIPAddressTextField(String ipAddress, int align)
	{
		super();
		
		this.align = align;
		
		ipAddressTextField1 = createTextField();
		JLabel dotLabel1 = createLabel();
		ipAddressTextField2 = createTextField();
		JLabel dotLabel2 = createLabel();
		ipAddressTextField3 = createTextField();
		JLabel dotLabel3 = createLabel();
		ipAddressTextField4 = createTextField();
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setFocusable(false);
		
		if (align != LEFT)
		{
			add(Box.createHorizontalStrut(20));
		}
		add(ipAddressTextField1);
		add(dotLabel1);
		add(ipAddressTextField2);
		add(dotLabel2);
		add(ipAddressTextField3);
		add(dotLabel3);
		add(ipAddressTextField4);
		if (align != LEFT)
		{
			add(Box.createHorizontalStrut(20));
		}
		
		removeMouseListener(getPopupMenuAdapter());
		
		setIPAddress(ipAddress);
	}
	
	private JNumberTextField createTextField()
	{
		final JNumberTextField ipAddressTextField = new JNumberTextField(3, 0, 0, 255)
		{
			public boolean exclude(String value)
			{
				if (value.equals("."))
				{
					transferFocus();
					
					return true;
				}
				
				return false;
			}
		};
		ipAddressTextField.setHorizontalAlignment(RIGHT);
		ipAddressTextField.setBorder(null);
		ipAddressTextField.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent e)
			{				
				char c = e.getKeyChar();				
				boolean isDigit = Character.isDigit(c);	
				
				JBalloonTip balloonTip = ipAddressTextField.getBalloonTip();
				int length = ipAddressTextField.getText().length();
				if (!balloonTip.isVisible() && isDigit && length == 3)
				{	
					ipAddressTextField.transferFocus();
				}
			}
		}
		);
		
		if (align == LEFT)
		{	
			DimensionManager.setDimension(ipAddressTextField, new Dimension(30, getPreferredSize().height));
		}
		
		return ipAddressTextField;
	}
	
	private JLabel createLabel()
	{
		JLabel label = new JLabel(".");
		label.setPreferredSize(new Dimension(2, getPreferredSize().height));
		
		return label;
	}
	
	public void setEnabled(boolean enabled)
	{
		super.setEnabled(enabled);
		
		if (ipAddressTextField1 != null && ipAddressTextField2 != null && ipAddressTextField3 != null && ipAddressTextField4 != null)
		{	
			ipAddressTextField1.setEnabled(enabled);
			ipAddressTextField2.setEnabled(enabled);
			ipAddressTextField3.setEnabled(enabled);
			ipAddressTextField4.setEnabled(enabled);
		}
	}
	
	public void setEditable(boolean editable)
	{
		super.setEditable(editable);
		
		if (ipAddressTextField1 != null && ipAddressTextField2 != null && ipAddressTextField3 != null && ipAddressTextField4 != null)
		{
			ipAddressTextField1.setEditable(editable);
			ipAddressTextField2.setEditable(editable);
			ipAddressTextField3.setEditable(editable);
			ipAddressTextField4.setEditable(editable);
		}
	}
	
	public void setBackground(Color bg)
	{
		super.setBackground(bg);
		
		if (ipAddressTextField1 != null && ipAddressTextField2 != null && ipAddressTextField3 != null && ipAddressTextField4 != null)
		{
			ipAddressTextField1.setBackground(bg);
			ipAddressTextField2.setBackground(bg);
			ipAddressTextField3.setBackground(bg);
			ipAddressTextField4.setBackground(bg);
		}
	}
	
	public void setForeground(Color fg)
	{
		super.setForeground(fg);
		
		if (ipAddressTextField1 != null && ipAddressTextField2 != null && ipAddressTextField3 != null && ipAddressTextField4 != null)
		{
			ipAddressTextField1.setForeground(fg);
			ipAddressTextField2.setForeground(fg);
			ipAddressTextField3.setForeground(fg);
			ipAddressTextField4.setForeground(fg);
		}
	}
	
	public void setFont(Font f)
	{
		super.setFont(f);
		
		if (ipAddressTextField1 != null && ipAddressTextField2 != null && ipAddressTextField3 != null && ipAddressTextField4 != null)
		{
			ipAddressTextField1.setFont(f);
			ipAddressTextField2.setFont(f);
			ipAddressTextField3.setFont(f);
			ipAddressTextField4.setFont(f);
		}
	}
	
	public void setOpaque(boolean isOpaque)
	{
		super.setOpaque(isOpaque);
		
		if (ipAddressTextField1 != null && ipAddressTextField2 != null && ipAddressTextField3 != null && ipAddressTextField4 != null)
		{
			ipAddressTextField1.setOpaque(isOpaque);
			ipAddressTextField2.setOpaque(isOpaque);
			ipAddressTextField3.setOpaque(isOpaque);
			ipAddressTextField4.setOpaque(isOpaque);
		}
	}
	
	public void setIPAddress(String ipAddress)
	{
		if (ipAddress == null || ipAddress.equals(""))
		{
			ipAddressTextField1.setText("");
			ipAddressTextField2.setText("");
			ipAddressTextField3.setText("");
			ipAddressTextField4.setText("");
		}
		else
		{
			if ((ipAddress.indexOf(".") == -1) || (ipAddress.split("\\.").length != 4))
			{
				throw new IllegalArgumentException(SwingLocale.getString("invalid_ip_address") + " : " + ipAddress);
			}
			String ipAddresses[] = ipAddress.split("\\.");
			
			try
			{
				int number1 = Integer.parseInt(ipAddresses[0]);
				int number2 = Integer.parseInt(ipAddresses[1]);
				int number3 = Integer.parseInt(ipAddresses[2]);
				int number4 = Integer.parseInt(ipAddresses[3]);
				
				if (number1 < 0 || number1 > 255 || number2 < 0 || number2 > 255 || number3 < 0 || number3 > 255 || number4 < 0 || number4 > 255)
				{
					throw new IllegalArgumentException(SwingLocale.getString("invalid_ip_address") + " : " + ipAddress);
				}
			}
			catch (NumberFormatException e)
			{
				throw new IllegalArgumentException(SwingLocale.getString("invalid_ip_address") + " : " + ipAddress);
			}
			
			ipAddressTextField1.setText(ipAddresses[0]);
			ipAddressTextField2.setText(ipAddresses[1]);
			ipAddressTextField3.setText(ipAddresses[2]);
			ipAddressTextField4.setText(ipAddresses[3]);
		}
	}
	
	public String getIPAddress()
	{
		String ipAddress1 = ipAddressTextField1.getText().trim();
		String ipAddress2 = ipAddressTextField2.getText().trim();
		String ipAddress3 = ipAddressTextField3.getText().trim();
		String ipAddress4 = ipAddressTextField4.getText().trim();
		if (ipAddress1.equals("") && ipAddress2.equals("") && ipAddress3.equals("") && ipAddress4.equals(""))
		{
			return "";
		}
		
		return (ipAddress1.equals("") ? "0" : ipAddress1) + "." + (ipAddress2.equals("") ? "0" : ipAddress2) + "." + (ipAddress3.equals("") ? "0" : ipAddress3) + "." + (ipAddress4.equals("") ? "0" : ipAddress4);
	}
	
	public void setText(String text)
	{
		setIPAddress(text);
	}
	
	public String getText()
	{
		return getIPAddress();
	}
}