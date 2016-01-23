package com.herotculb.qunhaichat.homeactiviti.weixin.wifi;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class LookWifiThread extends Thread{
	private Context context;
	private String name;
	private Handler handler;
	private String nowpage;
	private String countNum;
	private String id;
	public LookWifiThread(Context context,String id,String nowpage,String countNum,Handler handler) {
		super();
		this.context = context;
		this.name = name;
		this.handler = handler;
		this.countNum=countNum;
		this.nowpage=nowpage;
		this.id=id;
	}
	@Override
	public void run() {
		Looper.prepare();
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.lookLinkDevice(nowpage,countNum,id);
		Map<String,Object> map=list.iterator().next();
		boolean b=(Boolean) map.get("success");
		if(b){
			Message sendmsg = Message.obtain();  
            sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
            handler.sendMessage(sendmsg); 
		}else{
			//获取数据失败
			Message sendmsg = Message.obtain();  
            sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
            handler.sendMessage(sendmsg);  
		}
	}
}
