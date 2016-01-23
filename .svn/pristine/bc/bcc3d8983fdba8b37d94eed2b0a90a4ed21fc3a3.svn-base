package com.herotculb.qunhaichat.employee.interactive;

import java.util.Date;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.herotculb.qunhaichat.util.DateUtil;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

/**
 * 获得单个仓库 Thread 与主程序的通讯
 * @author Administrator
 *
 */
public class GetHuDongKongJianThread extends Thread {
	private Activity context;
	private String groupId;
	private String nowpage;
	private String countNum;
	private Handler handler;
	
	public GetHuDongKongJianThread(Activity context, String groupId,
			String nowpage,String countNum, Handler handler) {
		super();
		this.context = context;
		this.groupId = groupId;
		this.nowpage = nowpage;
		this.countNum = countNum;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
				
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		
		List<Map<String, Object>> list=qnpAPi.getHuDongKongJian(groupId, nowpage, countNum);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
