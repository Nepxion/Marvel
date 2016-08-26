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

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import com.nepxion.swing.action.JSecurityAction;

public class TGraphKeyboardRegister
{
	public static void registerZoomIn(TGraph graph, JSecurityAction action)
	{
		graph.registerKeyboardAction(action, KeyEvent.VK_PLUS, InputEvent.CTRL_MASK);
	}
	
	public static void registerZoomOut(TGraph graph, JSecurityAction action)
	{
		graph.registerKeyboardAction(action, KeyEvent.VK_MINUS, InputEvent.CTRL_MASK);
	}
	
	public static void registerZoomReset(TGraph graph, JSecurityAction action)
	{
		graph.registerKeyboardAction(action, KeyEvent.VK_O, InputEvent.CTRL_MASK);
	}
	
	public static void registerZoomToOverview(TGraph graph, JSecurityAction action)
	{
		graph.registerKeyboardAction(action, KeyEvent.VK_R, InputEvent.CTRL_MASK);
	}
	
	public static void registerZoomBack(TGraph graph, JSecurityAction action)
	{
		graph.registerKeyboardAction(action, KeyEvent.VK_BACK_SPACE, 0);
	}
	
	public static void registerFullScreen(TGraph graph, JSecurityAction action)
	{
		graph.registerKeyboardAction(action, KeyEvent.VK_F10, 0);
	}
	
	public static void registerNew(TGraph graph, JSecurityAction action)
	{
		graph.registerKeyboardAction(action, KeyEvent.VK_N, InputEvent.CTRL_MASK);
	}
	
	public static void registerDelete(TGraph graph, JSecurityAction action)
	{
		graph.registerKeyboardAction(action, KeyEvent.VK_DELETE, 0);
	}
	
	public static void registerSave(TGraph graph, JSecurityAction action)
	{
		graph.registerKeyboardAction(action, KeyEvent.VK_S, InputEvent.CTRL_MASK);
	}
	
	public static void registerRefresh(TGraph graph, JSecurityAction action)
	{
		graph.registerKeyboardAction(action, KeyEvent.VK_F5, 0);
	}
	
	public static void registerCopy(TGraph graph, JSecurityAction action)
	{
		graph.registerKeyboardAction(action, KeyEvent.VK_C, InputEvent.CTRL_MASK);
	}
	
	public static void registerPaste(TGraph graph, JSecurityAction action)
	{
		graph.registerKeyboardAction(action, KeyEvent.VK_V, InputEvent.CTRL_MASK);
	}
	
	public static void registerSelectAll(TGraph graph, JSecurityAction action)
	{
		graph.registerKeyboardAction(action, KeyEvent.VK_A, InputEvent.CTRL_MASK);
	}
	
	public static void registerUndo(TGraph graph, JSecurityAction action)
	{
		graph.registerKeyboardAction(action, KeyEvent.VK_Z, InputEvent.CTRL_MASK);
	}
	
	public static void registerRedo(TGraph graph, JSecurityAction action)
	{
		graph.registerKeyboardAction(action, KeyEvent.VK_Y, InputEvent.CTRL_MASK);
	}
	
	public static void registerImport(TGraph graph, JSecurityAction action)
	{
		graph.registerKeyboardAction(action, KeyEvent.VK_M, InputEvent.CTRL_MASK);
	}
	
    public static void registerShowControlBar(TGraph graph, JSecurityAction action)
    {
        graph.registerKeyboardAction(action, KeyEvent.VK_F3, 0);
    }
    
    public static void registerHideControlBar(TGraph graph, JSecurityAction action)
    {
        graph.registerKeyboardAction(action, KeyEvent.VK_F4, 0);
    }    
}