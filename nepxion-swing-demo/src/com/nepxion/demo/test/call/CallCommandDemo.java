package com.nepxion.demo.test.call;

import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JFrame;

public class CallCommandDemo
	extends JFrame
{	
	public CallCommandDemo()
	{
		setSize(300, 200);
	}
	
	protected void processWindowEvent(WindowEvent e)
	{
		super.processWindowEvent(e);
		
		if (e.getID() == WindowEvent.WINDOW_CLOSING)
		{
			Runtime.getRuntime().addShutdownHook(new ShutdownHookThread());
			System.exit(0);
		}
	}
	
	public class ShutdownHookThread
		extends Thread
	{
		public ShutdownHookThread()
		{
		}
		
		public void run()
		{
			String value = windowCommand("cmd /c D:\\Project\\Utility\\Nepxion\\java\\nepxion-swing-demo\\release\\application\\a.bat");
			System.out.println(value);
		}
	}
	
	public static String windowCommand(String command)
	{
		Runtime runtime = Runtime.getRuntime();
		Process process = null;
		String result = "";
		String line = null;
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try
		{
			process = runtime.exec(command);
			
			is = process.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			while ((line = br.readLine()) != null)
			{
				if (!line.equals(""))
				{
					result += line;
				}
			}
		}
		catch (IOException ex)
		{
			
		}
		finally
		{
			try
			{
				if (br != null)
				{
					br.close();
				}
				if (isr != null)
				{
					isr.close();
				}
				if (is != null)
				{
					is.close();
				}
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		new CallCommandDemo().setVisible(true);
	}
}