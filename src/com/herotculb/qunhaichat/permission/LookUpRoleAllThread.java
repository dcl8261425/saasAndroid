package com.herotculb.qunhaichat.permission;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

/**
 * 获得组数据
 * @author Administrator
 *
 */
public class LookUpRoleAllThread extends Thread {
	private Activity context;
	private String groupId;
	private String roleName;
	private Handler handler;
	
	public LookUpRoleAllThread(Activity context, 
			String groupId, String roleName, Handler handler) {
		super();
		this.context = context;
		this.groupId = groupId;
		this.roleName = roleName;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.lookupRoleAll(groupId, roleName);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
