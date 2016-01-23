package com.herotculb.qunhaichat.weixin.operationvip;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class WeixinJianPriceUserThread extends Thread {
	private Activity context;
	private Handler handler;
	
	public WeixinJianPriceUserThread(Activity context, Handler handler) {
		super();
		this.context = context;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		BootstrapEditText idtext =(BootstrapEditText) context.findViewById(R.id.weixin_jian_money_id);
		BootstrapEditText moneytext =(BootstrapEditText) context.findViewById(R.id.weixin_jian_money_name);
		
		String id = idtext.getText().toString();
		String money = moneytext.getText().toString();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.jianpriceToUser(id, money);
		Map<String,Object> map=list.iterator().next();
		
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
