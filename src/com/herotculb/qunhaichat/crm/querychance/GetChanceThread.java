package com.herotculb.qunhaichat.crm.querychance;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

/**
 * 获得单个仓库 Thread 与主程序的通讯
 * @author Administrator
 *
 */
public class GetChanceThread extends Thread {
	private Context context;
	private String ChanceName;
	private Handler handler;
	
	public GetChanceThread(Context context, String ChanceName, Handler handler) {
		super();
		this.context = context;
		this.ChanceName = ChanceName;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
				
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.getChance(ChanceName);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
