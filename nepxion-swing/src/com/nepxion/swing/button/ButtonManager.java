package com.nepxion.swing.button;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.StringTokenizer;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import com.nepxion.swing.buttonbar.JBasicButtonBar;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.font.FontContext;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.separator.JBasicSeparator;
import com.nepxion.swing.style.button.AbstractButtonUI;
import com.nepxion.swing.style.button.IButtonStyle;
import com.nepxion.swing.style.button.IButtonUI;
import com.nepxion.swing.style.button.flat.FlatButtonUI;
import com.nepxion.swing.style.button.flat.FlatMenuButtonUI;
import com.nepxion.swing.style.button.flat.FlatSplitButtonUI;
import com.nepxion.swing.style.buttonbar.ButtonBarUI;

public class ButtonManager
	implements SwingConstants
{
	/**
	 * The button ui
	 */
	private static IButtonUI buttonUI;
	
	/**
	 * The menu button ui.
	 */
	private static IButtonUI menuButtonUI;
	
	/**
	 * The split button ui.
	 */
	private static IButtonUI splitButtonUI;
	
	/**
	 * The button style.
	 */
	private static IButtonStyle buttonStyle;
	
	/**
	 * The flat button ui.
	 */
	private static FlatButtonUI flatButtonUI;
	
	/**
	 * The flat menu button ui. 
	 */
	private static FlatMenuButtonUI flatMenuButtonUI;
	
	/**
	 * The flat split button ui.
	 */
	private static FlatSplitButtonUI flatSplitButtonUI;
	
	/**
	 * The button bar ui.
	 */
	private static ButtonBarUI buttonBarUI;

	/**
	 * Sets the preference style for the button.
	 * @param button the instance of AbstractButton
	 */
	public static void setPreferenceStyle(AbstractButton button)
	{
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			button.setMargin(new Insets(0, 0, 0, 0));
		}
		else
		{
			button.setMargin(new Insets(3, 9, 3, 9));
			button.setFocusPainted(false);
		}
	}
	
	/**
	 * Updates ui for buttons components which are added in the container.
	 * @param container the instance of Container. It is mainly JToolBar, JPanel etc.
	 */
	public static void updateUI(Container container)
	{
		updateUI(container, (Insets) null);
	}
	
	/**
	 * Updates ui for buttons components which are added in the container.
	 * @param container the instance of Container. It is mainly JToolBar, JPanel etc.
	 * @param insets the instance of Insets
	 */
	public static void updateUI(Container container, Insets insets)
	{
		updateUI(container, insets, new int[] {HORIZONTAL, CENTER});
	}
	
	/**
	 * Updates ui for buttons components which are added in the container.
	 * @param container the instance of Container. It is mainly JToolBar, JPanel etc.
	 * @param isFlatButtonUI the boolean value of isFlatButtonUI
	 */
	public static void updateUI(Container container, boolean isFlatButtonUI)
	{
		updateUI(container, new int[] {HORIZONTAL, CENTER}, isFlatButtonUI);
	}	
	
	/**
	 * Updates ui for buttons components which are added in the container.
	 * @param container the instance of Container. It is mainly JToolBar, JPanel etc.
	 * @param layout the layout array
	 */
	public static void updateUI(Container container, int[] layout)
	{
		updateUI(container, (Insets) null, layout);
	}		
	
	/**
	 * Updates ui for buttons components which are added in the container.
	 * @param container the instance of Container. It is mainly JToolBar, JPanel etc.
	 * @param insets the instance of Insets
	 * @param layout the layout array
	 */
	public static void updateUI(Container container, Insets insets, int[] layout)
	{
		updateUI(container, insets, null, layout);
	}
	
	/**
	 * Updates ui for buttons components which are added in the container.
	 * @param container the instance of Container. It is mainly JToolBar, JPanel etc.
	 * @param buttonGroup the instance of ButtonGroup
	 */
	public static void updateUI(Container container, ButtonGroup buttonGroup)
	{
		updateUI(container, (Insets) null, buttonGroup);
	}
	
	/**
	 * Updates ui for buttons components which are added in the container.
	 * @param container the instance of Container. It is mainly JToolBar, JPanel etc.
	 * @param insets the instance of Insets
	 * @param buttonGroup the instance of ButtonGroup
	 */
	public static void updateUI(Container container, Insets insets, ButtonGroup buttonGroup)
	{
		updateUI(container, insets, buttonGroup, new int[] {HORIZONTAL, CENTER});
	}
	
	/**
	 * Updates ui for buttons components which are added in the container.
	 * @param container the instance of Container. It is mainly JToolBar, JPanel etc.
	 * @param dimension the instance of Dimension
	 */
	public static void updateUI(Container container, Dimension dimension)
	{
		updateUI(container, dimension, false);
	}
	
	/**
	 * Updates ui for buttons components which are added in the container.
	 * @param container the instance of Container. It is mainly JToolBar, JPanel etc.
	 * @param layout the layout array
	 * @param isFlatButtonUI the boolean value of isFlatButtonUI
	 */
	public static void updateUI(Container container, int[] layout, boolean isFlatButtonUI)
	{
		updateUI(container, (Dimension) null, layout, isFlatButtonUI);
	}
		
	/**
	 * Updates ui for buttons components which are added in the container.
	 * @param container the instance of Container. It is mainly JToolBar, JPanel etc.
	 * @param buttonGroup the instance of ButtonGroup
	 * @param isFlatButtonUI the boolean value of isFlatButtonUI
	 */	
	public static void updateUI(Container container, ButtonGroup buttonGroup, boolean isFlatButtonUI)
	{
		updateUI(container, null, buttonGroup, isFlatButtonUI);
	}		
	
	/**
	 * Updates ui for buttons components which are added in the container.
	 * @param container the instance of Container. It is mainly JToolBar, JPanel etc.
	 * @param dimension the instance of Dimension
	 * @param isFlatButtonUI the boolean value of isFlatButtonUI
	 */
	public static void updateUI(Container container, Dimension dimension, boolean isFlatButtonUI)
	{
		updateUI(container, dimension, (ButtonGroup) null, isFlatButtonUI);
	}	
		
	/**
	 * Updates ui for buttons components which are added in the container.
	 * @param container the instance of Container. It is mainly JToolBar, JPanel etc.
	 * @param buttonGroup the instance of ButtonGroup
	 * @param layout the layout array
	 */
	public static void updateUI(Container container, ButtonGroup buttonGroup, int[] layout)
	{
		updateUI(container, (Insets) null, buttonGroup, layout);
	}	
	
	/**
	 * Updates ui for buttons components which are added in the container.
	 * @param container the instance of Container. It is mainly JToolBar, JPanel etc.
	 * @param insets the instance of Insets
	 * @param buttonGroup the instance of ButtonGroup
	 * @param layout the layout array
	 */
	public static void updateUI(Container container, Insets insets, ButtonGroup buttonGroup, int[] layout)
	{
		updateUI(container, null, insets, buttonGroup, layout, false);
	}		
	
	/**
	 * Updates ui for buttons components which are added in the container.
	 * @param container the instance of Container. It is mainly JToolBar, JPanel etc.
	 * @param dimension the instance of Dimension
	 * @param layout the layout array
	 */
	public static void updateUI(Container container, Dimension dimension, int[] layout)
	{
		updateUI(container, dimension, null, layout);
	}
	
	/**
	 * Updates ui for buttons components which are added in the container.
	 * @param container the instance of Container. It is mainly JToolBar, JPanel etc.
	 * @param dimension the instance of Dimension
	 * @param buttonGroup the instance of ButtonGroup
	 */
	public static void updateUI(Container container, Dimension dimension, ButtonGroup buttonGroup)
	{
		updateUI(container, dimension, buttonGroup, new int[] {HORIZONTAL, CENTER});
	}	
	
	/**
	 * Updates ui for buttons components which are added in the container.
	 * @param container the instance of Container. It is mainly JToolBar, JPanel etc.
	 * @param buttonGroup the instance of ButtonGroup
	 * @param layout the layout array
	 * @param isFlatButtonUI the boolean value of isFlatButtonUI
	 */
	public static void updateUI(Container container, ButtonGroup buttonGroup, int[] layout, boolean isFlatButtonUI)
	{
		updateUI(container, null, buttonGroup, layout, isFlatButtonUI);
	}
	
	/**
	 * Updates ui for buttons components which are added in the container.
	 * @param container the instance of Container. It is mainly JToolBar, JPanel etc.
	 * @param dimension the instance of Dimension
	 * @param layout the layout array
	 * @param isFlatButtonUI the boolean value of isFlatButtonUI
	 */
	public static void updateUI(Container container, Dimension dimension, int[] layout, boolean isFlatButtonUI)
	{
		updateUI(container, dimension, null, layout, isFlatButtonUI);
	}
	
	/**
	 * Updates ui for buttons components which are added in the container.
	 * @param container the instance of Container. It is mainly JToolBar, JPanel etc.
	 * @param dimension the instance of Dimension
	 * @param buttonGroup the instance of ButtonGroup
	 * @param isFlatButtonUI the boolean value of isFlatButtonUI
	 */
	public static void updateUI(Container container, Dimension dimension, ButtonGroup buttonGroup, boolean isFlatButtonUI)
	{
		updateUI(container, dimension, buttonGroup, new int[] {HORIZONTAL, CENTER}, isFlatButtonUI);
	}
	
	/**
	 * Updates ui for buttons components which are added in the container.
	 * @param container the instance of Container. It is mainly JToolBar, JPanel etc.
	 * @param dimension the instance of Dimension
	 * @param buttonGroup the instance of ButtonGroup
	 * @param layout the layout array
	 */
	public static void updateUI(Container container, Dimension dimension, ButtonGroup buttonGroup, int[] layout)
	{
		updateUI(container, dimension, buttonGroup, layout, false);
	}
	
	/**
	 * Updates ui for buttons components which are added in the container.
	 * @param container the instance of Container. It is mainly JToolBar, JPanel etc.
	 * @param dimension the instance of Dimension
	 * @param buttonGroup the instance of ButtonGroup
	 * @param layout the layout array
	 * @param isFlatButtonUI the boolean value of isFlatButtonUI
	 */
	public static void updateUI(Container container, Dimension dimension, ButtonGroup buttonGroup, int[] layout, boolean isFlatButtonUI)
	{
		updateUI(container, dimension, null, buttonGroup, layout, isFlatButtonUI);
	}
		
	/**
	 * Updates ui for buttons components which are added in the container.
	 * The button component includes Button, ToggleButton, MenuButton, SplitButton, Separator.
	 * When the specified dimension and insets is not null, it will be distributed to all buttons.
	 * When the specified buttonGroup is not null, all of toggle buttons will be added in it. (The attribute of "isGrouped" in the toggle button should be true).
	 * The layout array is [iconTextLayout, horizontalAlignment].
	 * The isFlatButtonUI will be distributed to the button as flat button ui style.
	 * @param container the instance of Container. It is mainly JToolBar, JPanel etc.
	 * @param dimension the instance of Dimension
	 * @param insets the instance of Insets
	 * @param buttonGroup the instance of ButtonGroup
	 * @param layout the layout array
	 * @param isFlatButtonUI the boolean value of isFlatButtonUI
	 */
	public static void updateUI(Container container, Dimension dimension, Insets insets, ButtonGroup buttonGroup, int[] layout, boolean isFlatButtonUI)
	{
		for (int i = 0; i < container.getComponentCount(); i++)
		{
			Component component = container.getComponent(i);
			if (component instanceof AbstractButton)
			{
				AbstractButton abstractButton = (AbstractButton) component;
				
				if (layout != null)
				{
					setButtonLayout(abstractButton, layout);
				}
				
				if (container instanceof JToolBar)
				{
					abstractButton.setFocusPainted(false);					
				}
				
				if (insets != null)
				{
					abstractButton.setMargin(insets);
				}
				else
				{
					if (container instanceof JToolBar && abstractButton instanceof JButton)
					{
						abstractButton.setMargin(new Insets(3, 3, 3, 3));				
					}
				}
				
				abstractButton.setFont(FontContext.getFont());
				
				if (buttonGroup != null)
				{
					if (abstractButton instanceof IToggleButton)
					{
						IToggleButton toggleButton = (IToggleButton) component;
						if (toggleButton.isGrouped())
						{	
							buttonGroup.add(abstractButton);
						}
					}
				}
				
				if (component instanceof JBasicSplitButton)
				{
					JBasicSplitButton button = (JBasicSplitButton) component;
					if (isFlatButtonUI)
					{
						if (flatSplitButtonUI == null)
						{
							flatSplitButtonUI = new FlatSplitButtonUI();
						}	
						button.setUI(flatSplitButtonUI);
					}
					else
					{
						button.setUI((AbstractButtonUI) splitButtonUI);
					}
					if (dimension != null)
					{
						button.setDimension(new Dimension(dimension.width + 5, dimension.height));
					}
				}
				else if (component instanceof JBasicMenuButton)
				{
					JBasicMenuButton button = (JBasicMenuButton) component;
					if (isFlatButtonUI)
					{
						if (flatMenuButtonUI == null)
						{
							flatMenuButtonUI = new FlatMenuButtonUI();
						}							
						button.setUI(flatMenuButtonUI);
					}
					else
					{
						button.setUI((AbstractButtonUI) menuButtonUI);
					}
					if (dimension != null)
					{
						if (container instanceof JToolBar)
						{
							JToolBar toolBar = (JToolBar) container;
							if (toolBar.getOrientation() == VERTICAL)
							{
								button.setDimension(dimension);
							}
							else
							{
								button.setDimension(new Dimension(dimension.width + 5, dimension.height));
							}
						}
						else
						{
							button.setDimension(new Dimension(dimension.width + 5, dimension.height));
						}
					}
				}
				else if (component instanceof JBasicButton)
				{
					JBasicButton button = (JBasicButton) component;
					if (isFlatButtonUI)
					{
						if (flatButtonUI == null)
						{
							flatButtonUI = new FlatButtonUI();
						}							
						button.setUI(flatButtonUI);
					}
					else
					{
						button.setUI((AbstractButtonUI) buttonUI);
					}
					if (dimension != null)
					{
						button.setDimension(dimension);
					}
				}
				else if (component instanceof JBasicToggleButton)
				{
					JBasicToggleButton button = (JBasicToggleButton) component;
					if (isFlatButtonUI)
					{
						if (flatButtonUI == null)
						{
							flatButtonUI = new FlatButtonUI();
						}							
						button.setUI(flatButtonUI);
					}
					else
					{
						button.setUI((AbstractButtonUI) buttonUI);
					}
					if (dimension != null)
					{
						button.setDimension(dimension);
					}
				}
				else
				{
					if (dimension != null)
					{
						DimensionManager.setDimension(abstractButton, dimension);
					}
				}
			}
			else if (component instanceof JBasicSeparator)
			{
				JBasicSeparator separator = (JBasicSeparator) component;
				Dimension size = null;
				if (dimension != null)
				{
					size = dimension;
				}
				else
				{
					size = container.getPreferredSize();
				}
				
				if (container instanceof JToolBar)
				{
					// JToolBar toolBar = (JToolBar) container;
					// separator.setOrientation(toolBar.getOrientation() == VERTICAL ? HORIZONTAL : VERTICAL);
					separator.setLength(separator.getOrientation()== VERTICAL ? size.height - 8 : size.width - 8);
				}
				else
				{
					separator.setLength(size.height - 8);
				}
			}
		}
	}
	
	/**
	 * Update ui for the button bar.
	 * @param buttonBar the instance of JBasicButtonBar
	 */
	public static void updateUI(JBasicButtonBar buttonBar)
	{
		buttonBar.setUI(buttonBarUI);
	}
	
	/**
	 * Sets the button layout.
	 * @param button the instance of AbstractButton
	 * @param layout the layout array
	 */
	public static void setButtonLayout(AbstractButton button, int[] layout)
	{
		int iconTextLayout = layout[0];
		int alignmentLayout = layout[1];
		if (iconTextLayout == VERTICAL)
		{
			button.setHorizontalTextPosition(CENTER);
			button.setVerticalTextPosition(BOTTOM);
			
			button.setVerticalAlignment(alignmentLayout);
		}
		else if (iconTextLayout == HORIZONTAL)
		{
			button.setHorizontalTextPosition(TRAILING);
			button.setVerticalTextPosition(CENTER);
			
			button.setHorizontalAlignment(alignmentLayout);
		}
	}
	
	/**
	 * Sets ui by a button ui class, menu button ui class, split button ui class and button style class.
	 * @param buttonUIClass the button ui class string
	 * @param menuButtonUIClass the menu button ui class string
	 * @param splitButtonUIClass the split button ui class string
	 * @param buttonStyleClass the button style class string
	 */
	public static void setUI(String buttonUIClass, String menuButtonUIClass, String splitButtonUIClass, String buttonStyleClass)
	{
		try
		{
			buttonStyle = (IButtonStyle) Class.forName(buttonStyleClass).newInstance();
			
			Constructor buttonUIConstructor = Class.forName(buttonUIClass).getConstructor(new Class[] {IButtonStyle.class});
			buttonUI = (IButtonUI) buttonUIConstructor.newInstance(new Object[] {buttonStyle});
			
			Constructor menuButtonUIConstructor = Class.forName(menuButtonUIClass).getConstructor(new Class[] {IButtonStyle.class});
			menuButtonUI = (IButtonUI) menuButtonUIConstructor.newInstance(new Object[] {buttonStyle});
			
			Constructor splitButtonUIConstructor = Class.forName(splitButtonUIClass).getConstructor(new Class[] {IButtonStyle.class});
			splitButtonUI = (IButtonUI) splitButtonUIConstructor.newInstance(new Object[] {buttonStyle});
			
			buttonBarUI = new ButtonBarUI((AbstractButtonUI) buttonUI);
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the button ui.
	 * @return the instance of IButtonUI
	 */
	public static IButtonUI getButtonUI()
	{
		return buttonUI;
	}
	
	/**
	 * Gets the menu button ui.
	 * @return the instance of IButtonUI
	 */
	public static IButtonUI getMenuButtonUI()
	{
		return menuButtonUI;
	}
	
	/**
	 * Gets the split button ui.
	 * @return the instance of IButtonUI
	 */
	public static IButtonUI getSplitButtonUI()
	{
		return splitButtonUI;
	}
	
	/**
	 * Gets the button style.
	 * @return the instance of IButtonStyle
	 */
	public static IButtonStyle getButtonStyle()
	{
		return buttonStyle;
	}
	
	/**
	 * Gets the button bar ui.
	 * @return the instance of ButtonBarUI
	 */
	public static ButtonBarUI getButtonBarUI()
	{
		return buttonBarUI;
	}
		
	/**
	 * Gets the html text by a text.
	 * If the text is from XML, the parsing relations are as below:
	 * XML ["&#x0A;"] -> HTML ["\n"],
	 * XML ["&amp;nbsp;] -> HTML [&nbsp;].
	 * @param text the text string
	 * @return the html text
	 */
	public static String getHtmlText(String text)
	{
		if (text == null)
		{
			return null;
		}	
		
		String delimiter = "\n";
		
		if (text.indexOf(delimiter) > -1)
		{
			String html = "<html>";
			
			StringTokenizer stringTokenizer = new StringTokenizer(text, delimiter);
			while (stringTokenizer.hasMoreTokens())
			{
				String next = stringTokenizer.nextToken();
				html += "<p align=center>" + next + "</p>";
			}
			
			html += "</html>";

			return html;
		}
		else
		{
			return text;
		}
	}
}