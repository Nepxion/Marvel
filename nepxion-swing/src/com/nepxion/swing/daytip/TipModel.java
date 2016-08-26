package com.nepxion.swing.daytip;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.Collection;

import com.l2fprod.common.swing.tips.DefaultTipModel;

public class TipModel
    extends DefaultTipModel
{
	/**
	 * Constructs with the default.
	 */
    public TipModel()
    {
        super();
    }

    /**
     * Constructs with the specified initial tip array.
     * @param tips the tip array
     */
    public TipModel(TipModel.Tip[] tips)
    {
        super(tips);
    }

    /**
     * Constructs with the specified initial tip list.
     * @param tips the instance of Collection
     */
    public TipModel(Collection tips)
    {
        super(tips);
    }
}