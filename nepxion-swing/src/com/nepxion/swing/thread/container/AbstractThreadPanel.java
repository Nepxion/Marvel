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

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.timer.JTimerProgressBar;
import com.nepxion.swing.timer.JTimerProgressPanel;

public abstract class AbstractThreadPanel
	extends JBasicScrollPane
{
	/**
	 * The instance of JPanel.
	 */
	private JPanel panel;
	
	/**
	 * The instance of JTimerProgressPanel.
	 */
	private JTimerProgressPanel progressPanel;
	
	/**
	 * Constructs with the specified initial animation label and information.
	 * @param animationLabel the animation label
	 * @param information the information string
	 */
	public AbstractThreadPanel(JLabel animationLabel, String information)
	{
		progressPanel = new JTimerProgressPanel(animationLabel, information)
		{
			public void fireHidden()
			{
				AbstractThreadPanel.this.fireHidden();
			}
			
			public void fireCancelled()
			{
				AbstractThreadPanel.this.fireCancelled();
			}
		};
		
		double[][] size = 
		{ 
			{TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL}, 
			{TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL}
		};
		panel = new JPanel();
		panel.setLayout(new TableLayout(size));
		panel.add(progressPanel, "1, 1");
		
		setBackgound(panel, Color.white);
		
		getViewport().add(panel);
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
	 * Gets the progress panel.
	 * @return the instance of JTimerProgressPanel
	 */
	public JTimerProgressPanel getProgressPanel()
	{
		return progressPanel;
	}
	
	/**
	 * Gets the progress bar.
	 * @return the instance of JTimerProgressBar
	 */
	public JTimerProgressBar getProgressBar()
	{
		return progressPanel.getTimerProgressBar();
	}
	
	/**
	 * Sets the width.
	 * @param width the width value
	 */
	public void setWidth(int width)
	{
		if (panel.getLayout() instanceof TableLayout)
		{
			TableLayout tableLayout = (TableLayout) panel.getLayout();
			tableLayout.setColumn(1, width);
		}
	}
	
	/**
	 * Sets the height.
	 * @param height the height value
	 */
	public void setHeight(int height)
	{
		if (panel.getLayout() instanceof TableLayout)
		{
			TableLayout tableLayout = (TableLayout) panel.getLayout();
			tableLayout.setRow(1, height);
		}
	}
	
	/**
	 * Sets the background for the component.
	 * @param component the instance of JComponent
	 * @param background the instance of Color
	 */
	private void setBackgound(JComponent component, Color background)
	{
		for (int i = 0; i < component.getComponentCount(); i++)
		{
			JComponent childComponent = (JComponent) component.getComponent(i);
			if (childComponent instanceof JPanel)
			{
				setBackgound(childComponent, background);
			}
		}
		component.setBackground(background);
	}
	
	/**
	 * Fires the hidden.
	 */
	protected abstract void fireHidden();
	
	/**
	 * Fires the cancelled.
	 */
	protected abstract void fireCancelled();
}