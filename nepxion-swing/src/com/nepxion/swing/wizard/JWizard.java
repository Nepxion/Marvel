package com.nepxion.swing.wizard;

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
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import com.nepxion.swing.button.JClassicButton;
import com.nepxion.swing.container.ContainerManager;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.keystroke.KeyStrokeManager;
import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;

public class JWizard
	extends JPanel
{
	private WizardModel wizardModel;
	
	private ImageModule imageModule;
	private ContentModule contentModule;
	private ToolBar toolBar;
	
	private JPanel panel;
	
	private int currentStepIndex = 0;
	
	public JWizard(WizardModel wizardModel)
	{
		this.wizardModel = wizardModel;
		
		imageModule = new ImageModule();
		contentModule = new ContentModule();
		toolBar = new ToolBar();
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(imageModule, BorderLayout.WEST);
		panel.add(contentModule, BorderLayout.CENTER);
		
        double[][] size =
        {
            {TableLayout.FILL},
            {TableLayout.FILL, 10, 30}
        };
		
		setLayout(new TableLayout(size));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		add(panel, "0, 0");
		add(new JSeparator(), "0, 1");
		add(toolBar, "0, 2");
	}
	
	public void setCurrentStep(int currentStepIndex)
	{
		if (currentStepIndex < 0 || currentStepIndex >= wizardModel.getStepCount())
		{
			throw new IllegalArgumentException("超出索引范围");
		}
		this.currentStepIndex = currentStepIndex;
		JStep step = wizardModel.getStepAt(currentStepIndex);
		
		Window window = HandleManager.getWindow(this);
		if (step.getTitle() != null)
		{
			if (window instanceof JFrame)
			{
				((JFrame) window).setTitle(step.getTitle());
			}
			else if (window instanceof JDialog)
			{
				((JDialog) window).setTitle(step.getTitle());
			}
		}
		
		if (step.getImage() != null)
		{
			if (imageModule.getParent() != panel)
			{
				panel.add(imageModule, BorderLayout.WEST);
			}
			imageModule.setImage(step.getImage());
		}
		else
		{
			panel.remove(imageModule);
		}
		
		if (step.getContentPane() != null)
		{
			if (contentModule.getParent() != panel)
			{
				panel.add(contentModule, BorderLayout.CENTER);
			}
			contentModule.setContentPane(step.getContentPane());
		}
		else
		{
			panel.remove(contentModule);
		}
		
		toolBar.previousButton.setEnabled(currentStepIndex != 0);
		toolBar.nextButton.setEnabled(currentStepIndex != wizardModel.getStepCount() - 1);
	}
	
	public void confirm()
	{
		int stepCount = wizardModel.getStepCount();
		if (stepCount == 0)
		{
			return;
		}
		
		JStep currentStep = wizardModel.getStepAt(currentStepIndex);
		if (!currentStep.confirm())
		{
			return;
		}
	}
	
	public void cancel()
	{
		int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getWindow(this), "确认要取消？", SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
		if (selectedValue != JBasicOptionPane.YES_OPTION)
		{
			return;
		}
		
		int stepCount = wizardModel.getStepCount();
		if (stepCount == 0)
		{
			return;
		}
		
		JStep currentStep = wizardModel.getStepAt(currentStepIndex);
		if (!currentStep.cancel())
		{
			return;
		}
		
		HandleManager.getWindow(this).setVisible(false);
	}
	
	public void next()
	{
		int stepCount = wizardModel.getStepCount();
		if (stepCount == 0)
		{
			return;
		}
		
		JStep currentStep = wizardModel.getStepAt(currentStepIndex);
		if (!currentStep.next())
		{
			return;
		}
		
		int nextStepIndex = currentStepIndex + 1;
		if (nextStepIndex >= stepCount)
		{
			toolBar.nextButton.setEnabled(false);
		}
		toolBar.previousButton.setEnabled(true);
		
		setCurrentStep(nextStepIndex);
		
		HandleManager.getWindow(this).pack();
	}
	
	public void previous()
	{
		int stepCount = wizardModel.getStepCount();
		if (stepCount == 0)
		{
			return;
		}
		
		JStep currentStep = wizardModel.getStepAt(currentStepIndex);
		if (!currentStep.previous())
		{
			return;
		}
		
		int previousStepIndex = currentStepIndex - 1;
		if (previousStepIndex < 0)
		{
			toolBar.previousButton.setEnabled(false);
		}
		toolBar.nextButton.setEnabled(true);
		
		setCurrentStep(previousStepIndex);
		
		HandleManager.getWindow(this).pack();
	}
	
	public WizardModel getWizardModel()
	{
		return wizardModel;
	}
	
	public ImageModule getImageModule()
	{
		return imageModule;
	}
	
	public ContentModule getContentModule()
	{
		return contentModule;
	}
	
	public ToolBar getToolBar()
	{
		return toolBar;
	}
	
	public class ImageModule
		extends JPanel
	{
		public JLabel imageLabel;
		
		public ImageModule()
		{
			imageLabel = new JLabel();
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			panel.setBackground(Color.white);
			panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0), BorderFactory.createLineBorder(Color.gray)));
			panel.add(imageLabel, BorderLayout.CENTER);
			
			setLayout(new BorderLayout());
			setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5));
			
			add(panel, BorderLayout.NORTH);
			add(Box.createHorizontalGlue(), BorderLayout.CENTER);
		}
		
		public void setImage(Icon image)
		{
			imageLabel.setIcon(image);
		}
	}
	
	public class ContentModule
		extends JPanel
	{
		public ContentModule()
		{
			setLayout(new BorderLayout());
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		}
		
		public void setContentPane(Component contentPane)
		{
			removeAll();
			
			add(contentPane, BorderLayout.CENTER);
			
			ContainerManager.update(this);
		}
	}
	
	public class ToolBar
		extends JPanel
	{
		public JClassicButton cancelButton;
		public JClassicButton previousButton;
		public JClassicButton nextButton;
		public JClassicButton confirmButton;
		
		public ToolBar()
		{
			add(Box.createHorizontalGlue());
			
			cancelButton = new JClassicButton("撤销", IconFactory.getSwingIcon("stereo/cancel_16.png"), "撤销");
			ActionListener cancelActionListener = new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					cancel();
				}
			};
			cancelButton.addActionListener(cancelActionListener);
			KeyStrokeManager.registerButtonToEscapeKey(cancelButton, cancelActionListener);
			add(cancelButton);
			
			add(Box.createHorizontalStrut(10));
			
			previousButton = new JClassicButton("上一步", IconFactory.getSwingIcon("stereo/arrow_backward_16.png"), "上一步");
			previousButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					previous();
				}
			}
			);
			add(previousButton);
			
			add(Box.createHorizontalStrut(5));
			
			nextButton = new JClassicButton("下一步", IconFactory.getSwingIcon("stereo/arrow_forward_16.png"), "下一步");
			nextButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					next();
				}
			}
			);
			add(nextButton);
			
			add(Box.createHorizontalStrut(10));
			
			confirmButton = new JClassicButton("完成", IconFactory.getSwingIcon("stereo/confirm_16.png"), "完成");
			ActionListener confirmActionListener = new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					confirm();
				}
			};
			confirmButton.addActionListener(confirmActionListener);
			KeyStrokeManager.registerButtonToEnterKey(confirmButton, confirmActionListener);
			add(confirmButton);
			
			add(Box.createHorizontalStrut(10));
			
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		}
	}
	
	public static JWizard getWizard(Component component)
	{
		if (component == null)
		{
			return null;
		}
		
		if (component instanceof JWizard)
		{
			return (JWizard) component;
		}
		
		Container parent = component.getParent();
		while (parent != null)
		{
			if (parent instanceof JWizard)
			{
				return (JWizard) parent;
			}
			parent = parent.getParent();
		}
		
		return null;
	}
}