package com.nepxion.demo.component.panel;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.panel.decoration.JDecorationPanel;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.style.framework.JAcidStyle;
import com.nepxion.swing.style.framework.JAlloyStyle;
import com.nepxion.swing.style.framework.JBedouinStyle;
import com.nepxion.swing.style.framework.JBlueStyle;
import com.nepxion.swing.style.framework.JBorlandStyle;
import com.nepxion.swing.style.framework.JEclipseStyle;
import com.nepxion.swing.style.framework.JFervencyStyle;
import com.nepxion.swing.style.framework.JGlassStyle;
import com.nepxion.swing.style.framework.JLiteStyle;
import com.nepxion.swing.style.framework.JNimbusStyle;
import com.nepxion.swing.style.framework.JPlasticStyle;
import com.nepxion.swing.style.framework.JWindowsStyle;
import com.nepxion.swing.style.framework.JYellowStyle;
import com.nepxion.swing.textarea.JBasicTextArea;

public class DemoDecorationPanel
	extends JBasicScrollPane
{
	public DemoDecorationPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		panel.add(new WindowsStyleDecorationPanel());
		panel.add(new LiteStyleDecorationPanel());
		panel.add(new AlloyStyleDecorationPanel());
		panel.add(new EclipseStyleDecorationPanel());
		panel.add(new BorlandStyleDecorationPanel());
		panel.add(new NimbusStyleDecorationPanel());
		panel.add(new ColorStyleDecorationPanel());
		panel.add(new PlasticStyleDecorationPanel());
		panel.add(new FervencyStyleDecorationPanel());
		
		getViewport().add(panel);
	}
	
	public class WindowsStyleDecorationPanel
		extends JPanel
	{
		public WindowsStyleDecorationPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Windows Style"));
			
			JDecorationPanel windowsStyleDecorationPanel = new JDecorationPanel("JWindows Style", IconFactory.getSwingIcon("component/internal_frame_16.png"), "JWindows Style", true, new JBasicScrollPane(new JBasicTextArea()), new JWindowsStyle());			
			DimensionManager.setDimension(windowsStyleDecorationPanel, new Dimension(150, 48));	
			add(windowsStyleDecorationPanel);
		}
	}
	
	public class LiteStyleDecorationPanel
		extends JPanel
	{
		public LiteStyleDecorationPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Lite Style"));
			
			JDecorationPanel liteStyleDecorationPanel = new JDecorationPanel("JLite Style", IconFactory.getSwingIcon("component/internal_frame_16.png"), "JLite Style", true, new JBasicScrollPane(new JBasicTextArea()), new JLiteStyle());			
			DimensionManager.setDimension(liteStyleDecorationPanel, new Dimension(150, 48));	
			add(liteStyleDecorationPanel);
		}
	}	
	
	public class AlloyStyleDecorationPanel
		extends JPanel
	{
		public AlloyStyleDecorationPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Alloy Style"));
			
			JDecorationPanel alloyLiteStyleDecorationPanel = new JDecorationPanel("JAlloyLite Style", IconFactory.getSwingIcon("component/internal_frame_16.png"), "JAlloyLite Style", true, new JBasicScrollPane(new JBasicTextArea()), new JAlloyStyle());			
			DimensionManager.setDimension(alloyLiteStyleDecorationPanel, new Dimension(150, 48));	
			add(alloyLiteStyleDecorationPanel);
			
			JDecorationPanel acidLiteStyleDecorationPanel = new JDecorationPanel("JAcidLite Style", IconFactory.getSwingIcon("component/internal_frame_16.png"), "JAcidLite Style", true, new JBasicScrollPane(new JBasicTextArea()), new JAcidStyle());			
			DimensionManager.setDimension(acidLiteStyleDecorationPanel, new Dimension(150, 48));	
			add(acidLiteStyleDecorationPanel);
			
			JDecorationPanel bedouinLiteStyleDecorationPanel = new JDecorationPanel("JBedouinLite Style", IconFactory.getSwingIcon("component/internal_frame_16.png"), "JBedouinLite Style", true, new JBasicScrollPane(new JBasicTextArea()), new JBedouinStyle());			
			DimensionManager.setDimension(bedouinLiteStyleDecorationPanel, new Dimension(150, 48));	
			add(bedouinLiteStyleDecorationPanel);
			
			JDecorationPanel glassLiteStyleDecorationPanel = new JDecorationPanel("JGlassLite Style", IconFactory.getSwingIcon("component/internal_frame_16.png"), "JGlassLite Style", true, new JBasicScrollPane(new JBasicTextArea()), new JGlassStyle());			
			DimensionManager.setDimension(glassLiteStyleDecorationPanel, new Dimension(150, 48));	
			add(glassLiteStyleDecorationPanel);
		}
	}
		
	public class EclipseStyleDecorationPanel
		extends JPanel
	{
		public EclipseStyleDecorationPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Eclipse Style"));
			
			JDecorationPanel eclipseStyleDecorationPanel = new JDecorationPanel("JEclipse Style", IconFactory.getSwingIcon("component/internal_frame_16.png"), "JEclipse Style", true, new JBasicScrollPane(new JBasicTextArea()), new JEclipseStyle());			
			DimensionManager.setDimension(eclipseStyleDecorationPanel, new Dimension(150, 48));	
			add(eclipseStyleDecorationPanel);
		}
	}
	
	public class BorlandStyleDecorationPanel
		extends JPanel
	{
		public BorlandStyleDecorationPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Borland Style"));
			
			JDecorationPanel nimbusStyleDecorationPanel = new JDecorationPanel("JBorland Style", IconFactory.getSwingIcon("component/internal_frame_16.png"), "JBorland Style", true, new JBasicScrollPane(new JBasicTextArea()), new JBorlandStyle());
			DimensionManager.setDimension(nimbusStyleDecorationPanel, new Dimension(150, 48));
			add(nimbusStyleDecorationPanel);
		}
	}	
		
	public class NimbusStyleDecorationPanel
		extends JPanel
	{
		public NimbusStyleDecorationPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Nimbus Style"));
			
			JDecorationPanel nimbusStyleDecorationPanel = new JDecorationPanel("JNimbus Style", IconFactory.getSwingIcon("component/internal_frame_16.png"), "JNimbus Style", true, new JBasicScrollPane(new JBasicTextArea()), new JNimbusStyle());			
			DimensionManager.setDimension(nimbusStyleDecorationPanel, new Dimension(150, 48));	
			add(nimbusStyleDecorationPanel);
		}
	}
	
	public class ColorStyleDecorationPanel
		extends JPanel
	{
		public ColorStyleDecorationPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Color Style"));
			
			JDecorationPanel blueLiteStyleDecorationPanel = new JDecorationPanel("JBlueLite Style", IconFactory.getSwingIcon("component/internal_frame_16.png"), "JBlueLite Style", true, new JBasicScrollPane(new JBasicTextArea()), new JBlueStyle());
			DimensionManager.setDimension(blueLiteStyleDecorationPanel, new Dimension(150, 48));
			add(blueLiteStyleDecorationPanel, "0, 1");
			
			JDecorationPanel yellowLiteStyleDecorationPanel = new JDecorationPanel("JYellowLite Style", IconFactory.getSwingIcon("component/internal_frame_16.png"), "JYellowLite Style", true, new JBasicScrollPane(new JBasicTextArea()), new JYellowStyle());
			DimensionManager.setDimension(yellowLiteStyleDecorationPanel, new Dimension(150, 48));
			add(yellowLiteStyleDecorationPanel, "1, 1");
		}
	}		
	
	public class PlasticStyleDecorationPanel
		extends JPanel
	{
		public PlasticStyleDecorationPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Plastic Style"));
			
			JDecorationPanel plasticStyleDecorationPanel = new JDecorationPanel("JPlastic Style", IconFactory.getSwingIcon("component/internal_frame_16.png"), "JPlastic Style", true, new JBasicScrollPane(new JBasicTextArea()), new JPlasticStyle());
			DimensionManager.setDimension(plasticStyleDecorationPanel, new Dimension(150, 48));
			add(plasticStyleDecorationPanel);
		}
	}			
	
	public class FervencyStyleDecorationPanel
		extends JPanel
	{
		public FervencyStyleDecorationPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Fervency Style"));
			
			JDecorationPanel fervencyDecorationPanel = new JDecorationPanel("JFervency Style", IconFactory.getSwingIcon("component/internal_frame_16.png"), "JFervency Style", true, new JBasicScrollPane(new JBasicTextArea()), new JFervencyStyle());			
			DimensionManager.setDimension(fervencyDecorationPanel, new Dimension(150, 48));	
			add(fervencyDecorationPanel);
		}
	}
}