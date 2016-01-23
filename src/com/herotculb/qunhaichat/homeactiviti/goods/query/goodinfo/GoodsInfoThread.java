package com.herotculb.qunhaichat.homeactiviti.goods.query.goodinfo;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class GoodsInfoThread extends Thread{
	private Context context;
	private Handler handler;
	private String id;
	private String nowpage;
	private String countNum;
	public GoodsInfoThread(Context context,Handler handler,String id,String nowpage,String countNum) {
		super();
		this.context = context;
		this.handler = handler;
		this.id=id;
		this.nowpage=nowpage;
		this.countNum=countNum;
	}
	@Override
	public void run() {
		Looper.prepare();
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.queryGoodsLog(id, nowpage, countNum);
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
