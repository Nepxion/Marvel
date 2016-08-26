package com.nepxion.demo;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Component;
import java.awt.event.ActionEvent;

import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.topic.TopicContext;

public class DemoController
{
    public static JSecurityAction getAboutAction()
    {
    	JSecurityAction action = new JSecurityAction("¹ØÓÚ", IconFactory.getSwingIcon("about.png"), "About Nepxion Swing 1.0")
        {
            public void execute(ActionEvent e)
            {
            	Component topicComponent = TopicContext.getTopicComponent();
            	if (topicComponent == null)
            	{
            		return;
            	}	
            	topicComponent.setVisible(true);
            }
        };
        
        return action;
    }	
}