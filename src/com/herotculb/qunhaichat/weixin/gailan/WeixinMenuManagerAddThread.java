package com.herotculb.qunhaichat.weixin.gailan;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

/**
 * 管理微信菜单时，用Handler 和主程序进行通讯
 * @author Administrator
 *
 */
public class WeixinMenuManagerAddThread extends Thread {
	private Context context;
	private String id;
	private String name;
	private String url;
	private String key;	
	private Handler handler;
		
	public WeixinMenuManagerAddThread(Context context, String id, String name,
			String url, String key, Handler handler) {
		super();
		this.context = context;
		this.id = id;
		this.name = name;
		this.url = url;
		this.key = key;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.addMenu(id, name, url, key);
		Map<String,Object> map=list.iterator().next();
		boolean b=(Boolean) map.get("success");
		String info=(String) map.get("info");
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
