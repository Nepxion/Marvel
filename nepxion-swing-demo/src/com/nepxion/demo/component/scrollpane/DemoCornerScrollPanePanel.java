package com.nepxion.demo.component.scrollpane;

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
import javax.swing.JScrollBar;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.button.JBasicToggleButton;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.scrollpane.JCornerScrollPane;
import com.nepxion.swing.textarea.JBasicTextArea;

public class DemoCornerScrollPanePanel
	extends JPanel
{
	public DemoCornerScrollPanePanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new CornerScrollPanePanel());
	}
	
	public class CornerScrollPanePanel
		extends JPanel
	{
		public CornerScrollPanePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Corner ScrollPane"));
			
			JPanel leadingToolBar = new JPanel();
			leadingToolBar.setLayout(new BoxLayout(leadingToolBar, BoxLayout.X_AXIS));
			leadingToolBar.add(new JBasicToggleButton(IconFactory.getContextIcon("view_normal.png")));
			leadingToolBar.add(new JBasicToggleButton(IconFactory.getContextIcon("view_web_layout.png")));
			leadingToolBar.add(new JBasicToggleButton(IconFactory.getContextIcon("view_outline.png")));
			leadingToolBar.add(new JBasicToggleButton(IconFactory.getContextIcon("view_print_layout.png")));
			leadingToolBar.add(new JBasicToggleButton(IconFactory.getContextIcon("view_reading_layout.png")));
			ButtonManager.updateUI(leadingToolBar, new Dimension(18, 18));
			
			JPanel bottomToolBar = new JPanel();
			bottomToolBar.setLayout(new BoxLayout(bottomToolBar, BoxLayout.Y_AXIS));
			bottomToolBar.add(new JBasicButton(IconFactory.getContextIcon("scroll_up.png")));
			bottomToolBar.add(new JBasicButton(IconFactory.getContextIcon("scroll_select.png")));
			bottomToolBar.add(new JBasicButton(IconFactory.getContextIcon("scroll_down.png")));
			ButtonManager.updateUI(bottomToolBar, new Dimension(18, 18));
			
			JCornerScrollPane cornerScrollPane = new JCornerScrollPane(new JBasicTextArea());
			cornerScrollPane.setHorizontalScrollBarPolicy(JCornerScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			cornerScrollPane.setVerticalScrollBarPolicy(JCornerScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			cornerScrollPane.setScrollBarCorner(JCornerScrollPane.HORIZONTAL_LEADING, leadingToolBar);
			cornerScrollPane.setScrollBarCorner(JCornerScrollPane.VERTICAL_BOTTOM, bottomToolBar);
			
			JScrollBar horizontalScrollBar = cornerScrollPane.getHorizontalScrollBar();
			horizontalScrollBar.setPreferredSize(new Dimension(horizontalScrollBar.getPreferredSize().width, 18));
			
			JScrollBar verticalScrollBar = cornerScrollPane.getVerticalScrollBar();
			verticalScrollBar.setPreferredSize(new Dimension(18, verticalScrollBar.getPreferredSize().height));
			
			add(cornerScrollPane);
		}
	}
}