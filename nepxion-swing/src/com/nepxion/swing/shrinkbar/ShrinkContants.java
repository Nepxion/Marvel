package com.nepxion.swing.shrinkbar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.swing.style.texture.shrink.IHeaderTextureStyle;
import com.nepxion.swing.style.texture.shrink.IOutlookTextureStyle;
import com.nepxion.swing.style.texture.shrink.JBlackHeaderTextureStyle;
import com.nepxion.swing.style.texture.shrink.JGreenOutlookTextureStyle;

public interface ShrinkContants
{
	public static final int PLACEMENT_EAST = 0;
	public static final int PLACEMENT_WEST = 1;
	
	public static final int CONTENT_PANE_TYPE_LABEL = 2;
	public static final int CONTENT_PANE_TYPE_TOOLBAR = 3;
	
	public static final int DEFAULT_CONTENT_PANE_TYPE = CONTENT_PANE_TYPE_LABEL;
	
	public static final IHeaderTextureStyle DEFAULT_HEADER_TEXTURE_STYLE = new JBlackHeaderTextureStyle();
	public static final IOutlookTextureStyle DEFAULT_OUTLOOK_TEXTURE_STYLE = new JGreenOutlookTextureStyle();
}