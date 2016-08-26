package com.nepxion.demo.swing.border;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.*;
import javax.swing.border.*;

import com.nepxion.swing.border.*;

public class DemoButtonBorderPanel
    extends JPanel
{
    public DemoButtonBorderPanel(int borderType)
    {
        setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2), new ButtonBorder(borderType)));
    }
}
