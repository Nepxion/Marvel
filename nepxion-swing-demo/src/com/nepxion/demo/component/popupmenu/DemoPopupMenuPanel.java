package com.nepxion.demo.component.popupmenu;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.demo.common.DemoComponentFactory;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;
import com.nepxion.swing.popupmenu.PopupMenuPainter;
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
import com.nepxion.swing.style.framework.IStyle;
import com.nepxion.swing.style.framework.JAcidStyle;
import com.nepxion.swing.style.framework.JAlloyStyle;
import com.nepxion.swing.style.framework.JBedouinStyle;
import com.nepxion.swing.style.framework.JBlueStyle;
import com.nepxion.swing.style.framework.JBorlandStyle;
import com.nepxion.swing.style.framework.JEclipseStyle;
import com.nepxion.swing.style.framework.JFervencyStyle;
import com.nepxion.swing.style.framework.JGlassStyle;
import com.nepxion.swing.style.framework.JLiteStyle;
import com.nepxion.swing.style.framework.JNimbusStyle;
import com.nepxion.swing.style.framework.JPlasticStyle;
import com.nepxion.swing.style.framework.JWindowsStyle;
import com.nepxion.swing.style.framework.JYellowStyle;

public class DemoPopupMenuPanel
	extends JBasicScrollPane
{
	public DemoPopupMenuPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		panel.add(new WindowsStylePopupMenuPanel());
		panel.add(new LiteStylePopupMenuPanel());
		panel.add(new AlloyStylePopupMenuPanel());
		panel.add(new EclipseStylePopupMenuPanel());
		panel.add(new BorlandStylePopupMenuPanel());
		panel.add(new NimbusStylePopupMenuPanel());		
		panel.add(new ColorStylePopupMenuPanel());	
		panel.add(new PlasticStylePopupMenuPanel());
		panel.add(new FervencyStylePopupMenuPanel());
		
		getViewport().add(panel);
	}
	
	public class WindowsStylePopupMenuPanel
		extends JPanel
	{
		public WindowsStylePopupMenuPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Windows Style"));

			JBasicButton flatStyleButton = new JBasicButton("JWindows Style", IconFactory.getSwingIcon("component/popup_menu_16.png"), "JWindows Style");
			flatStyleButton.setUI(new FlatButtonUI());
			createPopupMenu(flatStyleButton, "JWindows", new JWindowsStyle());
			add(flatStyleButton);					
		}
	}
	
	public class LiteStylePopupMenuPanel
		extends JPanel
	{
		public LiteStylePopupMenuPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Lite Style"));
			
			JBasicButton alloyStyleButton = new JBasicButton("JLite Style", IconFactory.getSwingIcon("component/popup_menu_16.png"), "JLite Style");
			alloyStyleButton.setUI(new LiteButtonUI(new JAlloyLiteButtonStyle()));
			createPopupMenu(alloyStyleButton, "JLite", new JLiteStyle());
			add(alloyStyleButton);					
		}
	}
	
	public class AlloyStylePopupMenuPanel
		extends JPanel
	{
		public AlloyStylePopupMenuPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Alloy Style"));
			
			JBasicButton alloyStyleButton = new JBasicButton("JAlloy Style", IconFactory.getSwingIcon("component/popup_menu_16.png"), "JAlloy Style");
			alloyStyleButton.setUI(new LiteButtonUI(new JAlloyLiteButtonStyle()));
			createPopupMenu(alloyStyleButton, "JAlloy", new JAlloyStyle());
			add(alloyStyleButton);
			
			JBasicButton acidStyleButton = new JBasicButton("JAcid Style", IconFactory.getSwingIcon("component/popup_menu_16.png"), "JAcid Style");
			acidStyleButton.setUI(new LiteButtonUI(new JAcidLiteButtonStyle()));
			createPopupMenu(acidStyleButton, "JAcid", new JAcidStyle());
			add(acidStyleButton);
			
			JBasicButton bedouinStyleButton = new JBasicButton("JBedouin Style", IconFactory.getSwingIcon("component/popup_menu_16.png"), "JBedouin Style");
			bedouinStyleButton.setUI(new LiteButtonUI(new JBedouinLiteButtonStyle()));
			createPopupMenu(bedouinStyleButton, "JBedouin", new JBedouinStyle());
			add(bedouinStyleButton);
			
			JBasicButton glassStyleButton = new JBasicButton("JGlass Style", IconFactory.getSwingIcon("component/popup_menu_16.png"), "JGlass Style");
			glassStyleButton.setUI(new LiteButtonUI(new JGlassLiteButtonStyle()));
			createPopupMenu(glassStyleButton, "JGlass", new JGlassStyle());
			add(glassStyleButton);
		}
	}	
	
	public class EclipseStylePopupMenuPanel
		extends JPanel
	{
		public EclipseStylePopupMenuPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Eclipse Style"));
			
			JBasicButton eclipseStyleButton = new JBasicButton("JEclipse Style", IconFactory.getSwingIcon("component/popup_menu_16.png"), "JEclipse Style");
			eclipseStyleButton.setUI(new LiteButtonUI(new JEclipseLiteButtonStyle()));
			createPopupMenu(eclipseStyleButton, "JEclipse", new JEclipseStyle());
			add(eclipseStyleButton);			
		}
	}	
	
	public class BorlandStylePopupMenuPanel
		extends JPanel
	{
		public BorlandStylePopupMenuPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Borland Style"));
			
			JBasicButton borlandStyleButton = new JBasicButton("JBorland Style", IconFactory.getSwingIcon("component/popup_menu_16.png"), "JBorland Style");
			borlandStyleButton.setUI(new LiteButtonUI(new JBorlandLiteButtonStyle()));
			createPopupMenu(borlandStyleButton, "JBorland", new JBorlandStyle());
			add(borlandStyleButton);
		}
	}
	
	public class NimbusStylePopupMenuPanel
		extends JPanel
	{
		public NimbusStylePopupMenuPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Nimbus Style"));
			
			JBasicButton nimbusStyleButton = new JBasicButton("JNimbus Style", IconFactory.getSwingIcon("component/popup_menu_16.png"), "JNimbus Style");
			nimbusStyleButton.setUI(new LiteButtonUI(new JNimbusLiteButtonStyle()));
			createPopupMenu(nimbusStyleButton, "JNimbus", new JNimbusStyle());
			add(nimbusStyleButton);
		}
	}	
	
	public class ColorStylePopupMenuPanel
		extends JPanel
	{
		public ColorStylePopupMenuPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Color Style"));
			
			JBasicButton blueStyleButton = new JBasicButton("JBlue Style", IconFactory.getSwingIcon("component/popup_menu_16.png"), "JBlue Style");
			blueStyleButton.setUI(new LiteButtonUI(new JBlueLiteButtonStyle()));
			createPopupMenu(blueStyleButton, "JBlue", new JBlueStyle());
			add(blueStyleButton);
			
			JBasicButton yellowStyleButton = new JBasicButton("JYellow Style", IconFactory.getSwingIcon("component/popup_menu_16.png"), "JYellow Style");
			yellowStyleButton.setUI(new LiteButtonUI(new JYellowLiteButtonStyle()));
			createPopupMenu(yellowStyleButton, "JYellow", new JYellowStyle());
			add(yellowStyleButton);			
		}
	}		
	
	public class PlasticStylePopupMenuPanel
		extends JPanel
	{
		public PlasticStylePopupMenuPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Plastic Style"));
			
			JBasicButton eclipseStyleButton = new JBasicButton("JPlastic Style", IconFactory.getSwingIcon("component/popup_menu_16.png"), "JPlastic Style");
			eclipseStyleButton.setUI(new LiteButtonUI(new JEclipseLiteButtonStyle()));
			createPopupMenu(eclipseStyleButton, "JPlastic", new JPlasticStyle());
			add(eclipseStyleButton);
		}
	}		
	
	public class FervencyStylePopupMenuPanel
		extends JPanel
	{
		public FervencyStylePopupMenuPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Fervency Style"));
			
			JBasicButton blueStyleButton = new JBasicButton("JFervency Style", IconFactory.getSwingIcon("component/popup_menu_16.png"), "JFervency Style");
			blueStyleButton.setUI(new LiteButtonUI(new JEclipseLiteButtonStyle()));
			createPopupMenu(blueStyleButton, "JFervency", new JFervencyStyle());
			add(blueStyleButton);						
		}
	}
	
	public void createPopupMenu(final JBasicButton button, String text, IStyle style)
	{
		final JBasicPopupMenu popupMenu = DemoComponentFactory.createPopupMenu();
		popupMenu.setPainter(new PopupMenuPainter(text, style));
		button.addMouseListener(new MouseAdapter()
		{
			public void mouseReleased(MouseEvent e)
			{
				int x = e.getX();
				int y = e.getY();
				popupMenu.show(button, x, y);
			}
		}
		);
	}	
}