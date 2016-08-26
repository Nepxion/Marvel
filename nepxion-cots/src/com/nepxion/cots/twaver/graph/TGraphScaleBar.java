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

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.text.NumberFormat;

import javax.swing.JLabel;

import twaver.ZoomListener;

import com.nepxion.cots.twaver.icon.TIconFactory;
import com.nepxion.cots.twaver.locale.TLocale;
import com.nepxion.swing.separator.JBasicSeparator;
import com.nepxion.swing.statusbar.JStatusBar;
import com.nepxion.swing.statusbar.JStatusItem;

public class TGraphScaleBar
	extends JStatusBar
{
	public TGraphScaleBar(final TGraph graph)
	{
		setSeparatorHeight(13);
		
		final JLabel zoomLabel = new JLabel(TIconFactory.getContextIcon("zoom.png"));
		
		final JLabel positionLabel = new JLabel(TIconFactory.getContextIcon("scale.png"));
		positionLabel.setText("x:0 y:0");
		
		addItem(new JStatusItem(zoomLabel), 90, LEFT, JBasicSeparator.LOWERED_STYLE, true);
		addItem(new JStatusItem(positionLabel), 130, LEFT, JBasicSeparator.LOWERED_STYLE, false);

		graph.getCanvas().addMouseListener(new MouseAdapter()
		{
			public void mouseExited(MouseEvent e)
			{
				update(zoomLabel, positionLabel, graph, null);
			}
		}
		);
		
		graph.getCanvas().addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{
				update(zoomLabel, positionLabel, graph, e.getPoint());
			}
			
			public void mouseMoved(MouseEvent e)
			{
				update(zoomLabel, positionLabel, graph, e.getPoint());
			}
		}
		);
		
		graph.getCanvas().addMouseWheelListener(new MouseWheelListener()
		{
			public void mouseWheelMoved(MouseWheelEvent e)
			{
				update(zoomLabel, positionLabel, graph, e.getPoint());
			}
		}
		);
		
		graph.getZoomer().addZoomListener(new ZoomListener()
		{
			public void zoomChanged(double oldZoom, double newZoom)
			{
				update(zoomLabel, positionLabel, graph, null);
			}
		}
		);
		
		update(zoomLabel, positionLabel, graph, null);
	}
	
	private void update(JLabel zoomLabel, JLabel positionLabel, TGraph graph, Point point)
	{
		double zoom = graph.getZoom();
		
		NumberFormat format = NumberFormat.getInstance();
		format.setMaximumFractionDigits(2);
		zoomLabel.setText(TLocale.getString("graph_zoom") + ":" + format.format(zoom));
		
		if (point != null)
		{
			int x = (int) (point.getX() / zoom);
			int y = (int) (point.getY() / zoom);
			
			positionLabel.setText("x:" + x + " y:" + y);
		}
	}
}