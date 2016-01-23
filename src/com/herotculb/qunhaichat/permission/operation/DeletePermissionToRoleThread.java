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

public class DeletePermissionToRoleThread extends Thread {
	private Activity context;
	private String permissionId;
	private String roleId;	
	private Handler handler;
	
	public DeletePermissionToRoleThread(Activity context, String permissionId,
			String roleId, Handler handler) {
		super();
		this.context = context;
		this.permissionId = permissionId;
		this.roleId = roleId;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.deletePermissionToRole(permissionId, roleId);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
