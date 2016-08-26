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
		dpd.setValue("人事部", 15);
		dpd.setValue("市场部", 20);
		dpd.setValue("物流部", 21);
		dpd.setValue("开发部", 16);
		
		JFreeChart chart = ChartFactory.createPieChart("公司人员信息", dpd, true, true, false);
		// 设置标题文字，并将其字体设置 此处为图片正上方文字
		chart.setTitle(new TextTitle("公司人员信息", new Font("黑体", Font.BOLD, 16)));
		// 取得统一表的第一个图列
		LegendTitle legend = chart.getLegend(0);
		// 修改图例字体
		legend.setItemFont(new Font("宋体", Font.BOLD, 14));
		// 取得饼图plot对象
		PiePlot plot = (PiePlot) chart.getPlot();
		// 设置饼图各部分标签字体
		plot.setLabelFont(new Font("隶书", Font.ITALIC, 20));
		// 设置标题文字
		// 以下是显示
		ChartPanel chartpanel = new ChartPanel(chart);
		
		ChartFrame chartFrame = new ChartFrame("公司人员信息", chart);
		chartFrame.pack();
		chartFrame.setVisible(true);
		
		// 以下是作为jpg文件写入到c盘根目录下
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