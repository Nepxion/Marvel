package com.nepxion.demo.component.ribbon;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JClassicButton;
import com.nepxion.swing.button.JClassicMenuButton;
import com.nepxion.swing.button.JClassicToggleButton;
import com.nepxion.swing.combobox.JBasicComboBox;
import com.nepxion.swing.font.FontManager;
import com.nepxion.swing.framework.ribbon.JRibbon;
import com.nepxion.swing.framework.ribbon.JRibbonBar;
import com.nepxion.swing.framework.ribbon.JRibbonContainer;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.icon.paint.ColorCombinationIcon;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;
import com.nepxion.swing.selector.color.JClassicColorSelectorButton;
import com.nepxion.swing.separator.JBasicSeparator;
import com.nepxion.swing.toolbar.JBasicToolBar;

public class DemoRibbonBar
	extends JRibbonBar
{
	public DemoRibbonBar(JRibbonContainer ribbonContainer)
	{
		super(ribbonContainer);
		
		JPanel ribbonView = getRibbonView();
		
		ribbonView.add(createCopyAndPasteRibbon());
		ribbonView.add(createFontRibbon());
		ribbonView.add(createParagraphRibbon());
	}
	
	private JRibbon createCopyAndPasteRibbon()
	{
		JRibbon ribbon = new JRibbon("剪贴版", "剪贴版");
		
		DemoCornerAction cornerAction = new DemoCornerAction();
		cornerAction.setSource(this);
		ribbon.setCornerAction(cornerAction);
		
		JBasicToolBar toolBar = ribbon.getToolBar();
		
		JBasicPopupMenu pastePopupMenu = new JBasicPopupMenu();
		pastePopupMenu.add(new JBasicMenuItem("粘贴选项", "粘贴选项"));
		pastePopupMenu.add(new JBasicMenuItem("粘贴选项", "粘贴选项"));
		pastePopupMenu.add(new JBasicMenuItem("粘贴选项", "粘贴选项"));
		pastePopupMenu.add(new JBasicMenuItem("粘贴选项", "粘贴选项"));
		pastePopupMenu.add(new JBasicMenuItem("粘贴选项", "粘贴选项"));
		
		JClassicMenuButton pasteButton = new JClassicMenuButton(ButtonManager.getHtmlText("粘贴\n&nbsp;"), IconFactory.getContextIcon("paste_32.png"), "粘贴");
		pasteButton.setShowArrowRight(false);
		pasteButton.setPopupMenu(pastePopupMenu);
		ButtonManager.setButtonLayout(pasteButton, new int[] {VERTICAL, CENTER});
		
		JClassicButton cutButton = new JClassicButton("剪切", IconFactory.getContextIcon("cut.png"), "剪切");
		ButtonManager.setButtonLayout(cutButton, new int[] {HORIZONTAL, LEFT});
		
		JClassicButton copyButton = new JClassicButton("复制", IconFactory.getContextIcon("copy.png"), "复制");
		ButtonManager.setButtonLayout(copyButton, new int[] {HORIZONTAL, LEFT});
		
		JClassicButton brushButton = new JClassicButton("格式刷", IconFactory.getContextIcon("brush.png"), "格式刷");
		ButtonManager.setButtonLayout(brushButton, new int[] {HORIZONTAL, LEFT});
		
		double[][] size = 
		{
			{TableLayout.PREFERRED, TableLayout.PREFERRED}, 
			{TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}
		};
		
		toolBar.setLayout(new TableLayout(size));
		toolBar.add(pasteButton, "0, 0, 0, 2");
		toolBar.add(cutButton, "1, 0");
		toolBar.add(copyButton, "1, 1");
		toolBar.add(brushButton, "1, 2");
		
		ButtonManager.updateUI(toolBar, (int[]) null);
		
		return ribbon;
	}
	
	private JRibbon createFontRibbon()
	{
		JRibbon ribbon = new JRibbon("字体", "字体");
		
		DemoCornerAction cornerAction = new DemoCornerAction();
		cornerAction.setSource(this);
		ribbon.setCornerAction(cornerAction);
		
		JBasicToolBar toolBar = ribbon.getToolBar();
		
		JBasicToolBar topToolBar = new JBasicToolBar();
		
		JBasicComboBox fontNameComboBox = new JBasicComboBox(FontManager.getAvailableFontFamilyNames());
		topToolBar.add(fontNameComboBox);
		
		JBasicComboBox fontSizeComboBox = new JBasicComboBox(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"});
		topToolBar.add(fontSizeComboBox);
		
		topToolBar.add(new JClassicButton(IconFactory.getContextIcon("font_zoom_in.png")));
		topToolBar.add(new JClassicButton(IconFactory.getContextIcon("font_zoom_out.png")));
		
		JBasicSeparator separator1 = new JBasicSeparator();
		topToolBar.add(separator1);
		
		topToolBar.add(new JClassicMenuButton(IconFactory.getContextIcon("font_upper_lower_case.png")));

		JBasicSeparator separator2 = new JBasicSeparator();
		topToolBar.add(separator2);
		
		topToolBar.add(new JClassicButton(IconFactory.getContextIcon("font_clear_style.png")));
		topToolBar.add(new JClassicButton(IconFactory.getContextIcon("font_spell.png")));
		topToolBar.add(new JClassicToggleButton(IconFactory.getContextIcon("font_border.png")));
		ButtonManager.updateUI(topToolBar, new Insets(2, 2, 2, 2));
		
		fontNameComboBox.setPreferredSize(new Dimension(105, fontNameComboBox.getPreferredSize().height));
		fontSizeComboBox.setPreferredSize(new Dimension(50, fontNameComboBox.getPreferredSize().height));
		separator1.setLength(15);
		separator2.setLength(15);
		
		JBasicToolBar bottomToolBar = new JBasicToolBar();
		
		bottomToolBar.add(new JClassicToggleButton(IconFactory.getContextIcon("font_bold.png"), true));
		bottomToolBar.add(new JClassicToggleButton(IconFactory.getContextIcon("font_italic.png"), true));		
		bottomToolBar.add(new JClassicMenuButton(IconFactory.getContextIcon("font_underline.png")));
		bottomToolBar.add(new JClassicToggleButton(IconFactory.getContextIcon("font_delete_line.png")));
		bottomToolBar.add(new JClassicToggleButton(IconFactory.getContextIcon("font_mark_down.png")));
		bottomToolBar.add(new JClassicToggleButton(IconFactory.getContextIcon("font_mark_up.png")));
		
		JBasicSeparator separator3 = new JBasicSeparator();
		bottomToolBar.add(separator3);
				
		bottomToolBar.add(new JClassicMenuButton(IconFactory.getContextIcon("font_effect.png")));
		
		JClassicColorSelectorButton fontHighlightButton = new JClassicColorSelectorButton(new ColorCombinationIcon(IconFactory.getContextIcon("font_highlight.png"), Color.white), "字体高亮色")
		{
			public void executeSelection(Color color)
			{
				JBasicOptionPane.showMessageDialog(HandleManager.getFrame(DemoRibbonBar.this), "Color : " + color);
			}
			
		};
		bottomToolBar.add(fontHighlightButton);
		
		JClassicColorSelectorButton fontColorButton = new JClassicColorSelectorButton(new ColorCombinationIcon(IconFactory.getContextIcon("font_color.png"), Color.yellow), "字体颜色")
		{
			public void executeSelection(Color color)
			{
				JBasicOptionPane.showMessageDialog(HandleManager.getFrame(DemoRibbonBar.this), "Color : " + color);
			}
			
		};
		bottomToolBar.add(fontColorButton);
		
		bottomToolBar.add(new JClassicToggleButton(IconFactory.getContextIcon("font_background.png")));
		bottomToolBar.add(new JClassicButton(IconFactory.getContextIcon("font_circle.png")));
		
		ButtonManager.updateUI(bottomToolBar, new Insets(2, 2, 2, 2));
		
		separator3.setLength(15);
		
		toolBar.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		toolBar.setLayout(new FiledLayout());
		toolBar.add(topToolBar);
		toolBar.add(bottomToolBar);
		
		return ribbon;
	}
	
	private JRibbon createParagraphRibbon()
	{
		JRibbon ribbon = new JRibbon("段落", "段落");
		
		DemoCornerAction cornerAction = new DemoCornerAction();
		cornerAction.setSource(this);
		ribbon.setCornerAction(cornerAction);
		
		JBasicToolBar toolBar = ribbon.getToolBar();
		
		JBasicToolBar topToolBar = new JBasicToolBar();
		
		topToolBar.add(new JClassicMenuButton(IconFactory.getContextIcon("paragraph_denotation.png")));
		topToolBar.add(new JClassicMenuButton(IconFactory.getContextIcon("paragraph_number.png")));
		topToolBar.add(new JClassicMenuButton(IconFactory.getContextIcon("paragraph_list.png")));
		
		JBasicSeparator separator1 = new JBasicSeparator();
		topToolBar.add(separator1);
		
		topToolBar.add(new JClassicButton(IconFactory.getContextIcon("paragraph_reduce_indent.png")));
		topToolBar.add(new JClassicButton(IconFactory.getContextIcon("paragraph_increase_indent.png")));
		
		JBasicSeparator separator2 = new JBasicSeparator();
		topToolBar.add(separator2);
		topToolBar.add(new JClassicMenuButton(IconFactory.getContextIcon("paragraph_chinest_style.png")));
		
		JBasicSeparator separator3 = new JBasicSeparator();
		topToolBar.add(separator3);
		
		topToolBar.add(new JClassicButton(IconFactory.getContextIcon("paragraph_sort_asc.png")));
		
		JBasicSeparator separator4 = new JBasicSeparator();
		topToolBar.add(separator4);
		
		topToolBar.add(new JClassicToggleButton(IconFactory.getContextIcon("paragraph_toggle_mark.png")));
		ButtonManager.updateUI(topToolBar, new Insets(2, 2, 2, 2));
		
		separator1.setLength(15);
		separator2.setLength(15);
		separator3.setLength(15);
		separator4.setLength(15);
		
		JBasicToolBar bottomToolBar = new JBasicToolBar();
		
		bottomToolBar.add(new JClassicToggleButton(IconFactory.getContextIcon("paragraph_align_left.png"), true));
		bottomToolBar.add(new JClassicToggleButton(IconFactory.getContextIcon("paragraph_align_center.png")));		
		bottomToolBar.add(new JClassicToggleButton(IconFactory.getContextIcon("paragraph_align_right.png")));
		bottomToolBar.add(new JClassicToggleButton(IconFactory.getContextIcon("paragraph_align_all.png")));
		bottomToolBar.add(new JClassicToggleButton(IconFactory.getContextIcon("paragraph_align_separate.png")));		
		
		JBasicSeparator separator5 = new JBasicSeparator();
		bottomToolBar.add(separator5);
		
		bottomToolBar.add(new JClassicMenuButton(IconFactory.getContextIcon("paragraph_ident.png")));
		
		JBasicSeparator separator6 = new JBasicSeparator();
		bottomToolBar.add(separator6);
				
		JClassicColorSelectorButton paragraphBackgroundButton = new JClassicColorSelectorButton(new ColorCombinationIcon(IconFactory.getContextIcon("paragraph_background.png"), Color.red), "填充颜色")
		{
			public void executeSelection(Color color)
			{
				JBasicOptionPane.showMessageDialog(HandleManager.getFrame(DemoRibbonBar.this), "Color : " + color);
			}
			
		};
		bottomToolBar.add(paragraphBackgroundButton);
		
		bottomToolBar.add(new JClassicMenuButton(IconFactory.getContextIcon("paragraph_border.png")));
		
		ButtonManager.updateUI(bottomToolBar, new Insets(2, 2, 2, 2), new ButtonGroup());
		
		separator5.setLength(15);
		separator6.setLength(15);
		
		toolBar.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		toolBar.setLayout(new FiledLayout());
		toolBar.add(topToolBar);
		toolBar.add(bottomToolBar);
		
		return ribbon;
	}	
}