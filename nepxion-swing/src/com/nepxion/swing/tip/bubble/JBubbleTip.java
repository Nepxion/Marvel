package com.nepxion.swing.tip.bubble;

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
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.button.JStyleButton;
import com.nepxion.swing.fullscreen.FullScreenManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.panel.decoration.JDecorationPanel;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.textarea.JBasicTextArea;

public abstract class JBubbleTip
{
	public Color background = new Color(255, 255, 225); // 气泡背景色
	private int width = 300; // 气泡提示宽度
	private int height = 140; // 气泡提示高度
	
	private int step = 30; // 循环的步长
	private int stepTime = 30; // 每步时间
	private int displayTime = 10000; // 显示时间
	
	private int count = 0; // 目前申请的气泡提示数量
	private int maxCount = 0; // 当前最大气泡提示数量
	private int maxCountInSceen; // 在屏幕上显示的最大气泡提示数量
	
	public JBubbleTip()
	{
		
	}
	
	public void show(String title, Icon icon, String message)
	{
		show(title, icon, message, null);
	}
	
	public void show(String title, Icon icon, String message, Object data)
	{
		BubbleTipWindow bubbleTipWindow = new BubbleTipWindow(data);
		if (title != null)
		{
			bubbleTipWindow.setTitle(title);
		}
		if (icon != null)
		{
			bubbleTipWindow.setIcon(icon);
		}
		bubbleTipWindow.setMessage(message);
		
		BubbleTipAnimation bubbleTipAnimation = new BubbleTipAnimation(bubbleTipWindow);
		bubbleTipAnimation.start();
	}
	
	public void close(BubbleTipWindow bubbleTipWindow)
	{
		count--;
		bubbleTipWindow.setVisible(false);
		bubbleTipWindow.dispose();
	}
	
	public Color getBackground()
	{
		return background;
	}
	
	public void setBackground(Color background)
	{
		this.background = background;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	public int getStep()
	{
		return step;
	}
	
	public void setStep(int step)
	{
		this.step = step;
	}
	
	public int getStepTime()
	{
		return stepTime;
	}
	
	public void setStepTime(int stepTime)
	{
		this.stepTime = stepTime;
	}
	
	public int getDisplayTime()
	{
		return displayTime;
	}
	
	public void setDisplayTime(int displayTime)
	{
		this.displayTime = displayTime;
	}
	
	public abstract void viewDetail(Object data);
	
	public class BubbleTipWindow
		extends JWindow
	{
		private JDecorationPanel decorationPanel;
		private JBasicTextArea messageTextArea;
		
		public BubbleTipWindow(final Object data)
		{
			JPanel iconPanel = new JPanel();
			iconPanel.setLayout(new BorderLayout());
			iconPanel.setBackground(background);
			iconPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
			iconPanel.add(new JLabel(IconFactory.getSwingIcon("tip.png")), BorderLayout.NORTH);
			
			messageTextArea = new JBasicTextArea();
			messageTextArea.setBackground(background);
			messageTextArea.setOpaque(true);
			messageTextArea.setEditable(false);
			messageTextArea.setLineWrap(true);
			messageTextArea.setWrapStyleWord(true);
			messageTextArea.setFocusable(false);
			messageTextArea.setMargin(new Insets(4, 4, 4, 4));
			
			JBasicScrollPane messageScrollPane = new JBasicScrollPane(messageTextArea);
			messageScrollPane.setBorder(null);
			
			JStyleButton viewDetailButton = new JStyleButton(SwingLocale.getString("view_detail"));
			viewDetailButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					viewDetail(data);
				}
			}
			);
			viewDetailButton.setButtonStyle(JStyleButton.HYPERLINK_STYLE);
			
			double[][] size = 
			{ 
				{50, TableLayout.FILL, TableLayout.PREFERRED}, 
				{TableLayout.FILL, 30}
			};
			
			JPanel panel = new JPanel();
			panel.setLayout(new TableLayout(size));
			panel.setBackground(background);
			panel.add(iconPanel, "0, 0");
			panel.add(messageScrollPane, "1, 0, 2, 0");
			panel.add(viewDetailButton, "2, 1");
			
			JBasicButton closeButton = FullScreenManager.createCloseButton(false);
			closeButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					close(BubbleTipWindow.this);
				}
			}
			);
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
			buttonPanel.setOpaque(false);
			buttonPanel.add(closeButton);
			
			ButtonManager.updateUI(buttonPanel, new Dimension(20, 20), true);
			
			decorationPanel = new JDecorationPanel(SwingLocale.getString("message"), IconFactory.getSwingIcon("view.png"), SwingLocale.getString("message"), true);
			decorationPanel.getHeader().add(buttonPanel, BorderLayout.EAST);
			decorationPanel.setContentPane(panel);
			
			getContentPane().add(decorationPanel);
			
			// NativeSkin.getInstance().setAlwaysOnTop(this, true);
			setAlwaysOnTop(true);
			setSize(width, height);
		}
		
		public void setTitle(String title)
		{
			decorationPanel.setTitle(title);
		}
		
		public void setIcon(Icon icon)
		{
			decorationPanel.setIcon(icon);
		}
		
		public void setMessage(String message)
		{
			messageTextArea.setText(message);
		}
	}
	
	public class BubbleTipAnimation
		extends Thread
	{
		private BubbleTipWindow bubbleTipWindow;
		
		public BubbleTipAnimation(BubbleTipWindow tipWindow)
		{
			this.bubbleTipWindow = tipWindow;
		}
		
		private void animate(int x, int startY, int endY)
			throws InterruptedException
		{
			bubbleTipWindow.setLocation(x, startY);
			if (endY < startY)
			{
				for (int i = startY; i > endY; i -= step)
				{
					bubbleTipWindow.setLocation(x, i);
					Thread.sleep(stepTime);
				}
			}
			else
			{
				for (int i = startY; i < endY; i += step)
				{
					bubbleTipWindow.setLocation(x, i);
					Thread.sleep(stepTime);
				}
			}
			bubbleTipWindow.setLocation(x, endY);
		}
		
		public void run()
		{
			try
			{
				GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
				Rectangle screenRect = ge.getMaximumWindowBounds();
				int screenHeight = (int) screenRect.height;
				
				boolean isAnimated = true;
				if (screenRect.y > 0)
				{
					isAnimated = false;
				}
				
				maxCountInSceen = screenHeight / height;
				
				int x = (int) screenRect.width - width - 1;
				bubbleTipWindow.setLocation(x, screenHeight);
				bubbleTipWindow.setVisible(true);
				
				int startY;
				int stopY;
				if (isAnimated)
				{
					startY = screenHeight;
					stopY = startY - height - 1;
					if (count > 0)
					{
						stopY = stopY - (maxCount % maxCountInSceen * height);
					}
					else
					{
						maxCount = 0;
					}
				}
				else
				{
					startY = screenRect.y - height;
					stopY = screenRect.y;
					
					if (count > 0)
					{
						stopY = stopY + (maxCount % maxCountInSceen * height);
					}
					else
					{
						maxCount = 0;
					}
				}
				
				count++;
				maxCount++;
				
				animate(x, startY, stopY);
				Thread.sleep(displayTime);
				if (bubbleTipWindow.isVisible())
				{
					animate(x, stopY, startY);
					
					close(bubbleTipWindow);
				}
			}
			catch (Exception e)
			{
				throw new RuntimeException(e);
			}
		}
	}
}