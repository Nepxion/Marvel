package com.nepxion.demo.component.buttonbar;

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
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import com.l2fprod.common.swing.plaf.basic.BasicButtonBarUI;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.JBasicToggleButton;
import com.nepxion.swing.buttonbar.JBasicButtonBar;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
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
import com.nepxion.swing.style.buttonbar.ButtonBarUI;
import com.nepxion.swing.style.buttonbar.GrayThemeButtonBarUI;
import com.nepxion.swing.style.buttonbar.BlueThemeButtonBarUI;

public class DemoButtonBarPanel
	extends JBasicScrollPane
{
	public DemoButtonBarPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new FiledLayout(FiledLayout.ROW, FiledLayout.FULL, 0));
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		panel.add(new ButtonBarPanel(new ButtonBarUI(new FlatButtonUI()), "JFlat Style"));
		panel.add(new ButtonBarPanel(new ButtonBarUI(new LiteButtonUI(new JAlloyLiteButtonStyle())), "JAlloy Style"));
		panel.add(new ButtonBarPanel(new ButtonBarUI(new LiteButtonUI(new JAcidLiteButtonStyle())), "JAcid Style"));
		panel.add(new ButtonBarPanel(new ButtonBarUI(new LiteButtonUI(new JBedouinLiteButtonStyle())), "JBedouin Style"));
		panel.add(new ButtonBarPanel(new ButtonBarUI(new LiteButtonUI(new JGlassLiteButtonStyle())), "JGlass Style"));
		panel.add(new ButtonBarPanel(new ButtonBarUI(new LiteButtonUI(new JEclipseLiteButtonStyle())), "JEclipse Style"));			
		panel.add(new ButtonBarPanel(new ButtonBarUI(new LiteButtonUI(new JBorlandLiteButtonStyle())), "JBorland Style"));		
		panel.add(new ButtonBarPanel(new ButtonBarUI(new LiteButtonUI(new JNimbusLiteButtonStyle())), "JNimbus Style"));		
		panel.add(new ButtonBarPanel(new ButtonBarUI(new LiteButtonUI(new JBlueLiteButtonStyle())), "JBlue Style"));
		panel.add(new ButtonBarPanel(new ButtonBarUI(new LiteButtonUI(new JYellowLiteButtonStyle())), "JYellow Style"));
		panel.add(new ButtonBarPanel(new BlueThemeButtonBarUI(), "Blue Theme"));
		panel.add(new ButtonBarPanel(new GrayThemeButtonBarUI(), "Gray Theme"));
		
		getViewport().add(panel);
	}
	
	public class ButtonBarPanel
		extends JPanel
	{
		public ButtonBarPanel(BasicButtonBarUI buttonBarUI, String text)
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder(text));						
			
			JBasicButtonBar buttonBar = new JBasicButtonBar(JBasicButtonBar.VERTICAL);	
			buttonBar.setPreferredSize(new Dimension(75, buttonBar.getPreferredSize().height));
			buttonBar.setUI(buttonBarUI);
			
			ButtonGroup buttonGroup = new ButtonGroup();			
			JBasicToggleButton[] toggleButtons = {
				new JBasicToggleButton("Welcome", IconFactory.getIcon("com/l2fprod/common/demo/icons/welcome32x32.png"), "Welcome", true),
				new JBasicToggleButton("Settings", IconFactory.getIcon("com/l2fprod/common/demo/icons/propertysheet32x32.png"), "Settings"),
				new JBasicToggleButton("Sounds", IconFactory.getIcon("com/l2fprod/common/demo/icons/fonts32x32.png"), "Sounds"),
				new JBasicToggleButton("Statistics", IconFactory.getIcon("com/l2fprod/common/demo/icons/folder32x32.png"), "Statistics")
			}; 
			for (int i = 0; i < toggleButtons.length; i++)
			{
				buttonBar.add(toggleButtons[i]);
				buttonGroup.add(toggleButtons[i]);
			}
			
			JBasicScrollPane buttonBarScrollPane = new JBasicScrollPane();
			buttonBarScrollPane.getViewport().add(buttonBar);
						
			add(buttonBarScrollPane);
		}
	}
}