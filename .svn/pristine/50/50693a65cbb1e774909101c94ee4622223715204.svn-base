package com.herotculb.qunhaichat.homeactiviti.weixin.goods;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class WeiXinGoodsUpDownThread extends Thread{
	private Context context;
	private Handler handler;
	private String id;
	private String b2;
	public WeiXinGoodsUpDownThread(Context context,Handler handler,String id,String b2) {
		super();
		this.context = context;
		this.handler = handler;
		this.id=id;
		this.b2=b2;
		
	}
	@Override
	public void run() {
		Looper.prepare();
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=null;
		Log.e("------===", b2);
		if(Boolean.parseBoolean(b2)){
			list=qnpAPi.xiajia(id);
			Log.e("-----", "进入下架");
		}else{
			list=qnpAPi.shangjia(id);
			Log.e("-----", "进入上架");
		}
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
