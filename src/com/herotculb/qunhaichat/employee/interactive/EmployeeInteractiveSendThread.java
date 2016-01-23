package com.herotculb.qunhaichat.employee.interactive;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

/**
 * 获得单个仓库 Thread 与主程序的通讯
 * @author Administrator
 *
 */
public class EmployeeInteractiveSendThread extends Thread {
	private Activity context;
	private String groupId;
	private Handler handler;
	BootstrapEditText titleText;
	BootstrapEditText contentText;
	
	public EmployeeInteractiveSendThread(Activity context, String groupId,
			 Handler handler) {
		super();
		this.context = context;
		this.groupId = groupId;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
				
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		
		titleText = (BootstrapEditText)context.findViewById(R.id.send_title);
		contentText = (BootstrapEditText)context.findViewById(R.id.send_content);
		
		String title = titleText.getText().toString();
		String content = contentText.getText().toString();
		String file = "略";
		String img = "略";
		String video = "略";
		String toupiao = "略";
		String toupiao_title = "略";
		String toupiao_start = "略";
		String toupiao_end = "略";
		String toupiao_move = "略";
		
		List<Map<String, Object>> list=qnpAPi.sendKongJianManager(groupId, title, content, file, img, video,
				toupiao, toupiao_title, toupiao_start, toupiao_end, toupiao_move);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
