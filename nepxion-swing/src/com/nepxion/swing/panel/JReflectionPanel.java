package com.nepxion.swing.panel;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

import org.jdesktop.swingx.RepaintManagerX;
import org.jdesktop.swingx.image.FastBlurFilter;

import com.nepxion.swing.container.ContainerManager;
import com.nepxion.swing.graphics.GraphicsUtilities;

public class JReflectionPanel
	extends JPanel
{
	private ReflectionRepaintManager manager;
	private FastBlurFilter blurFilter;
	
	private JPanel contentPane;
	private Component content;
	
	private BufferedImage contentBuffer;
	private BufferedImage reflectionBuffer;
	
	private Graphics2D contentGraphics;
	private Graphics2D reflectionGraphics;
	
	private GradientPaint alphaMask;
	
	private int maxReflectHeight = 50;
	private float opacity = 0.5f;
	
	private boolean initialized = false;
	
	public JReflectionPanel()
	{
		super(new BorderLayout());
		
		setOpaque(false);
		
		blurFilter = new FastBlurFilter(1);
		
		buildContentPane();
		buildFiller();
		
		installRepaintManager();
		
		initialized = true;
	}
	
	public void installRepaintManager()
	{
		if (manager == null)
		{
			manager = new ReflectionRepaintManager(RepaintManager.currentManager(this));
		}
		
		RepaintManager.setCurrentManager(manager);
	}
	
	private void buildContentPane()
	{
		contentPane = new JPanel(new BorderLayout());
		contentPane.setOpaque(false);
		
		add(contentPane, BorderLayout.CENTER);
	}
	
	private void buildFiller()
	{
		add(Box.createRigidArea(new Dimension(maxReflectHeight, maxReflectHeight)), BorderLayout.SOUTH);
	}
	
	public void paint(Graphics g)
	{
		paintContent(g);
		paintReflection(g);
	}
	
	private void paintReflection(Graphics g)
	{
		if (contentPane.getWidth() <=0 || contentPane.getHeight() <= 0)
		{
			return;
		}	
		
		int width = contentPane.getWidth();
		int height = contentPane.getHeight() > maxReflectHeight ? maxReflectHeight : contentPane.getHeight();
		
		createReflection(g, width, height);
		
		Graphics2D g2 = (Graphics2D) g.create();
		g2.scale(1.0, -1.0);
		g2.drawImage(reflectionBuffer, 0, -contentPane.getHeight() - height - 5, null);
		g2.dispose();
	}
	
	private void createReflection(Graphics g, int width, int height)
	{
		if (contentPane.getWidth() <=0 || contentPane.getHeight() <= 0)
		{
			return;
		}	
		
		if (reflectionBuffer == null || reflectionBuffer.getWidth() != width || reflectionBuffer.getHeight() != height)
		{
			if (reflectionBuffer != null)
			{
				reflectionBuffer.flush();
				reflectionGraphics.dispose();
			}
			
			reflectionBuffer = GraphicsUtilities.createCompatibleImage(contentBuffer, width, height);
			reflectionGraphics = reflectionBuffer.createGraphics();
			
			alphaMask = new GradientPaint(0.0f, 0.0f, new Color(0.0f, 0.0f, 0.0f, 0.0f), 0.0f, height, new Color(0.0f, 0.0f, 0.0f, opacity), true);
		}
		
		int yOffset = contentPane.getHeight() - height;
		Rectangle clip = g.getClipBounds();
		
		Graphics2D g2 = reflectionGraphics;
		g2.setClip(clip.x, clip.y - yOffset, clip.width, clip.height);
		
		g2.setComposite(AlphaComposite.Clear);
		g2.fillRect(clip.x, clip.y - yOffset, clip.width, clip.height);
		g2.setComposite(AlphaComposite.SrcOver);
		
		g2.translate(0, -yOffset);
		// BufferedImage blurBuffer = blurFilter.filter(contentBuffer, null);
		g2.drawImage(contentBuffer, 0, 0, null);
		g2.translate(0, yOffset);
		
		g2.setComposite(AlphaComposite.DstIn);
		g2.setPaint(alphaMask);
		g2.fillRect(clip.x, clip.y - yOffset, clip.width, clip.height);
	}
	
	private void paintContent(Graphics g)
	{
		if (contentPane.getWidth() <=0 || contentPane.getHeight() <= 0)
		{
			return;
		}	
		
		if (contentBuffer == null || contentBuffer.getWidth() != contentPane.getWidth() || contentBuffer.getHeight() != contentPane.getHeight())
		{
			if (contentBuffer != null)
			{
				contentBuffer.flush();
				contentGraphics.dispose();
			}
			
			contentBuffer = GraphicsUtilities.createCompatibleTranslucentImage(contentPane.getWidth(), contentPane.getHeight());
			contentGraphics = contentBuffer.createGraphics();
		}
		
		Graphics2D g2 = contentGraphics;
		g2.clipRect(contentPane.getX(), contentPane.getY(), contentPane.getWidth(), contentPane.getHeight());
		
		g2.setComposite(AlphaComposite.Clear);
		Rectangle clip = g.getClipBounds();
		g2.fillRect(clip.x, clip.y, clip.width, clip.height);
		g2.setComposite(AlphaComposite.SrcOver);
		
		g2.setColor(g.getColor());
		g2.setFont(g.getFont());
		super.paint(g2);
		
		g.drawImage(contentBuffer, 0, 0, null);
	}
	
	private class ReflectionRepaintManager
		extends RepaintManagerX
	{
		public ReflectionRepaintManager(RepaintManager repaintManager)
		{
			super(repaintManager);
		}
		
		public void addDirtyRegion(JComponent c, int x, int y, int w, int h)
		{
			Rectangle dirtyRegion = getDirtyRegion(c);
			
			int lastDeltaX = c.getX();
			int lastDeltaY = c.getY();
			
			Container parent = c.getParent();
			while (parent instanceof JComponent)
			{
				if (!parent.isVisible())
				{
					return;
				}
				
				if (parent instanceof JReflectionPanel)
				{
					x += lastDeltaX;
					y += lastDeltaY;
					
					int gap = contentPane.getHeight() - h - y;
					h += 2 * gap + h;
					
					lastDeltaX = lastDeltaY = 0;
					
					c = (JComponent) parent;
				}
				
				lastDeltaX += parent.getX();
				lastDeltaY += parent.getY();
				
				parent = parent.getParent();
			}
			
			super.addDirtyRegion(c, x, y, w, h);
		}
	}
	
	public void setContent(Component content)
	{
		if (this.content == content)
		{
			return;
		}	
		
		if (this.content != null)
		{
			contentPane.remove(this.content);
		}	
		
		this.content = content;
		contentPane.add(content, BorderLayout.CENTER);
		
		ContainerManager.update(contentPane);
	}
	
	public Component getContent()
	{
		return content;
	}
	
	public Dimension getPreferredSize()
	{
		Dimension size = contentPane.getPreferredSize();
		size.height += size.height > maxReflectHeight ? maxReflectHeight : size.height;
		
		return size;
	}
	
	public void remove(int index)
	{
		contentPane.remove(index);
	}
	
	public void remove(Component comp)
	{
		contentPane.remove(comp);
	}
	
	public void removeAll()
	{
		contentPane.removeAll();
	}
	
	public void setLayout(LayoutManager layout)
	{
		if (initialized)
		{
			contentPane.setLayout(layout);
		}
		else
		{
			super.setLayout(layout);
		}
	}
}