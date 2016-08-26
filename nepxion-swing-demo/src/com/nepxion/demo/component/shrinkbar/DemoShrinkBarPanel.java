package com.nepxion.demo.component.shrinkbar;

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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.list.JBasicList;
import com.nepxion.swing.shrinkbar.JShrinkBar;
import com.nepxion.swing.shrinkbar.JShrinkOutlook;
import com.nepxion.swing.shrinkbar.JShrinkOutlookBar;
import com.nepxion.swing.shrinkbar.JShrinkShortcut;
import com.nepxion.swing.shrinkbar.JShrinkShortcutBar;
import com.nepxion.swing.shrinkbar.ShrinkListCellRenderer;
import com.nepxion.swing.style.button.lite.JYellowLiteButtonStyle;
import com.nepxion.swing.style.button.lite.LiteButtonUI;
import com.nepxion.swing.style.texture.shrink.IHeaderTextureStyle;
import com.nepxion.swing.style.texture.shrink.IOutlookTextureStyle;
import com.nepxion.swing.style.texture.shrink.JBlackHeaderTextureStyle;
import com.nepxion.swing.style.texture.shrink.JBlackOutlookTextureStyle;
import com.nepxion.swing.style.texture.shrink.JBlueHeaderTextureStyle;
import com.nepxion.swing.style.texture.shrink.JBlueOutlookTextureStyle;
import com.nepxion.swing.style.texture.shrink.JGrayHeaderTextureStyle;
import com.nepxion.swing.style.texture.shrink.JGrayOutlookTextureStyle;
import com.nepxion.swing.style.texture.shrink.JGreenHeaderTextureStyle;
import com.nepxion.swing.style.texture.shrink.JGreenOutlookTextureStyle;
import com.nepxion.swing.style.texture.shrink.JYellowHeaderTextureStyle;
import com.nepxion.swing.style.texture.shrink.JYellowOutlookTextureStyle;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;
import com.nepxion.swing.toolbar.JBasicToolBar;
import com.nepxion.util.data.CollectionUtil;

public class DemoShrinkBarPanel
	extends JPanel
{
	public DemoShrinkBarPanel()
	{
		JEclipseTabbedPane tabbedPane = new JEclipseTabbedPane();
		tabbedPane.setTabPlacement(JEclipseTabbedPane.BOTTOM);
		
		tabbedPane.addTab("Mix", IconFactory.getSwingIcon("component/color_16.png"), new TaskBarPanel("Mix Texture Style", new JBlackHeaderTextureStyle(), new JGreenOutlookTextureStyle()), "Mix Texture Style");
		tabbedPane.addTab("Black", IconFactory.getSwingIcon("component/color_16.png"), new TaskBarPanel("Black Texture Style", new JBlackHeaderTextureStyle(), new JBlackOutlookTextureStyle()), "Black Texture Style");
		tabbedPane.addTab("Gray", IconFactory.getSwingIcon("component/color_16.png"), new TaskBarPanel("Gray Texture Style", new JGrayHeaderTextureStyle(), new JGrayOutlookTextureStyle()), "Gray Texture Style");
		tabbedPane.addTab("Green", IconFactory.getSwingIcon("component/color_16.png"), new TaskBarPanel("Green Texture Style", new JGreenHeaderTextureStyle(), new JGreenOutlookTextureStyle()), "Green Texture Style");
		tabbedPane.addTab("Blue", IconFactory.getSwingIcon("component/color_16.png"), new TaskBarPanel("Blue Texture Style", new JBlueHeaderTextureStyle(), new JBlueOutlookTextureStyle()), "Blue Texture Style");
		tabbedPane.addTab("Yellow", IconFactory.getSwingIcon("component/color_16.png"), new TaskBarPanel("Yellow Texture Style", new JYellowHeaderTextureStyle(), new JYellowOutlookTextureStyle()), "Yellow Texture Style");
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(tabbedPane);
	}
	
	public class TaskBarPanel
		extends JPanel
	{
		public TaskBarPanel(String title, IHeaderTextureStyle headerTextureStyle, IOutlookTextureStyle outlookTextureStyle)
		{
			setLayout(new BorderLayout(5, 5));
			setBorder(BorderManager.createComplexTitledBorder(title));
			
			// Initializes shrink outlook bar
			final JShrinkOutlookBar shrinkOutlookBar = new JShrinkOutlookBar(JShrinkBar.PLACEMENT_WEST, JShrinkBar.CONTENT_PANE_TYPE_TOOLBAR, headerTextureStyle, outlookTextureStyle);
			JBasicToolBar toolBar = shrinkOutlookBar.getShrinkHeader().getToolBar();
			toolBar.add(new JButton("test"));
			toolBar.add(new JButton("test"));
			toolBar.add(new JButton("test"));
			shrinkOutlookBar.setPreferredSize(new Dimension(200, shrinkOutlookBar.getPreferredSize().height));
			
			JShrinkOutlook shrinkOutlook = createShrinkOutlook(shrinkOutlookBar);
			shrinkOutlook.setSelected(true);
			
			createShrinkOutlook(shrinkOutlookBar);
			createShrinkOutlook(shrinkOutlookBar);
			createShrinkOutlook(shrinkOutlookBar);
			
			// Initializes shrink shortcut bar
			final JShrinkShortcutBar shrinkShortcutBar = new JShrinkShortcutBar(JShrinkBar.PLACEMENT_EAST, JShrinkBar.CONTENT_PANE_TYPE_LABEL, headerTextureStyle);
			shrinkShortcutBar.setTitle("Shortcut Bar");
			shrinkShortcutBar.setToolTipText("Shortcut Bar");
			shrinkShortcutBar.setIcon(IconFactory.getSwingIcon("hierarchy.png"));
			shrinkShortcutBar.setTitleFont(new Font("Calibri", Font.BOLD, 14));
			shrinkShortcutBar.setPreferredSize(new Dimension(200, shrinkShortcutBar.getPreferredSize().height));
			
			JShrinkShortcut shrinkShortcut1 = shrinkShortcutBar.addShrinkShortcut("Operation", IconFactory.getSwingIcon("stereo/paste_16.png"), "Operation", createButtonList());
			shrinkShortcut1.setTitleFont(new Font("Calibri", Font.BOLD, 12));
			shrinkShortcut1.setTitleColor(Color.white);
			
			JShrinkShortcut shrinkShortcut2 = shrinkShortcutBar.addShrinkShortcut("Operation", IconFactory.getSwingIcon("stereo/paste_16.png"), "Operation", createButtonList());
			shrinkShortcut2.setTitleFont(new Font("Calibri", Font.BOLD, 12));
			shrinkShortcut2.setTitleColor(Color.white);
			
			// shrinkShortcutBar.setShrinked(true);
			
			// Initializes shrink content bar
			JShrinkBar shrinkContentBar = new JShrinkBar(JShrinkBar.PLACEMENT_EAST, JShrinkBar.CONTENT_PANE_TYPE_LABEL, headerTextureStyle);
			shrinkContentBar.setShrinkable(false);
			shrinkContentBar.setContentPane(new JScrollPane(new JTree()));
			shrinkContentBar.setTitle("Content Bar (Double-clicked to shrink sides)");
			shrinkContentBar.setToolTipText("Content Bar");
			shrinkContentBar.setIcon(IconFactory.getSwingIcon("hierarchy.png"));
			shrinkContentBar.setTitleFont(new Font("Calibri", Font.BOLD, 14));
			shrinkContentBar.getShrinkHeader().getLabel().addMouseListener(new MouseAdapter()
			{
				public void mouseClicked(MouseEvent e)
				{
					if (e.getClickCount() > 1)
					{
						boolean isOutlookBarShrinked = shrinkOutlookBar.isShrinked();
						boolean isShortcutBarShrinked = shrinkShortcutBar.isShrinked();
						boolean isShrinked = !(isOutlookBarShrinked && isShortcutBarShrinked);
						
						shrinkOutlookBar.setShrinked(isShrinked);
						shrinkShortcutBar.setShrinked(isShrinked);
					}	
				}
			}
			);
			
			add(shrinkShortcutBar, BorderLayout.EAST);
			add(shrinkContentBar, BorderLayout.CENTER);
			add(shrinkOutlookBar, BorderLayout.WEST);
		}
		
		private JShrinkOutlook createShrinkOutlook(JShrinkOutlookBar shrinkOutlookBar)
		{
			JBasicList list = createList();
			
			JShrinkOutlook outlook = shrinkOutlookBar.addShrinkOutlook("Favorite", IconFactory.getSwingIcon("stereo/favorite_16.png"), IconFactory.getSwingIcon("stereo/favorite_add_16.png"), "Favorite", new Font("Calibri", Font.BOLD, 13));
			outlook.setContentPane(list);
			
			return outlook;
		}
		
		private JBasicList createList()
		{
			List elementNodes = new ArrayList();
			elementNodes.add(new ElementNode("Home", IconFactory.getSwingIcon("stereo/home_16.png"), "Home"));
			elementNodes.add(new ElementNode("Mail", IconFactory.getSwingIcon("stereo/mail_16.png"), "Mail"));
			elementNodes.add(new ElementNode("Music", IconFactory.getSwingIcon("stereo/music_16.png"), "Music"));
			elementNodes.add(new ElementNode("Movie", IconFactory.getSwingIcon("stereo/movie_16.png"), "Movie"));
			elementNodes.add(new ElementNode("Shopping", IconFactory.getSwingIcon("stereo/shopping_cart_16.png"), "Shopping"));
			elementNodes.add(new ElementNode("Camera", IconFactory.getSwingIcon("stereo/camera_16.png"), "Camera"));
			elementNodes.add(new ElementNode("Chat", IconFactory.getSwingIcon("stereo/chat_16.png"), "Chat"));
			elementNodes.add(new ElementNode("Finance", IconFactory.getSwingIcon("stereo/finance_16.png"), "Finance"));
			
			JBasicList list = new JBasicList(CollectionUtil.parseVector(elementNodes));
			list.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
			list.setCellRenderer(new ShrinkListCellRenderer(list, BorderFactory.createEmptyBorder(0, 10, 0, 0), 22));
			
			return list;
		}
		
		private List createButtonList()
		{
			List elementNodes = new ArrayList();
			elementNodes.add(new ElementNode("Add an item", IconFactory.getSwingIcon("stereo/add_16.png"), "Add an item"));
			elementNodes.add(new ElementNode("Deleted an item", IconFactory.getSwingIcon("stereo/delete_16.png"), "Deleted an item"));
			elementNodes.add(new ElementNode("Refresh item list", IconFactory.getSwingIcon("stereo/refresh_16.png"), "Refresh item list"));
			elementNodes.add(new ElementNode("Search item in the list", IconFactory.getSwingIcon("stereo/search_16.png"), "Search item in the list"));
			elementNodes.add(new ElementNode("Configuration", IconFactory.getSwingIcon("stereo/application_16.png"), "Configuration"));
			elementNodes.add(new ElementNode("Online support", IconFactory.getSwingIcon("stereo/web_16.png"), "Online support"));
			elementNodes.add(new ElementNode("Print", IconFactory.getSwingIcon("stereo/print_16.png"), "Print"));
			
			List buttonList = new ArrayList();
			
			for (int i = 0; i < elementNodes.size(); i++)
			{
				ElementNode elementNode = (ElementNode) elementNodes.get(i);
				final JBasicButton button = new JBasicButton(elementNode.getText(), elementNode.getIcon(), elementNode.getToolTipText());
				button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						JOptionPane.showMessageDialog(null, button.getToolTipText());
					}					
				}
				);

				LiteButtonUI liteButtonUI = new LiteButtonUI(new JYellowLiteButtonStyle());
				liteButtonUI.setWidthOffset(20);
				button.setUI(liteButtonUI);
				
				buttonList.add(button);
			}
			
			return buttonList;
		}
	}
}