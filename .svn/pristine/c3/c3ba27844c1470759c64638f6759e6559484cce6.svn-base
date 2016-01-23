package com.herotculb.qunhaichat.permission.operation;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.permission.window.AddRoleWindow;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class AddPermissionToRoleThread extends Thread {
	private Activity context;
	private String isAll;
	private String permissionId;
	private String roleId;
	private Handler handler;
	
	public AddPermissionToRoleThread(Activity context, String isAll,
			String permissionId, String roleId, Handler handler) {
		super();
		this.context = context;
		this.isAll = isAll;
		this.permissionId = permissionId;
		this.roleId = roleId;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.addPermissionToRole(isAll, permissionId, roleId);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
