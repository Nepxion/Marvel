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

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.swing.JPanel;

import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.table.JBasicTable;
import com.nepxion.swing.table.MapTableModel;

public class JLoginInfoPanel
	extends JPanel
{
	public static final String[] COLUMN_NAMES = {SwingLocale.getString("parameter"), SwingLocale.getString("value")};
	
	public JLoginInfoPanel(String account, String role, String ipAddress)
	{
		this(createRowDatas(account, role, ipAddress));
	}
	
	public JLoginInfoPanel(List rowDatas)
	{
		MapTableModel model = new MapTableModel(rowDatas, COLUMN_NAMES);
		JBasicTable table = new JBasicTable(model);
		
		JBasicScrollPane scrollPane = new JBasicScrollPane();
		scrollPane.getViewport().add(table);
		
		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public static List createRowDatas(String account, String role, String ipAddress)
	{
		LinkedHashMap accountMap = new LinkedHashMap();
		accountMap.put("key", SwingLocale.getString("account"));
		accountMap.put("value", account);
		
		LinkedHashMap roleMap = new LinkedHashMap();
		roleMap.put("key", SwingLocale.getString("role"));
		roleMap.put("value", role);
		
		LinkedHashMap ipAddressMap = new LinkedHashMap();
		ipAddressMap.put("key", SwingLocale.getString("ip_address"));
		ipAddressMap.put("value", ipAddress);
		
		List rowDatas = new ArrayList();
		rowDatas.add(accountMap);
		rowDatas.add(roleMap);
		rowDatas.add(ipAddressMap);
		
		return rowDatas;
	}
}