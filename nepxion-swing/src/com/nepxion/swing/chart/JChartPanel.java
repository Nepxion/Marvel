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

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;

public class JChartPanel
	extends ChartPanel
{
	/**
	 * The instance of ChartPDFWriter.
	 */
	private ChartPDFWriter chartPDFWriter;
	
	/**
	 * Constructs with the specified initial chart.
	 * @param chart the instance of JFreeChart
	 */
	public JChartPanel(JFreeChart chart)
	{
		super(chart);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial chart.
	 * @param chart the instance of JFreeChart
	 * @param useBuffer the boolean value of useBuffer
	 */
	public JChartPanel(JFreeChart chart, boolean useBuffer)
	{
		super(chart, useBuffer);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial chart.
	 * @param chart the instance of JFreeChart
	 * @param properties the boolean value of properties
	 * @param save the boolean value of save
	 * @param print the boolean value of print
	 * @param zoom the boolean value of zoom
	 * @param tooltips the boolean value of tooltips
	 */
	public JChartPanel(JFreeChart chart, boolean properties, boolean save, boolean print, boolean zoom, boolean tooltips)
	{
		super(chart, properties, save, print, zoom, tooltips);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial chart.
	 * @param chart the instance of JFreeChart
	 * @param width the width value
	 * @param height the height value
	 * @param minimumDrawWidth the minimum draw width
	 * @param minimumDrawHeight the minimum draw height
	 * @param maximumDrawWidth the maximum draw width
	 * @param maximumDrawHeight maximum draw height
	 * @param useBuffer the boolean value of useBuffer
	 * @param properties the boolean value of properties
	 * @param save the boolean value of save
	 * @param print the boolean value of print
	 * @param zoom the boolean value of zoom
	 * @param tooltips the boolean value of tooltips
	 */
	public JChartPanel(JFreeChart chart, int width, int height, int minimumDrawWidth, int minimumDrawHeight, int maximumDrawWidth, int maximumDrawHeight, boolean useBuffer, boolean properties, boolean save, boolean print, boolean zoom, boolean tooltips)
	{
		super(chart, width, height, minimumDrawWidth, minimumDrawHeight, maximumDrawWidth, maximumDrawHeight, useBuffer, properties, save, print, zoom, tooltips);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial chart.
	 * @param chart the instance of JFreeChart
	 * @param width the width value
	 * @param height the height value
	 * @param minimumDrawWidth the minimum draw width
	 * @param minimumDrawHeight the minimum draw height
	 * @param maximumDrawWidth the maximum draw width
	 * @param maximumDrawHeight maximum draw height
	 * @param useBuffer the boolean value of useBuffer
	 * @param properties the boolean value of properties
	 * @param copy the boolean value of copy
	 * @param save the boolean value of save
	 * @param print the boolean value of print
	 * @param zoom the boolean value of zoom
	 * @param tooltips the boolean value of tooltips
	 */
	public JChartPanel(JFreeChart chart, int width, int height, int minimumDrawWidth, int minimumDrawHeight, int maximumDrawWidth, int maximumDrawHeight, boolean useBuffer, boolean properties, boolean copy, boolean save, boolean print, boolean zoom, boolean tooltips)
	{
		super(chart, width, height, minimumDrawWidth, minimumDrawHeight, maximumDrawWidth, maximumDrawHeight, useBuffer, properties, copy, save, print, zoom, tooltips);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		setMouseWheelEnabled(true);
	}
	
	/**
	 * Invoked when the mouse button has been released on a component.
	 * @param e the instance of MouseEvent
	 */
	public void mouseReleased(MouseEvent e)
	{
		super.mouseReleased(e);
		
		JPopupMenu popupMenu = getPopupMenu();
		if (popupMenu != null && popupMenu.isShowing())
		{
			super.mouseClicked(e);
		}
	}
	
	/**
	 * Creates the popup menu.
	 * @param properties the boolean value whether the popup menu shows "Properties" menu item or not
	 * @param copy the boolean value whether the popup menu shows "Copy" menu item or not
	 * @param save the boolean value whether the popup menu shows "Save" menu item or not
	 * @param print the boolean value whether the popup menu shows "Print" menu item or not
	 * @param zoom the boolean value whether the popup menu shows "Zoom" menu item or not
	 */
	protected JPopupMenu createPopupMenu(boolean properties, boolean copy, boolean save, boolean print, boolean zoom)
	{
		JPopupMenu popupMenu = super.createPopupMenu(properties, copy, save, print, zoom);
		
		JMenuItem propertiesMenuItem = null;
		if (properties)
		{
			propertiesMenuItem = getMenuItem(popupMenu, localizationResources.getString("Properties..."));
			propertiesMenuItem.setText(SwingLocale.getString("setting") + "    ");
			propertiesMenuItem.setIcon(IconFactory.getSwingIcon("edit.png"));
		}
		
		JMenuItem copyMenuItem = null;
		if (copy)
		{
			copyMenuItem = getMenuItem(popupMenu, localizationResources.getString("Copy"));
			copyMenuItem.setIcon(IconFactory.getSwingIcon("copy.png"));
		}
		
		JMenu exportMenu = null;
		if (save)
		{
			JMenuItem exportPNGMenuItem = getMenuItem(popupMenu, localizationResources.getString("Save_as..."));
			exportPNGMenuItem.setText("PNG " + SwingLocale.getString("image"));
			exportPNGMenuItem.setIcon(IconFactory.getSwingIcon("image.png"));
			
			JMenuItem exportPDFMenuItem = new JMenuItem();
			exportPDFMenuItem.setText("PDF " + SwingLocale.getString("file"));
			exportPDFMenuItem.setIcon(IconFactory.getSwingIcon("pdf.png"));
			exportPDFMenuItem.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					exportPDF();
				}
			}
			);
			
			exportMenu = new JMenu();
			exportMenu.setText(SwingLocale.getString("export"));
			exportMenu.setIcon(IconFactory.getSwingIcon("export.png"));
			exportMenu.add(exportPDFMenuItem);
			exportMenu.add(exportPNGMenuItem);
		}
		
		JMenu zoomInMenu = null;
		JMenu zoomOutMenu = null;
		JMenu zoomResetMenu = null;
		if (zoom)
		{
			zoomInMenu = (JMenu) getMenuItem(popupMenu, localizationResources.getString("Zoom_In"));
			zoomInMenu.setIcon(IconFactory.getSwingIcon("zoom_in.png"));
			
			zoomOutMenu = (JMenu) getMenuItem(popupMenu, localizationResources.getString("Zoom_Out"));
			zoomOutMenu.setIcon(IconFactory.getSwingIcon("zoom_out.png"));
			
			zoomResetMenu = (JMenu) getMenuItem(popupMenu, localizationResources.getString("Auto_Range"));
			zoomResetMenu.setText(SwingLocale.getString("zoom_restore"));
			zoomResetMenu.setIcon(IconFactory.getSwingIcon("zoom.png"));
		}
		
		JMenuItem printMenuItem = null;
		if (print)
		{
			printMenuItem = getMenuItem(popupMenu, localizationResources.getString("Print..."));
			printMenuItem.setText(SwingLocale.getString("print"));
			printMenuItem.setIcon(IconFactory.getSwingIcon("print.png"));
		}
		
		popupMenu.removeAll();
		
		JBasicPopupMenu basicPopupMenu = new JBasicPopupMenu();
		
		if (properties)
		{
			basicPopupMenu.add(propertiesMenuItem);
		}
		if (copy)
		{
			basicPopupMenu.add(copyMenuItem);
		}
		if (save)
		{
			basicPopupMenu.add(exportMenu);
		}
		if (zoom)
		{
			basicPopupMenu.addSeparator();
			basicPopupMenu.add(zoomInMenu);
			basicPopupMenu.add(zoomOutMenu);
			basicPopupMenu.add(zoomResetMenu);
		}
		if (print)
		{
			basicPopupMenu.addSeparator();
			basicPopupMenu.add(printMenuItem);
		}
		
		return basicPopupMenu;
	}
	
    /**
     * Exports the pdf file.
     */
	public void exportPDF()
	{
		if (chartPDFWriter == null)
		{
			chartPDFWriter = new ChartPDFWriter(JChartPanel.this);
		}
		chartPDFWriter.write(ChartContext.getChartPDFAuthor(), ChartContext.getChartPDFSubject());
	}
	
	/**
	 * Exports the png file.
	 */
	public void exportPNG()
	{
		try
		{
			doSaveAs();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the menu item at the popup menu by a text.
	 * @param popupMenu the instance of JPopupMenu
	 * @param text the text string
	 * @return the instance of JMenuItem
	 */
	private JMenuItem getMenuItem(JPopupMenu popupMenu, String text)
	{		
		for (int i = 0; i < popupMenu.getComponentCount(); i++)
		{
			Component component = popupMenu.getComponent(i);
			if (component instanceof JMenuItem)
			{
				JMenuItem menuItem = (JMenuItem) component;
				if (menuItem.getText().equals(text))
				{
					return menuItem;
				}	
			}	
		}
		
		return null;
	}
}