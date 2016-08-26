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

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.JFreeChart;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.AsianFontMapper;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;

public class ChartPDFUtil
{
	/**
	 * Writes the chart as the pdf file.
	 * @param filePath the file path
	 * @param chart the instance of JFreeChart
	 * @param width the pdf graphics width value
	 * @param height the pdf graphics height value
	 * @param author the pdf author string
	 * @param subject the pdf subject string
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static void writeChartAsPDF(String filePath, JFreeChart chart, int width, int height, String author, String subject)
		throws IOException, DocumentException
	{
		writeChartAsPDF(new File(filePath), chart, width, height, author, subject);
	}
	
	/**
	 * Writes the chart as the pdf file.
	 * @param file the instance of File
	 * @param chart the instance of JFreeChart
	 * @param width the pdf graphics width value
	 * @param height the pdf graphics height value
	 * @param author the pdf author string
	 * @param subject the pdf subject string
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static void writeChartAsPDF(File file, JFreeChart chart, int width, int height, String author, String subject)
		throws IOException, DocumentException
	{
		writeChartAsPDF(new FileOutputStream(file), chart, width, height, author, subject);
	}
	
	/**
	 * Writes the chart as the pdf file.
	 * @param fileOutputStream the instance of FileOutputStream
	 * @param chart the instance of JFreeChart
	 * @param width the pdf graphics width value
	 * @param height the pdf graphics height value
	 * @param author the pdf author string
	 * @param subject the pdf subject string
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static void writeChartAsPDF(FileOutputStream fileOutputStream, JFreeChart chart, int width, int height, String author, String subject)
		throws IOException, DocumentException
	{
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		Rectangle rectangle = new Rectangle(width, height);
		Document document = new Document(rectangle, 50F, 50F, 50F, 50F);
		
		PdfWriter pdfWriter = PdfWriter.getInstance(document, bufferedOutputStream);
		if (author != null)
		{	
			document.addAuthor(author);
		}
		if (subject != null)
		{	
			document.addSubject(subject);
		}
		document.open();
		
		PdfContentByte pdfContentByte = pdfWriter.getDirectContent();
		PdfTemplate pdfTemplate = pdfContentByte.createTemplate(width, height);
		AsianFontMapper fontMapper = new AsianFontMapper("STSong-Light", "UniGB-UCS2-H");
		Graphics2D graphics2D = pdfTemplate.createGraphics(width, height, fontMapper);
		Rectangle2D.Double doubleValue = new Rectangle2D.Double(0.0D, 0.0D, width, height);
		chart.draw(graphics2D, doubleValue);
		
		graphics2D.dispose();
		pdfContentByte.addTemplate(pdfTemplate, 0.0F, 0.0F);
		
		document.close();
		bufferedOutputStream.close();
	}
}