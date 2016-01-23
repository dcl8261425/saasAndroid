package com.herotculb.qunhaichat.homeactiviti.goods.ingoods;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.herotculb.qunhaichat.util.DateUtil;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class SubmitOrderThread extends Thread{
	private Context context;
	private Handler handler;
	private String  sql;
	private boolean issave;
	private String id;
	public SubmitOrderThread(Context context,Handler handler,String sql,boolean issave,	 String id){
		this.sql=sql;
		this.handler=handler;
		this.context=context;
		this.issave=issave;
		this.id=id;
	}
	@Override
	public void run() {
		Looper.prepare();
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.createInOrder(DateUtil.formatDateYYYY_MM_DD(new Date()), sql, id, issave?"save":"store");
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
