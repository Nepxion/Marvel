package com.nepxion.swing.chart;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.io.IOException;
import java.util.List;

import javax.swing.SwingUtilities;

import org.jfree.chart.JFreeChart;
import org.jfree.ui.RectangleInsets;

import com.lowagie.text.DocumentException;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.selector.file.JFileFilter;
import com.nepxion.swing.selector.file.JFileSelector;
import com.nepxion.util.data.CollectionUtil;

public class ChartPDFWriter
{
	/**
	 * The instance of JChartPanel.
	 */
	private JChartPanel chartPanel;
	
	/**
	 * The instance of JFileSelector.
	 */
	private JFileSelector fileSelector;
	
	/**
	 * Constructs with the specified initial chartPanel.
	 * @param chartPanel The instance of JChartPanel
	 */
	public ChartPDFWriter(JChartPanel chartPanel)
	{
		this.chartPanel = chartPanel;
		
		List filterWords = CollectionUtil.parseList(new String[] {"pdf"});
		String filterDescription = "PDF " + SwingLocale.getString("document") + " (*.pdf)";
		JFileFilter filterFilter = new JFileFilter(filterWords, filterDescription);
		
		fileSelector = new JFileSelector(chartPanel, SwingLocale.getString("export") + " PDF " + SwingLocale.getString("file"));
		fileSelector.addChoosableFileFilter(filterFilter);
		fileSelector.setFileFilter(filterFilter);
	}
	
	/**
	 * Writes the chart as the pdf file.
	 * The author and subject are null.
	 */
	public void write()
	{
		write(null, null);
	}
	
	/**
	 * Writes the chart as the pdf file by an author and subject.
	 * @param author the pdf author string
	 * @param subject the pdf subject string
	 */
	public void write(final String author, final String subject)
	{
		JFreeChart chart = chartPanel.getChart();
		
		final String filePath = fileSelector.saveFile(chart.getTitle().getText() + ".pdf");
		if (filePath == null)
		{
			return;
		}
		
		try
		{
			final JFreeChart chartClone = (JFreeChart) chart.clone();
			chartClone.setBorderVisible(true);
			chartClone.setPadding(new RectangleInsets(2D, 2D, 2D, 2D));
			
			SwingUtilities.invokeLater(new Runnable()
			{
				public void run()
				{			
					try
					{
						ChartPDFUtil.writeChartAsPDF(filePath, chartClone, chartPanel.getWidth(), chartPanel.getHeight(), author, subject);
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
					catch (DocumentException e)
					{
						e.printStackTrace();
					}
				}
			}
			);
		}
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
	}
}