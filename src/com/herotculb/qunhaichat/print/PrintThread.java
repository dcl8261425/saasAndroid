package com.herotculb.qunhaichat.print;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.gprinterio.GpDevice;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;
import com.herotculb.qunhaichat.widget.LoadingDialog;

/**
 * 获得单个仓库 Thread 与主程序的通讯
 * @author Administrator
 *
 */
public class PrintThread extends Thread {
	private Handler handler;
	private LoadingDialog dialog;
	private GpDevice mDevice;
	public PrintThread(   Handler handler,GpDevice mDevice) {
		super();
		this.mDevice=mDevice;
		this.handler=handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		while(true){
			 if(mDevice.isDeviceOpen()){
				 	Map<String,Object> map=new HashMap<String, Object>();
				 	Message sendmsg = Message.obtain();  
		            sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
		            handler.sendMessage(sendmsg);  
				 break;
			 }
		 }
		
	}
	
}
