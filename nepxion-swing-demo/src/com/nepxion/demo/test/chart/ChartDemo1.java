package com.nepxion.demo.test.chart;

import java.awt.Font;
import java.awt.RenderingHints;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.general.DefaultPieDataset;

import com.nepxion.swing.chart.JChartFactory;
import com.nepxion.swing.chart.JChartPanel;

public class ChartDemo1
{
	public static void main(String[] args)
	{
		DefaultPieDataset dfp = new DefaultPieDataset();
		
		dfp.setValue("������Ա", 110);
		dfp.setValue("������Ա", 8);
		dfp.setValue("����", 4);
		dfp.setValue("���ž���", 8);
		dfp.setValue("������Ա", 15);
		// ͨ�õ���������������
		StandardChartTheme theme = new StandardChartTheme("unicode")
		{
			public void apply(JFreeChart chart)
			{
				chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
				super.apply(chart);
			}
		};
		theme.setExtraLargeFont(new Font("����", Font.PLAIN, 14));
		theme.setLargeFont(new Font("����", Font.PLAIN, 14));
		theme.setRegularFont(new Font("����", Font.PLAIN, 12));
		theme.setSmallFont(new Font("����", Font.PLAIN, 10));
		ChartFactory.setChartTheme(theme);
		
		JFreeChart jfreeChart = ChartFactory.createPieChart("ȫ����Ա��Ϣͼ", dfp, true, true, true);
		JChartPanel chartPanel = JChartFactory.createChartPanel(jfreeChart);
		
		JFrame f = new JFrame();
		f.getContentPane().add(chartPanel);
		f.pack();
		f.setVisible(true);
		
//		ChartFrame chartFrame = new ChartFrame("ȫ����Ա��Ϣͼ", jfreeChart, true);
//		chartFrame.pack();
//		chartFrame.setVisible(true);
	}
}
