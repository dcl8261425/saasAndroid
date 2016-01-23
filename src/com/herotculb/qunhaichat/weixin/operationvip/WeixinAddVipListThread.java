package com.herotculb.qunhaichat.weixin.operationvip;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class WeixinAddVipListThread extends Thread {
	private Activity context;
	private Handler handler;
		
	public WeixinAddVipListThread(Activity context, Handler handler) {
		super();
		this.context = context;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		BootstrapEditText markstext=(BootstrapEditText) context.findViewById(R.id.weixin_create_class_marks);
		BootstrapEditText scoretext=(BootstrapEditText) context.findViewById(R.id.weixin_create_class_score);
		BootstrapEditText nametext=(BootstrapEditText) context.findViewById(R.id.weixin_create_class_name);
		
		String score=scoretext.getText().toString();
		String name=nametext.getText().toString();
		String marks=markstext.getText().toString();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.addVipList(marks, score, name);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
