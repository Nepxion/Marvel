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
            "Nepxion Awt & Swing 开源库整合将近", 
            "一百种样式新颖，风格独特，以及功能", 
            "丰富的界面控件，同时提供一套轻量级", 
            "的界面框架解决方案，并适配于不同的", 
            "外观风格，实现可定制化，可扩展化。",
            "其具备如下几个特点：",
            "1. 纯Java技术，实现跨平台",
            "2. 组件原子化和良好的粒度实现化",
            "3. 支持C/S，B/S两种方式的部署",
            "4. 支持三种框架组件的实现", 
            "5. 强大的风格预制和定制功能"
        }
        );
    }
}