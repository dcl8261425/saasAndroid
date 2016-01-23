package com.herotculb.qunhaichat.crm;

import java.util.List;
import java.util.Map;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.herotculb.qunhaichat.crm.querychance.window.QueryNotesWindow;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class StartNotesThread extends Thread {
	private QueryNotesWindow context;
	private String chanceId;
	private Handler handler;
	
	public StartNotesThread(QueryNotesWindow context, String chanceId,
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
		List<Map<String, Object>> list=qnpAPi.startNotes(chanceId);
		
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
