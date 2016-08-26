package com.nepxion.demo.component.searcher.gis.google.loc;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.searcher.gis.google.loc.JCellPanel;
import com.nepxion.util.searcher.gis.google.loc.LocConstants;

public class DemoCellPanel
	extends JPanel
{
	public DemoCellPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new CellPanel());
	}
	
	public class CellPanel
		extends JPanel
	{
		public CellPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("根据移动信息查询地理位置"));
			
			JCellPanel cellPanel = new JCellPanel();
			cellPanel.setCellID(19625);
			cellPanel.setLac(22770);
			cellPanel.setMcc(LocConstants.DEFAULT_MCC);
			cellPanel.setMnc(LocConstants.DEFAULT_MNC);
			
			add(cellPanel);
		}
	}
}