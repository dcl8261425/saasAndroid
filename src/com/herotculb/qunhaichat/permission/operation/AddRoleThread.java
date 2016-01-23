package com.herotculb.qunhaichat.permission.operation;

import java.util.List;
import java.util.Map;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.permission.window.AddRoleWindow;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class AddRoleThread extends Thread {
	private AddRoleWindow context;
	private String groupId;
	private Handler handler;
	
	public AddRoleThread(AddRoleWindow context, String groupId, Handler handler) {
		super();
		this.context = context;
		this.groupId = groupId;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		BootstrapEditText nametext =(BootstrapEditText) context.findViewById(R.id.permission_role_name);
		BootstrapEditText markstext =(BootstrapEditText) context.findViewById(R.id.permission_role_marks);
		
//		String groupId = "1";
		String name = nametext.getText().toString();
		String marks = markstext.getText().toString();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.addRole(name, marks, groupId);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
