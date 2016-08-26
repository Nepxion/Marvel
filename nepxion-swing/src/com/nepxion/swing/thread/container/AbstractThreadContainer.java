package com.nepxion.swing.thread.container;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JLabel;

import com.nepxion.swing.container.JContainer;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.panel.JInformationPanel;

public abstract class AbstractThreadContainer
	extends JContainer
{
	/**
	 * The information text.
	 */
	private String informationText;
	
	/**
	 * The information icon.
	 */
	private Icon informationIcon;
	
	/**
	 * The error text.
	 */
	private String errorText;
	
	/**
	 * The error icon.
	 */
	private Icon errorIcon;
	
	/**
	 * The information panel.
	 */
	private JInformationPanel informationPanel;
	
	/**
	 * The thread panel.
	 */
	private AbstractThreadPanel threadPanel;
	
	/**
	 * Constructs with the specified initial animation label and information.
	 * @param animationLabel the animation label
	 * @param information the information string
	 */
	public AbstractThreadContainer(JLabel animationLabel, String information)
	{
		informationPanel = new JInformationPanel();
		informationPanel.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				fireHidden();
			}
		}
		);
		
		threadPanel = new AbstractThreadPanel(animationLabel, information)
		{
			public void fireHidden()
			{
				AbstractThreadContainer.this.fireHidden();
			}
			
			public void fireCancelled()
			{
				AbstractThreadContainer.this.fireCancelled();
			}
		};
		
		setLayout(new BorderLayout());
	}
	
	/**
	 * Resets the thread.
	 */
	public void reset()
	{
		threadPanel.reset();
	}
	
	/**
	 * Starts the thread.
	 */
	public void start()
	{
		threadPanel.start();
	}
	
	/**
	 * Starts the thread by a delay time.
	 * @param delayTime the delay time value
	 */
	public void start(int delayTime)
	{
		threadPanel.start(delayTime);
	}
	
	/**
	 * Restarts the thread.
	 */
	public void restart()
	{
		threadPanel.restart();
	}
	
	/**
	 * Restarts the thread by a delay time.
	 * @param delayTime the delay time value 
	 */
	public void restart(int delayTime)
	{
		threadPanel.restart(delayTime);
	}
	
	/**
	 * Stops the thread.
	 */
	public void stop()
	{
		threadPanel.stop();
	}
	
	/**
	 * Finished the thread.
	 */
	public void finish()
	{
		threadPanel.finish();
	}
	
	/**
	 * Shows the thread panel.
	 */
	public void showThread()
	{
		addComponent(threadPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Shows the information panel.
	 */
	public void showInformation()
	{
		informationPanel.getLabel().setText(informationText);
		informationPanel.getLabel().setIcon(informationIcon);
		addComponent(informationPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Shows the error panel.
	 */
	public void showError()
	{
		informationPanel.getLabel().setText(errorText + SwingLocale.getString("period") + SwingLocale.getString("return_to_result_page"));
		informationPanel.getLabel().setIcon(errorIcon);
		addComponent(informationPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Gets the thread panel.
	 * @return the instance of AbstractThreadPanel
	 */
	public AbstractThreadPanel getThreadPanel()
	{
		return threadPanel;
	}
	
	/**
	 * Gets the information panel.
	 * @return the instance of JInformationPanel
	 */
	public JInformationPanel getInformationPanel()
	{
		return informationPanel;
	}
	
	/**
	 * Gets the information text.
	 * @return the information text string
	 */
	public String getInformationText()
	{
		return informationText;
	}
	
	/**
	 * Sets the information text.
	 * @param informationText the information text string
	 */
	public void setInformationText(String informationText)
	{
		this.informationText = informationText;
	}
	
	/**
	 * Gets the information icon.
	 * @return the instance of Icon
	 */
	public Icon getInformationIcon()
	{
		return informationIcon;
	}
	
	/**
	 * Sets the information icon.
	 * @param informationIcon the instance of Icon
	 */
	public void setInformationIcon(Icon informationIcon)
	{
		this.informationIcon = informationIcon;
	}
	
	/**
	 * Gets the error text.
	 * @return the error text string
	 */
	public String getErrorText()
	{
		return errorText;
	}
	
	/**
	 * Sets the error text.
	 * @param errorText the error text string
	 */
	public void setErrorText(String errorText)
	{
		this.errorText = errorText;
	}
	
	/**
	 * Gets the error icon.
	 * @return the instance of Icon
	 */
	public Icon getErrorIcon()
	{
		return errorIcon;
	}
	
	/**
	 * Sets the error icon.
	 * @param errorIcon the instance of Icon
	 */
	public void setErrorIcon(Icon errorIcon)
	{
		this.errorIcon = errorIcon;
	}
	
	/**
	 * Sets the width for the thread panel.
	 * @param width the width value
	 */
	public void setThreadPanelWidth(int width)
	{
		threadPanel.setWidth(width);
	}
	
	/**
	 * Sets the height for the thread panel.
	 * @param height the height value
	 */
	public void setThreadPanelHeight(int height)
	{
		threadPanel.setHeight(height);
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