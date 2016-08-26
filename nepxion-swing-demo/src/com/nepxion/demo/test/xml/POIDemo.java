package com.nepxion.demo.test.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.nepxion.util.io.FileUtil;
import com.nepxion.util.searcher.gis.google.loc.LocEntity;
import com.nepxion.util.searcher.gis.google.loc.LocSearcher;


public class POIDemo
{
	public static void read()
	{
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("<records>\n");
		try
		{
			FileInputStream rs = new FileInputStream("D:/Cell.xls");
			HSSFWorkbook workbook = new HSSFWorkbook(rs);			
			for (int i = 0; i < workbook.getNumberOfSheets(); i++)
			{
				LocSearcher locSearcher = new LocSearcher();
				
				HSSFSheet sheet = workbook.getSheetAt(i);
				for (int j = sheet.getFirstRowNum() + 1; j < sheet.getLastRowNum(); j++)
				{
					HSSFRow row = sheet.getRow(j);
					HSSFCell cell0 = row.getCell(0);
					HSSFCell cell1 = row.getCell(1);
					HSSFCell cell2 = row.getCell(2);
					HSSFCell cell3 = row.getCell(3);
					int lac = Integer.parseInt(cell0.toString().substring(0, cell0.toString().length() - 2));
					int cell = Integer.parseInt(cell1.toString().substring(0, cell1.toString().length() - 2));
					
					LocEntity loc = null;
					try
					{
						loc = locSearcher.search(cell, lac);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}			
					System.out.println(loc);
					stringBuffer.append("	<record lac=\"" + lac + "\" cell=\"" + cell + "\" latitude=\"" + cell2 + "\" longitude=\"" + cell3 + "\" address=\"" + loc + "\" />\n");
				}
			}
			rs.close();
		}
		catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
		}
		catch (IOException e)
		{
			
			e.printStackTrace();
		}
		stringBuffer.append("</records>");
		try
		{
			FileUtil.writeString(stringBuffer.toString(), "D:/Cell.xml");
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		POIDemo.read();
	}
}