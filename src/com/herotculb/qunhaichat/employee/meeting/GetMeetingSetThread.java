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
public class GetMeetingSetThread extends Thread {
	private Activity context;
	private Handler handler;
	
	public GetMeetingSetThread(Activity context, 
			Handler handler) {
		super();
		this.context = context;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		BootstrapEditText startedit= (BootstrapEditText)
        		context.findViewById(R.id.meeting_set_info_start_date);
		BootstrapEditText endedit= (BootstrapEditText)
				context.findViewById(R.id.meeting_set_info_end_date);
		BootstrapEditText ipedit= (BootstrapEditText)
				context.findViewById(R.id.meeting_set_info_ip);
        
		String ip = ipedit.getText().toString();
		String uptime = startedit.getText().toString();
		String downtime = endedit.getText().toString();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.getMeetingSet(ip, uptime, downtime);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
