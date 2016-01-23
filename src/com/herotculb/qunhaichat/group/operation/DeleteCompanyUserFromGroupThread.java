package com.herotculb.qunhaichat.group.operation;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class DeleteCompanyUserFromGroupThread extends Thread {
	private Activity context;
	private String userId;
	private String groupId;
	private Handler handler;
	
	public DeleteCompanyUserFromGroupThread(Activity context, String userId,
			String groupId, Handler handler) {
		super();
		this.context = context;
		this.userId = userId;
		this.groupId = groupId;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.deleteConpanyUserFormGroup(userId, groupId);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
