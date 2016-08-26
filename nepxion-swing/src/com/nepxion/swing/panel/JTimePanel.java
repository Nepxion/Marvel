package com.nepxion.swing.panel;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Dimension;
import java.awt.event.HierarchyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.listener.DisplayAbilityListener;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.textfield.number.JNumberTextField;
import com.nepxion.swing.validation.IValidation;

public class JTimePanel
	extends JPanel implements SwingConstants, IValidation
{
	private JNumberTextField dayTextField;
	private JPanel dayPanel;
	
	private JNumberTextField hourTextField;
	private JPanel hourPanel;
	
	private JNumberTextField minuteTextField;
	private JPanel minutePanel;
	
	private JNumberTextField secondTextField;
	private JPanel secondPanel;
	
	private JNumberTextField milliSecondTextField;
	private JPanel milliSecondPanel;
	
	public JTimePanel(int orientation)
	{
		dayTextField = new JNumberTextField(0);
		dayPanel = new JPanel();
		dayPanel.setLayout(new BoxLayout(dayPanel, BoxLayout.X_AXIS));
		dayPanel.add(dayTextField);
		dayPanel.add(Box.createHorizontalStrut(2));
		dayPanel.add(new JLabel(SwingLocale.getString("day")));
		dayPanel.add(Box.createHorizontalStrut(2));
		
		hourTextField = new JNumberTextField(2, 0, 0, 23);
		hourPanel = new JPanel();
		hourPanel.setLayout(new BoxLayout(hourPanel, BoxLayout.X_AXIS));
		hourPanel.add(hourTextField);
		hourPanel.add(Box.createHorizontalStrut(2));
		hourPanel.add(new JLabel(SwingLocale.getString("hour")));
		hourPanel.add(Box.createHorizontalStrut(2));
		
		minuteTextField = new JNumberTextField(2, 0, 0, 59);
		minutePanel = new JPanel();
		minutePanel.setLayout(new BoxLayout(minutePanel, BoxLayout.X_AXIS));
		minutePanel.add(minuteTextField);
		minutePanel.add(Box.createHorizontalStrut(2));
		minutePanel.add(new JLabel(SwingLocale.getString("minute")));
		minutePanel.add(Box.createHorizontalStrut(2));
		
		secondTextField = new JNumberTextField(2, 0, 0, 59);
		secondPanel = new JPanel();
		secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.X_AXIS));
		secondPanel.add(secondTextField);
		secondPanel.add(Box.createHorizontalStrut(2));
		secondPanel.add(new JLabel(SwingLocale.getString("second")));
		secondPanel.add(Box.createHorizontalStrut(2));
		
		milliSecondTextField = new JNumberTextField(3, 0, 0, 999);
		milliSecondPanel = new JPanel();
		milliSecondPanel.setLayout(new BoxLayout(milliSecondPanel, BoxLayout.X_AXIS));
		milliSecondPanel.add(milliSecondTextField);
		milliSecondPanel.add(Box.createHorizontalStrut(2));
		milliSecondPanel.add(new JLabel(SwingLocale.getString("millisecond")));
		milliSecondPanel.add(Box.createHorizontalStrut(2));
		
		if (orientation == HORIZONTAL)
		{
			setLayout(new FiledLayout(FiledLayout.ROW, FiledLayout.LEFT, 0));
			setTextFieldDimension(new Dimension(30, 22));
		}
		else if (orientation == VERTICAL)
		{
			setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.LEFT, 5));
			setTextFieldDimension(new Dimension(80, 22));
			setLabelDimension(new Dimension(70, 22));
		}
		
		add(dayPanel);
		add(hourPanel);
		add(minutePanel);
		add(secondPanel);
		add(milliSecondPanel);
		
		addHierarchyListener(new DisplayAbilityListener()
		{
			public void displayAbilityChanged(HierarchyEvent e)
			{
				if (dayTextField.getText().equals(""))
				{
					dayTextField.setText("0");
				}
				if (hourTextField.getText().equals(""))
				{
					hourTextField.setText("0");
				}
				if (minuteTextField.getText().equals(""))
				{
					minuteTextField.setText("0");
				}
				if (secondTextField.getText().equals(""))
				{
					secondTextField.setText("0");
				}
				if (milliSecondTextField.getText().equals(""))
				{
					milliSecondTextField.setText("0");
				}
			}
		}
		);
	}
	
	public void showDay(boolean visible)
	{
		if (visible)
		{
			add(dayPanel);
		}
		else
		{
			remove(dayPanel);
		}
	}
	
	public void showHour(boolean visible)
	{
		if (visible)
		{
			add(hourPanel);
		}
		else
		{
			remove(hourPanel);
		}
	}
	
	public void showMinute(boolean visible)
	{
		if (visible)
		{
			add(minutePanel);
		}
		else
		{
			remove(minutePanel);
		}
	}
	
	public void showSecond(boolean visible)
	{
		if (visible)
		{
			add(secondPanel);
		}
		else
		{
			remove(secondPanel);
		}
	}
	
	public void showMilliSecond(boolean visible)
	{
		if (visible)
		{
			add(milliSecondPanel);
		}
		else
		{
			remove(milliSecondPanel);
		}
	}
	
	public void setTextFieldDimension(Dimension dimension)
	{
		dayPanel.getComponent(0).setPreferredSize(dimension);
		hourPanel.getComponent(0).setPreferredSize(dimension);
		minutePanel.getComponent(0).setPreferredSize(dimension);
		secondPanel.getComponent(0).setPreferredSize(dimension);
		milliSecondPanel.getComponent(0).setPreferredSize(dimension);
	}
	
	public void setLabelDimension(Dimension dimension)
	{
		dayPanel.getComponent(2).setPreferredSize(dimension);
		hourPanel.getComponent(2).setPreferredSize(dimension);
		minutePanel.getComponent(2).setPreferredSize(dimension);
		secondPanel.getComponent(2).setPreferredSize(dimension);
		milliSecondPanel.getComponent(2).setPreferredSize(dimension);
	}
	
	public void setInterval(int[] interval)
	{
		if (interval.length != 5)
		{
			throw new IllegalArgumentException(SwingLocale.getString("invalid_time_array_format"));
		}
		dayTextField.setText(interval[0] + "");
		hourTextField.setText(interval[1] + "");
		minuteTextField.setText(interval[2] + "");
		secondTextField.setText(interval[3] + "");
		milliSecondTextField.setText(interval[4] + "");
	}
	
	public int[] getInterval()
	{
		int[] interval = new int[5];
		interval[0] = Integer.parseInt(dayTextField.getText());
		interval[1] = Integer.parseInt(hourTextField.getText());
		interval[2] = Integer.parseInt(minuteTextField.getText());
		interval[3] = Integer.parseInt(secondTextField.getText());
		interval[4] = Integer.parseInt(milliSecondTextField.getText());
		
		return interval;
	}
	
	public boolean verify()
	{
		if (dayTextField.isVisible() && dayTextField.getText().equals(""))
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(this), SwingLocale.getString("day_description"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return false;
		}
		if (hourTextField.isVisible() && hourTextField.getText().equals(""))
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(this), SwingLocale.getString("hour_description"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return false;
		}
		if (minuteTextField.isVisible() && minuteTextField.getText().equals(""))
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(this), SwingLocale.getString("minute_description"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return false;
		}
		if (secondTextField.isVisible() && secondTextField.getText().equals(""))
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(this), SwingLocale.getString("second_description"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return false;
		}
		if (milliSecondTextField.isVisible() && milliSecondTextField.getText().equals(""))
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(this), SwingLocale.getString("millisecond_description"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return false;
		}
		
		return true;
	}
}