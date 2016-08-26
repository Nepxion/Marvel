package com.nepxion.demo.test.chart;

import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

public class ChartDemo2
{
	public static void main(String[] args)
	{
		DefaultPieDataset dpd = new DefaultPieDataset();
		dpd.setValue("���²�", 15);
		dpd.setValue("�г���", 20);
		dpd.setValue("������", 21);
		dpd.setValue("������", 16);
		
		JFreeChart chart = ChartFactory.createPieChart("��˾��Ա��Ϣ", dpd, true, true, false);
		// ���ñ������֣��������������� �˴�ΪͼƬ���Ϸ�����
		chart.setTitle(new TextTitle("��˾��Ա��Ϣ", new Font("����", Font.BOLD, 16)));
		// ȡ��ͳһ��ĵ�һ��ͼ��
		LegendTitle legend = chart.getLegend(0);
		// �޸�ͼ������
		legend.setItemFont(new Font("����", Font.BOLD, 14));
		// ȡ�ñ�ͼplot����
		PiePlot plot = (PiePlot) chart.getPlot();
		// ���ñ�ͼ�����ֱ�ǩ����
		plot.setLabelFont(new Font("����", Font.ITALIC, 20));
		// ���ñ�������
		// ��������ʾ
		ChartPanel chartpanel = new ChartPanel(chart);
		
		ChartFrame chartFrame = new ChartFrame("��˾��Ա��Ϣ", chart);
		chartFrame.pack();
		chartFrame.setVisible(true);
		
		// ��������Ϊjpg�ļ�д�뵽c�̸�Ŀ¼��
		try
		{
			FileOutputStream fos = new FileOutputStream("c:\\test.jpg");
			ChartUtilities.writeChartAsJPEG(fos, chart, 300, 400);
			fos.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}