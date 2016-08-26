package com.nepxion.swing.thread.dialog;

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
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.border.ShadowBorder;
import com.nepxion.swing.dialog.DialogResizer;
import com.nepxion.swing.dialog.JBasicDialog;
import com.nepxion.swing.thread.ThreadManager;
import com.nepxion.swing.timer.JTimerProgressPanel;

public abstract class AbstractThreadDialog
	extends JBasicDialog
{
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * The progress panel.
	 */
	private JTimerProgressPanel progressPanel;
	
	/**
	 * The animation label.
	 */
	private JLabel animationLabel;
	
	/**
	 * The information string.
	 */
	private String information;
	
	/**
	 * Constructs with the specified initial frame, title, animation label and information.
	 * @param owner the instance of Frame
	 * @param title the title string
	 * @param animationLabel the animation label
	 * @param information the information string
	 */
	public AbstractThreadDialog(Frame owner, String title, JLabel animationLabel, String information)
	{
		super(owner, title, null);
		
		this.animationLabel = animationLabel;
		this.information = information;
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial dialog, title, animation label and information.
	 * @param owner the instance of Dialog
	 * @param title the title string
	 * @param animationLabel the animation label
	 * @param information the information string
	 */
	public AbstractThreadDialog(Dialog owner, String title, JLabel animationLabel, String information)
	{
		super(owner, title, null);
		
		this.animationLabel = animationLabel;
		this.information = information;
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		progressPanel = new JTimerProgressPanel(animationLabel, information)
		{
			public void fireCancelled()
			{
				AbstractThreadDialog.this.fireCancelled();
			}
			
			public void fireHidden()
			{
				AbstractThreadDialog.this.fireHidden();
			}
		};
		
		progressPanel.setPreferredSize(new Dimension(330, progressPanel.getPreferredSize().height + 10 + ThreadManager.getDecoratedMargin(this)));
		progressPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(progressPanel, BorderLayout.CENTER);
		
		if (!JDialog.isDefaultLookAndFeelDecorated())
		{
			layoutPanel.setBorder(new ShadowBorder());
		}
		
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		container.add(layoutPanel, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JBasicDialog.DO_NOTHING_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);
		
		for (int i = 0; i < getComponentListeners().length; i++)
		{
			ComponentListener componentListener = getComponentListeners()[i];
			if (componentListener instanceof DialogResizer)
			{
				removeComponentListener(componentListener);
				break;
			}
		}
		
		ThreadManager.setPreferenceStyle(this);
	}
	
	/**
	 * Resets the thread.
	 */
	public void reset()
	{
		progressPanel.reset();
	}
	
	/**
	 * Starts the thread.
	 */
	public void start()
	{
		progressPanel.start();
	}
	
	/**
	 * Starts the thread by a delay time.
	 * @param delayTime the delay time value
	 */
	public void start(int delayTime)
	{
		progressPanel.start(delayTime);
	}
	
	/**
	 * Restarts the thread.
	 */
	public void restart()
	{
		progressPanel.restart();
	}
	
	/**
	 * Restarts the thread by a delay time.
	 * @param delayTime the delay time value 
	 */
	public void restart(int delayTime)
	{
		progressPanel.restart(delayTime);
	}
	
	/**
	 * Stops the thread.
	 */
	public void stop()
	{
		progressPanel.stop();
	}
	
	/**
	 * Finished the thread.
	 */
	public void finish()
	{
		progressPanel.finish();
	}
	
	/**
	 * Gets the layout panel.
	 * @return the instance of JPanel
	 */
	public JPanel getLayoutPanel()
	{
		return layoutPanel;
	}
	
	/**
	 * Gets the progress panel.
	 * @return the instance of JTimerProgressPanel
	 */
	public JTimerProgressPanel getProgressPanel()
	{
		return progressPanel;
	}
	
	/**
	 * Executes.
	 */
	public abstract void execute();
	
	/**
	 * Fires the hidden.
	 */
	protected abstract void fireHidden();
	
	/**
	 * Fires the cancelled.
	 */
	protected abstract void fireCancelled();
}