package com.herotculb.qunhaichat.homeactiviti.goods.query.updateprice;

import java.util.List;
import java.util.Map;

import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class UpdateGoodsPriceThread extends Thread{
	private Context context;
	private Handler handler;
	private String id,newprice;
	public UpdateGoodsPriceThread(Context context,Handler handler,String id,String newprice){
		this.id=id;
		this.newprice=newprice;
		this.handler=handler;
		this.context=context;
	}
	@Override
	public void run() {
		Looper.prepare();
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.updatePrice(id,newprice);
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
