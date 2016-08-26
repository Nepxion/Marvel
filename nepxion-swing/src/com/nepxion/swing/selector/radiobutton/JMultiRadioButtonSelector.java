package com.nepxion.swing.selector.radiobutton;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.nepxion.swing.button.ButtonFocusListener;
import com.nepxion.swing.button.JClassicButton;
import com.nepxion.swing.dialog.JBasicDialog;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.keystroke.KeyStrokeManager;
import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.list.JBasicList;
import com.nepxion.swing.locale.SwingLocale;

public class JMultiRadioButtonSelector
	extends JBasicDialog
{
	private JMultiRadioButtonListPanel radioButtonListPanel;
	
	private List allElementNodes;
	
	private boolean isConfirmed;
	
	public JMultiRadioButtonSelector(Frame owner, String title)
	{
		this(owner, title, new Dimension(350, 320));
	}
	
	public JMultiRadioButtonSelector(Dialog owner, String title)
	{
		this(owner, title, new Dimension(350, 320));
	}
	
	public JMultiRadioButtonSelector(Frame owner, String title, Dimension dimension)
	{
		this(owner, title, dimension, null);
	}
	
	public JMultiRadioButtonSelector(Dialog owner, String title, Dimension dimension)
	{
		this(owner, title, dimension, null);
	}
	
	public JMultiRadioButtonSelector(Frame owner, String title, List allElementNodes)
	{
		this(owner, title, new Dimension(350, 320), allElementNodes);
	}
	
	public JMultiRadioButtonSelector(Dialog owner, String title, List allElementNodes)
	{
		this(owner, title, new Dimension(350, 320), allElementNodes);
	}
	
	public JMultiRadioButtonSelector(Frame owner, String title, Dimension dimension, List allElementNodes)
	{
		super(owner, title, dimension, true, false, true);
		
		this.allElementNodes = allElementNodes;
		
		initComponents();
	}
	
	public JMultiRadioButtonSelector(Dialog owner, String title, Dimension dimension, List allElementNodes)
	{
		super(owner, title, dimension, true, false, true);
		
		this.allElementNodes = allElementNodes;
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		radioButtonListPanel = new JMultiRadioButtonListPanel(allElementNodes);
		
		JClassicButton confirmButton = new JClassicButton(SwingLocale.getString("yes"), IconFactory.getSwingIcon("stereo/confirm_16.png"), SwingLocale.getString("yes"));
		ActionListener confirmActionListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{				
				setVisible(false);
				isConfirmed = true;
			}
		};
		confirmButton.addFocusListener(new ButtonFocusListener(this));
		confirmButton.addActionListener(confirmActionListener);
		KeyStrokeManager.registerButtonToEnterKey(confirmButton, confirmActionListener);
		
		final JClassicButton cancelButton = new JClassicButton(SwingLocale.getString("no"), IconFactory.getSwingIcon("stereo/cancel_16.png"), SwingLocale.getString("no"));
		ActionListener cancelActionListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				isConfirmed = false;
			}
		};
		cancelButton.addFocusListener(new ButtonFocusListener(this));
		cancelButton.addActionListener(cancelActionListener);
		KeyStrokeManager.registerButtonToEscapeKey(cancelButton, cancelActionListener);
		
		double[][] size = 
		{ 
			{TableLayout.FILL, TableLayout.PREFERRED, 5, TableLayout.PREFERRED, TableLayout.FILL}, 
			{TableLayout.FILL, 5, 30}
		};
		
		JPanel panel = new JPanel();
		panel.setLayout(new TableLayout(size));
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.add(radioButtonListPanel, "0, 0, 4, 0");
		panel.add(confirmButton, "1, 2");
		panel.add(cancelButton, "3, 2");
		
		Container container = getContentPane();
		container.add(panel);
	}
	
	public JMultiRadioButtonListPanel getRadioButtonListPanel()
	{
		return radioButtonListPanel;
	}
	
	public JBasicList getRadioButtonList()
	{
		return radioButtonListPanel.getList();
	}
	
	public List getAllElementNodes()
	{
		return radioButtonListPanel.getAllElementNodes();
	}
	
	public boolean isConfirmed()
	{
		return isConfirmed;
	}
}