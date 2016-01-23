package com.herotculb.qunhaichat.weixin.operationgame;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class WeixinUpdateGameGuaGuaKaThread extends Thread {
	private Context context;
	private String value;
	private String type;	
	private Handler handler;
	
	public WeixinUpdateGameGuaGuaKaThread(Context context, String value,
			String type, Handler handler) {
		super();
		this.context = context;
		this.value = value;
		this.type = type;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		if(type.equals("use")){
			type = "1";
		}else if(type.equals("score")){
			type = "2";
		}
		if(value.equals("true")){
			value = "false";
		}else if(value.equals("false")){
			value = "true";
		}
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list= qnpAPi.updateGameguaguaka(value, type);
		Map<String,Object> map=list.iterator().next();
		//获取数据成功
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg); 
	}
	
}
