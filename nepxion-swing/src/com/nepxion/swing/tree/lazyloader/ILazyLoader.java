package com.nepxion.swing.tree.lazyloader;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

public interface ILazyLoader
{
	public void loadForeground(Object data, JLazyLoaderTreeNode lazyLoaderTreeNode) // װ��ǰ�����ݣ�����������
		throws Exception;
	
	public Object loadBackground(JLazyLoaderTreeNode lazyLoaderTreeNode) // װ�غ�����ݣ������ȡ���ݿ�
		throws Exception;
		
	public boolean isLoaded(JLazyLoaderTreeNode lazyLoaderTreeNode); // �ж��Ƿ��Ѿ�װ�ع�
	
	public boolean isLoading(JLazyLoaderTreeNode lazyLoaderTreeNode); // �ж��Ƿ�����װ��
	
	public boolean isLeaf(JLazyLoaderTreeNode lazyLoaderTreeNode); // �ж��Ƿ��װ��
	
	public boolean isSynchronized(); // �ж��Ƿ�Ϊͬ��װ��ģʽ
	
	public void setSynchronized(boolean isSynchronized); // �����Ƿ�Ϊͬ��װ��ģʽ
	
	public boolean isRecursive(); // �ж��Ƿ�Ϊ�ݹ�װ��
	
	public void setRecursive(boolean isRecursive); // �����Ƿ�Ϊ�ݹ�װ��
	
	public int getRecursionDepth(); // ��õݹ����
	
	public void setRecursionDepth(int recursionDepth); // ���õݹ����
	
	public SearchDescription getSearchDescription(); // ������������Ķ���
	
	public void setSearchDescription(SearchDescription searchDescription); // ������������Ķ���
}