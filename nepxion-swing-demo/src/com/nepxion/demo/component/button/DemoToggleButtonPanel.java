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
import com.nepxion.swing.button.JBasicToggleButton;
import com.nepxion.swing.button.JStyleToggleButton;
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

public class DemoToggleButtonPanel
	extends JPanel
{
	public DemoToggleButtonPanel()
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
			
			JBasicToggleButton flatStyleButton = new JBasicToggleButton("JFlat Style", IconFactory.getSwingIcon("component/button_16.png"), "JFlat Style");
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
			
			JBasicToggleButton alloyStyleButton = new JBasicToggleButton("JAlloy Style", IconFactory.getSwingIcon("component/button_16.png"), "JAlloy Style");
			alloyStyleButton.setUI(new LiteButtonUI(new JAlloyLiteButtonStyle()));
			add(alloyStyleButton);
			
			JBasicToggleButton acidStyleButton = new JBasicToggleButton("JAcid Style", IconFactory.getSwingIcon("component/button_16.png"), "JAcid Style");
			acidStyleButton.setUI(new LiteButtonUI(new JAcidLiteButtonStyle()));
			add(acidStyleButton);
			
			JBasicToggleButton bedouinStyleButton = new JBasicToggleButton("JBedouin Style", IconFactory.getSwingIcon("component/button_16.png"), "JBedouin Style");
			bedouinStyleButton.setUI(new LiteButtonUI(new JBedouinLiteButtonStyle()));
			add(bedouinStyleButton);
			
			JBasicToggleButton glassStyleButton = new JBasicToggleButton("JGlass Style", IconFactory.getSwingIcon("component/button_16.png"), "JGlass Style");
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
			
			JBasicToggleButton eclipseStyleButton = new JBasicToggleButton("JEclipse Style", IconFactory.getSwingIcon("component/button_16.png"), "JEclipse Style");
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
			
			JBasicToggleButton borlandStyleButton = new JBasicToggleButton("JBorland Style", IconFactory.getSwingIcon("component/button_16.png"), "JBorland Style");
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
			
			JBasicToggleButton nimbusStyleButton = new JBasicToggleButton("JNimbus Style", IconFactory.getSwingIcon("component/button_16.png"), "JNimbus Style");
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
			
			JBasicToggleButton blueStyleButton = new JBasicToggleButton("JBlue Style", IconFactory.getSwingIcon("component/button_16.png"), "JBlue Style");
			blueStyleButton.setUI(new LiteButtonUI(new JBlueLiteButtonStyle()));
			add(blueStyleButton);	
			
			JBasicToggleButton yellowStyleButton = new JBasicToggleButton("JYellow Style", IconFactory.getSwingIcon("component/button_16.png"), "JYellow Style");
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
			
			JStyleToggleButton flatStyleButton = new JStyleToggleButton("Flat Style", IconFactory.getSwingIcon("component/button_16.png"), "Flat Style");
			flatStyleButton.setButtonStyle(JStyleToggleButton.FLAT_STYLE);
			add(flatStyleButton);
			
			JStyleToggleButton hyperLinkStyleButton = new JStyleToggleButton("HyperLink Style", IconFactory.getSwingIcon("component/button_16.png"), "HyperLink Style");
			hyperLinkStyleButton.setButtonStyle(JStyleToggleButton.HYPERLINK_STYLE);
			add(hyperLinkStyleButton);
			
			JStyleToggleButton toolBarStyleButton = new JStyleToggleButton("ToolBar Style", IconFactory.getSwingIcon("component/button_16.png"), "ToolBar Style");
			toolBarStyleButton.setButtonStyle(JStyleToggleButton.TOOLBAR_STYLE);
			add(toolBarStyleButton);
			
			/*JStyleToggleButton toolBoxStyleButton = new JStyleToggleButton("ToolBox Style", IconFactory.getSwingIcon("component/button_16.png"), "ToolBox Style");
			toolBoxStyleButton.setButtonStyle(JStyleToggleButton.TOOLBOX_STYLE);
			add(toolBoxStyleButton);*/			
		}
	}
}