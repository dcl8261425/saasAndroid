package com.herotculb.qunhaichat.crm.querychance;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.crm.querychance.window.CustomerLevelWindow;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class AllocationMyCreateChanceThread extends Thread {
	private Activity context;
	private Handler handler;
	
	public AllocationMyCreateChanceThread(Activity context, Handler handler) {
		super();
		this.context = context;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		BootstrapEditText idtext =(BootstrapEditText) context.findViewById(R.id.create_chance_id);
		BootstrapEditText useridtext =(BootstrapEditText) context.findViewById(R.id.create_chance_userid);
		
		String ChanceId = idtext.getText().toString();
		String NotesUserId= useridtext.getText().toString();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.allocationMyCreateChance(NotesUserId, ChanceId);
		
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
