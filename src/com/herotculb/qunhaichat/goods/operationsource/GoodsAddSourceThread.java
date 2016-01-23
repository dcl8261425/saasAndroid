package com.herotculb.qunhaichat.goods.operationsource;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class GoodsAddSourceThread extends Thread {
	private Activity context;
	private Handler handler;
	
	public GoodsAddSourceThread(Activity context, Handler handler) {
		super();
		this.context = context;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		BootstrapEditText nametext =(BootstrapEditText) context.findViewById(R.id.goods_source_name);
		BootstrapEditText addresstext =(BootstrapEditText) context.findViewById(R.id.goods_source_address);
		
		String name = nametext.getText().toString();
		String address = addresstext.getText().toString();
		Log.e("add--", "success");
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.addGoodSource(name, address);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
