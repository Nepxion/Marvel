package com.nepxion.demo.test.timeout;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class TimeoutDemo
{
	public static void main(String[] args)
	{
		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener()
		{
			public void eventDispatched(AWTEvent event)
			{
				String eventText = event.toString();
				if (eventText.indexOf("PRESSED") != -1 || eventText.indexOf("RELEASED") != -1)
				{
					System.out.println(System.currentTimeMillis() + " =========== ");
				}
			}
		}, AWTEvent.MOUSE_EVENT_MASK + AWTEvent.KEY_EVENT_MASK);
		
		final JFrame frame = new JFrame();
		
		JButton button = new JButton("Test");
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JDialog dialog = new JDialog(frame);
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		}
		);
		
		frame.getContentPane().add(button);
		frame.pack();
		frame.setVisible(true);
	}
}