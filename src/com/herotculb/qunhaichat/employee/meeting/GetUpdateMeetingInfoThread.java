package com.herotculb.qunhaichat.employee.meeting;

import java.util.Date;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.util.DateUtil;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

/**
 * 获得签到信息 Thread 与主程序的通讯
 * @author Administrator
 *
 */
public class GetUpdateMeetingInfoThread extends Thread {
	private Activity context;
	private String type;
	private String value;
	private String id;
	private Handler handler;
	
	public GetUpdateMeetingInfoThread(Activity context, String type,
			String value, String id, Handler handler) {
		super();
		this.context = context;
		this.type = type;
		this.value = value;
		this.id = id;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.getUpdateMeetingInfo(type, value, id);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
