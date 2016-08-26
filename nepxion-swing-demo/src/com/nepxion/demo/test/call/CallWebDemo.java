package com.nepxion.demo.test.call;

import com.nepxion.swing.activex.ActiveXManager;

public class CallWebDemo
{
	public static void main(String[] args)
	{
		try
		{
			ActiveXManager.callWeb(null, "www.163.com");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}