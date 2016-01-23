package com.herotculb.qunhaichat.employee.manager;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.goods.store.window.GoodsAddStoreHouseWindow;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class UpdateCustomerInfoThread extends Thread {
	private Activity context;
	private String id;
	private String name;
	private String value;
	private Handler handler;
	
	public UpdateCustomerInfoThread(Activity context, String id, String name,
			String value, Handler handler) {
		super();
		this.context = context;
		this.id = id;
		this.name = name;
		this.value = value;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.updateCustemmerInfo(id, name, value);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
