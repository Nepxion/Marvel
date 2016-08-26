package com.nepxion.swing.panel.option;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.button.ButtonFocusListener;
import com.nepxion.swing.button.JClassicButton;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.keystroke.KeyStrokeManager;
import com.nepxion.swing.locale.SwingLocale;

public class JOptionButtonPanel
	extends JPanel implements OptionConstants
{
	private JPanel container;
	
	private JClassicButton confirmButton;
	private JClassicButton cancelButton;
	private JClassicButton applyButton;
	private JClassicButton closeButton;
	
	private int option;
	
	private String value;
	
	public JOptionButtonPanel()
	{
		initComponents();
	}
	
	public JOptionButtonPanel(int option)
	{
		initComponents();
		
		setOption(option);
	}
	
	private void initComponents()
	{
		container = new JPanel();
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(Box.createHorizontalGlue());
		add(container);
		add(Box.createHorizontalGlue());
	}
	
	public int getOption()
	{
		return option;
	}
	
	public void setOption(int option)
	{
		container.removeAll();
		
		this.option = option;
		
		switch (option)
		{
			case YES_NO_APPLY_OPTION :
			{
				initYesNoApplyOption();
				break;
			}
			case YES_NO_OPTION :
			{
				initYesNoOption();
				break;
			}
			case CLOSE_OPTION :
			{
				initCloseOption();
				break;
			}
		}
	}
	
	private void initYesNoApplyOption()
	{
		initYesNoOption();
		
		applyButton = new JClassicButton(SwingLocale.getString("apply"), IconFactory.getSwingIcon("stereo/application_16.png"), SwingLocale.getString("apply"));
		ActionListener applyActionListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				doApply();
			}
		};
		applyButton.addFocusListener(new ButtonFocusListener(this));
		applyButton.addActionListener(applyActionListener);
		container.add(applyButton);
	}
	
	private void initYesNoOption()
	{
		confirmButton = new JClassicButton(SwingLocale.getString("yes"), IconFactory.getSwingIcon("stereo/confirm_16.png"), SwingLocale.getString("yes"));
		ActionListener confirmActionListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				doConfirm();
			}
		};
		confirmButton.addFocusListener(new ButtonFocusListener(this));
		confirmButton.addActionListener(confirmActionListener);
		KeyStrokeManager.registerButtonToEnterKey(confirmButton, confirmActionListener);
		container.add(confirmButton);
		
		cancelButton = new JClassicButton(SwingLocale.getString("no"), IconFactory.getSwingIcon("stereo/cancel_16.png"), SwingLocale.getString("no"));
		ActionListener cancelActionListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				doCancel();
			}
		};
		cancelButton.addFocusListener(new ButtonFocusListener(this));
		cancelButton.addActionListener(cancelActionListener);
		KeyStrokeManager.registerButtonToEscapeKey(cancelButton, cancelActionListener);
		container.add(cancelButton);
	}
	
	private void initCloseOption()
	{
		closeButton = new JClassicButton(SwingLocale.getString("close"), IconFactory.getSwingIcon("stereo/close_16.png"), SwingLocale.getString("close"));
		closeButton.addFocusListener(new ButtonFocusListener(this));
		ActionListener closeActionListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				doClose();
			}
		};
		closeButton.addActionListener(closeActionListener);
		KeyStrokeManager.registerButtonToEnterKey(closeButton, closeActionListener);
		KeyStrokeManager.registerButtonToEscapeKey(closeButton, closeActionListener);
		container.add(closeButton);
	}
	
	public JPanel getContainer()
	{
		return container;
	}
	
	public JClassicButton getConfirmButton()
	{
		return confirmButton;
	}
	
	public JClassicButton getCancelButton()
	{
		return cancelButton;
	}
	
	public JClassicButton getApplyButton()
	{
		return applyButton;
	}
	
	public JClassicButton getCloseButton()
	{
		return closeButton;
	}
	
	public void doConfirm()
	{
		value = null;
		if (confirm())
		{
			hideParent();
			value = COMFIRM;
		}
	}
	
	public void doCancel()
	{
		value = null;
		if (cancel())
		{
			hideParent();
			value = CANCEL;
		}
	}
	
	public void doApply()
	{
		value = null;
		apply();
		value = APPLY;
	}
	
	public void doClose()
	{
		value = null;
		if (close())
		{
			hideParent();
			value = CLOSE;
		}
	}
	
	private void hideParent()
	{
		Window window = HandleManager.getWindow(this);
		if (window != null)
		{
			window.setVisible(false);
		}
	}
	
	public String getValue()
	{
		return value;
	}
	
	public boolean confirm()
	{
		return true;
	}
	
	public boolean cancel()
	{
		return true;
	}
	
	public boolean apply()
	{
		return true;
	}
	
	public boolean close()
	{
		return true;
	}
}