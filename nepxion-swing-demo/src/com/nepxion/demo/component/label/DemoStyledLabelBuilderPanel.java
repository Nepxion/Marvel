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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import com.nepxion.swing.border.ComplexLineBorder;
import com.nepxion.swing.label.JStyledLabel;
import com.nepxion.swing.label.JStyledLabelBuilder;
import com.nepxion.swing.layout.box.XBoxLayout;
import com.nepxion.swing.scrollpane.JBasicScrollPane;

public class DemoStyledLabelBuilderPanel
	extends JPanel
{
	public static final String INITIAL_TEXT = "{Preview:bold} of {StyledLabel:f:red}";
	
	protected JStyledLabel styleLabel;
	
	public DemoStyledLabelBuilderPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new XBoxLayout(panel, XBoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
		panel.add(new PreviewPanel());
		panel.add(Box.createVerticalStrut(6));
		panel.add(new InputPanel());
		panel.add(Box.createVerticalStrut(6), XBoxLayout.VARY);
		panel.add(new HelpPanel());
		panel.add(Box.createGlue(), XBoxLayout.VARY);
		
		JBasicScrollPane scrollPane = new JBasicScrollPane();
		scrollPane.getViewport().add(panel);
		
		setLayout(new BorderLayout());
		add(scrollPane);
	}
	
	public class PreviewPanel
		extends JPanel
	{
		public PreviewPanel()
		{
			setLayout(new GridLayout(0, 1, 10, 10));
			setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(new ComplexLineBorder(Color.gray, 1, true, 8), "Preview", TitledBorder.CENTER, TitledBorder.CENTER), BorderFactory.createEmptyBorder(15, 5, 15, 5)));
			
			styleLabel = new JStyledLabel();
			styleLabel.setHorizontalAlignment(SwingConstants.CENTER);
			
			JStyledLabelBuilder.setStyledText(styleLabel, INITIAL_TEXT);
			
			add(styleLabel);
		}
	}
	
	public class InputPanel
		extends JPanel
	{
		public InputPanel()
		{
			setLayout(new BorderLayout(5, 5));
			setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(new ComplexLineBorder(Color.gray, 1, true, 8), "Type in an annotated string and press enter to see the result", TitledBorder.CENTER, TitledBorder.CENTER), BorderFactory.createEmptyBorder(15, 5, 15, 5)));
			
			add(new JLabel("Annotated String: "), BorderLayout.BEFORE_LINE_BEGINS);
			
			final JTextField textField = new JTextField();
			textField.setColumns(50);
			textField.setText(INITIAL_TEXT);
			add(textField, BorderLayout.CENTER);
			
			final JButton button = new JButton("Update");
			button.setMnemonic('U');
			button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					styleLabel.clearStyleRanges();
					
					JStyledLabelBuilder.setStyledText(styleLabel, textField.getText());
				}
			}
			);
			add(button, BorderLayout.AFTER_LINE_ENDS);
			
			textField.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					button.doClick();
				}
			}
			);
		}
	}
	
	public class HelpPanel
		extends JPanel
	{
		public HelpPanel()
		{
			setLayout(new GridLayout(0, 1, 5, 5));
			setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(new ComplexLineBorder(Color.gray, 1, true, 8), "Help", TitledBorder.CENTER, TitledBorder.CENTER), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
			
			JLabel titleLabel = JStyledLabelBuilder.createStyledLabel("{Font styles\\::b, f:blue}");
			titleLabel.setFont(titleLabel.getFont().deriveFont(12.0f));
			add(titleLabel);
			
			add(JStyledLabelBuilder.createStyledLabel("   - {plain:b} or {p:b}, i.e. \\{plain text:p} => {plain text:p}"));
			add(JStyledLabelBuilder.createStyledLabel("   - {bold:b} or {b:b}, i.e. \\{bold text:b} => {bold text:b}"));
			add(JStyledLabelBuilder.createStyledLabel("   - {italic:b} or {i:b}, i.e. \\{italic text:i} => {italic text:i}"));
			add(JStyledLabelBuilder.createStyledLabel("   - {bolditalic:b} or {bi:b}, i.e. \\{bold and italic text:bi} => {bold and italic:bi}"));
			
			titleLabel = JStyledLabelBuilder.createStyledLabel("{Line styles\\::b,f:blue}");
			titleLabel.setFont(titleLabel.getFont().deriveFont(12.0f));
			add(titleLabel);
			
			add(JStyledLabelBuilder.createStyledLabel("   - {strike:b} or {s:b}, i.e. \\{strikethrough:s} => {strikethrough:s}"));
			add(JStyledLabelBuilder.createStyledLabel("   - {doublestrike:b} or {ds:b}, i.e. \\{double strikethrough:ds} => {double strikethrough:ds}"));
			add(JStyledLabelBuilder.createStyledLabel("   - {waved:b} or {w:b}, i.e. \\{waved:w} => {waved:w}"));
			add(JStyledLabelBuilder.createStyledLabel("   - {underlined:b} or {u:b}, i.e. \\{underlined:u} => {underlined:u}"));
			add(JStyledLabelBuilder.createStyledLabel("   - {dotted:b} or {d:b}, i.e. \\{dotted:d} => {dotted:d}"));
			add(JStyledLabelBuilder.createStyledLabel("   - {superscript:b} or {sp:b}, i.e. Java\\{TM:sp} => Java{TM:sp}"));
			add(JStyledLabelBuilder.createStyledLabel("   - {subscipt:b} or {sb:b}, i.e. CO\\{2:sb} => CO{2:sb}"));
			
			titleLabel = JStyledLabelBuilder.createStyledLabel("{Using Colors\\::b,f:blue} using {f:b} for font color, {l:b} for line color and {b:b} for backgroundcolor");
			titleLabel.setFont(titleLabel.getFont().deriveFont(12.0f));
			add(titleLabel);
			
			add(JStyledLabelBuilder.createStyledLabel("   - {f\\::b} plus color name defined in class Color, i.e. \\{red text:f:red} => {red text:f:red}"));
			add(JStyledLabelBuilder.createStyledLabel("   - {l\\::b}: plus color name defined in class Color, i.e. \\{red underline:u, l:red} => {red underline:u, l:red}"));
			add(JStyledLabelBuilder.createStyledLabel("   - {b\\::b}: plus color name defined in class Color, i.e. \\{red background:b:red} => {red background:b:red}"));
			add(JStyledLabelBuilder.createStyledLabel("   - {f\\::b} or {l\\::b} or {b\\::b}: plus #RRGGBB, i.e. \\{any color:f:#00AA55} => {any color:f:#00AA55}"));
			add(JStyledLabelBuilder.createStyledLabel("   - {f\\::b} or {l\\::b} or {b\\::b}: plus #RGB as in CSS, i.e. \\{any color:f:#0A5} => {any color:f:#0A5}"));
			add(JStyledLabelBuilder.createStyledLabel("   - {f\\::b} or {l\\::b}or {b\\::b}: plus (R, G, B), i.e. \\{any line color:s, l:(0, 220, 128)} or \\{any background color:b:(0, 120, 128)} => {any line color:s, l:(0, 220, 128)} or {any background color:b:(0, 120, 128)}"));
			
			titleLabel = JStyledLabelBuilder.createStyledLabel("{Special characters\\::b, f:blue}");
			titleLabel.setFont(titleLabel.getFont().deriveFont(12.0f));
			add(titleLabel);
			
			add(JStyledLabelBuilder.createStyledLabel("   - Special annotation characters {\\{:b} {\\}:b} {\\(:b} {\\):b} {\\#:b} {\\::b} {\\,:b} should be escaped by \"\\\\\" when they are used as regular text"));
			add(JStyledLabelBuilder.createStyledLabel("   - i.e. \\{\\\\\\{brace\\\\\\}:b} => {\\{brace\\}:b}"));
		}
	}
}