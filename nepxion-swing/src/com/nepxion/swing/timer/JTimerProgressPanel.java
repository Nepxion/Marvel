package com.nepxion.swing.timer;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.button.JClassicButton;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.keystroke.KeyStrokeManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;

public abstract class JTimerProgressPanel
	extends JPanel
{
	/**
	 * The animation label.
	 */
	private JLabel animationLabel;
	
	/**
	 * The timer progress bar.
	 */
	private JTimerProgressBar timerProgressBar;
	
	/**
	 * The information label
	 */
	private JLabel informationLabel;
	
	/**
	 * The hide button.
	 */
	private JClassicButton hideButton;
	
	/**
	 * The cancel button.
	 */
	private JClassicButton cancelButton;
	
	/**
	 * The information string
	 */
	private String information;
	
	/**
	 * Constructs with the specified initial animation label and information.
	 * @param animationLabel the instance of JLabel
	 * @param information the information string
	 */
	public JTimerProgressPanel(JLabel animationLabel, String information)
	{
		this.animationLabel = animationLabel;
		this.information = information;
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		LabelPanel labelPanel = new LabelPanel();
		ProgressPanel progressPanel = new ProgressPanel();
		ButtonPanel buttonPanel = new ButtonPanel();
		
		setLayout(new BorderLayout());
		add(labelPanel, BorderLayout.NORTH);
		add(progressPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public class LabelPanel
		extends JPanel
	{
		/**
		 * Constructs with the default.
		 */
		public LabelPanel()
		{
			informationLabel = new JLabel(information);
			informationLabel.setIconTextGap(5);
			informationLabel.setHorizontalAlignment(JLabel.LEADING);
			
			setLayout(new FlowLayout(FlowLayout.LEADING));
			add(animationLabel);
			add(Box.createHorizontalStrut(5));
			add(informationLabel);
		}
	}
	
	public class ProgressPanel
		extends JPanel
	{
		/**
		 * Constructs with the default.
		 */
		public ProgressPanel()
		{
			timerProgressBar = new JTimerProgressBar();
			
			setLayout(new BorderLayout());
			add(Box.createHorizontalStrut(5), BorderLayout.WEST);
			add(timerProgressBar);
			add(Box.createHorizontalStrut(5), BorderLayout.EAST);
		}
	}
	
	public class ButtonPanel
		extends JPanel
	{
		/**
		 * Constructs with the default.
		 */
		public ButtonPanel()
		{
			hideButton = new JClassicButton(SwingLocale.getString("hide"), IconFactory.getSwingIcon("stereo/confirm_16.png"), SwingLocale.getString("hide"));
			ActionListener hideActionListener = new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(JTimerProgressPanel.this), SwingLocale.getString("confirm_to_hide"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
					if (selectedValue != JBasicOptionPane.YES_OPTION)
					{
						return;
					}
					
					stop();
					fireHidden();
				}
			};
			hideButton.addActionListener(hideActionListener);
			KeyStrokeManager.registerButtonToEnterKey(hideButton, hideActionListener);
			
			cancelButton = new JClassicButton(SwingLocale.getString("cancel"), IconFactory.getSwingIcon("stereo/cancel_16.png"), SwingLocale.getString("cancel"));
			ActionListener cancelActionListener = new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(JTimerProgressPanel.this), SwingLocale.getString("confirm_to_cancel"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
					if (selectedValue != JBasicOptionPane.YES_OPTION)
					{
						return;
					}
					
					stop();
					fireCancelled();
				}
			};
			cancelButton.addActionListener(cancelActionListener);
			KeyStrokeManager.registerButtonToEscapeKey(cancelButton, cancelActionListener);
			
			setLayout(new FlowLayout(FlowLayout.RIGHT));
			add(hideButton);
			add(cancelButton);
		}
	}
	
	/**
	 * Rests the timer.
	 */
	public void reset()
	{
		if (animationLabel instanceof JTimerLabel)
		{
			JTimerLabel timerAnimationLabel = (JTimerLabel) animationLabel;
			timerAnimationLabel.reset();
		}
		
		timerProgressBar.reset();
	}
	
	/**
	 * Starts the timer.
	 */
	public void start()
	{
		if (animationLabel instanceof JTimerLabel)
		{
			JTimerLabel timerAnimationLabel = (JTimerLabel) animationLabel;
			timerAnimationLabel.restart(); // 不需要重复刷新
		}
		
		timerProgressBar.start();
	}
	
	/**
	 * Starts the timer with a delay time.
	 * @param delayTime the delay time value
	 */
	public void start(int delayTime)
	{
		if (animationLabel instanceof JTimerLabel)
		{
			JTimerLabel timerAnimationLabel = (JTimerLabel) animationLabel;
			timerAnimationLabel.restart(); // 按照默认的时间间隔执行
		}
		
		timerProgressBar.start(delayTime);
	}
	
	/**
	 * Restarts the timer.
	 */
	public void restart()
	{
		if (animationLabel instanceof JTimerLabel)
		{
			JTimerLabel timerAnimationLabel = (JTimerLabel) animationLabel;
			timerAnimationLabel.restart();
		}
		
		timerProgressBar.restart();
	}
	
	/**
	 * Restarts the timer with a delay time.
	 * @param delayTime the delay time value
	 */
	public void restart(int delayTime)
	{
		if (animationLabel instanceof JTimerLabel)
		{
			JTimerLabel timerAnimationLabel = (JTimerLabel) animationLabel;
			timerAnimationLabel.restart();
		}
		
		timerProgressBar.restart(delayTime);
	}
	
	/**
	 * Stops the timer.
	 */
	public void stop()
	{
		if (animationLabel instanceof JTimerLabel)
		{
			JTimerLabel timerLabel = (JTimerLabel) animationLabel;
			timerLabel.stop();
		}
		
		timerProgressBar.stop();
	}
	
	/**
	 * Finishes the timer.
	 */
	public void finish()
	{
		if (animationLabel instanceof JTimerLabel)
		{
			JTimerLabel timerLabel = (JTimerLabel) animationLabel;
			timerLabel.finish();
		}
		
		timerProgressBar.finish();
	}
	
	/**
	 * Gets the animation label.
	 * @return the instance of JLabel
	 */
	public JLabel getAnimationLabel()
	{
		return animationLabel;
	}
	
	/**
	 * Gets the timer progress bar.
	 * @return the instance of JTimerProgressBar
	 */
	public JTimerProgressBar getTimerProgressBar()
	{
		return timerProgressBar;
	}
	
	/**
	 * Gets the information label.
	 * @return the instance of JLabel
	 */
	public JLabel getInformationLabel()
	{
		return informationLabel;
	}
	
	/**
	 * Gets the hide button.
	 * @return the instance of JClassicButton
	 */
	public JClassicButton getHideButton()
	{
		return hideButton;
	}
	
	/**
	 * Gets the cancel button.
	 * @return the instance of JClassicButton
	 */
	public JClassicButton getCancelButton()
	{
		return cancelButton;
	}
	
	/**
	 * Fires the progress hidden.
	 */
	protected abstract void fireHidden();
	
	/**
	 * Fires the progress cancelled.
	 */
	protected abstract void fireCancelled();
}