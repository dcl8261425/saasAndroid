package com.herotculb.qunhaichat.group;

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
public class GetAllGroupThread extends Thread {
	private Activity context;
	private String nowpage;
	private String countNum;
	private String groupId;
	private String groupName;
	private Handler handler;
	
	public GetAllGroupThread(Activity context, String nowpage, String countNum,
			String groupId, String groupName, Handler handler) {
		super();
		this.context = context;
		this.nowpage = nowpage;
		this.countNum = countNum;
		this.groupId = groupId;
		this.groupName = groupName;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		if(groupId==null){
			groupId = "0";
		}
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.getAllGroup(nowpage, countNum, groupId, groupName);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
