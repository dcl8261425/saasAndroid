package com.herotculb.qunhaichat.crm.querychance;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class DeleteMyCreateChanceThread extends Thread {
	private Activity context;
	private String chanceId;
	private Handler handler;
	
	public DeleteMyCreateChanceThread(Activity context, String chanceId,
			Handler handler) {
		super();
		this.context = context;
		this.chanceId = chanceId;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.DeleteMyCreateChance(chanceId);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
