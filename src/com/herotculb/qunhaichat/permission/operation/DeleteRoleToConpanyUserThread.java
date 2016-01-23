package com.herotculb.qunhaichat.permission.operation;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.permission.window.AddRoleWindow;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class DeleteRoleToConpanyUserThread extends Thread {
	private Activity context;
	private String roleId;
	private String groupId;
	private String userId;
	private Handler handler;
	
	public DeleteRoleToConpanyUserThread(Activity context, String roleId,
			String groupId, String userId, Handler handler) {
		super();
		this.context = context;
		this.roleId = roleId;
		this.groupId = groupId;
		this.userId = userId;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.deleteRoleToConpanyUser(roleId, groupId, userId);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
