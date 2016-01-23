package com.herotculb.qunhaichat.weixin.info;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

/**
 * 设置微信账户的信息 的Thread 和主程序进行通讯
 * @author Administrator
 *
 */
public class WeixinMenuInfoThread extends Thread {
	private Context context;
	private Handler handler;
	public WeixinMenuInfoThread(Context context, Handler handler) {
		super();
		this.context = context;
		this.handler = handler;
	}
	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.getWeXinInfo();
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
