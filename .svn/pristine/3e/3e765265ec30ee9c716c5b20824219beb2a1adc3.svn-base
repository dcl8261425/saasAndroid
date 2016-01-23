package com.herotculb.qunhaichat.weixin.getgame;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.herotculb.qunhaichat.util.QNPermissionApiImpl;
/**
 * 微信游戏活动权限 的 Thread 同 主程序的交互
 * @author Administrator
 *
 */
public class WeixinGetAwardsThread extends Thread {
	private Context context;
	private Handler handler;
	public WeixinGetAwardsThread(Context context, Handler handler) {
		super();
		this.context = context;
		this.handler = handler;
	}
	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list= qnpAPi.getAwards();
		Map<String,Object> map=list.iterator().next();
		boolean b=(Boolean) map.get("success");
		if(b){
			map.put("success", b);
			map.put("data", map.get("data"));
			//获取数据成功
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
