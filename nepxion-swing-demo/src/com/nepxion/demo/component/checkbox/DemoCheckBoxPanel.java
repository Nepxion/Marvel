package com.nepxion.demo.component.checkbox;

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
import javax.swing.JPanel;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.checkbox.JLiteCheckBox;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.style.button.lite.JAcidLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JAlloyLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JBedouinLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JGlassLiteButtonStyle;
import com.nepxion.swing.style.checkbox.lite.LiteCheckBoxUI;

public class DemoCheckBoxPanel
	extends JPanel
{
	public DemoCheckBoxPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new AlloyStyleCheckBoxPanel());
	}
	
	public class AlloyStyleCheckBoxPanel
		extends JPanel
	{
		public AlloyStyleCheckBoxPanel()
		{
			setLayout(new FiledLayout(FiledLayout.ROW, FiledLayout.LEFT, 5));
			setBorder(BorderManager.createComplexTitledBorder("Alloy CheckBoxUI"));
			
			JLiteCheckBox alloyStyleCheckBox = new JLiteCheckBox("JAlloy Style", "JAlloy Style", true);
			alloyStyleCheckBox.setUI(new LiteCheckBoxUI(LiteCheckBoxUI.CHECKBOX_THEME_PLASTIC, new JAlloyLiteButtonStyle()));
			add(alloyStyleCheckBox);
			
			JLiteCheckBox acidStyleCheckBox = new JLiteCheckBox("JAcid Style", "JAcid Style", true);
			acidStyleCheckBox.setUI(new LiteCheckBoxUI(LiteCheckBoxUI.CHECKBOX_THEME_PLASTIC, new JAcidLiteButtonStyle()));
			add(acidStyleCheckBox);
			
			JLiteCheckBox bedouinStyleCheckBox = new JLiteCheckBox("JBedouin Style", "JBedouin Style", true);
			bedouinStyleCheckBox.setUI(new LiteCheckBoxUI(LiteCheckBoxUI.CHECKBOX_THEME_PLASTIC, new JBedouinLiteButtonStyle()));
			add(bedouinStyleCheckBox);
			
			JLiteCheckBox glassStyleCheckBox = new JLiteCheckBox("JGlass Style", "JGlass Style", true);
			glassStyleCheckBox.setUI(new LiteCheckBoxUI(LiteCheckBoxUI.CHECKBOX_THEME_PLASTIC, new JGlassLiteButtonStyle()));
			add(glassStyleCheckBox);
		}
	}
}