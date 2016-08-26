package com.nepxion.demo.component.button;

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
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.button.JStyleButton;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.style.button.flat.FlatButtonUI;
import com.nepxion.swing.style.button.lite.JAcidLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JAlloyLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JBedouinLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JBlueLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JBorlandLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JEclipseLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JGlassLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JNimbusLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JYellowLiteButtonStyle;
import com.nepxion.swing.style.button.lite.LiteButtonUI;

public class DemoButtonPanel
	extends JPanel
{
	public DemoButtonPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new FlatStyleButtonPanel());
		add(new AlloyStyleButtonPanel());
		add(new EclipseStyleButtonPanel());
		add(new BorlandStyleButtonPanel());
		add(new NimbusStyleButtonPanel());		
		add(new ColorStyleButtonPanel());
		add(new StyleButtonPanel());	
	}
	
	public class FlatStyleButtonPanel
		extends JPanel
	{
		public FlatStyleButtonPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Flat ButtonUI"));

			JBasicButton flatStyleButton = new JBasicButton("JFlat Style", IconFactory.getSwingIcon("component/button_16.png"), "JFlat Style");
			flatStyleButton.setUI(new FlatButtonUI());
			add(flatStyleButton);					
		}
	}
	
	public class AlloyStyleButtonPanel
		extends JPanel
	{
		public AlloyStyleButtonPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Alloy ButtonUI"));
			
			JBasicButton alloyStyleButton = new JBasicButton("JAlloy Style", IconFactory.getSwingIcon("component/button_16.png"), "JAlloy Style");
			alloyStyleButton.setUI(new LiteButtonUI(new JAlloyLiteButtonStyle()));
			add(alloyStyleButton);
			
			JBasicButton acidStyleButton = new JBasicButton("JAcid Style", IconFactory.getSwingIcon("component/button_16.png"), "JAcid Style");
			acidStyleButton.setUI(new LiteButtonUI(new JAcidLiteButtonStyle()));
			add(acidStyleButton);
			
			JBasicButton bedouinStyleButton = new JBasicButton("JBedouin Style", IconFactory.getSwingIcon("component/button_16.png"), "JBedouin Style");
			bedouinStyleButton.setUI(new LiteButtonUI(new JBedouinLiteButtonStyle()));
			add(bedouinStyleButton);
			
			JBasicButton glassStyleButton = new JBasicButton("JGlass Style", IconFactory.getSwingIcon("component/button_16.png"), "JGlass Style");
			glassStyleButton.setUI(new LiteButtonUI(new JGlassLiteButtonStyle()));
			add(glassStyleButton);						
		}
	}
	
	public class EclipseStyleButtonPanel
		extends JPanel
	{
		public EclipseStyleButtonPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Eclipse ButtonUI"));
			
			JBasicButton eclipseStyleButton = new JBasicButton("JEclipse Style", IconFactory.getSwingIcon("component/button_16.png"), "JEclipse Style");
			eclipseStyleButton.setUI(new LiteButtonUI(new JEclipseLiteButtonStyle()));
			add(eclipseStyleButton);			
		}
	}	
	
	public class BorlandStyleButtonPanel
		extends JPanel
	{
		public BorlandStyleButtonPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Borland ButtonUI"));
			
			JBasicButton borlandStyleButton = new JBasicButton("JBorland Style", IconFactory.getSwingIcon("component/button_16.png"), "JBorland Style");
			borlandStyleButton.setUI(new LiteButtonUI(new JBorlandLiteButtonStyle()));
			add(borlandStyleButton);			
		}
	}
	
	public class NimbusStyleButtonPanel
		extends JPanel
	{
		public NimbusStyleButtonPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Nimbus ButtonUI"));
			
			JBasicButton nimbusStyleButton = new JBasicButton("JNimbus Style", IconFactory.getSwingIcon("component/button_16.png"), "JNimbus Style");
			nimbusStyleButton.setUI(new LiteButtonUI(new JNimbusLiteButtonStyle()));
			add(nimbusStyleButton);			
		}
	}	
	
	public class ColorStyleButtonPanel
		extends JPanel
	{
		public ColorStyleButtonPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Color ButtonUI"));
			
			JBasicButton blueStyleButton = new JBasicButton("JBlue Style", IconFactory.getSwingIcon("component/button_16.png"), "JBlue Style");
			blueStyleButton.setUI(new LiteButtonUI(new JBlueLiteButtonStyle()));
			add(blueStyleButton);	
			
			JBasicButton yellowStyleButton = new JBasicButton("JYellow Style", IconFactory.getSwingIcon("component/button_16.png"), "JYellow Style");
			yellowStyleButton.setUI(new LiteButtonUI(new JYellowLiteButtonStyle()));
			add(yellowStyleButton);						
		}
	}		
	
	public class StyleButtonPanel
		extends JPanel
	{
		public StyleButtonPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Style ButtonUI"));
			
			JStyleButton flatStyleButton = new JStyleButton("Flat Style", IconFactory.getSwingIcon("component/button_16.png"), "Flat Style");
			flatStyleButton.setButtonStyle(JStyleButton.FLAT_STYLE);
			add(flatStyleButton);
			
			JStyleButton hyperLinkStyleButton = new JStyleButton("HyperLink Style", IconFactory.getSwingIcon("component/button_16.png"), "HyperLink Style");
			hyperLinkStyleButton.setButtonStyle(JStyleButton.HYPERLINK_STYLE);
			add(hyperLinkStyleButton);
			
			JStyleButton toolBarStyleButton = new JStyleButton("ToolBar Style", IconFactory.getSwingIcon("component/button_16.png"), "ToolBar Style");
			toolBarStyleButton.setButtonStyle(JStyleButton.TOOLBAR_STYLE);
			add(toolBarStyleButton);
			
			/*JStyleButton toolBoxStyleButton = new JStyleButton("ToolBox Style", IconFactory.getSwingIcon("component/button_16.png"), "ToolBox Style");
			toolBoxStyleButton.setButtonStyle(JStyleButton.TOOLBOX_STYLE);
			add(toolBoxStyleButton);*/			
		}
	}
}