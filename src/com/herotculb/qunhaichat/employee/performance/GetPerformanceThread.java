package com.herotculb.qunhaichat.employee.performance;

import java.util.Date;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.herotculb.qunhaichat.util.DateUtil;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

/**
 * 获得单个仓库 Thread 与主程序的通讯
 * @author Administrator
 *
 */
public class GetPerformanceThread extends Thread {
	private Activity context;
	private String startDate;
	private String endDate;
	private Handler handler;
	
	public GetPerformanceThread(Activity context, String startDate,
			String endDate, Handler handler) {
		super();
		this.context = context;
		this.startDate = startDate;
		this.endDate = endDate;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
				
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.getPerForMance(startDate, endDate);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
