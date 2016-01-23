package com.herotculb.qunhaichat.weixin.getres;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

/**
 * 资源权限的Thread 和 主程序的通讯
 * @author Administrator
 *
 */
public class WeixinResourceVideoThread extends Thread {
	private Context context;
	private Handler handler;
	public WeixinResourceVideoThread(Context context, Handler handler) {
		super();
		this.context = context;
		this.handler = handler;
	}
	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.getVideo();
		Map<String,Object> map=list.iterator().next();
		boolean b=(Boolean) map.get("success");
		String info=(String) map.get("info");
		if(b){
			Intent mainIntent = new Intent().setClass(context, HomeActivity.class);
			context.startActivity(mainIntent);
			SharedPreferences mySharedPreferences = context.getSharedPreferences("usermessage", 
					Activity.MODE_PRIVATE); 
		}else{
			//获取数据失败
			Message sendmsg = Message.obtain();  
            sendmsg.obj = list;   //利用Message.obj把子线程的handle传递给主线程。  
            handler.sendMessage(sendmsg);  
		}
	}
	
}
