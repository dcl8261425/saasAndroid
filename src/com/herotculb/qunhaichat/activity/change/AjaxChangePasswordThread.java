package com.herotculb.qunhaichat.activity.change;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class AjaxChangePasswordThread extends Thread {
	private Activity context;
	private Handler handler;
	
	public AjaxChangePasswordThread(Activity context, Handler handler) {
		super();
		this.context = context;
		this.handler = handler;
	}
	
	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		BootstrapEditText oldtext=(BootstrapEditText) context.findViewById(R.id.change_password_old);
		BootstrapEditText newptext=(BootstrapEditText) context.findViewById(R.id.change_password_newp);
		BootstrapEditText renewptext=(BootstrapEditText) context.findViewById(R.id.change_password_renewp);
		
		String old = oldtext.getText().toString();
		String newp=newptext.getText().toString();
		String renewp=newptext.getText().toString();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list= qnpAPi.ajaxchangePassword(old, newp, renewp);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg); 
	}
	
}
