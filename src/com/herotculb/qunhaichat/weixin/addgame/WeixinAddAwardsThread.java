package com.herotculb.qunhaichat.weixin.addgame;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class WeixinAddAwardsThread extends Thread {
	private Activity context;
	private Handler handler;
	
	public WeixinAddAwardsThread(Activity context, Handler handler) {
		super();
		this.context = context;
		this.handler = handler;
	}
	
	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		BootstrapEditText markstext=(BootstrapEditText) context.findViewById(R.id.weixin_add_awards_marks);
		BootstrapEditText contenttext=(BootstrapEditText) context.findViewById(R.id.weixin_add_awards_content);
		
		String content = contenttext.getText().toString();
		String marks=markstext.getText().toString();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list= qnpAPi.addAwards(content, marks);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg); 
	}
	
}
