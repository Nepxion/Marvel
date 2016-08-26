package com.nepxion.swing.style.menu.lite;

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
import com.nepxion.swing.style.menu.AbstractCheckBoxMenuItemUI;

public class LiteCheckBoxMenuItemUI
	extends AbstractCheckBoxMenuItemUI implements IButtonUI
{
	/**
	 * The plastic style value.
	 */
	public static final String PLASTIC_STYLE = "theme/checkbox/plastic/";
	
	/**
	 * The nimbus style value.
	 */
	public static final String NIMBUS_STYLE = "theme/checkbox/nimbus/";
	
	/**
	 * The lite button style.
	 */
	protected ILiteButtonStyle buttonStyle;
	
	/**
	 * Constructs with the specified initial button style.
	 * @param buttonStyle the instance of IButtonStyle
	 */
	public LiteCheckBoxMenuItemUI(IButtonStyle buttonStyle)
	{
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
		
		armedIcon = new CheckBoxIcon(IconFactory.getSwingIcon(PLASTIC_STYLE + "checkbox_lower.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getCheckFocusColor(), false, true, false);
		pressedIcon = new CheckBoxIcon(IconFactory.getSwingIcon(PLASTIC_STYLE + "checkbox_lower.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getCheckFocusColor(), false, true, false);
		rolloverIcon = new CheckBoxIcon(IconFactory.getSwingIcon(PLASTIC_STYLE + "checkbox_raised.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getCheckFocusColor(), false, true, false);
		disableIcon = new CheckBoxIcon(IconFactory.getSwingIcon(PLASTIC_STYLE + "checkbox_disable.png"), Color.gray, null, false, false, false);
		normalIcon = new CheckBoxIcon(IconFactory.getSwingIcon(PLASTIC_STYLE + "checkbox_raised.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getCheckFocusColor(), false, false, false);
		
		selectionArmedIcon = new CheckBoxIcon(IconFactory.getSwingIcon(PLASTIC_STYLE + "checkbox_lower.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getCheckFocusColor(), true, true, false);
		selectionPressedIcon = new CheckBoxIcon(IconFactory.getSwingIcon(PLASTIC_STYLE + "checkbox_lower.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getCheckFocusColor(), true, true, false);
		selectionRolloverIcon = new CheckBoxIcon(IconFactory.getSwingIcon(PLASTIC_STYLE + "checkbox_raised.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getCheckFocusColor(), true, true, false);
		selectionDisableIcon = new CheckBoxIcon(IconFactory.getSwingIcon(PLASTIC_STYLE + "checkbox_disable.png"), Color.gray, null, true, false, false);
		selectionNormalIcon = new CheckBoxIcon(IconFactory.getSwingIcon(PLASTIC_STYLE + "checkbox_raised.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getCheckFocusColor(), true, false, false);
	}
}