package com.herotculb.qunhaichat.weixin.getvip;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

/**
 * 会员管理的 Thread 与主程序的通讯
 * @author Administrator
 *
 */
public class WeixinGetDuiHuanThread extends Thread {
	private Context context;
	private String id;
	private Handler handler;
	
	public WeixinGetDuiHuanThread(Context context, String id, Handler handler) {
		super();
		this.context = context;
		this.id = id;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.getScoreDuiHuan(id);
		Map<String,Object> map=list.iterator().next();
		boolean b=(Boolean) map.get("success");
		String info=(String) map.get("info");
		if(b){
			
		}else{
			//获取数据失败
			Message sendmsg = Message.obtain();  
            sendmsg.obj = list;   //利用Message.obj把子线程的handle传递给主线程。  
            handler.sendMessage(sendmsg);  
		}
	}
	
}
