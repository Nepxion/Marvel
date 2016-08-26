package com.nepxion.demo.test.list;

import java.util.ArrayList;
import java.util.List;

public class SubListDemo
{
	public static void main(String[] args)
	{
		List vEntityList = new ArrayList();
		vEntityList.add("1");
		vEntityList.add("2");
		vEntityList.add("3");
		vEntityList.add("4");
		vEntityList.add("5");
		vEntityList.add("6");
		vEntityList.add("7");
		vEntityList.add("8");
		vEntityList.add("9");
		vEntityList.add("10");
		
		int subCount = 4;
		
		int count = (vEntityList.size() % subCount == 0 ? vEntityList.size() / subCount : vEntityList.size() / subCount + 1);
		for (int i = 0; i < count; i++)
		{
			int fromIndex = i * subCount;
			int toIndex = (i + 1) * subCount;
			if (toIndex > vEntityList.size())
			{
				toIndex = vEntityList.size();
			}	
			List subList = vEntityList.subList(fromIndex, toIndex);
			
			System.out.println(subList);
		}
	}
}
