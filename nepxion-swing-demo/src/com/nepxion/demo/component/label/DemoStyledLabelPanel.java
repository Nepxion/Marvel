package com.nepxion.demo.component.label;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.nepxion.swing.border.ComplexLineBorder;
import com.nepxion.swing.label.JStyleRange;
import com.nepxion.swing.label.JStyledLabel;
import com.nepxion.swing.layout.filed.FiledLayout;

public class DemoStyledLabelPanel
	extends JPanel
{
	public DemoStyledLabelPanel()
	{
		setLayout(new FiledLayout());
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new StyledLabelPanel());
	}
	
	public class StyledLabelPanel
		extends JPanel
	{
		public StyledLabelPanel()
		{
			setLayout(new GridLayout(0, 2, 10, 10));
			setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(new ComplexLineBorder(Color.gray, 1, true, 10), "Styled Label", TitledBorder.CENTER, TitledBorder.CENTER), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
			
			JStyledLabel javaTM = new JStyledLabel("JavaTM");
			javaTM.addStyleRange(new JStyleRange(4, 2, Font.PLAIN, JStyleRange.STYLE_SUPERSCRIPT));
			add(javaTM);
			
			JStyledLabel co2 = new JStyledLabel("CO2");
			co2.addStyleRange(new JStyleRange(0, 2, Font.PLAIN, Color.blue));
			co2.addStyleRange(new JStyleRange(2, -1, Font.PLAIN, Color.blue, JStyleRange.STYLE_SUBSCRIPT));
			add(co2);
			
			JStyledLabel bold = new JStyledLabel("Bold");
			bold.addStyleRange(new JStyleRange(Font.BOLD, Color.black));
			add(bold);
			
			JStyledLabel italic = new JStyledLabel("Italic");
			italic.addStyleRange(new JStyleRange(Font.ITALIC, Color.gray));
			add(italic);
			
			JStyledLabel error = new JStyledLabel("Error");
			error.addStyleRange(new JStyleRange(Font.PLAIN, Color.black, JStyleRange.STYLE_WAVED, Color.red));
			add(error);
			
			JStyledLabel background = new JStyledLabel("Background");
			background.addStyleRange(new JStyleRange(0, 4, Font.PLAIN, Color.black, Color.yellow, JStyleRange.STYLE_WAVED, Color.red));
			background.addStyleRange(new JStyleRange(4, 6, Font.PLAIN, Color.black, Color.cyan, JStyleRange.STYLE_UNDERLINED, Color.blue));
			add(background);
			
			JStyledLabel dotted = new JStyledLabel("Dotted");
			dotted.addStyleRange(new JStyleRange(Font.PLAIN, Color.black, JStyleRange.STYLE_DOTTED, Color.red));
			add(dotted);
			
			JStyledLabel underlined = new JStyledLabel("Underlined");
			underlined.addStyleRange(new JStyleRange(Font.PLAIN, Color.blue, JStyleRange.STYLE_UNDERLINED, Color.black));
			add(underlined);
			
			JStyledLabel strikethrough = new JStyledLabel("Strikethrough");
			strikethrough.addStyleRange(new JStyleRange(Font.PLAIN, Color.blue, JStyleRange.STYLE_STRIKE_THROUGH, Color.black));
			add(strikethrough);
			
			JStyledLabel doubleStrikethrough = new JStyledLabel("Double Strikethrough");
			doubleStrikethrough.addStyleRange(new JStyleRange(Font.PLAIN, Color.blue, JStyleRange.STYLE_DOUBLE_STRIKE_THROUGH, Color.black));
			add(doubleStrikethrough);
			
			JStyledLabel twoStyles = new JStyledLabel("Strikethrough and Underlined");
			twoStyles.addStyleRange(new JStyleRange(Font.PLAIN, Color.red, JStyleRange.STYLE_STRIKE_THROUGH | JStyleRange.STYLE_UNDERLINED, Color.black));
			add(twoStyles);
			
			JStyledLabel customizedUnderlined = new JStyledLabel("Customized Underlined");
			customizedUnderlined.addStyleRange(new JStyleRange(Font.PLAIN, Color.black, JStyleRange.STYLE_UNDERLINED, Color.black, new BasicStroke(1.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 1.0f, new float[] {6, 3, 0, 3}, 0)));
			add(customizedUnderlined);
			
			JStyledLabel mixed = new JStyledLabel("Mixed Underlined Strikethrough Styles");
			mixed.addStyleRange(new JStyleRange(0, 5, Font.BOLD, Color.blue));
			mixed.addStyleRange(new JStyleRange(6, 10, Font.PLAIN, Color.black, JStyleRange.STYLE_UNDERLINED));
			mixed.addStyleRange(new JStyleRange(17, 13, Font.PLAIN, Color.red, JStyleRange.STYLE_STRIKE_THROUGH));
			add(mixed);
		}
	}
}