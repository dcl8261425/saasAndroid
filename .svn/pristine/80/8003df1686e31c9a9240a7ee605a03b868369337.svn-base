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
public class WeixinGetGuaGuaKaThread extends Thread {
	private Context context;
	private Handler handler;
	public WeixinGetGuaGuaKaThread(Context context, Handler handler) {
		super();
		this.context = context;
		this.handler = handler;
	}
	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list= qnpAPi.getguaguaka();
		Map<String,Object> map=list.iterator().next();
		map.put("data", map.get("data"));
		map.put("use", map.get("use"));
		map.put("jilv", map.get("jilv"));
		map.put("num", map.get("num"));
		map.put("score", map.get("score"));
		map.put("scoreNum", map.get("scoreNum"));
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg); 
	}
	
}
