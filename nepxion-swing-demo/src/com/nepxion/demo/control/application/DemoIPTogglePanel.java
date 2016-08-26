package com.nepxion.demo.control.application;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.Icon;

import com.nepxion.demo.common.DemoTogglePanel;
import com.nepxion.demo.common.DemoToggleTemplate;
import com.nepxion.demo.component.searcher.ip.local.DemoIPPanel;
import com.nepxion.demo.component.searcher.ip.local.DemoAddressPanel;
import com.nepxion.demo.component.searcher.ip.netease.DemoNeteaseIPPanel;
import com.nepxion.demo.component.searcher.ip.sina.DemoSinaIPPanel;
import com.nepxion.demo.component.searcher.ip.tencent.DemoTencentIPPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoIPTogglePanel
	extends DemoTogglePanel
{
	public DemoIPTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("ģ����ѯ - ���ؽӿ�", IconFactory.getSwingIcon("component/application_16.png"), new DemoToggleTemplate(new DemoAddressPanel()), "ģ����ѯ����λ�� - ���ؽӿ�");
		toggleTabbedPane.addTab("����IP��ַ��ѯ - ���ؽӿ�", IconFactory.getSwingIcon("component/application_16.png"), new DemoToggleTemplate(new DemoIPPanel()), "����IP��ַ��ѯ����λ�� - ���ؽӿ�");
		toggleTabbedPane.addTab("����IP��ַ��ѯ - ���׽ӿ�", IconFactory.getSwingIcon("component/application_16.png"), new DemoToggleTemplate(new DemoNeteaseIPPanel()), "����IP��ַ��ѯ����λ�� - ���׽ӿ�");
		toggleTabbedPane.addTab("����IP��ַ��ѯ - ���˽ӿ�", IconFactory.getSwingIcon("component/application_16.png"), new DemoToggleTemplate(new DemoSinaIPPanel()), "����IP��ַ��ѯ����λ�� - ���˽ӿ�");
		toggleTabbedPane.addTab("����IP��ַ��ѯ - ��Ѷ�ӿ�", IconFactory.getSwingIcon("component/application_16.png"), new DemoToggleTemplate(new DemoTencentIPPanel()), "����IP��ַ��ѯ����λ�� - ��Ѷ�ӿ�");		
	}	
	
	public String getToggleText()
	{
		return "IP";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/application_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/application_32.png");
	}
	
	public String getToggleDescription()
	{
		return "IP - ���ؽӿڣ����׽ӿڣ����˽ӿڣ���Ѷ�ӿ�Ӧ��";
	}
}