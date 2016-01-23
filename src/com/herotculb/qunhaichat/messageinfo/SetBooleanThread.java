package com.herotculb.qunhaichat.messageinfo;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class SetBooleanThread extends Thread {
	private Activity context;
	private String value;
	private String type;	
	private Handler handler;
		
	public SetBooleanThread(Activity context, String value, String type,
			Handler handler) {
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
		
		if(value.equals("true")){
			value = "false";
		}else{
			value = "true";
		}
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list= qnpAPi.setboolean(value, type);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg); 
	}
	
}
