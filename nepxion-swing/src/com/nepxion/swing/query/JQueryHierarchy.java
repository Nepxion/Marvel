package com.nepxion.swing.query;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import com.nepxion.swing.framework.dockable.JDockable;
import com.nepxion.swing.framework.dockable.JDockableView;
import com.nepxion.swing.framework.dockable.JDockableHierarchy;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.query.condition.JQueryCondition;
import com.nepxion.swing.query.result.JQueryResult;

public class JQueryHierarchy
	extends JDockableHierarchy
{
	/**
	 * The query condition title string.
	 */
	public static final String QUERY_CONDITION_TITLE = SwingLocale.getString("query_condition");
	
	/**
	 * The query result title string.
	 */
	public static final String QUERY_RESULT_TITLE = SwingLocale.getString("query_result");
	
	/**
	 * The instance of JQueryCondition.
	 */
	private JQueryCondition queryCondition;
	
	/**
	 * The instance of JQueryResult.
	 */
	private JQueryResult queryResult;
	
	/**
	 * Constructs with the default.
	 */
	public JQueryHierarchy()
	{
		initContentPane();
		initBar();
	}
	
	/**
	 * Initializes the content pane.
	 */
	private void initContentPane()
	{
		queryCondition = new JQueryCondition();
		queryResult = new JQueryResult();
		
		JDockableView queryConditionView = new JDockableView(QUERY_CONDITION_TITLE, IconFactory.getSwingIcon("edit.png"), QUERY_CONDITION_TITLE, queryCondition);
		JDockableView queryResultView = new JDockableView(QUERY_RESULT_TITLE, IconFactory.getSwingIcon("query.png"), QUERY_RESULT_TITLE, queryResult);
		
		queryConditionView.setClosable(false);
		queryResultView.setClosable(false);
		
		JDockable dockable = new JDockable();
		dockable.setOrientation(JDockable.HORIZONTAL_SPLIT);
		dockable.add(queryConditionView, JDockable.FLEXIBLE);
		dockable.add(queryResultView, JDockable.VARY);
		
		QueryManager.setPreferenceStyle(dockable);
		
		getDockableContainer().setContentPane(dockable);
	}
	
	/**
	 * Initializes the bar.
	 */
	private void initBar()
	{
		getBarContainer().setVisible(false);
		getStatusBarContainer().setVisible(false);
	}
	
	/**
	 * Gets the query condition.
	 * @return the instance of JQueryCondition
	 */
	public JQueryCondition getQueryCondition()
	{
		return queryCondition;
	}
	
	/**
	 * Gets the query result.
	 * @return the instance of JQueryResult
	 */
	public JQueryResult getQueryResult()
	{
		return queryResult;
	}
}