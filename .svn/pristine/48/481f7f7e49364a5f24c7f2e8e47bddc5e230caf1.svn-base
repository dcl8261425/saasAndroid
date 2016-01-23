package com.herotculb.qunhaichat.homeactiviti.weixin.duihuan.thread;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

/**
 * 获取自动回复列表 的 Thread 同主程序进行通讯
 * @author Administrator
 *
 */
public class jifenThread extends Thread {
	private Context context;
	private Handler handler;
	private String num;
	public jifenThread(Context context, Handler handler,String num) {
		super();
		this.context = context;
		this.handler = handler;
		this.num=num;
	}
	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.jifenTogoodManager(num);
		Map<String,Object> map=list.iterator().next();
		boolean b=(Boolean) map.get("success");
		if(b){
			Message sendmsg = Message.obtain();  
            sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
            handler.sendMessage(sendmsg);  
		}else{
			//获取数据失败
			Message sendmsg = Message.obtain();  
            sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
            handler.sendMessage(sendmsg);  
		}
	}
	
}
