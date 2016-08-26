package com.nepxion.swing.searcher.gis.google.loc;

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
import java.awt.Dimension;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.combobox.JBasicComboBox;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.layout.toolbar.ToolBarLayout;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.textfield.JBasicTextField;
import com.nepxion.util.locale.LocaleConstants;

public class JCellPanel
	extends JPanel
{
	/**
	 * The cell id text field.
	 */
	private JBasicTextField cellIDTextField;
	
	/**
	 * The lac text field.
	 */	
	private JBasicTextField lacTextField;
	
	/**
	 * The mcc text field.
	 */	
	private JBasicTextField mccTextField;
	
	/**
	 * The mnc text field.
	 */	
	private JBasicTextField mncTextField;
	
	/**
	 * The language combo box.
	 */	
	private JBasicComboBox languageComboBox;
	
	/**
	 * The loc table.
	 */
	private JLocTable table;
	
	/**
	 * Constructs with the default.
	 */
	public JCellPanel()
	{
		table = new JLocTable();
		
		setLayout(new BorderLayout());
		add(new ToolBar(), BorderLayout.NORTH);
		add(new JBasicScrollPane(table), BorderLayout.CENTER);
	}
	
	public class ToolBar
		extends JPanel
	{
		/**
		 * Constructs with the default.
		 */
		public ToolBar()
		{
			setLayout(new ToolBarLayout());
			setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
			
			cellIDTextField = new JBasicTextField();
			DimensionManager.setDimension(cellIDTextField, new Dimension(100, 23));
			
			lacTextField = new JBasicTextField();
			DimensionManager.setDimension(lacTextField, new Dimension(100, 23));
			
			mccTextField = new JBasicTextField();
			DimensionManager.setDimension(mccTextField, new Dimension(100, 23));
			
			mncTextField = new JBasicTextField();
			DimensionManager.setDimension(mncTextField, new Dimension(100, 23));
			
			Locale[] locales = LocaleConstants.LOCALE_LIST;
			ElementNode[] elementNodes = new ElementNode[locales.length];
			for (int i = 0; i < locales.length; i++)
			{
				Locale locale = locales[i];
				String text = SwingLocale.getString(locale.toString().toLowerCase());				
				elementNodes[i] = new ElementNode(text, null, text, locale);
			}
			
			languageComboBox = new JBasicComboBox(elementNodes);			
			DimensionManager.setDimension(languageComboBox, new Dimension(90, 23));
			
			JBasicButton searchButton = new JBasicButton(LocController.getSearchAction(JCellPanel.this));
			JBasicButton clearButton = new JBasicButton(LocController.getClearAction(table));
			
			add(new JLabel(SwingLocale.getString("cell_id")));
			add(cellIDTextField);
			
			add(Box.createHorizontalStrut(5));
			add(new JLabel(SwingLocale.getString("lac")));
			add(lacTextField);
			
			add(Box.createHorizontalStrut(5));
			add(new JLabel(SwingLocale.getString("mcc")));
			add(mccTextField);
			
			add(Box.createHorizontalStrut(5));
			add(new JLabel(SwingLocale.getString("mnc")));
			add(mncTextField);
			
			add(Box.createHorizontalStrut(5));
			add(new JLabel(SwingLocale.getString("language")));
			add(languageComboBox);
			
			add(searchButton);
			add(clearButton);
			
			add(Box.createHorizontalGlue());
			
			ButtonManager.updateUI(this);
		}
	}
	
	/**
	 * Gets the loc table.
	 * @return the instance of JLocTable
	 */
	public JLocTable getLocTable()
	{
		return table;
	}
	
	/**
	 * Gets the cell id.
	 * @return the cell id value
	 */
	public int getCellID()
	{
		return Integer.parseInt(cellIDTextField.getText());
	}
	
	/**
	 * Sets the cell id.
	 * @param cellID the cell id value
	 */
	public void setCellID(int cellID)
	{
		cellIDTextField.setText(cellID + "");
	}
	
	/**
	 * Gets the lac.
	 * @return the lac value
	 */
	public int getLac()
	{
		return Integer.parseInt(lacTextField.getText());
	}
	
	/**
	 * Sets the lac.
	 * @param lac the lac value
	 */
	public void setLac(int lac)
	{
		lacTextField.setText(lac + "");
	}
	
	/**
	 * Gets the mcc.
	 * @return the mcc value
	 */
	public int getMcc()
	{
		return Integer.parseInt(mccTextField.getText());
	}
	
	/**
	 * Sets the mcc.
	 * @param mcc the mcc value
	 */
	public void setMcc(int mcc)
	{
		mccTextField.setText(mcc + "");
	}
	
	/**
	 * Gets the mnc.
	 * @return the mnc value
	 */
	public int getMnc()
	{
		return Integer.parseInt(mncTextField.getText());
	}
	
	/**
	 * Sets the mnc.
	 * @param mnc the mnc value
	 */
	public void setMnc(int mnc)
	{
		mncTextField.setText(mnc + "");
	}
	
	/**
	 * Gets the language.
	 * @return the language string 
	 */
	public String getLanguage()
	{
		ElementNode selectedElementNode = (ElementNode) languageComboBox.getSelectedItem();
		Locale locale = (Locale) selectedElementNode.getUserObject();
		
		return locale.toString();
	}
	
	/**
	 * Set the language.
	 * @param language the language string
	 */
	public void setLanguage(String language)
	{
		for (int i = 0; i < languageComboBox.getItemCount(); i++)
		{
			ElementNode selectedElementNode = (ElementNode) languageComboBox.getItemAt(i);
			Locale locale = (Locale) selectedElementNode.getUserObject();
			if (locale.toString().equals(language))
			{
				languageComboBox.setSelectedIndex(i);
				
				return;
			}	
		}
	}
}