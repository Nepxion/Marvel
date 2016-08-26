package com.nepxion.swing.selector.color;

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
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.MenuElement;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.nepxion.swing.border.LineBorder;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.icon.paint.ColorIcon;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.separator.JBasicSeparator;
import com.nepxion.swing.style.button.lite.JYellowLiteButtonStyle;
import com.nepxion.swing.style.button.lite.LiteButtonUI;

public abstract class JColorSelector
	extends JPanel implements SwingConstants
{	
	/**
	 * The border style of all.
	 */
	public static final int BORDER_STYLE_ALL = 0;
	
	/**
	 * The border style of top.
	 */
	public static final int BORDER_STYLE_TOP = 1;
	
	/**
	 * The border style of center.
	 */
	public static final int BORDER_STYLE_CENTER = 2;
	
	/**
	 * The border style of bottom.
	 */
	public static final int BORDER_STYLE_BOTTOM = 3;

	/**
	 * The selected border.
	 */
	protected Border selectedBorder = BorderFactory.createCompoundBorder(new LineBorder(new Color(239, 72, 16)), new LineBorder(new Color(255, 226, 148)));
	
	/**
	 * The hover border.
	 */
	protected Border hoverBorder = BorderFactory.createCompoundBorder(new LineBorder(new Color(242, 148, 54)), new LineBorder(new Color(255, 226, 148)));

	/**
	 * The color list.
	 */
	protected List colorList;
	
	/**
	 * The color item map.
	 */
	protected Map colorItemMap;
	
	/**
	 * The selected color item.
	 */
	protected ColorItem selectedColorItem;
	
	/**
	 * The selected color.
	 */
	protected Color selectedColor;
	
	/**
	 * Constructs with the default.
	 */
	public JColorSelector()
	{
		initColors();
		initComponents();
	}
	
	/**
	 * Initializes the colors.
	 */
	private void initColors()
	{
		colorList = new ArrayList();
		
		colorList.add(new Color(255, 255, 255));
		colorList.add(new Color(0, 0, 0));
		colorList.add(new Color(238, 236, 225));
		colorList.add(new Color(31, 73, 125));
		colorList.add(new Color(79, 129, 189));
		colorList.add(new Color(192, 80, 77));
		colorList.add(new Color(155, 187, 90));
		colorList.add(new Color(128, 100, 162));
		colorList.add(new Color(75, 172, 198));
		colorList.add(new Color(247, 150, 70));
		
		colorList.add(new Color(242, 242, 242));
		colorList.add(new Color(127, 127, 127));
		colorList.add(new Color(221, 217, 195));
		colorList.add(new Color(198, 217, 241));
		colorList.add(new Color(219, 229, 241));
		colorList.add(new Color(242, 219, 219));
		colorList.add(new Color(234, 241, 221));
		colorList.add(new Color(229, 223, 236));
		colorList.add(new Color(218, 238, 243));
		colorList.add(new Color(253, 233, 217));
		
		colorList.add(new Color(217, 217, 217));
		colorList.add(new Color(89, 89, 89));
		colorList.add(new Color(196, 188, 150));
		colorList.add(new Color(141, 179, 226));
		colorList.add(new Color(184, 204, 228));
		colorList.add(new Color(229, 184, 183));
		colorList.add(new Color(214, 227, 188));
		colorList.add(new Color(204, 192, 217));
		colorList.add(new Color(182, 221, 232));
		colorList.add(new Color(251, 212, 180));
		
		colorList.add(new Color(191, 191, 191));
		colorList.add(new Color(64, 64, 64));
		colorList.add(new Color(148, 138, 84));
		colorList.add(new Color(84, 141, 212));
		colorList.add(new Color(149, 179, 215));
		colorList.add(new Color(217, 149, 148));
		colorList.add(new Color(194, 214, 155));
		colorList.add(new Color(178, 161, 199));
		colorList.add(new Color(146, 205, 220));
		colorList.add(new Color(250, 191, 143));
		
		colorList.add(new Color(166, 166, 166));
		colorList.add(new Color(38, 38, 38));
		colorList.add(new Color(74, 68, 42));
		colorList.add(new Color(23, 54, 93));
		colorList.add(new Color(54, 95, 145));
		colorList.add(new Color(148, 54, 52));
		colorList.add(new Color(118, 146, 60));
		colorList.add(new Color(95, 73, 122));
		colorList.add(new Color(49, 132, 155));
		colorList.add(new Color(227, 108, 10));
		
		colorList.add(new Color(128, 128, 128));
		colorList.add(new Color(13, 13, 13));
		colorList.add(new Color(29, 27, 17));
		colorList.add(new Color(15, 36, 62));
		colorList.add(new Color(36, 64, 97));
		colorList.add(new Color(99, 36, 35));
		colorList.add(new Color(79, 98, 40));
		colorList.add(new Color(64, 49, 82));
		colorList.add(new Color(33, 88, 104));
		colorList.add(new Color(152, 72, 6));
		
		colorList.add(new Color(192, 0, 0));
		colorList.add(new Color(255, 0, 0));
		colorList.add(new Color(255, 192, 0));
		colorList.add(new Color(255, 255, 0));
		colorList.add(new Color(146, 208, 80));
		colorList.add(new Color(0, 176, 80));
		colorList.add(new Color(0, 176, 240));
		colorList.add(new Color(0, 112, 192));
		colorList.add(new Color(0, 32, 96));
		colorList.add(new Color(112, 48, 160));
		
		colorItemMap = new LinkedHashMap();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 1));
		setBackground(Color.white);
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 2));
		
		JPanel themePanel = createThemePanel();
		add(themePanel);
		
		JPanel standardPanel = createStandardPanel();
		add(standardPanel);
		
		JPanel buttonPanel = createButtonPanel();
		add(buttonPanel);
	}
	
	/**
	 * Creates the theme panel.
	 * @return the instance of JPanel
	 */
	private JPanel createThemePanel()
	{
		JPanel labelPanel = createLabelPanel(SwingLocale.getString("theme_color"));
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.white);
		topPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		topPanel.setLayout(new GridLayout(1, 10, 4, 0));
		
		for (int i = 0; i < 10; i++)
		{	
			Color color = (Color) colorList.get(i);
			
			int borderStyle = BORDER_STYLE_ALL;
			
			ColorItem colorItem = new ColorItem(color, borderStyle);
			topPanel.add(colorItem);
			
			colorItemMap.put(color, colorItem);
		}
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.white);
		centerPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 0, 2));
		centerPanel.setLayout(new GridLayout(5, 10, 4, 0));
		
		for (int i = 10; i < 60; i++)
		{	
			Color color = (Color) colorList.get(i);
			
			int borderStyle = BORDER_STYLE_ALL;

			if (i / 10 == 1)
			{
				borderStyle = BORDER_STYLE_TOP;
			}
			else if (i / 10 == 5)
			{
				borderStyle = BORDER_STYLE_BOTTOM;
			}
			else
			{
				borderStyle = BORDER_STYLE_CENTER;
			}
			
			ColorItem colorItem = new ColorItem(color, borderStyle);
			centerPanel.add(colorItem);
			
			colorItemMap.put(color, colorItem);
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		panel.add(labelPanel);
		panel.add(topPanel);
		panel.add(centerPanel);
		
		return panel;
	}
	
	/**
	 * Create the standard panel.
	 * @return the instance of JPanel
	 */
	private JPanel createStandardPanel()
	{
		JPanel labelPanel = createLabelPanel(SwingLocale.getString("standard_color"));
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.white);
		topPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		topPanel.setLayout(new GridLayout(1, 10, 4, 0));
		
		for (int i = 60; i < 70; i++)
		{	
			Color color = (Color) colorList.get(i);
			
			int borderStyle = BORDER_STYLE_ALL;
			
			ColorItem colorItem = new ColorItem(color, borderStyle);
			topPanel.add(colorItem);
			
			colorItemMap.put(color, colorItem);
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		panel.add(labelPanel);
		panel.add(topPanel);
		
		return panel;
	}
	
	/**
	 * Creates the button panel.
	 * @return the instance of JPanel
	 */
	private JPanel createButtonPanel()
	{
		JBasicButton noColorButton = new JBasicButton(SwingLocale.getString("no_color"), new ColorIcon(null, new Color(226, 228, 231), 16, 16), SwingLocale.getString("no_color"));
		noColorButton.setUI(new LiteButtonUI(new JYellowLiteButtonStyle()));
		ButtonManager.setButtonLayout(noColorButton, new int[] {HORIZONTAL, LEFT});
		noColorButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				hideParent();
				
				setColor(null);
				
				executeSelection();
			}
		}
		);
		
		JBasicButton otherColorColorButton = new JBasicButton(SwingLocale.getString("other_color") + "...", IconFactory.getSwingIcon("palette.png"), SwingLocale.getString("other_color") + "...");
		otherColorColorButton.setUI(new LiteButtonUI(new JYellowLiteButtonStyle()));
		ButtonManager.setButtonLayout(otherColorColorButton, new int[] {HORIZONTAL, LEFT});
		otherColorColorButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{			
				hideParent();
				
				setColor(JColorChooser.showDialog(HandleManager.getFrame(JColorSelector.this), SwingLocale.getString("color_selector"), selectedColor));
				
				executeSelection();
			}
		}
		);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		panel.add(noColorButton);
		panel.add(new JBasicSeparator(JBasicSeparator.HORIZONTAL, JBasicSeparator.LOWERED_STYLE, 22));
		panel.add(otherColorColorButton);
		
		return panel;
	}
	
	/**
	 * Creates the label panel.
	 * @param title the title string
	 * @return the instance of JPanel
	 */
	private JPanel createLabelPanel(String title)
	{
		JLabel label = new JLabel(title);
		label.setBorder(BorderFactory.createEmptyBorder(0, 7, 0, 0));
		
		JPanel labelPanel = new JPanel();
		labelPanel.setBackground(new Color(239, 243, 246));
		labelPanel.setPreferredSize(new Dimension(labelPanel.getPreferredSize().width, 22));
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.X_AXIS));
		labelPanel.add(label);
		
		return labelPanel;
	}
	
	/**
	 * Hides the parent.
	 */
	private void hideParent()
	{
		Component menu = HandleManager.getComponent(this, MenuElement.class);
		if (menu != null)
		{
			menu.setVisible(false);
		}
		
		Component dialog = HandleManager.getComponent(this, Dialog.class);
		if (dialog != null)
		{
			dialog.setVisible(false);
		}
	}
	
	/**
	 * Gets the selected color.
	 * @return the instance of Color
	 */
	public Color getColor()
	{
		return selectedColor;
	}
	
	/**
	 * Sets the selected color.
	 * @param color the instance of Color
	 */
	public void setColor(Color color)
	{				
		this.selectedColor = color;
		
		for (Iterator iterator = colorItemMap.values().iterator(); iterator.hasNext();)
		{
			ColorItem colorItem = (ColorItem) iterator.next();
			
			if (colorItem.getColor().equals(color))
			{
				colorItem.setSelected(true);
			}
			else
			{
				colorItem.setSelected(false);
			}
		}
	}
	
	public class ColorItem
		extends JPanel implements MouseListener
	{
		/**
		 * The instance of Color.
		 */
		protected Color color;
		
		/**
		 * The boolean value of selected.
		 */
		protected boolean selected;
		
		/**
		 * The instance of line border.
		 */
		protected LineBorder normalBorder = new LineBorder(new Color(227, 228, 232));
		
		/**
		 * Constructs with the specified initial color and border style.
		 * @param color the instance of Color
		 * @param borderStyle the border style
		 */
		public ColorItem(Color color, int borderStyle)
		{
			this.color = color;
			
			switch (borderStyle)
			{
				case BORDER_STYLE_ALL :
					break;
				case BORDER_STYLE_TOP :
					normalBorder.setColor(null, SOUTH);
					break;
				case BORDER_STYLE_CENTER :
					normalBorder.setColor(null, NORTH);
					normalBorder.setColor(null, SOUTH);
					break;
				case BORDER_STYLE_BOTTOM :
					normalBorder.setColor(null, NORTH);
					break;					
			}
			
			setBackground(color);
			setBorder(normalBorder);
			setToolTipText(SwingLocale.getString("red_short") + " " + color.getRed() + ", " + SwingLocale.getString("green_short") + " " + color.getGreen() + ", " + SwingLocale.getString("blue_short") + " " + color.getBlue());
			
			addMouseListener(this);
		}
		
		/**
		 * Gets the color.
		 * @return the instance of Color
		 */
		public Color getColor()
		{
			return color;
		}
		
		/**
		 * Gets the preferred size.
		 * @return the instance of Dimension
		 */
		public Dimension getPreferredSize()
		{
			return new Dimension(13, 13);
		}
		
		/**
		 * Gets the maximum size.
		 * @return the instance of Dimension
		 */
		public Dimension getMaximumSize()
		{
			return getPreferredSize();
		}
		
		/**
		 * Gets the minimum size.
		 * @return the instance of Dimension
		 */
		public Dimension getMinimumSize()
		{
			return getPreferredSize();
		}
		
		/**
		 * Sets the selected.
		 * @param selected the boolean value of selected
		 */
		public void setSelected(boolean selected)
		{
			this.selected = selected;
			
			if (selected)
			{
				setBorder(selectedBorder);
			}
			else
			{
				setBorder(normalBorder);
			}
		}
		
		/**
		 * Returns true if selected.
		 * @return true if selected 
		 */
		public boolean isSelected()
		{
			return selected;
		}
		
	    /**
	     * Invoked when the mouse button has been clicked (pressed and released) on a component.
	     * @param e the instance of MouseEvent
	     */
		public void mouseClicked(MouseEvent e)
		{
		}
		
	    /**
	     * Invoked when the mouse button has been pressed on a component.
	     * @param e the instance of MouseEvent
	     */
		public void mousePressed(MouseEvent e)
		{			
			hideParent();
			
			setColor(color);
			
			executeSelection();
		}
		
	    /**
	     * Invoked when the mouse button has been released on a component.
	     * @param e the instance of MouseEvent
	     */
		public void mouseReleased(MouseEvent e)
		{
		}
		
	    /**
	     * Invoked when the mouse enters a component.
	     * @param e the instance of MouseEvent
	     */
		public void mouseEntered(MouseEvent e)
		{
			setBorder(hoverBorder);
		}
		
	    /**
	     * Invoked when the mouse exits a component.
	     * @param e the instance of MouseEvent
	     */
		public void mouseExited(MouseEvent e)
		{
			setBorder(selected ? selectedBorder : normalBorder);
		}
	}
	
	/**
	 * Executes the selection.
	 */
	public abstract void executeSelection();
}