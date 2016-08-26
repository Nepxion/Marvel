package com.nepxion.swing.scrollpane;

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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.plaf.UIResource;

import com.jidesoft.icons.JideIconsFactory;
import com.jidesoft.swing.SimpleScrollPane;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.style.button.lite.LiteButtonUI;

public class JAutoRollScrollPane
	extends SimpleScrollPane implements SwingConstants
{	
	/**
	 * Constructs with the default.
	 */
	public JAutoRollScrollPane()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial vertical scroll bar policy and horizontal scroll bar policy.
	 * @param vsbPolicy the vertical scroll bar policy value
	 * @param hsbPolicy the horizontal scroll bar policy value
	 */
	public JAutoRollScrollPane(int vsbPolicy, int hsbPolicy)
	{
		super(vsbPolicy, hsbPolicy);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial view.
	 * @param view the instance of Component
	 */
	public JAutoRollScrollPane(Component view)
	{
		super(view);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial view, vertical scroll bar policy and horizontal scroll bar policy.
	 * @param view the instance of Component
	 * @param vsbPolicy the vertical scroll bar policy value
	 * @param hsbPolicy the horizontal scroll bar policy value
	 */
	public JAutoRollScrollPane(Component view, int vsbPolicy, int hsbPolicy)
	{
		super(view, vsbPolicy, hsbPolicy);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{					
		setScrollUpButton(new JAutoRollScrollButton(SwingConstants.NORTH));
		setScrollDownButton(new JAutoRollScrollButton(SwingConstants.SOUTH));
		setScrollLeftButton(new JAutoRollScrollButton(SwingConstants.WEST));
		setScrollRightButton(new JAutoRollScrollButton(SwingConstants.EAST));
		setRepeatDelay(15);

		// setViewportBorder(BorderManager.createLineBorder(Color.gray, 0, 0, 0, 0));
		
		ScrollPaneManager.setPreferenceStyle(this);
	}
	
	public class JAutoRollScrollButton
		extends JBasicButton implements MouseListener, ActionListener, UIResource
	{
		/**
		 * The direction value.
		 */
		private int direction;
		
		/**
		 * The instance of Timer.
		 */
		private Timer timer;
		
		/**
		 * Constructs with the specified initial direction.
		 * @param direction the direction value
		 */
		public JAutoRollScrollButton(final int direction)
		{
			this.direction = direction;
			
			switch (direction)
			{
				case NORTH :
					setIcon(JideIconsFactory.getImageIcon(JideIconsFactory.Arrow.UP));
					break;
				case SOUTH :
					setIcon(JideIconsFactory.getImageIcon(JideIconsFactory.Arrow.DOWN));
					break;
				case WEST :
					setIcon(JideIconsFactory.getImageIcon(JideIconsFactory.Arrow.LEFT));
					break;
				case EAST :
					setIcon(JideIconsFactory.getImageIcon(JideIconsFactory.Arrow.RIGHT));
					break;
			}
						
			setUI(new LiteButtonUI(ButtonManager.getButtonStyle())
			{
				public void paint(Graphics g, JComponent c)
				{
					super.paint(g, c);
					
					g.setColor(Color.gray);
					
					Border viewportBorder = getViewportBorder();
					
					if (viewportBorder != null && viewportBorder instanceof CompoundBorder)
					{	
						switch (direction)
						{
							case NORTH :
								g.drawLine(0, 0, getWidth() - 1, 0);
								g.drawLine(0, 0, 0, getHeight() - 1);
								g.drawLine(getWidth() - 1, 0, getWidth() - 1, getHeight() - 1);
								break;
							case SOUTH :
								g.drawLine(0, getHeight() - 1, getWidth() - 1, getHeight() - 1);
								g.drawLine(0, 0, 0, getHeight() - 1);
								g.drawLine(getWidth() - 1, 0, getWidth() - 1, getHeight() - 1);								
								break;
							case WEST :
								g.drawLine(0, 0, getWidth() - 1, 0);
								g.drawLine(0, 0, 0, getHeight() - 1);
								g.drawLine(0, getHeight() - 1, getWidth() - 1, getHeight() - 1);
								break;
							case EAST :
								g.drawLine(0, 0, getWidth() - 1, 0);
								g.drawLine(getWidth() - 1, 0, getWidth() - 1, getHeight() - 1);
								g.drawLine(0, getHeight() - 1, getWidth() - 1, getHeight() - 1);
								break;
						}						
					}
					else
					{
						g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
					}
				}
			}
			);
			
			setDimension(new Dimension(10, 10));
			
			addActionListener(this);
			addMouseListener(this);
		}
		
		/**
		 * Invoked when the selection value is changed.
		 * @param e the instance of ListSelectionEvent
		 */
		public void actionPerformed(ActionEvent e)
		{
			scroll(getViewport(), direction);
			
			updateButtonState();
		}
		
	    /**
	     * Invoked when the mouse button has been clicked (pressed and released) on a component.
	     * @param e the instance of MouseEvent
	     */
		public void mouseClicked(MouseEvent e)
		{
		}
		
	    /**
	     * Invoked when the mouse button has been pressed on a component.
	     * @param e the instance of MouseEvent
	     */
		public void mousePressed(MouseEvent e)
		{
			if (!isScrollOnRollover())
			{
				startTimer(e, 500);
			}
			else
			{
				updateTimer(e);
			}
		}
		
	    /**
	     * Invoked when the mouse button has been released on a component.
	     * @param e the instance of MouseEvent
	     */
		public void mouseReleased(MouseEvent e)
		{
			if (!isScrollOnRollover())
			{
				stopTimer();
			}
			else
			{
				updateTimer(e);
			}
		}
		
	    /**
	     * Invoked when the mouse enters a component.
	     * @param e the instance of MouseEvent
	     */
		public void mouseEntered(MouseEvent e)
		{
			if (isScrollOnRollover())
			{
				startTimer(e, 500);
			}
		}
		
	    /**
	     * Invoked when the mouse exits a component.
	     * @param e the instance of MouseEvent
	     */
		public void mouseExited(MouseEvent e)
		{
			if (isScrollOnRollover())
			{
				stopTimer();
			}
		}
		
		/**
		 * Updates the timer.
		 * @param e the instance of MouseEvent
		 */
		private void updateTimer(MouseEvent e)
		{
			if (timer != null)
			{
				int delay = getDelay(e);
				timer.setDelay(delay);
			}
		}
		
		/**
		 * Starts the timer.
		 * @param e the instance of MouseEvent
		 * @param initDelay the initial delay value
		 */
		private void startTimer(MouseEvent e, int initialDelay)
		{
			stopTimer();
			
			int delay = getDelay(e);
			
			timer = new Timer(delay, this);
			timer.setInitialDelay(initialDelay);
			timer.start();
		}
		
		/**
		 * Stops the timer.
		 */
		private void stopTimer()
		{
			if (timer != null)
			{
				timer.stop();
				timer = null;
			}
		}
		
		/**
		 * Gets the delay.
		 * @param e the instance of MouseEvent
		 * @return the delay value
		 */
		private int getDelay(MouseEvent e)
		{
			if (isScrollOnRollover())
			{
				return SwingUtilities.isLeftMouseButton(e) ? getRepeatDelay() : getRepeatDelay() * 2;
			}
			else
			{
				return getRepeatDelay();
			}
		}
	}
}