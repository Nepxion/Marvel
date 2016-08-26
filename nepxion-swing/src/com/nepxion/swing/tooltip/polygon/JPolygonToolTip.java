package com.nepxion.swing.tooltip.polygon;

import java.awt.AlphaComposite;
import java.awt.Color;
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

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class JPolygonToolTip
	extends JPanel implements MouseListener, SwingConstants
{
	private JFrame frame = null;
	private Color background = null;
	private Color foreground = null;
	private Color borderColor = null;
	
	private String content = null;
	
	private int direction = RIGHT;
	
	public JPolygonToolTip(JFrame frame, Color backGround, Color foreground, Color borderColor, String content)
	{
		this.frame = frame;
		this.background = backGround;
		this.foreground = foreground;
		this.borderColor = borderColor;
		this.content = content;
		
		int firstRowIndex = content.indexOf("\n");
		String tooltip = "";
		if (firstRowIndex > 0)
		{
			tooltip = content.substring(0, content.indexOf("\n"));
		}
		else
		{
			tooltip = content;
		}
		
		setSize(tooltip.length() * getFont().getSize() + 20, new StringTokenizer(content, "\n").countTokens() * 20 + 20);
		setOpaque(false);
		setVisible(false);
		
		frame.getLayeredPane().add(this, JLayeredPane.POPUP_LAYER);
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(background);
		
		AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 70 / 100.0F);
		g2d.setComposite(composite);
		
		Area area = getArea();
		g2d.fill(area);
		g2d.setColor(foreground);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		
		StringTokenizer contentTokenizer = new StringTokenizer(content, "\n");
		int index = 20;
		while (contentTokenizer.hasMoreElements())
		{
			g2d.drawString(contentTokenizer.nextToken(), 10, index);
			index = index + 20;
		}
	}
	
	protected void paintBorder(Graphics g)
	{
		super.paintBorder(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(borderColor);
		
		Area area = getArea();
		g2d.draw(area);
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
		int width = getWidth();
		int height = getHeight();
		
		Area area = new Area(new RoundRectangle2D.Float(0, 0, width - 1, height - 10, 10, 10));
		Polygon polygon = new Polygon();
		polygon.addPoint(width - 25, height - 10);
		polygon.addPoint(width - 10, height - 10);
		polygon.addPoint(width, height);
		area.add(new Area(polygon));
		
		return area;
	}
	
	private Area getRightArea()
	{
		int width = getWidth();
		int height = getHeight();
		
		Area area = new Area(new RoundRectangle2D.Float(0, 0, width - 1, height - 10, 10, 10));
		Polygon polygon = new Polygon();
		polygon.addPoint(25, height - 10);
		polygon.addPoint(10, height - 10);
		polygon.addPoint(0, height);
		area.add(new Area(polygon));
		
		return area;
	}
	
	public void mouseEntered(MouseEvent e)
	{
		int width = getWidth();
		int height = getHeight();
		
		Point p = e.getComponent().getLocationOnScreen();
		SwingUtilities.convertPointFromScreen(p, e.getComponent().getParent());
		if (p.x + width > frame.getX())
		{
			direction = LEFT;
			setLocation(new Point(p.x - width + 10, p.y - height + 10));
		}
		else
		{
			direction = RIGHT;
			setLocation(new Point(p.x + e.getComponent().getWidth(), p.y - height + 10));
		}
		
		setVisible(true);
	}
	
	public void mouseExited(MouseEvent e)
	{
		setVisible(false);
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