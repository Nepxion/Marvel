package com.nepxion.demo.component.splash;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.splash.JCaptionSplashWindow;

public class DemoCaptionSplashWindow
	extends JCaptionSplashWindow
{	
	public DemoCaptionSplashWindow()
	{
        super(IconFactory.getSwingIcon("splash.png"), new int[] {15, 200}, new int[] {220, 90}, new String[]
        {
            "Nepxion Awt & Swing ��Դ�����Ͻ���", 
            "һ������ʽ��ӱ�������أ��Լ�����", 
            "�ḻ�Ľ���ؼ���ͬʱ�ṩһ��������", 
            "�Ľ����ܽ���������������ڲ�ͬ��", 
            "��۷��ʵ�ֿɶ��ƻ�������չ����",
            "��߱����¼����ص㣺",
            "1. ��Java������ʵ�ֿ�ƽ̨",
            "2. ���ԭ�ӻ������õ�����ʵ�ֻ�",
            "3. ֧��C/S��B/S���ַ�ʽ�Ĳ���",
            "4. ֧�����ֿ�������ʵ��", 
            "5. ǿ��ķ��Ԥ�ƺͶ��ƹ���"
        }
        );
    }
}