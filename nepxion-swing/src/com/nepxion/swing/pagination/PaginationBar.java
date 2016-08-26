package com.nepxion.swing.pagination;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicLabelUI;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.combobox.JBasicComboBox;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.textfield.number.JNumberTextField;
import com.nepxion.swing.tip.balloon.JBalloonTip;

public abstract class PaginationBar
	extends JPanel
{
	/**
	 * 
	 */
	private JLabel currentPageIndexLabel; // 第X页
	private JLabel currentPageRowCountLabel; // 当前页有X条
	
	private JLabel totalPageCountLabel; // 共X页
	private JLabel totalRowCountLabel; // 总共X条
	private JLabel maxPageRowCountLabel; // 每页X条
	
	private JBasicButton firstPageButton;
	private JBasicButton backwardPageButton;
	private JBasicButton forwardPageButton;
	private JBasicButton lastPageButton;
	
	private JNumberTextField pageIndexDirectTextField; // 跳转到第X页
	private JBasicButton pageIndexDirectButton;
	
	private JNumberTextField maxPageRowCountDirectTextField; // 每页X条
	private JBasicButton maxPageRowCountDirectButton;
	
	private JBasicComboBox sortNameComboBox; // 排序名称
	private JBasicComboBox sortTypeComboBox; // 排序方式 ：升序/降序
	private JBasicButton submitSortButton;
	
	private JTable table;
	private JList list;
	
	private JPanel pageInfoPanel;
	private JPanel pageButtonPanel;
	private JPanel pageIndexDirectPanel;
	private JPanel maxPageRowCountDirectPanel;
	private JPanel sortPanel;
	
	private PaginationContext paginationContext;
	
	public PaginationBar(JTable table)
	{
		this(table, null);
	}
	
	public PaginationBar(JList list)
	{
		this(list, null);
	}
	
	public PaginationBar(JTable table, PaginationContext context)
	{
		this(context);
		
		this.table = table;
	}
	
	public PaginationBar(JList list, PaginationContext context)
	{
		this(context);
		
		this.list = list;
	}
	
	public PaginationBar(PaginationContext context)
	{
		currentPageIndexLabel = createLabel("");
		currentPageRowCountLabel = createLabel("");
		
		totalPageCountLabel = createLabel("");
		totalRowCountLabel = createLabel("");
		
		maxPageRowCountLabel = createLabel("");
		
		firstPageButton = new JBasicButton(IconFactory.getSwingIcon("stereo/control_top_16.png"), SwingLocale.getString("first_page"));
		firstPageButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				boolean isValidation = paginationContext.isValidation();
				int currentPageIndex = paginationContext.getCurrentPageIndex();
				if (isValidation && currentPageIndex == 1)
				{					
					JBasicOptionPane.showMessageDialog(HandleManager.getFrame(PaginationBar.this), SwingLocale.getString("first_page_description"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
					
					return;
				}
				try
				{
					clearRowDatas();
					paginationContext.setPageIndex(1);
					directRowIndex(paginationContext.getRowIndex());
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
		);
		
		backwardPageButton = new JBasicButton(IconFactory.getSwingIcon("stereo/arrow_backward_16.png"), SwingLocale.getString("backward_page"));
		backwardPageButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				boolean isValidation = paginationContext.isValidation();
				int currentPageIndex = paginationContext.getCurrentPageIndex();
				if (isValidation && currentPageIndex == 1)
				{
					JBasicOptionPane.showMessageDialog(HandleManager.getFrame(PaginationBar.this), SwingLocale.getString("first_page_description"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
					
					return;
				}
				try
				{
					clearRowDatas();
					paginationContext.setPageIndex(currentPageIndex - 1);
					directRowIndex(paginationContext.getRowIndex());
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
		);
		
		forwardPageButton = new JBasicButton(IconFactory.getSwingIcon("stereo/arrow_forward_16.png"), SwingLocale.getString("forward_page"));
		forwardPageButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				boolean isValidation = paginationContext.isValidation();
				int currentPageIndex = paginationContext.getCurrentPageIndex();
				int totalPageCount = paginationContext.getTotalPageCount();
				if (isValidation && currentPageIndex == totalPageCount)
				{
					JBasicOptionPane.showMessageDialog(HandleManager.getFrame(PaginationBar.this), SwingLocale.getString("last_page_description"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
					
					return;
				}
				try
				{
					clearRowDatas();
					paginationContext.setPageIndex(currentPageIndex + 1);
					directRowIndex(paginationContext.getRowIndex());
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
		);
		
		lastPageButton = new JBasicButton(IconFactory.getSwingIcon("stereo/control_bottom_16.png"), SwingLocale.getString("last_page"));
		lastPageButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				boolean isValidation = paginationContext.isValidation();
				int currentPageIndex = paginationContext.getCurrentPageIndex();
				int totalPageCount = paginationContext.getTotalPageCount();
				if (isValidation && currentPageIndex == totalPageCount)
				{
					JBasicOptionPane.showMessageDialog(HandleManager.getFrame(PaginationBar.this), SwingLocale.getString("last_page_description"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
					
					return;
				}
				try
				{
					clearRowDatas();
					paginationContext.setPageIndex(totalPageCount);
					directRowIndex(paginationContext.getRowIndex());
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
		);
		
		pageIndexDirectTextField = new JNumberTextField(1);
		setPageIndexDirectTextFieldWidth(35);
		pageIndexDirectButton = new JBasicButton(IconFactory.getSwingIcon("stereo/control_go_16.png"), SwingLocale.getString("submit"));
		pageIndexDirectButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int pageIndexDirect = -1;
				try
				{
					pageIndexDirect = Integer.parseInt(pageIndexDirectTextField.getText());
				}
				catch (NumberFormatException ex)
				{
					pageIndexDirectTextField.showTip(SwingLocale.getString("invalid_page_count"), JBalloonTip.TIP_ICON_ERROR_MESSAGE, 1, 9);
					
					return;
				}
				
				boolean isValidation = paginationContext.isValidation();
				int currentPageIndex = paginationContext.getCurrentPageIndex();
				int totalPageCount = paginationContext.getTotalPageCount();
				
				if (pageIndexDirect > totalPageCount)
				{
					pageIndexDirectTextField.showTip(SwingLocale.getString("page_count_not_more_than") + totalPageCount, JBalloonTip.TIP_ICON_ERROR_MESSAGE, 2, 12);
					
					return;
				}
				
				if (isValidation && currentPageIndex == pageIndexDirect)
				{
					return;
				}
				try
				{
					clearRowDatas();
					paginationContext.setPageIndex(pageIndexDirect);
					directRowIndex(paginationContext.getRowIndex());
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
		);
		
		maxPageRowCountDirectTextField = new JNumberTextField(1);
		setMaxPageRowCountDirectTextFieldWidth(35);
		maxPageRowCountDirectButton = new JBasicButton(IconFactory.getSwingIcon("stereo/control_go_16.png"), SwingLocale.getString("submit"));
		maxPageRowCountDirectButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int maxPageRowCountDirect = -1;
				try
				{
					maxPageRowCountDirect = Integer.parseInt(maxPageRowCountDirectTextField.getText());
				}
				catch (NumberFormatException e1)
				{
					maxPageRowCountDirectTextField.showTip(SwingLocale.getString("item_count_not_null"));
					
					return;
				}
				
				boolean isValidation = paginationContext.isValidation();
				int totalRowCount = paginationContext.getTotalRowCount();
				
				if (maxPageRowCountDirect > totalRowCount)
				{
					maxPageRowCountDirectTextField.showTip(SwingLocale.getString("item_count_not_more_than") + totalRowCount);
					
					return;
				}
				
				try
				{
					clearRowDatas();
					paginationContext.setPageIndex(1);
					paginationContext.setRowCount(maxPageRowCountDirect);
					directRowCount(maxPageRowCountDirect);
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
		);
		
		sortNameComboBox = new JBasicComboBox();
		setSortNameComboBoxWidth(60);
		
		List sortTypeList = new ArrayList();
		
		ElementNode ascSortType = new ElementNode();
		ascSortType.setName("asc");
		ascSortType.setText(SwingLocale.getString("asc"));
		sortTypeList.add(ascSortType);
		
		ElementNode descSortType = new ElementNode();
		descSortType.setName("desc");
		descSortType.setText(SwingLocale.getString("desc"));
		sortTypeList.add(descSortType);
		
		sortTypeComboBox = new JBasicComboBox(sortTypeList.toArray());
		setSortTypeComboBoxWidth(60);
		
		submitSortButton = new JBasicButton(IconFactory.getSwingIcon("stereo/control_go_16.png"), SwingLocale.getString("submit"));
		submitSortButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				boolean isValidation = paginationContext.isValidation();
				ElementNode sortName = (ElementNode) sortNameComboBox.getSelectedItem();
				ElementNode sortType = (ElementNode) sortTypeComboBox.getSelectedItem();
				if (isValidation && paginationContext.getSortName().getName().equals(sortName.getName()) && paginationContext.getSortType().getName().equals(sortType.getName()))
				{
					return;
				}
				try
				{
					clearRowDatas();
					paginationContext.setSortName(sortName);
					paginationContext.setSortType(sortType);
					sort(sortName, sortType);
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
		);
		
		try
		{
			setPaginationContext(context);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(BorderFactory.createEmptyBorder(3, 1, 1, 1));
		
		initPageInfoPanel();
		initPageButtonPanel();
		initPageIndexDirectPanel();
		initMaxPageRowCountDirectPanel();
		initSortPanel();
		
		add(pageInfoPanel);
		
		add(Box.createHorizontalStrut(10));
		add(Box.createHorizontalGlue());
		
		add(pageButtonPanel);
		
		add(Box.createHorizontalStrut(5));
		
		add(pageIndexDirectPanel);
		
		add(Box.createHorizontalStrut(10));
		
		add(maxPageRowCountDirectPanel);
		
		add(Box.createHorizontalStrut(10));
		
		add(sortPanel);
	}
	
	private void initPageInfoPanel()
	{
		pageInfoPanel = new JPanel();
		pageInfoPanel.setLayout(new BoxLayout(pageInfoPanel, BoxLayout.X_AXIS));
		
		pageInfoPanel.add(createLabel(SwingLocale.getString("sequence")));
		pageInfoPanel.add(Box.createHorizontalStrut(2));
		pageInfoPanel.add(currentPageIndexLabel);
		pageInfoPanel.add(Box.createHorizontalStrut(2));
		pageInfoPanel.add(createLabel(SwingLocale.getString("page")));
		pageInfoPanel.add(Box.createHorizontalStrut(5));
		
		pageInfoPanel.add(currentPageRowCountLabel);
		pageInfoPanel.add(Box.createHorizontalStrut(2));
		pageInfoPanel.add(createLabel(SwingLocale.getString("item")));
		
		pageInfoPanel.add(Box.createHorizontalStrut(2));
		pageInfoPanel.add(createLabel(IconFactory.getSwingIcon("separator.png")));
		pageInfoPanel.add(Box.createHorizontalStrut(2));
		
		pageInfoPanel.add(createLabel(SwingLocale.getString("total")));
		pageInfoPanel.add(Box.createHorizontalStrut(2));
		pageInfoPanel.add(totalPageCountLabel);
		pageInfoPanel.add(Box.createHorizontalStrut(2));
		pageInfoPanel.add(createLabel(SwingLocale.getString("page")));
		
		pageInfoPanel.add(Box.createHorizontalStrut(5));
		
		pageInfoPanel.add(totalRowCountLabel);
		pageInfoPanel.add(Box.createHorizontalStrut(2));
		pageInfoPanel.add(createLabel(SwingLocale.getString("item")));
		pageInfoPanel.add(Box.createHorizontalStrut(5));
		
		/*pageInfoPanel.add(createLabel(SwingLocale.getString("a_page_has")));
		pageInfoPanel.add(Box.createHorizontalStrut(2));
		pageInfoPanel.add(maxPageRowCountLabel);
		pageInfoPanel.add(Box.createHorizontalStrut(2));
		pageInfoPanel.add(createLabel(SwingLocale.getString("item")));*/
	}
	
	private void initPageButtonPanel()
	{
		pageButtonPanel = new JPanel();
		pageButtonPanel.setLayout(new BoxLayout(pageButtonPanel, BoxLayout.X_AXIS));
		
		pageButtonPanel.add(firstPageButton);
		pageButtonPanel.add(backwardPageButton);
		pageButtonPanel.add(forwardPageButton);
		pageButtonPanel.add(lastPageButton);
		
		ButtonManager.updateUI(pageButtonPanel, new Dimension(22, 22));
	}
	
	private void initPageIndexDirectPanel()
	{
		pageIndexDirectPanel = new JPanel();
		pageIndexDirectPanel.setLayout(new BoxLayout(pageIndexDirectPanel, BoxLayout.X_AXIS));
		
		pageIndexDirectPanel.add(createLabel(SwingLocale.getString("jump")));
		pageIndexDirectPanel.add(Box.createHorizontalStrut(2));
		pageIndexDirectPanel.add(pageIndexDirectTextField);
		pageIndexDirectPanel.add(Box.createHorizontalStrut(2));
		pageIndexDirectPanel.add(createLabel(SwingLocale.getString("page")));
		pageIndexDirectPanel.add(pageIndexDirectButton);
		
		ButtonManager.updateUI(pageIndexDirectPanel, new Dimension(22, 22));
	}
	
	private void initMaxPageRowCountDirectPanel()
	{
		maxPageRowCountDirectPanel = new JPanel();
		maxPageRowCountDirectPanel.setLayout(new BoxLayout(maxPageRowCountDirectPanel, BoxLayout.X_AXIS));
		
		maxPageRowCountDirectPanel.add(createLabel(SwingLocale.getString("a_page_has")));
		maxPageRowCountDirectPanel.add(Box.createHorizontalStrut(2));
		maxPageRowCountDirectPanel.add(maxPageRowCountDirectTextField);
		maxPageRowCountDirectPanel.add(Box.createHorizontalStrut(2));
		maxPageRowCountDirectPanel.add(createLabel(SwingLocale.getString("item")));
		maxPageRowCountDirectPanel.add(maxPageRowCountDirectButton);
		
		ButtonManager.updateUI(maxPageRowCountDirectPanel, new Dimension(22, 22));
	}
	
	private void initSortPanel()
	{
		sortPanel = new JPanel();
		sortPanel.setLayout(new BoxLayout(sortPanel, BoxLayout.X_AXIS));
		
		sortPanel.add(createLabel(SwingLocale.getString("sort")));
		sortPanel.add(Box.createHorizontalStrut(2));
		sortPanel.add(sortNameComboBox);
		sortPanel.add(Box.createHorizontalStrut(5));
		sortPanel.add(sortTypeComboBox);
		sortPanel.add(Box.createHorizontalStrut(2));
		sortPanel.add(submitSortButton);
		
		ButtonManager.updateUI(sortPanel, new Dimension(22, 22));
	}
	
	private JLabel createLabel(String text)
	{
		JLabel label = new JLabel(text);
		label.setUI(new BasicLabelUI());
		
		return label;
	}
	
	private JLabel createLabel(Icon icon)
	{
		JLabel label = new JLabel(icon);
		label.setUI(new BasicLabelUI());
		
		return label;
	}
	
	public void setSortNameComboBoxWidth(int width)
	{
		DimensionManager.setDimension(sortNameComboBox, new Dimension(width, 22));
	}
	
	public void setSortNameComboBoxPopupWidth(int width)
	{
		sortNameComboBox.setPopupMenuWidth(width);
	}
	
	public void setSortTypeComboBoxWidth(int width)
	{
		DimensionManager.setDimension(sortTypeComboBox, new Dimension(width, 22));
	}
	
	public void setSortTypeComboBoxPopupWidth(int width)
	{
		sortTypeComboBox.setPopupMenuWidth(width);
	}
	
	public void setPageIndexDirectTextFieldWidth(int width)
	{
		DimensionManager.setDimension(pageIndexDirectTextField, new Dimension(width, 22));
	}
	
	public void setMaxPageRowCountDirectTextFieldWidth(int width)
	{
		DimensionManager.setDimension(maxPageRowCountDirectTextField, new Dimension(width, 22));
	}
	
	private void setCurrentPageIndex(int currentPageIndex)
	{
		if (currentPageIndex < 1)
		{
			throw new IllegalArgumentException(SwingLocale.getString("page_index_not_less_than_1"));
		}
		currentPageIndexLabel.setText(currentPageIndex + "");
	}
	
	private void setCurrentPageRowCount(int currentPageRowCount)
	{
		if (currentPageRowCount < 0)
		{
			throw new IllegalArgumentException(SwingLocale.getString("current_item_count_not_less_than_0"));
		}
		currentPageRowCountLabel.setText(currentPageRowCount + "");
	}
	
	private void setTotalPageCount(int totalPageCount)
	{
		if (totalPageCount < 1)
		{
			throw new IllegalArgumentException(SwingLocale.getString("page_count_not_less_than_1"));
		}
		totalPageCountLabel.setText(totalPageCount + "");
	}
	
	private void setTotalRowCount(int totalRowCount)
	{
		if (totalRowCount < 0)
		{
			throw new IllegalArgumentException(SwingLocale.getString("total_count_not_less_than_0"));
		}
		totalRowCountLabel.setText(totalRowCount + "");
	}
	
	private void setMaxPageRowCount(int maxPageRowCount)
	{
		if (maxPageRowCount < 0)
		{
			throw new IllegalArgumentException(SwingLocale.getString("a_page_item_count_not_less_than_0"));
		}
		maxPageRowCountLabel.setText(maxPageRowCount + "");
	}
	
	public void setSortNameList(List sortNameList)
	{
		sortNameComboBox.setModel(new DefaultComboBoxModel(sortNameList.toArray()));
	}
	
	private void setSortName(ElementNode sortName)
	{
		sortNameComboBox.setSelectedItem(sortName);
	}
	
	public void setSortTypeList(List sortTypeList)
	{
		sortTypeComboBox.setModel(new DefaultComboBoxModel(sortTypeList.toArray()));
	}
	
	private void setSortType(ElementNode sortType)
	{
		sortTypeComboBox.setSelectedItem(sortType);
	}
	
	public boolean isAscending(ElementNode sortType)
	{
		return sortType.getName().equals("asc");
	}
	
	private void setPageIndexDirect(int pageIndexDirect)
	{
		if (pageIndexDirect < 1)
		{
			throw new IllegalArgumentException(SwingLocale.getString("page_index_not_less_than_1"));
		}
		pageIndexDirectTextField.setText(pageIndexDirect + "");
	}
	
	private void setMaxPageRowCountDirect(int maxPageRowCountDirect)
	{
		if (maxPageRowCountDirect < 1)
		{
			return;
		}
		maxPageRowCountDirectTextField.setText(maxPageRowCountDirect + "");
	}
	
	public JNumberTextField getPageIndexDirectTextField()
	{
		return pageIndexDirectTextField;
	}
	
	public JNumberTextField getMaxPageRowCountDirectTextField()
	{
		return maxPageRowCountDirectTextField;
	}
	
	public JBasicComboBox getSortNameComboBox()
	{
		return sortNameComboBox;
	}
	
	public JBasicComboBox getSortTypeComboBox()
	{
		return sortTypeComboBox;
	}
	
	public JTable getTable()
	{
		return table;
	}
	
	public void setTable(JTable table)
	{
		this.table = table;
	}
	
	public JList getList()
	{
		return list;
	}
	
	public void setList(JList list)
	{
		this.list = list;
	}
	
	public JPanel getPageInfoPanel()
	{
		return pageInfoPanel;
	}
	
	public JPanel getPageButtonPanel()
	{
		return pageButtonPanel;
	}
	
	public JPanel getPageIndexDirectPanel()
	{
		return pageIndexDirectPanel;
	}
	
	public JPanel getMaxPageRowCountDirectPanel()
	{
		return maxPageRowCountDirectPanel;
	}
	
	public JPanel getSortPanel()
	{
		return sortPanel;
	}
	
	public PaginationContext getPaginationContext()
	{
		return paginationContext;
	}
	
	public void setPaginationContext(PaginationContext paginationContext)
		throws Exception
	{
		if (paginationContext != null)
		{
			this.paginationContext = paginationContext;
			
			updatePagination();
			
			clearRowDatas();
		}
	}
	
	public void updatePagination()
	{
		setCurrentPageIndex(paginationContext.getCurrentPageIndex());
		setCurrentPageRowCount(paginationContext.getCurrentPageRowCount());
		setTotalPageCount(paginationContext.getTotalPageCount());
		setTotalRowCount(paginationContext.getTotalRowCount());
		setMaxPageRowCount(paginationContext.getRowCount());
		setPageIndexDirect(paginationContext.getCurrentPageIndex());
		setMaxPageRowCountDirect(paginationContext.getRowCount());
		if (paginationContext.getSortName() != null)
		{
			setSortName(paginationContext.getSortName());
		}
		else
		{
			if (sortNameComboBox.getItemCount() != 0)
			{	
				paginationContext.setSortName((ElementNode) sortNameComboBox.getItemAt(0));
			}
		}
		if (paginationContext.getSortType() != null)
		{
			setSortType(paginationContext.getSortType());
		}
		else
		{
			if (sortTypeComboBox.getItemCount() != 0)
			{	
				paginationContext.setSortType((ElementNode) sortTypeComboBox.getItemAt(0));
			}
		}
	}
	
	public void setPaginationEnabled(boolean enabled)
	{
		firstPageButton.setEnabled(enabled);
		backwardPageButton.setEnabled(enabled);
		forwardPageButton.setEnabled(enabled);
		lastPageButton.setEnabled(enabled);
		
		pageIndexDirectTextField.setEnabled(enabled);
		pageIndexDirectButton.setEnabled(enabled);
		
		maxPageRowCountDirectTextField.setEnabled(enabled);
		maxPageRowCountDirectButton.setEnabled(enabled);
		
		sortNameComboBox.setEnabled(enabled);
		sortTypeComboBox.setEnabled(enabled);
		submitSortButton.setEnabled(enabled);
	}
	
	public abstract void directRowIndex(int rowIndex)
		throws Exception;
	
	public abstract void directRowCount(int rowCount)
		throws Exception;
	
	public abstract void sort(ElementNode sortName, ElementNode sortType)
		throws Exception;
	
	public abstract void clearRowDatas()
		throws Exception;
}