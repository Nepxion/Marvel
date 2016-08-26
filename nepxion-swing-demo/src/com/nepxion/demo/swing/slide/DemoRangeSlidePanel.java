package com.nepxion.demo.swing.slide;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import com.nepxion.swing.slider.*;

public class DemoRangeSlidePanel
    extends JPanel implements SwingConstants
{
    public DemoRangeSlidePanel()
    {
        RangeSlidePanel rangeSlidePanel = new RangeSlidePanel();
        rangeSlidePanel.rangeSlider.setPaintTicks(true);
        rangeSlidePanel.rangeSlider.setPaintLabels(false);
        rangeSlidePanel.rangeSlider.setPaintTrack(true);
        rangeSlidePanel.rangeSlider.setOrientation(SwingConstants.HORIZONTAL);

        RangeSlidePanel rangeSlidePane2 = new RangeSlidePanel();
        rangeSlidePane2.rangeSlider.setPaintTicks(true);
        rangeSlidePane2.rangeSlider.setPaintLabels(true);
        rangeSlidePane2.rangeSlider.setPaintTrack(true);
        rangeSlidePane2.rangeSlider.setOrientation(VERTICAL);

        add(rangeSlidePanel);
        add(rangeSlidePane2);
    }

    public class RangeSlidePanel
        extends JPanel
    {
        public JRangeSlider rangeSlider;

        public RangeSlidePanel()
        {
            final JTextField minField = new JTextField();
            final JTextField maxField = new JTextField();
            rangeSlider = new JRangeSlider(0, 100, 10, 90);
            rangeSlider.setPaintTicks(true);
            rangeSlider.setMajorTickSpacing(10);
            rangeSlider.addChangeListener(new ChangeListener()
            {
                public void stateChanged(ChangeEvent e)
                {
                    minField.setText("" + rangeSlider.getLowValue());
                    maxField.setText("" + rangeSlider.getHighValue());
                }
            }
            );

            minField.setText("" + rangeSlider.getLowValue());
            maxField.setText("" + rangeSlider.getHighValue());

            JPanel minPanel = new JPanel(new BorderLayout());
            minPanel.add(new JLabel("Min"), BorderLayout.BEFORE_FIRST_LINE);
            minField.setEditable(false);
            minPanel.add(minField);

            JPanel maxPanel = new JPanel(new BorderLayout());
            maxPanel.add(new JLabel("Max", SwingConstants.TRAILING), BorderLayout.BEFORE_FIRST_LINE);
            maxField.setEditable(false);
            maxPanel.add(maxField);

            JPanel textFieldPanel = new JPanel(new GridLayout(1, 3));
            textFieldPanel.add(minPanel);
            textFieldPanel.add(new JPanel());
            textFieldPanel.add(maxPanel);

            setLayout(new BorderLayout());
            add(rangeSlider, BorderLayout.CENTER);
            add(textFieldPanel, BorderLayout.AFTER_LAST_LINE);
        }
    }
}
