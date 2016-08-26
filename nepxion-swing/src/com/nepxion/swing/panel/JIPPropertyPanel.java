package com.nepxion.swing.panel;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.checkbox.JBasicCheckBox;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.radiobutton.JBasicRadioButton;
import com.nepxion.swing.textfield.JIPAddressTextField;

public class JIPPropertyPanel
	extends JPanel
{
	private JBasicRadioButton dhcpIPAddressRadioButton;
	private JBasicRadioButton useIPAddressRadioButton;
	
	private JLabel ipAddressLabel;
	private JIPAddressTextField ipAddressTextField;
	
	private JLabel subnetMaskLabel;
	private JIPAddressTextField subnetMaskTextField;
	
	private JLabel defaultGatewayLabel;
	private JIPAddressTextField defaultGatewayTextField;
	
	private JBasicRadioButton dhcpDNSRadioButton;
	private JBasicRadioButton useDNSRadioButton;
	
	private JLabel preferredDNSLabel;
	private JIPAddressTextField preferredDNSTextField;
	
	private JLabel alternateDNSLabel;
	private JIPAddressTextField alternateDNSTextField;
	
	private JBasicCheckBox showIconCheckBox;
	
	public JIPPropertyPanel()
	{
		add(new IPAddressPanel());
		add(new DNSPanel());
		add(new ShowIconPanel());
		
		DimensionManager.setDimension(this, new Dimension(425, 350));
	}
	
	public String getIPAddress()
	{
		return ipAddressTextField.getIPAddress();
	}
	
	public void setIPAddress(String ipAddress)
	{
		ipAddressTextField.setIPAddress(ipAddress);
	}
	
	public String getSubnetMask()
	{
		return subnetMaskTextField.getIPAddress();
	}
	
	public void setSubnetMask(String subnetMask)
	{
		subnetMaskTextField.setIPAddress(subnetMask);
	}
	
	public String getDefaultGateway()
	{
		return defaultGatewayTextField.getIPAddress();
	}
	
	public void setDefaultGateway(String defaultGateway)
	{
		defaultGatewayTextField.setIPAddress(defaultGateway);
	}
	
	public String getPreferredDNS()
	{
		return preferredDNSTextField.getIPAddress();
	}
	
	public void setPreferredDNS(String preferredDNS)
	{
		preferredDNSTextField.setIPAddress(preferredDNS);
	}
	
	public String getAlternateDNS()
	{
		return alternateDNSTextField.getIPAddress();
	}
	
	public void setAlternateDNS(String alternateDNS)
	{
		alternateDNSTextField.setIPAddress(alternateDNS);
	}
	
	public void setIconShown(boolean isIconShown)
	{
		showIconCheckBox.setSelected(isIconShown);
	}
	
	public boolean isIconShown()
	{
		return showIconCheckBox.isSelected();
	}
	
	public class IPAddressPanel
		extends JPanel
	{
		public IPAddressPanel()
		{
			dhcpIPAddressRadioButton = new JBasicRadioButton(SwingLocale.getString("dhcp_ip_address"));
			dhcpIPAddressRadioButton.setPreferredSize(new Dimension(170, 22));
			
			useIPAddressRadioButton = new JBasicRadioButton(SwingLocale.getString("use_ip_address"), true);
			useIPAddressRadioButton.setPreferredSize(new Dimension(205, 22));
			useIPAddressRadioButton.addItemListener(new IPAddressItemLister());
			
			ButtonGroup buttonGroup = new ButtonGroup();
			buttonGroup.add(dhcpIPAddressRadioButton);
			buttonGroup.add(useIPAddressRadioButton);
			
			ipAddressLabel = new JLabel(SwingLocale.getString("ip_address"));
			ipAddressLabel.setPreferredSize(new Dimension(120, 22));
			
			ipAddressTextField = new JIPAddressTextField();
			ipAddressTextField.setPreferredSize(new Dimension(245, 22));
			
			subnetMaskLabel = new JLabel(SwingLocale.getString("subnet_mask"));
			subnetMaskLabel.setPreferredSize(new Dimension(120, 22));
			
			subnetMaskTextField = new JIPAddressTextField();
			subnetMaskTextField.setPreferredSize(new Dimension(245, 22));
			
			defaultGatewayLabel = new JLabel(SwingLocale.getString("default_gateway"));
			defaultGatewayLabel.setPreferredSize(new Dimension(120, 22));
			
			defaultGatewayTextField = new JIPAddressTextField();
			defaultGatewayTextField.setPreferredSize(new Dimension(245, 22));
			
			setBorder(BorderFactory.createTitledBorder(SwingLocale.getString("ip_config")));
			setPreferredSize(new Dimension(410, 147));
			
			add(dhcpIPAddressRadioButton);
			add(useIPAddressRadioButton);
			
			add(ipAddressLabel);
			add(ipAddressTextField);
			
			add(subnetMaskLabel);
			add(subnetMaskTextField);
			
			add(defaultGatewayLabel);
			add(defaultGatewayTextField);
		}
	}
	
	public class IPAddressItemLister
		implements ItemListener
	{
		public void itemStateChanged(ItemEvent e)
		{
			JBasicRadioButton radioButton = (JBasicRadioButton) e.getSource();
			
			ipAddressLabel.setEnabled(radioButton.isSelected());
			ipAddressTextField.setEnabled(radioButton.isSelected());
			
			subnetMaskLabel.setEnabled(radioButton.isSelected());
			subnetMaskTextField.setEnabled(radioButton.isSelected());
			
			defaultGatewayLabel.setEnabled(radioButton.isSelected());
			defaultGatewayTextField.setEnabled(radioButton.isSelected());
			
			dhcpDNSRadioButton.setEnabled(!radioButton.isSelected());
			if (radioButton.isSelected())
			{
				useDNSRadioButton.setSelected(true);
			}
			else
			{
				useDNSRadioButton.setEnabled(true);
			}
		}
	}
	
	public class DNSPanel
		extends JPanel
	{
		public DNSPanel()
		{
			dhcpDNSRadioButton = new JBasicRadioButton(SwingLocale.getString("dhcp_dns_server_address"));
			dhcpDNSRadioButton.setPreferredSize(new Dimension(170, 22));
			dhcpDNSRadioButton.setEnabled(false);
			
			useDNSRadioButton = new JBasicRadioButton(SwingLocale.getString("use_dns_server_address"), true);
			useDNSRadioButton.setPreferredSize(new Dimension(205, 22));
			useDNSRadioButton.addItemListener(new DNSItemLister());
			
			ButtonGroup buttonGroup = new ButtonGroup();
			buttonGroup.add(dhcpDNSRadioButton);
			buttonGroup.add(useDNSRadioButton);
			
			preferredDNSLabel = new JLabel(SwingLocale.getString("preferred_dns_server"));
			preferredDNSLabel.setPreferredSize(new Dimension(120, 22));
			
			preferredDNSTextField = new JIPAddressTextField();
			preferredDNSTextField.setPreferredSize(new Dimension(245, 22));
			
			alternateDNSLabel = new JLabel(SwingLocale.getString("alternate_dns_server"));
			alternateDNSLabel.setPreferredSize(new Dimension(120, 22));
			
			alternateDNSTextField = new JIPAddressTextField();
			alternateDNSTextField.setPreferredSize(new Dimension(245, 22));
			
			setBorder(BorderFactory.createTitledBorder(SwingLocale.getString("dns_config")));
			setPreferredSize(new Dimension(410, 120));
			
			add(dhcpDNSRadioButton);
			add(useDNSRadioButton);
			
			add(preferredDNSLabel);
			add(preferredDNSTextField);
			
			add(alternateDNSLabel);
			add(alternateDNSTextField);
		}
	}
	
	public class DNSItemLister
		implements ItemListener
	{
		public void itemStateChanged(ItemEvent e)
		{
			JBasicRadioButton radioButton = (JBasicRadioButton) e.getSource();
			
			preferredDNSLabel.setEnabled(radioButton.isSelected());
			preferredDNSTextField.setEnabled(radioButton.isSelected());
			
			alternateDNSLabel.setEnabled(radioButton.isSelected());
			alternateDNSTextField.setEnabled(radioButton.isSelected());
		}
	}
	
	public class ShowIconPanel
		extends JPanel
	{
		public ShowIconPanel()
		{
			showIconCheckBox = new JBasicCheckBox(SwingLocale.getString("show_icon"), SwingLocale.getString("show_icon"));
			showIconCheckBox.setPreferredSize(new Dimension(410, 22));
			add(showIconCheckBox);
			
			setPreferredSize(new Dimension(410, 24));
		}
	}
}