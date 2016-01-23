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
public class LookUpPermissionMainThread extends Thread {
	private Activity context;
	private String groupId;
	private String name;
	private String id;
	private Handler handler;
	
	public LookUpPermissionMainThread(Activity context, String groupId,
			String name, String id, Handler handler) {
		super();
		this.context = context;
		this.groupId = groupId;
		this.name = name;
		this.id = id;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list = null;
		if(id.equals("")){
			list=qnpAPi.lookupPremissionMain(groupId, name);
		}else{
			list=qnpAPi.lookupPremissionMain(groupId, name, id);
		}
		
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
