package com.nepxion.demo.test.scale;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScalePanel
	extends JComponent
{
	private JComponent component;
	private double scaleRatio = 0.8;
	
	public ScalePanel(JComponent component, double scaleRatio)
	{
		this.component = component;
		this.scaleRatio = scaleRatio;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform at = g2d.getTransform();
		g2d.transform(AffineTransform.getScaleInstance(scaleRatio, scaleRatio));
		component.paint(g);
		g2d.setTransform(at);
	}
	
	@Override
	public Dimension getPreferredSize()
	{
		if (component != null)
		{
			return new Dimension((int) scaleRatio * component.getWidth(), (int) (scaleRatio * component.getHeight()));
		}
		else
		{
			return super.getPreferredSize();
		}
	}
	
	public static void main(String[] args)
	{
		JPanel panel = new JPanel();
		panel.add(new JButton("A"));
		panel.add(new JButton("B"));
		panel.add(new JButton("C"));
		
		ScalePanel scalePanel = new ScalePanel(panel, 0.85);
		
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(panel);
		frame.getContentPane().add(scalePanel);
		frame.pack();
		frame.setVisible(true);
	}
}