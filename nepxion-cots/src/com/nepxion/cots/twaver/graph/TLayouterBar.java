package com.nepxion.cots.twaver.graph;

/**
 * <p>Title: Nepxion Cots For TWaver</p>
 * <p>Description: Nepxion Cots Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * <p>Announcement: It depends on the commercial software of TWaver, the repository only references the trial version.</p>
 * <p>If you want to use Nepxion Cots, please contact with Serva Corporation to buy the genuine version.</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.cots.twaver.locale.TLocale;
import com.nepxion.swing.outlookbar.JFlatOutlookBar;

public class TLayouterBar
	extends JFlatOutlookBar
{
	public TLayouterBar(TGraph graph)
	{
		TLayoutPanel layoutPanel = new TLayoutPanel(graph);
		TLiteLayoutPanel liteLayoutPanel = new TLiteLayoutPanel(graph);
		
		addTab(TLocale.getString("layout_box_base"), null, makeScrollPane(layoutPanel), TLocale.getString("layout_box_base"));
		addTab(TLocale.getString("layout_box_extra"), null, makeScrollPane(liteLayoutPanel), TLocale.getString("layout_box_extra"));
	}
}