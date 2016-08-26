package com.nepxion.swing.tree.xml;


/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

public class Dom4JBasicTreeParser
	implements Dom4JTreeConstants
{
	public static final int DEFAULT_MODE_ICON = 1;
	public static final String DEFAULT_EXTENSION_NAME = ".png";
	
	protected String indexTag;
	protected String nameTag;
	protected String textTag;
	protected String iconTag;
	protected String toolTipTextTag;
	protected String classTag;
	
	protected int iconFolderMode;
	protected String iconExtensionName;
	
	public Dom4JBasicTreeParser()
	{
		this(DEFAULT_MODE_ICON);
	}
	
	public Dom4JBasicTreeParser(String iconExtensionName)
	{
		this(DEFAULT_MODE_ICON, iconExtensionName);
	}
	
	public Dom4JBasicTreeParser(int iconFolderMode)
	{
		this(iconFolderMode, null);
	}
	
	public Dom4JBasicTreeParser(int iconFolderMode, String iconExtensionName)
	{
		this(TAG_INDEX, TAG_NAME, TAG_TEXT, TAG_ICON, TAG_TOOL_TIP_TEXT, TAG_CLASS, iconFolderMode, iconExtensionName);
	}
	
	public Dom4JBasicTreeParser(String indexTag, String nameTag, String textTag, String iconTag, String toolTipTextTag, String classTag, int iconFolderMode, String iconExtensionName)
	{
		this.indexTag = indexTag;
		this.nameTag = nameTag;
		this.textTag = textTag;
		this.iconTag = iconTag;
		this.toolTipTextTag = toolTipTextTag;
		this.classTag = classTag;
		
		this.iconFolderMode = iconFolderMode;
		this.iconExtensionName = iconExtensionName;
	}
	
	public String getIndexTag()
	{
		return indexTag;
	}
	
	public void setIndexTag(String indexTag)
	{
		this.indexTag = indexTag;
	}
	
	public String getNameTag()
	{
		return nameTag;
	}
	
	public void setNameTag(String nameTag)
	{
		this.nameTag = nameTag;
	}
	
	public String getTextTag()
	{
		return textTag;
	}
	
	public void setTextTag(String textTag)
	{
		this.textTag = textTag;
	}
	
	public String getIconTag()
	{
		return iconTag;
	}
	
	public void setIconTag(String iconTag)
	{
		this.iconTag = iconTag;
	}
	
	public String getToolTipTextTag()
	{
		return toolTipTextTag;
	}
	
	public void setToolTipTextTag(String toolTipTextTag)
	{
		this.toolTipTextTag = toolTipTextTag;
	}
	
	public String getClassTag()
	{
		return classTag;
	}
	
	public void setClassTag(String classTag)
	{
		this.classTag = classTag;
	}
	
	public int getIconFolderMode()
	{
		return iconFolderMode;
	}
	
	public void setIconFolderMode(int iconFolderMode)
	{
		this.iconFolderMode = iconFolderMode;
	}
	
	public String getIconExtensionName()
	{
		return iconExtensionName;
	}
	
	public void setIconExtensionName(String iconExtensionName)
	{
		this.iconExtensionName = iconExtensionName;
	}
}