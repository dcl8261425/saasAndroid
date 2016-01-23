package com.herotculb.qunhaichat.homeactiviti.weixin.goods;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class WeiXinGoodsThread extends Thread{
	private Context context;
	private Handler handler;
	private String b;
	private String name;
	private String nowpage;
	private String countNum;
	public WeiXinGoodsThread(Context context,Handler handler,String b,String name,String nowpage,String countNum) {
		super();
		this.context = context;
		this.handler = handler;
		this.b=b;
		this.name=name;
		this.nowpage=nowpage;
		this.countNum=countNum;
	}
	@Override
	public void run() {
		Looper.prepare();
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.queryGood(name, b, nowpage, countNum);
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
