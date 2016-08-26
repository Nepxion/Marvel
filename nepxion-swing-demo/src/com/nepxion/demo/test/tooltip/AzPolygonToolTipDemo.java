package com.nepxion.demo.test.tooltip;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AzPolygonToolTipDemo
	extends JFrame
{
	public AzPolygonToolTipDemo()
	{
		init();
	}
	
	public void init()
	{
		HalfOpaqueToolTip tooltip = new HalfOpaqueToolTip("让我再吻一吻你的脸！", new Color(250, 250, 200), Color.RED, new Color(95, 145, 145), this);
		JButton button = new JButton("swing");
		button.addMouseListener(tooltip);
		button.setToolTipText("xxxxxx");
		
		this.setLayout(new FlowLayout());
		this.add(new JButton("金"));
		this.add(new JButton("木"));
		this.add(new JButton("水"));
		this.add(new JButton("火"));
		this.add(new JButton("土"));
		this.add(new JButton("风"));
		this.add(new JButton("雨"));
		this.add(new JButton("雷"));
		this.add(new JButton("电"));
		this.add(new JButton("天"));
		this.add(new JButton("地"));
		this.add(new JButton("乾"));
		this.add(new JButton("坤"));
		this.add(button);
		
		this.setSize(380, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void main(String args[])
	{
		new AzPolygonToolTipDemo();
	}
	
	class HalfOpaqueToolTip
		extends JPanel
		implements MouseListener
	{
		private Color backGroundCol = null;
		
		private Color foregroundColorCol = null;
		
		private Color borderCol = null;
		
		private String content = null;
		
		private JFrame frame = null;
		
		private int LEFT = 1;
		
		private int RIGHT = 2;
		
		private int direction = 2;
		
		public HalfOpaqueToolTip(String tooltipContent, Color backGroundColor, Color foregroundColor, Color borderColor, JFrame frame)
		{
			content = tooltipContent;
			backGroundCol = backGroundColor;
			foregroundColorCol = foregroundColor;
			borderCol = borderColor;
			/*
			 * 调整tooltip的大小
			 */
			int fristRowIndex = tooltipContent.indexOf("\n");
			String tooltipStr = "";
			if (fristRowIndex > 0)
			{
				tooltipStr = tooltipContent.substring(0, tooltipContent.indexOf("\n"));
			}
			else
			{
				tooltipStr = tooltipContent;
			}
			
			this.setSize(tooltipStr.length() * this.getFont().getSize() + 20, new StringTokenizer(tooltipContent, "\n").countTokens() * 20 + 20);// 左右各留10的空白空间
			this.setOpaque(false);
			this.setVisible(false);
			// 将本控件置于界面的最顶层
			frame.getLayeredPane().add(this, JLayeredPane.POPUP_LAYER);
			this.frame = frame;
		}
		
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setColor(backGroundCol);
			AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 70 / 100.0F);
			g2d.setComposite(composite);
			g2d.fill(getArea());
			g2d.setColor(foregroundColorCol);
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
			/*
			 * 画上字符内容
			 */
			StringTokenizer contentTokenizer = new StringTokenizer(content, "\n");
			int contentStartY = 20;
			while (contentTokenizer.hasMoreElements())
			{
				g2d.drawString(contentTokenizer.nextToken(), 10, contentStartY);
				contentStartY = contentStartY + 20;
			}
			
		}
		
		protected void paintBorder(Graphics g)
		{
			super.paintBorder(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setColor(borderCol);
			g2d.draw(getArea());
		}
		
		private Area getArea()
		{
			if (direction == LEFT)
			{
				return getLeftArea();
			}
			else
			{
				return getRightArea();
			}
		}
		
		private Area getLeftArea()
		{
			Area area = new Area(new RoundRectangle2D.Float(0, 0, this.getWidth() - 1, this.getHeight() - 10, 10, 10));
			Polygon polygon = new Polygon();
			polygon.addPoint(this.getWidth() - 25, this.getHeight() - 10);
			polygon.addPoint(this.getWidth() - 10, this.getHeight() - 10);
			polygon.addPoint(this.getWidth(), this.getHeight());
			area.add(new Area(polygon));
			
			return area;
		}
		
		private Area getRightArea()
		{
			Area area = new Area(new RoundRectangle2D.Float(0, 0, this.getWidth() - 1, this.getHeight() - 10, 10, 10));
			Polygon polygon = new Polygon();
			polygon.addPoint(25, this.getHeight() - 10);
			polygon.addPoint(10, this.getHeight() - 10);
			polygon.addPoint(0, this.getHeight());
			area.add(new Area(polygon));
			
			return area;
		}
		
		public void mouseEntered(MouseEvent e)
		{
			Point p = e.getComponent().getLocationOnScreen();
			SwingUtilities.convertPointFromScreen(p, e.getComponent().getParent());
			if (p.x + this.getWidth() > frame.getX())
			{
				direction = LEFT;
				this.setLocation(new Point(p.x - this.getWidth() + 10, p.y - this.getHeight() + 10));
			}
			else
			{
				direction = RIGHT;
				this.setLocation(new Point(p.x + e.getComponent().getWidth(), p.y - this.getHeight() + 10));
			}
			this.setVisible(true);
		}
		
		public void mouseExited(MouseEvent e)
		{
			this.setVisible(false);
		}
		
		public void mouseClicked(MouseEvent e)
		{
			
		}
		
		public void mousePressed(MouseEvent e)
		{
			
		}
		
		public void mouseReleased(MouseEvent e)
		{
			
		}
		
	}
}