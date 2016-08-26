package com.nepxion.swing.style.checkbox.lite;

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

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.icon.paint.CheckBoxIcon;
import com.nepxion.swing.style.button.IButtonStyle;
import com.nepxion.swing.style.button.IButtonUI;
import com.nepxion.swing.style.button.lite.ILiteButtonStyle;
import com.nepxion.swing.style.checkbox.AbstractCheckBoxUI;

public class LiteCheckBoxUI
	extends AbstractCheckBoxUI implements IButtonUI
{
	/**
	 * The check box theme of plastic.
	 */
	public static final String CHECKBOX_THEME_PLASTIC = "theme/checkbox/plastic/";
	
	/**
	 * The check box theme of nimbus.
	 */
	public static final String CHECKBOX_THEME_NIMBUS = "theme/checkbox/nimbus/";
	
	/**
	 * The check box theme string.
	 */
	private String checkBoxTheme = CHECKBOX_THEME_PLASTIC;
	
	/**
	 * The lite button style.
	 */
	protected ILiteButtonStyle buttonStyle;
	
	/**
	 * Constructs with the specified initial button style.
	 * @param buttonStyle the instance of IButtonStyle
	 */
	public LiteCheckBoxUI(String checkBoxTheme, IButtonStyle buttonStyle)
	{
		this.checkBoxTheme = checkBoxTheme;
		
		setButtonStyle(buttonStyle);
	}
	
	/**
	 * Gets the button style.
	 * @return the instance of IButtonStyle
	 */
	public IButtonStyle getButtonStyle()
	{
		return buttonStyle;
	}
	
	/**
	 * Sets the button style.
	 * @param buttonStyle the instance of IButtonStyle
	 */
	public void setButtonStyle(IButtonStyle buttonStyle)
	{
		this.buttonStyle = (ILiteButtonStyle) buttonStyle;
		
		armedIcon = new CheckBoxIcon(IconFactory.getSwingIcon(checkBoxTheme + "checkbox_lower.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getCheckFocusColor(), false, true, checkBoxTheme.equals(CHECKBOX_THEME_PLASTIC));
		pressedIcon = new CheckBoxIcon(IconFactory.getSwingIcon(checkBoxTheme + "checkbox_lower.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getCheckFocusColor(), false, true, checkBoxTheme.equals(CHECKBOX_THEME_PLASTIC));
		rolloverIcon = new CheckBoxIcon(IconFactory.getSwingIcon(checkBoxTheme + "checkbox_raised.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getCheckFocusColor(), false, true, checkBoxTheme.equals(CHECKBOX_THEME_PLASTIC));
		disableIcon = new CheckBoxIcon(IconFactory.getSwingIcon(checkBoxTheme + "checkbox_disable.png"), Color.gray, null, false, false, checkBoxTheme.equals(CHECKBOX_THEME_PLASTIC));
		normalIcon = new CheckBoxIcon(IconFactory.getSwingIcon(checkBoxTheme + "checkbox_normal.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getCheckFocusColor(), false, false, checkBoxTheme.equals(CHECKBOX_THEME_PLASTIC));
		
		selectionArmedIcon = new CheckBoxIcon(IconFactory.getSwingIcon(checkBoxTheme + "checkbox_lower.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getCheckFocusColor(), true, true, checkBoxTheme.equals(CHECKBOX_THEME_PLASTIC));
		selectionPressedIcon = new CheckBoxIcon(IconFactory.getSwingIcon(checkBoxTheme + "checkbox_lower.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getCheckFocusColor(), true, true, checkBoxTheme.equals(CHECKBOX_THEME_PLASTIC));
		selectionRolloverIcon = new CheckBoxIcon(IconFactory.getSwingIcon(checkBoxTheme + "checkbox_raised.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getCheckFocusColor(), true, true, checkBoxTheme.equals(CHECKBOX_THEME_PLASTIC));
		selectionDisableIcon = new CheckBoxIcon(IconFactory.getSwingIcon(checkBoxTheme + "checkbox_disable.png"), Color.gray, null, true, false, checkBoxTheme.equals(CHECKBOX_THEME_PLASTIC));
		selectionNormalIcon = new CheckBoxIcon(IconFactory.getSwingIcon(checkBoxTheme + "checkbox_normal.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getCheckFocusColor(), true, false, checkBoxTheme.equals(CHECKBOX_THEME_PLASTIC));
	}
}