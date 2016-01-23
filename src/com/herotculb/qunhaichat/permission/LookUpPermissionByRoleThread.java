package com.herotculb.qunhaichat.permission;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

/**
 * 获得组数据
 * @author Administrator
 *
 */
public class LookUpPermissionByRoleThread extends Thread {
	private Activity context;
	private String name;
	private String groupId;
	private String roleId;
	private Handler handler;
	
	public LookUpPermissionByRoleThread(Activity context, String name,
			String groupId, String roleId, Handler handler) {
		super();
		this.context = context;
		this.name = name;
		this.groupId = groupId;
		this.roleId = roleId;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.lookupPremissionByRole(name, groupId, roleId);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
