package com.nepxion.demo.test.text;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScrollTextDemo
	extends JComponent
{
	private BufferedImage image;
	private Dimension imageSize;
	private volatile int currOffset;
	
	private Thread internalThread;
	private volatile boolean noStopRequested;
	
	public ScrollTextDemo(String text)
	{
		currOffset = 0;
		buildImage(text);
		
		this.setMinimumSize(imageSize);
		this.setPreferredSize(imageSize);
		this.setMaximumSize(imageSize);
		this.setSize(imageSize);
		
		noStopRequested = true;
		Runnable r = new Runnable()
		{
			public void run()
			{
				try
				{
					runWork();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		};
		
		internalThread = new Thread(r, "ScrollText");
		internalThread.start();
	}
	
	private void buildImage(String text)
	{
		// �������ʱ���򿪷���ݣ������ø�����ѡ��
		RenderingHints renderHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		renderHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		
		// ����һ����ʱͼ�������ж��ļ��Ĵ�С
		BufferedImage scratchImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D scratchG2 = scratchImage.createGraphics();
		scratchG2.setRenderingHints(renderHints);
		
		Font font = new Font("Serif", Font.BOLD | Font.ITALIC, 24);
		
		FontRenderContext frc = scratchG2.getFontRenderContext();
		TextLayout t1 = new TextLayout(text, font, frc);
		Rectangle2D textBounds = t1.getBounds();
		int textWidth = (int) Math.ceil(textBounds.getWidth());
		int textHeight = (int) Math.ceil(textBounds.getHeight());
		int horizontalPad = 10;
		int verticalPad = 6;
		
		imageSize = new Dimension(textWidth + horizontalPad, textHeight + verticalPad);
		
		// �����ʵ���С��ͼ��
		image = new BufferedImage(imageSize.width, imageSize.height, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D g2 = image.createGraphics();
		g2.setRenderingHints(renderHints);
		
		int baselineOffset = (verticalPad / 2) - ((int) textBounds.getY());
		
		g2.setColor(Color.white);
		g2.fillRect(0, 0, imageSize.width, imageSize.height);
		
		g2.setColor(Color.blue);
		t1.draw(g2, 0, baselineOffset);
		
		// �����ͷ���Դ�������ֶ�����ʾͼ��
		scratchG2.dispose();
		scratchImage.flush();
		g2.dispose();
	}
	
	public void paint(Graphics g)
	{
		// ���۵�ǰ��С��ȷ���ü���Ե
		g.setClip(0, 0, imageSize.width, imageSize.height);
		
		int localOffset = currOffset; // �Է��ı�
		g.drawImage(image, -localOffset, 0, this);
		g.drawImage(image, imageSize.width - localOffset, 0, this);
		
		// ��������
		g.setColor(Color.black);
		g.drawRect(0, 0, imageSize.width - 1, imageSize.height - 1);
	}
	
	private void runWork()
	{
		while (noStopRequested)
		{
			try
			{
				Thread.sleep(100); // ÿ��10֡
				
				// ��������λ��
				currOffset = (currOffset + 1) % imageSize.width;
				
				// ֪ͨ�¼��̵߳���paint()
				repaint();
			}
			catch (InterruptedException e)
			{
				Thread.currentThread().interrupt();
			}
		}
	}
	
	public void stopRequest()
	{
		noStopRequested = false;
		internalThread.interrupt();
	}
	
	public boolean isAlive()
	{
		return internalThread.isAlive();
	}
	
	public static void main(String args[])
	{
		ScrollTextDemo st = new ScrollTextDemo("Java   can   do   animation!");
		JPanel p = new JPanel(new FlowLayout());
		p.add(st);
		
		JFrame f = new JFrame("ScrollText   Demo");
		f.setContentPane(p);
		f.setSize(400, 100);
		f.setVisible(true);
	}
}