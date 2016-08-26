package com.nepxion.cots.twaver.graph;

/**
 * <p>Title: Nepxion Cots For TWaver</p>
 * <p>Description: Nepxion Cots Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * <p>Announcement: It depends on the commercial software of TWaver, the repository only references the trial version.</p>
 * <p>If you want to use Nepxion Cots, please contact with Serva Corporation to buy the genuine version.</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.nepxion.cots.twaver.icon.TIconFactory;
import com.nepxion.cots.twaver.locale.TLocale;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.checkbox.JBasicCheckBox;
import com.nepxion.swing.combobox.JBasicComboBox;
import com.nepxion.swing.layout.table.TableLayout;

public class TLiteLayoutPanel
	extends JPanel
{
	private JLabel typeLabel;
	private JBasicComboBox typeComboBox;
	
	private JLabel gapLabel;
	private JSlider gapSlider;
	
	private JLabel animationLabel;
	private JBasicCheckBox animationCheckBox;
	
	private JBasicButton runButton;
	private JBasicButton stopButton;
	
	private TLiteLayouter liteLayouter;
	
	public TLiteLayoutPanel(final TGraph graph)
	{
		liteLayouter = new TLiteLayouter(graph);
				
		typeLabel = new JLabel(TLocale.getString("layout_type"));
		
		typeComboBox = new JBasicComboBox(new TLayoutType[] {TLayoutType.LITE_ORGANIC_LAYOUT_TYPE, TLayoutType.LITE_SMART_ORGANIC_LAYOUT_TYPE, TLayoutType.LITE_HIERARCHIC_LAYOUT_TYPE, TLayoutType.LITE_ORTHOGONAL_LAYOUT_TYPE, TLayoutType.LITE_CIRCULAR_LAYOUT_TYPE, TLayoutType.LITE_SINGLE_CYCLE_LAYOUT_TYPE, TLayoutType.LITE_TREE_LAYOUT_TYPE, /*TLayoutType.LITE_AR_TREE_LAYOUT_TYPE, TLayoutType.LITE_HV_TREE_LAYOUT_TYPE,*/ TLayoutType.LITE_BALLOON_TREE_LAYOUT_TYPE, TLayoutType.LITE_RANDOM_LAYOUT_TYPE});
		typeComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				doLayout(stopButton.isEnabled());
			}
		}
		);
				
		double size1[][] = 
		{
			{0.35, 0.65},
			{22}
		};
		
		JPanel layoutModePanel = new JPanel();
		layoutModePanel.setBorder(BorderManager.createComplexTitledBorder(TLocale.getString("layout_type_setting")));
		layoutModePanel.setLayout(new TableLayout(size1));
		layoutModePanel.add(typeLabel, "0, 0");
		layoutModePanel.add(typeComboBox, "1, 0");
		
		gapLabel = new JLabel(TLocale.getString("layout_gap"));
		
		gapSlider = new JSlider(TLiteLayouter.MINIMUM_GAP, TLiteLayouter.MAXIMUM_GAP, TLiteLayouter.DEFAULT_GAP);
		gapSlider.setToolTipText(gapSlider.getValue() + "");
		gapSlider.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				doLayout(stopButton.isEnabled());
				
				gapSlider.setToolTipText(gapSlider.getValue() + "");
			}
		}
		);
		
		animationLabel = new JLabel(TLocale.getString("layout_effect"));
		
		animationCheckBox = new JBasicCheckBox(TLocale.getString("layout_effect_animation"), true);
		
		double size2[][] = 
		{
			{0.35, 0.65},
			{22, 22}
		};
		
		JPanel layoutParamPanel = new JPanel();
		layoutParamPanel.setBorder(BorderManager.createComplexTitledBorder(TLocale.getString("layout_parameter_setting")));
		layoutParamPanel.setLayout(new TableLayout(size2));
		layoutParamPanel.add(gapLabel, "0, 0");
		layoutParamPanel.add(gapSlider, "1, 0");
		layoutParamPanel.add(animationLabel, "0, 1");
		layoutParamPanel.add(animationCheckBox, "1, 1");
		
		runButton = new JBasicButton(TLocale.getString("layout_run"), TIconFactory.getContextIcon("run.png"), TLocale.getString("layout_run_description"));
		runButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				doLayout(true);
				
				runButton.setEnabled(false);
				stopButton.setEnabled(true);
			}
		}
		);
		
		stopButton = new JBasicButton(TLocale.getString("layout_stop"), TIconFactory.getContextIcon("stop.png"), TLocale.getString("layout_stop_description"));
		stopButton.setEnabled(false);
		stopButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				runButton.setEnabled(true);
				stopButton.setEnabled(false);
			}
		}
		);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		buttonPanel.add(Box.createGlue());
		buttonPanel.add(runButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(Box.createGlue());
		
		ButtonManager.updateUI(buttonPanel, new Dimension(55, 25));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		add(layoutModePanel);
		add(layoutParamPanel);
		add(buttonPanel);
		
		typeComboBox.setSelectedIndex(0);
	}
	
	private void doLayout(boolean enabled)
	{
		if (enabled)
		{
			TLayoutType layoutType = (TLayoutType) typeComboBox.getSelectedItem();
			doLayout(layoutType);
		}
	}
	
	private void doLayout(TLayoutType layoutType)
	{
		if (layoutType.equals(TLayoutType.LITE_ORGANIC_LAYOUT_TYPE))
		{
			liteLayouter.doOrganicLayout(gapSlider.getValue(), animationCheckBox.isSelected());
		}
		else if (layoutType.equals(TLayoutType.LITE_SMART_ORGANIC_LAYOUT_TYPE))
		{
			liteLayouter.doSmartOrganicLayout(gapSlider.getValue(), animationCheckBox.isSelected());
		}
		else if (layoutType.equals(TLayoutType.LITE_HIERARCHIC_LAYOUT_TYPE))
		{
			liteLayouter.doHierarchicLayout(gapSlider.getValue(), animationCheckBox.isSelected());
		}
		else if (layoutType.equals(TLayoutType.LITE_ORTHOGONAL_LAYOUT_TYPE))
		{
			liteLayouter.doOrthogonalLayout(gapSlider.getValue(), animationCheckBox.isSelected());
		}
		else if (layoutType.equals(TLayoutType.LITE_CIRCULAR_LAYOUT_TYPE))
		{
			liteLayouter.doCircularLayout(animationCheckBox.isSelected());
		}
		else if (layoutType.equals(TLayoutType.LITE_SINGLE_CYCLE_LAYOUT_TYPE))
		{
			liteLayouter.doSingleCycleLayout(gapSlider.getValue(), animationCheckBox.isSelected());
		}
		else if (layoutType.equals(TLayoutType.LITE_TREE_LAYOUT_TYPE))
		{
			liteLayouter.doTreeLayout(gapSlider.getValue(), animationCheckBox.isSelected());
		}
		else if (layoutType.equals(TLayoutType.LITE_AR_TREE_LAYOUT_TYPE))
		{
			liteLayouter.doARTreeLayout(animationCheckBox.isSelected());
		}
		else if (layoutType.equals(TLayoutType.LITE_HV_TREE_LAYOUT_TYPE))
		{
			liteLayouter.doHVTreeLayout(animationCheckBox.isSelected());
		}
		else if (layoutType.equals(TLayoutType.LITE_BALLOON_TREE_LAYOUT_TYPE))
		{
			liteLayouter.doBalloonTreeLayout(gapSlider.getValue(), animationCheckBox.isSelected());
		}
		else if (layoutType.equals(TLayoutType.LITE_RANDOM_LAYOUT_TYPE))
		{
			liteLayouter.doRandomLayout(animationCheckBox.isSelected());
		}
	}
}