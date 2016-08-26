package com.nepxion.cots.twaver.graph;

/**
 * <p>Title: Nepxion Cots For TWaver</p>
 * <p>Description: Nepxion Cots Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * <p>Announcement: It depends on the commercial software of TWaver, the repository only references the trial version.</p>
 * <p>If you want to use Nepxion Cots, please contact with Serva Corporation to buy the genuine version.</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Color;

import twaver.AlarmSeverity;
import twaver.Element;
import twaver.Generator;
import twaver.TWaverConst;
import twaver.network.ui.ElementUI;

public class TAlarmFacadeAdapter
{
	public TAlarmFacadeAdapter(TGraph graph)
	{
		graph.setElementBodyColorGenerator(new Generator()
		{
			public Object generate(Object object)
			{
				if (!(object instanceof Element))
				{
					return null;
				}
				
				Element element = (Element) object;
				
				AlarmSeverity propagateSeverity = element.getAlarmState().getPropagateSeverity();
				if (propagateSeverity != null)
				{
					return propagateSeverity.getColor();
				}
				
				AlarmSeverity severity = element.getAlarmState().getHighestNativeAlarmSeverity();
				if (severity != null)
				{
					return severity.getColor();
				}
				
				Color elementBodyColor = (Color) element.getClientProperty(TWaverConst.PROPERTYNAME_RENDER_COLOR);
				if (elementBodyColor != null)
				{
					return elementBodyColor;
				}
				
				return null;
			}
		}
		);
		
		graph.setElementStateOutlineColorGenerator(new Generator()
		{
			public Object generate(Object object)
			{
				if (!(object instanceof Element))
				{
					return null;
				}
				
				Element element = (Element) object;
				
				/*AlarmSeverity propagateSeverity = element.getAlarmState().getPropagateSeverity();
				if (propagateSeverity != null)
				{
					return propagateSeverity.getColor();
				}*/
				
				Color elementOutlineColor = (Color) element.getClientProperty(TWaverConst.PROPERTYNAME_STATE_OUTLINE_COLOR);
				if (elementOutlineColor != null)
				{
					return elementOutlineColor;
				}
				
				return null;
			}
		}
		);
		
		graph.setAlarmColorGenerator(new Generator()
		{
			public Object generate(Object object)
			{
				Element element = null;
				
				if (object instanceof ElementUI)
				{
					ElementUI elementUI = (ElementUI) object;
					element = elementUI.getElement();
				}
				else
				{
					element = (Element) object;
				}
				
				AlarmSeverity propagateSeverity = element.getAlarmState().getPropagateSeverity();
				if (propagateSeverity != null)
				{
					return propagateSeverity.getColor();
				}
				
				AlarmSeverity severity = element.getAlarmState().getHighestNativeAlarmSeverity();
				if (severity != null)
				{
					return severity.getColor();
				}
				
				Color elementBodyColor = (Color) element.getClientProperty(TWaverConst.PROPERTYNAME_RENDER_COLOR);
				if (elementBodyColor != null)
				{
					return elementBodyColor;
				}
				
				return null;
			}
		}
		);
		
		graph.setAlarmLabelGenerator(new Generator()
		{
			public Object generate(Object object)
			{
				Element element = null;
				if (object instanceof ElementUI)
				{
					ElementUI elementUI = (ElementUI) object;
					element = elementUI.getElement();
				}
				else
				{
					element = (Element) object;
				}
				
				AlarmSeverity propagateSeverity = element.getAlarmState().getPropagateSeverity();
				if (propagateSeverity != null)
				{
					int severityCount = element.getAlarmState().getNewAlarmCount(propagateSeverity);
					String bubbleString = severityCount + propagateSeverity.getNickName();
					if (element.getAlarmState().hasLessSevereNewAlarms())
					{
						bubbleString += "+";
					}
					
					return bubbleString;
				}
				
				AlarmSeverity severity = element.getAlarmState().getHighestNativeAlarmSeverity();
				if (severity != null)
				{
					int highestSeverityCount = element.getAlarmState().getNewAlarmCount(severity);
					String bubbleString = highestSeverityCount + severity.getNickName();
					if (element.getAlarmState().hasLessSevereNewAlarms())
					{
						bubbleString += "+";
					}
					
					return bubbleString;
				}
				
				return null;
			}
		}
		);
	}
}