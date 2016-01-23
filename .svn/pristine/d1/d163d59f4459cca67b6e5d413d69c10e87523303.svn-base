package com.herotculb.qunhaichat.weixin.approval;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

/**
 * 会员管理的 Thread 与主程序的通讯
 * @author Administrator
 *
 */
public class GetImageThread extends Thread {
	private Context context;
	private String nowpage;
	private String countNum;
	private String type;
	private Handler handler;
	
	public GetImageThread(Context context, String nowpage, String countNum,
			String type, Handler handler) {
		super();
		this.context = context;
		this.nowpage = nowpage;
		this.countNum = countNum;
		this.type = type;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		String id = "略";
		if(type == null){
			type = "略";
		}
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.getImages(nowpage);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
