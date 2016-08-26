package com.nepxion.swing.wizard;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.nepxion.util.data.CollectionUtil;

public class WizardModel
{
	private List steps = new ArrayList();
	
	public WizardModel()
	{
	}
	
	public WizardModel(JStep[] steps)
	{
		this(CollectionUtil.parseList(steps));
	}
	
	public WizardModel(Collection steps)
	{
		this.steps.addAll(steps);
	}
	
	public void add(JStep step)
	{
		steps.add(step);
	}
	
	public void remove(JStep step)
	{
		steps.remove(step);
	}
	
	public JStep getStepAt(int index)
	{
		return (JStep) steps.get(index);
	}
	
	public JStep[] getSteps()
	{
		return (JStep[]) steps.toArray(new JStep[steps.size()]);
	}
	
	public void setSteps(JStep[] steps)
	{
		this.steps.clear();
		this.steps.addAll(CollectionUtil.parseList(steps));
	}
	
	public int getStepCount()
	{
		return steps.size();
	}
}